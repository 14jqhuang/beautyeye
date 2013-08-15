/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * __UI__.java at 2012-9-24 17:21:35, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch14_combox;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.UIManager;
import javax.swing.plaf.BorderUIResource;
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
		/* ~~ע�����������Jack Jiang����JTabel���ʵ�����Ѽӵ����ԣ�Ŀ���ǿ���ѡ���ĵ����б�ı߿�հ� */
		UIManager.put("ComboBox.scrollPaneBorder",new BorderUIResource(BorderFactory.createEmptyBorder(2,0,4,0)));
		
		UIManager.put("ComboBox.background",new ColorUIResource(Color.white));
		UIManager.put("ComboBox.disabledBackground",new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));
//		UIManager.put("ComboBox.buttonBackground",new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));
		UIManager.put("ComboBox.buttonBackground",new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));
		UIManager.put("ComboBox.selectionForeground",new ColorUIResource(BeautyEyeLNFHelper.commonSelectionForegroundColor));
		UIManager.put("ComboBox.selectionBackground",new ColorUIResource(BeautyEyeLNFHelper.commonSelectionBackgroundColor));
		UIManager.put("ComboBox.foreground",new ColorUIResource(BeautyEyeLNFHelper.commonForegroundColor));
		
		//render֮��ĳľ࣬�����ý��ı������������ռλ��С
		UIManager.put("ComboBox.padding",new javax.swing.plaf.InsetsUIResource(1,0,1,0));//5,8,5,8));
		//true��ʾ������ͷ��ť�Ŀ��������=�߶ȣ������Ȳ���߶ȱ��ֵȳ���ʹ�������ȣ�
		UIManager.put("ComboBox.squareButton",true);
		//��border������ArrowButton����Ĵ�С�������ڳĿհ״�С�����˴�С����conbox�ĸ߶ȺͿ�ȣ���һ�ַ���
		//��ͨ������render��borderҲ�ܴﵽ����combox�ĸ߶ȺͿ�ȣ����Ҷ�lnf��˵ͨ������render��border����ѷ���
		UIManager.put("ComboBox.border",new BorderUIResource(BorderFactory.createEmptyBorder(0, 4, 0, 0)));//new BERoundBorder(0).setThickness(10)));//.setArcWidth(10).setLineColor(new Color(0,0,0,0))));//ʹ��ȫ͸��ɫ��߿�Ŀ�ľ���Ҫ�����ı������ֳ�����NipePatchͼʵ�֣�
		UIManager.put("ComboBoxUI",org.jb2011.lnf.beautyeye.ch14_combox.BEComboBoxUI.class.getName());
	
		/* ~~ע�����������Jack JiangΪ�˸��õ�uiЧ���ͷ���δ�����趨���Ѽӵ����� */
		//��������������ĵ�������X����
		UIManager.put("ComboBox.popupOffsetX", -3);
		/* ~~ע�����������Jack JiangΪ�˸��õ�uiЧ���ͷ���δ�����趨���Ѽӵ����� */
		//��������������ĵ�������Y����
		UIManager.put("ComboBox.popupOffsetY", 2);
	}
}
