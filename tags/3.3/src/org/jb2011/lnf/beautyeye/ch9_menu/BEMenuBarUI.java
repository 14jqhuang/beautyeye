/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BEMenuBarUI.java at 2012-9-24 17:22:51, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch9_menu;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicMenuBarUI;

// TODO: Auto-generated Javadoc
/**
 * JMenuBar��UIʵ���ࡣ.
 *
 * @author Jack Jiang(jb2011@163.com)
 */
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� Start
//* �����ʵ�ֲο���WindowsMenuBarUI
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� END
public class BEMenuBarUI extends BasicMenuBarUI//WindowsMenuBarUI
{
    
    /**
     * Creates the ui.
     *
     * @param x the x
     * @return the component ui
     */
    public static ComponentUI createUI(JComponent x)
    {
    	return new BEMenuBarUI();
    }
    
    /* (non-Javadoc)
     * @see javax.swing.plaf.ComponentUI#paint(java.awt.Graphics, javax.swing.JComponent)
     */
    @Override
    public void paint(Graphics g, JComponent c) 
    {
    	int width = c.getWidth();
    	int height = c.getHeight();

    	//������һ����ɫ���ߣ�������JMenuBar�Ķ���˵���ĵ�ɫ�ںϣ�
    	g.setColor(BEMenuUI.MENU_UNSELECTED_UNDERLINE_COLOR);
    	g.fillRect(0,height-BEMenuUI.DECORATED_UNDERLINE_HEIGHT, width, height);
    }
}
