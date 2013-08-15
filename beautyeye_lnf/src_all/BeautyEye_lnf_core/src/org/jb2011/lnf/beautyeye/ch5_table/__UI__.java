/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * __UI__.java at 2012-9-24 17:22:40, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch5_table;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.UIManager;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.InsetsUIResource;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.ch_x.__IconFactory__;
import org.jb2011.lnf.beautyeye.utils.JVM;

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
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> JTable�����ui�����趨
		//JTable�����Ĺ�������borderʵ�֣�����JList��JTable��UI�Զ�Ϊ���䱸��һ��JScrollPane��
		UIManager.put("Table.scrollPaneBorder",new BorderUIResource(new org.jb2011.lnf.beautyeye.ch5_table.TableScrollBorder()));//defaut is com.sun.java.swing.plaf.windows.XPStyle.XPFillBorder
		UIManager.put("Table.focusCellHighlightBorder",new BorderUIResource(new org.jb2011.lnf.beautyeye.ch5_table.FocusCellHighlightBorder()));//new BEDashedBorder(new Color(0,160,0),1,0,true,false,true,false)));
		/* ~~ע�����������jb2011Ϊ�˸��õ�uiЧ�����Ѽӵ����� */
		UIManager.put("Table.focusCellHighlightBorderColor", new ColorUIResource(Color.red));
		/* ~~ע�����������jb2011Ϊ�˸��õ�uiЧ�����Ѽӵ����ԣ�Ŀ����ʹTable.focusCellHighlightBorder�е�����Ч��Ŷ */
		UIManager.put("Table.focusCellHighlightBorderHighlightColor"
				, new ColorUIResource(new Color(255,255,255,70)));//ע�⣺�����ɫ�ǰ�͸����Ŷ
		UIManager.put("Table.background",new ColorUIResource(Color.white));
		//** 2011-03-16 add by jb2011 Ϊ��ʹJDK1.6�����ϱ��ͷ������ʱ����ʾ�����ͷ��1.6�������ͼ������UI���趨�ģ�
		UIManager.put("Table.descendingSortIcon",__IconFactory__.getInstance().getTableDescendingSortIcon());
		UIManager.put("Table.ascendingSortIcon",__IconFactory__.getInstance().getTableAscendingSortIcon());
		UIManager.put("Table.selectionForeground",new ColorUIResource(BeautyEyeLNFHelper.commonSelectionForegroundColor));
		UIManager.put("Table.gridColor",new ColorUIResource(new Color(220,220,220)));
		UIManager.put("Table.selectionBackground",new ColorUIResource(BeautyEyeLNFHelper.commonSelectionBackgroundColor));
		UIManager.put("Table.foreground",new ColorUIResource(BeautyEyeLNFHelper.commonForegroundColor));
		UIManager.put("TableUI",org.jb2011.lnf.beautyeye.ch5_table.BETableUI.class.getName());
		
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> JTable��ͷ���ui�����趨
//		UIManager.put("TableHeader.font",new Font("����",Font.PLAIN,12));//�����Խ�������ͷ������
		UIManager.put("TableHeader.background",new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));
		UIManager.put("TableHeader.foreground",new ColorUIResource(BeautyEyeLNFHelper.commonForegroundColor));
		//��ͷ�Ķ�����JDK1.6���Ժ�汾�ö���һЩ��1.5����ǰ�汾����ȱ�ܶ�ؼ��Ĵ�����Ѷ��ƣ��ο���Ҫ���Ǽ����ԣ�
		//���Զ��Ʊ�ͷֻ֧�ֵ�1.6���Ժ�汾��1.5����ǰ�汾��ֻ֧�ֱ߿��Զ����������
		if(JVM.current().isOrLater(JVM.JDK1_6))
		{
			//��������ȫ���Ʊ�ͷui����ΪBasicTableHeaderUI��Ĺؼ���������private���޷��̳���д��Ҫʵ������
			//�Ļ����߼���Ҫ��д��δ��룬����JTabel�ڲ�ͬjdk�汾��ı䶯�ϴ󣺱���1.6����е����򣨼�ͼ�꣩����ط���
			//�ڲ�ͬ�İ汾�ﶼ������ͬ�����ҵ���������sun�ķǹ��������api������ڼ��������⣬Ϊ��UI���ۣ������Զ���ʵ�ְ�
			UIManager.put("TableHeaderUI","org.jb2011.lnf.beautyeye.ch5_table.BETableHeaderUI");
			//** BE LNF�ı�����ֻ��Java�汾����1.5ʱ��Ч
			//* ��jb2011���Ѽӵ����ԣ���ԭBasicTableHeaderUI����TableHeader.cellBorder������
			//border����WindowsTableHeaderUI��border��������ʵ�ֵ�IconBorder����BE LNF�����Ƿ�
			//��Windows LNFʵ�֣�����ֻ��ʵ��һ�����ѵ����������Ժ��ʹ��������趨������ֻ����Windows LNFһ��Ӳ�����ڴ����
			UIManager.put("TableHeader.cellMargin", new InsetsUIResource(7, 0, 7, 0));
		}
		else
		{
//			UIManager.put("TableHeader.font", userTextValue);
			//** BE LNF�ı�����ֻ��Java�汾���ڻ����1.5ʱ��Ч
			UIManager.put("TableHeader.cellBorder", 
//					new SwingLazyValue("javax.swing.plaf.metal.MetalBorders$TableHeaderBorder")
					new BorderUIResource(new org.jb2011.lnf.beautyeye.ch5_table.__UI__.TableHeaderBorder())
			);
			UIManager.put("TableHeaderUI",javax.swing.plaf.basic.BasicTableHeaderUI.class.getName());
		}
	}
	
	//* ��borderʵ�ֲο���javax.swing.plaf.metal.TableHeaderBorder
	/**
	 * Border for a Table Header.
	 */
	public static class TableHeaderBorder extends javax.swing.border.AbstractBorder 
	{
		
		/** The editor border insets. */
		protected Insets editorBorderInsets = new Insets( 7, 0, 7, 0 );//Ĭ����2, 2, 2, 0 );

		/* (non-Javadoc)
		 * @see javax.swing.border.AbstractBorder#paintBorder(java.awt.Component, java.awt.Graphics, int, int, int, int)
		 */
		public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) 
		{
			g.translate( x, y );

//			g.setColor(MetalLookAndFeel.getControlDarkShadow() );
//			g.drawLine( w-1, 0, w-1, h-1 );
//			g.drawLine( 1, h-1, w-1, h-1 );
//			g.setColor( MetalLookAndFeel.getControlHighlight() );
//			g.drawLine( 0, 0, w-2, 0 );
//			g.drawLine( 0, 0, 0, h-2 );
			
			//* add by Jack Jiang START
			//���Ʊ�ͷ��Ԫ�ĵײ�ˮƽ�ߣ�����������ɫһ���Ϳ����ˣ�
			g.setColor(UIManager.getColor("Table.gridColor"));
			g.drawLine( 0, h-1, w, h-1 );
			
			//���Ʊ�ͷ��Ԫ���ҷָ�����
			org.jb2011.lnf.beautyeye.ch5_table.__Icon9Factory__.getInstance().getTableHeaderCellSeparator1()
				.draw((Graphics2D)g, w - 4, 0, 4, h);
			//* add by Jack Jiang END

			g.translate( -x, -y );
		}

		/* (non-Javadoc)
		 * @see javax.swing.border.AbstractBorder#getBorderInsets(java.awt.Component)
		 */
		public Insets getBorderInsets( Component c ) 
		{
			return editorBorderInsets;
		}
	}
}
