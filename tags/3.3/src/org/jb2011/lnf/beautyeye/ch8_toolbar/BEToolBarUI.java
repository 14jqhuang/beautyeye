/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BEToolBarUI.java at 2012-9-24 17:22:48, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch8_toolbar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicToolBarUI;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import com.android.ninepatch.NinePatch;

// TODO: Auto-generated Javadoc
/**
 * JToolBar的UI实现类。.
 *
 * @author Jack Jiang(jb2011@163.com)
 */
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 一些说明 Start
//本类实现代码参考了WindowsToolBarUI。
//特别说明：JToolBar比较特殊，加入到JToolBar中的组件，其UI（主要是Border）将由ToolBarUI额
//外控制而不受自身UI控制，比如放入到JToolBar中的JToggleButton，它的border就是受ToolBarUI
//控制，这些JToggleButton将无论如何修改ToolgleButtonUI.border也不会起效。
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 一些说明 END
public class BEToolBarUI extends BasicToolBarUI 
	implements org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.__UseParentPaintSurported
{
	
	/**
	 * Creates the ui.
	 *
	 * @param c the c
	 * @return the component ui
	 */
	public static ComponentUI createUI(JComponent c) {
		return new BEToolBarUI();
	}

	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicToolBarUI#installDefaults()
	 */
	protected void installDefaults() 
	{
//		if (XPStyle.getXP() != null) 
		{
			setRolloverBorders(true);
		}
		super.installDefaults();
	}
	
	//* 本方法由Jack Jiang于2012-09-07日加入
    /**
	 * 是否使用父类的绘制实现方法，true表示是.
	 * <p>
	 * 因为在BE LNF中，工具条背景是使用N9图，没法通过设置背景色和前景
	 * 色来控制工具条的颜色，本方法的目的就是当用户设置了工具条的Background
	 * 时告之本实现类不使用BE LNF中默认的N9图填充绘制而改用父类中的方法（父类中的方法
	 * 就可以支持颜色的设置罗，只是丑点，但总归是能适应用户的需求场景要求，其实用户完全可以
	 * 通过JToolBar.setUI(new MetalToolBar())等方式来自定义UI哦）.
	 *
	 * @return true, if is use parent paint
	 */
    public boolean isUseParentPaint()
    {
    	return toolBar != null 
    		&& (!(toolBar.getBackground() instanceof UIResource));
    }

	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicToolBarUI#createRolloverBorder()
	 */
	protected Border createRolloverBorder() 
	{
		return new EmptyBorder(3, 3, 3, 3);
	}

	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicToolBarUI#createNonRolloverBorder()
	 */
	protected Border createNonRolloverBorder() 
	{
		return new EmptyBorder(3, 3, 3, 3);
	}

	/* (non-Javadoc)
	 * @see javax.swing.plaf.ComponentUI#paint(java.awt.Graphics, javax.swing.JComponent)
	 */
	public void paint(Graphics g, JComponent c) 
	{
		//* 如果用户作了自定义颜色设置则使用父类方法来实现绘制，否则BE LNF中没法支持这些设置哦
    	if(isUseParentPaint())
    	{
    		super.paint(g, c);
    	}
    	else
    	{
    		//* 根据工具条所放在父类的位置不同来决定它的背景该使用哪个图片（图片的差别在于方向不同，主要是边缘阴影的方向）
    		NinePatch np = __Icon9Factory__.getInstance().getToolBarBg_NORTH();
    		//		int orientation = toolBar.getOrientation();
    		Container parent = toolBar.getParent();
    		if(parent != null)
    		{
    			LayoutManager lm = parent.getLayout();
    			if(lm instanceof BorderLayout)
    			{
    				Object cons = ((BorderLayout)lm).getConstraints(toolBar);
    				if(cons != null)
    				{
    					if(cons.equals(BorderLayout.NORTH))
    						np = __Icon9Factory__.getInstance().getToolBarBg_NORTH();
    					else if(cons.equals(BorderLayout.SOUTH))
    						np = __Icon9Factory__.getInstance().getToolBarBg_SOUTH();
    					else if(cons.equals(BorderLayout.WEST))
    						np = __Icon9Factory__.getInstance().getToolBarBg_WEST();
    					else if(cons.equals(BorderLayout.EAST))
    						np = __Icon9Factory__.getInstance().getToolBarBg_EAST();
    				}
    			}
    		}
    		np.draw((Graphics2D)g, 0, 0, c.getWidth(), c.getHeight());
    	}
	}

	/**
	 * Gets the rollover border.
	 *
	 * @param b the b
	 * @return the rollover border
	 * {@inheritDoc}
	 * @since 1.6
	 */
	protected Border getRolloverBorder(AbstractButton b) 
	{
		return new BEButtonUI.XPEmptyBorder(new Insets(3,3,3,3));//xp.getBorder(b, WindowsButtonUI.getXPButtonType(b));
	}
	
	//* 由jb2011修改，只加了一行代码哦
	/**
	 * 重写父类方法实现自已的容器监听器.
	 * 自定义的目的就是为了把加入到其中的组件设置为透明，因为BE LNF的工具栏是有背景，否则
	 * 因有子组件的背景存在而使得整体很难看.
	 *
	 * @return the container listener
	 */
	@Override
	protected ContainerListener createToolBarContListener( )
	{
		return new ToolBarContListenerJb2011();
	}
	//* 由jb2011修改自父类的Handler里的ContainerListener监听代码
    /**
	 * The Class ToolBarContListenerJb2011.
	 */
	protected class ToolBarContListenerJb2011 implements ContainerListener 
    {
    	 //
        // ContainerListener
        //
        /* (non-Javadoc)
 	     * @see java.awt.event.ContainerListener#componentAdded(java.awt.event.ContainerEvent)
 	     */
 	    public void componentAdded(ContainerEvent evt) {
            Component c = evt.getChild();

            if (toolBarFocusListener != null) {
                c.addFocusListener(toolBarFocusListener);
            }

            if (isRolloverBorders()) {
                setBorderToRollover(c);
            } 
            else 
            {
                setBorderToNonRollover(c);
            }
            
            //* 只有它一行是由jb2011加的
            if(c instanceof JComponent)
            	((JComponent)c).setOpaque(false);
        }

        /* (non-Javadoc)
         * @see java.awt.event.ContainerListener#componentRemoved(java.awt.event.ContainerEvent)
         */
        public void componentRemoved(ContainerEvent evt) {
            Component c = evt.getChild();

            if (toolBarFocusListener != null) {
                c.removeFocusListener(toolBarFocusListener);
            }

            // Revert the button border
            setBorderToNormal(c);
        }
    }
    
    //* 本类由Jack Jiang实现，参考了com.sun.java.swing.plaf.windows.WindowsBorders.getToolBarBorder
    /**
     * 工具条边框，左边（或右、或上方）有拖动触点的绘制，方便 告之用户它是可以拖动的
     * A border for the ToolBar. If the ToolBar is floatable then the handle grip is drawn
     * <p>
     * @since 1.4
     */
    public static class ToolBarBorder extends AbstractBorder implements UIResource, SwingConstants
    {
    	
	    /** The shadow. */
	    protected Color shadow;
    	
	    /** The highlight. */
	    protected Color highlight;

    	/**
	     * Instantiates a new tool bar border.
	     *
	     * @param shadow the shadow
	     * @param highlight the highlight
	     */
	    public ToolBarBorder(Color shadow, Color highlight) {
    		this.highlight = highlight;
    		this.shadow = shadow;
    	}

    	/* (non-Javadoc)
	     * @see javax.swing.border.AbstractBorder#paintBorder(java.awt.Component, java.awt.Graphics, int, int, int, int)
	     */
	    public void paintBorder(Component c, Graphics g, int x, int y, 
    			int width, int height) {
    		g.translate(x, y);

    		//需要绘制拖动触点
    		if (((JToolBar)c).isFloatable()) 
    		{
    			boolean vertical = ((JToolBar)c).getOrientation() == VERTICAL;
    			if (!vertical) 
    			{
    				if (c.getComponentOrientation().isLeftToRight()) 
    				{
    					__Icon9Factory__.getInstance().getToolBarBorder_H_FloatTouch()
    					.draw((Graphics2D)g, 4, 0, 3, height);
    				} 
    				else
    				{
    					__Icon9Factory__.getInstance().getToolBarBorder_H_FloatTouch()
    					.draw((Graphics2D)g, width - 4, 0, 3, height);
    				}
    			} 
    			else // Vertical
    			{ 
    				__Icon9Factory__.getInstance().getToolBarBorder_V_FloatTouch()
    				.draw((Graphics2D)g, 0, 4, width, 3);
    			}
    		}

    		g.translate(-x, -y);
    	}

    	/* (non-Javadoc)
	     * @see javax.swing.border.AbstractBorder#getBorderInsets(java.awt.Component)
	     */
	    public Insets getBorderInsets(Component c)      
    	{
    		//** 根据toolbar所放面板的方位不同而设置不一样的border！
    		//tollbar上下设置的空白多一点看起来大气一些（它也将决定toolbar的整体高度和宽度哦）
    		final Insets DEFAILT_IS = new Insets(6, 0, 11, 0);
    		Insets is = DEFAILT_IS;
    		if(c instanceof JToolBar)
    		{
    			Container parent = c.getParent();
    			if(parent != null)
    			{
    				LayoutManager lm = parent.getLayout();
    				if(lm instanceof BorderLayout)
    				{
    					Object cons = ((BorderLayout)lm).getConstraints((JToolBar)c);
    					if(cons != null)
    					{
    						if(cons.equals(BorderLayout.NORTH))
    							is = DEFAILT_IS;// TODO 此insets作一UIManager属性就可以方便以后设置了
    						else if(cons.equals(BorderLayout.SOUTH))
    							is = new Insets(11, 0, 6, 0);// TODO 此insets作一UIManager属性就可以方便以后设置了
    						else if(cons.equals(BorderLayout.WEST))
    							is = new Insets(0, 6, 0, 11);// TODO 此insets作一UIManager属性就可以方便以后设置了
    						else if(cons.equals(BorderLayout.EAST))
    							is = new Insets(0, 11, 0, 6);// TODO 此insets作一UIManager属性就可以方便以后设置了
    					}
    				}
    			}
    		}
    		
    		return getBorderInsets(c, is);//5, 0, 10, 0));//默认是 1,1,1,1
    	}

    	/* (non-Javadoc)
	     * @see javax.swing.border.AbstractBorder#getBorderInsets(java.awt.Component, java.awt.Insets)
	     */
	    public Insets getBorderInsets(Component c, Insets insets) {
//    		insets.top = insets.left = insets.bottom = insets.right = 1;
    		if (((JToolBar)c).isFloatable()) 
    		{
//    			int gripInset = (XPStyle.getXP() != null) ? 12 : 9;
    			int gripInset = 9;
    			if (((JToolBar)c).getOrientation() == HORIZONTAL) 
    			{
    				if (c.getComponentOrientation().isLeftToRight()) 
    				{
    					insets.left = gripInset;
    				} 
    				else 
    				{
    					insets.right = gripInset;
    				}
    			} 
    			else 
    			{
    				insets.top = gripInset;
    			}
    		}
    		return insets;
    	}
    }
}

