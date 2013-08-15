/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * __Icon9Factory__.java at 2012-9-24 17:22:48, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch8_toolbar;

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

	
//	public NinePatch getToggleButtonIcon_CheckedGreen()
//	{
//		return getRaw(IMGS_ROOT+"/toggle_button_selected.9.png");
//	}
	
	/**
 * Gets the tool bar bg_ north.
 *
 * @return the tool bar bg_ north
 */
public NinePatch getToolBarBg_NORTH()
	{
		return getRaw(IMGS_ROOT+"/toolbar_bg1.9.png");
	}
	
	/**
	 * Gets the tool bar bg_ south.
	 *
	 * @return the tool bar bg_ south
	 */
	public NinePatch getToolBarBg_SOUTH()
	{
		return getRaw(IMGS_ROOT+"/toolbar_bg1_SOUTH.9.png");
	}
	
	/**
	 * Gets the tool bar bg_ west.
	 *
	 * @return the tool bar bg_ west
	 */
	public NinePatch getToolBarBg_WEST()
	{
		return getRaw(IMGS_ROOT+"/toolbar_bg1_WEST.9.png");
	}
	
	/**
	 * Gets the tool bar bg_ east.
	 *
	 * @return the tool bar bg_ east
	 */
	public NinePatch getToolBarBg_EAST()
	{
		return getRaw(IMGS_ROOT+"/toolbar_bg1_EAST.9.png");
	}
	
	/**
	 * Gets the tool bar border_ h_ float touch.
	 *
	 * @return the tool bar border_ h_ float touch
	 */
	public NinePatch getToolBarBorder_H_FloatTouch()
	{
		return getRaw(IMGS_ROOT+"/tollbar_border_h_float_touch.9.png");
	}
	
	/**
	 * Gets the tool bar border_ v_ float touch.
	 *
	 * @return the tool bar border_ v_ float touch
	 */
	public NinePatch getToolBarBorder_V_FloatTouch()
	{
		return getRaw(IMGS_ROOT+"/tollbar_border_v_float_touch.9.png");
	}
	
	
}