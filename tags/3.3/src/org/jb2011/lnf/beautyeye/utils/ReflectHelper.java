/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * ReflectHelper.java at 2012-9-24 17:22:54, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.utils;

import java.lang.reflect.Method;
import java.util.Arrays;

// TODO: Auto-generated Javadoc
/**
 * �ṩ�˷��䷽�㷽���ĸ�����.
 * 
 * @author Jack Jiang(jb2011@163.com), 2012-08-29
 * @version 1.0
 */
public class ReflectHelper
{
	/**
	 * ͨ���������ָ��������ָ����̬����.
	 * 
	 * @param theClassFullName ��ȫ�������磺javax.swing.JTable
	 * @param methodName Ҫ���õķ�����
	 * @param paramsType Ҫ���õķ����������ͣ��޲�����null
	 * @param paramsValue Ҫ���õķ�������ֵ���޲���ֵ��null
	 * @return ����÷����з���ֵ�����������򷵻ظ�ֵ�����򷵻�null
	 */
	public static Object invokeStaticMethod(String theClassFullName, String methodName
			, Class[] paramsType, Object[] paramsValue)
	{
		return invokeStaticMethod(getClass(theClassFullName), methodName, paramsType, paramsValue);
	}
	/**
	 * ͨ���������ָ��Class�����ָ����̬����.
	 * 
	 * @param theClass ��
	 * @param methodName Ҫ���õķ�����
	 * @param paramsType Ҫ���õķ����������ͣ��޲�����null
	 * @param paramsValue Ҫ���õķ�������ֵ���޲���ֵ��null
	 * @return ����÷����з���ֵ�����������򷵻ظ�ֵ�����򷵻�null
	 */
	public static Object invokeStaticMethod(Class theClass, String methodName
			, Class[] paramsType, Object[] paramsValue)
	{
		return invokeMethod(theClass, theClass, methodName, paramsType, paramsValue);
	}
	
	/**
	 * ͨ���������ָ��Class�����ָ��������������̬������ʵ��������.
	 * 
	 * @param theClassFullName ��ȫ�������磺javax.swing.JTable
	 * @param theObject Ҫ���÷�������Ӧ����������Ҫ���õ��Ǿ�̬�����򱾲�����theClassFullName��ͬһ��Class����Ŷ
	 * @param methodName Ҫ���õķ�����
	 * @param paramsType Ҫ���õķ����������ͣ��޲�����null
	 * @param paramsValue Ҫ���õķ�������ֵ���޲���ֵ��null
	 * @return ����÷����з���ֵ�����������򷵻ظ�ֵ�����򷵻�null
	 */
	public static Object invokeMethod(String theClassFullName, Object theObject, String methodName
			, Class[] paramsType, Object[] paramsValue)
	{
		Class theClass = getClass(theClassFullName);
		//��̬�����ı����ö������������Class������Ŷ
		return invokeMethod(theClass, theClass, methodName, paramsType, paramsValue);
	}
	/**
	 * ͨ���������ָ��Class�����ָ��������������̬������ʵ��������.
	 * 
	 * @param theClass ��
	 * @param theObject Ҫ���÷�������Ӧ����������Ҫ���õ��Ǿ�̬�����򱾲�����theClass��ͬһ��Class����Ŷ
	 * @param methodName Ҫ���õķ�����
	 * @param paramsType Ҫ���õķ����������ͣ��޲�����null
	 * @param paramsValue Ҫ���õķ�������ֵ���޲���ֵ��null
	 * @return ����÷����з���ֵ�����������򷵻ظ�ֵ�����򷵻�null
	 */
	public static Object invokeMethod(Class theClass, Object theObject, String methodName
			, Class[] paramsType, Object[] paramsValue)
	{
		Object ret = null;
		if(theClass != null)
		{
			try
			{
				Method m = theClass.getMethod(methodName, paramsType);
				ret = m.invoke(theObject, paramsValue);
//				 System.out.println("@ͨ��������÷���"+theClass.getName()+"."+methodName
//										   +"("+Arrays.toString(paramsType)+")�ɹ�.");
			}
			catch (Exception e)
			{
				e.printStackTrace();
				System.err.println("@����ͨ��������÷���"+theClass.getName()+"."+methodName
						+"("+Arrays.toString(paramsType)+")ʧ�ܣ�����JRE�汾������Ҫ���£�"+e.getMessage());
			}
		}
		return ret;
	}

	/**
	 * ͨ��������ָ��ȫ������Class����.
	 * 
	 * @param className ȫ���������磺javax.swing.JTable
	 * @return ����ɹ��򷵻ظ����Class���󣬷��򷵻�null
	 */
	public static Class getClass(String className)
	{
		try
		{
			return Class.forName(className);
		}
		catch (Exception e)
		{
			System.err.println("����ͨ��������"+className+"��Class����ʧ�ܣ�����JRE�汾������Ҫ���£�"+e.getMessage());
			return null;
		}
	}
}
