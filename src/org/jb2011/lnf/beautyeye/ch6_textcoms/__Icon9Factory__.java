/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * __Icon9Factory__.java at 2012-9-24 17:22:43, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch6_textcoms;

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
	 * Gets the text field bg normal.
	 *
	 * @return the text field bg normal
	 */
	public NinePatch getTextFieldBgNormal()
	{
		return getRaw(IMGS_ROOT+"/bg_login_text_normal.9.png");
	}
	
	/**
	 * Gets the text field bg focused.
	 *
	 * @return the text field bg focused
	 */
	public NinePatch getTextFieldBgFocused()
	{
		return getRaw(IMGS_ROOT+"/bg_login_text_pressed.9.png");
	}
	
	/**
	 * Gets the text field bg disabled.
	 *
	 * @return the text field bg disabled
	 */
	public NinePatch getTextFieldBgDisabled()
	{
		return getRaw(IMGS_ROOT+"/bg_login_text_disable.9.png");
	}
	
	//һ����ɫ����������JTextArea��JTextPane��JEditorPane����ҪJScrollPane�ĵط�
	/**
	 * Gets the null white bg.
	 *
	 * @return the null white bg
	 */
	public NinePatch getNullWhiteBg()
	{
		return getRaw(IMGS_ROOT+"/null_white_bg.9.png");
	}
}