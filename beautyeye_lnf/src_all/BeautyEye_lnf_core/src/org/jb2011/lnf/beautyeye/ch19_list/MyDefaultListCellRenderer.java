/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * MyDefaultListCellRenderer.java at 2012-9-24 17:22:25, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch19_list;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

// TODO: Auto-generated Javadoc
/**
 * �б�Ԫ��Ĭ��rendererʵ����.
 * 
 * @author Jack Jiang(jb2011@163.com), 2012-08-30
 * @version 1.0
 */
public class MyDefaultListCellRenderer extends DefaultListCellRenderer
{
	
	/** The is selected. */
	protected boolean isSelected = false;
	
	/** The is focuesed. */
	protected boolean isFocuesed = false;
	
	/**
	 * Instantiates a new my default list cell renderer.
	 */
	public MyDefaultListCellRenderer()
	{
		//���ó�͸����������ζ�Ų���Ҫ������䣬�������е�Ӧ�ó����е�����
        //����Ĭ�ϵ�render��UI�ﲻ��Ҫ���Ʊ���������±���ſɽ���NinePatchͼ��Ϊ�����������
        setOpaque(false);
        
        //** Ҫ��Combox��renderһ������borderû�ã���Ϊ�б�Ԫ����ý���ʱ��border��UIManager����List.cellNoFocusBorder����
//      //ע�����ڳ��Ǿ����б�Ԫ����������ҿհ׵Ĺؼ�Ŷ��
//      setBorder(BorderFactory.createEmptyBorder(5, 8, 5, 8));
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) 
	{
		if(isSelected)
		{
			//ע�⣺2012-09-03���õĸ�ͼƬ�ұ���һ�����صĿհ�Ŷ����ʵ���ǿ���ͨ��List.border��UI������������
			//֮����û��������������Ϊ���պ����ʹ��N9ͼ�����ɵ���������������루List.border�Ĵ���û�ã�
			__Icon9Factory__.getInstance()
				//.getBgIcon_ItemSelected()
				.getBgIcon_ItemSelected2()
				.draw((Graphics2D)g, 0, 0, this.getWidth(), this.getHeight());
		}
		else
		{
//			g.setColor(this.getBackground());
//    		//��Insetsȡthis.getInsets()�Ƿ���Sun����Ƴ��Եģ����ǲ���������isPopupVisible==false
//    		//ʱ�ı����������������������������ͬ����֮��,���Դ˴����Զ����Insets����������UIչ���ϸ�Ϊ���� ��
//    		//TODO ���Instes������ΪUI���ԡ�ComboBox.popupNoVisibleBgInstes�������Ժ����ã���ʱ��Ӳ����ɣ��Ժ���˵
//    		Insets is = new Insets(2,3,2,3);//this.getInsets();
////    		g.fillRect(is.left, is.top
////    				 , this.getWidth()-is.left-is.right
////    				 , this.getHeight()-is.top-is.bottom);
//    		BEUtils.fillTextureRoundRec((Graphics2D)g, this.getBackground(), is.left, is.top
//    				, this.getWidth()-is.left-is.right
//    				, this.getHeight()-is.top-is.bottom,20,0);//20,20
		}
//		else
			//ע�⣺������Ѿ������ó�opaque=false��͸�������򱾷����������Ĭ�ϱ�������ôѡ��ʱ��
	    	//N9ͼ�������Ȼ潫�ᱻ����Ŷ������Ҫʹ��N9ͼ��Ϊѡ��ʱ�ı�����ǰ���Ǳ����������͸��
			super.paintComponent(g);
	}
	
	    
	//* ��jb2011�޸��Ը���ͬ������
	/* (non-Javadoc)
	 * @see javax.swing.DefaultListCellRenderer#getListCellRendererComponent(javax.swing.JList, java.lang.Object, int, boolean, boolean)
	 */
	public Component getListCellRendererComponent(
			JList list,
			Object value,
			int index,
			boolean isSelected,
			boolean cellHasFocus)
	{
		Component c = super.getListCellRendererComponent(list
				, value, index, isSelected, cellHasFocus);
		
		this.isSelected = isSelected;
		this.isFocuesed = cellHasFocus;
		return c;
	}
	
	/**
     * A subclass of DefaultListCellRenderer that implements UIResource.
     * DefaultListCellRenderer doesn't implement UIResource
     * directly so that applications can safely override the
     * cellRenderer property with DefaultListCellRenderer subclasses.
     * <p>
     * <strong>Warning:</strong>
     * Serialized objects of this class will not be compatible with
     * future Swing releases. The current serialization support is
     * appropriate for short term storage or RMI between applications running
     * the same version of Swing.  As of 1.4, support for long term storage
     * of all JavaBeans<sup><font size="-2">TM</font></sup>
     * has been added to the <code>java.beans</code> package.
     * Please see {@link java.beans.XMLEncoder}.
     */
    public static class UIResource extends MyDefaultListCellRenderer
        implements javax.swing.plaf.UIResource{
    }
}
