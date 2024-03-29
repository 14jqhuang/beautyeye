/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * FocusCellHighlightBorder.java at 2012-9-24 17:22:40, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch5_table;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.UIManager;
import javax.swing.border.AbstractBorder;

// TODO: Auto-generated Javadoc
/**
 * 表格单元获得焦点时的Border实现类。.
 *
 * @author Jack Jiang(jb2011@163.com)
 */
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 一些说明 Start
//本border由Jack Jiang实现，它是表格单元获得焦点时的边框（类似的功能在windows LNF下是一个距形虚线框）
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 一些说明 END
class FocusCellHighlightBorder extends AbstractBorder
{
	
	/* (non-Javadoc)
	 * @see javax.swing.border.AbstractBorder#getBorderInsets(java.awt.Component)
	 */
	public Insets getBorderInsets(Component c)       
	{
		return new Insets(0,3,0,1);
	}

	/* (non-Javadoc)
	 * @see javax.swing.border.AbstractBorder#getBorderInsets(java.awt.Component, java.awt.Insets)
	 */
	public Insets getBorderInsets(Component c, Insets insets) 
	{
		return getBorderInsets(c);
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.border.AbstractBorder#paintBorder(java.awt.Component, java.awt.Graphics, int, int, int, int)
	 */
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
	{
		//在左边划一条2像素宽的竖线
		g.setColor(UIManager.getColor("Table.focusCellHighlightBorderColor"));
		g.fillRect(x, y, 2, height );//上下各空白一个像素，目的是为了与render的N9图片背景配合形成更好的视觉效果
		
		//再在上面的竖线右边划一条1像素宽的亮色竖线，以便为上面的2像素竖线营造立体效果
		/* ~~注：这个属性是jb2011为了更好的ui效果自已加的属性，目的是使Table.focusCellHighlightBorder有点立体效果哦 */
		g.setColor(UIManager.getColor("Table.focusCellHighlightBorderHighlightColor"));
		g.fillRect(x+2, y, 1, height );
	}
}