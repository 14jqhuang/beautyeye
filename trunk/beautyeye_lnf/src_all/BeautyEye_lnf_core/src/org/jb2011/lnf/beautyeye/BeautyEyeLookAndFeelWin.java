/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BeautyEyeLookAndFeelWin.java at 2012-9-24 17:17:57, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.InsetsUIResource;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.FrameBorderStyle;
import org.jb2011.lnf.beautyeye.winlnfutils.WinUtils;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * BeautyEye Swing���ʵ�ַ��� - Windowsƽ̨ר�����ʵ������.<br>
 * <p>
 * �������������Windows��ʹ�ã�����ʹ��Windows����ϵͳĬ�ϵ����������.
 * 
 * @author Jack Jiang(jb2011@163.com)
 * @version 1.0
 */
// * �ο�Դ�����JDK_1.6.0_u18.
public class BeautyEyeLookAndFeelWin extends WindowsLookAndFeel
{
	static{
		initLookAndFeelDecorated();
	}
	
	/**
	 * Instantiates a new beauty eye look and feel win.
	 *
	 * @see BeautyEyeLNFHelper#implLNF()
	 * @see org.jb2011.lnf.beautyeye.ch20_filechooser.__UI__#uiImpl_win()
	 * @see #initForVista()
	 */
	public BeautyEyeLookAndFeelWin()
	{
		super();

		BeautyEyeLNFHelper.implLNF();
		
		//�Զ���JFileChooser��L&Fʵ�֣�Ϊ�˽��windows LNF���ļ�ѡ���UIδʵ�ֱ���������⣩
		org.jb2011.lnf.beautyeye.ch20_filechooser.__UI__.uiImpl_win();
		
		//���Vista�����µ�windowsƽ̨������������
		initForVista();
	}
	
	/**
	 * ��Windos LNF����Vista�����µĲ���ϵͳ����win7���϶�Windows LNF���������ã�
	 * �Ա�֤��Vista������ƽ̨����۵�һ���ԣ����ò˵�����߶ȸ���ȣ�����μ�
	 * WindowsLookAndFeel.initVistaComponentDefaults(..)��
	 * <p>
	 * BeautyEye������Ҫ��֤����һ���ԣ�������winƽ̨�ϣ�������Ҫ��Щ��������ã�
	 * ����÷�����private˽�з������޷����и������Σ�����ֻ���ڴ˵��з������Ա����Vista
	 * �����µ�ƽ̨���в��������������Ա���BeautyEye LNF����˽�������.
	 * 
	 * @see WindowsLookAndFeel.initVistaComponentDefaults(..)
	 */
	protected void initForVista()
	{
		if(WinUtils.isOnVista())
		{
			UIManager.put("CheckBoxMenuItem.margin",new InsetsUIResource(0,0,0,0));
			UIManager.put("RadioButtonMenuItem.margin",new InsetsUIResource(0,0,0,0));
			UIManager.put("Menu.margin",new InsetsUIResource(0,0,0,0));//windows lnf xp��Ĭ����2��2��2��2
			UIManager.put("MenuItem.margin",new InsetsUIResource(0,0,0,0));//windows lnf��  xpĬ����2��2��2��2
			
			UIManager.put("Menu.border",new BorderUIResource(BorderFactory.createEmptyBorder(1,3,2,3)));//javax.swing.plaf.basic.BasicBorders.MarginBorder;
			UIManager.put("MenuItem.border",new BorderUIResource(BorderFactory.createEmptyBorder(1,0,2,0)));//javax.swing.plaf.basic.BasicBorders.MarginBorder;
			UIManager.put("CheckBoxMenuItem.border",new BorderUIResource(BorderFactory.createEmptyBorder(4,2,4,2)));//javax.swing.plaf.basic.BasicBorders.MarginBorder;
			UIManager.put("RadioButtonMenuItem.border",new BorderUIResource(BorderFactory.createEmptyBorder(4,0,4,0)));//javax.swing.plaf.basic.BasicBorders.MarginBorder;		
//			UIManager.put("PopupMenu.border",new BorderUIResource(BorderFactory.createEmptyBorder(20,10,20,10)));//	
		
			UIManager.put("CheckBoxMenuItem.checkIcon"
					,new org.jb2011.lnf.beautyeye.ch9_menu.BECheckBoxMenuItemUI.CheckBoxMenuItemIcon().setUsedForVista(true));//javax.swing.plaf.basic.BasicIconFactory.CheckBoxMenuItemIcon);
			UIManager.put("RadioButtonMenuItem.checkIcon"
					,new org.jb2011.lnf.beautyeye.ch9_menu.BERadioButtonMenuItemUI.RadioButtonMenuItemIcon().setUsedForVista(true));
		}
	}
	
	/* (non-Javadoc)
	 * @see com.sun.java.swing.plaf.windows.WindowsLookAndFeel#getName()
	 */
	@Override 
	public String getName() 
	{
        return "BeautyEyeWin";
    }

	/* (non-Javadoc)
	 * @see com.sun.java.swing.plaf.windows.WindowsLookAndFeel#getID()
	 */
	@Override 
    public String getID() 
    {
        return "BeautyEyeWin";
    }

	/* (non-Javadoc)
	 * @see com.sun.java.swing.plaf.windows.WindowsLookAndFeel#getDescription()
	 */
	@Override 
    public String getDescription() 
    {
        return "BeautyEye windows-platform L&F developed by Jack Jiang(jb2011@163.com).";
    }
	
	/**
	 * Gets the supports window decorations.
	 *
	 * @return the supports window decorations
	 * {@inheritDoc}
	 */
	@Override 
	public boolean getSupportsWindowDecorations() 
	{
		return true;
	}
	
	/**
	 * ��BeautyEyeLNFHelper.frameBorderStyleָ���Ĵ��ڱ߿�������
	 * �����Ƿ�ʹ�ò���ϵͳ��صĴ���װ����ʽ.
	 */
	static void initLookAndFeelDecorated()
	{
		if(BeautyEyeLNFHelper.frameBorderStyle == FrameBorderStyle.osLookAndFeelDecorated)
		{
			JFrame.setDefaultLookAndFeelDecorated(false);
			JDialog.setDefaultLookAndFeelDecorated(false);
		}
		else
		{
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
		}
		
//		UIManager.put("swing.aatext", Boolean.FALSE);
	}
}
