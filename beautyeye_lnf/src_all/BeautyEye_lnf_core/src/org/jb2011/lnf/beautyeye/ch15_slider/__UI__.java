/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * __UI__.java at 2012-9-24 17:21:57, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch15_slider;

import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;


// TODO: Auto-generated Javadoc
/**
 * The Class __UI__.
 */
public class __UI__
{
	
	/**
	 * Ui impl.
	 */
	public static void uiImpl()
	{
		UIManager.put("Slider.background",new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));
		//JSlider�Ŀ̶��߻�����ɫ
		UIManager.put("Slider.tickColor",new ColorUIResource(new Color(154,154,154)));
		UIManager.put("Slider.foreground",new ColorUIResource(BeautyEyeLNFHelper.commonForegroundColor));
		//��ý���ʱ��insets
//		UIManager.put("Slider.focusInsets",new InsetsUIResource(2,2,7,7));//������Ĭ����2,2,2,2
		//��ý���ʱ�Ľ���߿���ɫ
		UIManager.put("Slider.focus",new ColorUIResource(BeautyEyeLNFHelper.commonFocusedBorderColor));//windows������Ĭ����[r=113,g=111,b=100]
		UIManager.put("SliderUI",org.jb2011.lnf.beautyeye.ch15_slider.BESliderUI.class.getName());
	}
}
