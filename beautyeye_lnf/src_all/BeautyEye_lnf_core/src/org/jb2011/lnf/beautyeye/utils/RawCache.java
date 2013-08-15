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
 * ���ش�����Դ�ļ��������ĳ��࣬����ɼ̳б�����ʵ�ִ�����Դ�ļ��л���.
 *
 * @param <T> the generic type
 * @author Jack Jiang(jb2011@163.com), 2010-09-11
 * @version 1.0
 */
public abstract class RawCache<T>
{
	
	/** ���ش�����Դ�������ģ�key=path,value=image����. */
	private HashMap<String,T> rawCache = new HashMap<String,T>();
	
	/**
	 * ���ش�����Դ������������Ѵ��ڣ������ȡ֮������Ӵ��̶�ȡ������֮����.
	 *
	 * @param relativePath ���ش�����Դ�����baseClass������·���������������/res/imgs/pic/�£�baseClass��
	 * /res�£��򱾵ش�����Դ�˴������������·��Ӧ����/imgs/pic/some.png
	 * @param baseClass ��׼�ָ࣬���������ȡ���ش�����Դʱ���Դ���Ϊ��׼ȡ���ش�����Դ���������Ŀ¼
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
				System.out.println("ȡ���ش�����Դ�ļ�����,path="+key+","+e.getMessage());
				e.printStackTrace();
			}
		}
		return ic;
	}
	
	/**
	 * ������Դ��ȡ����ʵ��.
	 *
	 * @param relativePath ���·��
	 * @param baseClass ��׼��
	 * @return the resource
	 */
	protected abstract T getResource(String relativePath,Class baseClass);
}
