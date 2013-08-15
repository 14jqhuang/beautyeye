/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * __Icon9Factory__.java at 2012-9-24 17:21:09, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch12_progress;

import org.jb2011.lnf.beautyeye.utils.NinePatchHelper;
import org.jb2011.lnf.beautyeye.utils.RawCache;

import com.android.ninepatch.NinePatch;

// TODO: Auto-generated Javadoc
/**
 * NinePatch图片（*.9.png）工厂类.
 * 
 * @author Jack Jiang
 * @version 1.0
 */
public class __Icon9Factory__ extends RawCache<NinePatch>
{
	
	/** 相对路径根（默认是相对于本类的相对物理路径）. */
	public final static String IMGS_ROOT="imgs/np";

	/** The instance. */
	private static __Icon9Factory__ instance = null;

	/**
	 * Gets the single instance of __Icon9Factory__.
	 *
	 * @return single instance of __Icon9Factory__
	 */
	public static __Icon9Factory__ getInstance()
	{
		if(instance==null)
			instance = new __Icon9Factory__();
		return instance;
	}
	
	/* (non-Javadoc)
	 * @see org.jb2011.lnf.beautyeye.utils.RawCache#getResource(java.lang.String, java.lang.Class)
	 */
	@Override
	protected NinePatch getResource(String relativePath, Class baseClass)
	{
		return NinePatchHelper.createNinePatch(baseClass.getResource(relativePath), false);
	}

	/**
	 * Gets the raw.
	 *
	 * @param relativePath the relative path
	 * @return the raw
	 */
	public NinePatch getRaw(String relativePath)
	{
		return  getRaw(relativePath,this.getClass());
	}
	
	/**
	 * Gets the progress bar bg.
	 *
	 * @return the progress bar bg
	 */
	public NinePatch getProgressBarBg()
	{
		return getRaw(IMGS_ROOT+"/progress_bar_bg.9.png");
	}
	
	/**
	 * Gets the progress bar bg_v.
	 *
	 * @return the progress bar bg_v
	 */
	public NinePatch getProgressBarBg_v()
	{
		return getRaw(IMGS_ROOT+"/progress_bar_bg_v.9.png");
	}
	
	/**
	 * Gets the progress bar_green.
	 *
	 * @return the progress bar_green
	 */
	public NinePatch getProgressBar_green()
	{
		return getRaw(IMGS_ROOT+"/progress_bar_green.9.png");
	}
	
	/**
	 * Gets the progress bar_blue_v.
	 *
	 * @return the progress bar_blue_v
	 */
	public NinePatch getProgressBar_blue_v()
	{
		return getRaw(IMGS_ROOT+"/progress_bar_grean_v.9.png");//progress_bar_green
	}
}