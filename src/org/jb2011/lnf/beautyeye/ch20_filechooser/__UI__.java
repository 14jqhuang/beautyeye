/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * __UI__.java at 2012-9-24 17:22:31, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch20_filechooser;

import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;


// TODO: Auto-generated Javadoc
/**
 * The Class __UI__.
 */
public class __UI__
{
	//
	/**
	 * Ui impl.
	 */
	public static void uiImpl()
	{
		//�ļ��鿴�б�ı߿�ʵ��
		UIManager.put("FileChooser.listViewBorder"
				, new BorderUIResource(new org.jb2011.lnf.beautyeye.ch4_scroll.ScrollPaneBorder()));//com.sun.java.swing.plaf.windows.XPStyle.XPFillBorder);
		//����ɫ������windowsƽ̨���ļ�ѡ���������WindowsPlaceBar�ı���ɫ
		UIManager.put("ToolBar.shadow",new ColorUIResource(new Color(249,248,243)));
	}
	
	//����������Windowsƽ̨ʹ��
	/**
	 * Ui impl_win.
	 */
	public static void uiImpl_win()
	{
		//JFileChooser��UIʵ��ʹ��windowsƽ̨��ۺ���ΪUI������û�����
		UIManager.put("FileChooserUI"
				,org.jb2011.lnf.beautyeye.ch20_filechooser.BEFileChooserUIWin.class.getName());
	}
	
	//����������ͨ�ÿ�ƽ̨����ʹ��
	/**
	 * Ui impl_cross.
	 */
	public static void uiImpl_cross()
	{
		UIManager.put("FileChooserUI"
				,org.jb2011.lnf.beautyeye.ch20_filechooser.BEFileChooserUICross.class.getName());
	}
}
