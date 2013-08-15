/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * __UI__.java at 2012-9-24 17:19:28, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch_x;

import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.widget.border.BEDashedRoundRecBorder;

// TODO: Auto-generated Javadoc
/**
 * ����δ�����UI��������ʵ����.
 * �����еĸ��������պ���ܻ�������Ӧ�ĸ����������UI��.
 * 
 * @author Jack Jiang
 * @version 1.1
 */
public class __UI__
{
	/**
	 * Ui impl.
	 */
	public static void uiImpl()
	{
		UIManager.put("control",new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));
		UIManager.put("Separator.foreground",new ColorUIResource(BeautyEyeLNFHelper.commonForegroundColor));
		UIManager.put("ToolTip.foreground",new ColorUIResource(BeautyEyeLNFHelper.commonForegroundColor));
		
		UIManager.put("Panel.foreground",new ColorUIResource(BeautyEyeLNFHelper.commonForegroundColor));
		UIManager.put("Panel.background",new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));
		
		UIManager.put("Label.foreground",new ColorUIResource(BeautyEyeLNFHelper.commonForegroundColor));
		UIManager.put("Label.background",new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));

		UIManager.put("ColorChooser.foreground",new ColorUIResource(BeautyEyeLNFHelper.commonForegroundColor));
		UIManager.put("ColorChooser.background",new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));
		UIManager.put("ColorChooser.swatchesDefaultRecentColor",new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));
		
		UIManager.put("TitledBorder.titleColor",new ColorUIResource(new Color(58,135,173)));//TitleBorder�ı�����ɫ
		//TitledBorder��Ĭ��borderʵ�֣�windows LNF��Ĭ����Բɫ��ɫʵ�߾��Σ�
		UIManager.put("TitledBorder.border",new BorderUIResource(new BEDashedRoundRecBorder(BeautyEyeLNFHelper.commonFocusedBorderColor)));
		
//		UIManager.put("OptionPaneUI",org.jb2011.lnf.windows2.ch3.NLOptionPaneUI.class.getName());
		//** Ui���ʵ���߼���������Ϊtrueʱ������JOptionPane��ĸ���ť��BasicOptionPaneUI���趨��Insets����
		//** UIչ�֣�����ť��<=2ʱʹ�õ�Insets=new Instes(2,8,2,8)������ʹ��new Instes(2,4,2,4)��
		//** �������߼��£�BeautyEye L&Fʵ�����ʹ�ð�ť�߶���С�����ÿ�������Ҫ�رմ�����
		UIManager.put("OptionPane.setButtonMargin",false);
		UIManager.put("OptionPane.foreground",new ColorUIResource(BeautyEyeLNFHelper.commonForegroundColor));
		UIManager.put("OptionPane.background",new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));
		UIManager.put("OptionPane.questionIcon",__IconFactory__.getInstance().getOptionPaneQUESTIONIcon());
		UIManager.put("OptionPane.warningIcon",__IconFactory__.getInstance().getOptionPaneWARNIcon());
		UIManager.put("OptionPane.informationIcon",__IconFactory__.getInstance().getOptionPaneINFOIcon());
		UIManager.put("OptionPane.errorIcon",__IconFactory__.getInstance().getOptionPaneERRORIcon());
	}
}
