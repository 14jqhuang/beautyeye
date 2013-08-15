/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * __UI__.java at 2012-9-24 17:22:16, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch16_tree;

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
		UIManager.put("Tree.background",new ColorUIResource(Color.white));
		UIManager.put("Tree.textBackground",new ColorUIResource(Color.white));
//		UIManager.put("Tree.drawsFocusBorderAroundIcon",new Boolean(false));
		UIManager.put("Tree.selectionForeground",new ColorUIResource(BeautyEyeLNFHelper.commonSelectionForegroundColor));
		UIManager.put("Tree.selectionBackground",new ColorUIResource(BeautyEyeLNFHelper.commonSelectionBackgroundColor));
		UIManager.put("Tree.foreground",new ColorUIResource(BeautyEyeLNFHelper.commonForegroundColor));
		UIManager.put("Tree.selectionBorderColor",new ColorUIResource(BeautyEyeLNFHelper.commonFocusedBorderColor));//windows������Ĭ����0,0,0
		
		UIManager.put("Tree.openIcon",__IconFactory__.getInstance().getTreeDefaultOpenIcon_16_16());
		UIManager.put("Tree.closedIcon",__IconFactory__.getInstance().getTreeDefaultClosedIcon_16_16());
		UIManager.put("Tree.leafIcon",__IconFactory__.getInstance().getTreeDefaultLeafIcon_16_16());
		UIManager.put("Tree.expandedIcon",__IconFactory__.getInstance().getTreeA());
//				,new org.jb2011.lnf.windows2.ch16.BETreeUI.ExpandedIcon());
		UIManager.put("Tree.collapsedIcon",__IconFactory__.getInstance().getTreeB());
//				,new org.jb2011.lnf.windows2.ch16.BETreeUI.CollapsedIcon());
		
		//�����Ʋ����
		UIManager.put("Tree.paintLines", false);//default is true
		//�и�
		UIManager.put("Tree.rowHeight", 18);//default is 16
		//δѡ��ʱ��Ԫǰ��ɫ����ѡMacOSX�� (35,35,35)��
		UIManager.put("Tree.textForeground", new ColorUIResource(70,70,70));
		//���ڱ༭״̬ʱ���ı���߿���BE LNF���ı����ޱ߿���ʵ��������N9ͼʵ�ֵı���
		//�߿��Ӿ�Ч���������Դ˴�Ҫȥ�������Ӷ��հף��뱳����������ÿ���
		UIManager.put("Tree.editorBorder"
				, new BorderUIResource(BorderFactory.createEmptyBorder(1,5,1,5)));//Windows LNF��Ĭ����LineBorderUIResource
		
		UIManager.put("TreeUI",org.jb2011.lnf.beautyeye.ch16_tree.BETreeUI.class.getName());
	}
}
