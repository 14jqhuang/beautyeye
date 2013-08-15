/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BEComboBoxUI.java at 2012-9-24 17:21:35, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch14_combox;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

// TODO: Auto-generated Javadoc
/**
 * JComboBox��UIʵ���ࡣ.
 *
 * @author Jack Jiang(jb2011@163.com), 2012-06-30
 * @version 1.0
 */
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� Start
//�����ʵ�ֲο���WindowsComboBoxUI
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� END
public class BEComboBoxUI extends BasicComboBoxUI 
	implements org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.__UseParentPaintSurported
{
    
    /**
     * Creates the ui.
     *
     * @param c the c
     * @return the component ui
     */
    public static ComponentUI createUI(JComponent c) 
    {
//    	//��������ı�
//    	if(NLLookAndFeel.paintFocusedBorder&&NLLookAndFeel.comboxFocusedThikness>=1)
//    		c.addFocusListener(NLLookAndFeel.FocusListenerImpl.getInstance()
//    				.setFocusedThikness(NLLookAndFeel.comboxFocusedThikness));
        return new BEComboBoxUI();
    }  
    
    //* ��������Jack Jiang��2012-09-07�ռ���
    /**
     * �Ƿ�ʹ�ø���Ļ���ʵ�ַ�����true��ʾ��.
     * <p>
     * ��Ϊ��BE LNF�У��߿�ͱ����ȶ���ʹ��N9ͼ��û��ͨ�����ñ���ɫ��ǰ��
     * ɫ������JComboBox����ɫ�ͱ߿򣬱�������Ŀ�ľ��ǵ��û������˽�������border�򱳾�ɫ
     * ʱ��֮��ʵ���಻ʹ��BE LNF��Ĭ�ϵ�N9ͼ�����ƶ����ø����еķ����������еķ���
     * �Ϳ���֧����ɫ�������ޣ�ֻ�ǳ�㣬���ܹ�������Ӧ�û������󳡾�Ҫ����ʵ�û���ȫ����
     * ͨ��JComboBox.setUI(..)��ʽ���Զ���UIŶ��.
     *
     * @return true, if is use parent paint
     */
    public boolean isUseParentPaint()
    {
    	return comboBox != null 
    		&& ( !(comboBox.getBorder() instanceof UIResource)
    				||!(comboBox.getBackground() instanceof UIResource));
    }
    
    //copy from parent and modified by Jack Jiang
    /* (non-Javadoc)
     * @see javax.swing.plaf.basic.BasicComboBoxUI#installUI(javax.swing.JComponent)
     */
    @Override
    public void installUI( JComponent c )
    {
    	super.installUI(c);
    	
    	//2012-08-30*******************************************************����Ҫ˵���� START ��ӦBEListUI�еġ���Ҫ˵����
    	//* ����Ҫ˵������BEListUI��Ϊ��ʹ�б��е�Ԫ�߱�ĸ��ߣ���MyDefaultListCellRenderer.java��
    	//* ��COmboxRenderһ��ͨ������border����Ч������������BasicListUI�����ȱ�ݣ���ҪôȡFixedCellHeight
    	//* �̶�ֵ��ҪôȡgetPreferSize()���Զ�����߶ȡ������ƺ��ǲ�����border�ģ�����render����border����Ч��
    	//* ����ֻ��Ϊ�б�Ԫ������ֵ��list.setFixedCellHeight(30)��������Ӱ��Combox����иߣ�Ҳ����30�ߣ�
    	//* ���Դ˴�Ҫ���б�UI��ǿ���趨��30�����Combox��ԭ���Զ����㣨API�й涨FixedCellHeight==-1����ʾ�Զ����㣩
    	popup.getList().setFixedCellHeight(-1);
    	//**************************************************************** ����Ҫ˵���� END
    	
    	//* ���´�����jb2011����
//    	comboBox.setMaximumRowCount(8);//�������п�����Ч�����ƺ������и�ָ����һ���̶�ֵ�����Ǽ���ֵ����LNF����cell�����и߾ͺܸ�
    								   //��ʹ�����������ʾ�У�������ʾ�Ĳ�����ָ��ֵ���д���һ���о�
    	//Ϊ������ĵ�������border���������¿հ���һ��ÿ�һЩ
    	// install the scrollpane border
        Container parent = popup.getList().getParent();  // should be viewport
        if (parent != null) 
        {
            parent = parent.getParent();  // should be the scrollpane
            if (parent != null && parent instanceof JScrollPane) 
                LookAndFeel.installBorder((JScrollPane)parent, "ComboBox.scrollPaneBorder");//*~ ע�����������Jack Jiang����JTabel���ʵ�����Ѽӵ�����
        }
    }
    
    /**
     * Gets the combox.
     *
     * @return the combox
     */
    public JComboBox getCombox()
    {
    	return this.comboBox;
    }
    
    //copy from BasicComboBoxUI and modified by jb2011
    //�Զ����½ӿ��ͷ��ťʵ����
    /* (non-Javadoc)
     * @see javax.swing.plaf.basic.BasicComboBoxUI#createArrowButton()
     */
    @Override 
    protected JButton createArrowButton() 
    {
    	JButton button = new JButton()
    	{
    		//����������border
    		public void setBorder(Border b){
    		}
    		//�������
    		public void paint(Graphics g){
    			boolean isEnabled = isEnabled();
    			boolean isPressed = getModel().isPressed();
    			if(isEnabled)
    			{
    				if(isPressed)
    					__Icon9Factory__.getInstance().getButtonArrow_pressed()
						.draw((Graphics2D)g, 0, 0, this.getWidth(), this.getHeight());
    				else
    					__Icon9Factory__.getInstance().getButtonArrow_normal()
    						.draw((Graphics2D)g, 0, 0, this.getWidth(), this.getHeight());
    			}
    			else
    			{
    				__Icon9Factory__.getInstance().getButtonArrow_disable()
						.draw((Graphics2D)g, 0, 0, this.getWidth(), this.getHeight());
    			}
    		}
    		// Don't want the button to participate in focus traversable.
    		public boolean isFocusTraversable(){
    			return false;
    		}
    		/**
    		 * Returns the preferred size of the {@code BasicArrowButton}.
    		 *
    		 * @return the preferred size
    		 */
    		public Dimension getPreferredSize() {
    			return new Dimension(20, 20);
    		}
    		/**
    		 * Returns the minimum size of the {@code BasicArrowButton}.
    		 *
    		 * @return the minimum size
    		 */
    		public Dimension getMinimumSize() {
    			return new Dimension(5, 5);
    		}
    		/**
    		 * Returns the maximum size of the {@code BasicArrowButton}.
    		 *
    		 * @return the maximum size
    		 */
    		public Dimension getMaximumSize() {
    			return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
    		}
    	};
    	button.setName("ComboBox.arrowButton");
    	return button;
    }
    
    //* copy from BasicComboBoxUI and modified by jb2011
    /* (non-Javadoc)
     * @see javax.swing.plaf.basic.BasicComboBoxUI#paint(java.awt.Graphics, javax.swing.JComponent)
     */
    @Override
    public void paint( Graphics g, JComponent c ) 
    {
        hasFocus = comboBox.hasFocus();
//        if ( !comboBox.isEditable() ) 
        {
            Rectangle r = rectangleForCurrentValue();
            paintCurrentValueBackground(g,r,hasFocus);
            if(!comboBox.isEditable())
            	paintCurrentValue(g,r,hasFocus);
        }
    }
    
    //* copy from BasicComboBoxUI and modified by jb2011
    /**
     * Paints the background of the currently selected item.
     *
     * @param g the g
     * @param bounds the bounds
     * @param hasFocus the has focus
     */
    public void paintCurrentValueBackground(Graphics g,Rectangle bounds,boolean hasFocus) 
    {
    	//* ����û������Զ�����ɫ������ʹ�ø��෽����ʵ�ֻ��ƣ�����BE LNF��û��֧����Щ����Ŷ
    	if(!isUseParentPaint())
    	{
    		if ( comboBox.isEnabled() )
    			org.jb2011.lnf.beautyeye.ch6_textcoms.__Icon9Factory__.getInstance().getTextFieldBgNormal()
    			.draw((Graphics2D)g, 0,0,comboBox.getWidth(),comboBox.getHeight());
    		else
    			org.jb2011.lnf.beautyeye.ch6_textcoms.__Icon9Factory__.getInstance().getTextFieldBgDisabled()
    			.draw((Graphics2D)g, 0,0,comboBox.getWidth(),comboBox.getHeight());
    	}
    	else
    	{
    		super.paintCurrentValueBackground(g, bounds, hasFocus);
    	}
    }
    
    //* copy from BasicComboBoxUI and modified by jb2011
    /**
     * Creates the default renderer that will be used in a non-editiable combo 
     * box. A default renderer will used only if a renderer has not been 
     * explicitly set with <code>setRenderer</code>.
     * 
     * @return a <code>ListCellRender</code> used for the combo box
     * @see javax.swing.JComboBox#setRenderer
     */
    protected ListCellRenderer createRenderer() 
    {
        return new BEComboBoxRenderer.UIResource(this);
    }
    
    //* ��jb2011 Override��������Ŀ���Ǹı丸�෽���ɼ��ԣ������3������
    /* (non-Javadoc)
     * @see javax.swing.plaf.basic.BasicComboBoxUI#getInsets()
     */
    public Insets getInsets()
    {
    	return super.getInsets();
    }
    
    //---------------------------------------------------------
//    static boolean isMenuShortcutKeyDown(InputEvent event) {
//        return (event.getModifiers() & 
//                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()) != 0;
//    }
//    /**
//     * Creates the JList used in the popup to display 
//     * the items in the combo box model. This method is called when the UI class
//     * is created.
//     *
//     * @return a <code>JList</code> used to display the combo box items
//     */
//    protected JList createList() {
//	return new JList( comboBox.getModel() ) {
//            public void processMouseEvent(MouseEvent e)  {
//                if (
////                		BasicGraphicsUtils.
//                		isMenuShortcutKeyDown(e))  {
//                    // Fix for 4234053. Filter out the Control Key from the list. 
//                    // ie., don't allow CTRL key deselection.
//                    Toolkit toolkit = Toolkit.getDefaultToolkit();
//                    e = new MouseEvent((Component)e.getSource(), e.getID(), e.getWhen(), 
//                                       e.getModifiers() ^ toolkit.getMenuShortcutKeyMask(),
//                                       e.getX()-10, e.getY(),
//                                       e.getXOnScreen()-10, e.getYOnScreen(),
//                                       e.getClickCount(),
//                                       e.isPopupTrigger(),
//                                       MouseEvent.NOBUTTON);
//                }
//                super.processMouseEvent(e);
//            }
//        };
//    }
    
    //* ���´��뿽�Ը��࣬Ŀ������������popup���ڵ�x��y���꣬����˵�UI����
    //* Menu.menuPopupOffsetX��4�����Կ������Ա���������е�����BeautyEye LNF����Jack Jiang
    //* ����Menu�е�ʵ���Զ�����2�����ԣ��Ա��Ժ����á��ο���jdk1.6.0_u18Դ��.
    /**
     * Creates the popup portion of the combo box.
     *
     * @return an instance of <code>ComboPopup</code>
     * @see ComboPopup
     */
    protected ComboPopup createPopup() {
    	return new BasicComboPopup( comboBox ){
    		/** popupOffsetX��jb2011�Զ������ԣ���������������ĵ�������X���� */
    		private int popupOffsetX = UIManager.getInt("ComboBox.popupOffsetX");
    		/** popupOffsetY��jb2011�Զ������ԣ���������������ĵ�������Y���� */
    		private int popupOffsetY = UIManager.getInt("ComboBox.popupOffsetY");
    		
    		//* copy from parent and modified by Jack Jiang
    		/**
    		 * Implementation of ComboPopup.show().
    		 */
    		public void show() {
    			setListSelection(comboBox.getSelectedIndex());
    			Point location = getPopupLocation();
    			show( comboBox
    					//����x��y��������������Jack Jiang����
    					, location.x + popupOffsetX //*~ popupOffsetX���Զ����ԣ������޸ĵ�������X����
    					, location.y + popupOffsetY //*~ popupOffsetY���Զ����ԣ������޸ĵ�������Y����
    			);
    		}

    		//* copy from parent and no modified
    		/**
    		 * Sets the list selection index to the selectedIndex. This 
    		 * method is used to synchronize the list selection with the 
    		 * combo box selection.
    		 * 
    		 * @param selectedIndex the index to set the list
    		 */
    		private void setListSelection(int selectedIndex) {
    			if ( selectedIndex == -1 ) {
    				list.clearSelection();
    			}
    			else {
    				list.setSelectedIndex( selectedIndex );
    				list.ensureIndexIsVisible( selectedIndex );
    			}
    		}

    		//* copy from parent and no modified
    		/**
    		 * Calculates the upper left location of the Popup.
    		 */
    		private Point getPopupLocation() {
    			Dimension popupSize = comboBox.getSize();
    			Insets insets = getInsets();

    			// reduce the width of the scrollpane by the insets so that the popup
    			// is the same width as the combo box.
    			popupSize.setSize(popupSize.width - (insets.right + insets.left), 
    					getPopupHeightForRowCount( comboBox.getMaximumRowCount()));
    			Rectangle popupBounds = computePopupBounds( 0, comboBox.getBounds().height,
    					popupSize.width, popupSize.height);
    			Dimension scrollSize = popupBounds.getSize();
    			Point popupLocation = popupBounds.getLocation();

    			scroller.setMaximumSize( scrollSize );
    			scroller.setPreferredSize( scrollSize );
    			scroller.setMinimumSize( scrollSize );

    			list.revalidate();

    			return popupLocation;
    		}
    	};
    }
}
