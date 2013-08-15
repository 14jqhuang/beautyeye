/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BEComboBoxRenderer.java at 2012-9-24 17:21:35, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch14_combox;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import org.jb2011.lnf.beautyeye.utils.BEUtils;

// TODO: Auto-generated Javadoc
/**
 * JComboBox�������ѡ���renderĬ��ʵ����.
 * 
 * @author Jack Jiang(jb2011@163.com), 2012-07-05
 * @see BEComboBoxUI
 */
public class BEComboBoxRenderer extends BasicComboBoxRenderer 
{
	
	/** ��ǰ���������item�Ƿ�ѡ�У������Ƿ�Ҫ���������ѡ����ʽʱʹ��. */
	private boolean selected = false;
	
	/** ���±�render��Ӧ��JComboBox��UI. */
	private BEComboBoxUI ui = null;
	
    /**
     * Instantiates a new bE combo box renderer.
     *
     * @param ui the ui
     */
    public BEComboBoxRenderer(BEComboBoxUI ui)
    {
        super();
        this.ui = ui;
        //���ó�͸����������ζ�Ų���Ҫ������䣬�������е�Ӧ�ó����е�����
        //����Ĭ�ϵ�render��UI�ﲻ��Ҫ���Ʊ���������±���ſɽ���NinePatchͼ��Ϊ�����������
        setOpaque(false);
        //TODO ��border��render���ڳģ�������Ϊһ��UIManager������Ŷ�������Ժ�����
        //ע�����ڳ��Ǿ����б�Ԫ����������ҿհ׵Ĺؼ�Ŷ��
        setBorder(BorderFactory.createEmptyBorder(5, 4, 5, 8));//����������Combox.border UI�������Ŷ
    }
    
    //copy from BasicComboBoxRenderer and modified by jb2011
    //��������this.selected = isSelected�⣬û���޸���������
    /* (non-Javadoc)
     * @see javax.swing.plaf.basic.BasicComboBoxRenderer#getListCellRendererComponent(javax.swing.JList, java.lang.Object, int, boolean, boolean)
     */
    public Component getListCellRendererComponent(JList list, 
    		Object value,
    		int index, 
    		boolean isSelected, 
    		boolean cellHasFocus)
    {
		Component c = super.getListCellRendererComponent(list
				, value, index, isSelected, cellHasFocus);
    	//add by jb2011������ѡ��״̬
    	this.selected = isSelected;
    	return c;
    }
    
    //����˵�������е��Ƿ�ѡ�б������ʵ���߼���Render��UI��ʵ����Ϊ����������
    //������Ǵ�����UIʵ���У��������ײ�����ͻ���ʶ��������Զ���Uiʵ�֣��ɴ�Ӳ�������ֱ��
    /* (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    public void paintComponent(Graphics g) 
    {
    	//������ѡ���ʱ �� ��item�Ǳ�ѡ��ʱ����Ҫ�ѱ�������ѡ����ʽ
    	if (ui.isPopupVisible(null) && selected)
    	{
    		org.jb2011.lnf.beautyeye.ch9_menu.__Icon9Factory__.getInstance().getBgIcon_ItemSelected()
    			.draw((Graphics2D)g, 0, 0, this.getWidth(), this.getHeight());
    	}
    	//����ѡ��δ����ʱJComboBox�ı�����ʽ
    	//����˵�����������ó�͸����������䱳��������Ӧ�ó����У�ֻ����Ĭ��Ui����䱳��������²�
    	//������Զ���NinePatch��������䡣�� ComponentUI.update(Graphics g, JComponent c)����
    	else
    	{
    		//ֻ����popup���ɼ� �� ��combox��ý�����������Ҫ���ƺø���Բ�Ǳ�����ʾ����
    		if(!ui.isPopupVisible(null) && ui.getCombox().isFocusOwner())
    		{
    			g.setColor(this.getBackground());
    		 
    			//��Insetsȡthis.getInsets()�Ƿ���Sun����Ƴ��Եģ����ǲ���������isPopupVisible==false
    			//ʱ�ı����������������������������ͬ����֮��,���Դ˴����Զ����Insets����������UIչ���ϸ�Ϊ���� ��
    			//TODO ���Instes������ΪUI���ԡ�ComboBox.popupNoVisibleBgInstes�������Ժ����ã���ʱ��Ӳ����ɣ��Ժ���˵
    			Insets is = new Insets(2,0,2,3);//this.getInsets();////����������Combox.border UI���Ժ�render��border���Ŷ
//    			g.fillRect(is.left, is.top
//    				 , this.getWidth()-is.left-is.right
//    				 , this.getHeight()-is.top-is.bottom);
    			BEUtils.fillTextureRoundRec((Graphics2D)g, this.getBackground(), is.left, is.top
    					, this.getWidth()-is.left-is.right
    					, this.getHeight()-is.top-is.bottom,20,20);//20,20
    		}
    	}

    	//ע�⣺������Ѿ������ó�opaque=false��͸�������򱾷����������Ĭ�ϱ�������ôѡ��ʱ��
    	//N9ͼ�������Ȼ潫�ᱻ����Ŷ������Ҫʹ��N9ͼ��Ϊѡ��ʱ�ı�����ǰ���Ǳ����������͸��
    	super.paintComponent(g);
	 }

    //copy from BasicComboBoxRenderer and modified by jb2011
    /**
     * A subclass of BasicComboBoxRenderer that implements UIResource.
     * BasicComboBoxRenderer doesn't implement UIResource
     * directly so that applications can safely override the
     * cellRenderer property with BasicListCellRenderer subclasses.
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
    public static class UIResource extends BEComboBoxRenderer implements javax.swing.plaf.UIResource 
    {
    	
	    /**
	     * Instantiates a new uI resource.
	     *
	     * @param ui the ui
	     */
	    public UIResource(BEComboBoxUI ui)
    	{
    		super(ui);
    	}
    }
}
