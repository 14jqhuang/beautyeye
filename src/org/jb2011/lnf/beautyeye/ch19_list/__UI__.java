/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * __UI__.java at 2012-9-24 17:22:25, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch19_list;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.UIManager;
import javax.swing.border.AbstractBorder;
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
		//ͨ����border���Ե��������б���������ҵĿհ�
		UIManager.put("List.border",new BorderUIResource(BorderFactory.createEmptyBorder(0,0,0,0)));
		//�����Խ������ѱ�ѡ�е��б�Ԫ��ʾ�ı����������ҿհ�Ŷ
		UIManager.put("List.focusCellHighlightBorder",new BorderUIResource(BorderFactory.createEmptyBorder(1, 8, 5, 3)));//new BorderUIResource(new BEDashedBorder(Color.red,true,false,true,false)));
		/* ~~ע�����������jb2011Ϊ�˸��õ�uiЧ�����Ѽӵ����� */
		UIManager.put("List.focusSelectedCellHighlightBorderColor", new ColorUIResource(new Color(220,0,0,255)));//Color.red
		/* ~~ע�����������jb2011Ϊ�˸��õ�uiЧ�����Ѽӵ����ԣ�Ŀ����ʹList.focusSelectedCellHighlightBorderColor�е�����Ч��Ŷ */
		UIManager.put("List.focusSelectedCellHighlightBorderHighlightColor"
				, new ColorUIResource(new Color(255,255,255,70)));//ע�⣺�����ɫ�ǰ�͸����Ŷ
		//�б�Ԫ��ý���ʱ�ı߿�windows��������һ���������߿򣩡���֮ǰ��Ҳ�벻ͨ������߸�һ�����صİױ��������û��������ɵ�
		UIManager.put("List.focusSelectedCellHighlightBorder"
				,new BorderUIResource(new org.jb2011.lnf.beautyeye.ch19_list.__UI__.FocusSelectedCellHighlightBorder()));
		//��������״̬�µ��б�Ԫ��ʾ�ı����������ҿհ�Ŷ
		UIManager.put("List.cellNoFocusBorder",new BorderUIResource(BorderFactory.createEmptyBorder(1, 8, 5, 3)));
		
		UIManager.put("List.background",new ColorUIResource(Color.white));
		UIManager.put("List.foreground",new ColorUIResource(BeautyEyeLNFHelper.commonForegroundColor));
		UIManager.put("List.selectionForeground",Color.white);//fgColor);
		UIManager.put("List.selectionBackground",new ColorUIResource(BeautyEyeLNFHelper.commonSelectionBackgroundColor));
		
		UIManager.put("List.cellRenderer", new MyDefaultListCellRenderer.UIResource());
		UIManager.put("ListUI", org.jb2011.lnf.beautyeye.ch19_list.BEListUI.class.getName());
	}
	
	//��border��Jack Jiangʵ�֣������б�Ԫ��ý���ʱ�ı߿�windows���
	//����һ���������߿�,��border��ǰ����ʽ����������߻���һ����ɫ����
	/**
	 * The Class FocusSelectedCellHighlightBorder.
	 */
	static class FocusSelectedCellHighlightBorder extends AbstractBorder
	{
		
		/* (non-Javadoc)
		 * @see javax.swing.border.AbstractBorder#getBorderInsets(java.awt.Component)
		 */
		public Insets getBorderInsets(Component c)       
		{
			//Insets��List.focusCellHighlightBorder һ�����ɣ������������Ӿ��ϱ���һ���ޣ���һ���������λ���ѿ�Ч������
			return UIManager.getBorder("List.focusCellHighlightBorder").getBorderInsets(c);
		}

		/* (non-Javadoc)
		 * @see javax.swing.border.AbstractBorder#getBorderInsets(java.awt.Component, java.awt.Insets)
		 */
		public Insets getBorderInsets(Component c, Insets insets) 
		{
			return getBorderInsets(c);
		}
		
		/* (non-Javadoc)
		 * @see javax.swing.border.AbstractBorder#paintBorder(java.awt.Component, java.awt.Graphics, int, int, int, int)
		 */
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
		{
			//����߻�һ��2���ؿ������
			g.setColor(UIManager.getColor("List.focusSelectedCellHighlightBorderColor"));
			g.fillRect(x, y+1, 2, height -5);//-2);//���¸��հ�һ�����أ�Ŀ����Ϊ����render��N9ͼƬ��������γɸ��õ��Ӿ�Ч��
			
			//��������������ұ߻�һ��1���ؿ����ɫ���ߣ��Ա�Ϊ�����2��������Ӫ������Ч��
			/* ~~ע�����������jb2011Ϊ�˸��õ�uiЧ�����Ѽӵ����ԣ�Ŀ����ʹList.focusSelectedCellHighlightBorder�е�����Ч��Ŷ */
			g.setColor(UIManager.getColor("List.focusSelectedCellHighlightBorderHighlightColor"));
			g.fillRect(x+2, y+1, 1, height -5);//-2);
		}
	}
}
