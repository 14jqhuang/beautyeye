/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BEButtonUI.java at 2012-9-24 17:22:34, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch3_button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.InsetsUIResource;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.text.JTextComponent;

import org.jb2011.lnf.beautyeye.utils.BEUtils;

// TODO: Auto-generated Javadoc
/**
 * JButton��UIʵ����.
 * 
 * @author Jack Jiang(jb2011@163.com)
 * @version 1.0
 */
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� Start
//�����ʵ�ֲο���JDK1.6_u18��WindowsButtonUI��Դ��.
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� END
public class BEButtonUI extends BasicButtonUI
{
	
	/** The Constant xWindowsButtonUI. */
	private final static BEButtonUI xWindowsButtonUI = new BEButtonUI();
	
	/** The nomal color. */
	private NormalColor nomalColor = NormalColor.normal;
	
	/**
	 * ��ť��ɫ����ö�����͡�.
	 */
	public enum NormalColor
	{
		
		/** ��ͨ��ɫ��ť. */
		normal,
		
		/** ��ɫ��ť. */
		green,
		
		/** ��ɫ��ť. */
		red,
		
		/** ǳ��ɫ��ť. */
		lightBlue,
		
		/** ����ɫ��ť. */
		blue
	}
	
	/**
	 * Sets the normal color.
	 *
	 * @param nc the nc
	 * @return the bE button ui
	 */
	public BEButtonUI setNormalColor(NormalColor nc)
	{
		this.nomalColor = nc;
		return this;
	}

	/** The dashed rect gap x. */
	protected int dashedRectGapX;
	
	/** The dashed rect gap y. */
	protected int dashedRectGapY;
	
	/** The dashed rect gap width. */
	protected int dashedRectGapWidth;
	
	/** The dashed rect gap height. */
	protected int dashedRectGapHeight;

	/** The focus color. */
	protected Color focusColor;

	/** The defaults_initialized. */
	private boolean defaults_initialized = false;


	// ********************************
	//          Create PLAF
	// ********************************
	/**
	 * Creates the ui.
	 *
	 * @param c the c
	 * @return the component ui
	 */
	public static ComponentUI createUI(JComponent c){
		return xWindowsButtonUI;
	}


	// ********************************
	//            Defaults
	// ********************************
	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicButtonUI#installDefaults(javax.swing.AbstractButton)
	 */
	protected void installDefaults(AbstractButton b) {
		super.installDefaults(b);
		b.setOpaque(false);
		
		if(!defaults_initialized) {
			String pp = getPropertyPrefix();
			dashedRectGapX = UIManager.getInt(pp + "dashedRectGapX");
			dashedRectGapY = UIManager.getInt(pp + "dashedRectGapY");
			dashedRectGapWidth = UIManager.getInt(pp + "dashedRectGapWidth");
			dashedRectGapHeight = UIManager.getInt(pp + "dashedRectGapHeight");
			focusColor = UIManager.getColor(pp + "focus");
			defaults_initialized = true;
		}

//		BEXPStyle xp = BEXPStyle.getXP();
//		if (xp != null) 
		{
			b.setBorder(new XPEmptyBorder(new Insets(3,3,3,3)));//xp.getBorder(b, getXPButtonType(b)));
			LookAndFeel.installProperty(b, "rolloverEnabled", Boolean.TRUE);
		}
	}

	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicButtonUI#uninstallDefaults(javax.swing.AbstractButton)
	 */
	protected void uninstallDefaults(AbstractButton b) {
		super.uninstallDefaults(b);
		defaults_initialized = false;
	}

	/**
	 * Gets the focus color.
	 *
	 * @return the focus color
	 */
	protected Color getFocusColor() {
		return focusColor;
	}

	// ********************************
	//         Paint Methods
	// ********************************

//	/**
//	 * Overridden method to render the text without the mnemonic
//	 */
//	protected void paintText(Graphics g, AbstractButton b, Rectangle textRect, String text) 
//	{
//		WindowsGraphicsUtils.paintText(g, b, textRect, text, getTextShiftOffset());
//	} 

	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicButtonUI#paintFocus(java.awt.Graphics, javax.swing.AbstractButton, java.awt.Rectangle, java.awt.Rectangle, java.awt.Rectangle)
	 */
	protected void paintFocus(Graphics g, AbstractButton b, Rectangle viewRect, Rectangle textRect, Rectangle iconRect){
		if (b.getParent() instanceof JToolBar) {
			// Windows doesn't draw the focus rect for buttons in a toolbar.
			return;
		}

		//** ��jb2011ע�͵���Ŀ����ʹ�����κ�����¶�����\��ý��������߿�
//		if (NLXPStyle.getXP() != null) {
//			return;
//		}

		// focus painted same color as text on Basic??
		int width = b.getWidth();
		int height = b.getHeight();
		g.setColor(getFocusColor());
		
		//** modified by jb2011���������߷����ĳɿ����������߲����ķ�����������Ϊ2����ÿ�һ��
//		BasicGraphicsUtils.drawDashedRect(g, dashedRectGapX, dashedRectGapY,
//				width - dashedRectGapWidth, height - dashedRectGapHeight);
		// �������߿�
		BEUtils.drawDashedRect(g, dashedRectGapX, dashedRectGapY,
				width - dashedRectGapWidth, height - dashedRectGapHeight);
		// �������߿�İ�͸����ɫ������Ӱ����͸�����ô������������ֵ�Ч���ȴ���Ҫ������͵Ķࣩ
		g.setColor(new Color(255,255,255,50));
		// ������Ӱ����������ƫ��һ������ʵ�ֵ�
		BEUtils.drawDashedRect(g, dashedRectGapX+1, dashedRectGapY+1,
				width - dashedRectGapWidth, height - dashedRectGapHeight);
	}

//	protected void paintButtonPressed(Graphics g, AbstractButton b)
//	{
//		setTextShiftOffset();
//	}

	// ********************************
	//          Layout Methods
	// ********************************
	/* (non-Javadoc)
 * @see javax.swing.plaf.basic.BasicButtonUI#getPreferredSize(javax.swing.JComponent)
 */
public Dimension getPreferredSize(JComponent c) {
		Dimension d = super.getPreferredSize(c);

		/* Ensure that the width and height of the button is odd,
		 * to allow for the focus line if focus is painted
		 */
		AbstractButton b = (AbstractButton)c;
		if (d != null && b.isFocusPainted()) {
			if(d.width % 2 == 0) { d.width += 1; }
			if(d.height % 2 == 0) { d.height += 1; }
		}
		return d;
	}


	/* These rectangles/insets are allocated once for all 
	 * ButtonUI.paint() calls.  Re-using rectangles rather than 
	 * allocating them in each paint call substantially reduced the time
	 * it took paint to run.  Obviously, this method can't be re-entered.
	 */
//	private static Rectangle viewRect = new Rectangle();

	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicButtonUI#paint(java.awt.Graphics, javax.swing.JComponent)
	 */
	public void paint(Graphics g, JComponent c) {
//		if (NLXPStyle.getXP() != null) 
		{
			paintXPButtonBackground(nomalColor,g, c);
		}
		super.paint(g, c);
	}

//	static Part getXPButtonType(AbstractButton b) { 
//		boolean toolbar = (b.getParent() instanceof JToolBar);
//		return toolbar ? Part.TP_BUTTON : Part.BP_PUSHBUTTON; 
//	}

	/**
 * Paint xp button background.
 *
 * @param nomalColor the nomal color
 * @param g the g
 * @param c the c
 */
public static void paintXPButtonBackground(NormalColor nomalColor,Graphics g, JComponent c)
	{
		AbstractButton b = (AbstractButton) c;

//		BEXPStyle xp = BEXPStyle.getXP();

		boolean toolbar = (b.getParent() instanceof JToolBar);
//		Part part = getXPButtonType(b);

		if (b.isContentAreaFilled())// && xp != null)
		{
			ButtonModel model = b.getModel();
//			Skin skin = xp.getSkin(b, part);

			// normal, rollover/activated/focus, pressed, disabled, default
//			State state = State.NORMAL;
			if (toolbar)
			{
//				if (model.isArmed() && model.isPressed())
//				{
//					state = State.PRESSED;
//				}
//				else if (!model.isEnabled())
//				{
//					state = State.DISABLED;
//				}
//				else if (model.isSelected() && model.isRollover())
//				{
//					state = State.HOTCHECKED;
//				}
//				else if (model.isSelected())
//				{
//					state = State.CHECKED;
//				}
//				else if (model.isRollover())
//				{
//					state = State.HOT;
//				}
			}
			else
			{
//				if (model.isArmed() && model.isPressed() || model.isSelected())
//				{
//					state = State.PRESSED;
//				}
//				else if (!model.isEnabled())
//				{
//					state = State.DISABLED;
//				}
//				else if (model.isRollover() || model.isPressed())
//				{
//					state = State.HOT;
//				}
//				else if (b instanceof JButton
//						&& ((JButton) b).isDefaultButton())
//				{
//					state = State.DEFAULTED;
//				}
//				else if (c.hasFocus())
//				{
//					state = State.HOT;
//				}
			}
			Dimension d = c.getSize();
			int dx = 0;
			int dy = 0;
			int dw = d.width;
			int dh = d.height;

			Border border = c.getBorder();
			Insets insets;
			if (border != null)
			{
				// Note: The border may be compound, containing an outer
				// opaque border (supplied by the application), plus an
				// inner transparent margin border. We want to size the
				// background to fill the transparent part, but stay
				// inside the opaque part.
				insets = BEButtonUI.getOpaqueInsets(border, c);
			}
			else
			{
				insets = c.getInsets();
			}
			if (insets != null)
			{
				dx += insets.left;
				dy += insets.top;
				dw -= (insets.left + insets.right);
				dh -= (insets.top + insets.bottom);
			}
			
			/*************************** ���´�����jb2011������WindowsButtonUI START ********************/
			if(toolbar)
			{
				if(model.isRollover()||model.isPressed())
				{
					__Icon9Factory__.getInstance().getToggleButtonIcon_RoverGreen().draw((Graphics2D)g, dx, dy, dw, dh);
				}
				else if(model.isSelected())//state == State.CHECKED)//||state == State.HOTCHECKED)
				{
					__Icon9Factory__.getInstance().getToggleButtonIcon_CheckedGreen().draw((Graphics2D)g, dx, dy, dw, dh);
				}
				else
				{
					//TODO ����״̬�µİ�ť������ʽ��Ҫ���ƣ�Ҫ��Ȼ������̫Ӳ��
//					skin.paintSkin(g, dx, dy, dw, dh, state);
				}
			}
			else
			{
				try
				{
					//TODO ����״̬�µİ�ť������ʽ��Ҫ���ƣ�Ҫ��Ȼ������̫Ӳ��
					
//					if(state == State.PRESSED)
					if(model.isArmed() && model.isPressed() || model.isSelected())
						__Icon9Factory__.getInstance().getButtonIcon_PressedOrange().draw((Graphics2D)g, dx, dy, dw, dh);
//					else if(state == State.DISABLED)
					else if (!model.isEnabled())
						__Icon9Factory__.getInstance().getButtonIcon_DisableGray().draw((Graphics2D)g, dx, dy, dw, dh);
					else if(model.isRollover())
						__Icon9Factory__.getInstance().getButtonIcon_rover().draw((Graphics2D)g, dx, dy, dw, dh);
					else
					{
						if(nomalColor==NormalColor.green)
						{
							__Icon9Factory__.getInstance().getButtonIcon_NormalGreen().draw((Graphics2D)g, dx, dy, dw, dh);
						}
						else if(nomalColor==NormalColor.red)
						{
							__Icon9Factory__.getInstance().getButtonIcon_NormalRed().draw((Graphics2D)g, dx, dy, dw, dh);
						}
						else if(nomalColor==NormalColor.blue)
						{
							__Icon9Factory__.getInstance().getButtonIcon_NormalBlue().draw((Graphics2D)g, dx, dy, dw, dh);
						}
						else if(nomalColor==NormalColor.lightBlue)
						{
							__Icon9Factory__.getInstance().getButtonIcon_NormalLightBlue().draw((Graphics2D)g, dx, dy, dw, dh);
						}
//						else if(nomalColor==NormalColor.red)
//						{
//							//��ɫ��ť����״̬ʱΪ���õ�ͻ������״̬������Ұ�ť
//							if(state == State.DISABLED)
//								__Icon9Factory__.getInstance().getButtonIcon_NormalGray().draw((Graphics2D)g, dx, dy, dw, dh);
//							else
//								__Icon9Factory__.getInstance().getButtonIcon_NormalRed().draw((Graphics2D)g, dx, dy, dw, dh);
//						}
						else
							__Icon9Factory__.getInstance().getButtonIcon_NormalGray().draw((Graphics2D)g, dx, dy, dw, dh);
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			/*************************** ���´�����JS������WindowsButtonUI END ********************/
		}
	}

	/**
	 * returns - b.getBorderInsets(c) if border is opaque
	 * - null if border is completely non-opaque
	 * - somewhere inbetween if border is compound and
	 * outside border is opaque and inside isn't
	 *
	 * @param b the b
	 * @param c the c
	 * @return the opaque insets
	 */
	private static Insets getOpaqueInsets(Border b, Component c) {
		if (b == null) {
			return null;
		}
		if (b.isBorderOpaque()) {
			return b.getBorderInsets(c);
		} else if (b instanceof CompoundBorder) {
			CompoundBorder cb = (CompoundBorder)b;
			Insets iOut = getOpaqueInsets(cb.getOutsideBorder(), c);
			if (iOut != null && iOut.equals(cb.getOutsideBorder().getBorderInsets(c))) {
				// Outside border is opaque, keep looking
				Insets iIn = getOpaqueInsets(cb.getInsideBorder(), c);
				if (iIn == null) {
					// Inside is non-opaque, use outside insets
					return iOut;
				} else {
					// Found non-opaque somewhere in the inside (which is
					// also compound).
					return new Insets(iOut.top + iIn.top, iOut.left + iIn.left,
							iOut.bottom + iIn.bottom, iOut.right + iIn.right);
				}
			} else {
				// Outside is either all non-opaque or has non-opaque
				// border inside another compound border
				return iOut;
			}
		} else {
			return null;
		}
	}
	
	//copy from XPStyle.XPEmptyBorder ����û���޸�
	/**
	 * The Class XPEmptyBorder.
	 */
	public static class XPEmptyBorder extends EmptyBorder implements UIResource 
	{
        
        /**
         * Instantiates a new xP empty border.
         *
         * @param m the m
         */
        public XPEmptyBorder(Insets m) {
            super(m.top+2, m.left+2, m.bottom+2, m.right+2);
        }

        /* (non-Javadoc)
         * @see javax.swing.border.AbstractBorder#getBorderInsets(java.awt.Component)
         */
        public Insets getBorderInsets(Component c)       {
            return getBorderInsets(c, getBorderInsets());
        }

        /* (non-Javadoc)
         * @see javax.swing.border.EmptyBorder#getBorderInsets(java.awt.Component, java.awt.Insets)
         */
        public Insets getBorderInsets(Component c, Insets insets)       {
            insets = super.getBorderInsets(c, insets);
                
            Insets margin = null;
            if (c instanceof AbstractButton) {
                Insets m = ((AbstractButton)c).getMargin();
                // if this is a toolbar button then ignore getMargin()
                // and subtract the padding added by the constructor
                if(c.getParent() instanceof JToolBar 
                   && ! (c instanceof JRadioButton)
                   && ! (c instanceof JCheckBox)
                   && m instanceof InsetsUIResource) {
                    insets.top -= 2;
                    insets.left -= 2;
                    insets.bottom -= 2;
                    insets.right -= 2;
                } else {
                    margin = m;
                }
            } else if (c instanceof JToolBar) {
                margin = ((JToolBar)c).getMargin();
            } else if (c instanceof JTextComponent) {
                margin = ((JTextComponent)c).getMargin();
            }
            if (margin != null) {
                insets.top    = margin.top + 2;
                insets.left   = margin.left + 2;
                insets.bottom = margin.bottom + 2;
                insets.right  = margin.right + 2;
            }
            return insets;
        }
    }
}

