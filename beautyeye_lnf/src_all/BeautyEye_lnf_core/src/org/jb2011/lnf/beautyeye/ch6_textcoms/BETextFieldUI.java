/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BETextFieldUI.java at 2012-9-24 17:22:43, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch6_textcoms;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicTextFieldUI;
import javax.swing.text.JTextComponent;

import org.jb2011.lnf.beautyeye.ch6_textcoms.__UI__.BgSwitchable;
import org.jb2011.lnf.beautyeye.widget.FocusListenerImpl;

import com.android.ninepatch.NinePatch;

// TODO: Auto-generated Javadoc
/**
 * �ı����JTextField��UIʵ���ࡣ.
 *
 * @author Jack Jiang(jb2011@163.com)
 */
public class BETextFieldUI extends BasicTextFieldUI implements BgSwitchable
	,org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.__UseParentPaintSurported//WindowsTextFieldUI
{
	
	/** The bg. */
	private NinePatch bg = __Icon9Factory__.getInstance().getTextFieldBgNormal();
	
    /**
     * Creates the ui.
     *
     * @param c the c
     * @return the bE text field ui
     * {@inheritDoc}
     */
    public static BETextFieldUI createUI(JComponent c) 
    {
    	addOtherListener(c);
        return new BETextFieldUI();
    }
    
    //* ��������Jack Jiang��2012-09-07�ռ���
    /**
     * �Ƿ�ʹ�ø���Ļ���ʵ�ַ�����true��ʾ��.
     * <p>
     * ��Ϊ��BE LNF�У��߿�ͱ����ȶ���ʹ��N9ͼ��û��ͨ�����ñ���ɫ��ǰ��
     * ɫ������JTextField����ɫ�ͱ߿򣬱�������Ŀ�ľ��ǵ��û������˽�������border�򱳾�ɫ
     * ʱ��֮��ʵ���಻ʹ��BE LNF��Ĭ�ϵ�N9ͼ�����ƶ����ø����еķ����������еķ���
     * �Ϳ���֧����ɫ�������ޣ�ֻ�ǳ�㣬���ܹ�������Ӧ�û������󳡾�Ҫ����ʵ�û���ȫ����
     * ͨ��JTextField.setUI(..)��ʽ���Զ���UIŶ��.
     *
     * @return true, if is use parent paint
     */
    public boolean isUseParentPaint()
    {
    	return getComponent() != null 
    		&& ( !(getComponent().getBorder() instanceof UIResource)
    				||!(getComponent().getBackground() instanceof UIResource));
    }
    
    /**
     * Paints a background for the view.  This will only be
     * called if isOpaque() on the associated component is
     * true.  The default is to paint the background color 
     * of the component.
     *
     * @param g the graphics context
     */
    protected void paintBackground(Graphics g)
    {
//    	Color bgc = editor.getBackground();
//        g.setColor(bgc);
//        //���� �䱳��
//        g.fillRect(0, 0, editor.getWidth(), editor.getHeight());
//        
//        //(1) ---- ��Numbus�ı���Ч��
//        //** top����Ч��ʵ��
//        //��(0,0)��ʼ�ĵ�һ���߻ᱻ������border���ǵ��ģ����Դ˴�����û�����壬������
////        g.setColor(new Color(0,0,0));
////        g.drawLine(0, 0, editor.getWidth(), 0);
//        //��2������ɫ��һ��
//        g.setColor(new Color(208,208,208));
//        g.drawLine(0, 1, editor.getWidth(), 1);
//        //��3������ɫ����һ��
//        g.setColor(new Color(231,231,225));
//        g.drawLine(0, 2, editor.getWidth(), 2);
    	
    	
    	//�ȵ��ø��෽���ѱ���ˢ���£����籾UI��ʹ�õĴ�Բ��NPͼ�粻��ˢ�±����������������������
    	//����4��Բ��λ�õò���ˢ�£��Ӷ�Ӱ���Ӿ�Ч�����߽���ǰ���������������͸���߽ǲ���͸��������
    	//������⣬���п�����Android��NinePatch����Ϊ���������������Ż�����һ��ȫ͸�����ؼ���ζ�Ų�����ƣ�
    	super.paintBackground(g);// TODO ���ڽ�Լ������Դ�����ǣ����д��뻻�ɸ�����Ĭ����䱳���Ĵ��뼴��
    	
    	//* ����û������Զ�����ɫ������ʹ�ø��෽����ʵ�ֻ��ƣ�����BE LNF��û��֧����Щ����Ŷ
    	if(!isUseParentPaint())
    	{
    		//���µ�NPͼʵ�������ı������
    		JTextComponent editor = this.getComponent();
    		BETextFieldUI.paintBg(g, 0, 0, editor.getWidth(), editor.getHeight()
    				, editor.isEnabled(), bg);
    	}
    	
//    	if(this.getComponent().isEnabled())
//	    	//*** ��Ҫ˵������ʹ�õ�NinePatchͼƬ����䱳�������Ժ����κζ�JTextField����
//	    	//*** ����ɫ��������Ч����Ϊ��������ͼƬ�����Ǵ�ͳ�������Ƴ�����
//	    	bg.draw((Graphics2D)g, 0, 0, editor.getWidth(), editor.getHeight());
//    	else
//    		__Icon9Factory__.getInstance().getTextFieldBgDisabled()
//    			.draw((Graphics2D)g, 0, 0, editor.getWidth(), editor.getHeight());
    		
        
////      //(2) ---- ��360����ܼ��ı���Ч������̫�ÿ���
//        //** top����Ч��ʵ��
//        //��(0,0)��ʼ�ĵ�һ���߻ᱻ������border���ǵ��ģ����Դ˴�����û�����壬������
////        g.setColor(new Color(0,0,0));
////        g.drawLine(0, 0, editor.getWidth(), 0);
//        //��2������ɫ��һ��
//        g.setColor(new Color(232,232,232));
//        g.drawLine(1, 1, editor.getWidth()-1, 1);
//        //��3������ɫ����һ��
//        g.setColor(new Color(241,241,241));
//        g.drawLine(1, 2, editor.getWidth()-1, 2);
//        //��4������ɫ����һ��
//        g.setColor(new Color(248,248,248));
//        g.drawLine(1, 3, editor.getWidth()-1, 3);
//        //��5������ɫ����һ��
//        g.setColor(new Color(252,252,252));
//        g.drawLine(1, 4, editor.getWidth()-1, 4);
//        
//        //** left
//        //��2������ɫ��һ��
//        g.setColor(new Color(241,241,241));
//        g.drawLine(1, 1, 1, editor.getHeight()-1);
//        //��3������ɫ��һ��
//        g.setColor(new Color(248,248,248));
//        g.drawLine(2, 1, 2, editor.getHeight()-1);
//        //��4������ɫ��һ��
//        g.setColor(new Color(253,253,253));
//        g.drawLine(3, 1, 3, editor.getHeight()-1);
//        
//        //** right
//        //��2������ɫ��һ��
//        g.setColor(new Color(241,241,241));
//        g.drawLine(editor.getWidth()-1, 1, editor.getWidth()-1, editor.getHeight()-1);
//        //��3������ɫ��һ��
//        g.setColor(new Color(248,248,248));
//        g.drawLine(editor.getWidth()-2, 1, editor.getWidth()-2, editor.getHeight()-1);
//        //��4������ɫ��һ��
//        g.setColor(new Color(253,253,253));
//        g.drawLine(editor.getWidth()-3, 1, editor.getWidth()-3, editor.getHeight()-1);
//        
//        //** bottom
//        //��2������ɫ��һ��
//        g.setColor(new Color(248,248,248));
//        g.drawLine(1, editor.getHeight()-1, editor.getWidth()-1, editor.getHeight()-1);
//        //��3������ɫ��һ��
//        g.setColor(new Color(252,252,252));
//        g.drawLine(1, editor.getHeight()-2, editor.getWidth()-1, editor.getHeight()-2);
    }
    
    /* (non-Javadoc)
     * @see org.jb2011.lnf.beautyeye.ch6_textcoms.__UI__.BgSwitchable#switchBgToNomal()
     */
    public void switchBgToNomal()
    {
    	this.bg = __Icon9Factory__.getInstance().getTextFieldBgNormal();
    }
    
    /* (non-Javadoc)
     * @see org.jb2011.lnf.beautyeye.ch6_textcoms.__UI__.BgSwitchable#switchBgToFocused()
     */
    public void switchBgToFocused()
    {
    	this.bg = __Icon9Factory__.getInstance().getTextFieldBgFocused();
    }
    
    /**
     * Paint bg.
     *
     * @param g the g
     * @param x the x
     * @param y the y
     * @param w the w
     * @param h the h
     * @param enabled the enabled
     * @param bg the bg
     */
    public static void paintBg(Graphics g, int x, int y, int w , int h
    		, boolean enabled, NinePatch bg)
    {
    	if(enabled)
	    	//*** ��Ҫ˵������ʹ�õ�NinePatchͼƬ����䱳�������Ժ����κζ�JTextField����
	    	//*** ����ɫ��������Ч����Ϊ��������ͼƬ�����Ǵ�ͳ�������Ƴ�����
	    	bg.draw((Graphics2D)g, x, y, w, h);
    	else
    		__Icon9Factory__.getInstance().getTextFieldBgDisabled()
    			.draw((Graphics2D)g, x, y, w, h);
    }
    
    /**
     * Ϊ�����ӽ�������������/ȡ������ʱ�����Զ�����/ȡ��һ����ɫ�ı߿�Ч���������UI���飩
     * ���Ҽ��˵����������и���/ճ���ȹ��ܣ�.
     *
     * @param c the c
     */
    public static void addOtherListener(JComponent c)
    {
    	c.addFocusListener(FocusListenerImpl.getInstance());
//    	c.addMouseListener(new NLLookAndFeel.EditMenu());
    }
    
    
    

}

