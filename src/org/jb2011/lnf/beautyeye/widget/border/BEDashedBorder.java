/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BEDashedBorder.java at 2012-9-24 17:23:02, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.widget.border;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.border.LineBorder;
import javax.swing.plaf.UIResource;

import org.jb2011.lnf.beautyeye.utils.BEUtils;

// TODO: Auto-generated Javadoc
/**
 * ���߱߿�Border.
 * 
 * @author Jack Jiang(jb2011@163.com)
 */
public class BEDashedBorder extends LineBorder implements UIResource 
{
	
	/** ���߶λ��Ʋ���. */
	private int step = 3;
	
	/** The right. */
	private boolean top = true,left = true,bottom = true,right = true;
	
	/**
	 * Instantiates a new bE dashed border.
	 *
	 * @param color the color
	 * @param top the top
	 * @param left the left
	 * @param bottom the bottom
	 * @param right the right
	 */
	public BEDashedBorder(Color color,boolean top,boolean left,boolean bottom,boolean right) 
	{
		super(color);
		this.top = top;
		this.left = left;
		this.bottom = bottom;
		this.right = right;
	}

	/**
	 * ���췽��.
	 *
	 * @param color ������ɫ
	 * @param thickness �߿���
	 * @param step ����
	 * @param top the top
	 * @param left the left
	 * @param bottom the bottom
	 * @param right the right
	 */
	public BEDashedBorder(Color color, int thickness,int step
			,boolean top,boolean left,boolean bottom,boolean right) 
	{
		super(color, thickness);
		this.step=step;
		this.top = top;
		this.left = left;
		this.bottom = bottom;
		this.right = right;
	}

	/* (non-Javadoc)
	 * @see javax.swing.border.LineBorder#paintBorder(java.awt.Component, java.awt.Graphics, int, int, int, int)
	 */
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
	{
		Color oldColor = g.getColor();
		int i;

		g.setColor(lineColor);
		for(i = 0; i < thickness; i++)  
			BEUtils.drawDashedRect(g, x+i, y+i, width-i-i, height-i-i,step,top,left,bottom,right);
		g.setColor(oldColor);
	}
}