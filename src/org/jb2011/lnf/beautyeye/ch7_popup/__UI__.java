/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * __UI__.java at 2012-9-24 17:22:46, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch7_popup;

import javax.swing.PopupFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class __UI__.
 */
public class __UI__
{
	
	/** The popup factory diy. */
	public static PopupFactory popupFactoryDIY = new TranslucentPopupFactory();
	
	/**
	 * Ui impl.
	 */
	public static void uiImpl()
	{
		PopupFactory.setSharedInstance(popupFactoryDIY);
	}
}
