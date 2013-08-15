/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BETreeUI.java at 2012-9-24 17:22:16, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch16_tree;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

// TODO: Auto-generated Javadoc
/**
 * JTree��UIʵ���ࡣ.
 *
 * @author Jack Jiang(jb2011@163.com)
 * @version 1.0
 */
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� Start
//�����ʵ�ֲο���WindowsTreeUI
//Ŀǰ����������δ��UI�����������޸ģ���Tree��UI�޸���Ҫ�ǻ���UIManager��ӦTree
//���Ե����ã�Ŀǰ�Ѿ��㹻�ﵽԤ��Ч�������б�Ҫ�ɿ��ű����еĴ�����������޸ġ�
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� END
public class BETreeUI extends BasicTreeUI 
{
	
	/**
	 * Creates the ui.
	 *
	 * @param c the c
	 * @return the component ui
	 */
	public static ComponentUI createUI( JComponent c )
	{
		return new BETreeUI();
	}
	
//	//copy from BasicTreeUI and modified by jb2011
//	// This method is slow -- revisit when Java2D is ready.
//	// assumes x1 <= x2
//	/**
//	 * ����ˮƽ�������.
//   * Jack Jiang��д�˷�����Ŀ���Ǽӵ������ߵĲ���ֵ.
//	 */
//	protected void drawDashedHorizontalLine(Graphics g, int y, int x1, int x2)
//	{
//		// Drawing only even coordinates helps join line segments so they
//		// appear as one line.  This can be defeated by translating the
//		// Graphics by an odd amount.
////		x1 += (x1 % 2);
//		//modified by jb2011
//		x1 += (x1 % 6);
//
////		for (int x = x1; x <= x2; x+=2) 
////		{
////			g.drawLine(x, y, x, y);
////		}
//		//modified by jb2011
//		for (int x = x1; x <= x2; x+=6) 
//		{
//			g.drawLine(x, y, x, y);
//		}
//	}
//	
//	//copy from BasicTreeUI and modified by jb2011
//	// This method is slow -- revisit when Java2D is ready.
//	// assumes y1 <= y2
//	/**
//	 * ���ƴ�ֱ�������.
//  * Jack Jiang��д�˷�����Ŀ���Ǽӵ������ߵĲ���ֵ.
//	 */
//	protected void drawDashedVerticalLine(Graphics g, int x, int y1, int y2) 
//	{
//		// Drawing only even coordinates helps join line segments so they
//		// appear as one line.  This can be defeated by translating the
//		// Graphics by an odd amount.
////		y1 += (y1 % 2);
//		//modified by jb2011
//		y1 += (y1 % 6);
//
////		for (int y = y1; y <= y2; y+=2) {
////			g.drawLine(x, y, x, y);
////		}
//		//modified by jb2011
//		for (int y = y1; y <= y2; y+=6) {
//			g.drawLine(x, y, x, y);
//		}
//	}

//	static protected final int HALF_SIZE = 4;
//	static protected final int SIZE = 9;

	//copy from WindowsTreeUI
	/**
 * Returns the default cell renderer that is used to do the
 * stamping of each node.
 *
 * @return the tree cell renderer
 */
	protected TreeCellRenderer createDefaultCellRenderer() {
		return new WindowsTreeCellRenderer();
	}

//	/**
//	 * The minus sign button icon
//	 * <p>
//	 * <strong>Warning:</strong>
//	 * Serialized objects of this class will not be compatible with
//	 * future Swing releases.  The current serialization support is appropriate
//	 * for short term storage or RMI between applications running the same
//	 * version of Swing.  A future release of Swing will provide support for
//	 * long term persistence.
//	 */
//	public static class ExpandedIcon implements Icon, Serializable 
//	{
//
//		static public Icon createExpandedIcon()
//		{
//			return new ExpandedIcon();
//		}
//
////		Skin getSkin(Component c) 
////		{
////			XPStyle xp = XPStyle.getXP();
////			return (xp != null) ? xp.getSkin(c, Part.TVP_GLYPH) : null;
////		}
//
//		public void paintIcon(Component c, Graphics g, int x, int y) 
//		{
////			Skin skin = getSkin(c);
////			if (skin != null) {
////				skin.paintSkin(g, x, y, State.OPENED);
////				return;
////			}
//
//			Color     backgroundColor = c.getBackground();
//
//			if(backgroundColor != null)
//				g.setColor(backgroundColor);
//			else
//				g.setColor(Color.white);
//			
//			g.fillRect(x, y, SIZE-1, SIZE-1);
//			g.setColor(Color.gray);
//			g.drawRect(x, y, SIZE-1, SIZE-1);
//			g.setColor(Color.black);
//			g.drawLine(x + 2, y + HALF_SIZE, x + (SIZE - 3), y + HALF_SIZE);
//		}
//
//		public int getIconWidth() {
////			Skin skin = getSkin(null);
//			return //(skin != null) ? skin.getWidth() : 
//				SIZE;
//		}
//
//		public int getIconHeight()
//		{
////			Skin skin = getSkin(null);
//			return //(skin != null) ? skin.getHeight() : 
//				SIZE;
//		}
//	}

//	/**
//	 * The plus sign button icon
//	 * <p>
//	 * <strong>Warning:</strong>
//	 * Serialized objects of this class will not be compatible with
//	 * future Swing releases.  The current serialization support is appropriate
//	 * for short term storage or RMI between applications running the same
//	 * version of Swing.  A future release of Swing will provide support for
//	 * long term persistence.
//	 */
//	public static class CollapsedIcon extends ExpandedIcon {
//		static public Icon createCollapsedIcon() {
//			return new CollapsedIcon();
//		}
//
//		public void paintIcon(Component c, Graphics g, int x, int y) 
//		{
////			Skin skin = getSkin(c);
////			if (skin != null) 
////			{
////				skin.paintSkin(g, x, y, State.CLOSED);
////			} 
////			else 
//			{
//				super.paintIcon(c, g, x, y);
//				g.drawLine(x + HALF_SIZE, y + 2, x + HALF_SIZE, y + (SIZE - 3));
//			}
//		}
//	}

	//copy from WindowsTreeUI
	/**
 * The Class WindowsTreeCellRenderer.
 */
public class WindowsTreeCellRenderer extends DefaultTreeCellRenderer 
	{//Ŀǰû�ж������ݣ���������render���Ƴ�Բ�ǣ������Ժ���DefaultTreeCellRenderer����
	 //�Ĵ������Ƿ�ѣ����Ѽ̳У�Ҫ�ĵĴ���ǳ��࣬�ɴ�����
//		/**
//		 * Configures the renderer based on the passed in components.
//		 * The value is set from messaging the tree with
//		 * <code>convertValueToText</code>, which ultimately invokes
//		 * <code>toString</code> on <code>value</code>.
//		 * The foreground color is set based on the selection and the icon
//		 * is set based on on leaf and expanded.
//		 */
//		public Component getTreeCellRendererComponent(JTree tree, Object value,
//				boolean sel,
//				boolean expanded,
//				boolean leaf, int row,
//				boolean hasFocus) {
//			super.getTreeCellRendererComponent(tree, value, sel,
//					expanded, leaf, row,
//					hasFocus);
//			// Windows displays the open icon when the tree item selected.
//			if (!tree.isEnabled()) {
//				setEnabled(false);
//				if (leaf) {
//					setDisabledIcon(getLeafIcon());
//				} else if (sel) {
//					setDisabledIcon(getOpenIcon());
//				} else {
//					setDisabledIcon(getClosedIcon());
//				}
//			}
//			else {
//				setEnabled(true);
//				if (leaf) {
//					setIcon(getLeafIcon());
//				} else if (sel) {
//					setIcon(getOpenIcon());
//				} else {
//					setIcon(getClosedIcon());
//				}
//			}
//			return this;
//		}
	}
}
