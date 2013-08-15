/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BEDesktopIconUI.java at 2012-9-24 17:20:34, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch10_internalframe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicDesktopIconUI;

/**
 * �ڲ�������С��ʱ��ͼ��uiʵ���ࡣ.
 *
 * @author Jack Jiang(jb2011@163.com)
 */
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� Start
//�����ʵ�ֲο���WindowsDesktopIconUI (JDK1.6.0_u18)
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� END
public class BEDesktopIconUI extends BasicDesktopIconUI 
{
    
    /** The width. */
    private int width;

    /**
     * Creates the ui.
     *
     * @param c the c
     * @return the component ui
     */
    public static ComponentUI createUI(JComponent c) 
    {
        return new BEDesktopIconUI();
    }

    //copy from WindowsDesktopIconUI and no modified
    /* (non-Javadoc)
     * @see javax.swing.plaf.basic.BasicDesktopIconUI#installDefaults()
     */
    public void installDefaults() 
    {
        super.installDefaults();
        width = UIManager.getInt("DesktopIcon.width");
    }

    /* (non-Javadoc)
     * @see javax.swing.plaf.basic.BasicDesktopIconUI#installUI(javax.swing.JComponent)
     */
    public void installUI(JComponent c)   
    {
    	super.installUI(c);

    	//modified by jb2011
//		c.setOpaque(XPStyle.getXP() == null);
    	c.setOpaque(false);
    }

    //copy from WindowsDesktopIconUI and no modified
    /* (non-Javadoc)
     * @see javax.swing.plaf.basic.BasicDesktopIconUI#uninstallUI(javax.swing.JComponent)
     */
    public void uninstallUI(JComponent c) 
    {
    	BEInternalFrameTitlePane thePane = (BEInternalFrameTitlePane)iconPane;
        super.uninstallUI(c);
        thePane.uninstallListeners();
    }

    /* (non-Javadoc)
     * @see javax.swing.plaf.basic.BasicDesktopIconUI#installComponents()
     */
    protected void installComponents()
    {
        iconPane = new BEInternalFrameTitlePane(frame){
        	//��д���෽�� by jb2011
        	protected void paintTitlePaneImpl(Insets frameInsets,Graphics g
        			, int width,int height, boolean isSelected)
        	{
        		//** Swing BUG��������д�����Ŀ�ľ�������Insets(0,0,0,0)������paintTitlePaneImpl(������
        		//** BasicInternalFrameTitlePane�еĲ���bug�����ᵼ������λ)
        		Insets instes = new Insets(0,0,0,0);
        		super.paintTitlePaneImpl(instes, g, width, height, isSelected);
        	}
        };
        desktopIcon.setLayout(new BorderLayout());
        desktopIcon.add(iconPane, BorderLayout.CENTER);

//		if (XPStyle.getXP() != null) {
//	   	 	desktopIcon.setBorder(null);
//		}
        
        //add by jb2011 2012-06-19
	    desktopIcon.setBorder(UIManager.getBorder("InternalFrame.border"));
    }

    //copy from WindowsDesktopIconUI and no modified
    /* (non-Javadoc)
     * @see javax.swing.plaf.basic.BasicDesktopIconUI#getPreferredSize(javax.swing.JComponent)
     */
    public Dimension getPreferredSize(JComponent c)
    {
        // Windows desktop icons can not be resized.  Therefore, we should
        // always return the minimum size of the desktop icon. See
        // getMinimumSize(JComponent c).
        return getMinimumSize(c);
    }

    //copy from WindowsDesktopIconUI and no modified
    /**
     * Windows desktop icons are restricted to a width of 160 pixels by
     * default.  This value is retrieved by the DesktopIcon.width property.
     *
     * @param c the c
     * @return the minimum size
     */
    public Dimension getMinimumSize(JComponent c) 
    {
        Dimension dim = super.getMinimumSize(c);
        dim.width = width;
        return dim;
    }
}
