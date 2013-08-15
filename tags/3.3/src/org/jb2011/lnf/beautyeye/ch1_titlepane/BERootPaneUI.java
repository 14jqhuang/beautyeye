/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BERootPaneUI.java at 2012-9-24 17:20:10, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch1_titlepane;

import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.LayoutManager2;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JRootPane;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.event.MouseInputListener;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicRootPaneUI;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.utils.WindowTranslucencyHelper;

// TODO: Auto-generated Javadoc
/**
 * �����UIʵ��.
 * 
 * @author Jack Jiang(jb2011@163.com)
 */
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� Start
//* �����ʵ�ֲο���java1.5�е�MetalRootPaneUI.
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� END
public class BERootPaneUI extends BasicRootPaneUI 
{
	/**
	 * Keys to lookup borders in defaults table.
	 */
	private static final String[] borderKeys = new String[] {
		null
		, "RootPane.frameBorder"
		, "RootPane.plainDialogBorder"
		, "RootPane.informationDialogBorder"
		, "RootPane.errorDialogBorder"
		, "RootPane.colorChooserDialogBorder"
		, "RootPane.fileChooserDialogBorder"
		, "RootPane.questionDialogBorder"
		, "RootPane.warningDialogBorder"
	};
	
	//* 2012-09-19 ��BeautyEye v3.2�д˳�����Jack Jiangȡ���ˣ���Ϊ
	//* v3.2�����������ԭMetalRootPaneUI�и���ȷ���õı߿��Ϸ��㷨
//	/**
//	 * The amount of space (in pixels) that the cursor is changed on.
//	 */
//	//MetalLookAndFeel��Ĭ����16
//	private static final int CORNER_DRAG_WIDTH = 16; 
//		//BeautyEyeLNFHelper.__getFrameBorder_CORNER_DRAG_WIDTH();//Ϊ�˱� ���û������д�������������û����飬��ֵ�ɼӴ�

	/**
	 * Region from edges that dragging is active from.
	 */
	//���ڿ��϶����д��������СҪ���ö��ȡ������֪����border��insets��Ĭ���� 5;
	private static final int BORDER_DRAG_THICKNESS = 5;
		//BeautyEyeLNFHelper.__getFrameBorder_BORDER_DRAG_THICKNESS();//Ϊ�˱� ���û������д�������������û����飬��ֵ�ɼӴ�

	/**
	 * Window the <code>JRootPane</code> is in.
	 */
	private Window window;

	/**
	 * <code>JComponent</code> providing window decorations. This will be
	 * null if not providing window decorations.
	 */
	private JComponent titlePane;

	/**
	 * <code>MouseInputListener</code> that is added to the parent
	 * <code>Window</code> the <code>JRootPane</code> is contained in.
	 */
	private MouseInputListener mouseInputListener;

	/**
	 * The <code>LayoutManager</code> that is set on the
	 * <code>JRootPane</code>.
	 */
	private LayoutManager layoutManager;

	/**
	 * <code>LayoutManager</code> of the <code>JRootPane</code> before we
	 * replaced it.
	 */
	private LayoutManager savedOldLayout;

	/**
	 * <code>JRootPane</code> providing the look and feel for.
	 */
	private JRootPane root;

	/**
	 * <code>Cursor</code> used to track the cursor set by the user.  
	 * This is initially <code>Cursor.DEFAULT_CURSOR</code>.
	 */
	private Cursor lastCursor =
		Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
	
	//* ��jb2011 ���ӣ������ڴ��ڱ������벻����ʱ�Զ���������͸���ȣ�������ʱ��Ϊ��͸���� 
	/** The windows listener. */
	private WindowListener windowsListener = null;
	
	/**
	 * Creates a UI for a <code>JRootPane</code>.
	 *
	 * @param c the JRootPane the RootPaneUI will be created for
	 * @return the RootPaneUI implementation for the passed in JRootPane
	 */
	public static ComponentUI createUI(JComponent c) 
	{
		return new BERootPaneUI();
	}

	/**
	 * Invokes supers implementation of <code>installUI</code> to install
	 * the necessary state onto the passed in <code>JRootPane</code>
	 * to render the metal look and feel implementation of
	 * <code>RootPaneUI</code>. If
	 * the <code>windowDecorationStyle</code> property of the
	 * <code>JRootPane</code> is other than <code>JRootPane.NONE</code>,
	 * this will add a custom <code>Component</code> to render the widgets to
	 * <code>JRootPane</code>, as well as installing a custom
	 * <code>Border</code> and <code>LayoutManager</code> on the
	 * <code>JRootPane</code>.
	 *
	 * @param c the JRootPane to install state onto
	 */
	public void installUI(JComponent c) 
	{ 
		super.installUI(c);
		
		root = (JRootPane)c;
		int style = root.getWindowDecorationStyle();
		
		if (style != JRootPane.NONE) 
		{
			installClientDecorations(root);
		}
	}


	/**
	 * Invokes supers implementation to uninstall any of its state. This will
	 * also reset the <code>LayoutManager</code> of the <code>JRootPane</code>.
	 * If a <code>Component</code> has been added to the <code>JRootPane</code>
	 * to render the window decoration style, this method will remove it.
	 * Similarly, this will revert the Border and LayoutManager of the
	 * <code>JRootPane</code> to what it was before <code>installUI</code>
	 * was invoked.
	 *
	 * @param c the JRootPane to uninstall state from
	 */
	public void uninstallUI(JComponent c) 
	{
		super.uninstallUI(c);
		uninstallClientDecorations(root);

		layoutManager = null;
		mouseInputListener = null;
		root = null;
	}

	/**
	 * Installs the appropriate <code>Border</code> onto the
	 * <code>JRootPane</code>.
	 *
	 * @param root the root
	 */
	void installBorder(JRootPane root) 
	{
		int style = root.getWindowDecorationStyle();

		if (style == JRootPane.NONE) 
		{
			LookAndFeel.uninstallBorder(root);
		}
		else 
		{
			Border b = root.getBorder();
			if (b == null || b instanceof UIResource) 
			{
				root.setBorder(null);
				root.setBorder(UIManager.getBorder(borderKeys[style]));
			}
		}
	}

	/**
	 * Removes any border that may have been installed.
	 *
	 * @param root the root
	 */
	private void uninstallBorder(JRootPane root) 
	{
		LookAndFeel.uninstallBorder(root);
	}

	/**
	 * Installs the necessary Listeners on the parent <code>Window</code>,
	 * if there is one.
	 * <p>
	 * This takes the parent so that cleanup can be done from
	 * <code>removeNotify</code>, at which point the parent hasn't been
	 * reset yet.
	 *
	 * @param root the root
	 * @param parent The parent of the JRootPane
	 */
	private void installWindowListeners(JRootPane root, Component parent) 
	{
		if (parent instanceof Window)
		{
			window = (Window)parent;
		}
		else 
		{
			window = SwingUtilities.getWindowAncestor(parent);
		}
		if (window != null) 
		{
			if (mouseInputListener == null) 
			{
				mouseInputListener = createWindowMouseInputListener(root);
			}
			
			window.addMouseListener(mouseInputListener);
			window.addMouseMotionListener(mouseInputListener);
			
			//* add by JS 2011-12-27,���������Ӽ��������ڲ��ʱ���ô��ڰ�͸�����ʱ��ԭ
			if(BeautyEyeLNFHelper.translucencyAtFrameInactive)
			{
				if(windowsListener == null)
				{
					windowsListener = new WindowAdapter(){
						public void windowActivated(WindowEvent e) {
							if(window != null)
								//AWTUtilities.setWindowOpacity(window, 1.0f);
								WindowTranslucencyHelper.setOpacity(window, 1.0f);
						}
						public void windowDeactivated(WindowEvent e) {
							if(window != null)
								//AWTUtilities.setWindowOpacity(window, 0.94f);
								WindowTranslucencyHelper.setOpacity(window, 0.94f);
						}
					};
				}
				window.addWindowListener(windowsListener);
			}
		}
	}

	/**
	 * Uninstalls the necessary Listeners on the <code>Window</code> the
	 * Listeners were last installed on.
	 *
	 * @param root the root
	 */
	private void uninstallWindowListeners(JRootPane root)
	{
		if (window != null)
		{
			window.removeMouseListener(mouseInputListener);
			window.removeMouseMotionListener(mouseInputListener);
		}
	}

	/**
	 * Installs the appropriate LayoutManager on the <code>JRootPane</code>
	 * to render the window decorations.
	 *
	 * @param root the root
	 */
	private void installLayout(JRootPane root)
	{
		if (layoutManager == null)
		{
			layoutManager = createLayoutManager();
		}
		savedOldLayout = root.getLayout();
		root.setLayout(layoutManager);
	}

	/**
	 * Uninstalls the previously installed <code>LayoutManager</code>.
	 *
	 * @param root the root
	 */
	private void uninstallLayout(JRootPane root) 
	{
		if (savedOldLayout != null) 
		{
			root.setLayout(savedOldLayout);
			savedOldLayout = null;
		}
	}

	/**
	 * Installs the necessary state onto the JRootPane to render client
	 * decorations. This is ONLY invoked if the <code>JRootPane</code>
	 * has a decoration style other than <code>JRootPane.NONE</code>.
	 *
	 * @param root the root
	 */
	private void installClientDecorations(JRootPane root)
	{
		installBorder(root);

		JComponent titlePane = createTitlePane(root);

		setTitlePane(root, titlePane);
		installWindowListeners(root, root.getParent());
		installLayout(root);
		
		//ֻ���ڴ��ڱ߿��ǰ�͸��������£����²���Ҫ���ô���͸��
		//* ע�⣺�����еĴ˴������Ŀ�ľ���Ϊ��ʵ�ְ�͸���߿򴰿ڵ�
		//* ������ʾ�����ҽ���Դ�Ŀ�ġ�����ñ߿�Ϊ͸������˴�Ҳ�Ͳ���Ҫ����
		//* ����͸���ˣ���ô�����ĳ��������ط���Ҫ����͸���Ļ�������.setWindowOpaque(..)
		//* �����ˣ��ɿ��������Ⱦ������˴��Ͳ����ع����Ҫ����
		if (!BeautyEyeLNFHelper.__isFrameBorderOpaque() 
				&& window != null)
		{
			//** 20111222 by jb2011���ô���ȫ͸��������ʵ�ִ��ڵ�͸���߿�Ч����
//			AWTUtilities.setWindowOpaque(window, false);
			// TODO BUG��1��Ŀǰ��֪����jdk1.7.0_u6�£�JDialog�İ�͸���߿��͸���ȱ�ԭ�����һ��
			// TODO BUG��2��Ŀǰ��֪����jdk1.6.0_u33��+win7ƽ̨�£�JFrame���ڱ����ó�͸����
			//				�ô����������ı����ᱻ��������������Ҫû��Ҫ�����������汯�ߣ���Ӧ��
			//				�ǹٷ�AWTUtilities.setWindowOpaque(..)bug���µ�,1.7.0_u6ͬ�����ڸ����⣬
			//				ʹ��BeautyEyeʱ����������������ֻ������ʹ��__isFrameBorderOpaque��ָ����
			//				��͸���߿���У�������������´���Ͳ���ִ�У�Ҳ�Ͳ��ô�����bug�ˣ�����
			//				JDialog���ܴ�bugӰ�죬���죡
			WindowTranslucencyHelper.setWindowOpaque(window, false);
			root.revalidate();
			root.repaint();
		}
	}

	/**
	 * Uninstalls any state that <code>installClientDecorations</code> has
	 * installed.
	 * <p>
	 * NOTE: This may be called if you haven't installed client decorations
	 * yet (ie before <code>installClientDecorations</code> has been invoked).
	 *
	 * @param root the root
	 */
	private void uninstallClientDecorations(JRootPane root) 
	{
		uninstallBorder(root);
		uninstallWindowListeners(root);
		setTitlePane(root, null);
		uninstallLayout(root);
		// We have to revalidate/repaint root if the style is JRootPane.NONE
		// only. When we needs to call revalidate/repaint with other styles
		// the installClientDecorations is always called after this method
		// imediatly and it will cause the revalidate/repaint at the proper
		// time.
		int style = root.getWindowDecorationStyle();
		if (style == JRootPane.NONE) 
		{
			root.repaint();
			root.revalidate();
		}
		// Reset the cursor, as we may have changed it to a resize cursor
		if (window != null) 
		{
			window.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
		window = null;
	}

	/**
	 * Returns the <code>JComponent</code> to render the window decoration
	 * style.
	 *
	 * @param root the root
	 * @return the j component
	 */
	private JComponent createTitlePane(JRootPane root) 
	{
		return new BETitlePane(root, this);
	}

	/**
	 * Returns a <code>MouseListener</code> that will be added to the
	 * <code>Window</code> containing the <code>JRootPane</code>.
	 *
	 * @param root the root
	 * @return the mouse input listener
	 */
	private MouseInputListener createWindowMouseInputListener(JRootPane root) 
	{
		return new MouseInputHandler();
	}

	/**
	 * Returns a <code>LayoutManager</code> that will be set on the
	 * <code>JRootPane</code>.
	 *
	 * @return the layout manager
	 */
	private LayoutManager createLayoutManager() 
	{
		return new XMetalRootLayout();
	}

	/**
	 * Sets the window title pane -- the JComponent used to provide a plaf a
	 * way to override the native operating system's window title pane with
	 * one whose look and feel are controlled by the plaf.  The plaf creates
	 * and sets this value; the default is null, implying a native operating
	 * system window title pane.
	 *
	 * @param root the root
	 * @param titlePane the title pane
	 */
	private void setTitlePane(JRootPane root, JComponent titlePane) 
	{
		JLayeredPane layeredPane = root.getLayeredPane();
		JComponent oldTitlePane = getTitlePane();

		if (oldTitlePane != null)
		{
			oldTitlePane.setVisible(false);
			layeredPane.remove(oldTitlePane);
		}
		if (titlePane != null) 
		{
			layeredPane.add(titlePane, JLayeredPane.FRAME_CONTENT_LAYER);
			titlePane.setVisible(true);
		}
		this.titlePane = titlePane;
	}

	/**
	 * Returns the <code>JComponent</code> rendering the title pane. If this
	 * returns null, it implies there is no need to render window decorations.
	 *
	 * @return the current window title pane, or null
	 * @see #setTitlePane
	 */
	private JComponent getTitlePane() 
	{
		return titlePane;
	}

	/**
	 * Returns the <code>JRootPane</code> we're providing the look and
	 * feel for.
	 *
	 * @return the root pane
	 */
	private JRootPane getRootPane() 
	{
		return root;
	}

	/**
	 * Invoked when a property changes. <code>MetalRootPaneUI</code> is
	 * primarily interested in events originating from the
	 * <code>JRootPane</code> it has been installed on identifying the
	 * property <code>windowDecorationStyle</code>. If the 
	 * <code>windowDecorationStyle</code> has changed to a value other
	 * than <code>JRootPane.NONE</code>, this will add a <code>Component</code>
	 * to the <code>JRootPane</code> to render the window decorations, as well
	 * as installing a <code>Border</code> on the <code>JRootPane</code>.
	 * On the other hand, if the <code>windowDecorationStyle</code> has
	 * changed to <code>JRootPane.NONE</code>, this will remove the
	 * <code>Component</code> that has been added to the <code>JRootPane</code>
	 * as well resetting the Border to what it was before
	 * <code>installUI</code> was invoked.
	 *
	 * @param e A PropertyChangeEvent object describing the event source 
	 *          and the property that has changed.
	 */
	public void propertyChange(PropertyChangeEvent e) 
	{
		super.propertyChange(e);

		String propertyName = e.getPropertyName();
		if(propertyName == null) 
		{
			return;
		}

		if(propertyName.equals("windowDecorationStyle")) 
		{
			JRootPane root = (JRootPane) e.getSource();
			int style = root.getWindowDecorationStyle();

			// This is potentially more than needs to be done,
			// but it rarely happens and makes the install/uninstall process
			// simpler. MetalTitlePane also assumes it will be recreated if
			// the decoration style changes.
			
			uninstallClientDecorations(root);
			if (style != JRootPane.NONE) 
			{
				installClientDecorations(root);
			}
		}
		else if (propertyName.equals("ancestor")) 
		{
			uninstallWindowListeners(root);
			if (((JRootPane)e.getSource()).getWindowDecorationStyle() !=
				JRootPane.NONE) 
			{
				installWindowListeners(root, root.getParent());
			}
		}
		return;
	} 

	/** 
	 * A custom layout manager that is responsible for the layout of 
	 * layeredPane, glassPane, menuBar and titlePane, if one has been
	 * installed.
	 */
	// NOTE: Ideally this would extends JRootPane.RootLayout, but that
	//       would force this to be non-static.
	private static class XMetalRootLayout implements LayoutManager2 
	{
		
		/**
		 * Returns the amount of space the layout would like to have.
		 *
		 * @param parent the parent
		 * @return a Dimension object containing the layout's preferred size
		 */ 
		public Dimension preferredLayoutSize(Container parent) 
		{
			Dimension cpd, mbd, tpd;
			int cpWidth = 0;
			int cpHeight = 0;
			int mbWidth = 0;
			int mbHeight = 0;
			int tpWidth = 0;
			int tpHeight = 0;
			Insets i = parent.getInsets();
			JRootPane root = (JRootPane) parent;

			if(root.getContentPane() != null) 
			{
				cpd = root.getContentPane().getPreferredSize();
			} 
			else 
			{
				cpd = root.getSize();
			}
			if (cpd != null) 
			{
				cpWidth = cpd.width;
				cpHeight = cpd.height;
			}

			if(root.getMenuBar() != null) 
			{
				mbd = root.getMenuBar().getPreferredSize();
				if (mbd != null)
				{
					mbWidth = mbd.width;
					mbHeight = mbd.height;
				}
			} 

			if (root.getWindowDecorationStyle() != JRootPane.NONE &&
					(root.getUI() instanceof BERootPaneUI)) 
			{
				JComponent titlePane = ((BERootPaneUI)root.getUI()).
				getTitlePane();
				if (titlePane != null) 
				{
					tpd = titlePane.getPreferredSize();
					if (tpd != null) 
					{
						tpWidth = tpd.width;
						tpHeight = tpd.height;
					}
				}
			}

			return new Dimension(Math.max(Math.max(cpWidth, mbWidth), tpWidth) + i.left + i.right, 
					cpHeight + mbHeight + tpWidth + i.top + i.bottom);
		}

		/**
		 * Returns the minimum amount of space the layout needs.
		 *
		 * @param parent the parent
		 * @return a Dimension object containing the layout's minimum size
		 */ 
		public Dimension minimumLayoutSize(Container parent) 
		{
			Dimension cpd, mbd, tpd;
			int cpWidth = 0;
			int cpHeight = 0;
			int mbWidth = 0;
			int mbHeight = 0;
			int tpWidth = 0;
			int tpHeight = 0;
			Insets i = parent.getInsets();
			JRootPane root = (JRootPane) parent;

			if(root.getContentPane() != null) 
			{
				cpd = root.getContentPane().getMinimumSize();
			} 
			else 
			{
				cpd = root.getSize();
			}
			if (cpd != null) 
			{
				cpWidth = cpd.width;
				cpHeight = cpd.height;
			}

			if(root.getMenuBar() != null) 
			{
				mbd = root.getMenuBar().getMinimumSize();
				if (mbd != null) {
					mbWidth = mbd.width;
					mbHeight = mbd.height;
				}
			}            
			if (root.getWindowDecorationStyle() != JRootPane.NONE &&
					(root.getUI() instanceof BERootPaneUI)) {
				JComponent titlePane = ((BERootPaneUI)root.getUI()).
				getTitlePane();
				if (titlePane != null) 
				{
					tpd = titlePane.getMinimumSize();
					if (tpd != null) 
					{
						tpWidth = tpd.width;
						tpHeight = tpd.height;
					}
				}
			}

			return new Dimension(Math.max(Math.max(cpWidth, mbWidth), tpWidth) + i.left + i.right, 
					cpHeight + mbHeight + tpWidth + i.top + i.bottom);
		}

		/**
		 * Returns the maximum amount of space the layout can use.
		 *
		 * @param target the target
		 * @return a Dimension object containing the layout's maximum size
		 */ 
		public Dimension maximumLayoutSize(Container target)
		{
			Dimension cpd, mbd, tpd;
			int cpWidth = Integer.MAX_VALUE;
			int cpHeight = Integer.MAX_VALUE;
			int mbWidth = Integer.MAX_VALUE;
			int mbHeight = Integer.MAX_VALUE;
			int tpWidth = Integer.MAX_VALUE;
			int tpHeight = Integer.MAX_VALUE;
			Insets i = target.getInsets();
			JRootPane root = (JRootPane) target;

			if(root.getContentPane() != null)
			{
				cpd = root.getContentPane().getMaximumSize();
				if (cpd != null) 
				{
					cpWidth = cpd.width;
					cpHeight = cpd.height;
				}
			}

			if(root.getMenuBar() != null) 
			{
				mbd = root.getMenuBar().getMaximumSize();
				if (mbd != null) 
				{
					mbWidth = mbd.width;
					mbHeight = mbd.height;
				}
			}

			if (root.getWindowDecorationStyle() != JRootPane.NONE &&
					(root.getUI() instanceof BERootPaneUI))
			{
				JComponent titlePane = ((BERootPaneUI)root.getUI()).
				getTitlePane();
				if (titlePane != null)
				{
					tpd = titlePane.getMaximumSize();
					if (tpd != null) 
					{
						tpWidth = tpd.width;
						tpHeight = tpd.height;
					}
				}
			}

			int maxHeight = Math.max(Math.max(cpHeight, mbHeight), tpHeight);
			// Only overflows if 3 real non-MAX_VALUE heights, sum to > MAX_VALUE
			// Only will happen if sums to more than 2 billion units.  Not likely.
			if (maxHeight != Integer.MAX_VALUE) 
			{
				maxHeight = cpHeight + mbHeight + tpHeight + i.top + i.bottom;
			}

			int maxWidth = Math.max(Math.max(cpWidth, mbWidth), tpWidth);
			// Similar overflow comment as above
			if (maxWidth != Integer.MAX_VALUE)
			{
				maxWidth += i.left + i.right;
			}

			return new Dimension(maxWidth, maxHeight);
		}

		/**
		 * Instructs the layout manager to perform the layout for the specified
		 * container.
		 *
		 * @param parent the parent
		 */ 
		public void layoutContainer(Container parent) 
		{
			JRootPane root = (JRootPane) parent;
			Rectangle b = root.getBounds();
			Insets i = root.getInsets();
			int nextY = 0;
			int w = b.width - i.right - i.left;
			int h = b.height - i.top - i.bottom;

			if(root.getLayeredPane() != null)
			{
				root.getLayeredPane().setBounds(i.left, i.top, w, h);
			}
			if(root.getGlassPane() != null) 
			{
				root.getGlassPane().setBounds(i.left, i.top, w, h);
			}
			// Note: This is laying out the children in the layeredPane,
			// technically, these are not our children.
			if (root.getWindowDecorationStyle() != JRootPane.NONE &&
					(root.getUI() instanceof BERootPaneUI)) 
			{
				JComponent titlePane = ((BERootPaneUI)root.getUI()).
				getTitlePane();
				if (titlePane != null) 
				{
					Dimension tpd = titlePane.getPreferredSize();
					if (tpd != null) 
					{
						int tpHeight = tpd.height;
						titlePane.setBounds(0, 0, w, tpHeight);
						nextY += tpHeight;
					}                    
				}
			}
			if(root.getMenuBar() != null) 
			{
				Dimension mbd = root.getMenuBar().getPreferredSize();
				root.getMenuBar().setBounds(0, nextY, w, mbd.height);
				nextY += mbd.height;
			}
			if(root.getContentPane() != null) 
			{
				Dimension cpd = root.getContentPane().getPreferredSize();
				root.getContentPane().setBounds(0, nextY, w, 
						h < nextY ? 0 : h - nextY);
			}
		}

		/* (non-Javadoc)
		 * @see java.awt.LayoutManager#addLayoutComponent(java.lang.String, java.awt.Component)
		 */
		public void addLayoutComponent(String name, Component comp) {}
		
		/* (non-Javadoc)
		 * @see java.awt.LayoutManager#removeLayoutComponent(java.awt.Component)
		 */
		public void removeLayoutComponent(Component comp) {}
		
		/* (non-Javadoc)
		 * @see java.awt.LayoutManager2#addLayoutComponent(java.awt.Component, java.lang.Object)
		 */
		public void addLayoutComponent(Component comp, Object constraints) {}
		
		/* (non-Javadoc)
		 * @see java.awt.LayoutManager2#getLayoutAlignmentX(java.awt.Container)
		 */
		public float getLayoutAlignmentX(Container target) { return 0.0f; }
		
		/* (non-Javadoc)
		 * @see java.awt.LayoutManager2#getLayoutAlignmentY(java.awt.Container)
		 */
		public float getLayoutAlignmentY(Container target) { return 0.0f; }
		
		/* (non-Javadoc)
		 * @see java.awt.LayoutManager2#invalidateLayout(java.awt.Container)
		 */
		public void invalidateLayout(Container target) {}
	}


	/**
	 * Maps from positions to cursor type. Refer to calculateCorner and
	 * calculatePosition for details of this.
	 */
	private static final int[] cursorMapping = new int[]
	  { Cursor.NW_RESIZE_CURSOR,
		Cursor.NW_RESIZE_CURSOR,
		Cursor.N_RESIZE_CURSOR,
		Cursor.NE_RESIZE_CURSOR,
		Cursor.NE_RESIZE_CURSOR,
		Cursor.NW_RESIZE_CURSOR,
		0,
		0,
		0,
		Cursor.NE_RESIZE_CURSOR,
		Cursor.W_RESIZE_CURSOR,
		0,
		0,
		0, 
		Cursor.E_RESIZE_CURSOR,
		Cursor.SW_RESIZE_CURSOR,
		0,
		0,
		0,
		Cursor.SE_RESIZE_CURSOR,
		Cursor.SW_RESIZE_CURSOR, 
		Cursor.SW_RESIZE_CURSOR,
		Cursor.S_RESIZE_CURSOR,
		Cursor.SE_RESIZE_CURSOR,
		Cursor.SE_RESIZE_CURSOR
	  };

	/**
	 * MouseInputHandler is responsible for handling resize/moving of
	 * the Window. It sets the cursor directly on the Window when then
	 * mouse moves over a hot spot.
	 */
	private class MouseInputHandler implements MouseInputListener
	{
		/**
		 * Set to true if the drag operation is moving the window.
		 */
		private boolean isMovingWindow;

		/**
		 * Used to determine the corner the resize is occuring from.
		 */
		private int dragCursor;

		/**
		 * X location the mouse went down on for a drag operation.
		 */
		private int dragOffsetX;

		/**
		 * Y location the mouse went down on for a drag operation.
		 */
		private int dragOffsetY;

		/**
		 * Width of the window when the drag started.
		 */
		private int dragWidth;

		/**
		 * Height of the window when the drag started.
		 */
		private int dragHeight;

		/*
		 * PrivilegedExceptionAction needed by mouseDragged method to
		 * obtain new location of window on screen during the drag.
		 */
		/** The get location action. */
		private final PrivilegedExceptionAction getLocationAction = new PrivilegedExceptionAction()
		{
			public Object run() throws HeadlessException
			{
				return MouseInfo.getPointerInfo().getLocation();
			}
		};

		/* (non-Javadoc)
		 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
		 */
		public void mousePressed(MouseEvent ev)
		{
			JRootPane rootPane = getRootPane();

			if (rootPane.getWindowDecorationStyle() == JRootPane.NONE)
			{
				return;
			}
			Point dragWindowOffset = ev.getPoint();
			Window w = (Window) ev.getSource();
			if (w != null)
			{
				w.toFront();
			}
			Point convertedDragWindowOffset = SwingUtilities.convertPoint(w,
					dragWindowOffset, getTitlePane());

			Frame f = null;
			Dialog d = null;

			if (w instanceof Frame)
			{
				f = (Frame) w;
			}
			else if (w instanceof Dialog)
			{
				d = (Dialog) w;
			}

			int frameState = (f != null) ? f.getExtendedState() : 0;

			if (getTitlePane() != null
					&& getTitlePane().contains(convertedDragWindowOffset))
			{
				Insets insets = w.getInsets();
				if ((f != null && ((frameState & Frame.MAXIMIZED_BOTH) == 0) || (d != null))
						&& dragWindowOffset.y >= BORDER_DRAG_THICKNESS
						&& dragWindowOffset.x >= BORDER_DRAG_THICKNESS 
						&& dragWindowOffset.x < w.getWidth()
								- BORDER_DRAG_THICKNESS)
				{
					isMovingWindow = true;
					dragOffsetX = dragWindowOffset.x;
					dragOffsetY = dragWindowOffset.y;
				}
			}
			else if (f != null && f.isResizable()
					&& ((frameState & Frame.MAXIMIZED_BOTH) == 0)
					|| (d != null && d.isResizable()))
			{
//				System.out.println("dragOffsetX="+dragOffsetX+" dragOffsetY="+dragOffsetY); TODO
				dragOffsetX = dragWindowOffset.x;
				dragOffsetY = dragWindowOffset.y;
				dragWidth = w.getWidth();
				dragHeight = w.getHeight();
				dragCursor = 
//				getCursor(calculateCorner(w, dragWindowOffset.x,dragWindowOffset.y)); // TODO TEST
						getCursor_new(w, dragWindowOffset.x,dragWindowOffset.y);
			}
		}

		/* (non-Javadoc)
		 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
		 */
		public void mouseReleased(MouseEvent ev)
		{
			if (dragCursor != 0 && window != null && !window.isValid())
			{
				// Some Window systems validate as you resize, others won't,
				// thus the check for validity before repainting.
				window.validate();
				getRootPane().repaint();
			}
			isMovingWindow = false;
			dragCursor = 0;
		}

		/* (non-Javadoc)
		 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
		 */
		public void mouseMoved(MouseEvent ev)
		{
			JRootPane root = getRootPane();

			if (root.getWindowDecorationStyle() == JRootPane.NONE)
			{
				return;
			}

			Window w = (Window) ev.getSource();

			Frame f = null;
			Dialog d = null;

			if (w instanceof Frame)
			{
				f = (Frame) w;
			}
			else if (w instanceof Dialog)
			{
				d = (Dialog) w;
			}

			// Update the cursor
			int cursor = //������1�������㷨����ȷ�� 2�����Լ����������borderС�ڻ򲿷�С��BORDER_THINNESS��3��дע�͡�������룡
//				getCursor(calculateCorner(w, ev.getX(), ev.getY()));// TODO Test!!
				getCursor_new(w, ev.getX(), ev.getY());

			if (cursor != 0
					&& ((f != null && (f.isResizable() && (f.getExtendedState() & Frame.MAXIMIZED_BOTH) == 0)) || (d != null && d
							.isResizable())))
			{
				w.setCursor(Cursor.getPredefinedCursor(cursor));
			}
			else
			{
				w.setCursor(lastCursor);
			}
		}

		/**
		 * Adjust.
		 *
		 * @param bounds the bounds
		 * @param min the min
		 * @param deltaX the delta x
		 * @param deltaY the delta y
		 * @param deltaWidth the delta width
		 * @param deltaHeight the delta height
		 */
		private void adjust(Rectangle bounds, Dimension min, int deltaX,
				int deltaY, int deltaWidth, int deltaHeight)
		{
			bounds.x += deltaX;
			bounds.y += deltaY;
			bounds.width += deltaWidth;
			bounds.height += deltaHeight;
			if (min != null)
			{
				if (bounds.width < min.width)
				{
					int correction = min.width - bounds.width;
					if (deltaX != 0)
					{
						bounds.x -= correction;
					}
					bounds.width = min.width;
				}
				if (bounds.height < min.height)
				{
					int correction = min.height - bounds.height;
					if (deltaY != 0)
					{
						bounds.y -= correction;
					}
					bounds.height = min.height;
				}
			}
		}

		/* (non-Javadoc)
		 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
		 */
		public void mouseDragged(MouseEvent ev)
		{
			Window w = (Window) ev.getSource();
			Point pt = ev.getPoint();

			if (isMovingWindow)
			{
				Point windowPt;
				try
				{
					windowPt = (Point) AccessController
							.doPrivileged(getLocationAction);
					windowPt.x = windowPt.x - dragOffsetX;
					windowPt.y = windowPt.y - dragOffsetY;
					w.setLocation(windowPt);
				}
				catch (PrivilegedActionException e)
				{
				}
			}
			else if (dragCursor != 0)
			{
				Rectangle r = w.getBounds();
				Rectangle startBounds = new Rectangle(r);
				Dimension min = w.getMinimumSize();

				switch (dragCursor)
				{
					case Cursor.E_RESIZE_CURSOR:
						adjust(r, min, 0, 0, pt.x + (dragWidth - dragOffsetX)
								- r.width, 0);
						break;
					case Cursor.S_RESIZE_CURSOR:
						adjust(r, min, 0, 0, 0, pt.y
								+ (dragHeight - dragOffsetY) - r.height);
						break;
					case Cursor.N_RESIZE_CURSOR:
						adjust(r, min, 0, pt.y - dragOffsetY, 0,
								-(pt.y - dragOffsetY));
						break;
					case Cursor.W_RESIZE_CURSOR:
						adjust(r, min, pt.x - dragOffsetX, 0,
								-(pt.x - dragOffsetX), 0);
						break;
					case Cursor.NE_RESIZE_CURSOR:
						adjust(r, min, 0, pt.y - dragOffsetY, pt.x
								+ (dragWidth - dragOffsetX) - r.width,
								-(pt.y - dragOffsetY));
						break;
					case Cursor.SE_RESIZE_CURSOR:
						adjust(r, min, 0, 0, pt.x + (dragWidth - dragOffsetX)
								- r.width, pt.y + (dragHeight - dragOffsetY)
								- r.height);
						break;
					case Cursor.NW_RESIZE_CURSOR:
						adjust(r, min, pt.x - dragOffsetX, pt.y - dragOffsetY,
								-(pt.x - dragOffsetX), -(pt.y - dragOffsetY));
						break;
					case Cursor.SW_RESIZE_CURSOR:
						adjust(r, min, pt.x - dragOffsetX, 0,
								-(pt.x - dragOffsetX), pt.y
										+ (dragHeight - dragOffsetY) - r.height);
						break;
					default:
						break;
				}
				if (!r.equals(startBounds))
				{
					w.setBounds(r);
					// Defer repaint/validate on mouseReleased unless dynamic
					// layout is active.
					if (Toolkit.getDefaultToolkit().isDynamicLayoutActive())
					{
						w.validate();
						getRootPane().repaint();
					}
				}
			}
		}

		/* (non-Javadoc)
		 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
		 */
		public void mouseEntered(MouseEvent ev)
		{
			Window w = (Window) ev.getSource();
			lastCursor = w.getCursor();
			mouseMoved(ev);
		}

		/* (non-Javadoc)
		 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
		 */
		public void mouseExited(MouseEvent ev)
		{
			Window w = (Window) ev.getSource();
			// TODO ###### Hack����Swing����¼����⣬�϶�����Ļ��ܶ�ʱ��û�������ر���������lastCursor
			//					�Ӷ����¾����Ե��˳��϶����϶�ʱ�������ʽ���ڣ������ܲ�ˬ����Ӧ����swing
			//					������¼�����ȷ���µĻ��������⡣Ŀǰ������y���˳��϶�ʱǿ�ƻ�ԭ��Ĭ����꣬
			//					��Ȼ�ڼ�������¿��ܻز����û�������lastCursor���������ܽ��Ŀǰ��BueatyEye��
			//					���border��Ƶ�����ֵ���������ˣ�����ô�ΰɣ�
//			w.setCursor(lastCursor);
			w.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}

		/* (non-Javadoc)
		 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
		 */
		public void mouseClicked(MouseEvent ev)
		{
			Window w = (Window) ev.getSource();
			Frame f = null;

			if (w instanceof Frame)
			{
				f = (Frame) w;
			}
			else
			{
				return;
			}

			Point convertedPoint = SwingUtilities.convertPoint(w,
					ev.getPoint(), getTitlePane());

			int state = f.getExtendedState();
			if (getTitlePane() != null
					&& getTitlePane().contains(convertedPoint))
			{
				if ((ev.getClickCount() % 2) == 0
						&& ((ev.getModifiers() & InputEvent.BUTTON1_MASK) != 0))
				{
					if (f.isResizable())
					{
						if ((state & Frame.MAXIMIZED_BOTH) != 0)
						{
							f.setExtendedState(state & ~Frame.MAXIMIZED_BOTH);
						}
						else
						{
							f.setExtendedState(state | Frame.MAXIMIZED_BOTH);
						}
						return;
					}
				}
			}
		}

		//*************************************************************** v3.2ǰ�ο���MetalRootPaneUI�е��ϱ߿��Ϸź����㷨 START
		//** ���㷨˵����Metal�е��㷨�Ǽ��贰�ڱ߿��border�ǹ滮�ģ����������ҵ�inset����һ���ģ����ٶ����϶���Χ������
		//** 			�����С������border���ڵĴ�С����BORDER_DRAG_THICKNESS������Χ�ڵ��������������������� �㷨��
		//** 			��ǰ����ͨ��������ķ�����ʵ��û�����⡣
		//** ���㷨ȱ�ݣ������ڵı߿򲻹滮����FrameBorderStyle.translucencyAppleLik����ʱ����=17,��=27,��=27,��=37����
		//** 			�������ֻ�ܼٶ�һ����Сֵ�ˣ���ǰ��ȡ��17��Ϊͳһ�߿�Χ���룬��ô���²�ԭ����37��inset�������϶�
		//** 			��Χ��17�����µ�ԭ����border��insets��10������Ҳ�����������������ˣ����������ƶ����·�ʱ������
		//**			���ڱ�Եλ�ã�ȴ���Ǵ����϶���Χ�ڣ�Ҫ��������10���ص���inset�ĵ�10~27���ط�Χ�ڲ��У�������������
		//** 			Ӱ�����û����顣
		//* 2012-09-19 ��BeautyEye v3.2�е�BERootPaneUI��Jack Jiang���������
		//* ԭMetalRootPaneUI�и���ȷ���õı߿��Ϸ��㷨�����·�����ʱ���ã��Ժ����ɾ���ˣ� START
//		/**
//		 * Returns the corner that contains the point <code>x</code>,
//		 * <code>y</code>, or -1 if the position doesn't match a corner.
//		 */
//		private int calculateCorner(Window w, int x, int y)
//		{
//			Insets insets = w.getInsets();
//			int xPosition = calculatePosition(x - insets.left, w.getWidth()
//					- insets.left - insets.right);
//			int yPosition = calculatePosition(y - insets.top, w.getHeight()
//					- insets.top - insets.bottom);
//			
//			if (xPosition == -1 || yPosition == -1)
//			{
//				return -1;
//			}
//			return yPosition * 5 + xPosition;
//		}

//		/**
//		 * Returns the Cursor to render for the specified corner. This returns
//		 * 0 if the corner doesn't map to a valid Cursor
//		 */
//		private int getCursor(int corner)
//		{
//			if (corner == -1)
//			{
//				return 0;
//			}
//			return cursorMapping[corner];
//		}

//		/**
//		 * Returns an integer indicating the position of <code>spot</code>
//		 * in <code>width</code>. The return value will be:
//		 * 0 if < BORDER_DRAG_THICKNESS
//		 * 1 if < CORNER_DRAG_WIDTH
//		 * 2 if >= CORNER_DRAG_WIDTH && < width - BORDER_DRAG_THICKNESS
//		 * 3 if >= width - CORNER_DRAG_WIDTH
//		 * 4 if >= width - BORDER_DRAG_THICKNESS
//		 * 5 otherwise
//		 */
//		private int calculatePosition(int spot, int width)
//		{
////			Insets iss = getRootPane().getInsets();
////			System.out.println("ississ="+iss); //TODO
//			
//			if (spot < BORDER_DRAG_THICKNESS)
//			{
//				return 0;
//			}
//			if (spot < CORNER_DRAG_WIDTH)
//			{
//				return 1;
//			}
//			if (spot >= (width - BORDER_DRAG_THICKNESS))
//			{
//				return 4;
//			}
//			if (spot >= (width - CORNER_DRAG_WIDTH))
//			{
//				return 3;
//			}
//			return 2;
//		}//********************************************************************* v3.2ǰ���ϱ߿��Ϸź����㷨 END
		
		//********************************************************************* v3.2�����õ��±߿��Ϸź����㷨 SART
		//** ���㷨˵����v3.2�����õ����㷨��ԭ���ǰѿ��϶���Χ�޶����������������������С��ȥBorder���������������
		//**			�����һ���̶���BORDER_DRAG_THICKNESS�����ڣ�����������Ѵ��ڵ�border���ö�ô���滮���ҵ��û���
		//**			������Զ����һ����Χ�ڣ���ͱ�֤�û����飬�ϺõĽ�������㷨��ȱ�ݡ�
		/**
		 * Gets the cursor_new.
		 *
		 * @param w the w
		 * @param x the x
		 * @param y the y
		 * @return the cursor_new
		 */
		public int getCursor_new(Window w, int x, int y)
		{
			Insets insets = w.getInsets();
			return getCursor_new(x - insets.left,y - insets.top
					, w.getWidth() - insets.left - insets.right
					, w.getHeight() - insets.top - insets.bottom);
		}
		
		/**
		 * �µĴ��ڱ߿��϶��㷨��ʵ���ǰѿ��϶����ֳ�8��������������궯����Ӧ
		 * ������ͼ�����������ĸ������϶�����MetalRootPaneUI�еļ��׷���Ҫ��ȷ�;�ȷ��
		 * <p>
		 * ���϶��ж���ʾ��ͼ��<br>
		 * <u>��ɫ����ɫ�����������Ǵ��ڵ�border��Χ����ɫ����ɫ�������ǹ̶��Ŀ��϶�������ɫ����ɫ�������ǹ̶��ģ�
		 * ��ɫ����ɫ��������border��ͬ����һ����</u><br>
		 * <b>ע�⣺</b>�㷨��Ҫע��һ�ּ������������Border��һ���ֻ�ȫ����С�ڿ��϶���������������㷨Ӧ��Ҳ
		 * ��û������ģ��޷������8���϶������������и���������������Թ�ûӰ�죬�Ժ���ע��һ�£�
		 * <table border="1" width="28%" cellpadding="10" height="185" bordercolor="#000080">
		 * <tr>
		 * <td align="center">
		 * <table border="1" width="88%" id="table1" height="148" bordercolor="#808080">
		 * <tr>
		 * <td width="27" height="25" align="center">R1</td>
		 * <td height="25" align="center">R2</td>
		 * <td width="25" height="25" align="center">R3</td>
		 * </tr>
		 * <tr>
		 * <td width="27" align="center">R8</td>
		 * <td align="center" bordercolor="#FF0000">���ӹ�����</td>
		 * <td width="25" align="center">R4</td>
		 * </tr>
		 * <tr>
		 * <td width="27" height="25" align="center">R7</td>
		 * <td height="25" align="center">R6</td>
		 * <td width="25" height="25" align="center">R5</td>
		 * </tr>
		 * </table>
		 * </td>
		 * </tr>
		 * </table>.
		 *
		 * @param x the x
		 * @param y the y
		 * @param w the w
		 * @param h the h
		 * @return the cursor_new
		 */
		public int getCursor_new(int x, int y , int w, int h)
		{
			int B = BORDER_DRAG_THICKNESS;
			
			Insets iss = getRootPane().getInsets();
			int topI = iss.top, bottomI = iss.bottom, leftI = iss.left, rightI = iss.right; 
			
			//8���϶���������
			Rectangle r1 = new Rectangle(leftI-B,topI-B,B,B);
			Rectangle r2 = new Rectangle(leftI,topI-B,w-leftI-rightI,B);
			Rectangle r3 = new Rectangle(w-rightI,topI-B,B,B);
			Rectangle r4 = new Rectangle(w-rightI,topI,B,h-topI-bottomI);
			Rectangle r5 = new Rectangle(w-rightI,h-bottomI,B,B);
			Rectangle r6 = new Rectangle(leftI,h-bottomI,w-leftI-rightI,B);
			Rectangle r7 = new Rectangle(leftI-B,h-bottomI,B,B);
			Rectangle r8 = new Rectangle(leftI-B,topI,B,h-topI-bottomI);
			
			Point p = new Point(x,y);
			int cc = 0;
			
			if(r1.contains(p))
			{
//				System.out.println("����-NW");
				cc = Cursor.NW_RESIZE_CURSOR; 
			}
			else if(r3.contains(p))
			{
//				System.out.println("����-NE");
				cc = Cursor.NE_RESIZE_CURSOR; 
			}
			else if(r5.contains(p))
			{
//				System.out.println("����-SE");
				cc = Cursor.SE_RESIZE_CURSOR; 
			}
			else if(r7.contains(p))
			{
//				System.out.println("����-SW");
				cc = Cursor.SW_RESIZE_CURSOR; 
			}
			else if(r2.contains(p))
			{
//				System.out.println("��-N");
				cc = Cursor.N_RESIZE_CURSOR; 
			}
			else if(r4.contains(p))
			{
//				System.out.println("��-E");
				cc = Cursor.E_RESIZE_CURSOR; 
			}
			else if(r6.contains(p))
			{
//				System.out.println("��-S");
				cc = Cursor.S_RESIZE_CURSOR; 
			}
			else if(r8.contains(p))
			{
//				System.out.println("��-W");
				cc = Cursor.W_RESIZE_CURSOR; 
			}
			
			return cc;
		}
	}//********************************************************************* v3.2�����õ��±߿��Ϸź����㷨 END
}
