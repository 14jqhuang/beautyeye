/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BETableHeaderUI.java at 2012-9-24 17:22:40, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch5_table;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.SortOrder;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicTableHeaderUI;
import javax.swing.table.TableCellRenderer;

import org.jb2011.lnf.beautyeye.utils.ReflectHelper;

import sun.swing.table.DefaultTableCellHeaderRenderer;

// TODO: Auto-generated Javadoc
/**
 * ���ͷUIʵ���ࡣ
 * <p>
 * �������ֻ������JDK1.6�����ϰ汾����JDK1.5�����°汾û�����ݱ����еĺܴ�һ���ֹؼ����롣
 * 
 * @author Jack Jiang(jb2011@163.com), 2011-03-28
 * @see com.sun.java.swing.plaf.windows.WindowsTableHeaderUI
 */
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� Start
//����ʵ�ֲο���JDK1.6_u18�е�WindowsTableHeaderUIԴ�룬�����г��˼������޸ģ�����Դ��������䣡
//������������JDK�Դ�src�У��ƺ����벻�����µģ�����һ����̫���Ե�bug��
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� END
public class BETableHeaderUI extends BasicTableHeaderUI 
{
	
	/** The original header renderer. */
	private TableCellRenderer originalHeaderRenderer;

	/**
	 * Creates the ui.
	 *
	 * @param h the h
	 * @return the component ui
	 */
	public static ComponentUI createUI(JComponent h) 
	{
		return new BETableHeaderUI();
	}

	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicTableHeaderUI#installUI(javax.swing.JComponent)
	 */
	public void installUI(JComponent c) 
	{
		super.installUI(c);
//		if (BEXPStyle.getXP() != null) 
		{
			originalHeaderRenderer = header.getDefaultRenderer();
			if (originalHeaderRenderer instanceof UIResource) 
			{
				header.setDefaultRenderer(new XPDefaultRenderer());
			}
		}
	}

	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicTableHeaderUI#uninstallUI(javax.swing.JComponent)
	 */
	public void uninstallUI(JComponent c) 
	{
		if (header.getDefaultRenderer() instanceof XPDefaultRenderer) 
		{
			header.setDefaultRenderer(originalHeaderRenderer);
		}
		super.uninstallUI(c);
	}

//	@Override
	/* (non-Javadoc)
 * @see javax.swing.plaf.basic.BasicTableHeaderUI#rolloverColumnUpdated(int, int)
 */
protected void rolloverColumnUpdated(int oldColumn, int newColumn) 
	{
//		if (BEXPStyle.getXP() != null) 
		{
			header.repaint(header.getHeaderRect(oldColumn)); 
			header.repaint(header.getHeaderRect(newColumn));
		}
	}
	
	//����ͷUi���ݣ���������ȡ������Ϊ����ELineNumTable��Ҳ�����õ������ǽ������Զ���Uiͷʵ�֣�
	/**
	 * Paint head cell.
	 *
	 * @param g the g
	 * @param headCellSize the head cell size
	 */
	public static void paintHeadCell(Graphics g, Dimension headCellSize)
	{
		int w = headCellSize.width,h = headCellSize.height-1;
		
//		Graphics2D g2 = (Graphics2D)g;
//		//���䱳��
//		Paint oldp= g2.getPaint();
//		GradientPaint gp = new GradientPaint(0, 0
//				, new Color(250,250,250)
//				, 0, h,new Color(241,241,241));
//		g2.setPaint(gp);
//		g.fillRect(0, 0, w, h);
//		//��������1/2���ǽ�����䣨Ϊ�˲�������Ч����
//		g2.setPaint(oldp);
//		
//		//����������ͻ�������
//		g.setColor(new Color(215,215,215));
//		g.drawLine(0, 0, w, 0);
//		g.setColor(new Color(249,250,249));
//		g.drawLine(0, h-1, w, h-1);
//		g.setColor(new Color(209,209,209));
//		g.drawLine(0, h, w, h);
		
		__Icon9Factory__.getInstance().getTableHeaderCellBg1()
			.draw((Graphics2D)g, 0, 0, w, h);//��ͷ����
		__Icon9Factory__.getInstance().getTableHeaderCellSeparator1()
			.draw((Graphics2D)g, w - 2, 0, 4, h-1);//��ͷ�ұߵķָ���,h-1��Ϊ���÷ָ���������һ�����أ��ÿ�һ��
	}

	/**
	 * The Class XPDefaultRenderer.
	 */
	private class XPDefaultRenderer extends DefaultTableCellHeaderRenderer 
	{
//		Skin skin;
//		boolean isSelected, hasFocus, hasRollover;
//		int column;

		/**
 * Instantiates a new xP default renderer.
 */
XPDefaultRenderer() 
		{
			setHorizontalAlignment(LEADING);
			setVerticalAlignment(CENTER);
		}

		/* (non-Javadoc)
		 * @see sun.swing.table.DefaultTableCellHeaderRenderer#getTableCellRendererComponent(javax.swing.JTable, java.lang.Object, boolean, boolean, int, int)
		 */
		public Component getTableCellRendererComponent(JTable table, Object value,
				boolean isSelected, boolean hasFocus,int row, int column)
		{
			
			//** �������������Ĭ������render�������ɫ�����ã����Լ�ʹ�����湹�췽�����������ѵ�����ȶ�����Ч
			//���ڴ˷�������֮�������û�������
			super.getTableCellRendererComponent(table, value, isSelected,hasFocus, row, column);
			
//			this.isSelected = isSelected;
//			this.hasFocus = hasFocus;
//			this.column = column;
//			this.hasRollover = (column == getRolloverColumn());
//			if (skin == null) 
//			{
//				skin = BEXPStyle.getXP().getSkin(header, Part.HP_HEADERITEM); 
//			}
			Insets margins = UIManager.getInsets("TableHeader.cellMargin");//skin.getContentMargin();
			Border border = null;
			int contentTop = 0;
			int contentLeft = 0;
			int contentBottom = 0;
			int contentRight = 0;
			if (margins != null) 
			{
				contentTop = margins.top;
				contentLeft = margins.left;
				contentBottom = margins.bottom;
				contentRight = margins.right;
			}
			/* idk:
			 * Both on Vista and XP there is some offset to the
			 * HP_HEADERITEM content. It does not seem to come from 
			 * Prop.CONTENTMARGINS. Do not know where it is defined.
			 * using some hardcoded values.
			 */
			contentLeft += 5;
			contentBottom += 4;
			contentRight += 5;
			
			/* On Vista sortIcon is painted above the header's text.
			 * We use border to paint it.
			 */
			Icon sortIcon;
			//ԭUI����
//			if (ZCWindowsLookAndFeel.isOnVista()&& 
//					((sortIcon = getIcon()) instanceof javax.swing.plaf.UIResource
//							|| sortIcon == null)) 
			//�ִ��룺����ԭJavaԴ��������WindowsLookAndFeel.isOnVista()==trueʱ�Ż��������Ĵ���
			//�߼��ǲ��Եģ�Ҳ����ֻҪ����vista���Ͳ����ܻ�������ͼ�꣬�������Jdk�Դ���JavaԴ����ܿ��ܲ������µģ�
			if (
					//ȥ��vista�ж�
//					ZCWindowsLookAndFeel.isOnVista() 
//					&& 
					((sortIcon = getIcon()) instanceof javax.swing.plaf.UIResource|| sortIcon == null)) 
				
			{
				//ԭUI���룺ԭ������Ϊ�˷�vista��ʽ����ͷ�߶Ⱥܸߣ���ע�͵���
//				contentTop += 1;
				
				setIcon(null);
				sortIcon = null;
				
				//** BUG Fixed��2012-09-13 by Jsck Jiang
				//** ��BUG����ԭ�������ڵ�1.6�治����getColumnSortOrder������Ϊ�˼��ݣ�Ŀǰ�÷����������
				//** �������ǰ���е�jre���ڸ÷��������֮���������֮������޶ȱ�֤BeautyEye������
//				SortOrder sortOrder = getColumnSortOrder(table, column);				
				SortOrder sortOrder = (SortOrder)ReflectHelper.invokeMethod(DefaultTableCellHeaderRenderer.class
							, this, "getColumnSortOrder"
							, new Class[]{JTable.class, int.class}, new Object[]{table, column} );
				if (sortOrder != null) 
				{
					switch (sortOrder) 
					{
						case ASCENDING: 
							sortIcon =
								UIManager.getIcon("Table.ascendingSortIcon");
							break;
						case DESCENDING:
							sortIcon =
								UIManager.getIcon("Table.descendingSortIcon");
							break;
					}
				}
				
				if (sortIcon != null) 
				{
					//ԭUI���룺ԭ������Ϊ�˷�vista��ʽ����ͷ�߶Ⱥܸߣ���ע�͵���
//					contentBottom = sortIcon.getIconHeight();
					border = new IconBorder(sortIcon, contentTop, contentLeft, 
							contentBottom, contentRight);
				} 
				else 
				{
					sortIcon = UIManager.getIcon("Table.ascendingSortIcon");
					int sortIconHeight = (sortIcon != null) ? sortIcon.getIconHeight() : 0;
					if (sortIconHeight != 0)
					{
						//ԭUI���룺ԭ������Ϊ�˷�vista��ʽ����ͷ�߶Ⱥܸߣ���ע�͵���
//						contentBottom = sortIconHeight;
					}
					border = new EmptyBorder(
						//ԭUI���룺ԭ������Ϊ�˷�vista��ʽ����ͷ�߶Ⱥܸߣ���ע�͵���
//						sortIconHeight + contentTop, contentLeft, contentBottom, contentRight);
//						/�ִ��룺border��top��Ҫ��ô��ԭ������Ϊ�˷�vista�ģ�
						contentTop, contentLeft, contentBottom, contentRight);
				}
			} 
			else 
			{
				contentTop += 3;
				border = new EmptyBorder(contentTop, contentLeft, contentBottom, contentRight);
			}
			setBorder(border);
			
			
			//** jb2011����������ɫ�ͼӴ�
//			this.setForeground(ColorHelper.DARK_GRAY1_LIKE_APPLE);
//			this.setFont(this.getFont().deriveFont(Font.BOLD));
			
			return this;
		}
		
		/* (non-Javadoc)
		 * @see javax.swing.JComponent#paint(java.awt.Graphics)
		 */
		public void paint(Graphics g) 
		{
			Dimension size = getSize();
//			State state = State.NORMAL;
//			TableColumn draggedColumn = header.getDraggedColumn();
//			if (draggedColumn != null && 
//					column == SwingUtilities2.convertColumnIndexToView(
//							header.getColumnModel(), 
//							draggedColumn.getModelIndex())) 
//			{
//				state = State.PRESSED;
//			} 
//			else if (isSelected || hasFocus || hasRollover) 
//			{
//				state = State.HOT;
//			} 
			/* on Vista there are more states for sorted columns */
//			if (WinUtils.isOnVista()) 
//			{
//				SortOrder sortOrder = getColumnSortOrder(header.getTable(), column);
//				if (sortOrder != null) 
//				{
//					switch(sortOrder) 
//					{
//						case ASCENDING:
//							/* falls through */
//						case DESCENDING:
//							switch (state)
//							{
//								case NORMAL:
//									state = State.SORTEDNORMAL;
//									break;
//								case PRESSED:
//									state = State.SORTEDPRESSED;
//									break;
//								case HOT:
//									state = State.SORTEDHOT;
//									break;
//								default:
//									/* do nothing */
//							}
//						default : 
//							/* do nothing */
//					}
//				}
//			}
			
			paintHeadCell(g, size);
//			skin.paintSkin(g, 0, 0, size.width-1, size.height-1, state);
			
			super.paint(g);
		}
	}
	
	//* ��jb2011 �޸���WindowsTableHeaderUI���ͬ����.
	/**
	 * A border with an Icon at the middle of the top side.
	 * Outer insets can be provided for this border.
	 */
	private static class IconBorder implements Border, UIResource
	{
		
		/** The icon. */
		private final Icon icon;
		
		/** The top. */
		private final int top;
		
		/** The left. */
		private final int left;
		
		/** The bottom. */
		private final int bottom;
		
		/** The right. */
		private final int right;
		
		/**
		 * Creates this border;.
		 *
		 * @param icon - icon to paint for this border
		 * @param top the top
		 * @param left the left
		 * @param bottom the bottom
		 * @param right the right
		 */
		public IconBorder(Icon icon, int top, int left, int bottom, int right) 
		{
			this.icon = icon;
			this.top = top;
			this.left = left;
			this.bottom = bottom;
			this.right = right;
		}
		
		/* (non-Javadoc)
		 * @see javax.swing.border.Border#getBorderInsets(java.awt.Component)
		 */
		public Insets getBorderInsets(Component c) 
		{
			//ԭUI���룺ԭ������Ϊ�˷�vista��ʽ����ͷ�߶Ⱥܸߣ���ע�͵���
//			return new Insets(icon.getIconHeight() + top, left, bottom, right);
			//�ִ���
			return new Insets(top, left, bottom, right);
		}
		
		/* (non-Javadoc)
		 * @see javax.swing.border.Border#isBorderOpaque()
		 */
		public boolean isBorderOpaque() 
		{
			return false;
		}
		
		/* (non-Javadoc)
		 * @see javax.swing.border.Border#paintBorder(java.awt.Component, java.awt.Graphics, int, int, int, int)
		 */
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) 
		{
			icon.paintIcon(c, g, 
					
			//ԭUI���룺ԭ������Ϊ�˷�vista��ʽ����ͷ�߶Ⱥܸ���ͼ���λ���Ƿ���top���룬��ע�͵���
//			x + left + (width - left - right - icon.getIconWidth()) / 2, y + top);
					
			//�ִ��룺ͼ������ұ���������2�����ص�λ�ã��ÿ�һ�㣩
			x + left + width - right - icon.getIconWidth()-2, y );
		}
	}
}

