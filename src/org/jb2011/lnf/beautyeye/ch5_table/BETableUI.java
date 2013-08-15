/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BETableUI.java at 2012-9-24 17:22:40, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch5_table;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.UIDefaults;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTableUI;

// TODO: Auto-generated Javadoc
/**
 * JTable��UIʵ���ࡣ.
 *
 * @author Jack Jiang(jb2011@163.com)
 */
public class BETableUI extends BasicTableUI
{
	
	/** The default renderers by column class. */
	UIDefaults defaultRenderersByColumnClass;
	
    /**
     * Creates the ui.
     *
     * @param c the c
     * @return the component ui
     */
    public static ComponentUI createUI(JComponent c) 
    {
        return new BETableUI();
    }

    /**
     * Initialize JTable properties, e.g. font, foreground, and background.
     * The font, foreground, and background properties are only set if their
     * current value is either null or a UIResource, other properties are set
     * if the current value is null.
     *
     * @see #installUI
     */
	@Override
    protected void installDefaults() 
	{
    	super.installDefaults();
    	//�и�����Ϊ25�����������Щ
		table.setRowHeight(25);
		//����ʾ��ֱ��������
		table.setShowVerticalLines(false);
		//���õ�Ԫ���Ŀհף�Ĭ����1�����ؿ�͸ߣ�
		//˵�������ñ���������ʵ�ֵ�Ԫ���ļ�����ƣ������ͨ����ʵ�������ߵĻ��ƣ���
		//����ά������񲢲�Ӱ�����Ĵ��ڣ����������ڵ������߲���Ļ���������͸���Ŀ�
		//�䣩��������width��ʾˮƽ�����height��ʾ��ֱ�����Ϊ0���ʾû�м��
		table.setIntercellSpacing(new Dimension(0,1));
    }
}
