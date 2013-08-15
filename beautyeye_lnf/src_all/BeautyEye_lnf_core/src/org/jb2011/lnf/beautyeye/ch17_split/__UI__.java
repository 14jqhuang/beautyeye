/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * __UI__.java at 2012-9-24 17:22:19, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch17_split;

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
	
	/**
	 * Ui impl.
	 */
	public static void uiImpl()
	{
		UIManager.put("SplitPane.shadow",new ColorUIResource(new Color(200,200,200)));// ��������BE LNF����ʱû�õ�
		//JSplitePane��Ĭ�ϱ���ɫ
		UIManager.put("SplitPane.background",new ColorUIResource(new Color(250,250,250)));//238,241,243)));
		//JSplitePane�ı߿�ʵ��
		UIManager.put("SplitPane.border",new BorderUIResource(new org.jb2011.lnf.beautyeye.ch4_scroll.ScrollPaneBorder()));//BorderFactory.createEmptyBorder(0, 0, 0, 0)));
		UIManager.put("SplitPaneUI",org.jb2011.lnf.beautyeye.ch17_split.BESplitPaneUI.class.getName());
		
		//�ָ����϶�ʱ����ɫ��˵������ֵ��������alphaͨ���Ա�ﵽ��͸��Ч��Ŷ��
		UIManager.put("SplitPaneDivider.draggingColor",new ColorUIResource(new Color(0,0,0,50)));
		//������ť��Ĭ�ϴ�С
		UIManager.put("SplitPane.oneTouchButtonSize",4);//drfault is 5
		//�ָ�����Ĭ�ϴ�С
		UIManager.put("SplitPane.dividerSize",7);//drfault is 5
		//�ָ����ı߿�ʵ��
		UIManager.put("SplitPaneDivider.border",new SplitPaneDividerBorder());
	}
}
