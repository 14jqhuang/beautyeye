/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BEScrollPaneUI.java at 2012-9-24 17:22:37, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch4_scroll;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicScrollPaneUI;

// TODO: Auto-generated Javadoc
/**
 * ��������UIʵ���ࡣ.
 *
 * @author Jack Jiang(jb2011@163.com
 */
public class BEScrollPaneUI extends BasicScrollPaneUI
{
    
    /**
     * Creates the ui.
     *
     * @param x the x
     * @return the component ui
     */
    public static ComponentUI createUI(JComponent x) 
    {
    	return new BEScrollPaneUI();
    }
    
    /* (non-Javadoc)
     * @see javax.swing.plaf.basic.BasicScrollPaneUI#installDefaults(javax.swing.JScrollPane)
     */
    protected void installDefaults(JScrollPane scrollpane) 
    {
    	super.installDefaults(scrollpane);
    	
//    	/* ~~ע��ScrollPane.opaque���������jb2011���Ѽӵģ�Ŀ���ǿ��ƹ�����弰��Viewport��͸���� */
//    	scrollpane.setOpaque(UIManager.getBoolean("ScrollPane.opaque"));
//    	scrollpane.getViewport().setOpaque(UIManager.getBoolean("ScrollPane.opaque"));
    }
}
