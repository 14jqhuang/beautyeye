/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BEInternalFrameTitlePane.java at 2012-9-24 17:20:34, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch10_internalframe;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Icon;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.metal.MetalLookAndFeel;

import org.jb2011.lnf.beautyeye.ch1_titlepane.BETitlePane;
import org.jb2011.lnf.beautyeye.utils.MySwingUtilities2;
import org.jb2011.lnf.beautyeye.winlnfutils.WinUtils;

// TODO: Auto-generated Javadoc
/**
 * �ڲ�����ı�����UIʵ��.
 * 
 * @author Jack Jiang
 */
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� Start
//BeautyEye���ʵ����ȡ����isPalette���������⴦��isPalette�����������
//������н�ʧȥ���壬��ע�⣡
//��ȻbeautyEye�ǲο���MetalLookAndFeel������beautyEyeʹ����Insets�ܴ������߿�
//�������Ҫ��MetalLookAndFeelʵ��Palette���͵�JInternalFrame��Ч������ѿ����ɴ�;���
//WindowsLookAndFeelһ������ȥ���ʲôPalette���ڵ�ǰ��L&F��û���κμ��֡�
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� END
public class BEInternalFrameTitlePane extends BasicInternalFrameTitlePane
{
//	protected boolean isPalette = false;
//	protected Icon paletteCloseIcon;
//	protected int paletteTitleHeight;

	/** The Constant handyEmptyBorder. */
private static final Border handyEmptyBorder = new EmptyBorder(0, 0, 0, 0);

	/**
	 * Key used to lookup Color from UIManager. If this is null,
	 * <code>getWindowTitleBackground</code> is used.
	 */
	private String selectedBackgroundKey;
	/**
	 * Key used to lookup Color from UIManager. If this is null,
	 * <code>getWindowTitleForeground</code> is used.
	 */
	private String selectedForegroundKey;
	/**
	 * Key used to lookup shadow color from UIManager. If this is null,
	 * <code>getPrimaryControlDarkShadow</code> is used.
	 */
	private String selectedShadowKey;
	/**
	 * Boolean indicating the state of the <code>JInternalFrame</code>s
	 * closable property at <code>updateUI</code> time.
	 */
	private boolean wasClosable;

	/** The buttons width. */
	int buttonsWidth = 0;

	/**
	 * Instantiates a new bE internal frame title pane.
	 *
	 * @param f the f
	 */
	public BEInternalFrameTitlePane(JInternalFrame f)
	{
		super(f);
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#addNotify()
	 */
	public void addNotify()
	{
		super.addNotify();
		// This is done here instead of in installDefaults as I was worried
		// that the BasicInternalFrameUI might not be fully initialized, and
		// that if this resets the closable state the BasicInternalFrameUI
		// Listeners that get notified might be in an odd/uninitialized state.
		updateOptionPaneState();
	}

	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicInternalFrameTitlePane#installDefaults()
	 */
	protected void installDefaults()
	{
		super.installDefaults();
		setFont(UIManager.getFont("InternalFrame.titleFont"));
//		paletteTitleHeight = UIManager
//				.getInt("InternalFrame.paletteTitleHeight");
//		paletteCloseIcon = UIManager.getIcon("InternalFrame.paletteCloseIcon");
		wasClosable = frame.isClosable();
		selectedForegroundKey = selectedBackgroundKey = null;
		if (true)
		{
			setOpaque(false);
		}
	}

	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicInternalFrameTitlePane#uninstallDefaults()
	 */
	protected void uninstallDefaults()
	{
		super.uninstallDefaults();
		if (wasClosable != frame.isClosable())
		{
			frame.setClosable(wasClosable);
		}
	}

	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicInternalFrameTitlePane#createButtons()
	 */
	protected void createButtons()
	{
		super.createButtons();

		Boolean paintActive = frame.isSelected() ? Boolean.TRUE : Boolean.FALSE;
		iconButton.putClientProperty("paintActive", paintActive);
		iconButton.setBorder(handyEmptyBorder);

		maxButton.putClientProperty("paintActive", paintActive);
		maxButton.setBorder(handyEmptyBorder);

		closeButton.putClientProperty("paintActive", paintActive);
		closeButton.setBorder(handyEmptyBorder);
		
		// The palette close icon isn't opaque while the regular close icon is.
		// This makes sure palette close buttons have the right background.
		closeButton.setBackground(MetalLookAndFeel.getPrimaryControlShadow());

		if (true)
		{
			iconButton.setContentAreaFilled(false);
			maxButton.setContentAreaFilled(false);
			closeButton.setContentAreaFilled(false);
		}
	}
	
	/**
	 * Override the parent's method to do nothing. Metal frames do not 
	 * have system menus.
	 */
	protected void assembleSystemMenu()
	{
	}

	/**
	 * Override the parent's method to do nothing. Metal frames do not
	 * have system menus.
	 *
	 * @param systemMenu the system menu
	 */
	protected void addSystemMenuItems(JMenu systemMenu)
	{
	}

	/**
	 * Override the parent's method to do nothing. Metal frames do not 
	 * have system menus.
	 */
	protected void showSystemMenu()
	{
	}

	/**
	 * Override the parent's method avoid creating a menu bar. Metal frames
	 * do not have system menus.
	 */
	protected void addSubComponents()
	{
		add(iconButton);
		add(maxButton);
		add(closeButton);
	}

	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicInternalFrameTitlePane#createPropertyChangeListener()
	 */
	protected PropertyChangeListener createPropertyChangeListener()
	{
		return new MetalPropertyChangeHandler();
	}

	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicInternalFrameTitlePane#createLayout()
	 */
	protected LayoutManager createLayout()
	{
		return new XMetalTitlePaneLayout();
	}

	/**
	 * The Class MetalPropertyChangeHandler.
	 */
	class MetalPropertyChangeHandler extends
			BasicInternalFrameTitlePane.PropertyChangeHandler
	{
		
		/* (non-Javadoc)
		 * @see javax.swing.plaf.basic.BasicInternalFrameTitlePane.PropertyChangeHandler#propertyChange(java.beans.PropertyChangeEvent)
		 */
		public void propertyChange(PropertyChangeEvent evt)
		{
			String prop = (String) evt.getPropertyName();
			if (prop.equals(JInternalFrame.IS_SELECTED_PROPERTY))
			{
				Boolean b = (Boolean) evt.getNewValue();
				iconButton.putClientProperty("paintActive", b);
				closeButton.putClientProperty("paintActive", b);
				maxButton.putClientProperty("paintActive", b);
			}
			else if ("JInternalFrame.messageType".equals(prop))
			{
				updateOptionPaneState();
				frame.repaint();
			}
			super.propertyChange(evt);	
		}
	}

	/**
	 * The Class XZCMetalTitlePaneLayout.
	 */
	class XMetalTitlePaneLayout extends TitlePaneLayout
	{
		
		/* (non-Javadoc)
		 * @see javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout#addLayoutComponent(java.lang.String, java.awt.Component)
		 */
		public void addLayoutComponent(String name, Component c)
		{
		}

		/* (non-Javadoc)
		 * @see javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout#removeLayoutComponent(java.awt.Component)
		 */
		public void removeLayoutComponent(Component c)
		{
		}

		/* (non-Javadoc)
		 * @see javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout#preferredLayoutSize(java.awt.Container)
		 */
		public Dimension preferredLayoutSize(Container c)
		{
			return minimumLayoutSize(c);
		}

		/* (non-Javadoc)
		 * @see javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout#minimumLayoutSize(java.awt.Container)
		 */
		public Dimension minimumLayoutSize(Container c)
		{
			// Compute width.
			int width = 30;
			if (frame.isClosable())
			{
				width += 21;
			}
			if (frame.isMaximizable())
			{
				width += 16 + (frame.isClosable() ? 10 : 4);
			}
			if (frame.isIconifiable())
			{
				width += 16 + (frame.isMaximizable() ? 2
						: (frame.isClosable() ? 10 : 4));
			}
			FontMetrics fm = frame.getFontMetrics(getFont());
			String frameTitle = frame.getTitle();
			int title_w = frameTitle != null ? MySwingUtilities2.stringWidth(
					frame, fm, frameTitle) : 0;
			int title_length = frameTitle != null ? frameTitle.length() : 0;

			if (title_length > 2)
			{
				int subtitle_w = MySwingUtilities2.stringWidth(frame, fm, frame
						.getTitle().substring(0, 2)
						+ "...");
				width += (title_w < subtitle_w) ? title_w : subtitle_w;
			}
			else
			{
				width += title_w;
			}

			// Compute height.
			int height = 0;
			
//			if (isPalette)
//			{
//				height = paletteTitleHeight;
//			}
//			else
			{
				int fontHeight = fm.getHeight();
				fontHeight += 4;//Ĭ���� +=7 
				Icon icon = frame.getFrameIcon();
				int iconHeight = 0;
				if (icon != null)
				{
					// SystemMenuBar forces the icon to be 16x16 or less.
					iconHeight = Math.min(icon.getIconHeight(), 16);
				}
				iconHeight += 5;
				height = Math.max(fontHeight, iconHeight) + 5;//Ĭ���� +0��modified by jb2011 2012-06-18
			}

			return new Dimension(width, height);
		}

		/* (non-Javadoc)
		 * @see javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout#layoutContainer(java.awt.Container)
		 */
		public void layoutContainer(Container c)
		{
			boolean leftToRight = WinUtils.isLeftToRight(frame);

			int w = getWidth();
			int x = leftToRight ? w : 0;
			int y = 5;//Ĭ����0��modified by jb2011
			int spacing;

			// assumes all buttons have the same dimensions
			// these dimensions include the borders
			int buttonHeight = closeButton.getIcon().getIconHeight();
			int buttonWidth = closeButton.getIcon().getIconWidth();

			if (frame.isClosable())
			{
//				if (isPalette)
//				{
//					spacing = 3;
//					x += leftToRight ? -spacing - (buttonWidth + 2) : spacing;
//					closeButton.setBounds(x, y, buttonWidth + 2,
//							getHeight() - 4);
//					if (!leftToRight)
//						x += (buttonWidth + 2);
//				}
//				else
				{
					spacing = 4;
					x += leftToRight ? -spacing - buttonWidth : spacing;
					closeButton.setBounds(x, y, buttonWidth, buttonHeight);
					if (!leftToRight)
						x += buttonWidth;
				}
			}

			if (frame.isMaximizable())// && !isPalette)
			{
				spacing = frame.isClosable() ? 2 : 4; //10 : 40
				x += leftToRight ? -spacing - buttonWidth : spacing;
				maxButton.setBounds(x, y, buttonWidth, buttonHeight);
				if (!leftToRight)
					x += buttonWidth;
			}

			if (frame.isIconifiable())// && !isPalette)
			{
				spacing = frame.isMaximizable() ? 2 : (frame.isClosable() ? 10
						: 4);
				x += leftToRight ? -spacing - buttonWidth : spacing;
				iconButton.setBounds(x, y, buttonWidth, buttonHeight);
				if (!leftToRight)
					x += buttonWidth;
			}

			buttonsWidth = leftToRight ? w - x : x;
		}
	}

//	public void paintPalette(Graphics g)
//	{
//		boolean leftToRight = WinUtils.isLeftToRight(frame);
//
//		int width = getWidth();
//		int height = getHeight();
//
//		Color background = MetalLookAndFeel.getPrimaryControlShadow();
//		Color darkShadow = MetalLookAndFeel.getPrimaryControlDarkShadow();
//
//		NLTitlePane.paintTitlePane(g, 0, 0, width , height, false
//				, background, darkShadow);
//	}

	/* (non-Javadoc)
 * @see javax.swing.plaf.basic.BasicInternalFrameTitlePane#paintComponent(java.awt.Graphics)
 */
public void paintComponent(Graphics g)
	{
//		if (isPalette)
//		{
//			paintPalette(g);
//			return;
//		}

		boolean leftToRight = WinUtils.isLeftToRight(frame);
		boolean isSelected = frame.isSelected();//! ѡ�������жϷ�ʽ���μ�border���ֵ�ע��

		int width = getWidth();
		int height = getHeight();
		
		Color background = null;
		Color foreground = null;
		Color shadow = null;
		
		if (isSelected)
		{
			if (!true)
			{
				closeButton.setContentAreaFilled(true);
				maxButton.setContentAreaFilled(true);
				iconButton.setContentAreaFilled(true);
			}
			if (selectedBackgroundKey != null)
			{
				background = UIManager.getColor(selectedBackgroundKey);
			}
			if (background == null)
			{
				background = UIManager.getColor("activeCaption");
			}
			if (selectedForegroundKey != null)
			{
				foreground = UIManager.getColor(selectedForegroundKey);
			}
			if (selectedShadowKey != null)
			{
				shadow = UIManager.getColor(selectedShadowKey);
			}
			if (shadow == null)
			{
				shadow = UIManager.getColor("activeCaptionBorder");
			}
			if (foreground == null)
			{
				foreground = UIManager.getColor("activeCaptionText");
			}
		}
		else
		{
			if (!true)
			{
				closeButton.setContentAreaFilled(false);
				maxButton.setContentAreaFilled(false);
				iconButton.setContentAreaFilled(false);
			}
			background = UIManager.getColor("inactiveCaption");
			foreground = UIManager.getColor("inactiveCaptionText");
			shadow = UIManager.getColor("inactiveCaptionBorder");
		}

		//---------------------------------------------------���Ʊ���������
//		Color topDarkShadow2 = LNFUtils.getColor(
//				background, -40, -40, -40)
//				,topHightLight2 = LNFUtils.getColor(background,
//						60, 60, 60)
//				,topDarkHightLight2 = LNFUtils.getColor(background,
//						20, 20, 20);
		/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ���Ʊ���������START */
		/*
		 * ** bug���� by js,2009-09-30��������JDK1.5��Swing�ײ�BUG��
		 * 
		 * BUG������������ϵͳ�������л�ʱ��JInternalFrame��ʱ��ͬ�ķ���this.getBounds()��õĽ���ǲ�һ����
		 * 			�����ֲ�����Ҫ������ʱthis.getBounds()��õĽ����δ��������border����Ҫ���־��ǽ��
		 * 			��(x,y)��������δ����border�����꣬����������������(x=0,y=0),����ȷӦ��
		 * 			(x=border.insets.left,y=border.insets.top)��������Ӵ�bug����titlePane
		 * 			�����ʱ���ĳ�ª��
		 * 
		 * �����������ȷ֪���bug������ֻ�����˹���ʽ�ֲ��������࣬�� ǿ��������(x,y)�����꣬����Ӧ�ص���
		 * 			titlePane���������
		 */
//		Border b=frame.getBorder();
//		Insets is=b.getBorderInsets(frame);
//		Rectangle bounds = this.getBounds();
//		int paintTitlePaneX = bounds.x,paintTitlePaneY = bounds.y;
////		boolean isBUG = false;
//////		System.out.println("JInternalFrame��UI�Ƿ�������isBUG="+isBUG);
////		if(isBUG=(is.left!=bounds.x))//��is.left!=bounds.x�����϶��Ѿ�������BUG
////			paintTitlePaneX = is.left;
////		if(isBUG=(is.top!=bounds.y))//��is.left!=bounds.xͬ�����϶��Ѿ�������BUG
////			paintTitlePaneY = is.top;
////		if(isBUG)//��BUGʱ�����
////		{
////			//----------------------------- ���´�����Ϊ���ֲ���BUG������������쳣
////			//*����(1),(2),(3)���ִ����������ֲ�BUG�µ�border��۱�titlePane���ǵĴ���
////			//*��μ�JInternalFrameDialogBorder�ı߿������루�����ڴ˴�ģ����߿��TOP����Ч����>
////			//ˮƽ��һ����(1)
////			g.setColor(topDarkShadow2);
////			g.drawLine(0, 0, width, 0);
////			g.drawLine(0, 1, 0, height);//�����
////			g.drawLine(width, 1, width, height);//�Ҽ���
////			//ˮƽ�ڶ�����(2)
////			g.setColor(topHightLight2);
////			g.drawLine(1, 1, width-NLMetalBorders.InternalFrameDialogBorder.insets.left, 1);
////			//ˮƽ��������(3)
////			g.setColor(topDarkHightLight2);
////			g.drawLine(2, 2, width-NLMetalBorders.InternalFrameDialogBorder.insets.left, 2);
////			
////			NLTitlePane.paintTitlePane(g//���ҿ���Ĳ�����Border����
////					, paintTitlePaneX//ZCMetalBorders.InternalFrameDialogBorder.insets.left
////					, paintTitlePaneY//ZCMetalBorders.InternalFrameDialogBorder.insets.left
////					, width-is.left*2	//ע��˴�Ҳ��BUG�������������ĵ���
////					, height, isSelected
////					, background, shadow);
////			//----------------------------- END
////		}
////		//������BUGʱ�����
////		else
		{
			Insets frameInsets = frame.getInsets();
			//** Swing BUG������˵���˴��ǲ���Ҫ����frameInstes�ģ�����BasicInternalFrameTitlePane�Ĳ���
			//�Ǵ���BUG��������ʱû�а�BorderInstes���뵽x��y��ƫ���У�����UI��paintʱֻ������
			//�������棬��������ͼ��ο϶�����û������borderInstes����λ����������е�
			//BasicInternalFrameTitlePane���ڲ���Handler��layoutContainer������
			//getNorthPane().setBounds(..)��һ��
//			NLTitlePane.paintTitlePane(g
//					, frameInsets.left//0
//					, frameInsets.top//0
//					, width-frameInsets.left-frameInsets.right//-0
//					, height, isSelected
////					, background, shadow
//					);
			paintTitlePaneImpl(frameInsets, g, width,height, isSelected);
		}
		/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ���Ʊ���������END */

		//----------------------------------------------------���Ʊ��⼰ͼ��
		int titleLength = 0;
		int xOffset = leftToRight ? 5 : width - 5;
		String frameTitle = frame.getTitle();

		Icon icon = frame.getFrameIcon();
		if (icon != null)
		{
			if (!leftToRight)
				xOffset -= icon.getIconWidth();
			int iconY = ((height / 2) - (icon.getIconHeight() / 2));
			icon.paintIcon(frame, g, xOffset +2, iconY+1);//Ĭ����xOffset +0, iconY+0
			xOffset += leftToRight ? icon.getIconWidth() + 5 : -5;
		}

		if (frameTitle != null)
		{
			Font f = getFont();
			g.setFont(f);
			FontMetrics fm = MySwingUtilities2.getFontMetrics(frame, g, f);
			int fHeight = fm.getHeight();

			int yOffset = ((height - fm.getHeight()) / 2) + fm.getAscent();

			Rectangle rect = new Rectangle(0, 0, 0, 0);
			if (frame.isIconifiable())
			{
				rect = iconButton.getBounds();
			}
			else if (frame.isMaximizable())
			{
				rect = maxButton.getBounds();
			}
			else if (frame.isClosable())
			{
				rect = closeButton.getBounds();
			}
			int titleW;

			if (leftToRight)
			{
				if (rect.x == 0)
				{
					rect.x = frame.getWidth() - frame.getInsets().right - 2;
				}
				titleW = rect.x - xOffset - 4;
				frameTitle = getTitle(frameTitle, fm, titleW);
			}
			else
			{
				titleW = xOffset - rect.x - rect.width - 4;
				frameTitle = getTitle(frameTitle, fm, titleW);
				xOffset -= MySwingUtilities2.stringWidth(frame, fm, frameTitle);
			}

			titleLength = MySwingUtilities2.stringWidth(frame, fm, frameTitle);
			
//			g.setColor(Color.DARK_GRAY);//
//			NLUtils.drawString(frame, g, frameTitle, xOffset+1, yOffset+1);
			g.setColor(foreground);
//			if(NLLookAndFeel.windowTitleAntialising)
//				NLLookAndFeel.setAntiAliasing((Graphics2D) g,true);
			MySwingUtilities2.drawString(frame, g, frameTitle, xOffset, yOffset);
//			if(NLLookAndFeel.windowTitleAntialising)
//				NLLookAndFeel.setAntiAliasing((Graphics2D) g,false);
			xOffset += leftToRight ? titleLength + 5 : -5;
		}
	}
	
	/**
	 * Paint title pane impl.
	 *
	 * @param frameInsets the frame insets
	 * @param g the g
	 * @param width the width
	 * @param height the height
	 * @param isSelected the is selected
	 */
	protected void paintTitlePaneImpl(Insets frameInsets,Graphics g
			, int width,int height, boolean isSelected)
	{
		BETitlePane.paintTitlePane(g
				, frameInsets.left//0
				, frameInsets.top//0
				, width-frameInsets.left-frameInsets.right//-0
				, height, isSelected
//				, background, shadow
				);
	}

//	public void setPalette(boolean b)
//	{
//		isPalette = b;
//
//		if (isPalette)
//		{
//			closeButton.setIcon(paletteCloseIcon);
//			if (frame.isMaximizable())
//				remove(maxButton);
//			if (frame.isIconifiable())
//				remove(iconButton);
//		}
//		else
//		{
//			closeButton.setIcon(closeIcon);
//			if (frame.isMaximizable())
//				add(maxButton);
//			if (frame.isIconifiable())
//				add(iconButton);
//		}
//		revalidate();
//		repaint();
//	}

	/**
	 * Updates any state dependant upon the JInternalFrame being shown in
	 * a <code>JOptionPane</code>.
	 */
	private void updateOptionPaneState()
	{
		int type = -2;
		boolean closable = wasClosable;
		Object obj = frame.getClientProperty("JInternalFrame.messageType");

		if (obj == null)
		{
			// Don't change the closable state unless in an JOptionPane.
			return;
		}
		if (obj instanceof Integer)
		{
			type = ((Integer) obj).intValue();
		}
		switch (type)
		{
			case JOptionPane.ERROR_MESSAGE:
				selectedBackgroundKey = "OptionPane.errorDialog.titlePane.background";
				selectedForegroundKey = "OptionPane.errorDialog.titlePane.foreground";
				selectedShadowKey = "OptionPane.errorDialog.titlePane.shadow";
				closable = false;
				break;
			case JOptionPane.QUESTION_MESSAGE:
				selectedBackgroundKey = "OptionPane.questionDialog.titlePane.background";
				selectedForegroundKey = "OptionPane.questionDialog.titlePane.foreground";
				selectedShadowKey = "OptionPane.questionDialog.titlePane.shadow";
				closable = false;
				break;
			case JOptionPane.WARNING_MESSAGE:
				selectedBackgroundKey = "OptionPane.warningDialog.titlePane.background";
				selectedForegroundKey = "OptionPane.warningDialog.titlePane.foreground";
				selectedShadowKey = "OptionPane.warningDialog.titlePane.shadow";
				closable = false;
				break;
			case JOptionPane.INFORMATION_MESSAGE:
			case JOptionPane.PLAIN_MESSAGE:
				selectedBackgroundKey = selectedForegroundKey = selectedShadowKey = null;
				closable = false;
				break;
			default:
				selectedBackgroundKey = selectedForegroundKey = selectedShadowKey = null;
				break;
		}
		if (closable != frame.isClosable())
		{
			frame.setClosable(closable);
		}
	}
	
	//�ı丸��ķ����Ŀɼ���Ϊpublic�����������ã����˶��ѣ�
	//modified by jb2011
	//@see com.sun.java.swing.plaf.windows.uninstallListeners()
    /* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicInternalFrameTitlePane#uninstallListeners()
	 */
	public void uninstallListeners() {
        // Get around protected method in superclass
        super.uninstallListeners();
    }
}
