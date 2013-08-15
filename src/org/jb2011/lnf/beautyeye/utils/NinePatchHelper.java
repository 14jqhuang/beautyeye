/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * NinePatchHelper.java at 2012-9-24 17:22:54, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.utils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import com.android.ninepatch.NinePatch;

// TODO: Auto-generated Javadoc
/**
 * NinePatchÍ¼¸¨Öú¹¤³§Àà.
 * 
 * @author Jack Jiang(jb2011@163.com), 2011-12-22
 * @version 1.0
 */
public class NinePatchHelper
{
	
	/**
	 * Creates the nine patch.
	 *
	 * @param fileUrl the file url
	 * @param convert the convert
	 * @return the nine patch
	 * @see NinePatch#load(URL, boolean)
	 */
	public static NinePatch createNinePatch(URL fileUrl, boolean convert)
	{
		try
		{
			return NinePatch.load(fileUrl, convert);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Creates the nine patch.
	 *
	 * @param stream the stream
	 * @param is9Patch the is9 patch
	 * @param convert the convert
	 * @return the nine patch
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see NinePatch#load(InputStream, boolean, boolean)
	 */
	public static NinePatch createNinePatch(InputStream stream, boolean is9Patch,boolean convert) throws IOException
	{
		return NinePatch.load(stream, is9Patch, convert);
	}
	
	/**
	 * Creates the nine patch.
	 *
	 * @param image the image
	 * @param is9Patch the is9 patch
	 * @param convert the convert
	 * @return the nine patch
	 * @see NinePatch#load(BufferedImage, boolean, boolean)
	 */
	public static NinePatch createNinePatch(BufferedImage image, boolean is9Patch,boolean convert)
	{
		return NinePatch.load(image, is9Patch, convert);
	}
}
