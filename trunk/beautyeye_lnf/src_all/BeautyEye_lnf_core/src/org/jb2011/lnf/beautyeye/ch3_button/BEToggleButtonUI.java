/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BEToggleButtonUI.java at 2012-9-24 17:22:34, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch3_button;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicToggleButtonUI;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI.NormalColor;
import org.jb2011.lnf.beautyeye.utils.BEUtils;
import org.jb2011.lnf.beautyeye.utils.MySwingUtilities2;

import sun.awt.AppContext;


// TODO: Auto-generated Javadoc
/**
 * JToggleButton��UIʵ���ࡣ.
 *
 * @author Jack Jiang(jb2011@163.com)
 */
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� Start
//�����ʵ�ֲο���JDK1.6_u18��WindowsToggleButtonUI����
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� END
public class BEToggleButtonUI extends BasicToggleButtonUI
{
    
    /** The Constant WINDOWS_TOGGLE_BUTTON_UI_KEY. */
    private static final Object WINDOWS_TOGGLE_BUTTON_UI_KEY = new Object();
    
    /** The nomal color. */
    private NormalColor nomalColor = BEButtonUI.NormalColor.normal;
    
    /**
     * Creates the ui.
     *
     * @param b the b
     * @return the component ui
     */
    public static ComponentUI createUI(JComponent b) {
        AppContext appContext = AppContext.getAppContext();
        BEToggleButtonUI windowsToggleButtonUI = 
                (BEToggleButtonUI) appContext.get(WINDOWS_TOGGLE_BUTTON_UI_KEY);
        if (windowsToggleButtonUI == null) {
            windowsToggleButtonUI = new BEToggleButtonUI();
            appContext.put(WINDOWS_TOGGLE_BUTTON_UI_KEY, windowsToggleButtonUI);
        }
        return windowsToggleButtonUI;
    }

    // ********************************
    //         Paint Methods
    // ********************************
    /* (non-Javadoc)
     * @see javax.swing.plaf.basic.BasicToggleButtonUI#paint(java.awt.Graphics, javax.swing.JComponent)
     */
    public void paint(Graphics g, JComponent c) 
    {
////    	if (NLXPStyle.getXP() != null) 
//    	{
    		BEButtonUI.paintXPButtonBackground(nomalColor,g, c);
//    	}
    	super.paint(g, c);
    }
    
    //copy from BasicToggleButtonUI,modified by jb2011 2012-06-15
    //�޸ĵ�Ŀ���������ڻ�ý��㣨��˵����ʱ���ı�ǰ��ɫ����ϧ������û��ʵ������ֻ�������������
    /**
     * As of Java 2 platform v 1.4 this method should not be used or overriden.
     * Use the paintText method which takes the AbstractButton argument.
     *
     * @param g the g
     * @param c the c
     * @param textRect the text rect
     * @param text the text
     */
    protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text) {
    	AbstractButton b = (AbstractButton) c;                       
    	ButtonModel model = b.getModel();
    	FontMetrics fm = //SwingUtilities2
    					MySwingUtilities2.getFontMetrics(c, g);
    	int mnemonicIndex = b.getDisplayedMnemonicIndex();

    	/* Draw the Text */
    	if(model.isEnabled()) 
    	{
    		//=================== modified by jb2011 START
    		if(model.isSelected())//ѡ��ʱʹ�ò�ͬ����ɫ
    			g.setColor(UIManager.getColor(getPropertyPrefix()+"focus"));
    		else
    			/*** paint the text normally */
    			g.setColor(b.getForeground());
    		//=================== modified by jb2011 END
    		
//    		SwingUtilities2 *��Ҫֱ�ӵ��ø��ࣨ��Ϊ����sunδ����api��1.5����1.6���Ժ�������ڲ�ͬ�İ��ĳ��������ʧҲ˵���ã�
    		MySwingUtilities2.drawStringUnderlineCharAt(c, g,text, mnemonicIndex,
    				textRect.x + getTextShiftOffset(),
    				textRect.y + fm.getAscent() + getTextShiftOffset());
    	}
    	else 
    	{
    		/*** paint the text disabled ***/
    		g.setColor(b.getBackground().brighter());
    		//SwingUtilities2 *��Ҫֱ�ӵ��ø��ࣨ��Ϊ����sunδ����api��1.5����1.6���Ժ�������ڲ�ͬ�İ��ĳ��������ʧҲ˵���ã�
    		MySwingUtilities2.drawStringUnderlineCharAt(c, g,text, mnemonicIndex,
    				textRect.x, textRect.y + fm.getAscent());
    		g.setColor(b.getBackground().darker());
    		//SwingUtilities2 *��Ҫֱ�ӵ��ø��ࣨ��Ϊ����sunδ����api��1.5����1.6���Ժ�������ڲ�ͬ�İ��ĳ��������ʧҲ˵���ã�
    		MySwingUtilities2.drawStringUnderlineCharAt(c, g,text, mnemonicIndex,
    				textRect.x - 1, textRect.y + fm.getAscent() - 1);
    	}
    }
    
    // Method signature defined here overriden in subclasses. 
    // Perhaps this class should be abstract?
    /* (non-Javadoc)
     * @see javax.swing.plaf.basic.BasicButtonUI#paintFocus(java.awt.Graphics, javax.swing.AbstractButton, java.awt.Rectangle, java.awt.Rectangle, java.awt.Rectangle)
     */
    protected void paintFocus(Graphics g, AbstractButton b,
    		Rectangle viewRect, Rectangle textRect, Rectangle iconRect)
    {
    	Rectangle bound = b.getVisibleRect();
    	//��������Ҫ�Ƶ�λ�ã���ǰʵ����������3�����أ��뵱ǰ��ť������ϣ�
    	final int delta = 3;
    	int x = bound.x + delta, y = bound.y + delta
    		, w = bound.width - delta * 2, h = bound.height - delta * 2;
    	
    	//���ƽ������߿�
    	g.setColor(UIManager.getColor("ToggleButton.focusLine"));//*~ ����Jack Jiang�Զ��������Ŷ
    	BEUtils.drawDashedRect(g, x, y, w, h, 17, 17, 2, 2);
    	//�ٻ��ƽ������߿�����������Ӱ���Ա��γ������
    	g.setColor(UIManager.getColor("ToggleButton.focusLineHilight"));//*~ ����Jack Jiang�Զ��������Ŷ
    	BEUtils.drawDashedRect(g, x + 1, y + 1, w, h, 17, 17, 2, 2);
    }
}

