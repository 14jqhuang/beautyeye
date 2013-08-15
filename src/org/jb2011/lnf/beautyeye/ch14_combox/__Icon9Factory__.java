/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * __Icon9Factory__.java at 2012-9-24 17:21:36, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch14_combox;

import org.jb2011.lnf.beautyeye.utils.NinePatchHelper;
import org.jb2011.lnf.beautyeye.utils.RawCache;

import com.android.ninepatch.NinePatch;

// TODO: Auto-generated Javadoc
/**
 * The Class __Icon9Factory__.
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
	 * Gets the button arrow_normal.
	 *
	 * @return the button arrow_normal
	 */
	public NinePatch getButtonArrow_normal()
	{
		return getRaw(IMGS_ROOT+"/button_arrow.9.png");
	}
	
	/**
	 * Gets the button arrow_pressed.
	 *
	 * @return the button arrow_pressed
	 */
	public NinePatch getButtonArrow_pressed()
	{
		return getRaw(IMGS_ROOT+"/button_arrow_pressed.9.png");
	}
	
	/**
	 * Gets the button arrow_disable.
	 *
	 * @return the button arrow_disable
	 */
	public NinePatch getButtonArrow_disable()
	{
		return getRaw(IMGS_ROOT+"/button_arrow_disable.9.png");
	}
	
	
	
}