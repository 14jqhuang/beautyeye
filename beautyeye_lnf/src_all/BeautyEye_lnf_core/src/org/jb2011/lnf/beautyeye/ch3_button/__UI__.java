/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * __UI__.java at 2012-9-24 17:22:34, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch3_button;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.InsetsUIResource;
import javax.swing.plaf.basic.BasicBorders.MarginBorder;

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
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> JButton���ui�����趨
		UIManager.put("Button.background",new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));
		//Button.foreground���趨����Ч���������LNF���bug����NLLookAndFeel
		//�Ǽ̳�������������ʱ����Ϊ��������ô�İɣ��Ժ���˵
		UIManager.put("Button.foreground",new ColorUIResource(BeautyEyeLNFHelper.commonForegroundColor));
		
		//�������Խ�������ť��ý���ʱ�Ľ������߿�Ļ���ƫ����Ŷ
		UIManager.put("Button.dashedRectGapX",3);//windows LNF��Ĭ����3
		UIManager.put("Button.dashedRectGapY",3);//windows LNF��Ĭ����3
		UIManager.put("Button.dashedRectGapWidth",6);//windows LNF��Ĭ����6
		UIManager.put("Button.dashedRectGapHeight",6);//windows LNF��Ĭ����6
		
		UIManager.put("ButtonUI",org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI.class.getName());
		UIManager.put("Button.margin",new InsetsUIResource(6, 8, 6, 8));//new InsetsUIResource(6, 8, 6, 8));
		//��border������Button.margin����ʹ�ã�����֮�ͼ�������Button���ڳ�Ŷ
		UIManager.put("Button.border" ,new org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI
					.XPEmptyBorder(new Insets(3,3,3,3)));//default is 3,3,3,3
		//��ý���ʱ�����߿���ɫ
		UIManager.put("Button.focus",new ColorUIResource(130,130,130));

		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> JToggleButton���ui�����趨
		//ע�⣺�����Բ�Ҫ��ToggleButton.border���ã���Ϊû���������ȼ��ߣ�
		//����������InsetsUIResource�򲻻���Ч��������ԭ����飨������Ҳ������toolbar������߶ȺͿ��Ŷ��
		UIManager.put("ToggleButton.margin",new Insets(3, 11, 3, 11));//4, 8, 4, 8));////4, 12, 4, 12));
		UIManager.put("ToggleButton.background",new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));
		UIManager.put("ToggleButton.foreground",new ColorUIResource(BeautyEyeLNFHelper.commonForegroundColor));
		//����ToggleButon��ѡ��ʱ��ǰ��ɫ
		//ע����ԭWindowsLookAndFeel�У������Դ��ڣ�ֵ��Color(0,0,0,)������UI��û���õ�
		//���˴���jb2011����Ϊ��ѡ��ʱ��ǰ��ɫ������ȻҲ�������Ѷ����ƣ��μ� NLWindowsToggleButtonUI2.paintText(..)
		UIManager.put("ToggleButton.focus",new ColorUIResource(BeautyEyeLNFHelper.commonForegroundColor));//new ColorUIResource(Color.white)));//
		UIManager.put("ToggleButtonUI",org.jb2011.lnf.beautyeye.ch3_button.BEToggleButtonUI.class.getName());
		//�������ö�ToggleButton�ڲ����뵽JToolBarʱ����Ч����Ŷ����������������������
		Border toggleButtonBorder = new BorderUIResource(new MarginBorder());
//		UIManager.put("ToggleButton.margin",new InsetsUIResource(2, 30, 2, 30));
		UIManager.put("ToggleButton.border",toggleButtonBorder);
		/* ~~ע�����������Jack JiangΪ�˸��õ�uiЧ�����Ѽӵ����ԣ��������ߵ���ɫ */
		UIManager.put("ToggleButton.focusLine"
				,new ColorUIResource(BeautyEyeLNFHelper.commonFocusedBorderColor.darker()));
		/* ~~ע�����������Jack JiangΪ�˸��õ�uiЧ�����Ѽӵ����ԣ��������ߵĸ���������Ӱ��ɫ */
		UIManager.put("ToggleButton.focusLineHilight",new ColorUIResource(new Color(240,240,240)));
	}
}
