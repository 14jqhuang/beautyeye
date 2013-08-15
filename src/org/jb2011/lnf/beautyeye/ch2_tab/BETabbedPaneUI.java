/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BETabbedPaneUI.java at 2012-9-24 17:22:28, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch2_tab;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import org.jb2011.lnf.beautyeye.utils.BEUtils;

// TODO: Auto-generated Javadoc
/**
 * JTabbedPane��UIʵ����.
 * 
 * @author Jack Jiang(jb2011@163.com), 2012-01-12
 * @version 1.1
 */
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� Start
//�����ʵ�ֲο���JDK1.6_u18��com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� END
public class BETabbedPaneUI extends BasicTabbedPaneUI
{
	
	/**
	 * Creates the ui.
	 *
	 * @param c the c
	 * @return the component ui
	 */
	public static ComponentUI createUI(JComponent c)
	{
		return new BETabbedPaneUI();
	}
	
	//* ����������дcopy�� com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI������δ�޸Ĵ���
	//* ��д���෽��ʵ��rover״̬�µ�tab��ui�ػ棨���෽��ֻ��ʵ����rolloverTab
	//* �����ã�������ui�ػ��ƣ���Basic LNF��û��ʵ��rover״̬��ui��ʽ��
	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicTabbedPaneUI#setRolloverTab(int)
	 */
	protected void setRolloverTab(int index) 
	{
		// Rollover is only supported on XP
//		if (XPStyle.getXP() != null)
		{
			int oldRolloverTab = getRolloverTab();
			super.setRolloverTab(index);
			Rectangle r1 = null;
			Rectangle r2 = null;
			if ( (oldRolloverTab >= 0) && (oldRolloverTab < tabPane.getTabCount()) ) {
				r1 = getTabBounds(tabPane, oldRolloverTab);
			}
			if (index >= 0) {
				r2 = getTabBounds(tabPane, index);
			}
			if (r1 != null) {
				if (r2 != null) {
					tabPane.repaint(r1.union(r2));
				} else {
					tabPane.repaint(r1);
				}
			} else if (r2 != null) {
				tabPane.repaint(r2);
			}
		}
	}

	//* copy from parent and modified by jb2011
	/**
	 * this function draws the border around each tab
	 * note that this function does now draw the background of the tab.
	 * that is done elsewhere
	 *
	 * @param g the g
	 * @param tabPlacement the tab placement
	 * @param tabIndex the tab index
	 * @param x the x
	 * @param y the y
	 * @param w the w
	 * @param h the h
	 * @param isSelected the is selected
	 */
	protected void paintTabBorder(Graphics g, int tabPlacement,
			int tabIndex, int x, int y, int w, int h, boolean isSelected ) 
	{
//		g.setColor(lightHighlight);  
//		Graphics2D g2d = (Graphics2D)g;
		Graphics2D g2d = (Graphics2D)g.create();
		g2d.translate(x, y);

		//* ��Jack Jiang��ӣ�true��ʾ��tab��ǰ���������rover���ϵ�״̬
		//* this.getRolloverTab()�ķ���ֵ�ɸ��෽�� setRolloverTab()�趨��ʵ��ui�ػ��
		boolean isRover = (this.getRolloverTab() == tabIndex);
		//* ��Jack Jiang��ӣ�true��ʾ��tab���ڿ���״̬�������ʾ���ڽ���״̬
		boolean isEnableAt = this.tabPane.isEnabledAt(tabIndex);

		switch (tabPlacement) 
		{
			case LEFT:
				g2d.scale(-1.0, 1.0);
				g2d.rotate(Math.toRadians(90.0));
				paintTabBorderImpl(g2d, isEnableAt, isSelected, isRover, 0, 0, h, w);
				break;
			case RIGHT:
				g2d.translate(w, 0);
				g2d.rotate(Math.toRadians(90.0));
				paintTabBorderImpl(g2d, isEnableAt, isSelected, isRover, 0, 0, h, w);
				break;              
			case BOTTOM:
				g2d.translate(0, h);
				g2d.scale(-1.0, 1.0);
				g2d.rotate(Math.toRadians(180.0));
				paintTabBorderImpl(g2d, isEnableAt, isSelected, isRover, 0, 0, w, h);
				break;
			case TOP:
			default:    
				paintTabBorderImpl(g2d, isEnableAt, isSelected, isRover, 0, 0, w, h);
				break;
		}
	}
	//* paintTabBorder�Ļ���ʵ�ַ�����2012-01-12�� BY Jack Jiang
	/**
	 * Paint tab border impl.
	 *
	 * @param g2d the g2d
	 * @param isEnableAt the is enable at
	 * @param isSelected the is selected
	 * @param isRover the is rover
	 * @param x the x
	 * @param y the y
	 * @param w the w
	 * @param h the h
	 */
	private void paintTabBorderImpl(Graphics2D g2d, boolean isEnableAt, boolean isSelected
			, boolean isRover, int x, int y, int w, int h)
	{
		//** modified by jb2011 ��ΪNinePatchͼƬʵ�֣�Y + 1 ��Ŀ����ʹ��ѡ��ʱ�ĵ��������»�һ�����أ������ÿ��㣩
		if(isSelected)//ѡ��״̬
			__Icon9Factory__.getInstance().getTabbedPaneBgSelected().draw(g2d, x, y+1, w, h);//y, w, h);
		else
		{
			if(isEnableAt && isRover)//rover״̬
				__Icon9Factory__.getInstance().getTabbedPaneBgNormal_rover().draw(g2d, x, y+1 , w, h);//y , w, h);
			else//����״̬
				__Icon9Factory__.getInstance().getTabbedPaneBgNormal().draw(g2d, x, y+1 , w, h);//y , w, h);
		}
	}

	//copy from BasicTabbedPaneUI and modified by Jack Jiang
	//* ��д��������Ŀ�Ľ��ǰ�ԭ����Ĭ��ʵ�߱�����߶���Ŷ
	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicTabbedPaneUI#paintContentBorder(java.awt.Graphics, int, int)
	 */
	@Override
	protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
		//*** add by jb2011 2012-08-23 START
		//������ʽ
		Stroke oldStroke = ((Graphics2D)g).getStroke();
		Stroke sroke = new BasicStroke(1, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_BEVEL, 0, new float[]{2, 2}, 0);//ʵ�ߣ��հ�
		((Graphics2D)g).setStroke(sroke);
		//*** add by jb2011 2012-08-23 END

		//���ø���Ĭ��ʵ��
		super.paintContentBorder(g, tabPlacement, selectedIndex);

		//*** add by jb2011 2012-08-23 START
		((Graphics2D)g).setStroke(oldStroke);
		//*** add by jb2011 2012-08-23 END
	}

	//copy from BasicTabbedPaneUI and modified by Jack Jiang
	//JTabbedPaneUI ���������ϱ߿���Ʒ�����Ĭ�Ͼ�����������Ϸ���������ɫ��
	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicTabbedPaneUI#paintContentBorderTopEdge(java.awt.Graphics, int, int, int, int, int, int)
	 */
	protected void paintContentBorderTopEdge(Graphics g, int tabPlacement,
			int selectedIndex, 
			int x, int y, int w, int h)
	{
		//��ģʽ�²���������3���߿��Ӿ��Ϻÿ�һЩ
		if(tabPlacement == TOP)
			//���ø���Ĭ��ʵ��
			super.paintContentBorderTopEdge(g, tabPlacement, selectedIndex, x, y, w, h);
	}
	//copy from BasicTabbedPaneUI and modified by Jack Jiang
	//JTabbedPaneUI ����������߿���Ʒ���
	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicTabbedPaneUI#paintContentBorderLeftEdge(java.awt.Graphics, int, int, int, int, int, int)
	 */
	protected void paintContentBorderLeftEdge(Graphics g, int tabPlacement,
			int selectedIndex,
			int x, int y, int w, int h) 
	{ 
		//��ģʽ�²���������3���߿��Ӿ��Ϻÿ�һЩ
		if(tabPlacement == LEFT)
			//���ø���Ĭ��ʵ��
			super.paintContentBorderLeftEdge(g, tabPlacement, selectedIndex, x, y, w, h);
	}
	//copy from BasicTabbedPaneUI and modified by Jack Jiang
	//JTabbedPaneUI �������ĵױ߿���Ʒ���
	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicTabbedPaneUI#paintContentBorderBottomEdge(java.awt.Graphics, int, int, int, int, int, int)
	 */
	protected void paintContentBorderBottomEdge(Graphics g, int tabPlacement,
			int selectedIndex,
			int x, int y, int w, int h) 
	{ 
		//��ģʽ�²���������3���߿��Ӿ��Ϻÿ�һЩ
		if(tabPlacement == BOTTOM)
			//���ø���Ĭ��ʵ��
			super.paintContentBorderBottomEdge(g, tabPlacement, selectedIndex, x, y, w, h);
	}
	//copy from BasicTabbedPaneUI and modified by Jack Jiang
	//JTabbedPaneUI ���������ұ߿���Ʒ���
	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicTabbedPaneUI#paintContentBorderRightEdge(java.awt.Graphics, int, int, int, int, int, int)
	 */
	protected void paintContentBorderRightEdge(Graphics g, int tabPlacement,
			int selectedIndex,
			int x, int y, int w, int h) 
	{
		//��ģʽ�²���������3���߿��Ӿ��Ϻÿ�һЩ
		if(tabPlacement == RIGHT)
			//���ø���Ĭ��ʵ��
			super.paintContentBorderRightEdge(g, tabPlacement, selectedIndex, x, y, w, h);
	}
	
	//copy from BasicTabbedPaneUI and modified by 2011
	//��ý���ʱ�����߿���Ʒ���
	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicTabbedPaneUI#paintFocusIndicator(java.awt.Graphics, int, java.awt.Rectangle[], int, java.awt.Rectangle, java.awt.Rectangle, boolean)
	 */
	@Override
	protected void paintFocusIndicator(Graphics g, int tabPlacement,
			Rectangle[] rects, int tabIndex, 
			Rectangle iconRect, Rectangle textRect,
			boolean isSelected) 
	{
		Rectangle tabRect = rects[tabIndex];
		if (tabPane.hasFocus() && isSelected) 
		{
			int x, y, w, h;
			g.setColor(focus);
			switch(tabPlacement) {
				case LEFT:
					x = tabRect.x + 4;//������Ĭ����+3
					y = tabRect.y + 6;//������Ĭ����+3
					w = tabRect.width - 7;//������Ĭ���� - 5
					h = tabRect.height - 12;//������Ĭ����-6
					break;
				case RIGHT:
					x = tabRect.x + 4;//������Ĭ����+ 2
					y = tabRect.y + 6;//������Ĭ����+ 3
					w = tabRect.width - 9;//������Ĭ����- 5
					h = tabRect.height - 12;//������Ĭ����- 6
					break;
				case BOTTOM:
					x = tabRect.x + 6;//������Ĭ����+ 3
					y = tabRect.y + 4;//������Ĭ����+ 2
					w = tabRect.width - 12;//������Ĭ����- 6
					h = tabRect.height - 9;//������Ĭ����- 5
					break;
				case TOP:
				default:
					//** modified by jb2011����������Ч������ƫ������
					x = tabRect.x + 6;//������Ĭ����+3
					//** modified by jb2011����������Ч������ƫ������
					y = tabRect.y + 4;//������Ĭ����+3
					//** modified by jb2011����������Ч������ƫ������
					w = tabRect.width - 12;//������Ĭ����-6
					//** modified by jb2011��-8��Ŀ����ʹ�ý������߿���ѡ�еױ߱���һ�����صľ��룬������һ�����Ӿ���Ч����ϲ�
					h = tabRect.height - 8;//������Ĭ���� - 5
			}
			
			//** modified by jb2011���������߷����ĳɿ����������߲����ķ�����������Ϊ2����ÿ�һ��
//			BasicGraphicsUtils.drawDashedRect(g, x, y, w, h);
			BEUtils.drawDashedRect(g, x, y, w, h);
			// �������߿�İ�͸����ɫ������Ӱ����������ɫ�ϵ���Ч�������ԣ�����Ȼ��û��Ҫ�ã�
			g.setColor(new Color(255,255,255,255));
			// ������Ӱ����������ƫ��һ������ʵ�ֵ�
			BEUtils.drawDashedRect(g, x + 1, y + 1,w, h);
		}
	}
	
	//copy from BasicTabbedPaneUI and modified by 2011
	//* ��д���޸ı�������Ŀ��������tab�ϵ��ı���ʾY���귽���ϵ�ƫ�ƣ��Ա��뱳��Э��
	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicTabbedPaneUI#getTabLabelShiftY(int, int, boolean)
	 */
	protected int getTabLabelShiftY(int tabPlacement, int tabIndex, boolean isSelected) 
	{
		Rectangle tabRect = rects[tabIndex];
		int nudge = 0;
		switch(tabPlacement) {
			case BOTTOM:
				nudge = isSelected? 1 : -1;
				break;
			case LEFT:
			case RIGHT:
				nudge = tabRect.height % 2;
				break;
			case TOP:
			default:
				//** ��jb2011 2012-08-24�޸ģ�Ŀ����ʹ��ѡ��ʱ��δѡ��ʱ���ı�������ͼ��
				//** Ĭ��ʵ����֮����Ҫ��������Ч����Ϊ��Ӫ������Ч������BE LNF�в�����Ҫ
				//** ����Ҫ���ϻ�����ƫ�Ƶ�̫�̫ࣨ�����൱�ѿ���
//				nudge = isSelected? -1 : 1;//������ԭ�����е�Ĭ��ʵ��Ŷ
				nudge = -2;//��jb2011�޸ģ�Ŀ�������ı�������ڵı�������ƫ��һ�㣬�ÿ�һЩ
		}
		return nudge;
	}
}
