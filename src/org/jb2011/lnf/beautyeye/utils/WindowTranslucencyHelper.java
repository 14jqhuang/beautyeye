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
//* 关于java支持窗口透明的详细信息请见：http://docs.oracle.com/javase/tutorial/uiswing/misc/trans_shaped_windows.html#uniform

//* 关于java1.6.0_10里的窗口透明存在一个BUG：
//* BUG出的错误：Exception in thread "AWT-EventQueue-0" java.lang.IllegalArgumentException: Width (0) and height (0) cannot be <= 0
//* 官方BUG ID ：6750920，地址：http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=6750920
//* 该BUG被解决于:java1.6.0_12，realease note地址：http://www.oracle.com/technetwork/java/javase/6u12-137788.html
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
			//1.6.0_u12及以后版本
			if(JVM.current().isOneDotSixUpdate12OrAfter())//JDK1_6_U10//为什么要到u12才支持？因u10里的窗口透明存在BUG 6750920
			{
				//1.7.0及以后版本
				if(JVM.current().isOrLater(JVM.JDK1_7))
					ReflectHelper.invokeMethod(Window.class, w, "setOpacity"
							, new Class[]{float.class}, new Object[]{opacity});
				else
					ReflectHelper.invokeStaticMethod("com.sun.awt.AWTUtilities", "setWindowOpacity"
							, new Class[]{Window.class, float.class}, new Object[]{w, opacity});
			}
			else
				System.err.println("您的JRE不支持每像素半透明(需jre1.6_u12及以上版本)，BeautyEye外观将不能达到最佳视觉效果哦.");
		}
		catch (Exception e)
		{
			System.err.println("您的JRE不支持每像素半透明(需jre1.6_u12及以上版本)，BeautyEye外观将不能达到最佳视觉效果哦."+e.getMessage());
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
			//1.6.0_u12及以后版本
			if(JVM.current().isOneDotSixUpdate12OrAfter())//JDK1_6_U10//为什么要到u12才支持？因u10里的窗口透明存在BUG 6750920
			{
				//1.7.0及以后版本
				if(JVM.current().isOrLater(JVM.JDK1_7))
				{
//					if(isWindowTranslucencySupported())
					Color bgc = w.getBackground();
					//* 2012-09-22 由Jack Jiang注释：在群友机器上（win7+java1.7.0.1）的生产系统下
					//* 下使用BeautyEye有时w.getBackground()返回值是null，但为什么返回是null，Jack 没
					//* 有测出来（Jack测试都是正常的），暂且认为是其系统代码有问题吧，在此容错一下
					if(bgc == null)
						bgc = Color.black;//暂不知道用此黑色作为容错值合不合适
					Color newBgn = new Color(bgc.getRed(),bgc.getGreen(), bgc.getBlue(), opaque?255:0);
					w.setBackground(newBgn);
				}
				else
					ReflectHelper.invokeStaticMethod("com.sun.awt.AWTUtilities", "setWindowOpaque"
							, new Class[]{Window.class, boolean.class}, new Object[]{w, opaque});
			}
			else
				System.err.println("您的JRE不支持窗口透明(需jre1.6_u12及以上版本)，BeautyEye外观将不能达到最佳视觉效果哦.");
		}
		catch (Exception e)
		{
			System.err.println("您的JRE不支持窗口透明(需jre1.6_u12及以上版本)，BeautyEye外观将不能达到最佳视觉效果哦."+e.getMessage());
//			e.printStackTrace();
		}
	}
}
