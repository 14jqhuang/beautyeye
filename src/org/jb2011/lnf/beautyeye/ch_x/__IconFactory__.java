/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * __IconFactory__.java at 2012-9-24 17:19:28, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch_x;

import javax.swing.ImageIcon;

import org.jb2011.lnf.beautyeye.utils.RawCache;

// TODO: Auto-generated Javadoc
/**
 * ��ͨͼƬ������.
 * 
 * @author Jack Jiang
 * @version 1.0
 */
public class __IconFactory__ extends RawCache<ImageIcon>
{
	
	/** ���·������Ĭ��������ڱ�����������·����. */
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
	 * Gets the table descending sort icon.
	 *
	 * @return the table descending sort icon
	 */
	public ImageIcon getTableDescendingSortIcon()
	{
		return getImage(IMGS_ROOT+"/desc2.png");
	}
	
	/**
	 * Gets the table ascending sort icon.
	 *
	 * @return the table ascending sort icon
	 */
	public ImageIcon getTableAscendingSortIcon()
	{
		return getImage(IMGS_ROOT+"/asc2.png");
	}

	/**
	 * Ĭ�����ڵ��ʱ��ͼ��.
	 *
	 * @return the tree default open icon_16_16
	 */
	public ImageIcon getTreeDefaultOpenIcon_16_16()
	{
		return getImage(IMGS_ROOT+"/treeDefaultOpen1.png");
	}
	
	/**
	 * Ĭ�����ڵ�����ʱ��ͼ��.
	 *
	 * @return the tree default closed icon_16_16
	 */
	public ImageIcon getTreeDefaultClosedIcon_16_16()
	{
		return getImage(IMGS_ROOT+"/treeDefaultClosed1.png");
	}
	
	/**
	 * Ĭ����Ҷͼ��.
	 *
	 * @return the tree default leaf icon_16_16
	 */
	public ImageIcon getTreeDefaultLeafIcon_16_16()
	{
		return getImage(IMGS_ROOT+"/leaf1.png");
	}
	
	/**
	 * Gets the option pane warn icon.
	 *
	 * @return the option pane warn icon
	 */
	public ImageIcon getOptionPaneWARNIcon()
	{
		return getImage(IMGS_ROOT+"/warn.png");
	}
	
	/**
	 * Gets the option pane error icon.
	 *
	 * @return the option pane error icon
	 */
	public ImageIcon getOptionPaneERRORIcon()
	{
		return getImage(IMGS_ROOT+"/error.png");
	}
	
	/**
	 * Gets the option pane info icon.
	 *
	 * @return the option pane info icon
	 */
	public ImageIcon getOptionPaneINFOIcon()
	{
		return getImage(IMGS_ROOT+"/info.png");
	}
	
	/**
	 * Gets the option pane question icon.
	 *
	 * @return the option pane question icon
	 */
	public ImageIcon getOptionPaneQUESTIONIcon()
	{
		return getImage(IMGS_ROOT+"/question.png");
	}
}
