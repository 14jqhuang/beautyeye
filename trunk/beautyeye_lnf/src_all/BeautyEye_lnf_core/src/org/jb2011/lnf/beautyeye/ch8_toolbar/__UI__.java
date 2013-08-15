/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * __UI__.java at 2012-9-24 17:22:48, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch8_toolbar;

import javax.swing.UIManager;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class __UI__.
 */
public class __UI__
{
	
	/**
	 * Ui impl.
	 */
	public static void uiImpl()
	{
		UIManager.put("ToolBar.dockingBackground",new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));
		UIManager.put("ToolBar.floatingBackground",new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));
		UIManager.put("ToolBar.background",new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));
		UIManager.put("ToolBar.foreground",new ColorUIResource(BeautyEyeLNFHelper.commonForegroundColor));
		//工具栏的border实现
		UIManager.put("ToolBar.border",new BorderUIResource(
//				com.sun.java.swing.plaf.windows.WindowsBorders.getToolBarBorder()));
				new org.jb2011.lnf.beautyeye.ch8_toolbar.BEToolBarUI.ToolBarBorder(UIManager.getColor("ToolBar.shadow"),
						UIManager.getColor("ToolBar.highlight"))));
//				BorderFactory.createEmptyBorder(5, 0, 8, 0)));//5, 5, 8, 5)));
		//分隔条ui实现
		UIManager.put("ToolBarSeparatorUI"
				, org.jb2011.lnf.beautyeye.ch8_toolbar.BEToolBarSeparatorUI.class.getName());
		UIManager.put("ToolBarUI",org.jb2011.lnf.beautyeye.ch8_toolbar.BEToolBarUI.class.getName());
	}
}
