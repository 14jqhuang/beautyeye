/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * RawCache.java at 2012-9-24 17:22:54, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.utils;

import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * 本地磁盘资源文件缓存中心超类，子类可继承本类以实现磁盘资源的集中缓存.
 *
 * @param <T> the generic type
 * @author Jack Jiang(jb2011@163.com), 2010-09-11
 * @version 1.0
 */
public abstract class RawCache<T>
{
	
	/** 本地磁盘资源缓存中心（key=path,value=image对象）. */
	private HashMap<String,T> rawCache = new HashMap<String,T>();
	
	/**
	 * 本地磁盘资源（如果缓存中已存在，则从中取之，否则从磁盘读取并缓存之）。.
	 *
	 * @param relativePath 本地磁盘资源相对于baseClass类的相对路径，比如它如果在/res/imgs/pic/下，baseClass在
	 * /res下，则本地磁盘资源此处传过来的相对路径应该是/imgs/pic/some.png
	 * @param baseClass 基准类，指定此类则获取本地磁盘资源时会以此类为基准取本地磁盘资源的相对物理目录
	 * @return T
	 */
	public T getRaw(String relativePath,Class baseClass)
	{
		T ic=null;
		
		String key = relativePath+baseClass.getCanonicalName();
		if(rawCache.containsKey(key))
			ic = rawCache.get(key);
		else
		{
			try
			{
				ic = getResource(relativePath, baseClass);
				rawCache.put(key, ic);
			}
			catch (Exception e)
			{
				System.out.println("取本地磁盘资源文件出错,path="+key+","+e.getMessage());
				e.printStackTrace();
			}
		}
		return ic;
	}
	
	/**
	 * 本地资源获取方法实现.
	 *
	 * @param relativePath 相对路径
	 * @param baseClass 基准类
	 * @return the resource
	 */
	protected abstract T getResource(String relativePath,Class baseClass);
}
