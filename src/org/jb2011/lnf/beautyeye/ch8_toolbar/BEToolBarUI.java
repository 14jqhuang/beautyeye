/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BEToolBarUI.java at 2012-9-24 17:22:48, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch8_toolbar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicToolBarUI;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import com.android.ninepatch.NinePatch;

// TODO: Auto-generated Javadoc
/**
 * JToolBar��UIʵ���ࡣ.
 *
 * @author Jack Jiang(jb2011@163.com)
 */
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� Start
//����ʵ�ִ���ο���WindowsToolBarUI��
//�ر�˵����JToolBar�Ƚ����⣬���뵽JToolBar�е��������UI����Ҫ��Border������ToolBarUI��
//����ƶ���������UI���ƣ�������뵽JToolBar�е�JToggleButton������border������ToolBarUI
//���ƣ���ЩJToggleButton����������޸�ToolgleButtonUI.borderҲ������Ч��
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� END
public class BEToolBarUI extends BasicToolBarUI 
	implements org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.__UseParentPaintSurported
{
	
	/**
	 * Creates the ui.
	 *
	 * @param c the c
	 * @return the component ui
	 */
	public static ComponentUI createUI(JComponent c) {
		return new BEToolBarUI();
	}

	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicToolBarUI#installDefaults()
	 */
	protected void installDefaults() 
	{
//		if (XPStyle.getXP() != null) 
		{
			setRolloverBorders(true);
		}
		super.installDefaults();
	}
	
	//* ��������Jack Jiang��2012-09-07�ռ���
    /**
	 * �Ƿ�ʹ�ø���Ļ���ʵ�ַ�����true��ʾ��.
	 * <p>
	 * ��Ϊ��BE LNF�У�������������ʹ��N9ͼ��û��ͨ�����ñ���ɫ��ǰ��
	 * ɫ�����ƹ���������ɫ����������Ŀ�ľ��ǵ��û������˹�������Background
	 * ʱ��֮��ʵ���಻ʹ��BE LNF��Ĭ�ϵ�N9ͼ�����ƶ����ø����еķ����������еķ���
	 * �Ϳ���֧����ɫ�������ޣ�ֻ�ǳ�㣬���ܹ�������Ӧ�û������󳡾�Ҫ����ʵ�û���ȫ����
	 * ͨ��JToolBar.setUI(new MetalToolBar())�ȷ�ʽ���Զ���UIŶ��.
	 *
	 * @return true, if is use parent paint
	 */
    public boolean isUseParentPaint()
    {
    	return toolBar != null 
    		&& (!(toolBar.getBackground() instanceof UIResource));
    }

	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicToolBarUI#createRolloverBorder()
	 */
	protected Border createRolloverBorder() 
	{
		return new EmptyBorder(3, 3, 3, 3);
	}

	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicToolBarUI#createNonRolloverBorder()
	 */
	protected Border createNonRolloverBorder() 
	{
		return new EmptyBorder(3, 3, 3, 3);
	}

	/* (non-Javadoc)
	 * @see javax.swing.plaf.ComponentUI#paint(java.awt.Graphics, javax.swing.JComponent)
	 */
	public void paint(Graphics g, JComponent c) 
	{
		//* ����û������Զ�����ɫ������ʹ�ø��෽����ʵ�ֻ��ƣ�����BE LNF��û��֧����Щ����Ŷ
    	if(isUseParentPaint())
    	{
    		super.paint(g, c);
    	}
    	else
    	{
    		//* ���ݹ����������ڸ����λ�ò�ͬ���������ı�����ʹ���ĸ�ͼƬ��ͼƬ�Ĳ�����ڷ���ͬ����Ҫ�Ǳ�Ե��Ӱ�ķ���
    		NinePatch np = __Icon9Factory__.getInstance().getToolBarBg_NORTH();
    		//		int orientation = toolBar.getOrientation();
    		Container parent = toolBar.getParent();
    		if(parent != null)
    		{
    			LayoutManager lm = parent.getLayout();
    			if(lm instanceof BorderLayout)
    			{
    				Object cons = ((BorderLayout)lm).getConstraints(toolBar);
    				if(cons != null)
    				{
    					if(cons.equals(BorderLayout.NORTH))
    						np = __Icon9Factory__.getInstance().getToolBarBg_NORTH();
    					else if(cons.equals(BorderLayout.SOUTH))
    						np = __Icon9Factory__.getInstance().getToolBarBg_SOUTH();
    					else if(cons.equals(BorderLayout.WEST))
    						np = __Icon9Factory__.getInstance().getToolBarBg_WEST();
    					else if(cons.equals(BorderLayout.EAST))
    						np = __Icon9Factory__.getInstance().getToolBarBg_EAST();
    				}
    			}
    		}
    		np.draw((Graphics2D)g, 0, 0, c.getWidth(), c.getHeight());
    	}
	}

	/**
	 * Gets the rollover border.
	 *
	 * @param b the b
	 * @return the rollover border
	 * {@inheritDoc}
	 * @since 1.6
	 */
	protected Border getRolloverBorder(AbstractButton b) 
	{
		return new BEButtonUI.XPEmptyBorder(new Insets(3,3,3,3));//xp.getBorder(b, WindowsButtonUI.getXPButtonType(b));
	}
	
	//* ��jb2011�޸ģ�ֻ����һ�д���Ŷ
	/**
	 * ��д���෽��ʵ�����ѵ�����������.
	 * �Զ����Ŀ�ľ���Ϊ�˰Ѽ��뵽���е��������Ϊ͸������ΪBE LNF�Ĺ��������б���������
	 * ����������ı������ڶ�ʹ��������ѿ�.
	 *
	 * @return the container listener
	 */
	@Override
	protected ContainerListener createToolBarContListener( )
	{
		return new ToolBarContListenerJb2011();
	}
	//* ��jb2011�޸��Ը����Handler���ContainerListener��������
    /**
	 * The Class ToolBarContListenerJb2011.
	 */
	protected class ToolBarContListenerJb2011 implements ContainerListener 
    {
    	 //
        // ContainerListener
        //
        /* (non-Javadoc)
 	     * @see java.awt.event.ContainerListener#componentAdded(java.awt.event.ContainerEvent)
 	     */
 	    public void componentAdded(ContainerEvent evt) {
            Component c = evt.getChild();

            if (toolBarFocusListener != null) {
                c.addFocusListener(toolBarFocusListener);
            }

            if (isRolloverBorders()) {
                setBorderToRollover(c);
            } 
            else 
            {
                setBorderToNonRollover(c);
            }
            
            //* ֻ����һ������jb2011�ӵ�
            if(c instanceof JComponent)
            	((JComponent)c).setOpaque(false);
        }

        /* (non-Javadoc)
         * @see java.awt.event.ContainerListener#componentRemoved(java.awt.event.ContainerEvent)
         */
        public void componentRemoved(ContainerEvent evt) {
            Component c = evt.getChild();

            if (toolBarFocusListener != null) {
                c.removeFocusListener(toolBarFocusListener);
            }

            // Revert the button border
            setBorderToNormal(c);
        }
    }
    
    //* ������Jack Jiangʵ�֣��ο���com.sun.java.swing.plaf.windows.WindowsBorders.getToolBarBorder
    /**
     * �������߿���ߣ����ҡ����Ϸ������϶�����Ļ��ƣ����� ��֮�û����ǿ����϶���
     * A border for the ToolBar. If the ToolBar is floatable then the handle grip is drawn
     * <p>
     * @since 1.4
     */
    public static class ToolBarBorder extends AbstractBorder implements UIResource, SwingConstants
    {
    	
	    /** The shadow. */
	    protected Color shadow;
    	
	    /** The highlight. */
	    protected Color highlight;

    	/**
	     * Instantiates a new tool bar border.
	     *
	     * @param shadow the shadow
	     * @param highlight the highlight
	     */
	    public ToolBarBorder(Color shadow, Color highlight) {
    		this.highlight = highlight;
    		this.shadow = shadow;
    	}

    	/* (non-Javadoc)
	     * @see javax.swing.border.AbstractBorder#paintBorder(java.awt.Component, java.awt.Graphics, int, int, int, int)
	     */
	    public void paintBorder(Component c, Graphics g, int x, int y, 
    			int width, int height) {
    		g.translate(x, y);

    		//��Ҫ�����϶�����
    		if (((JToolBar)c).isFloatable()) 
    		{
    			boolean vertical = ((JToolBar)c).getOrientation() == VERTICAL;
    			if (!vertical) 
    			{
    				if (c.getComponentOrientation().isLeftToRight()) 
    				{
    					__Icon9Factory__.getInstance().getToolBarBorder_H_FloatTouch()
    					.draw((Graphics2D)g, 4, 0, 3, height);
    				} 
    				else
    				{
    					__Icon9Factory__.getInstance().getToolBarBorder_H_FloatTouch()
    					.draw((Graphics2D)g, width - 4, 0, 3, height);
    				}
    			} 
    			else // Vertical
    			{ 
    				__Icon9Factory__.getInstance().getToolBarBorder_V_FloatTouch()
    				.draw((Graphics2D)g, 0, 4, width, 3);
    			}
    		}

    		g.translate(-x, -y);
    	}

    	/* (non-Javadoc)
	     * @see javax.swing.border.AbstractBorder#getBorderInsets(java.awt.Component)
	     */
	    public Insets getBorderInsets(Component c)      
    	{
    		//** ����toolbar�������ķ�λ��ͬ�����ò�һ����border��
    		//tollbar�������õĿհ׶�һ�㿴��������һЩ����Ҳ������toolbar������߶ȺͿ��Ŷ��
    		final Insets DEFAILT_IS = new Insets(6, 0, 11, 0);
    		Insets is = DEFAILT_IS;
    		if(c instanceof JToolBar)
    		{
    			Container parent = c.getParent();
    			if(parent != null)
    			{
    				LayoutManager lm = parent.getLayout();
    				if(lm instanceof BorderLayout)
    				{
    					Object cons = ((BorderLayout)lm).getConstraints((JToolBar)c);
    					if(cons != null)
    					{
    						if(cons.equals(BorderLayout.NORTH))
    							is = DEFAILT_IS;// TODO ��insets��һUIManager���ԾͿ��Է����Ժ�������
    						else if(cons.equals(BorderLayout.SOUTH))
    							is = new Insets(11, 0, 6, 0);// TODO ��insets��һUIManager���ԾͿ��Է����Ժ�������
    						else if(cons.equals(BorderLayout.WEST))
    							is = new Insets(0, 6, 0, 11);// TODO ��insets��һUIManager���ԾͿ��Է����Ժ�������
    						else if(cons.equals(BorderLayout.EAST))
    							is = new Insets(0, 11, 0, 6);// TODO ��insets��һUIManager���ԾͿ��Է����Ժ�������
    					}
    				}
    			}
    		}
    		
    		return getBorderInsets(c, is);//5, 0, 10, 0));//Ĭ���� 1,1,1,1
    	}

    	/* (non-Javadoc)
	     * @see javax.swing.border.AbstractBorder#getBorderInsets(java.awt.Component, java.awt.Insets)
	     */
	    public Insets getBorderInsets(Component c, Insets insets) {
//    		insets.top = insets.left = insets.bottom = insets.right = 1;
    		if (((JToolBar)c).isFloatable()) 
    		{
//    			int gripInset = (XPStyle.getXP() != null) ? 12 : 9;
    			int gripInset = 9;
    			if (((JToolBar)c).getOrientation() == HORIZONTAL) 
    			{
    				if (c.getComponentOrientation().isLeftToRight()) 
    				{
    					insets.left = gripInset;
    				} 
    				else 
    				{
    					insets.right = gripInset;
    				}
    			} 
    			else 
    			{
    				insets.top = gripInset;
    			}
    		}
    		return insets;
    	}
    }
}

