/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * PlainGrayBorder.java at 2012-9-24 17:23:03, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.widget.border;

import java.awt.Insets;

import org.jb2011.lnf.beautyeye.widget.__Icon9Factory__;

// TODO: Auto-generated Javadoc
/**
 * һ��NinePatchͼʵ�ֵĲ�͸���߿�border.
 * <p>
 * Ŀǰ��Ҫ����jdk1.5�����°汾�Ĵ��ڱ߿���Ϊ�ð汾��java��֧�ִ���͸����.
 * 
 * @author Jack Jiang(jb2011@163.com), 2012-09-04
 * @version 1.0
 * @see org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.FrameBorderStyle#generalNoTranslucencyShadow
 */
public class PlainGrayBorder extends NinePatchBorder
{
	
	/** The Constant IS. */
	private final static int IS = 5;
	
	/**
	 * Instantiates a new plain gray border.
	 */
	public PlainGrayBorder()
	{
		super(new Insets(IS,IS,IS,IS)
			, __Icon9Factory__.getInstance().getBorderIcon_plainGray());
	}
	
	//* 2012-09-19 ��BeautyEye v3.2�е�BERootPaneUI��Jack Jiang���������
	//* ԭMetalRootPaneUI�и���ȷ���õı߿��Ϸ��㷨�����·�����ʱ���ã��Ժ����ɾ���ˣ�
//	//���ñ�border���߿�ʱ�����ڿ��϶����д�������Сֵ
//	public static int BORDER_DRAG_THICKNESS()
//	{
//		return IS;
//	}
//	//���ñ�border���߿�ʱ�����ڱ߽ǿ��϶����д�������Сֵ
//	public static int CORNER_DRAG_WIDTH()
//	{
//		return 16;//ʹ��MetalLookAndFeel��Ĭ��ֵ�ȽϺ���Ŷ
//	}
}
