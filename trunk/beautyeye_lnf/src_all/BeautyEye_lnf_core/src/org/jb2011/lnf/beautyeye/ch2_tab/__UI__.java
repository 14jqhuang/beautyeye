/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * __UI__.java at 2012-9-24 17:22:28, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch2_tab;

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
		UIManager.put("TabbedPane.background",new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));
		UIManager.put("TabbedPane.foreground",new ColorUIResource(BeautyEyeLNFHelper.commonForegroundColor));
//		UIManager.put("TabbedPane.tabRunOverlay", 2);//��������Ч��
		//false��ʾtab�ڱ߿�����֮�϶������ص�Ч��
		UIManager.put("TabbedPane.tabsOverlapBorder",true);
		UIManager.put("TabbedPaneUI",org.jb2011.lnf.beautyeye.ch2_tab.BETabbedPaneUI.class.getName());
		//�����Ծ���������JTabbedPane������ڳ�
		UIManager.put("TabbedPane.tabAreaInsets"
				,new javax.swing.plaf.InsetsUIResource(3,20,2,20));//Ĭ����3,2,2,2
		//�����Ծ�����tab����������Ŀհ�
		UIManager.put("TabbedPane.contentBorderInsets"
				,new javax.swing.plaf.InsetsUIResource(2,0,3,0));//Ĭ����2,2,3,3
		//�˲���������ѡ��ʱ��tab����������tab���غ϶ȣ���ֵ��ʾ�غϡ���ֵ��ʾ������հף�
		UIManager.put("TabbedPane.selectedTabPadInsets"//* ע����NPͼ�ı�Ե�������ʹ���ܴﵽ������Ч��
				,new javax.swing.plaf.InsetsUIResource(0,1,0,2));//Ĭ���� 2,2,2,1
		//�����Ծ�����JTabbedPane��tab��ǩ���ڳ�
		UIManager.put("TabbedPane.tabInsets",new javax.swing.plaf.InsetsUIResource(7,15,9,15));//Ĭ����1,4,1,4
		//��ý���ʱ�����߿���ɫ
		UIManager.put("TabbedPane.focus",new ColorUIResource(130,130,130));
		ColorUIResource highlight = new ColorUIResource(BeautyEyeLNFHelper.commonFocusedBorderColor);//192,192,192);
		//��BE LNF�У�����ɫ������TabPlacement=TOP��LEFT��������TabbedPane����������������ߵ���ɫ
		UIManager.put("TabbedPane.highlight",highlight);//new Color(200,200,200)));
		//��BE LNF�У�����ɫ������TabPlacement=RIGHT��BOTTOM��������TabbedPane����������������ߵ���ɫ
		UIManager.put("TabbedPane.shadow",highlight);
		//��BE LNF�У���TabPlacement=RIGHT��BOTTOM��������ʱ�����෽����Ĭ���ٶ໭һ����ɫ�����߶�ʹ����BE LNF��
		//���ÿ�������ɫ���õ�Ŀ�ľ����ô�������Ӱ���뱳��ɫһ�´Ӷ�����������Ч����������Ӱ�������������������BE LNF�е��Ӿ�Ч��
		UIManager.put("TabbedPane.darkShadow"
				,new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));
	}
}
