/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * NinePatchBorder.java at 2012-9-24 17:23:03, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.widget.border;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.border.AbstractBorder;

import com.android.ninepatch.NinePatch;

// TODO: Auto-generated Javadoc
/**
 * 一个利用NinePatch图实现边框的border实现类.
 * <p>
 * 本类可以很好地被重用于NinePatch图作为border实现的场景哦.
 * 
 * @author Jack Jiang(jb2011@163.com), 2012-09-04
 * @version 1.0
 */
public class NinePatchBorder extends AbstractBorder
{
	
	/** The insets. */
	private Insets insets = null;
	
	/** The np. */
	private NinePatch np = null;
	
	/**
	 * Instantiates a new nine patch border.
	 *
	 * @param insets the insets
	 * @param np the np
	 */
	public NinePatchBorder(Insets insets, NinePatch np)
	{
		this.insets = insets;
		this.np = np;
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.border.AbstractBorder#getBorderInsets(java.awt.Component)
	 */
	public Insets getBorderInsets(Component c)       
	{
		return insets;
	}

	/* (non-Javadoc)
	 * @see javax.swing.border.AbstractBorder#getBorderInsets(java.awt.Component, java.awt.Insets)
	 */
	public Insets getBorderInsets(Component c, Insets insets) 
	{
		return insets;
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.border.AbstractBorder#paintBorder(java.awt.Component, java.awt.Graphics, int, int, int, int)
	 */
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
	{
		this.np.draw((Graphics2D)g, x, y, width, height);
	}
}
