/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BEToolBarSeparatorUI.java at 2012-9-24 17:22:48, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch8_toolbar;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JComponent;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicToolBarSeparatorUI;

// TODO: Auto-generated Javadoc
/**
 * JToolBar�ķָ���UIʵ���ࡣ.
 *
 * @author Jack Jiang(jb2011@163.com)
 */
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� Start
//����ʵ�ִ���ο���WindowsToolBarSeparatorUI
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� END
public class BEToolBarSeparatorUI extends BasicToolBarSeparatorUI 
{
	
	/**
	 * Creates the ui.
	 *
	 * @param c the c
	 * @return the component ui
	 */
	public static ComponentUI createUI( JComponent c ) {
		return new BEToolBarSeparatorUI();
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicToolBarSeparatorUI#getPreferredSize(javax.swing.JComponent)
	 */
	public Dimension getPreferredSize(JComponent c) 
	{
		Dimension size = ((JToolBar.Separator)c).getSeparatorSize();

		if (size != null) 
		{
			size = size.getSize();
		} 
		else 
		{
			size = new Dimension(6, 6);
			//			XPStyle xp = XPStyle.getXP();
			//			if (xp != null) {
			//				boolean vertical = ((JSeparator)c).getOrientation() == SwingConstants.VERTICAL;
			//				Part part = vertical ? Part.TP_SEPARATOR : Part.TP_SEPARATORVERT;
			//				Skin skin = xp.getSkin(c, part);
			//				size.width = skin.getWidth();
			//				size.height = skin.getHeight();
			//			}
			
			if (((JSeparator)c).getOrientation() == SwingConstants.VERTICAL) 
			{
				size.height = 0;
			}
			else 
			{
				size.width = 0;
			}
		}
		return size;
	}

	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicSeparatorUI#getMaximumSize(javax.swing.JComponent)
	 */
	public Dimension getMaximumSize(JComponent c) {
		Dimension pref = getPreferredSize(c);
		if (((JSeparator)c).getOrientation() == SwingConstants.VERTICAL) {
			return new Dimension(pref.width, Short.MAX_VALUE);
		} else {
			return new Dimension(Short.MAX_VALUE, pref.height);
		}
	}

	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicToolBarSeparatorUI#paint(java.awt.Graphics, javax.swing.JComponent)
	 */
	public void paint( Graphics g, JComponent c ) 
	{
		boolean vertical = ((JSeparator)c).getOrientation() == SwingConstants.VERTICAL;
		Dimension size = c.getSize();
		
		//������ʽ
		Stroke oldStroke = ((Graphics2D)g).getStroke();
		Stroke sroke = new BasicStroke(1, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_BEVEL, 0, new float[]{2, 2}, 0);//ʵ�ߣ��հ�
		((Graphics2D)g).setStroke(sroke);//

		Color temp = g.getColor();
		UIDefaults table = UIManager.getLookAndFeelDefaults();
		Color shadow = table.getColor("ToolBar.shadow");
		Color highlight = table.getColor("ToolBar.highlight");

		// TODO BUG_001����֪�ιʣ���ֱ�ָ�����������ˮƽ�ָ���һ����ӵ��Ĭ�����õ�new Dimension(6, 6)
		// ��ֻ��new Dimension(1, ...)��������floatingʱȴ����������(ֻ�ܻ��hilight�����ܻ��shadow)
		//���д������о�����ֱ�ķָ����򲻻��д������
		if (vertical) 
		{
			int x = (size.width / 2) - 1;
			
			//* ��BUG_001����ʱ����ʱʹ�����´��������ѱ�����ʾhilight��
			//* ������shadow��ɫ���ƣ������ܱ�֤ui������չ��
//			g.setColor(shadow);
//			g.drawLine(x, 2, x, size.height - 2);
			g.setColor(shadow);//highlight);
			g.drawLine(x + 1, 2, x + 1, size.height - 2);
			
			//* ��BUG_001������ʱ��Ӧ��ʹ�����´���
//			g.setColor(shadow);
//			g.drawLine(x, 2, x, size.height - 2);
//			g.setColor(highlight);
//			g.drawLine(x + 1, 2, x + 1, size.height - 2);
		} 
		else 
		{
			int y = (size.height / 2) - 1;
			g.setColor(shadow);
			g.drawLine(2, y, size.width - 2, y);

			g.setColor(highlight);
			g.drawLine(2, y + 1, size.width - 2, y + 1);
		}
		g.setColor(temp);

		//
		((Graphics2D)g).setStroke(oldStroke);
	}


}
