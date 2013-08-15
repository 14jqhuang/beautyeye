/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BeautyEyeLNFHelper.java at 2012-9-24 17:17:57, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.border.Border;

import org.jb2011.lnf.beautyeye.utils.JVM;
import org.jb2011.lnf.beautyeye.widget.border.BEShadowBorder;
import org.jb2011.lnf.beautyeye.widget.border.BEShadowBorder3;
import org.jb2011.lnf.beautyeye.widget.border.PlainGrayBorder;

/**
 * <p>
 * BeautyEye Swing���ʵ�ַ��� - L&F���ĸ�����.<br>
 * <p>
 * ��Ŀ�йܵ�ַ��http://code.google.com/p/beautyeye/
 * 
 * @author Jack Jiang(jb2011@163.com), 2012-05
 * @version 1.0
 */
public class BeautyEyeLNFHelper
{
	/** 
	 * �����������ڿ���/�ر�BeautyEye LNF�ĵ�����Ϣ���.
	 * <p>
	 * Ĭ��false����������������Ϣ���. 
	 * 
	 * @since 3.2 
	 */
	public static boolean debug = false;
	/**
	 * �����������ڿ���/�رյ����ڣ�����JFrame��JDialog�����ڷǻ
	 * ״̬��inactivity��ʱ�İ�͸���Ӿ�Ч��.
	 * <p>
	 * Ĭ��true������ʾĬ�Ͽ�����͸��Ч��.
	 * 
	 * @since 3.2
	 */
	public static boolean translucencyAtFrameInactive = true;
	
	/** 
	 * BeautyEye LNF �Ĵ��ڱ߿���ʽ.
	 * <p>Ĭ��ֵ��������java1.6.0_u10�����ϰ汾ʱʹ�� {@link FrameBorderStyle#translucencyAppleLike}��
	 * ������java1.5�汾ʱʹ��{@link FrameBorderStyle#generalNoTranslucencyShadow}.
	 * 
	 * <p><b>ע�⣺</b>�������ñ���������ȷ������UIManager.setLookAndFeelǰ�����ã����򽫲�����ЧŶ.
	 * @see FrameBorderStyle
	 */
	public static FrameBorderStyle frameBorderStyle = 
		isSurportedTranslucency()?FrameBorderStyle.translucencyAppleLike:FrameBorderStyle.generalNoTranslucencyShadow;
	
	/** 
	 * ��ɫȫ�ֱ�������������µĴ����ı���ɫ.
	 * <p>
	 * ������ñ�������Ҳ��ֱ��ͨ��{@code UIManager.put("activeCaptionText",new ColorUIResource(c))}��
	 * {@code UIManager.put("inactiveCaptionText",new ColorUIResource(c))}��ʵ�ִ����ı���ɫ�ĸı�.
	 * <p>
	 * ���岻�(inactivite)ʱ����ɫ���ݴ��Զ���������������������.
	 * Ĭ���Ǻ�ɫ��new Color(0,0,0)��. */
	public static Color activeCaptionTextColor = new Color(0,0,0);//��ɫ
	
	/** 
	 * ��ɫȫ�ֱ�������������ı���ɫ.
	 * <p>
	 * ������ñ�������Ҳ��ֱ��ͨ�����Ե�UIManager�������ı�����.
	 * <p>
	 * Ĭ����ǳ��ɫ��new Color(250,250,250)��. 
	 * @since 3.2 */
	public static Color commonBackgroundColor = new Color(250,250,250);//240,240,240); //248,248,248);//255,255,255);//
	/** 
	 * ��ɫȫ�ֱ��������������ǰ��ɫ���ı���ɫ��.
	 * <p>
	 * ������ñ�������Ҳ��ֱ��ͨ�����Ե�UIManager�������ı�����.
	 * <p>
	 * Ĭ�������ɫ��new Color(60,60,60)��. 
	 * @since 3.2 */
	public static Color commonForegroundColor = new Color(60,60,60);//102,102,102);
	/** 
	 * ��ɫȫ�ֱ�����ĳЩ����Ľ���߿���ɫ.
	 * ��ǰ��Ҫ���ڰ�ť�Ƚ���߿�Ļ�����ɫ.
	 * <p>
	 * ������ñ�������Ҳ��ֱ��ͨ�����Ե�UIManager�������ı�����.
	 * <p>
	 * Ĭ����ǳ��ɫ��new Color(250,250,250)��. 
	 * @since 3.2 */
	public static Color commonFocusedBorderColor = new Color(162,162,162);
	/** 
	 * ��ɫȫ�ֱ�����ĳЩ���������ʱ���ı���ɫ.
	 * ��ǰ��Ҫ���ڲ˵�����.
	 * <p>
	 * ������ñ�������Ҳ��ֱ��ͨ�����Ե�UIManager�������ı�����.
	 * <p>
	 * Ĭ����ǳ��ɫ��new Color(172,168,153)��. 
	 * @since 3.2 */
	public static Color commonDisabledForegroundColor = new Color(172,168,153);
	/** 
	 * ��ɫȫ�ֱ���������������ı���ѡ��ʱ�ı���ɫ.��ǰ��Ҫ���ڸ��ı������.
	 * <p>
	 * ������ñ�������Ҳ��ֱ��ͨ�����Ե�UIManager�������ı�����.
	 * <p>
	 * Ĭ�������ɫ��new Color(2,129,216)��. 
	 * @since 3.2 */
	public static Color commonSelectionBackgroundColor = new Color(2,129,216);//78,155,193));//58,135,173));//235,217,147));//new Color(255,237,167));
	/** 
	 * ��ɫȫ�ֱ���������������ı���ѡ��ʱ��ǰ��ɫ���ı���ɫ��.��ǰ��Ҫ���ڸ��ı�������˵����.
	 * <p>
	 * ������ñ�������Ҳ��ֱ��ͨ�����Ե�UIManager�������ı�����.
	 * <p>
	 * Ĭ�������ɫ��new Color(255,255,255)��. 
	 * @since 3.2 */
	public static Color commonSelectionForegroundColor = new Color(255,255,255);
	
	/**
	 * ������������Ĭ�����û����ô��ڣ�Frame�������ࣩ�����ô˴������󻯱߽�.
	 * <p>
	 * �˿�����������Ϊ�˽������һ������ ��<br>
	 * ����ʹ�ò���ϵͳ�Ĵ���װ�Σ���ʹ����ȫ�Զ���Ĵ��ڱ��⡢�߿�ʱ����windows����
	 * �󻯴���ʱ����ȫ����ʾ�Ӷ��������·�����������task bar����������� ��˵��2002��
	 * ���Ѵ��ڣ�SUNһֱδ������߸�������Ϊ��bug��Ŀǰ�Ľ�������ǵ���������trueʱ��
	 * Ĭ��Ϊÿһ������������󻯱߽磬���򱣳�ϵͳĬ�ϡ������������ò�������������һ��
	 * ���������߽磬��˺�����Task Bar����ô�� ����С�����类hide�ˣ�������Զ����
	 * ��ʱ�����߽磬����ĿǰҲֻ����ô���н���ˣ���Ϊ��������¼�������L&F��ʵ��
	 * ����δ�ҵ��������õķ�����
	 * <p>
	 * Ĭ��true������ʾĬ�Ͽ���������.
	 * 
	 * @since 3.2
	 * @see javax.swing.JFrame#setMaximizedBounds(java.awt.Rectangle)
	 */
	public static boolean setMaximizedBoundForFrame = true;
	
	/**
	 * BeautyEye LNF�����ʵ�ֺ��ķ���.
	 * <p>
	 * ����������ֱ�Ӵ��ⲿ���ã�����ζ��BeautyEye LNF����ۺ���ʵ�������ض���LookAndFeel��ʵ��.
	 * <p>Ҳ����˵������۶���Ӧ�ñ��������������ʵ�֣�����֤��ƽ̨������ʹ֮�����Ӧ��.
	 * 
	 * @see org.jb2011.lnf.beautyeye.ch1_titlepane.__UI__#uiImpl()
	 * @see org.jb2011.lnf.beautyeye.ch2_tab.__UI__#uiImpl()
	 * @see org.jb2011.lnf.beautyeye.ch3_button.__UI__#uiImpl()
	 * @see org.jb2011.lnf.beautyeye.ch_x.__UI__#uiImpl()
	 * @see org.jb2011.lnf.beautyeye.ch4_scroll.__UI__#uiImpl()
	 * @see org.jb2011.lnf.beautyeye.ch5_table.__UI__#uiImpl()
	 * @see org.jb2011.lnf.beautyeye.ch6_textcoms.__UI__#uiImpl()
	 * @see org.jb2011.lnf.beautyeye.ch7_popup.__UI__#uiImpl()
	 * @see org.jb2011.lnf.beautyeye.ch8_toolbar.__UI__#uiImpl()
	 * @see org.jb2011.lnf.beautyeye.ch9_menu.__UI__#uiImpl()
	 * @see org.jb2011.lnf.beautyeye.ch10_internalframe.__UI__#uiImpl()
	 * @see org.jb2011.lnf.beautyeye.ch12_progress.__UI__#uiImpl()
	 * @see org.jb2011.lnf.beautyeye.ch13_radio$cb_btn.__UI__#uiImpl()
	 * @see org.jb2011.lnf.beautyeye.ch14_combox.__UI__#uiImpl()
	 * @see org.jb2011.lnf.beautyeye.ch15_slider.__UI__#uiImpl()
	 * @see org.jb2011.lnf.beautyeye.ch16_tree.__UI__#uiImpl()
	 * @see org.jb2011.lnf.beautyeye.ch17_split.__UI__#uiImpl()
	 * @see org.jb2011.lnf.beautyeye.ch18_spinner.__UI__#uiImpl()
	 * @see org.jb2011.lnf.beautyeye.ch19_list.__UI__#uiImpl()
	 * @see org.jb2011.lnf.beautyeye.ch20_filechooser.__UI__#uiImpl_win()
	 */
	protected static void implLNF()
	{
		//�Զ��崰�ڵ�L&Fʵ��
		org.jb2011.lnf.beautyeye.ch1_titlepane.__UI__.uiImpl();
		//�Զ���JTabbedPane��L&Fʵ��
		org.jb2011.lnf.beautyeye.ch2_tab.__UI__.uiImpl();
		//�Զ��尴ť��L&Fʵ��
		org.jb2011.lnf.beautyeye.ch3_button.__UI__.uiImpl();
		//���������Ӱ˵�����
		org.jb2011.lnf.beautyeye.ch_x.__UI__.uiImpl();
		//�Զ����������L&Fʵ��
		org.jb2011.lnf.beautyeye.ch4_scroll.__UI__.uiImpl();
		//�Զ�����ͷ��L&Fʵ��
		org.jb2011.lnf.beautyeye.ch5_table.__UI__.uiImpl();
		//�Զ����ı������L&Fʵ��
		org.jb2011.lnf.beautyeye.ch6_textcoms.__UI__.uiImpl();
		//�Զ��嵯�����������toolTip����͵����˵��ȣ���L&Fʵ��
		org.jb2011.lnf.beautyeye.ch7_popup.__UI__.uiImpl();
		//�Զ���ToggleButton��L&Fʵ��
		org.jb2011.lnf.beautyeye.ch8_toolbar.__UI__.uiImpl();
		//�Զ���˵����L&Fʵ��
		org.jb2011.lnf.beautyeye.ch9_menu.__UI__.uiImpl();
		//�Զ���DesktopPane���ڲ������L&Fʵ��
		org.jb2011.lnf.beautyeye.ch10_internalframe.__UI__.uiImpl();
		//�Զ����������L&Fʵ��
		org.jb2011.lnf.beautyeye.ch12_progress.__UI__.uiImpl();
		//�Զ��嵥ѡ��ť��L&Fʵ��
		org.jb2011.lnf.beautyeye.ch13_radio$cb_btn.__UI__.uiImpl();
		//�Զ����������L&Fʵ��
		org.jb2011.lnf.beautyeye.ch14_combox.__UI__.uiImpl();
		//�Զ���JSlider��L&Fʵ��
		org.jb2011.lnf.beautyeye.ch15_slider.__UI__.uiImpl();
		//�Զ���Jtree��L&Fʵ��
		org.jb2011.lnf.beautyeye.ch16_tree.__UI__.uiImpl();
		//�Զ���JSplitPane��L&Fʵ��
		org.jb2011.lnf.beautyeye.ch17_split.__UI__.uiImpl();
		//�Զ���JSpinner��L&Fʵ��
		org.jb2011.lnf.beautyeye.ch18_spinner.__UI__.uiImpl();
		//�Զ���JList��L&Fʵ��
		org.jb2011.lnf.beautyeye.ch19_list.__UI__.uiImpl();
		//�Զ���JFileChooser��L&Fʵ��
		org.jb2011.lnf.beautyeye.ch20_filechooser.__UI__.uiImpl();
	}
	
	/**
	 * Gets the beauty eye lnf str cross platform.
	 *
	 * @return "org.jb2011.lnf.beautyeye.BeautyEyeLookAndFeelCross"
	 */
	public static String getBeautyEyeLNFStrCrossPlatform()
	{
		return "org.jb2011.lnf.beautyeye.BeautyEyeLookAndFeelCross";
	}
	
	/**
	 * Gets the beauty eye lnf str windows platform.
	 *
	 * @return "org.jb2011.lnf.beautyeye.BeautyEyeLookAndFeelWin"
	 */
	public static String getBeautyEyeLNFStrWindowsPlatform()
	{
		return "org.jb2011.lnf.beautyeye.BeautyEyeLookAndFeelWin";
	}
	
	/**
	 * Gets the beauty eye lnf cross platform.
	 *
	 * @return {@code new BeautyEyeLookAndFeelCross()}
	 */
	public static LookAndFeel getBeautyEyeLNFCrossPlatform()
	{
		return new BeautyEyeLookAndFeelCross();
	}
	
	/**
	 * Gets the beauty eye lnf windows platform.
	 *
	 * @return {@code new BeautyEyeLookAndFeelWin()}
	 */
	public static LookAndFeel getBeautyEyeLNFWindowsPlatform()
	{
		return new BeautyEyeLookAndFeelWin();
	}
	
	/**
	 * ʵʩBeautyEye���.<b>������ʹ��BeautyEye L&FʱӦ��ѡ������.</b>
	 * <p>
	 * ��������ݲ���ϵͳ���Ͳ�ͬ��������������ʹ��BeautyEyeLookAndFeelWin����BeautyEyeLookAndFeelWin.
	 * ʹ��BeautyEye���ʱ�Ƽ�ʹ�ñ��������������.֮������ƽ̨��ͬ���಻ͬ�����֣���Ϊ��
	 * ��Windows��ƽ̨���ܸ��õ�ʹ�������ϵͳ��ͬ�����������.
	 * 
	 * @throws Exception {@link UIManager#setLookAndFeel(String)}�����г��ֵ��κ��쳣
	 * @see #getBeautyEyeLNFStrWindowsPlatform()
	 * @see #getBeautyEyeLNFStrCrossPlatform()
	 * @see org.jb2011.lnf.beautyeye.utils.Platform
	 */
	public static void launchBeautyEyeLNF() throws Exception
	{
		if(org.jb2011.lnf.beautyeye.utils.Platform.isWindows())
		{
			if(BeautyEyeLNFHelper.debug)
				System.out.println("����������Windowsƽ̨ר�õ�BeautyEye���ʵ��(��Ҳ���������ÿ�ƽ̨ʵ��).");
			UIManager.setLookAndFeel(getBeautyEyeLNFStrWindowsPlatform());
		}
		else
		{
			if(BeautyEyeLNFHelper.debug)
				System.out.println("���������ÿ�ƽ̨��ͨ��BeautyEye���ʵ��.");
			UIManager.setLookAndFeel(getBeautyEyeLNFStrCrossPlatform());
		}
	}
	
	/**
	 * ��ǰ���е�Java�汾�Ƿ�֧�ִ���͸����ÿ���ذ�͸��.
	 * <p>
	 * ����java1.6.0_u12���Ժ�汾��֧�֣�ΪʲôҪ��u12��֧�֣�
	 * ��u10��u11��Ĵ���͸������BUG 6750920��.
	 * 
	 * @return true��ʾ֧�֣�����֧��
	 */
	public static boolean isSurportedTranslucency()
	{
		//�Ƿ�֧�ִ���͸��������java1.6.0_u12���Ժ�汾��֧��
		return JVM.current().isOneDotSixUpdate12OrAfter();//JDK1_6_U10);//ΪʲôҪ��u12��֧�֣���u10��Ĵ���͸������BUG 6750920
	}
	
	/**
	 * <b>�����������ע������.</b>
	 * <p>
	 * true��ʾ��ǰ����ʹ�õĴ��ڱ߿��ǲ�͸���ģ������ʾ͸��.
	 * ������Ŀǰ��ΪBERootPaneUI�����ô����Ƿ�͸���Ŀ���ʹ��.
	 * <p>
	 * #### �ٷ�API�д��Bug�� ####<br>
	 * ��jdk1.6.0_u33��+win7ƽ̨�£������汾�Ƿ�Ҳ���������δ��ȫ��֤����JFrame����
	 * �����ó�͸���󣬸ô����������ı����ᱻ����������������û��Ҫ�����������汯�ߡ�
	 * ��Ӧ���ǹٷ�AWTUtilities.setWindowOpaque(..)bug���µ�,1.7.0_u6ͬ�����ڸ����⣬
	 * ʹ��BeautyEyeʱ����������������ֻ������ʹ�ñ�������ָ���Ĳ�͸���߿���У�����
	 * BERootPaneUI������ô���͸���Ĵ���Ͳ���ִ�У�Ҳ�Ͳ��ô�����bug�ˣ�����JDialog
	 * ���ܴ�bugӰ�죬���죡
	 *
	 * @return true, if successful
	 * @since 3.2
	 */
	public static boolean __isFrameBorderOpaque()
	{
		return frameBorderStyle == FrameBorderStyle.osLookAndFeelDecorated 
			|| frameBorderStyle == FrameBorderStyle.generalNoTranslucencyShadow;
	}
	/**
	 * <b>�����������ע������.</b>
	 * <p>
	 * �������õ�frameBorderStyle��������ȷ�Ĵ��ڱ߿�.
	 * 
	 * @return ��frameBorderStyle=={@link FrameBorderStyle#defaultLookAndFeelDecorated}
	 * ʱ�����������BorderFactory.createEmptyBorder()�����򷵻�ָ���߿����
	 */
	public static Border __getFrameBorder()
	{
		switch(frameBorderStyle)
		{
			case osLookAndFeelDecorated:
				return BorderFactory.createEmptyBorder();
			case translucencyAppleLike:
				return new BEShadowBorder3();
			case translucencySmallShadow:
				return new BEShadowBorder();
			case generalNoTranslucencyShadow:
			default:
				return new PlainGrayBorder();
		}
	}
//	/**
//	 * <b>�����������ע������.</b>
//	 * <p>
//	 * �������õ�frameBorderStyle��������ȷ�Ĵ��ڱ߿�߽ǵ��϶�����С.
//	 * <p>
//	 * <b>��Ҫ˵����</b>�������еı߿����ͼ����Ӧ�ı߿�������뷽�� {@link #__getFrameBorder()}
//	 * ��ȫһ�£�
//	 * 
//	 * @return ��frameBorderStyle=={@link FrameBorderStyle#defaultLookAndFeelDecorated}
//	 * ʱ����null�����򷵻�ָ���߿����
//	 */
//	public static int __getFrameBorder_CORNER_DRAG_WIDTH()
//	{
//		switch(frameBorderStyle)
//		{
//			case osLookAndFeelDecorated:
//				return 16;
//			case translucencyAppleLike:
//				return BEShadowBorder3.CORNER_DRAG_WIDTH();
//			case translucencySmallShadow:
//				return new BEShadowBorder().CORNER_DRAG_WIDTH();
//			case generalNoTranslucencyShadow:
//			default:
//				return new PlainGrayBorder().CORNER_DRAG_WIDTH();
//		}
//	}
//	/**
//	 * <b>�����������ע������.</b>
//	 * <p>
//	 * �������õ�frameBorderStyle��������ȷ�Ĵ��ڱ߿��϶�����С.
//	 * <p>
//	 * <b>��Ҫ˵����</b>�������еı߿����ͼ����Ӧ�ı߿�������뷽�� {@link #__getFrameBorder()}
//	 * ��ȫһ�£�
//	 * 
//	 * @return ��frameBorderStyle=={@link FrameBorderStyle#defaultLookAndFeelDecorated}
//	 * ʱ����null�����򷵻�ָ���߿����
//	 */
//	public static int __getFrameBorder_BORDER_DRAG_THICKNESS()
//	{
//		switch(frameBorderStyle)
//		{
//			case osLookAndFeelDecorated:
//				return 5;
//			case translucencyAppleLike:
//				return BEShadowBorder3.BORDER_DRAG_THICKNESS();
//			case translucencySmallShadow:
//				return new BEShadowBorder().BORDER_DRAG_THICKNESS();
//			case generalNoTranslucencyShadow:
//			default:
//				return new PlainGrayBorder().BORDER_DRAG_THICKNESS();
//		}
//	}
	
	/**
	 * BeautyEye LNF �Ĵ��ڱ߿���ʽ.
	 */
	public enum FrameBorderStyle
	{
		
		/** ʹ�ñ���ϵͳ�Ĵ���װ����ʽ������ʽ���ܴ���������ܣ�ʹ�ò���ϵͳĬ�ϴ�����ʽ��. */
		osLookAndFeelDecorated,
		
		/** ʹ��������MacOSX��ǿ������а�͸����Ӱ�߿򣨱���ʽ�����пɣ��Ӿ�Ч����ѣ�. */
		translucencyAppleLike,
		
		/** ʹ�ò�̫ǿ������а�͸����Ӱ�߿򣨱���ʽ�����пɣ��Ӿ�Ч����soft��. */
		translucencySmallShadow,
		/** ʹ�ò�͸������ͨ�߿����Ǳ�LNF��Java1.5��Ĭ��ʹ�õ���ʽ����Ϊjava1.5��֧�ִ���͸���� */
		generalNoTranslucencyShadow
	}
	
	/**
	 * <b>��������ʱ�����ע�˽ӿ�.</b>
	 * <p>
	 * ʵ���˴˽ӿڵ�UI����ζ���û�����ͨ��������������border�ȣ���
	 * ȡ��Ĭ�ϵ�NainePatchͼʵ�ֵı߿���䡢�������ȣ�����������
	 * Щ��������ȡ��Ĭ�ϵ�NinePatchͼ���ķ�ʽ������Ե���ע�͡�
	 */
	public interface __UseParentPaintSurported
	{
		
		/**
		 * �Ƿ�ʹ�ø���Ļ���ʵ�ַ�����true��ʾ��.
		 * <p>
		 * ��Ϊ��BE LNF�У��������ͱ�������ʹ��N9ͼ������û��ͨ������JProgressBar�ı���ɫ��ǰ��
		 * ɫ�����ƽ���������ɫ����������Ŀ�ľ��ǵ��û������˽�������Background��Foreground
		 * ʱ��֮��ʵ���಻ʹ��BE LNF��Ĭ�ϵ�N9ͼ�����ƶ����ø����еķ����������еķ���
		 * �Ϳ���֧����ɫ�������ޣ�ֻ�ǳ�㣬���ܹ�������Ӧ�û������󳡾�Ҫ����ʵ�û���ȫ����
		 * ͨ��JProgressBar.setUI(new MetalProgressBar())��ʽ���Զ�����ȵ�UIŶ��.
		 *
		 * @return true, if is use parent paint
		 */
		boolean isUseParentPaint();
	}
}
