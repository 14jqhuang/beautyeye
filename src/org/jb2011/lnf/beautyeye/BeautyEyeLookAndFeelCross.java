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
 * BeautyEye Swing外观实现方案 - 跨平台通用外观实现主类.<br>
 * <p>
 * 本主题主类仅供跨平台时使用，它可用于Java支持的所有操作系统.
 * 
 * @author Jack Jiang(jb2011@163.com)
 * @version 1.0
 */
// * 参考源码基于JDK_1.6.0_u18.
//如果要继承BasicLookAndFeel实现跨平台lnf 则还需要做更多的工作，目前
//跨平台时干脆继承MetalLookAndFeel以便站在巨人的肩膀上，节省一些工作量
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

//		//本属性仅对windows平台有效？！ -> Jack Jiang最终证实没效果！！！！！！！！！！！
//		UIManager.put("Application.useSystemFontSettings", Boolean.TRUE);
		//取消Metal LNF中默认的粗体字
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		//此项如是true，则将会为TabbedPane的内容面板填充天蓝色背景
		UIManager.put("TabbedPane.contentOpaque", Boolean.FALSE);
		//此项如是true，则将会为TabbedPane的标签填充天蓝色背景
		UIManager.put("TabbedPane.tabsOpaque", Boolean.FALSE);
		BeautyEyeLNFHelper.implLNF();
		
		//自定义JFileChooser的L&F实现（为了解决JFileChooser中的文件查看列表的行高问题）
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
