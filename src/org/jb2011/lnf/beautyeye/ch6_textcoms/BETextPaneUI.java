/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BETextPaneUI.java at 2012-9-24 17:22:43, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch6_textcoms;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicTextPaneUI;
import javax.swing.text.JTextComponent;

import org.jb2011.lnf.beautyeye.ch6_textcoms.__UI__.BgSwitchable;

import com.android.ninepatch.NinePatch;

// TODO: Auto-generated Javadoc
/**
 * �ı����JTextPane��UIʵ���ࡣ.
 *
 * @author Jack Jiang(jb2011@163.com), 2012-08-25
 */
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� Start
//����ο���WindowsTextPaneUI��ʵ��
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� END
public class BETextPaneUI extends BasicTextPaneUI implements BgSwitchable
	,org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.__UseParentPaintSurported//WindowsTextPaneUI
{
	//Ĭ���Ǵ���ɫ��������ΪJTextPane�϶���Ҫ����JScrollPane�еģ���ScrollPaneҲ���б߿��
	//���JTextPane���б߿�ͺ��ѿ��ˣ�����JTextPane��û�л�ý���ʱ�����ޱ߿�Ч�����ֻ�ÿ��ܶ�
	/** The bg. */
	private NinePatch bg = __Icon9Factory__.getInstance().getNullWhiteBg();
	
    /**
     * Creates a UI for a JTextPane.
     *
     * @param c the styled text component
     * @return the UI
     */
    public static ComponentUI createUI(JComponent c) 
    {
    	BETextFieldUI.addOtherListener(c);
//    	c.addMouseListener(new NLLookAndFeel.EditMenu());
        return new BETextPaneUI();
    }
    
    //* ��������Jack Jiang��2012-09-07�ռ���
    /**
     * �Ƿ�ʹ�ø���Ļ���ʵ�ַ�����true��ʾ��.
     * <p>
     * ��Ϊ��BE LNF�У��߿�ͱ����ȶ���ʹ��N9ͼ��û��ͨ�����ñ���ɫ��ǰ��
     * ɫ������JTextPane����ɫ�ͱ߿򣬱�������Ŀ�ľ��ǵ��û������˽�������border�򱳾�ɫ
     * ʱ��֮��ʵ���಻ʹ��BE LNF��Ĭ�ϵ�N9ͼ�����ƶ����ø����еķ����������еķ���
     * �Ϳ���֧����ɫ�������ޣ�ֻ�ǳ�㣬���ܹ�������Ӧ�û������󳡾�Ҫ����ʵ�û���ȫ����
     * ͨ��JTextPane.setUI(..)��ʽ���Զ���UIŶ��.
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
    }
    
    /* (non-Javadoc)
     * @see org.jb2011.lnf.beautyeye.ch6_textcoms.__UI__.BgSwitchable#switchBgToNomal()
     */
    public void switchBgToNomal()
    {
    	//Ĭ���Ǵ���ɫ��������ΪJTextPane�϶���Ҫ����JScrollPane�еģ���ScrollPaneҲ���б߿��
    	//���JTextPane���б߿�ͺ��ѿ��ˣ�����JTextPane��û�л�ý���ʱ�����ޱ߿�Ч�����ֻ�ÿ��ܶ�
    	this.bg = __Icon9Factory__.getInstance().getNullWhiteBg();
    }
    
    /* (non-Javadoc)
     * @see org.jb2011.lnf.beautyeye.ch6_textcoms.__UI__.BgSwitchable#switchBgToFocused()
     */
    public void switchBgToFocused()
    {
    	this.bg = __Icon9Factory__.getInstance().getTextFieldBgFocused();
    }

//    /**
//     * Creates the object to use for a caret.  By default an
//     * instance of WindowsCaret is created.  This method
//     * can be redefined to provide something else that implements
//     * the InputPosition interface or a subclass of DefaultCaret.
//     *
//     * @return the caret object
//     */
//    protected Caret createCaret() {
//        return new WindowsTextUI.WindowsCaret();
//    }
}

