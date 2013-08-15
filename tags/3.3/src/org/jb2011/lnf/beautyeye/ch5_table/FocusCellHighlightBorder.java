/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * FocusCellHighlightBorder.java at 2012-9-24 17:22:40, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch5_table;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.UIManager;
import javax.swing.border.AbstractBorder;

// TODO: Auto-generated Javadoc
/**
 * ���Ԫ��ý���ʱ��Borderʵ���ࡣ.
 *
 * @author Jack Jiang(jb2011@163.com)
 */
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� Start
//��border��Jack Jiangʵ�֣����Ǳ��Ԫ��ý���ʱ�ı߿����ƵĹ�����windows LNF����һ���������߿�
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� END
class FocusCellHighlightBorder extends AbstractBorder
{
	
	/* (non-Javadoc)
	 * @see javax.swing.border.AbstractBorder#getBorderInsets(java.awt.Component)
	 */
	public Insets getBorderInsets(Component c)       
	{
		return new Insets(0,3,0,1);
	}

	/* (non-Javadoc)
	 * @see javax.swing.border.AbstractBorder#getBorderInsets(java.awt.Component, java.awt.Insets)
	 */
	public Insets getBorderInsets(Component c, Insets insets) 
	{
		return getBorderInsets(c);
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.border.AbstractBorder#paintBorder(java.awt.Component, java.awt.Graphics, int, int, int, int)
	 */
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
	{
		//����߻�һ��2���ؿ������
		g.setColor(UIManager.getColor("Table.focusCellHighlightBorderColor"));
		g.fillRect(x, y, 2, height );//���¸��հ�һ�����أ�Ŀ����Ϊ����render��N9ͼƬ��������γɸ��õ��Ӿ�Ч��
		
		//��������������ұ߻�һ��1���ؿ����ɫ���ߣ��Ա�Ϊ�����2��������Ӫ������Ч��
		/* ~~ע�����������jb2011Ϊ�˸��õ�uiЧ�����Ѽӵ����ԣ�Ŀ����ʹTable.focusCellHighlightBorder�е�����Ч��Ŷ */
		g.setColor(UIManager.getColor("Table.focusCellHighlightBorderHighlightColor"));
		g.fillRect(x+2, y, 1, height );
	}
}