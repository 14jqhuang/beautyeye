/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * PlainGrayBorder.java at 2012-9-24 17:23:03, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.widget.border;

import java.awt.Insets;

import org.jb2011.lnf.beautyeye.widget.__Icon9Factory__;

// TODO: Auto-generated Javadoc
/**
 * 一个NinePatch图实现的不透明边框border.
 * <p>
 * 目前主要用于jdk1.5及以下版本的窗口边框（因为该版本下java不支持窗口透明）.
 * 
 * @author Jack Jiang(jb2011@163.com), 2012-09-04
 * @version 1.0
 * @see org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.FrameBorderStyle#generalNoTranslucencyShadow
 */
public class PlainGrayBorder extends NinePatchBorder
{
	
	/** The Constant IS. */
	private final static int IS = 5;
	
	/**
	 * Instantiates a new plain gray border.
	 */
	public PlainGrayBorder()
	{
		super(new Insets(IS,IS,IS,IS)
			, __Icon9Factory__.getInstance().getBorderIcon_plainGray());
	}
	
	//* 2012-09-19 在BeautyEye v3.2中的BERootPaneUI，Jack Jiang启用了相比
	//* 原MetalRootPaneUI中更精确更好的边框拖放算法，以下方法暂时弃用，以后可以删除了！
//	//当用本border作边框时，窗口可拖动敏感触点区大小值
//	public static int BORDER_DRAG_THICKNESS()
//	{
//		return IS;
//	}
//	//当用本border作边框时，窗口边角可拖动敏感触点区大小值
//	public static int CORNER_DRAG_WIDTH()
//	{
//		return 16;//使用MetalLookAndFeel的默认值比较合适哦
//	}
}
