/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * ImageBgPanel.java at 2012-9-24 17:22:59, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.widget;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.android.ninepatch.NinePatch;

// TODO: Auto-generated Javadoc
/**
 * һ��ʹ��NinePatchͼ��Ϊ���������ʵ����.
 * 
 * @author Jack Jiang(jb2011@163.com)
 */
public class ImageBgPanel extends JPanel
{
	
	/** The draw bg. */
	private boolean drawBg = true;
	
	/** The n9. */
	private NinePatch n9 = null;
	
	/**
	 * Instantiates a new image bg panel.
	 */
	public ImageBgPanel()
	{
		this.setOpaque(false);
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintChildren(java.awt.Graphics)
	 */
	public void paintChildren(Graphics g)
	{
		if(drawBg && n9 != null)
			n9.draw((Graphics2D)g, 0, 0, this.getWidth(), this.getHeight());
		super.paintChildren(g);
	}

	/**
	 * ��д���෽������ʵ����ӵ����������������͸�����ǰ��ֶ�childOpaqueָ���ķ�ʽ����.
	 *
	 * @param comp the comp
	 * @param constraints the constraints
	 * @param index the index
	 */
	protected void addImpl(Component comp, Object constraints, int index) 
	{
		if(comp!=null&&comp instanceof JComponent)
			((JComponent)comp).setOpaque(false);
		super.addImpl(comp,constraints,index);
	}

	/**
	 * Checks if is draw bg.
	 *
	 * @return true, if is draw bg
	 */
	public boolean isDrawBg()
	{
		return drawBg;
	}
	
	/**
	 * Sets the draw bg.
	 *
	 * @param drawBg the draw bg
	 * @return the image bg panel
	 */
	public ImageBgPanel setDrawBg(boolean drawBg)
	{
		this.drawBg = drawBg;
		return this;
	}

	/**
	 * Gets the n9.
	 *
	 * @return the n9
	 */
	public NinePatch getN9()
	{
		return n9;
	}
	
	/**
	 * Sets the n9.
	 *
	 * @param n9 the n9
	 * @return the image bg panel
	 */
	public ImageBgPanel setN9(NinePatch n9)
	{
		this.n9 = n9;
		return this;
	}
}