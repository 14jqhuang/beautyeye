/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BEProgressBarUI.java at 2012-9-24 17:21:09, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch12_progress;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.JProgressBar;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicProgressBarUI;

import org.jb2011.lnf.beautyeye.utils.ReflectHelper;
import org.jb2011.lnf.beautyeye.winlnfutils.WinUtils;

import com.android.ninepatch.NinePatch;

// TODO: Auto-generated Javadoc
/**
 * ��������UIʵ����.
 * 
 * @author Jack Jiang(jb2011@163.com)
 */
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� Start
//�����ʵ�ֲο���WindowsProgressBarUI����ȫ����������ʵ�֣�������û��WindowsProgressBarUI�Ĵ����ˣ�
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� END
public class BEProgressBarUI extends BasicProgressBarUI 
	implements org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.__UseParentPaintSurported
{
    
    /**
     * Creates the ui.
     *
     * @param x the x
     * @return the component ui
     */
    public static ComponentUI createUI(JComponent x) 
    {
    	return new BEProgressBarUI();
    }
    
    //* ��������Jack Jiang��2012-09-07�ռ���
    /**
     * �Ƿ�ʹ�ø���Ļ���ʵ�ַ�����true��ʾ��.
     * <p>
     * ��Ϊ��BE LNF�У��������ͱ�������ʹ��N9ͼ��û��ͨ������JProgressBar�ı���ɫ��ǰ��
     * ɫ�����ƽ���������ɫ����������Ŀ�ľ��ǵ��û������˽�������Background��Foreground
     * ʱ��֮��ʵ���಻ʹ��BE LNF��Ĭ�ϵ�N9ͼ�����ƶ����ø����еķ����������еķ���
     * �Ϳ���֧����ɫ�������ޣ�ֻ�ǳ�㣬���ܹ�������Ӧ�û������󳡾�Ҫ����ʵ�û���ȫ����
     * ͨ��JProgressBar.setUI(new MetalProgressBar())��ʽ���Զ�����ȵ�UIŶ��.
     *
     * @return true, if is use parent paint
     */
    public boolean isUseParentPaint()
    {
    	return progressBar != null 
    		&& (!(progressBar.getForeground() instanceof UIResource)
				|| !(progressBar.getBackground() instanceof UIResource));
    }

    //* copy from BasicProgressBarUI and modified by Jack Jiang
    //������ͨ�������ķ���
	/**
     * All purpose paint method that should do the right thing for almost all
     * linear, determinate progress bars. By setting a few values in the
     * defaults table, things should work just fine to paint your progress bar.
     * Naturally, override this if you are making a circular or semi-circular
     * progress bar.
     *
     * @param g the g
     * @param c the c
     * @see #paintIndeterminate
     * @since 1.4
     */
	protected void paintDeterminate(Graphics g, JComponent c)
	{
		if (!(g instanceof Graphics2D))
		{
			return;
		}
		
		//* ����û������Զ�����ɫ������ʹ�ø��෽����ʵ�ֻ��ƣ�����BE LNF��û��֧����Щ����Ŷ
		if(isUseParentPaint())
		{
			super.paintDeterminate(g, c);
			return;
		}

		Insets b = progressBar.getInsets(); // area for border
		int barRectWidth = progressBar.getWidth() - (b.right + b.left);
		int barRectHeight = progressBar.getHeight() - (b.top + b.bottom);
		
		//* add by Jack Jiang 2012-06-20 START
		//���ƽ������ı���
		paintProgressBarBgImpl(progressBar.getOrientation() == JProgressBar.HORIZONTAL
				, g, b, barRectWidth, barRectHeight);
		//* add by Jack Jiang 2012-06-20 END
			
		if (barRectWidth <= 0 || barRectHeight <= 0)
		{
			return;
		}

		int amountFull = getAmountFull(b, barRectWidth, barRectHeight);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(progressBar.getForeground());//��BE LNF�б���������Ŀǰû������Ŷ����Ϊ�õĶ���n9ͼ

		if (progressBar.getOrientation() == JProgressBar.HORIZONTAL)
		{
			if (WinUtils.isLeftToRight(c))
			{
				paintProgressBarContentImpl(true, g,b.left, b.top
						,amountFull, barRectHeight, -1);
			}
			// TODO ���´���δ������
			else
			{
				paintProgressBarContentImpl(true, g,barRectWidth+b.left, b.top
						, barRectWidth + b.left - amountFull, barRectHeight, -1);
			}
		}
		else
		{ // VERTICAL
			paintProgressBarContentImpl(false, g, b.left, b.top + barRectHeight - amountFull
					, barRectWidth, amountFull, barRectHeight);
		}

		// Deal with possible text painting
		if (progressBar.isStringPainted())
		{
			paintString(g, b.left, b.top, barRectWidth, barRectHeight,amountFull, b);
		}
	}
	
	//* copy from BasicProgressBarUI and modified by Jack Jiang
	//��������������ķ���
	/**
	 * All purpose paint method that should do the right thing for all
	 * linear bouncing-box progress bars.
	 * Override this if you are making another kind of
	 * progress bar.
	 *
	 * @param g the g
	 * @param c the c
	 * @see #paintDeterminate
	 * @since 1.4
	 */
	protected void paintIndeterminate(Graphics g, JComponent c) 
	{
		if (!(g instanceof Graphics2D)) 
		{
			return;
		}
		
		//* ����û������Զ�����ɫ������ʹ�ø��෽����ʵ�ֻ��ƣ�����BE LNF��û��֧����Щ����Ŷ
		if(isUseParentPaint())
		{
			super.paintIndeterminate(g, c);
			return;
		}

		Insets b = progressBar.getInsets(); // area for border
		int barRectWidth = progressBar.getWidth() - (b.right + b.left);
		int barRectHeight = progressBar.getHeight() - (b.top + b.bottom);

		if (barRectWidth <= 0 || barRectHeight <= 0) {
			return;
		}
		
		//* add by Jack Jiang 2012-06-20 START
		//���ƽ������ı���
		paintProgressBarBgImpl(progressBar.getOrientation() == JProgressBar.HORIZONTAL, g,b,barRectWidth, barRectHeight);
		//* add by Jack Jiang 2012-06-20 END
		
		Graphics2D g2 = (Graphics2D)g;

		// Paint the bouncing box.
		boxRect = getBox(boxRect);
		if (boxRect != null) 
		{
			g2.setColor(progressBar.getForeground());//BE LNF�У�Ŀǰ����ɫ����������Ŷ����ʹ�õĶ���N9ͼ
			//��Jack Jiang�޸�
//			g2.fillRect(boxRect.x, boxRect.y, boxRect.width, boxRect.height);
			paintProgressBarContentImpl(progressBar.getOrientation() == JProgressBar.HORIZONTAL
					, g,boxRect.x, boxRect.y, boxRect.width, boxRect.height, boxRect.height);//ˮƽʱ���һ������������Ŷ
		}

		// Deal with possible text painting
		if (progressBar.isStringPainted()) 
		{
			if (progressBar.getOrientation() == JProgressBar.HORIZONTAL) 
			{
				paintString(g2, b.left, b.top, barRectWidth, barRectHeight,boxRect.x, boxRect.width, b);
			}
			else 
			{
				paintString(g2, b.left, b.top, barRectWidth, barRectHeight,boxRect.y, boxRect.height, b);
			}
		}
	}
	
	//* add by Jack Jiang
	/**
	 * ��������ǰֵ�Ļ���ʵ�ַ���.
	 *
	 * @param isHorizontal true��ʾˮƽ�������������ʾ��ֱ������
	 * @param g the g
	 * @param x the x
	 * @param y the y
	 * @param amountFull the amount full
	 * @param barContentRectHeight the bar content rect height
	 * @param barSumHeightForVertival ������ֻ�ڴ�ֱ������ʱ�����壬Ŀ����Ϊ���ڵ�ǰֵ��
	 * С�������Ϊ�˴ﵽN9ͼ��С���Ƹ߶�ʱ��������ʱ��Ҫ
	 */
	protected void paintProgressBarContentImpl(boolean isHorizontal
			,Graphics g,int x,int y,int amountFull,int barContentRectHeight
			, int barSumHeightForVertival)
	{
		NinePatch np;
		
		//��ǰ�Ľ���������.9.pngͼƬ�ı�Ե����䲿����17���أ����Ҫ
		//�����ܿ��С�ڴ�������NinePatch����㷨�޷��������䣬
		//�����жϽ����ܿ��С�ڴ�ֵʱǿ�����ó���С���
		final int n9min = 17;// TODO 14�������.9.pngͼƬ����С����ȵģ�����ó���ʵ��
		if(isHorizontal)
		{
			//�����С��䳤��С��n9ͼ����С�������趨Ϊ��С���ȣ�����N9��������ѿ�Ŷ
			if(amountFull > 0 && amountFull < n9min)
			{
				amountFull = n9min;
			}
			np = __Icon9Factory__.getInstance().getProgressBar_green();
		}
		else
		{
			//�����С��䳤��С��n9ͼ����С�������趨Ϊ��С���ȣ�����N9��������ѿ�Ŷ
			if(barContentRectHeight > 0 && barContentRectHeight < n9min)
			{
				y = barSumHeightForVertival - n9min;
				barContentRectHeight = n9min;
			}
			np = __Icon9Factory__.getInstance().getProgressBar_blue_v();
		}
		//��ʼ����N9ͼ
		np.draw((Graphics2D)g, x, y, amountFull, barContentRectHeight);
	}
	
	//* add by Jack Jiang
	/**
	 * �������������ʵ�ַ���.
	 *
	 * @param isHorizontal the is horizontal
	 * @param g the g
	 * @param b the b
	 * @param barRectWidth the bar rect width
	 * @param barRectHeight the bar rect height
	 */
	protected void paintProgressBarBgImpl(boolean isHorizontal,Graphics g,Insets b,int barRectWidth,int barRectHeight)
	{
		NinePatch np;
		if(isHorizontal)
			np = __Icon9Factory__.getInstance().getProgressBarBg();
		else
			np = __Icon9Factory__.getInstance().getProgressBarBg_v();
		np.draw((Graphics2D)g, b.left, b.top, barRectWidth, barRectHeight);
	}
	
	//* ԭ�����ڱ������в��ɼ����޷����ã�����ֻ�ܸ��ƹ�����
	/**
	 * Paints the progress string.
	 *
	 * @param g Graphics used for drawing.
	 * @param x x location of bounding box
	 * @param y y location of bounding box
	 * @param width width of bounding box
	 * @param height height of bounding box
	 * @param fillStart start location, in x or y depending on orientation,
	 *        of the filled portion of the progress bar.
	 * @param amountFull size of the fill region, either width or height
	 *        depending upon orientation.
	 * @param b Insets of the progress bar.
	 */
	private void paintString(Graphics g, int x, int y, int width, int height,
			int fillStart, int amountFull, Insets b) 
	{
		//* ��Jack Jiang�޸ģ������еı�������private����ʵ��ȫ����Ū��protected���������Ҫȫ���Ѹ÷�����������
		//* �������������sun�ķǹ���api��ʹ���ڲ�ͬ��java�汾���м��������⣨����SwingUtilities2�࣬��1.5��
		//* λ��com.sun.swing.**����1.6��1.7���Ƿ���sun.swing��ģ������Ժ���İ汾�����᲻���λ��Ҳ˵��������
		//* ����Ϊ�˼����ԣ��˴����÷������������ĵ��ø���˽�з���paintString(��������������ǵ��ò����˸����˽�з�������)
		ReflectHelper.invokeMethod(BasicProgressBarUI.class, this, "paintString"
				, new Class[]{Graphics.class, int.class, int.class, int.class, int.class, int.class, int.class, Insets.class}
				, new Object[]{g,x,y,width,height,fillStart,amountFull,b});
	}
}

