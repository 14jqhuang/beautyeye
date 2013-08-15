/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * __IconFactory__.java at 2012-9-24 17:22:16, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch16_tree;

import javax.swing.ImageIcon;

import org.jb2011.lnf.beautyeye.utils.RawCache;

// TODO: Auto-generated Javadoc
/**
 * 普通图片工厂类.
 * 
 * @author Jack Jiang
 * @version 1.0
 */
public class __IconFactory__ extends RawCache<ImageIcon>
{
	
	/** 相对路径根（默认是相对于本类的相对物理路径）. */
	public final static String IMGS_ROOT="imgs";

	/** The instance. */
	private static __IconFactory__ instance = null;

	/**
	 * Gets the single instance of __IconFactory__.
	 *
	 * @return single instance of __IconFactory__
	 */
	public static __IconFactory__ getInstance()
	{
		if(instance==null)
			instance = new __IconFactory__();
		return instance;
	}
	
	/* (non-Javadoc)
	 * @see org.jb2011.lnf.beautyeye.utils.RawCache#getResource(java.lang.String, java.lang.Class)
	 */
	@Override
	protected ImageIcon getResource(String relativePath, Class baseClass)
	{
		return new ImageIcon(baseClass.getResource(relativePath));
	}
	
	/**
	 * Gets the image.
	 *
	 * @param relativePath the relative path
	 * @return the image
	 */
	public ImageIcon getImage(String relativePath)
	{
		return  getRaw(relativePath,this.getClass());
	}
	
	/**
	 * 默认树节点打开时的图标.
	 *
	 * @return the tree default open icon_16_16
	 */
	public ImageIcon getTreeDefaultOpenIcon_16_16()
	{
		return getImage(IMGS_ROOT+"/treeDefaultOpen1.png");
	}
	
	/**
	 * 默认树节点收起时的图标.
	 *
	 * @return the tree default closed icon_16_16
	 */
	public ImageIcon getTreeDefaultClosedIcon_16_16()
	{
		return getImage(IMGS_ROOT+"/treeDefaultClosed1.png");
	}
	
	/**
	 * 默认树叶图标.
	 *
	 * @return the tree default leaf icon_16_16
	 */
	public ImageIcon getTreeDefaultLeafIcon_16_16()
	{
		return getImage(IMGS_ROOT+"/leaf1.png");
	}
	
	/**
	 * Gets the tree a.
	 *
	 * @return the tree a
	 */
	public ImageIcon getTreeA()
	{
		return getImage(IMGS_ROOT+"/a.png");
	}
	
	/**
	 * Gets the tree b.
	 *
	 * @return the tree b
	 */
	public ImageIcon getTreeB()
	{
		return getImage(IMGS_ROOT+"/b.png");
	}

}
