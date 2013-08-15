/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * __Icon9Factory__.java at 2012-9-24 17:22:22, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch18_spinner;

import org.jb2011.lnf.beautyeye.utils.NinePatchHelper;
import org.jb2011.lnf.beautyeye.utils.RawCache;

import com.android.ninepatch.NinePatch;

// TODO: Auto-generated Javadoc
/**
 * NinePatchͼƬ��*.9.png��������.
 * 
 * @author Jack Jiang
 * @version 1.0
 */
public class __Icon9Factory__ extends RawCache<NinePatch>
{
	
	/** ���·������Ĭ��������ڱ�����������·����. */
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
	 * Gets the spinner bg.
	 *
	 * @return the spinner bg
	 */
	public NinePatch getSpinnerBg()
	{
		return getRaw(IMGS_ROOT+"/spinner1_bg.9.png");
	}
	
	/**
	 * Gets the up button bg.
	 *
	 * @return the up button bg
	 */
	public NinePatch getUpButtonBg()
	{
		return getRaw(IMGS_ROOT+"/spinner1_btn_up_bg.9.png");
	}
	
	/**
	 * Gets the down button bg.
	 *
	 * @return the down button bg
	 */
	public NinePatch getDownButtonBg()
	{
		return getRaw(IMGS_ROOT+"/spinner1_btn_down_bg.9.png");
	}
	
	/**
	 * Gets the spinner disable bg.
	 *
	 * @return the spinner disable bg
	 */
	public NinePatch getSpinnerDisableBg()
	{
		return getRaw(IMGS_ROOT+"/spinner1_disable_bg.9.png");
	}
	
	/**
	 * Gets the up button bg_pressed.
	 *
	 * @return the up button bg_pressed
	 */
	public NinePatch getUpButtonBg_pressed()
	{
		return getRaw(IMGS_ROOT+"/spinner1_btn_up_pressed_bg.9.png");
	}
	
	/**
	 * Gets the down button bg_pressed.
	 *
	 * @return the down button bg_pressed
	 */
	public NinePatch getDownButtonBg_pressed()
	{
		return getRaw(IMGS_ROOT+"/spinner1_btn_down_pressed_bg.9.png");
	}
	
}