/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * __Icon9Factory__.java at 2012-9-24 17:21:57, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch15_slider;

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
	 * Gets the slider track.
	 *
	 * @return the slider track
	 */
	public NinePatch getSliderTrack()
	{
		return getRaw(IMGS_ROOT+"/slider_track2.9.png");
	}
	
	/**
	 * Gets the slider track_ veritical.
	 *
	 * @return the slider track_ veritical
	 */
	public NinePatch getSliderTrack_VERITICAL()
	{
		return getRaw(IMGS_ROOT+"/slider_track2_v.9.png");
	}
	
	/**
	 * Gets the slider track_disable.
	 *
	 * @return the slider track_disable
	 */
	public NinePatch getSliderTrack_disable()
	{
		return getRaw(IMGS_ROOT+"/slider_track2_dark.9.png");
	}
	
	/**
	 * Gets the slider track_ veritica l_disable.
	 *
	 * @return the slider track_ veritica l_disable
	 */
	public NinePatch getSliderTrack_VERITICAL_disable()
	{
		return getRaw(IMGS_ROOT+"/slider_track2_v_dark.9.png");
	}
	
	/**
	 * Gets the slider track_forground.
	 *
	 * @return the slider track_forground
	 */
	public NinePatch getSliderTrack_forground()
	{
		return getRaw(IMGS_ROOT+"/slider_track2_forgroud.9.png");
	}
	
	/**
	 * Gets the slider track_forground_disable.
	 *
	 * @return the slider track_forground_disable
	 */
	public NinePatch getSliderTrack_forground_disable()
	{
		return getRaw(IMGS_ROOT+"/slider_track2_forgroud_disable.9.png");
	}
	
	/**
	 * Gets the slider track_ vertica l_forground.
	 *
	 * @return the slider track_ vertica l_forground
	 */
	public NinePatch getSliderTrack_VERTICAL_forground()
	{
		return getRaw(IMGS_ROOT+"/slider_track2_forgroud_v.9.png");
	}
	
	/**
	 * Gets the slider track_ vertica l_forground_disable.
	 *
	 * @return the slider track_ vertica l_forground_disable
	 */
	public NinePatch getSliderTrack_VERTICAL_forground_disable()
	{
		return getRaw(IMGS_ROOT+"/slider_track2_forgroud_v_disable.9.png");
	}
	
}