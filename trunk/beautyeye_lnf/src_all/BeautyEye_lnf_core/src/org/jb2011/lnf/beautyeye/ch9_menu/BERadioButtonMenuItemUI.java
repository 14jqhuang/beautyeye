/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BERadioButtonMenuItemUI.java at 2012-9-24 17:22:51, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch9_menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.Serializable;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;

// TODO: Auto-generated Javadoc
/**
 * JRadioButtonMenuItem的UI实现.
 *
 * @author Jack Jiang(jb2011@163.com)
 * @version 1.0
 */
public class BERadioButtonMenuItemUI extends BasicRadioButtonMenuItemUI 
{
    
    /**
     * Creates the ui.
     *
     * @param b the b
     * @return the component ui
     */
    public static ComponentUI createUI(JComponent b) 
    {
        return new BERadioButtonMenuItemUI();
    }    
    
    //copy from BasicMenuItemUI.paintBackground(..),modified by Jack Jiang
    /**
     * Draws the background of the menu item.
     * 
     * @param g the paint graphics
     * @param menuItem menu item to be painted
     * @param bgColor selection background color
     * @since 1.4
     */
    protected void paintBackground(Graphics g, JMenuItem menuItem, Color bgColor) 
    {
    	ButtonModel model = menuItem.getModel();
    	Color oldColor = g.getColor();
    	int menuWidth = menuItem.getWidth();
    	int menuHeight = menuItem.getHeight();

    	if(menuItem.isOpaque()) 
    	{
    		if (model.isArmed()|| (menuItem instanceof JMenu && model.isSelected())) 
    		{
    			g.setColor(bgColor);
    			g.fillRect(0,0, menuWidth, menuHeight);
    		} 
    		else 
    		{
    			g.setColor(menuItem.getBackground());
    			g.fillRect(0,0, menuWidth, menuHeight);
    		}
    		g.setColor(oldColor);
    	}
    	else if (model.isArmed() || (menuItem instanceof JMenu &&
    			model.isSelected())) 
    	{
//    		g.setColor(bgColor);
//    		g.fillRect(0,0, menuWidth, menuHeight);
//    		g.setColor(oldColor);
    		
    		//由jb2011改用NinePatch图来填充
			__Icon9Factory__.getInstance().getBgIcon_ItemSelected()
				.draw((Graphics2D)g, 0, 0, menuWidth, menuHeight);
    	}
    }
    
    //copy from com.sun.java.swing.plaf.windows.WindowsIconFactory.RadioButtonMenuItemIcon 
    //* 由Jack Jiang修改
    /**
     * The Class RadioButtonMenuItemIcon.
     */
    public static class RadioButtonMenuItemIcon implements Icon, UIResource, Serializable
    {
    	/** 
    	 * 本常量用于标识是否运行于Vista及更新的windows平台.
    	 * （当然，目前该变量只会在BeautyEyeLookAndFeelWin中被设置，即如果使
    	 * 用BeautyEyeLookAndFeelCross跨平台主类则永远不会被设置，因为跨平台主类及LNF不受此影响哦）.
    	 * @see org.jb2011.lnf.beautyeye.BeautyEyeLookAndFeelWin#initForVista()
    	 */
    	private boolean usedForVista = false;
    	
    	/** The selected img. */
	    private Image selectedImg = __IconFactory__.getInstance()
				.getRadioButtonMenuItemCheckIcon().getImage();
    	
	    /* (non-Javadoc)
	     * @see javax.swing.Icon#paintIcon(java.awt.Component, java.awt.Graphics, int, int)
	     */
	    public void paintIcon(Component c, Graphics g, int x, int y) 
    	{
    		AbstractButton b = (AbstractButton) c;
//    		ButtonModel model = b.getModel();
    		if (b.isSelected() == true) 
    		{
//    			g.fillRoundRect(x+3,y+3, getIconWidth()-6, getIconHeight()-6,4, 4);
    			g.drawImage(selectedImg
    					, x+(usedForVista?11:2)//* 注意：当用于windows平台专用主类且处于Vista及更高版win时要做不一样的处理哦
    					,y+1, null);
    		}
    	}
    	
	    /* (non-Javadoc)
	     * @see javax.swing.Icon#getIconWidth()
	     */
	    public int getIconWidth() { return 16; }//default 6
    	
	    /* (non-Javadoc)
	     * @see javax.swing.Icon#getIconHeight()
	     */
	    public int getIconHeight() { return 16; }//default 6
    	
    	/**
	     * Checks if is used for vista.
	     *
	     * @return true, if is used for vista
	     */
	    public boolean isUsedForVista()
		{
			return usedForVista;
		}
		
		/**
		 * Sets the used for vista.
		 *
		 * @param usedForVista the used for vista
		 * @return the radio button menu item icon
		 */
		public RadioButtonMenuItemIcon setUsedForVista(boolean usedForVista)
		{
			this.usedForVista = usedForVista;
			return this;
		}
    } // End class RadioButtonMenuItemIcon
}

