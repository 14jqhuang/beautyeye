/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BESplitPaneDivider.java at 2012-9-24 17:22:19, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch17_split;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;

import org.jb2011.lnf.beautyeye.utils.BEUtils;

import sun.swing.DefaultLookup;

// TODO: Auto-generated Javadoc
/**
 * ��������ϵķָ���ʵ����.
 * <p>
 * TODO ����Touch��ť��λ�õȶ��ǿ��Զ��Ƶģ�Ŀǰû�и��õ�������У��Ժ�������������ȡ�
 * 
 * @author Jack Jiang(jb2011@163.com), 2012-07-13
 * @version 1.0
 */
public class BESplitPaneDivider extends BasicSplitPaneDivider
{
	//copy from BasicSplitPaneDivider
	/** The one touch size. */
	private int oneTouchSize;

	//* add by jb201
	//* TODO ��������������UIManager�����Ա�δ��ʹ���߽�������Ŷ
	/** The TOUC h_ butto n_ color. */
	protected final Color TOUCH_BUTTON_COLOR = new Color(58,135,173);
	
	//* add by jb201
	//��ˮƽSplitePane״̬�£��м䴥��װ����װ�ΰ�ť�Ŀ�� 
	/** The Constant TOUCH_DECRATED_BUTTON_W. */
	protected final static int TOUCH_DECRATED_BUTTON_W = 5;//* TODO ��������������UIManager�����Ա�δ��ʹ���߽�������Ŷ
	//��ˮƽSplitePane״̬�£��м䴥��װ����װ�ΰ�ť�ĸ߶� 
	/** The Constant TOUCH_DECRATED_BUTTON_H. */
	protected final static int TOUCH_DECRATED_BUTTON_H = 30;//* TODO ��������������UIManager�����Ա�δ��ʹ���߽�������Ŷ

	//�ָ�����ֱ�ߵ���ɫ 
	/** The Constant TOUCH_DECRATED_BUTTON_COLOR. */
	protected final static Color TOUCH_DECRATED_BUTTON_COLOR = new Color(180,180,180);//* TODO ����ɫ������������UIManager�����Ա�δ��ʹ���߽�������Ŷ
	//�ָ�����ֱ�ߵĸ�����ɫ�������γɸ߶Աȶȵ�����Ч���� 
	/** The Constant TOUCH_DECRATED_BUTTON_HILIGHT_COLOR. */
	protected final static Color TOUCH_DECRATED_BUTTON_HILIGHT_COLOR = Color.white;//* TODO ����ɫ������������UIManager�����Ա�δ��ʹ���߽�������Ŷ
	
	/**
	 * Creates a new Windows SplitPaneDivider.
	 *
	 * @param ui the ui
	 */
	public BESplitPaneDivider(BasicSplitPaneUI ui) 
	{
		super(ui);

		//copy from BasicSplitPaneDivider
		oneTouchSize = DefaultLookup.getInt(ui.getSplitPane(), ui,
				"SplitPane.oneTouchButtonSize", ONE_TOUCH_SIZE);
	} 

	//copy from BasicSplitPaneDivider and modified by jb2011
	/**
	 * Paints the divider.
	 *
	 * @param g the g
	 */
	public void paint(Graphics g)
	{
		Color bgColor = (splitPane.hasFocus()) ?
				UIManager.getColor("SplitPane.shadow") :getBackground();
		Dimension size = getSize();
		Graphics2D g2=((Graphics2D)g);
		BEUtils.setAntiAliasing((Graphics2D)g, true);
//		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//				RenderingHints.VALUE_ANTIALIAS_ON);
		if(bgColor != null)
		{
			int orient = this.splitPane.getOrientation();
			if(orient==JSplitPane.HORIZONTAL_SPLIT)
			{
				int halfWidth=size.width/2;
				int halfHeight=size.height/2;
				
				//------------------------��ˮƽ���л���������
				//������ʽ
				Stroke oldStroke = ((Graphics2D)g).getStroke();
				Stroke sroke = new BasicStroke(1, BasicStroke.CAP_BUTT,
						BasicStroke.JOIN_BEVEL, 0, new float[]{2, 2}, 0);//ʵ�ߣ��հ�
				((Graphics2D)g).setStroke(sroke);
				
				g.setColor(TOUCH_DECRATED_BUTTON_COLOR);//bgColor);
//				g.fillRect(0, 0, size.width, size.height);
				g.drawLine(halfWidth+0, 0, halfWidth+0, size.height);
				//�������ұ��ٻ�һ���߶Աȶȵ����ߴӶ��γ�����Ч��
				g.setColor(TOUCH_DECRATED_BUTTON_HILIGHT_COLOR);
				g.drawLine(halfWidth+1, 0, halfWidth+1, size.height);
				
				((Graphics2D)g).setStroke(oldStroke);

				//------------------------����䴥��װ����
				int decratedButton_w = TOUCH_DECRATED_BUTTON_W;
				int decratedButton_h= TOUCH_DECRATED_BUTTON_H;//18;
				int diverTouchStartX = halfWidth - decratedButton_w/2 ;
				__Icon9Factory__.getInstance().getSplitTouchBg1()
					.draw((Graphics2D)g, diverTouchStartX, halfHeight - decratedButton_h/2
							, decratedButton_w, decratedButton_h);
			}
			else
			{
				int halfHeight = size.height/2;
				int halfWidth = size.width/2;
				
				//------------------------�ȴ�ֱ���л��ָ�������
				//������ʽ
				Stroke oldStroke = ((Graphics2D)g).getStroke();
				Stroke sroke = new BasicStroke(1, BasicStroke.CAP_BUTT,
						BasicStroke.JOIN_BEVEL, 0, new float[]{2, 2}, 0);//ʵ�ߣ��հ�
				((Graphics2D)g).setStroke(sroke);
				
				g.setColor(TOUCH_DECRATED_BUTTON_COLOR);//bgColor);
//				g.fillRect(0, 0, size.width, size.height);
				g.drawLine(0, halfHeight +0, size.width, halfHeight +0);
				//�������±��ٻ�һ���߶Աȶȵĺ��ߴӶ��γ�����Ч��
				g.setColor(TOUCH_DECRATED_BUTTON_HILIGHT_COLOR);
				g.drawLine(0, halfHeight +1, size.width, halfHeight +1);
				
				((Graphics2D)g).setStroke(oldStroke);

				//------------------------����䴥��װ����
				int decratedButton_w = TOUCH_DECRATED_BUTTON_W;
				int decratedButton_h= TOUCH_DECRATED_BUTTON_H;//18;
				int diverTouchStartY = halfHeight - decratedButton_w/2;
				__Icon9Factory__.getInstance().getSplitTouchBg1()
					.draw((Graphics2D)g, halfWidth - decratedButton_h, diverTouchStartY
							, decratedButton_h, decratedButton_w);
			}
//			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//					RenderingHints.VALUE_ANTIALIAS_OFF);
			BEUtils.setAntiAliasing((Graphics2D)g, false);
		}

		super.paint(g);
	}

	//copy from BasicSplitPaneDivider and modified by jb2011
	//���෽���̳�������Ʋ��ѣ��˴�ֻ��ȫ�����������룬�����޸ġ�
	//��2012-07-13��������ֻ���˹��ڼ�ͷ��ť�������ɫ�ĸı䡣
	/**
	 * Creates and return an instance of JButton that can be used to
	 * collapse the left component in the split pane.
	 *
	 * @return the j button
	 */
	protected JButton createLeftOneTouchButton()
	{
		JButton b = new JButton()
		{
			public void setBorder(Border b)
			{
			}

			public void paint(Graphics g)
			{
				if (splitPane != null)
				{
					int[] xs = new int[3];
					int[] ys = new int[3];
					int blockSize;

					// Fill the background first ...
					g.setColor(this.getBackground());
					g.fillRect(0, 0, this.getWidth(), this.getHeight());

					//modified by jb2011
					// ... then draw the arrow.
					g.setColor(TOUCH_BUTTON_COLOR);//Color.black);

					//* ����������
					BEUtils.setAntiAliasing((Graphics2D)g, true);
					
					if (orientation == JSplitPane.VERTICAL_SPLIT)
					{
						blockSize = Math.min(getHeight(), oneTouchSize);
						xs[0] = blockSize;
						xs[1] = 0;
						xs[2] = blockSize << 1;
						ys[0] = 0;
						ys[1] = ys[2] = blockSize;
						g.drawPolygon(xs, ys, 3); // Little trick to make the
						// arrows of equal size
					}
					else
					{
						blockSize = Math.min(getWidth(), oneTouchSize);
						xs[0] = xs[2] = blockSize;
						xs[1] = 0;
						ys[0] = 0;
						ys[1] = blockSize;
						ys[2] = blockSize << 1;
					}
					g.fillPolygon(xs, ys, 3);
					
					//* �رշ�����
					BEUtils.setAntiAliasing((Graphics2D)g, false);
				}
			}

			// Don't want the button to participate in focus traversable.
			public boolean isFocusTraversable()
			{
				return false;
			}
		};
		b.setMinimumSize(new Dimension(oneTouchSize, oneTouchSize));
		b.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		b.setFocusPainted(false);
		b.setBorderPainted(false);
		b.setRequestFocusEnabled(false);
		return b;
	}

	//copy from BasicSplitPaneDivider and modified by jb2011
	//���෽���̳�������Ʋ��ѣ��˴�ֻ��ȫ�����������룬�����޸ġ�
	//��2012-07-13��������ֻ���˹��ڼ�ͷ��ť�������ɫ�ĸı䡣
	/**
	 * Creates and return an instance of JButton that can be used to
	 * collapse the right component in the split pane.
	 *
	 * @return the j button
	 */
	protected JButton createRightOneTouchButton() {
		JButton b = new JButton() {
			public void setBorder(Border border) {
			}
			public void paint(Graphics g) {
				if (splitPane != null) {
					int[]          xs = new int[3];
					int[]          ys = new int[3];
					int            blockSize;

					// Fill the background first ...
					g.setColor(this.getBackground());
					g.fillRect(0, 0, this.getWidth(),
							this.getHeight());

					//* ����������
					BEUtils.setAntiAliasing((Graphics2D)g, true);
					
					// ... then draw the arrow.
					if (orientation == JSplitPane.VERTICAL_SPLIT) {
						blockSize = Math.min(getHeight(), oneTouchSize);
						xs[0] = blockSize;
						xs[1] = blockSize << 1;
						xs[2] = 0;
						ys[0] = blockSize;
						ys[1] = ys[2] = 0;
					}
					else {
						blockSize = Math.min(getWidth(), oneTouchSize);
						xs[0] = xs[2] = 0;
						xs[1] = blockSize;
						ys[0] = 0;
						ys[1] = blockSize;
						ys[2] = blockSize << 1;
					}

					//modified by jb2011
					g.setColor(TOUCH_BUTTON_COLOR);//Color.black);

					g.fillPolygon(xs, ys, 3);
					
					//* �رշ�����
					BEUtils.setAntiAliasing((Graphics2D)g, false);
				}
			}
			// Don't want the button to participate in focus traversable.
			public boolean isFocusTraversable() {
				return false;
			}
		};
		b.setMinimumSize(new Dimension(oneTouchSize, oneTouchSize));
		b.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		b.setFocusPainted(false);
		b.setBorderPainted(false);
		b.setRequestFocusEnabled(false);
		return b;
	}
}
