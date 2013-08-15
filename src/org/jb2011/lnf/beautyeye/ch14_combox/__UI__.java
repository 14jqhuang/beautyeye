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
		/* ~~注：这个属性是Jack Jiang仿照JTabel里的实现自已加的属性，目的是控制选择框的弹出列表的边框空白 */
		UIManager.put("ComboBox.scrollPaneBorder",new BorderUIResource(BorderFactory.createEmptyBorder(2,0,4,0)));
		
		UIManager.put("ComboBox.background",new ColorUIResource(Color.white));
		UIManager.put("ComboBox.disabledBackground",new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));
//		UIManager.put("ComboBox.buttonBackground",new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));
		UIManager.put("ComboBox.buttonBackground",new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));
		UIManager.put("ComboBox.selectionForeground",new ColorUIResource(BeautyEyeLNFHelper.commonSelectionForegroundColor));
		UIManager.put("ComboBox.selectionBackground",new ColorUIResource(BeautyEyeLNFHelper.commonSelectionBackgroundColor));
		UIManager.put("ComboBox.foreground",new ColorUIResource(BeautyEyeLNFHelper.commonForegroundColor));
		
		//render之外的衬距，此设置将改变下拉框的整体占位大小
		UIManager.put("ComboBox.padding",new javax.swing.plaf.InsetsUIResource(1,0,1,0));//5,8,5,8));
		//true表示下拉箭头按钮的宽度无条件=高度，否则宽度不与高度保持等长（使用自身长度）
		UIManager.put("ComboBox.squareButton",true);
		//此border将决定ArrowButton的外衬大小（即框内衬空白大小），此大小决定conbox的高度和宽度，另一种方法
		//是通过设置render的border也能达到调整combox的高度和宽度，而且对lnf来说通过设置render的border是最佳方案
		UIManager.put("ComboBox.border",new BorderUIResource(BorderFactory.createEmptyBorder(0, 4, 0, 0)));//new BERoundBorder(0).setThickness(10)));//.setArcWidth(10).setLineColor(new Color(0,0,0,0))));//使用全透明色绘边框，目的就是要让它的背景显现出来（NipePatch图实现）
		UIManager.put("ComboBoxUI",org.jb2011.lnf.beautyeye.ch14_combox.BEComboBoxUI.class.getName());
	
		/* ~~注：这个属性是Jack Jiang为了更好的ui效果和方便未来的设定自已加的属性 */
		//用于修正下拉框的弹出窗的X坐标
		UIManager.put("ComboBox.popupOffsetX", -3);
		/* ~~注：这个属性是Jack Jiang为了更好的ui效果和方便未来的设定自已加的属性 */
		//用于修正下拉框的弹出窗的Y坐标
		UIManager.put("ComboBox.popupOffsetY", 2);
	}
}
