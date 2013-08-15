/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * ScrollPaneBorder.java at 2012-9-24 17:22:37, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch4_scroll;

import java.awt.Insets;

import org.jb2011.lnf.beautyeye.widget.border.NinePatchBorder;

// TODO: Auto-generated Javadoc
/**
 * 滚动面板默认Border的实现类。.
 *
 * @author Jack Jiang(jb2011@163.com)
 */
public class ScrollPaneBorder extends NinePatchBorder
{
	
	/**
	 * Instantiates a new scroll pane border.
	 */
	public ScrollPaneBorder()
	{
		super(new Insets(6,6,8,6)//5,4,6,4
				, __Icon9Factory__.getInstance().getScrollPaneBorderBg());
	}
}