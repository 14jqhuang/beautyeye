/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * __UI__.java at 2012-9-24 17:22:22, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch18_spinner;

import java.awt.Dimension;

import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.InsetsUIResource;

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
		UIManager.put("Spinner.background",new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));
		UIManager.put("Spinner.foreground",new ColorUIResource(BeautyEyeLNFHelper.commonForegroundColor));
		UIManager.put("SpinnerUI", org.jb2011.lnf.beautyeye.ch18_spinner.BESpinnerUI.class.getName());
		
		//Spinner����ı߿�
		UIManager.put("Spinner.border", new BorderUIResource(new EmptyBorder(5, 5, 10, 5)));//windows lnf��Ĭ����3, 3, 3, 3
		//Spinner�����2����ͷ��ť���ڳľ�
		UIManager.put("Spinner.arrowButtonInsets", new InsetsUIResource(1,0,2,2));//windows lnf��Ĭ����1,1,1,1
		//Spinner�����2����ͷ��ť��Ĭ�ϴ�С
		UIManager.put("Spinner.arrowButtonSize",new Dimension(17,9));//windows lnf��Ĭ����17,9
	}
}
