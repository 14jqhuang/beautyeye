/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * WindowTranslucencyHelper.java at 2012-9-24 17:22:54, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.utils;

import java.awt.Color;
import java.awt.Window;

// TODO: Auto-generated Javadoc
//* ����java֧�ִ���͸������ϸ��Ϣ�����http://docs.oracle.com/javase/tutorial/uiswing/misc/trans_shaped_windows.html#uniform

//* ����java1.6.0_10��Ĵ���͸������һ��BUG��
//* BUG���Ĵ���Exception in thread "AWT-EventQueue-0" java.lang.IllegalArgumentException: Width (0) and height (0) cannot be <= 0
//* �ٷ�BUG ID ��6750920����ַ��http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=6750920
//* ��BUG�������:java1.6.0_12��realease note��ַ��http://www.oracle.com/technetwork/java/javase/6u12-137788.html
/**
 * The Class WindowTranslucencyHelper.
 */
public class WindowTranslucencyHelper
{
//	public static boolean isWindowTranslucencySupported(Class cTranslucency, Object param)
//	{
//		try
//		{
//			if(JVM.current().isOrLater(JVM.JDK1_6N))
//			{
//				if(JVM.current().isOrLater(JVM.JDK1_7))
//				{
//					Method m = GraphicsDevice.class.getMethod("isWindowTranslucencySupported", cTranslucency);
//					boolean is = (Boolean)(m.invoke(null, param));
//					return is;
//				}
//				else
//				{
//					Class c = Class.forName("com.sun.awt.AWTUtilities");
//					Method m = c.getMethod("isTranslucencySupported", cTranslucency);
//					boolean is = (Boolean)(m.invoke(null, param));
//					return is;
//				}
//			}
//			else
//			{
//				return false;
//			}
//		}
//		catch (Exception e)
//		{
//			return false;
//		}
//	}
	
	/**
	 * Sets the opacity.
	 *
	 * @param w the w
	 * @param opacity the opacity
	 */
	public static void setOpacity(Window w, float opacity)
	{
		try
		{
//			com.sun.awt.AWTUtilities.setWindowOpacity(w, opacity);
			//1.6.0_u12���Ժ�汾
			if(JVM.current().isOneDotSixUpdate12OrAfter())//JDK1_6_U10//ΪʲôҪ��u12��֧�֣���u10��Ĵ���͸������BUG 6750920
			{
				//1.7.0���Ժ�汾
				if(JVM.current().isOrLater(JVM.JDK1_7))
					ReflectHelper.invokeMethod(Window.class, w, "setOpacity"
							, new Class[]{float.class}, new Object[]{opacity});
				else
					ReflectHelper.invokeStaticMethod("com.sun.awt.AWTUtilities", "setWindowOpacity"
							, new Class[]{Window.class, float.class}, new Object[]{w, opacity});
			}
			else
				System.err.println("����JRE��֧��ÿ���ذ�͸��(��jre1.6_u12�����ϰ汾)��BeautyEye��۽����ܴﵽ����Ӿ�Ч��Ŷ.");
		}
		catch (Exception e)
		{
			System.err.println("����JRE��֧��ÿ���ذ�͸��(��jre1.6_u12�����ϰ汾)��BeautyEye��۽����ܴﵽ����Ӿ�Ч��Ŷ."+e.getMessage());
		}
	}
	
	/**
	 * Sets the window opaque.
	 *
	 * @param w the w
	 * @param opaque the opaque
	 */
	public static void setWindowOpaque(Window w, boolean opaque)
	{
		try
		{
//			com.sun.awt.AWTUtilities.setWindowOpaque(w, opaque);
			//1.6.0_u12���Ժ�汾
			if(JVM.current().isOneDotSixUpdate12OrAfter())//JDK1_6_U10//ΪʲôҪ��u12��֧�֣���u10��Ĵ���͸������BUG 6750920
			{
				//1.7.0���Ժ�汾
				if(JVM.current().isOrLater(JVM.JDK1_7))
				{
//					if(isWindowTranslucencySupported())
					Color bgc = w.getBackground();
					//* 2012-09-22 ��Jack Jiangע�ͣ���Ⱥ�ѻ����ϣ�win7+java1.7.0.1��������ϵͳ��
					//* ��ʹ��BeautyEye��ʱw.getBackground()����ֵ��null����Ϊʲô������null��Jack û
					//* �в������Jack���Զ��������ģ���������Ϊ����ϵͳ����������ɣ��ڴ��ݴ�һ��
					if(bgc == null)
						bgc = Color.black;//�ݲ�֪���ô˺�ɫ��Ϊ�ݴ�ֵ�ϲ�����
					Color newBgn = new Color(bgc.getRed(),bgc.getGreen(), bgc.getBlue(), opaque?255:0);
					w.setBackground(newBgn);
				}
				else
					ReflectHelper.invokeStaticMethod("com.sun.awt.AWTUtilities", "setWindowOpaque"
							, new Class[]{Window.class, boolean.class}, new Object[]{w, opaque});
			}
			else
				System.err.println("����JRE��֧�ִ���͸��(��jre1.6_u12�����ϰ汾)��BeautyEye��۽����ܴﵽ����Ӿ�Ч��Ŷ.");
		}
		catch (Exception e)
		{
			System.err.println("����JRE��֧�ִ���͸��(��jre1.6_u12�����ϰ汾)��BeautyEye��۽����ܴﵽ����Ӿ�Ч��Ŷ."+e.getMessage());
//			e.printStackTrace();
		}
	}
}
