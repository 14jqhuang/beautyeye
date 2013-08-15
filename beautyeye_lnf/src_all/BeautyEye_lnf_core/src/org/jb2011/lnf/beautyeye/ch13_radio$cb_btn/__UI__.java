/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * __UI__.java at 2012-9-24 17:21:12, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch13_radio$cb_btn;

import java.awt.Component;
import java.awt.Graphics;
import java.io.Serializable;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.InsetsUIResource;
import javax.swing.plaf.UIResource;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;


// TODO: Auto-generated Javadoc
/**
 * The Class __UI__.
 */
public class __UI__
{
	
	/**
	 * Ui impl.
	 */
	public static void uiImpl()
	{
//		UIManager.put("CheckBox.border",new BorderUIResource(new BERoundBorder().setArcWidth(0)));
		
		UIManager.put("CheckBox.margin",new InsetsUIResource(4,3,4,3));
		UIManager.put("RadioButton.margin",new InsetsUIResource(4,3,4,3));//2, 2, 2, 2));
		
		UIManager.put("RadioButton.background",new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));
		UIManager.put("CheckBox.background",new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));
		
		UIManager.put("CheckBox.foreground",new ColorUIResource(BeautyEyeLNFHelper.commonForegroundColor));
		UIManager.put("RadioButton.foreground",new ColorUIResource(BeautyEyeLNFHelper.commonForegroundColor));
		
		UIManager.put("RadioButton.icon", new RadioButtonIcon());
		UIManager.put("CheckBox.icon", new CheckBoxIcon());

		//�ľ��趨
		UIManager.put("RadioButton.margin", new InsetsUIResource(1,1,1,1));//Ĭ����2,2,2,2
		UIManager.put("CheckBox.margin", new InsetsUIResource(1,1,1,1));//Ĭ����2,2,2,2
	}

	//copy from com.sun.java.swing.plaf.windows.WindowsIconFactory.CheckBoxIcon
	//modified by Jack Jiang 2012-06-23
	/**
	 * CheckBox��ͼ��ʵ����.
	 */
	private static class CheckBoxIcon implements Icon, Serializable
	{
		
		/* (non-Javadoc)
		 * @see javax.swing.Icon#paintIcon(java.awt.Component, java.awt.Graphics, int, int)
		 */
		public void paintIcon(Component c, Graphics g, int x, int y)
		{
			JCheckBox cb = (JCheckBox) c;
			ButtonModel model = cb.getModel();

			//ѡ��ʱ
			if(model.isSelected())
			{
				//���ڽ���״̬
				if(!model.isEnabled())
					g.drawImage(__IconFactory__.getInstance().getCheckBoxButtonIcon_disable().getImage(), x, y, null);
				else
				{
					//���ڱ���ס״̬
					if(model.isPressed())
						g.drawImage(__IconFactory__.getInstance().getCheckBoxButtonIcon_pressed().getImage(), x, y, null);
					else
						g.drawImage(__IconFactory__.getInstance().getCheckBoxButtonIcon_normal().getImage(), x, y, null);
				}
			}
			//δѡ��ʱ
			else
			{
				//���ڽ���״̬
				if(!model.isEnabled())
					g.drawImage(__IconFactory__.getInstance().getCheckBoxButtonIcon_unchecked_disable().getImage(), x, y, null);
				else
				{
					//���ڱ���ס״̬
					if(model.isPressed())
						g.drawImage(__IconFactory__.getInstance().getCheckBoxButtonIcon_unchecked_pressed().getImage(), x, y, null);
					else
						g.drawImage(__IconFactory__.getInstance().getCheckBoxButtonIcon_unchecked_normal().getImage(), x, y, null);
				}
			}
		}

		/* (non-Javadoc)
		 * @see javax.swing.Icon#getIconWidth()
		 */
		public int getIconWidth() 
		{
			return 24;
		}

		/* (non-Javadoc)
		 * @see javax.swing.Icon#getIconHeight()
		 */
		public int getIconHeight() 
		{
			return 24;
		}
	} // end class CheckBoxIcon

	//copy from com.sun.java.swing.plaf.windows.WindowsIconFactory.CheckBoxIcon
	//modified by Jack Jiang 2012-06-23
	/**
	 * RadioButton��ͼ��ʵ����.
	 */
	private static class RadioButtonIcon implements Icon, UIResource, Serializable
	{
		
		/* (non-Javadoc)
		 * @see javax.swing.Icon#paintIcon(java.awt.Component, java.awt.Graphics, int, int)
		 */
		public void paintIcon(Component c, Graphics g, int x, int y) {
			AbstractButton b = (AbstractButton) c;
			ButtonModel model = b.getModel();

			//ѡ��ʱ
			if(model.isSelected())
			{
				//���ڽ���״̬
				if(!model.isEnabled())
					g.drawImage(__IconFactory__.getInstance().getRadioButtonIcon_disable().getImage(), x, y, null);
				else
				{
					//���ڱ���ס״̬
					if(model.isPressed())
						g.drawImage(__IconFactory__.getInstance().getRadioButtonIcon_pressed().getImage(), x, y, null);
					else
						g.drawImage(__IconFactory__.getInstance().getRadioButtonIcon_normal().getImage(), x, y, null);
				}
			}
			//δѡ��ʱ
			else
			{
				//���ڽ���״̬
				if(!model.isEnabled())
					g.drawImage(__IconFactory__.getInstance().getRadioButtonIcon_unchecked_disable().getImage(), x, y, null);
				else
				{
					//���ڱ���ס״̬
					if(model.isPressed())
						g.drawImage(__IconFactory__.getInstance().getRadioButtonIcon_unchecked_pressed().getImage(), x, y, null);
					else
						g.drawImage(__IconFactory__.getInstance().getRadioButtonIcon_unchecked_normal().getImage(), x, y, null);
				}
			}
		}

		/* (non-Javadoc)
		 * @see javax.swing.Icon#getIconWidth()
		 */
		public int getIconWidth()
		{
			return 24;
		}

		/* (non-Javadoc)
		 * @see javax.swing.Icon#getIconHeight()
		 */
		public int getIconHeight()
		{
			return 24;
		}
	} // end class RadioButtonIcon
}
