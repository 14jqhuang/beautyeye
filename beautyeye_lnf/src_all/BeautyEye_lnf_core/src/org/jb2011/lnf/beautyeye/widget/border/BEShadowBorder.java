/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BEShadowBorder.java at 2012-9-24 17:23:02, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.widget.border;

import java.awt.Insets;

// TODO: Auto-generated Javadoc
/**
 * һ����9��ͼʵ�ֵı߿���ӰЧ����Ŀǰ�����ڲ����ڵı߿���ӰЧ���ǰ�͸���ģ���.
 *
 * @author Jack Jiang(jb2011@163.com)
 * @see org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.FrameBorderStyle#translucencySmallShadow
 */
public class BEShadowBorder extends NinePatchBorder//AbstractBorder
{
	
	/** The Constant BOTTOM. */
	private final static int TOP = 5,LEFT = 5,RIGHT = 5,BOTTOM = 6;
	
	/**
	 * Instantiates a new bE shadow border.
	 */
	public BEShadowBorder()
	{
		super(new Insets(TOP, LEFT, BOTTOM, RIGHT)
				, org.jb2011.lnf.beautyeye.widget.__Icon9Factory__.getInstance().getBorderIcon_Shadow1());
	}
	
	//* 2012-09-19 ��BeautyEye v3.2�е�BERootPaneUI��Jack Jiang���������
	//* ԭMetalRootPaneUI�и���ȷ���õı߿��Ϸ��㷨�����·�����ʱ���ã��Ժ����ɾ���ˣ�
//	//���ñ�border���߿�ʱ�����ڿ��϶����д�������Сֵ
//	public static int BORDER_DRAG_THICKNESS()
//	{
//		return Math.min(Math.min(Math.min(TOP, LEFT),RIGHT),BOTTOM);
//	}
//	
//	//���ñ�border���߿�ʱ�����ڱ߽ǿ��϶����д�������Сֵ
//	public static int CORNER_DRAG_WIDTH()
//	{
//		return Math.max(Math.max(Math.max(TOP, LEFT),RIGHT),BOTTOM);
//	}
}
