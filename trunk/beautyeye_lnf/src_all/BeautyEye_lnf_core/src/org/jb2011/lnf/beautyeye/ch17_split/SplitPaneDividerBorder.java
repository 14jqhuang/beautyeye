/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * SplitPaneDividerBorder.java at 2012-9-24 17:22:19, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch17_split;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JSplitPane;
import javax.swing.border.Border;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;

// TODO: Auto-generated Javadoc
/**
 * �ָ�����borderʵ����.
 * <p>
 * Draws the border around the divider in a splitpane. To get the appropriate effect, this
 * needs to be used with a SplitPaneBorder.
 * 
 * @author Jack Jiang(jb2011@163.com)
 */
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� Start
//����ο���jdk1.6_u18��javax.swing.plaf.basic.BasicBorders
//	.SplitPaneDividerBorder��Դ�룬��Ҫ�޸���UI���ʵ�ֲ���
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� END
public class SplitPaneDividerBorder implements Border, UIResource
{
//	javax.swing.plaf.basic.BasicBorders.SplitPaneDividerBorder
//	private Color highlight;
//	private Color shadow;

//	public SplitPaneDividerBorder(Color highlight, Color shadow)
//	{
//		this.highlight = highlight;
//		this.shadow = shadow;
//	}

	/* (non-Javadoc)
 * @see javax.swing.border.Border#paintBorder(java.awt.Component, java.awt.Graphics, int, int, int, int)
 */
public void paintBorder(Component c, Graphics g, int x, int y, int width,
			int height)
	{
		//��Ŀǰ���Ӿ�Ч���²���Ҫ���border�Ļ���Ŷ
//		Graphics2D g2d = (Graphics2D) g;
//		Component child;
//		Rectangle cBounds;
//		JSplitPane splitPane = ((BasicSplitPaneDivider) c).getBasicSplitPaneUI().getSplitPane();
//		Dimension size = c.getSize();
//
//		child = splitPane.getLeftComponent();
//		// This is needed for the space between the divider and end of
//		// splitpane.
//		g.setColor(c.getBackground());
//		g.drawRect(x, y, width - 1, height - 1);
//		
//		if (splitPane.getOrientation() == JSplitPane.HORIZONTAL_SPLIT)
//		{
////			if (child != null)
////			{
////				g.setColor(shadow);//highlight);
////				g.drawLine(0, 0, 0, size.height);
////			}
////			child = splitPane.getRightComponent();
////			if (child != null)
////			{
////				g.setColor(shadow);
////				g.drawLine(size.width - 1, 0, size.width - 1, size.height);
////			}
//		}
//		else
//		{
////			if (child != null)
////			{
////				g.setColor(shadow);//highlight);
////				g.drawLine(0, 0, size.width, 0);
////			}
////			child = splitPane.getRightComponent();
////			if (child != null)
////			{
////				g.setColor(shadow);
////			    g.drawLine(0, size.height - 1, size.width,size.height - 1);
////
////			}
//		}
	}

	/* (non-Javadoc)
	 * @see javax.swing.border.Border#getBorderInsets(java.awt.Component)
	 */
	public Insets getBorderInsets(Component c)
	{
		Insets insets = new Insets(0, 0, 0, 0);
		if (c instanceof BasicSplitPaneDivider)
		{
			BasicSplitPaneUI bspui = ((BasicSplitPaneDivider) c)
					.getBasicSplitPaneUI();

			if (bspui != null)
			{
				JSplitPane splitPane = bspui.getSplitPane();

				if (splitPane != null)
				{
					if (splitPane.getOrientation() == JSplitPane.HORIZONTAL_SPLIT)
					{
						insets.top = insets.bottom = 0;
						insets.left = insets.right = 1;
						return insets;
					}
					// VERTICAL_SPLIT
					insets.top = insets.bottom = 1;
					insets.left = insets.right = 0;
					return insets;
				}
			}
		}
		insets.top = insets.bottom = insets.left = insets.right = 1;
		return insets;
	}

	/* (non-Javadoc)
	 * @see javax.swing.border.Border#isBorderOpaque()
	 */
	public boolean isBorderOpaque()
	{
		return true;
	}
}