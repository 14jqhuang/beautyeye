/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BEPopupMenuSeparatorUI.java at 2012-9-24 17:22:51, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */

package org.jb2011.lnf.beautyeye.ch9_menu;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JComponent;
import javax.swing.JSeparator;
import javax.swing.LookAndFeel;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.SeparatorUI;

// TODO: Auto-generated Javadoc
/**
 * JPopupMenuSeparator��UIʵ��.
 *
 * @author Jack Jiang(jb2011@163.com)
 * @version 1.0
 */
public class BEPopupMenuSeparatorUI extends SeparatorUI
{
	
	/**
	 * Creates the ui.
	 *
	 * @param c the c
	 * @return the component ui
	 */
	public static ComponentUI createUI( JComponent c )
	{
		return new BEPopupMenuSeparatorUI();
	}

	/* (non-Javadoc)
	 * @see javax.swing.plaf.ComponentUI#installUI(javax.swing.JComponent)
	 */
	public void installUI( JComponent c )
	{
		installDefaults( (JSeparator)c );
		installListeners( (JSeparator)c );
	}

	/* (non-Javadoc)
	 * @see javax.swing.plaf.ComponentUI#uninstallUI(javax.swing.JComponent)
	 */
	public void uninstallUI(JComponent c)
	{
		uninstallDefaults( (JSeparator)c );
		uninstallListeners( (JSeparator)c );
	}

	/**
	 * Install defaults.
	 *
	 * @param s the s
	 */
	protected void installDefaults( JSeparator s )
	{
		LookAndFeel.installColors( s, "Separator.background", "Separator.foreground" );
		LookAndFeel.installProperty( s, "opaque", Boolean.FALSE);
	}

	/**
	 * Uninstall defaults.
	 *
	 * @param s the s
	 */
	protected void uninstallDefaults( JSeparator s )
	{
	}

	/**
	 * Install listeners.
	 *
	 * @param s the s
	 */
	protected void installListeners( JSeparator s )
	{
	}

	/**
	 * Uninstall listeners.
	 *
	 * @param s the s
	 */
	protected void uninstallListeners( JSeparator s )
	{
	}

	/* (non-Javadoc)
	 * @see javax.swing.plaf.ComponentUI#paint(java.awt.Graphics, javax.swing.JComponent)
	 */
	public void paint( Graphics g, JComponent c )
	{
		int w = c.getWidth(),h = c.getHeight();
		Graphics2D g2 = (Graphics2D)g;

		if ( ((JSeparator)c).getOrientation() == JSeparator.VERTICAL )
		{
			//��ֱ����ԭʼ����
			//TODO ��ֱ��ʽ��������ʱ����ʵ�ְɣ���ֱ����Ĭ������JToolBar��
			g.setColor( c.getForeground() );
			g.drawLine( 0, 0, 0, c.getHeight() );
			g.setColor( c.getBackground() );
			g.drawLine( 1, 0, 1, c.getHeight() );
		}
		else  // HORIZONTAL
		{
			drawHorizonal(g2,c,w,h);
		}
	}
	
	/**
	 * ��ˮƽ������Ʒָ�����ʽ.
	 *
	 * @param g2 the g2
	 * @param c the c
	 * @param w the w
	 * @param h the h
	 */
	private void drawHorizonal(Graphics2D g2,JComponent c,int w,int h)
	{
		//** ����border�ĵ���
		//������ʽ
		Stroke oldStroke = g2.getStroke();
		Stroke sroke = new BasicStroke(1, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_BEVEL, 0, new float[]{1, 2}, 0);//ʵ�ߣ��հ�
		g2.setStroke(sroke);
		//�ױ��ϣ�ǳ��ɫ��
		//TODO ��ɫ������ȡ��UI����Ŷ����������
		g2.setColor(new Color(180,180,180));
		g2.drawLine(0,h-2, w-1,h-2); // draw bottom1
		//�ױ��£���ɫ��������һ����ɫ���ߵ�Ŀ����������Ļ��߲�����ǿ�ԱȶȴӶ��γ�����Ч��
		//����L&Fʵ��������Panel�ĵ�ɫ�ԱȶȲ���ǿ�Ҷ�����в����ԣ���ɫԽ��ĵ�ɫ����Ч��Խ���ԣ�
		//TODO ��ɫ������ȡ��UI����Ŷ����������
		g2.setColor(Color.white);
		g2.drawLine(0,h-1, w-1,h-1);//draw bottom2
		
		g2.setStroke(oldStroke);
	}

	/* (non-Javadoc)
	 * @see javax.swing.plaf.ComponentUI#getPreferredSize(javax.swing.JComponent)
	 */
	public Dimension getPreferredSize( JComponent c )
	{ 
		if ( ((JSeparator)c).getOrientation() == JSeparator.VERTICAL )
			return new Dimension( 2, 0 );
		else
			return new Dimension( 0, 3 );
	}

	/* (non-Javadoc)
	 * @see javax.swing.plaf.ComponentUI#getMinimumSize(javax.swing.JComponent)
	 */
	public Dimension getMinimumSize( JComponent c ) { return null; }
	
	/* (non-Javadoc)
	 * @see javax.swing.plaf.ComponentUI#getMaximumSize(javax.swing.JComponent)
	 */
	public Dimension getMaximumSize( JComponent c ) { return null; }
	
//	public static void main(String[] args) throws Exception
//	{
//		UIManager.setLookAndFeel(new WindowsLookAndFeel());
//		JFrame f = new JFrame("111");
//		f.setBounds(100,100,200,200);
//		
//		JToolBar.Separator sp = new JToolBar.Separator(new Dimension(3,100));
//		sp.setUI(new NLSeparatorUI());
//		sp.setOrientation(JSeparator.VERTICAL);
////		sp.setPreferredSize(new Dimension(10,50));
////		sp.setMaximumSize(new Dimension(10,50));
////		sp.setMinimumSize(new Dimension(10,50));
//		
//		f.getContentPane().setLayout(new FlowLayout());
//		f.getContentPane().add(new JButton("ddddd"));
//		f.getContentPane().add(sp);
//		
//		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
}




