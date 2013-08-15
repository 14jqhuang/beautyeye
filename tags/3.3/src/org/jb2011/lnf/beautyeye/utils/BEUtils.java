/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BEUtils.java at 2012-9-24 17:22:54, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.TexturePaint;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.UIManager;

// TODO: Auto-generated Javadoc
/**
 * The Class BEUtils.
 */
public class BEUtils
{
	/**
	 * ���ö��󼯵�͸���ԣ�����������Container����������ݹ���
	 * �ø�����ڵ������������͸���ԣ�ֱ������е��κ���������������.
	 * 
	 * @param comps ����
	 * @param opaque true��ʾҪ���óɲ�͸���������ʾҪ���ó�͸��
	 */
	public static void componentsOpaque(java.awt.Component[] comps
			, boolean opaque)
	{
		if(comps == null)
			return;
		for (Component c : comps)
		{
			//�ݹ��������������
			if(c instanceof Container)
			{
				if(c instanceof JComponent)
					((JComponent)c).setOpaque(opaque);
				componentsOpaque(((Container)c).getComponents(), opaque);
			}
			else
			{
				if(c instanceof JComponent)
					((JComponent)c).setOpaque(opaque);
			}
		}
	}
	
	/**
	 * ͼ�λ��Ʒ���������.
	 *
	 * @param g2 the g2
	 * @param antiAliasing �Ƿ�����
	 */
	public static void setAntiAliasing(Graphics2D g2 ,boolean antiAliasing)
	{
		if(antiAliasing)
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING
					, RenderingHints.VALUE_ANTIALIAS_ON);
		else
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING
					, RenderingHints.VALUE_ANTIALIAS_OFF);
	}
	
	/**
	 * ���3��������.
	 *
	 * @param g the g
	 * @param x1 3����֮һ��x����
	 * @param y1 3����֮һ��y����
	 * @param x2 3����֮һ��x����
	 * @param y2 3����֮һ��y����
	 * @param x3 3����֮һ��x����
	 * @param y3 3����֮һ��y����
	 * @param c the c
	 */
	public static void fillTriangle(Graphics g
			,int x1,int y1,int x2,int y2
			,int x3,int y3,Color c)
	{
		int[] x = new int[3],y = new int[3];
		// A simple triangle.
		x[0]=x1; x[1]=x2; x[2]=x3;
		y[0]=y1; y[1]=y2; y[2]=y3;
		int n = 3;

		Polygon p = new Polygon(x, y, n);  // This polygon represents a triangle with the above
		                                   //   vertices.
		g.setColor(c);
		g.fillPolygon(p);     // Fills the triangle above.
	}
	
	/**
	 * �������߿򣨱����������ڶ�4���ߵĿ�ѡ��������£����ܻ���4��5���С���
	 * ������Ҫ��ѡ����4�����⣬һ�㲻�Ƽ�ʹ�ã�.<br>.
	 *
	 * @param g the g
	 * @param x the x
	 * @param y the y
	 * @param width the width
	 * @param height the height
	 */
    public static void drawDashedRect(Graphics g,int x,int y,int width,int height) 
    {
    	drawDashedRect(g,x,y,width,height,6,6,2,2);
    }
	
	/**
	 * �������߿򣨱����������ڶ�4���ߵĿ�ѡ��������£����ܻ���4��5���С���
	 * ������Ҫ��ѡ����4�����⣬һ�㲻�Ƽ�ʹ�ã�.
	 *
	 * @param g the g
	 * @param x the x
	 * @param y the y
	 * @param width the width
	 * @param height the height
	 * @param arcWidth the arc width
	 * @param arcHeight the arc height
	 * @param separator_solid ���߶�ʵ�߳���
	 * @param separator_space ���߶οհ׳���
	 * add by js,2009-08-30
	 */
    public static void drawDashedRect(Graphics g,int x,int y,int width,int height
    		,int arcWidth, int arcHeight, int separator_solid, int separator_space) 
    {
//    	drawDashedRect(g,x,y,width,height,step,true,true,true,true);
    	BEUtils.setAntiAliasing((Graphics2D)g, true);
    	
    	//������ʽ
		Stroke oldStroke = ((Graphics2D)g).getStroke();
		Stroke sroke = new BasicStroke(1, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_BEVEL, 0, new float[]{separator_solid, separator_space}, 0);//ʵ�ߣ��հ�
		((Graphics2D)g).setStroke(sroke);
		
		g.drawRoundRect(x, y
				, width-1, height-1 //* һ���ܹ�������⣺ʹ��BasicStrokeʵ�����߻��ƺ��ƺ����Ƶľ���
									//* Ҫ����ͨ��������ʵ�߾�������ƫ��һ�����꣬�˴�-1��Ϊ������������⣬���ѵ���java��bug��
									//* �ѹֵ�����ӡ���߿���ʱҲ������Ī������ƫ��һ�����ص����󣬾����д���һ���о���
				, arcWidth, arcHeight);
		
		((Graphics2D)g).setStroke(oldStroke);
		BEUtils.setAntiAliasing((Graphics2D)g, false);
    }
    
    /**
     * Draw dashed rect.
     *
     * @param g the g
     * @param x the x
     * @param y the y
     * @param width the width
     * @param height the height
     * @param step the step
     * @param top the top
     * @param left the left
     * @param bottom the bottom
     * @param right the right
     */
    public static void drawDashedRect(Graphics g,int x,int y,int width,int height,int step//,boolean drawLeft$Right
    		,boolean top,boolean left,boolean bottom,boolean right) 
    {
    	int vx,vy;

    	int drawStep = step==0?1:2*step;
    	int drawLingStep = step==0?1:step;
    	// draw upper and lower horizontal dashes
    	for (vx = x; vx < (x + width); vx+=drawStep) 
    	{
    		if(top)
    			g.fillRect(vx, y, drawLingStep, 1);
    		if(bottom)
    			g.fillRect(vx, y + height-1, drawLingStep, 1);
    	}

//    	if(drawLeft$Right)
    		// draw left and right vertical dashes
    		for (vy = y; vy < (y + height); vy+=drawStep) 
    		{
    			if(left)
    				g.fillRect(x, vy, 1, drawLingStep);
    			if(right)
    				g.fillRect(x+width-1, vy, 1, drawLingStep);
    		}
    }
    
    /**
     * �Ի�׼��ɫ��RGBͨ�����мӼ���õ�����ɫ��.
     *
     * @param basic ��׼ɫ��
     * @param r Redͨ��������ֵ�������Ǹ���
     * @param g Geenͨ��������ֵ�������Ǹ���
     * @param b Blueͨ��������ֵ�������Ǹ���
     * @return the color
     */
    public static Color getColor(Color basic,int r, int g, int b)
	{
		return new Color(getColorInt(basic.getRed()+r)
				,getColorInt(basic.getGreen()+g)
				,getColorInt(basic.getBlue()+b)
				,getColorInt(basic.getAlpha()));
	}
    
    /**
     * �Ի�׼��ɫ��RGBAͨ�����мӼ���õ�����ɫ��.
     *
     * @param basic ��׼ɫ��
     * @param r Redͨ��������ֵ�������Ǹ���
     * @param g Geenͨ��������ֵ�������Ǹ���
     * @param b Blueͨ��������ֵ�������Ǹ���
     * @param a Alphaͨ��������ֵ�������Ǹ���
     * @return the color
     */
    public static Color getColor(Color basic,int r, int g, int b,int a)
	{
		return new Color(getColorInt(basic.getRed()+r)
				,getColorInt(basic.getGreen()+g)
				,getColorInt(basic.getBlue()+b)
				,getColorInt(basic.getAlpha()+a));
	}
    
    /**
     * Gets the color int.
     *
     * @param rgb the rgb
     * @return the color int
     */
    public static int getColorInt(int rgb)
	{
		return rgb<0?0:(rgb>255?255:rgb);
	}
    
	/**
	 * ����ַ��������ؿ��.
	 *
	 * @param fm the fm
	 * @param str the str
	 * @return the str pix width
	 * @see FontMetrics#stringWidth(String)
	 */
	public static int getStrPixWidth(FontMetrics fm,String str)
    {
    	return fm.stringWidth(str+"");
    }
	
	/**
	 * ����ַ��������ؿ��.
	 *
	 * @param f the f
	 * @param str the str
	 * @return the str pix width
	 * @see #getStrPixWidth(FontMetrics, String)
	 */
	public static int getStrPixWidth(Font f,String str)
    {
    	return getStrPixWidth(Toolkit.getDefaultToolkit().getFontMetrics(f),str);
    }
	
	/**
	 * ���һ���ɰ�ָ��ͼƬ����������䷽ʽ�Ķ������ô˶����ʵ��ͼƬ��䱳��Ч����
	 * 
	 * <pre>
	 * ʾ�����£�����������ｫʵ��һ����ָ��ͼƬ���Ч��Ϊ�����������󣩣�
	 * private FixedLayoutPane inputPane = new FixedLayoutPane() {
	 * //����Ūһ��ͼƬƽ�̵ı���
	 * private TexturePaint paint = createTexturePaint(LaunchIconFactory.getInstance()
	 * .getImage("/login_background.png").getImage());
	 * //��д������ʵ��ͼƬƽ�̵ı���
	 * protected void paintComponent(Graphics g) {
	 * super.paintComponent(g);
	 * Graphics2D g2d = (Graphics2D) g;
	 * g2d.setPaint(paint);
	 * g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
	 * }
	 * };
	 * </pre>
	 *
	 * @param image ���ͼƬ����ͼƬһ��1���ظ�N���أ�����1���ؿ�����ظ���伴�ɴﵽĿ�ģ�
	 * @return the texture paint
	 */
    public static TexturePaint createTexturePaint(Image image) 
    {
        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);
        BufferedImage bi = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bi.createGraphics();
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();
        return new TexturePaint(bi, new Rectangle(0, 0, imageWidth, imageHeight));
    }
    
	/**
	 * Gets the int.
	 *
	 * @param key the key
	 * @param defaultValue the default value
	 * @return the int
	 */
	public static int getInt(Object key, int defaultValue)
	{
		Object value = UIManager.get(key);

		if (value instanceof Integer)
		{
			return ((Integer) value).intValue();
		}
		if (value instanceof String)
		{
			try
			{
				return Integer.parseInt((String) value);
			}
			catch (NumberFormatException nfe)
			{
			}
		}
		return defaultValue;
	}
	
	/**
	 * ��ָ�������������������ʸ�����Ч��.
	 *
	 * @param g2 the g2
	 * @param baseColor the base color
	 * @param x the x
	 * @param y the y
	 * @param w the w
	 * @param h the h
	 * @param arc the arc
	 */
    public static void fillTextureRoundRec(Graphics2D g2,Color baseColor
    		,int x,int y,int w,int h,int arc)
    {
    	fillTextureRoundRec(g2,baseColor
        		, x, y, w, h,arc,35);
    }
    
    /**
     * ��ָ�������������������ʸ�����Ч��.
     *
     * @param g2 the g2
     * @param baseColor the base color
     * @param x the x
     * @param y the y
     * @param w the w
     * @param h the h
     * @param arc the arc
     * @param colorDelta ������ɫ���ϣ��뽥��ֹɫ���£���RGBɫ�ʸ����������ʾ�䵭������ʾ����
     */
    public static void fillTextureRoundRec(Graphics2D g2,Color baseColor
    		,int x,int y,int w,int h,int arc,int colorDelta)
    {
		setAntiAliasing(g2, true);
		//�������
		Paint oldpaint = g2.getPaint();
		GradientPaint gp = new GradientPaint(x, y
				//�������ɫ��ֹɫRGBǳ35
				,getColor(baseColor, colorDelta, colorDelta, colorDelta)
				,x, y+h,baseColor
                );
		g2.setPaint(gp);
		g2.fillRoundRect(x, y, w, h,arc,arc);
		g2.setPaint(oldpaint);
		setAntiAliasing(g2, false);
    }
}
