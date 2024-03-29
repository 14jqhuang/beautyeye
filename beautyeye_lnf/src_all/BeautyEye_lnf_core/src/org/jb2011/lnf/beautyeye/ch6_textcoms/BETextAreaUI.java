/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BETextAreaUI.java at 2012-9-24 17:22:43, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch6_textcoms;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicTextAreaUI;
import javax.swing.text.JTextComponent;

import org.jb2011.lnf.beautyeye.ch6_textcoms.__UI__.BgSwitchable;

import com.android.ninepatch.NinePatch;

// TODO: Auto-generated Javadoc
/**
 * 文本组件JTextArea的UI实现类。.
 *
 * @author Jack Jiang(jb2011@163.com)
 */
public class BETextAreaUI extends BasicTextAreaUI implements BgSwitchable
	,org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.__UseParentPaintSurported//WindowsTextAreaUI
{
	//默认是纯白色背景，因为JTextArea肯定是要放在JScrollPane中的，而ScrollPane也是有边框的
	//如果JTextArea再有边框就很难看了，所以JTextArea在没有获得焦点时就已无边框效果出现会好看很多
	/** The bg. */
	private NinePatch bg = __Icon9Factory__.getInstance().getNullWhiteBg();
	
    /**
     * Creates a UI for a JTextField.
     *
     * @param c the text field
     * @return the UI
     */
    public static ComponentUI createUI(JComponent c) 
    {
    	BETextFieldUI.addOtherListener(c);
//    	c.addMouseListener(new NLLookAndFeel.EditMenu());
        return new BETextAreaUI();
    }
    
    //* 本方法由Jack Jiang于2012-09-07日加入
    /**
     * 是否使用父类的绘制实现方法，true表示是.
     * <p>
     * 因为在BE LNF中，边框和背景等都是使用N9图，没法通过设置背景色和前景
     * 色来控制JTextField的颜色和边框，本方法的目的就是当用户设置了进度条的border或背景色
     * 时告之本实现类不使用BE LNF中默认的N9图填充绘制而改用父类中的方法（父类中的方法
     * 就可以支持颜色的设置罗，只是丑点，但总归是能适应用户的需求场景要求，其实用户完全可以
     * 通过JTextField.setUI(..)方式来自定义UI哦）.
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
    	//先调用父类方法把背景刷新下（比如本UI里使用的大圆角NP图如不先刷新背景则会因上下拉动滚动条
    	//而致4个圆角位置得不到刷新，从而影响视觉效果（边角有前面的遗留），置于透明边角不被透明像素填
    	//充的问题，它有可能是Android的NinePatch技术为了性能做作出的优化——一切全透明像素即意味着不需绘制）
    	super.paintBackground(g);// TODO 出于节约计算资源考生虑，本行代码换成父类中默认填充背景的代码即可
    	
    	//* 如果用户作了自定义颜色设置则使用父类方法来实现绘制，否则BE LNF中没法支持这些设置哦
    	if(!isUseParentPaint())
    	{
	    	//用新的NP图实现真正的背景填充
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
    	//默认是纯白色背景，因为JTextArea肯定是要放在JScrollPane中的，而ScrollPane也是有边框的
    	//如果JTextArea再有边框就很难看了，所以JTextArea在没有获得焦点时就已无边框效果出现会好看很多
    	this.bg = __Icon9Factory__.getInstance().getNullWhiteBg();
    }
    
    /* (non-Javadoc)
     * @see org.jb2011.lnf.beautyeye.ch6_textcoms.__UI__.BgSwitchable#switchBgToFocused()
     */
    public void switchBgToFocused()
    {
    	this.bg = __Icon9Factory__.getInstance().getTextFieldBgFocused();
    }
}

