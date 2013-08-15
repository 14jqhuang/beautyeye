/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BEListUI.java at 2012-9-24 17:22:25, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch19_list;

import javax.swing.CellRendererPane;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicListUI;

// TODO: Auto-generated Javadoc
/**
 * JList��UIʵ���ࡣ.
 *
 * @author Jack Jiang(jb2011@163.com)
 * @version 1.0
 */
public class BEListUI extends BasicListUI 
{
	
	/**
	 * Creates the ui.
	 *
	 * @param c the c
	 * @return the component ui
	 */
	public static ComponentUI createUI(JComponent c) 
	{
		return new BEListUI();
	}

	/**
	 * Initialize JList properties, e.g. font, foreground, and background,
	 * and add the CellRendererPane.  The font, foreground, and background
	 * properties are only set if their current value is either null
	 * or a UIResource, other properties are set if the current
	 * value is null.
	 *
	 * @see #uninstallDefaults
	 * @see #installUI
	 * @see CellRendererPane
	 */
	protected void installDefaults()
	{
		super.installDefaults();
		
		//2012-08-30*******************************************************����Ҫ˵���� START ��ӦBEComboBoxUI�еġ���Ҫ˵����
    	//* ����Ҫ˵������BEListUI��Ϊ��ʹ�б��е�Ԫ�߱�ĸ��ߣ���MyDefaultListCellRenderer.java��
    	//* ��COmboxRenderһ��ͨ������border����Ч������������BasicListUI�����ȱ�ݣ���ҪôȡFixedCellHeight
    	//* �̶�ֵ��ҪôȡgetPreferSize()���Զ�����߶ȡ������ƺ��ǲ�����border�ģ�����render����border����Ч��
    	//* ����ֻ��Ϊ�б�Ԫ������ֵ��list.setFixedCellHeight(30)��������Ӱ��Combox����иߣ�Ҳ����30�ߣ�
    	//* ����BEComboBoxUI��Ҫ�ѱ��б�UI��ǿ���趨��30�����Combox��ԭ���Զ����㣨API�й涨FixedCellHeight==-1����ʾ�Զ����㣩
    	//*************************************************************** ����Ҫ˵���� END
		//* ��jb2011���룬��ʾ�б�Ԫ�̶��߶ȣ�Ĭ��ֵ=-1������ζ���и��Զ����㣩
		//* ʹ��BE LNF����Ŀ����Ҫ�ָ��и��㶯��������ʾ�����б�Ĺ̶��и�Ϊ-1���ɣ�
		list.setFixedCellHeight(32);//30);// TODO ������ֵ��һ��UIManager���ԾͿ��Է����Ժ������ˣ�-1��ԭϵͳĬ��ֵŶ�����Զ����㵥Ԫ�ߣ�
		
		//* ����Ҫ�ˣ�����ǿ��Ҫ����Ϊ͸�����ܻ�Ӱ���Ժ��û��Ķ������󣬸ɴ�
		//* �������ı���Ϊ�ϰ�ɫ��Ҳ�ܴﵽ�뵽��N9��ɫ����
//		//�����ý�ȡ���б����Ļ��ƣ��Ա�BE LNF�л���N9����ͼŶ��
//		list.setOpaque(false);
	}
}
