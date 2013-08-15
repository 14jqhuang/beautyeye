/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BEMenuUI.java at 2012-9-24 17:22:51, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch9_menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.MenuElement;
import javax.swing.UIManager;
import javax.swing.event.MouseInputListener;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicMenuUI;

import org.jb2011.lnf.beautyeye.utils.BEUtils;
import org.jb2011.lnf.beautyeye.winlnfutils.WinUtils;


// TODO: Auto-generated Javadoc
/**
 * JMenuU��UIʵ���ࡣ.
 *
 * @author Jack Jiang(jb2011@163.com)
 */
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� Start
//* �����ʵ�ֲο���WindowsMenuUI
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� END
public class BEMenuUI extends BasicMenuUI//WindowsMenuUI 
{
	//JMenuBar�Ķ���˵����װ�ε��߸߶�
	/** The Constant DECORATED_UNDERLINE_HEIGHT. */
	public final static int DECORATED_UNDERLINE_HEIGHT = 2;// TODO ����������Ui����Ŷ
	//����˵��ѡ�е���ɫ
	/** The Constant MENU_SELECTED_UNDERLINE_COLOR. */
	public final static Color MENU_SELECTED_UNDERLINE_COLOR = new Color(37,147,217);// TODO ����������Ui����Ŷ
	//����˵���δ��ѡ�е���ɫ
	/** The Constant MENU_UNSELECTED_UNDERLINE_COLOR. */
	public final static Color MENU_UNSELECTED_UNDERLINE_COLOR = new Color(226,230,232);// TODO ����������Ui����Ŷ
	
    /** The menu bar height. */
    protected Integer menuBarHeight;
    
    /** The hot tracking on. */
    protected boolean hotTrackingOn;
    
    /**
     * Creates the ui.
     *
     * @param x the x
     * @return the component ui
     */
    public static ComponentUI createUI(JComponent x) 
    {
    	return new BEMenuUI();
    }
    
    //* ��������Jack Jiang 2012-09-13�޸���WindowsMenuUI
    /* (non-Javadoc)
     * @see javax.swing.plaf.basic.BasicMenuUI#installDefaults()
     */
    protected void installDefaults() 
    {
    	super.installDefaults();
//    	if (!WindowsLookAndFeel.isClassicWindows()) 
    	{
    		menuItem.setRolloverEnabled(true);
    	}
    	
    	menuBarHeight = (Integer)UIManager.getInt("MenuBar.height");
    	Object obj      = UIManager.get("MenuBar.rolloverEnabled");
    	hotTrackingOn = (obj instanceof Boolean) ? (Boolean)obj : true;
    }

    //copy of WindowsMenuUI, modified by jb2011
    /**
     * Draws the background of the menu.
     *
     * @param g the g
     * @param menuItem the menu item
     * @param bgColor the bg color
     * @since 1.4
     */
    protected void paintBackground(Graphics g, JMenuItem menuItem, Color bgColor) 
    {
    	JMenu menu = (JMenu)menuItem;
    	ButtonModel model = menu.getModel();

    	Color oldColor = g.getColor();
    	int menuWidth = menu.getWidth();
    	int menuHeight = menu.getHeight();

//    	UIDefaults table = UIManager.getLookAndFeelDefaults();
//    	Color highlight = table.getColor("controlLtHighlight");
//    	Color shadow = table.getColor("controlShadow");

    	g.setColor(menu.getBackground());
    	g.fillRect(0,0, menuWidth, menuHeight);
    	
    	//��JMEnuBar�Ķ���˵����л�һ����ɫ���ߣ����������ۣ�
    	//λ�ڲ˵������MenuItem����Ҫ��������ߣ�Ҫ��Ȼ���ÿ�Ŷ��
    	if(menu.isTopLevelMenu())
    	{
    		//δѡ�е�װ�ε���
    		//ֻҪ����MenuBar����JMenu����Ҫ��Ŷ���Ӷ����ɫ��Ϊһ�壩
    		g.setColor(MENU_UNSELECTED_UNDERLINE_COLOR);
    		g.fillRect(0,menuHeight-DECORATED_UNDERLINE_HEIGHT, menuWidth, menuHeight);
    	}

    	//* >ע�⣺�ٷ����ж�menu.isOpaque()==falseʱ�Ž����if-else��֧��
    	//* >��ʵ���´���������ǣ����Ƕ���Menu����ֱ�ӷ���MenuBar�ϵ��ǲ㣩ʱ
    	//* >����Ҫ�������·�֧������win7�£����·�֧�ǲ��ᱻ���õģ�WindowsLookAndfeel.initVistaComponentDefaults��
    	//* >�����������vista��"MenuItem.opaque", "Menu.opaque", "CheckBoxMenuItem.opaque", "RadioButtonMenuItem.opaque"
    	//* >Ĭ�϶����ó���false����Ĭ��͸�����ٷ��߼�������͸�������ζ���Ƕ���menu�ˣ�����
    	//* >����ôwin7�½�����ִ���ı��֣��޷������ǲ��Ƕ���menuҲ���޷�����paint����ͬ��������.
    	//* >��ô�ٷ�Ϊ��û�յ�bug�����أ��ҷ������ܻ�û������Ե�BeautyEye������Ҫ��Menu���нϸ�����ʽ����ĳ���
    	//* >�����Ѷ���menu���ڲ�menu�ֵĺ��塣
    	//* >ĿǰBeautyEye��ʵ�ּ�menu.isTopLevelMenu()==trueʱ�����뱾��֧
    	//* >���ǱȽϺ���ģ���Ȼ���д�ʵ�����飬����ٷ����������ǡ� -- commet by Jack Jiang 2012-09-14
		if (menu.isTopLevelMenu())//menu.isOpaque())
		{
			//JMebuBar�Ķ���˵��ѡ�л����ͣ��ʱ
			if (model.isArmed() || model.isSelected())
			{
				Color c = MENU_SELECTED_UNDERLINE_COLOR;
				g.setColor(c);
				
				//�����һ��װ��3���Σ�������UI����ʾ�û�����ѡ���ˣ�
				//       x2,y2
				//
				//x1,y1          x3,y3
				int tW = 7,tH = 3; 
				int x1 = menuWidth/2 - tW/2;
				int y1 = menuHeight - DECORATED_UNDERLINE_HEIGHT;
				int x2 = menuWidth/2;
				int y2 = menuHeight - DECORATED_UNDERLINE_HEIGHT - tH;
				int x3 = menuWidth /2 + tW/2;
				int y3 = menuHeight - DECORATED_UNDERLINE_HEIGHT;
				//������
				BEUtils.setAntiAliasing((Graphics2D)g, true);
				BEUtils.fillTriangle(g, x1, y1, x2, y2, x3, y3, c);
				BEUtils.setAntiAliasing((Graphics2D)g, false);
				
				//�����һ�����ߣ�����װ�Σ�
				g.fillRect(0,menuHeight-DECORATED_UNDERLINE_HEIGHT, menuWidth, DECORATED_UNDERLINE_HEIGHT);//menuHeight);
			}
			else if (model.isRollover() && model.isEnabled())
			{
				// Only paint rollover if no other menu on menubar is selected
				boolean otherMenuSelected = false;
				MenuElement[] menus = ((JMenuBar) menu.getParent())
						.getSubElements();
				for (int i = 0; i < menus.length; i++)
				{
					if (((JMenuItem) menus[i]).isSelected())
					{
						otherMenuSelected = true;
						break;
					}
				}
				
				if (!otherMenuSelected)
				{
					g.setColor(MENU_SELECTED_UNDERLINE_COLOR);//selectionBackground);// Uses protected
//					g.fillRect(0, 0, menuWidth, menuHeight);
					//�����һ�����ߣ�����װ�Σ�
					g.fillRect(0,menuHeight-DECORATED_UNDERLINE_HEIGHT, menuWidth, DECORATED_UNDERLINE_HEIGHT);//menuHeight);
				}
			}
		}
		// add by Jack Jiang��JMebuBar���ڲ㸸���˵������ʽ����
		else if (model.isArmed() || (menuItem instanceof JMenu &&
				model.isSelected())) 
		{
			//��NinePatchͼ�����
			__Icon9Factory__.getInstance().getBgIcon_ItemSelected()
				.draw((Graphics2D)g, 0, 0, menuWidth, menuHeight);
		}
    	g.setColor(oldColor);
    }
    
    //copy of WindowsMenuUI, modified by jb2011
    /**
     * Method which renders the text of the current menu item.
     * <p>
     * @param g Graphics context
     * @param menuItem Current menu item to render
     * @param textRect Bounding rectangle to render the text.
     * @param text String to render
     * @since 1.4
     */
    protected void paintText(Graphics g, JMenuItem menuItem,
    		Rectangle textRect, String text) 
    {
    	//================= commet by Jack Jiang START
//    	if (WindowsMenuItemUI.isVistaPainting()) {
//    		WindowsMenuItemUI.paintText(accessor, g, menuItem, textRect, text);
//    		return;
//    	}
    	//================= commet by Jack Jiang END
    	JMenu menu = (JMenu)menuItem;
    	ButtonModel model = menuItem.getModel();
    	Color oldColor = g.getColor();

    	// Only paint rollover if no other menu on menubar is selected
    	boolean paintRollover = model.isRollover();
    	if (paintRollover && menu.isTopLevelMenu()) {
    		MenuElement[] menus = ((JMenuBar)menu.getParent()).getSubElements();
    		for (int i = 0; i < menus.length; i++) {
    			if (((JMenuItem)menus[i]).isSelected()) {
    				paintRollover = false;
    				break;
    			}
    		}
    	}

    	if ((model.isSelected() && 
    							(
//    							WindowsLookAndFeel.isClassicWindows() ||
    							!menu.isTopLevelMenu())) 
    			||
    			(
//    					BEXPStyle.getXP() != null && 
    					(paintRollover ||model.isArmed() ||model.isSelected())
    			)
    	) 
    	{
    		g.setColor(selectionForeground); // Uses protected field.
    	}

    	//================= add by Jack Jiang START
    	//���⴦�����˵������ֱ�ӷ���JMenuBar�ϵ���һ�㣩��ʹ֮�ڱ�ѡ�л�rover��״̬ʱ���ֺ�ɫ����������ɫ��
    	//��Ŀ����Ϊ����������˵����L&FЧ������û�й������;������ɫ����ȡ��ΪUIManager���Զ�������Ŷ
    	if(menu.isTopLevelMenu())
    		g.setColor(new Color(35,35,35));//��MaxOS X�ľ����
    	//================= add by Jack Jiang END
    	
//    	WindowsGraphicsUtils.paintText(g, menuItem, textRect, text, 0);
    	WinUtils.paintText(g, menuItem, textRect, text, 0);
    	
    	g.setColor(oldColor);
    }
    
    //* copy of WindowsMenuUI, û�б��޸�
    /* (non-Javadoc)
     * @see javax.swing.plaf.basic.BasicMenuUI#createMouseInputListener(javax.swing.JComponent)
     */
    protected MouseInputListener createMouseInputListener(JComponent c) {
        return new BEMouseInputHandler();
    }

    //* copy of WindowsMenuUI, û�б��޸�
    /**
     * This class implements a mouse handler that sets the rollover flag to
     * true when the mouse enters the menu and false when it exits.
     * @since 1.4
     */
    protected class BEMouseInputHandler extends BasicMenuUI.MouseInputHandler {
    	
	    /* (non-Javadoc)
	     * @see javax.swing.plaf.basic.BasicMenuUI.MouseInputHandler#mouseEntered(java.awt.event.MouseEvent)
	     */
	    public void mouseEntered(MouseEvent evt) {
    		super.mouseEntered(evt);

    		JMenu menu = (JMenu)evt.getSource();
    		if (hotTrackingOn && menu.isTopLevelMenu() && menu.isRolloverEnabled()) {
    			menu.getModel().setRollover(true);
    			menuItem.repaint();
    		}
    	}

    	/* (non-Javadoc)
	     * @see javax.swing.plaf.basic.BasicMenuUI.MouseInputHandler#mouseExited(java.awt.event.MouseEvent)
	     */
	    public void mouseExited(MouseEvent evt) {
    		super.mouseExited(evt);

    		JMenu menu = (JMenu)evt.getSource();
    		ButtonModel model = menu.getModel();
    		if (menu.isRolloverEnabled()) {
    			model.setRollover(false);
    			menuItem.repaint();
    		}
    	}
    }

    //* copy of WindowsMenuUI, û�б��޸�
    /* (non-Javadoc)
     * @see javax.swing.plaf.basic.BasicMenuItemUI#getPreferredMenuItemSize(javax.swing.JComponent, javax.swing.Icon, javax.swing.Icon, int)
     */
    protected Dimension getPreferredMenuItemSize(JComponent c,
    		Icon checkIcon,
    		Icon arrowIcon,
    		int defaultTextIconGap) {

    	Dimension d = super.getPreferredMenuItemSize(c, checkIcon, arrowIcon,
    			defaultTextIconGap);

    	// Note: When toolbar containers (rebars) are implemented, only do
    		// this if the JMenuBar is not in a rebar (i.e. ignore the desktop
    	// property win.menu.height if in a rebar.)
    	if (c instanceof JMenu && ((JMenu)c).isTopLevelMenu() &&
    			menuBarHeight != null && d.height < menuBarHeight) {

    		d.height = menuBarHeight;
    	}

    	return d;
    }
}

