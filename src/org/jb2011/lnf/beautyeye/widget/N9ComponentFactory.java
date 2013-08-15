/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * N9ComponentFactory.java at 2012-9-24 17:22:59, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.widget;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import com.android.ninepatch.NinePatch;

// TODO: Auto-generated Javadoc
/**
 * ʹ��NinePatch��Ϊ������һЩ���������������.
 * <p>
 * Ŀǰ��Щ�����Ҫ����SwingSets2����ʾ���룬�Ա����ٷ���SwingSets2ʹ
 * �����ǵ�������BeautyEye�γɽϺõĴ��䡣
 * 
 * @author Jack Jiang(jb2011@163.com)
 */
public class N9ComponentFactory extends JLabel
{
	
	/**
	 * Creates a new N9Component object.
	 *
	 * @param text the text
	 * @param n9 the n9
	 * @param is the is
	 * @param foregroundColor the foreground color
	 * @param f the f
	 * @return the j label
	 */
	public static JLabel createLabel_root(String text
			, final NinePatch n9, Insets is
			, Color foregroundColor, Font f)
	{
		JLabel l = new JLabel(text){
			public void paintComponent(Graphics g) {
				n9.draw((Graphics2D)g, 0, 0, this.getWidth(), this.getHeight());
				super.paintComponent(g);
			}
		};
		if(is != null)
			l.setBorder(BorderFactory.createEmptyBorder(is.top, is.left, is.bottom, is.right));
		if(foregroundColor != null)
			l.setForeground(foregroundColor);
		if(f != null)
			l.setFont(f);

		return l;
	}

	/**
	 * Creates a new N9Component object.
	 *
	 * @param txt the txt
	 * @return the j label
	 */
	public static JLabel createLabel_style1(String txt)
	{
		return createLabel_root(txt,__Icon9Factory__.getInstance().getHintBgLightBlue()
				,new Insets(1, 6, 1, 6),Color.white,new Font("����",Font.BOLD,12));
	}
	
	/**
	 * Creates a new N9Component object.
	 *
	 * @param txt the txt
	 * @return the j label
	 */
	public static JLabel createLabel_style2(String txt)
	{
		return createLabel_root(txt,__Icon9Factory__.getInstance().getTipsBg()
				,new Insets(15, 3, 28, 3),new Color(139,119,75)
		,null);
	}
	
	/**
	 * Creates a new N9Component object.
	 *
	 * @param txt the txt
	 * @return the j label
	 */
	public static JLabel createLabel_style3(String txt)
	{
		return createLabel_root(txt,__Icon9Factory__.getInstance().getOrangeBaloon()
				,new Insets(4, 9, 9, 9)//3, 9, 8, 9)
				,new Color(255,255,255)
		,null);
	}
	
	/**
	 * Creates a new N9Component object.
	 *
	 * @param txt the txt
	 * @return the j label
	 */
	public static JLabel createLabel_style4(String txt)
	{
		return createLabel_root(txt,__Icon9Factory__.getInstance().getHintBgLightGray()
				,new Insets(2, 8, 2, 8),Color.white,new Font("����",Font.PLAIN,12));
	}

	/**
	 * Creates a new N9Component object.
	 *
	 * @return the image bg panel
	 */
	public static ImageBgPanel createPanel_style1()
	{
		return createPanel_style1(new Insets(8, 0, 26, 10));
	}
	
	/**
	 * Creates a new N9Component object.
	 *
	 * @param is the is
	 * @return the image bg panel
	 */
	public static ImageBgPanel createPanel_style1(Insets is)
	{
		ImageBgPanel p = new ImageBgPanel().setN9(__Icon9Factory__.getInstance().getPanelBg());
		if(is != null)
			p.setBorder(BorderFactory.createEmptyBorder(is.top,is.left,is.bottom,is.right));
		return p;
	}

}
