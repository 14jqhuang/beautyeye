/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BeautyEyeLookAndFeelCross.java at 2012-9-24 17:17:57, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye;

import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

// TODO: Auto-generated Javadoc
/**
 *<p>
 * BeautyEye Swing���ʵ�ַ��� - ��ƽ̨ͨ�����ʵ������.<br>
 * <p>
 * ���������������ƽ̨ʱʹ�ã���������Java֧�ֵ����в���ϵͳ.
 * 
 * @author Jack Jiang(jb2011@163.com)
 * @version 1.0
 */
// * �ο�Դ�����JDK_1.6.0_u18.
//���Ҫ�̳�BasicLookAndFeelʵ�ֿ�ƽ̨lnf ����Ҫ������Ĺ�����Ŀǰ
//��ƽ̨ʱ�ɴ�̳�MetalLookAndFeel�Ա�վ�ھ��˵ļ���ϣ���ʡһЩ������
public class BeautyEyeLookAndFeelCross extends MetalLookAndFeel
{
	static{
		BeautyEyeLookAndFeelWin.initLookAndFeelDecorated();
	}
	
	/**
	 * Instantiates a new beauty eye look and feel cross.
	 */
	public BeautyEyeLookAndFeelCross()
	{
		super();

//		//�����Խ���windowsƽ̨��Ч���� -> Jack Jiang����֤ʵûЧ������������������������
//		UIManager.put("Application.useSystemFontSettings", Boolean.TRUE);
		//ȡ��Metal LNF��Ĭ�ϵĴ�����
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		//��������true���򽫻�ΪTabbedPane����������������ɫ����
		UIManager.put("TabbedPane.contentOpaque", Boolean.FALSE);
		//��������true���򽫻�ΪTabbedPane�ı�ǩ�������ɫ����
		UIManager.put("TabbedPane.tabsOpaque", Boolean.FALSE);
		BeautyEyeLNFHelper.implLNF();
		
		//�Զ���JFileChooser��L&Fʵ�֣�Ϊ�˽��JFileChooser�е��ļ��鿴�б���и����⣩
		org.jb2011.lnf.beautyeye.ch20_filechooser.__UI__.uiImpl_cross();
		
//		JFrame.setDefaultLookAndFeelDecorated(true);
//		JDialog.setDefaultLookAndFeelDecorated(true);
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.plaf.metal.MetalLookAndFeel#getName()
	 */
	@Override 
	public String getName() 
	{
        return "BeautyEyeCross";
    }

	/* (non-Javadoc)
	 * @see javax.swing.plaf.metal.MetalLookAndFeel#getID()
	 */
	@Override 
    public String getID() 
    {
        return "BeautyEyeCross";
    }

	/* (non-Javadoc)
	 * @see javax.swing.plaf.metal.MetalLookAndFeel#getDescription()
	 */
	@Override 
    public String getDescription() 
    {
        return "BeautyEye cross-platform L&F developed by Jack Jiang(jb2011@163.com).";
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

	/* (non-Javadoc)
	 * @see javax.swing.plaf.metal.MetalLookAndFeel#isNativeLookAndFeel()
	 */
	@Override
	public boolean isNativeLookAndFeel()
	{
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.swing.plaf.metal.MetalLookAndFeel#isSupportedLookAndFeel()
	 */
	@Override
	public boolean isSupportedLookAndFeel()
	{
		return true;
	}
}
