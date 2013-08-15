/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BEScrollBarUI.java at 2012-9-24 17:22:37, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch4_scroll;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicScrollBarUI;

import org.jb2011.lnf.beautyeye.utils.BEUtils;

import com.android.ninepatch.NinePatch;

// TODO: Auto-generated Javadoc
/**
 * �����ǹ�������UIʵ��.
 * 
 * @author Jack Jiang(jb2011@163.com), 2009-09-01
 * @version 1.0 
 */
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� Start
//�����ʵ�ֲο���Windows LNF�е�WindowsScrollBarUI.
//ע�������������˼�ͷ��ť�ο���xp�����ʵ�֣�δ���޸ģ�����ⲿ���߼�������WindowsScrollBarUI������ȫһ����.
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� END
public class BEScrollBarUI extends BasicScrollBarUI 
{
	/**
	 * Creates a UI for a JScrollBar.
	 *
	 * @param c the text field
	 * @return the UI
	 */
	public static ComponentUI createUI(JComponent c) 
	{
		return new BEScrollBarUI();
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicScrollBarUI#createDecreaseButton(int)
	 */
	protected JButton createDecreaseButton(int orientation) 
	{
		return new WindowsArrowButton(orientation,
				UIManager.getColor("ScrollBar.thumb"),
				UIManager.getColor("ScrollBar.thumbShadow"),
				UIManager.getColor("ScrollBar.thumbDarkShadow"),
				UIManager.getColor("ScrollBar.thumbHighlight"));
	}

	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicScrollBarUI#createIncreaseButton(int)
	 */
	protected JButton createIncreaseButton(int orientation)  
	{
		return new WindowsArrowButton(orientation,
				UIManager.getColor("ScrollBar.thumb"),
				UIManager.getColor("ScrollBar.thumbShadow"),
				UIManager.getColor("ScrollBar.thumbDarkShadow"),
				UIManager.getColor("ScrollBar.thumbHighlight"));
	}

	/**
	 * WindowsArrowButton is used for the buttons to position the
	 * document up/down. It differs from BasicArrowButton in that the
	 * preferred size is always a square.
	 */
	protected class WindowsArrowButton extends BasicArrowButton
	{

		/**
		 * Instantiates a new windows arrow button.
		 *
		 * @param direction the direction
		 * @param background the background
		 * @param shadow the shadow
		 * @param darkShadow the dark shadow
		 * @param highlight the highlight
		 */
		public WindowsArrowButton(int direction, Color background, Color shadow,
				Color darkShadow, Color highlight)
		{
			super(direction, background, shadow, darkShadow, highlight);
		}

		/**
		 * Instantiates a new windows arrow button.
		 *
		 * @param direction the direction
		 */
		public WindowsArrowButton(int direction) {
			super(direction);
		}

		/* (non-Javadoc)
		 * @see javax.swing.plaf.basic.BasicArrowButton#paint(java.awt.Graphics)
		 */
		public void paint(Graphics g) 
		{
//			NLXPStyle xp = NLXPStyle.getXP();
//			if (xp != null) 
			{
				ButtonModel model = getModel();
//				Skin skin = xp.getSkin(scrollbar, Part.SBP_ARROWBTN);
//				State state = null;

//				// normal, rollover, pressed, disabled
//				if (model.isArmed() && model.isPressed()) 
//				{
//					switch (direction) 
//					{
//						case NORTH: state = State.UPPRESSED;    break;
//						case SOUTH: state = State.DOWNPRESSED;  break;
//						case WEST:  state = State.LEFTPRESSED;  break;
//						case EAST:  state = State.RIGHTPRESSED; break;
//					}
//				} 
//				else if (!model.isEnabled()) 
//				{
//					switch (direction) {
//						case NORTH: state = State.UPDISABLED;    break;
//						case SOUTH: state = State.DOWNDISABLED;  break;
//						case WEST:  state = State.LEFTDISABLED;  break;
//						case EAST:  state = State.RIGHTDISABLED; break;
//					}
//				} 
//				else if (model.isRollover() || model.isPressed())
//				{
//					switch (direction) {
//						case NORTH: state = State.UPHOT;    break;
//						case SOUTH: state = State.DOWNHOT;  break;
//						case WEST:  state = State.LEFTHOT;  break;
//						case EAST:  state = State.RIGHTHOT; break;
//					}
//				} 
//				else 
//				{
//					switch (direction)
//					{
//						case NORTH: state = State.UPNORMAL;    break;
//						case SOUTH: state = State.DOWNNORMAL;  break;
//						case WEST:  state = State.LEFTNORMAL;  break;
//						case EAST:  state = State.RIGHTNORMAL; break;
//					}
//				}

				//ԭʵ�֣�windows��ʽ��
//				skin.paintSkin(g, 0, 0, getWidth(), getHeight(), state);
				//2012-01-10 by jsʵ���Զ�����ʽ
				Graphics2D g2 = (Graphics2D)g;
				switch(direction)
				{
					case NORTH: 
						if(model.isRollover())
							__Icon9Factory__.getInstance().getScrollBarArrow_toTop_rover().draw(g2, 0, 0,getWidth(), getHeight());
						else
							__Icon9Factory__.getInstance().getScrollBarArrow_toTop().draw(g2, 0, 0,getWidth(), getHeight());
						break;
					case SOUTH:
						if(model.isRollover())
							__Icon9Factory__.getInstance().getScrollBarArrow_toBottom_rover().draw(g2, 0, 0,getWidth(), getHeight());
						else
							__Icon9Factory__.getInstance().getScrollBarArrow_toBottom().draw(g2, 0, 0,getWidth(), getHeight());
						break;
					case WEST:
						if(model.isRollover())
							__Icon9Factory__.getInstance().getScrollBarArrow_toLeft_rover().draw(g2, 0, 0,getWidth(), getHeight());
						else
							__Icon9Factory__.getInstance().getScrollBarArrow_toLeft().draw(g2, 0, 0,getWidth(), getHeight());
						break;
					case EAST: 
						if(model.isRollover())
							__Icon9Factory__.getInstance().getScrollBarArrow_toRight_rover().draw(g2, 0, 0,getWidth(), getHeight());
						else
							__Icon9Factory__.getInstance().getScrollBarArrow_toRight().draw(g2, 0, 0,getWidth(), getHeight());
						break;
				}
			} 
//			else 
//			{
//				super.paint(g);
//			}
		}

		/* (non-Javadoc)
		 * @see javax.swing.plaf.basic.BasicArrowButton#getPreferredSize()
		 */
		public Dimension getPreferredSize() 
		{
			int size = 16;
			if (scrollbar != null) 
			{
				switch (scrollbar.getOrientation()) 
				{
					case JScrollBar.VERTICAL:
						size = scrollbar.getWidth();
						break;
					case JScrollBar.HORIZONTAL:
						size = scrollbar.getHeight();
						break;
				}
				size = Math.max(size, 5);
			}
			return new Dimension(size, size);
		}
	}
	//----------------------------------------------------------------------------------- END
	
	//----------------------------------------------------------------------------------- ���θ�������岿��
	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicScrollBarUI#paintTrack(java.awt.Graphics, javax.swing.JComponent, java.awt.Rectangle)
	 */
	protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds)  
	{
    	if(c==null||g==null)	
			return;
		Graphics2D g2 = (Graphics2D)g;
		
		Paint oldp= g2.getPaint();
		int w = trackBounds.width;
		int h = trackBounds.height;	
		int x = trackBounds.x;
		int y = trackBounds.y;

		if(this.scrollbar.getOrientation()==JScrollBar.VERTICAL)
		{
//			//1/2������
//			GradientPaint gp = new GradientPaint(x, y
//					, GraphicHandler.getColor(trackColor,-15,-15,-15), w/2, y,trackColor);
//			g2.setPaint(gp);
//			g2.fillRect(x, y, w/2, h);
//
//			g2.setPaint(oldp);
//			g2.setColor(trackColor);
//			g2.fillRect(w/2, y, w/2, h);
			
			//** ����켣ʵ��
			int hhhWidth = 5;
			int px = (w-hhhWidth)/2;
			int delta = 50;
			//��1��
			g2.setColor(new Color(150+delta,151+delta,146+delta));
			g2.drawLine(px+0,y+10,px+0,y+h-10);
			//��2��
			g2.setColor(new Color(160+delta,160+delta,162+delta));
			g2.drawLine(px+1,y+10,px+1,y+h-10);
			//��3��
			g2.setColor(new Color(163+delta,162+delta,167+delta));
			g2.drawLine(px+2,y+10,px+2,y+h-10);
			//��4��
			g2.setColor(new Color(162+delta,162+delta,162+delta));
			g2.drawLine(px+3,y+10,px+3,y+h-10);
			//��5��
			g2.setColor(new Color(150+delta,150+delta,150+delta));
			g2.drawLine(px+4,y+10,px+4,y+h-10);
		}
		else
		{
			//1/2������
//			GradientPaint gp = new GradientPaint(x, y
//					, GraphicHandler.getColor(trackColor,-15,-15,-15), x, h/2,trackColor);
//			g2.setPaint(gp);
//			g2.fillRect(x, y, w, h/2);
//
//			g2.setPaint(oldp);
//			g2.setColor(trackColor);
//			g2.fillRect(x, h/2, w, h);
			
			//** ����켣ʵ��
			int hhhWidth = 5;
			int py = (h-hhhWidth)/2;
			int delta = 50;
			//��1��
			g2.setColor(new Color(150+delta,151+delta,146+delta));
			g2.drawLine(x+10,py+0,x+w-10,py+0);
			//��2��
			g2.setColor(new Color(160+delta,160+delta,162+delta));
			g2.drawLine(x+10,py+1,x+w-10,py+1);
			//��3��
			g2.setColor(new Color(163+delta,162+delta,167+delta));
			g2.drawLine(x+10,py+2,x+w-10,py+2);
			//��4��
			g2.setColor(new Color(162+delta,162+delta,162+delta));
			g2.drawLine(x+10,py+3,x+w-10,py+3);
			//��5��
			g2.setColor(new Color(150+delta,150+delta,150+delta));
			g2.drawLine(x+10,py+4,x+w-10,py+4); 
		}
	}
	
	/**
	 * ����������.
	 *
	 * @param g the g
	 * @param c the c
	 * @param thumbBounds the thumb bounds
	 */
	protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds)  
	{
		if(thumbBounds.isEmpty() || !scrollbar.isEnabled())	
		{
			return;
		}
		Graphics2D g2 = (Graphics2D)g;
		int w = thumbBounds.width-4;
		int h = thumbBounds.height-4;		
		g2.translate(thumbBounds.x+2, thumbBounds.y+2);
		
//		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		BEUtils.setAntiAliasing(g2, true);
		
		if(this.scrollbar.getOrientation()==JScrollBar.VERTICAL)
		{
			//��ֹthunmb����С�߶ȱ�ͼƬ����С�߶Ȼ�ҪС�������ڻ���ʱ�ͻ������
			//��ʵ��Ŀǰû��û�а취�ܺý������Ϊ��ʹ����������������thumb����
			//������ôС�����Ի�ͼ���ǻ������⣬�������ڲ��϶�ʱ�������������ģ��Ժ��ٽ���ɣ�
			NinePatch np = null;
			if(isDragging)
				np = __Icon9Factory__.getInstance().getScrollBar_pressed_v();
			else if(this.isThumbRollover())
				np = __Icon9Factory__.getInstance().getScrollBar_rover_v();
			else
				np = __Icon9Factory__.getInstance().getScrollBar_v();
			
			//��������и߶�С��NPͼ����С�߶�ʱ�򽻸��˷������ƣ�����NPͼ����佫������棬��Ӱ�������������Ŷ��
			if(h<np.getHeight())
				paintThumbIfSoSmall(g2, 0, 0, w, h);
			else
				np.draw(g2, 0, 0, w, h);
		}
		else
		{
			//��ֹthunmb����С�߶ȱ�ͼƬ����С�߶Ȼ�ҪС�������ڻ���ʱ�ͻ������
			//��ʵ��Ŀǰû��û�а취�ܺý������Ϊ��ʹ����������������thumb����
			//������ôС�����Ի�ͼ���ǻ������⣬�������ڲ��϶�ʱ�������������ģ��Ժ��ٽ���ɣ�
			NinePatch np = null;
			if(isDragging)
				np = __Icon9Factory__.getInstance().getScrollBar_pressed_h();
			else if(this.isThumbRollover())
				np = __Icon9Factory__.getInstance().getScrollBar_rover_h();
			else
				np = __Icon9Factory__.getInstance().getScrollBar_h();
			
			//��������п��С��NPͼ����С���ʱ�򽻸��˷������ƣ�����NPͼ����佫������棬��Ӱ�������������Ŷ��
			if(w<np.getWidth())
				paintThumbIfSoSmall(g2, 0, 0, w, h);
			else
				np.draw(g2, 0, 0, w, h);
		}
		
		g2.translate(-thumbBounds.x, -thumbBounds.y);
//		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		BEUtils.setAntiAliasing(g2, false);
	}
	//----------------------------------------------------------------------------------- END
	
	//* �ο���BasicScrollBarUI����Jack Jiang��2012-09-17�޸�
	/**
	 * ����������ǳ�С��С��С��NPͼ����С��С��ʱ���ô˷���ʵ�ֹ������ľ�ȷ����.
	 *
	 * @param g2 the g2
	 * @param x the x
	 * @param y the y
	 * @param w the w
	 * @param h the h
	 */
	protected void paintThumbIfSoSmall(Graphics2D g2, int x, int y, int w, int h)
	{
		final int NORMAL_ARC = 6;//����Բ��ֱ��
		//���w��h̫Сʱ����Ͳ�����Բ����(ֱ�Ǽ���)��Ҫ��Ȼ��û����ȫԲ�Ƕ����ѿ�
		int arc = ((w <= NORMAL_ARC || h <= NORMAL_ARC)?0:NORMAL_ARC);
		g2.setColor(thumbDarkShadowColor);
		g2.drawRoundRect(x, y, w-1, h-1,arc,arc);//�������������
		g2.setColor(thumbColor);
		g2.fillRoundRect(x+1, y+1, w-2, h-2,arc,arc);//�����������ڲ�
	}
}
