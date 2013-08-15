/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * FocusListenerImpl.java at 2012-9-24 17:22:59, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.widget;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.ComponentUI;

import org.jb2011.lnf.beautyeye.ch6_textcoms.__UI__.BgSwitchable;
import org.jb2011.lnf.beautyeye.utils.BEUtils;
import org.jb2011.lnf.beautyeye.widget.border.BERoundBorder;

// TODO: Auto-generated Javadoc
/**
 * ����ı�ʱ�ļ�����ʵ����.
 * <p>
 * Ŀǰ��Ҫ���ڸ��ı����.
 * 
 * @author Jack Jiang(jb2011@163.com)
 */
public class FocusListenerImpl  implements FocusListener
{
//		private final static FocusListenerImpl INSTANCE = new FocusListenerImpl();  
	/** �ı�����Ȼ�ý����ı߿��������. */
	public static int defaultFocusedThikness = 2;

	/**
	 * Gets the single instance of FocusListenerImpl.
	 *
	 * @return single instance of FocusListenerImpl
	 */
	public static FocusListenerImpl getInstance() 
	{
//			return INSTANCE;
		return new FocusListenerImpl();
	}

	/** The focused thikness. */
	protected int focusedThikness = defaultFocusedThikness;

	/**
	 * Gets the focused thikness.
	 *
	 * @return the focused thikness
	 */
	public int getFocusedThikness()
	{
		return focusedThikness;
	}

	/**
	 * Sets the focused thikness.
	 *
	 * @param focusedThikness the focused thikness
	 * @return the focus listener impl
	 */
	public FocusListenerImpl setFocusedThikness(int focusedThikness)
	{
		this.focusedThikness = focusedThikness;
		return this;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.FocusListener#focusGained(java.awt.event.FocusEvent)
	 */
	public void focusGained(FocusEvent e)
	{
		if(e.getSource() instanceof JComponent)
		{
			JComponent com = (JComponent)e.getSource();
			Border orignalBorder = com.getBorder();

			if(orignalBorder!=null)
			{
				//������ý���ʱ������ɫ��
				Color focusedColor = getTextFieldFocusedColor();

				//JTextField��ý���ʱ���⴦���Զ��л����ı���ͼ���ɣ���NinePatchͼʵ�֣�
				if(com instanceof JPasswordField 
						|| com instanceof JTextField
						)//JPasswordField�� JTextField���࣬��Ui�Ƕ�����
				{
					//						focusedColor = ZCWindowsLookAndFeel.getTextFieldFocusedColor();
					ComponentUI ui = ((JTextField)com).getUI();
					if(ui instanceof BgSwitchable)
					{
						((BgSwitchable)ui).switchBgToFocused();
						com.repaint();
						return;
					}
					else if(ui instanceof BgSwitchable)
					{
						((BgSwitchable)ui).switchBgToFocused();
						com.repaint();
						return;
					}
				}
				else if(com instanceof JTextArea)
				{
//					focusedColor = getTextAreaFocusedColor();
					ComponentUI ui = ((JTextArea)com).getUI();
					if(ui instanceof BgSwitchable)
					{
						((BgSwitchable)ui).switchBgToFocused();
						com.repaint();
						return;
					}
				}
				else if(com instanceof JTextPane)
				{
//					focusedColor = getTextPaneFocusedColor();
					ComponentUI ui = ((JTextPane)com).getUI();
					if(ui instanceof BgSwitchable)
					{
						((BgSwitchable)ui).switchBgToFocused();
						com.repaint();
						return;
					}
				}
				else if(com instanceof JEditorPane)
				{
//					focusedColor = getEditorPaneFocusedColor();
					ComponentUI ui = ((JEditorPane)com).getUI();
					if(ui instanceof BgSwitchable)
					{
						((BgSwitchable)ui).switchBgToFocused();
						com.repaint();
						return;
					}
				}
				
				else if(com instanceof JComboBox)
					focusedColor = getComboBoxFocusedColor();
				

				//��ý������±߿�
				BERoundBorder cc;
				if(orignalBorder instanceof BERoundBorder)
					cc =(BERoundBorder)(((BERoundBorder)orignalBorder).clone());
				else
					cc = new BERoundBorder(1).setArcWidth(0);
				cc.setLineColor(focusedColor);
				cc.setThickness(focusedThikness);

				//* ���������JPasswordField,���ķ�Ӧ����bug,Ҳ������setBorder֮������
				//* preferredSize���ĺ�С������������������⴦�����Ϊ��ʹ��size��setBorderǰ����һ��
				Dimension oldDm=null;
				if(com instanceof JTextField)
					oldDm=com.getSize();
				com.setBorder(cc);
				if(com instanceof JTextField)
					com.setPreferredSize(oldDm);
			}
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.FocusListener#focusLost(java.awt.event.FocusEvent)
	 */
	public void focusLost(FocusEvent e)
	{
		if(e.getSource() instanceof JComponent)
		{
			JComponent com = (JComponent)e.getSource();

			//JTextField��ý���ʱ���⴦���Զ��л����ı���ͼ���ɣ���NinePatchͼʵ�֣�
			if(com instanceof JPasswordField || com instanceof JTextField)//JPasswordField�� JTextField���࣬��Ui�Ƕ�����
			{
				//					focusedColor = ZCWindowsLookAndFeel.getTextFieldFocusedColor();
				ComponentUI ui = ((JTextField)com).getUI();
				if(ui instanceof BgSwitchable)
				{
					((BgSwitchable)ui).switchBgToNomal();
					com.repaint();
					return;
				}
				else if(ui instanceof BgSwitchable)
				{
					((BgSwitchable)ui).switchBgToNomal();
					com.repaint();
					return;
				}
			}
			else if(com instanceof JTextArea)
			{
				ComponentUI ui = ((JTextArea)com).getUI();
				if(ui instanceof BgSwitchable)
				{
					((BgSwitchable)ui).switchBgToNomal();
					com.repaint();
					return;
				}
			}
			else if(com instanceof JTextPane)
			{
				ComponentUI ui = ((JTextPane)com).getUI();
				if(ui instanceof BgSwitchable)
				{
					((BgSwitchable)ui).switchBgToNomal();
					com.repaint();
					return;
				}
			}
			else if(com instanceof JEditorPane)
			{
				ComponentUI ui = ((JEditorPane)com).getUI();
				if(ui instanceof BgSwitchable)
				{
					((BgSwitchable)ui).switchBgToNomal();
					com.repaint();
					return;
				}
			}
			

			//ʧȥ����ʱ��ԭ�߿���ʽ
			Border orignalBorder = com.getBorder();
			if(orignalBorder!=null)
				if(orignalBorder instanceof BERoundBorder)
				{
					BERoundBorder cc=(BERoundBorder)(((BERoundBorder)orignalBorder).clone());
					cc.setLineColor(BERoundBorder.defaultLineColor);
					cc.setThickness(1);
					com.setBorder(cc);
				}
		}
	}
	
	/**
	 * Gets the text field focused color.
	 *
	 * @return the text field focused color
	 */
	public static Color getTextFieldFocusedColor()
	{
		return BEUtils.getColor(UIManager.getColor("TextField.selectionBackground"),30,30,30);
	}
//	public static Color getTextAreaFocusedColor()
//	{
//		return LNFUtils.getColor(UIManager.getColor("TextArea.selectionBackground"),30,30,30);
//	}
//	public static Color getEditorPaneFocusedColor()
//	{
//		return LNFUtils.getColor(UIManager.getColor("EditorPane.selectionBackground"),30,30,30);
//	}
	/**
 * Gets the combo box focused color.
 *
 * @return the combo box focused color
 */
public static Color getComboBoxFocusedColor()
	{
		return BEUtils.getColor(UIManager.getColor("ComboBox.selectionBackground"),30,30,30);
	}
//	public static Color getTextPaneFocusedColor()
//	{
//		return LNFUtils.getColor(UIManager.getColor("TextPane.selectionBackground"),30,30,30);
//	}
}