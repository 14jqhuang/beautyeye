/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BEMenuItemUI.java at 2012-9-24 17:22:51, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */

package org.jb2011.lnf.beautyeye.ch9_menu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicMenuItemUI;

// TODO: Auto-generated Javadoc
/**
 * JMenuItem��UIʵ���ࡣ.
 *
 * @author Jack Jiang(jb2011@163.com)
 */
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� Start
//�ر�ע�⣺BasicMenuItemUI�����Vista��������Windows�汾Ԥ���˺ܶ�����LNF����Ҫ�����ԣ�
//Ԥ����������BasicMenuItemUI��WindowsLookAndFeel�е�initVistaComponentDefaults(..)����.
//��Щ����ֻ�ܻ���vista�����µ�windowsƽ̨�Ϲ�����ʱ�Ż���Ч�����Գ���֮���windows�ⲻ����,
//���׳���ui�Ӿ�����.
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� END
public class BEMenuItemUI extends BasicMenuItemUI//WindowsMenuItemUI
{
	
	/** �Ƿ�ǿ�Ƶ���͸��(��ǿ�Ʋ�͸��ʱ������ͨ״̬�¸�item�����ᱻ���Ʊ�����. */
	private static boolean enforceTransparent = true;// TODO ����������UI����
	
	/**
	 * Creates the ui.
	 *
	 * @param c the c
	 * @return the component ui
	 */
	public static ComponentUI createUI(JComponent c)
	{
		return new BEMenuItemUI();
	}


	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicMenuItemUI#paintBackground(java.awt.Graphics, javax.swing.JMenuItem, java.awt.Color)
	 */
	@Override
	protected void paintBackground(Graphics g, JMenuItem menuItem, Color bgColor)
	{
		// see parent!
		ButtonModel model = menuItem.getModel();
		Color oldColor = g.getColor();
		int menuWidth = menuItem.getWidth();
		int menuHeight = menuItem.getHeight();
		
		Graphics2D g2 = (Graphics2D)g;
		
		if (model.isArmed()
				|| (menuItem instanceof JMenu && model.isSelected()))
		{
			//�˵������ʽ����(��NinePatchͼ�����)
			__Icon9Factory__.getInstance().getBgIcon_ItemSelected()
					.draw(g2, 0, 0, menuWidth, menuHeight);
		}
		else
		{
			if(!enforceTransparent)
			{
				g.setColor(menuItem.getBackground());
				g.fillRect(0, 0, menuWidth, menuHeight);
			}
		}
		g.setColor(oldColor);
	}
}
