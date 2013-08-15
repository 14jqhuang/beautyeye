/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BETitlePane.java at 2012-9-24 17:20:09, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch1_titlepane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.UIResource;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.utils.BEUtils;
import org.jb2011.lnf.beautyeye.utils.MySwingUtilities2;


// TODO: Auto-generated Javadoc
/**
 * ����ı�����UIʵ��.
 * 
 * @author Jack Jiang(jb2011@163.com)
 */
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� Start
//* �����ʵ�ֲο���java1.5�е�MetalTitlePane.
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� END
public class BETitlePane extends JComponent
{
	
	/** The Constant handyEmptyBorder. */
	private static final Border handyEmptyBorder = new EmptyBorder(0, 0, 0, 0);
	
	/** The Constant IMAGE_HEIGHT. */
	private static final int IMAGE_HEIGHT = 16;
	
	/** The Constant IMAGE_WIDTH. */
	private static final int IMAGE_WIDTH = 16;

	/**
	 * PropertyChangeListener added to the JRootPane.
	 */
	private PropertyChangeListener propertyChangeListener;

	/**
	 * JMenuBar, typically renders the system menu items.
	 */
	private JMenuBar menuBar;
	/**
	 * Action used to close the Window.
	 */
	private Action closeAction;

	/**
	 * Action used to iconify the Frame.
	 */
	private Action iconifyAction;

	/**
	 * Action to restore the Frame size.
	 */
	private Action restoreAction;

	/**
	 * Action to restore the Frame size.
	 */
	private Action maximizeAction;
	
	/** ����action��������δʵ�֣���. */
	private Action setupAction;

	/**
	 * Button used to maximize or restore the Frame.
	 */
	private JButton toggleButton;

	/**
	 * Button used to maximize or restore the Frame.
	 */
	private JButton iconifyButton;

	/**
	 * Button used to maximize or restore the Frame.
	 */
	private JButton closeButton;

	/**
	 * Icon used for toggleButton when window is normal size.
	 */
	private Icon maximizeIcon;

	/**
	 * Icon used for toggleButton when window is maximized.
	 */
	private Icon minimizeIcon;
	
	/** ���ð�ť��������δʵ�֣���. */
	private JButton setupButton;

	/**
	 * Listens for changes in the state of the Window listener to update
	 * the state of the widgets.
	 */
	private WindowListener windowListener;

	/**
	 * Window we're currently in.
	 */
	private Window window;

	/**
	 * JRootPane rendering for.
	 */
	private JRootPane rootPane;

	/**
	 * Room remaining in title for bumps.
	 */
	private int buttonsWidth;

	/**
	 * Buffered Frame.state property. As state isn't bound, this is kept
	 * to determine when to avoid updating widgets.
	 */
	private int state;

	/**
	 * MetalRootPaneUI that created us.
	 */
	private BERootPaneUI rootPaneUI;

	// Colors
	/** The inactive background. */
	private Color inactiveBackground = UIManager.getColor("inactiveCaption");
	
	/** The inactive foreground. */
	private Color inactiveForeground = UIManager.getColor("inactiveCaptionText");
	
	/** The inactive shadow. */
	private Color inactiveShadow = UIManager.getColor("inactiveCaptionBorder");
	
	/** The active background. */
	private Color activeBackground = null;
	
	/** The active foreground. */
	private Color activeForeground = null;
	
	/** The active shadow. */
	private Color activeShadow = null;
	
	/**
	 * Instantiates a new bE title pane.
	 *
	 * @param root the root
	 * @param ui the ui
	 */
	public BETitlePane(JRootPane root, BERootPaneUI ui)
	{
		this.rootPane = root;
		rootPaneUI = ui;

		state = -1;

		installSubcomponents();
		determineColors();
		installDefaults();

		setLayout(createLayout());
	}

	/**
	 * Uninstalls the necessary state.
	 */
	private void uninstall()
	{
		uninstallListeners();
		window = null;
		removeAll();
	}

	/**
	 * Installs the necessary listeners.
	 */
	private void installListeners()
	{
		if (window != null)
		{
			windowListener = createWindowListener();
			window.addWindowListener(windowListener);
			propertyChangeListener = createWindowPropertyChangeListener();
			window.addPropertyChangeListener(propertyChangeListener);
		}
	}

	/**
	 * Uninstalls the necessary listeners.
	 */
	private void uninstallListeners()
	{
		if (window != null)
		{
			window.removeWindowListener(windowListener);
			window.removePropertyChangeListener(propertyChangeListener);
		}
	}

	/**
	 * Returns the <code>WindowListener</code> to add to the
	 * <code>Window</code>.
	 *
	 * @return the window listener
	 */
	private WindowListener createWindowListener()
	{
		return new WindowHandler();
	}

	/**
	 * Returns the <code>PropertyChangeListener</code> to install on
	 * the <code>Window</code>.
	 *
	 * @return the property change listener
	 */
	private PropertyChangeListener createWindowPropertyChangeListener()
	{
		return new PropertyChangeHandler();
	}

	/**
	 * Returns the <code>JRootPane</code> this was created for.
	 *
	 * @return the root pane
	 */
	public JRootPane getRootPane()
	{
		return rootPane;
	}

	/**
	 * Returns the decoration style of the <code>JRootPane</code>.
	 *
	 * @return the window decoration style
	 */
	private int getWindowDecorationStyle()
	{
		return getRootPane().getWindowDecorationStyle();
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#addNotify()
	 */
	public void addNotify()
	{
		try{
			super.addNotify();
		}
		catch (Exception e){
		}
		uninstallListeners();

		window = SwingUtilities.getWindowAncestor(this);
		if (window != null)
		{
			if (window instanceof Frame)
			{
				setState(((Frame) window).getExtendedState());
				
				//* ˵�������BeautyEyeLNFHelper.setMaximizedBoundForFrame
				if(BeautyEyeLNFHelper.setMaximizedBoundForFrame)
				{
					//* �˴����ô��ڵ����߽���Ϊ�˽���������ʱ����
					//* ����ϵͳ��task bar �����⣬����sunһֱû�н��������
					//* ��Ŀǰû�������÷�����ֻ����˽����
					setFrameMaxBound((Frame) window);
				}
			}
			else
			{
				setState(0);
			}
			setActive(window.isActive());
			installListeners();
		}
	}
	
	/**
	 * ���ô��ڵ����߽�.
	 * <p>
	 * ��������Jack Jiang ��2012-09-20��ӵġ�
	 *
	 * @param f the new frame max bound
	 * @see org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper#setMaximizedBoundForFrame
	 * @since 3.2
	 */
	private void setFrameMaxBound(Frame f)
	{
		GraphicsConfiguration gc = f.getGraphicsConfiguration();
		Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(gc);
		Rectangle screenBounds = gc.getBounds();
		int x = Math.max(0, screenInsets.left);
		int y = Math.max(0, screenInsets.top);
		int w = screenBounds.width - (screenInsets.left + screenInsets.right);
		int h = screenBounds.height - (screenInsets.top + screenInsets.bottom);
		// Keep taskbar visible
		f.setMaximizedBounds(new Rectangle(x, y, w, h));
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#removeNotify()
	 */
	public void removeNotify()
	{
		super.removeNotify();

		uninstallListeners();
		window = null;
	}

	/**
	 * Adds any sub-Components contained in the <code>MetalTitlePane</code>.
	 */
	private void installSubcomponents()
	{
		int decorationStyle = getWindowDecorationStyle();
		
		if (decorationStyle == JRootPane.FRAME||decorationStyle == JRootPane.PLAIN_DIALOG)
		{
			createActions();
			menuBar = createMenuBar();
			add(menuBar);
			createButtons();
			
			add(closeButton);
			
			//~* RootPane.setupButtonVisible��jb2011�Զ��������Ŷ��Ŀ���ǿ��������ǰ������ʾ�����ð�ť�Ŀɼ���
			Object isSetupButtonVisibleObj = UIManager.get("RootPane.setupButtonVisible");
			//���������û�����ô�������Ĭ����Ϊ��true(����ʾ�ð�ť)
			boolean isSetupButtonVisible = (isSetupButtonVisibleObj==null?true:(Boolean)isSetupButtonVisibleObj);
			if(isSetupButtonVisible)
				//�������ð�ť
				add(setupButton);
			
			if(decorationStyle!=JRootPane.PLAIN_DIALOG)//!
			{
				add(iconifyButton);
				add(toggleButton);
				menuBar.setEnabled(false);
			}
		}
		else if 
		(
//				decorationStyle == JRootPane.PLAIN_DIALOG
//				||
				decorationStyle == JRootPane.INFORMATION_DIALOG
				|| decorationStyle == JRootPane.ERROR_DIALOG
				|| decorationStyle == JRootPane.COLOR_CHOOSER_DIALOG
				|| decorationStyle == JRootPane.FILE_CHOOSER_DIALOG
				|| decorationStyle == JRootPane.QUESTION_DIALOG
				|| decorationStyle == JRootPane.WARNING_DIALOG)
		{
			createActions();
			createButtons();
			add(closeButton);
		}
	}

	/**
	 * Determines the Colors to draw with.
	 */
	private void determineColors()
	{
		switch (getWindowDecorationStyle())
		{
			case JRootPane.FRAME:
				activeBackground = UIManager.getColor("activeCaption");
				activeForeground = UIManager.getColor("activeCaptionText");
				activeShadow = UIManager.getColor("activeCaptionBorder");
				break;
			case JRootPane.ERROR_DIALOG:
				activeBackground = UIManager
						.getColor("OptionPane.errorDialog.titlePane.background");
				activeForeground = UIManager
						.getColor("OptionPane.errorDialog.titlePane.foreground");
				activeShadow = UIManager
						.getColor("OptionPane.errorDialog.titlePane.shadow");
				break;
			case JRootPane.QUESTION_DIALOG:
			case JRootPane.COLOR_CHOOSER_DIALOG:
			case JRootPane.FILE_CHOOSER_DIALOG:
				activeBackground = UIManager
						.getColor("OptionPane.questionDialog.titlePane.background");
				activeForeground = UIManager
						.getColor("OptionPane.questionDialog.titlePane.foreground");
				activeShadow = UIManager
						.getColor("OptionPane.questionDialog.titlePane.shadow");
				break;
			case JRootPane.WARNING_DIALOG:
				activeBackground = UIManager
						.getColor("OptionPane.warningDialog.titlePane.background");
				activeForeground = UIManager
						.getColor("OptionPane.warningDialog.titlePane.foreground");
				activeShadow = UIManager
						.getColor("OptionPane.warningDialog.titlePane.shadow");
				break;
			case JRootPane.PLAIN_DIALOG:
			case JRootPane.INFORMATION_DIALOG:
			default:
				activeBackground = UIManager.getColor("activeCaption");
				activeForeground = UIManager.getColor("activeCaptionText");
				activeShadow = UIManager.getColor("activeCaptionBorder");
				break;
		}
	}

	/**
	 * Installs the fonts and necessary properties on the MetalTitlePane.
	 */
	private void installDefaults()
	{
		setFont(UIManager.getFont("InternalFrame.titleFont", getLocale()));
	}

	/**
	 * Uninstalls any previously installed UI values.
	 */
	private void uninstallDefaults()
	{
	}

	/**
	 * Returns the <code>JMenuBar</code> displaying the appropriate
	 * system menu items.
	 *
	 * @return the j menu bar
	 */
	protected JMenuBar createMenuBar()
	{
		menuBar = new SystemMenuBar();
		menuBar.setOpaque(false);
		menuBar.setFocusable(false);
		menuBar.setBorderPainted(true);
		menuBar.add(createMenu());
		return menuBar;
	}

	/**
	 * Closes the Window.
	 */
	private void close()
	{
		Window window = getWindow();

		if (window != null)
		{
			window.dispatchEvent(new WindowEvent(window,
					WindowEvent.WINDOW_CLOSING));
		}
	}

	/**
	 * Iconifies the Frame.
	 */
	private void iconify()
	{
		Frame frame = getFrame();
		if (frame != null)
		{
			frame.setExtendedState(state | Frame.ICONIFIED);
		}
	}

	/**
	 * Maximizes the Frame.
	 */
	private void maximize()
	{
		Frame frame = getFrame();
		if (frame != null)
		{
			frame.setExtendedState(state | Frame.MAXIMIZED_BOTH);
		}
	}

	/**
	 * Restores the Frame size.
	 */
	private void restore()
	{
		Frame frame = getFrame();

		if (frame == null)
		{
			return;
		}

		if ((state & Frame.ICONIFIED) != 0)
		{
			frame.setExtendedState(state & ~Frame.ICONIFIED);
		}
		else
		{
			frame.setExtendedState(state & ~Frame.MAXIMIZED_BOTH);
		}
	}

	/**
	 * Create the <code>Action</code>s that get associated with the
	 * buttons and menu items.
	 */
	private void createActions()
	{
		closeAction = new CloseAction();
		if (getWindowDecorationStyle() == JRootPane.FRAME)
		{
			iconifyAction = new IconifyAction();
			restoreAction = new RestoreAction();
			maximizeAction = new MaximizeAction();
			
			setupAction = new AbstractAction("����  "){
				public void actionPerformed(ActionEvent e)
				{
					JOptionPane.showMessageDialog(rootPane, "This button just used for demo." +
							"In the future,you can customize it.\n" +
							"Now, you can set UIManager.put(\"RootPane.setupButtonVisible\", false) to hide it(detault is true).\n" +
							"BeautyEye L&F developed by Jack Jiang, you can mail with jb2011@163.com.");
				}
			};
		}
	}

	/**
	 * Returns the <code>JMenu</code> displaying the appropriate menu items
	 * for manipulating the Frame.
	 *
	 * @return the j menu
	 */
	private JMenu createMenu()
	{
		JMenu menu = new JMenu("");
//		menu.setRolloverEnabled(false);//����һ��Ҫ������Java 1.5֮Metal�����Bug! -- jack,2009-09-11
		menu.setOpaque(false);//����һ��Ҫ�����򽫵��´���ͼ���������Menu�ı���������Java Metal�����Bug! -- jack,2009-09-11
		if (getWindowDecorationStyle() == JRootPane.FRAME
				||getWindowDecorationStyle() == JRootPane.PLAIN_DIALOG//����Ҳ��dialog���ϲ˵����ֻ�йر��
			)
		{
			addMenuItems(menu);
		}
		return menu;
	}

	/**
	 * Adds the necessary <code>JMenuItem</code>s to the passed in menu.
	 *
	 * @param menu the menu
	 */
	private void addMenuItems(JMenu menu)
	{
		Locale locale = getRootPane().getLocale();
		menu.setToolTipText("������ز���.");

		JMenuItem mi;
		int mnemonic;
		if(getWindowDecorationStyle() == JRootPane.FRAME)//! ֻ��frame������Щ�˵���
		{
			mi = menu.add(restoreAction);
			mnemonic = BEUtils.getInt("MetalTitlePane.restoreMnemonic",
					-1);

			if (mnemonic != -1)
			{
				mi.setMnemonic(mnemonic);
			}

			mi = menu.add(iconifyAction);
			mnemonic = BEUtils.getInt("MetalTitlePane.iconifyMnemonic", -1);
			if (mnemonic != -1)
			{
				mi.setMnemonic(mnemonic);
			}

			if (Toolkit.getDefaultToolkit().isFrameStateSupported(
					Frame.MAXIMIZED_BOTH))
			{
				mi = menu.add(maximizeAction);
				mnemonic = BEUtils.getInt("MetalTitlePane.maximizeMnemonic",
						-1);
				if (mnemonic != -1)
				{
					mi.setMnemonic(mnemonic);
				}
			}

			menu.add(new JSeparator());
		}

		mi = menu.add(closeAction);
		mnemonic = BEUtils.getInt("MetalTitlePane.closeMnemonic", -1);
		if (mnemonic != -1)
		{
			mi.setMnemonic(mnemonic);
		}
	}

	/**
	 * Returns a <code>JButton</code> appropriate for placement on the
	 * TitlePane.
	 *
	 * @return the j button
	 */
	private JButton createTitleButton()
	{
		JButton button = new JButton();

		button.setFocusPainted(false);
		button.setFocusable(false);
		button.setOpaque(true);
		return button;
	}

	/**
	 * Creates the Buttons that will be placed on the TitlePane.
	 */
	private void createButtons()
	{
		
		setupButton = createTitleButton();
		setupButton.setAction(setupAction);
//		setupButton.setText("���� ");
//		setupButton.putClientProperty("paintActive", Boolean.TRUE);
		setupButton.setBorder(handyEmptyBorder);
//		setupButton.getAccessibleContext().setAccessibleName("Close");
		setupButton.setIcon(UIManager.getIcon("Frame.setupIcon"));
		setupButton.setContentAreaFilled(false);
//		setupButton.setToolTipText("����");
		
		closeButton = createTitleButton();
		closeButton.setAction(closeAction);
		closeButton.setText(null);
		closeButton.putClientProperty("paintActive", Boolean.TRUE);
		closeButton.setBorder(handyEmptyBorder);
		closeButton.getAccessibleContext().setAccessibleName("Close");
		closeButton.setIcon(UIManager.getIcon("Frame.closeIcon"));
		closeButton.setContentAreaFilled(false);
		closeButton.setToolTipText("�ر�");

		if (getWindowDecorationStyle() == JRootPane.FRAME)
		{
			maximizeIcon = UIManager.getIcon("Frame.maximizeIcon");
			minimizeIcon = UIManager.getIcon("Frame.minimizeIcon");

			iconifyButton = createTitleButton();
			iconifyButton.setAction(iconifyAction);
			iconifyButton.setText(null);
			iconifyButton.putClientProperty("paintActive", Boolean.TRUE);
			iconifyButton.setBorder(handyEmptyBorder);
			iconifyButton.getAccessibleContext().setAccessibleName("Iconify");
			iconifyButton.setIcon(UIManager.getIcon("Frame.iconifyIcon"));
			iconifyButton.setContentAreaFilled(false);
			iconifyButton.setToolTipText("��С��");

			toggleButton = createTitleButton();
			toggleButton.setAction(restoreAction);
			toggleButton.putClientProperty("paintActive", Boolean.TRUE);
			toggleButton.setBorder(handyEmptyBorder);
			toggleButton.getAccessibleContext().setAccessibleName("Maximize");
			toggleButton.setIcon(maximizeIcon);
			toggleButton.setContentAreaFilled(false);
			toggleButton.setToolTipText("���");
		}
	}

	/**
	 * Returns the <code>LayoutManager</code> that should be installed on
	 * the <code>MetalTitlePane</code>.
	 *
	 * @return the layout manager
	 */
	private LayoutManager createLayout()
	{
		return new TitlePaneLayout();
	}

	/**
	 * Updates state dependant upon the Window's active state.
	 *
	 * @param isActive the new active
	 */
	private void setActive(boolean isActive)
	{
		Boolean activeB = isActive ? Boolean.TRUE : Boolean.FALSE;
		closeButton.putClientProperty("paintActive", activeB);
		if (getWindowDecorationStyle() == JRootPane.FRAME)
		{
			iconifyButton.putClientProperty("paintActive", activeB);
			toggleButton.putClientProperty("paintActive", activeB);
		}
		// Repaint the whole thing as the Borders that are used have
		// different colors for active vs inactive
		getRootPane().repaint();
	}

	/**
	 * Sets the state of the Window.
	 *
	 * @param state the new state
	 */
	private void setState(int state)
	{
		setState(state, false);
	}

	/**
	 * Sets the state of the window. If <code>updateRegardless</code> is
	 * true and the state has not changed, this will update anyway.
	 *
	 * @param state the state
	 * @param updateRegardless the update regardless
	 */
	private void setState(int state, boolean updateRegardless)
	{
		Window w = getWindow();

		if (w != null && getWindowDecorationStyle() == JRootPane.FRAME)
		{
			if (this.state == state && !updateRegardless)
			{
				return;
			}
			Frame frame = getFrame();

			if (frame != null)
			{
				JRootPane rootPane = getRootPane();

				if (((state & Frame.MAXIMIZED_BOTH) != 0)
						&& (rootPane.getBorder() == null || (rootPane
								.getBorder() instanceof UIResource))
						&& frame.isShowing())
				{
					rootPane.setBorder(null);
				}
				else if ((state & Frame.MAXIMIZED_BOTH) == 0)
				{
					// This is a croak, if state becomes bound, this can
					// be nuked.
					rootPaneUI.installBorder(rootPane);
				}
				if (frame.isResizable())
				{
					if ((state & Frame.MAXIMIZED_BOTH) != 0)
					{
						updateToggleButton(restoreAction, minimizeIcon);
						maximizeAction.setEnabled(false);
						restoreAction.setEnabled(true);
					}
					else
					{
						updateToggleButton(maximizeAction, maximizeIcon);
						maximizeAction.setEnabled(true);
						restoreAction.setEnabled(false);
					}
					if (toggleButton.getParent() == null
							|| iconifyButton.getParent() == null)
					{
						add(toggleButton);
						add(iconifyButton);
						revalidate();
						repaint();
					}
					toggleButton.setText(null);
				}
				else
				{
					maximizeAction.setEnabled(false);
					restoreAction.setEnabled(false);
					if (toggleButton.getParent() != null)
					{
						remove(toggleButton);
						revalidate();
						repaint();
					}
				}
			}
			else
			{
				// Not contained in a Frame
				maximizeAction.setEnabled(false);
				restoreAction.setEnabled(false);
				iconifyAction.setEnabled(false);
				remove(toggleButton);
				remove(iconifyButton);
				revalidate();
				repaint();
			}
			closeAction.setEnabled(true);
			this.state = state;
		}
	}

	/**
	 * Updates the toggle button to contain the Icon <code>icon</code>, and
	 * Action <code>action</code>.
	 *
	 * @param action the action
	 * @param icon the icon
	 */
	private void updateToggleButton(Action action, Icon icon)
	{
		toggleButton.setAction(action);
		toggleButton.setIcon(icon);
		toggleButton.setText(null);
	}

	/**
	 * Returns the Frame rendering in. This will return null if the
	 * <code>JRootPane</code> is not contained in a <code>Frame</code>.
	 *
	 * @return the frame
	 */
	private Frame getFrame()
	{
		Window window = getWindow();

		if (window instanceof Frame)
		{
			return (Frame) window;
		}
		return null;
	}

	/**
	 * Returns the <code>Window</code> the <code>JRootPane</code> is
	 * contained in. This will return null if there is no parent ancestor
	 * of the <code>JRootPane</code>.
	 *
	 * @return the window
	 */
	private Window getWindow()
	{
		return window;
	}

	/**
	 * Returns the String to display as the title.
	 *
	 * @return the title
	 */
	private String getTitle()
	{
		Window w = getWindow();

		if (w instanceof Frame)
		{
			return ((Frame) w).getTitle();
		}
		else if (w instanceof Dialog)
		{
			return ((Dialog) w).getTitle();
		}
		return null;
	}

	/**
	 * Renders the TitlePane.
	 *
	 * @param g the g
	 */
	public void paintComponent(Graphics g)
	{
		// As state isn't bound, we need a convenience place to check
		// if it has changed. Changing the state typically changes the
		if (getFrame() != null)
		{
			setState(getFrame().getExtendedState());
		}
		JRootPane rootPane = getRootPane();
		Window window = getWindow();
		boolean leftToRight = (window == null) ? rootPane
				.getComponentOrientation().isLeftToRight() : window
				.getComponentOrientation().isLeftToRight();
		boolean isSelected = (window == null) ? true : window.isActive();
		int width = getWidth();
		int height = getHeight();

		Color background;
		Color foreground;
		Color darkShadow;

		if (isSelected)
		{
			background = activeBackground;
			foreground = activeForeground;
			darkShadow = activeShadow;
		}
		else
		{
			background = inactiveBackground;
			foreground = inactiveForeground;
			darkShadow = inactiveShadow;
//			bumps = inactiveBumps;
		}
		//----------------------------------------------- ���ⱳ��
		paintTitlePane(g,0,0,width,height,isSelected);

		//----------------------------------------------- �������ֺ�ͼƬ
		int xOffset = leftToRight ? 5 : width - 5;

		if (getWindowDecorationStyle() == JRootPane.FRAME||getWindowDecorationStyle() ==JRootPane.PLAIN_DIALOG)
		{
			xOffset += leftToRight ? IMAGE_WIDTH + 5 : -IMAGE_WIDTH - 5;
		}

		String theTitle = getTitle();
		if (theTitle != null)
		{
			FontMetrics fm = MySwingUtilities2.getFontMetrics(rootPane, g);
			int yOffset = ((height - fm.getHeight()) / 2) + fm.getAscent();

			Rectangle rect = new Rectangle(0, 0, 0, 0);
			if (iconifyButton != null && iconifyButton.getParent() != null)
			{
				rect = iconifyButton.getBounds();
			}
			int titleW;

			if (leftToRight)
			{
				if (rect.x == 0)
				{
					rect.x = window.getWidth() - window.getInsets().right - 2;
				}
				titleW = rect.x - xOffset - 4;
				theTitle = MySwingUtilities2.clipStringIfNecessary(rootPane, fm,
						theTitle, titleW);
			}
			else
			{
				titleW = xOffset - rect.x - rect.width - 4;
				theTitle = MySwingUtilities2.clipStringIfNecessary(rootPane, fm,
						theTitle, titleW);
				xOffset -= MySwingUtilities2.stringWidth(rootPane, fm, theTitle);
			}
			
			int titleLength = MySwingUtilities2.stringWidth(rootPane, fm,theTitle);
			g.setColor(foreground);
			MySwingUtilities2.drawString(rootPane, g, theTitle, xOffset, yOffset);
			xOffset += leftToRight ? titleLength + 5 : -5;
		}
	}
	
	/**
	 * Paint title pane.
	 *
	 * @param g the g
	 * @param x the x
	 * @param y the y
	 * @param width the width
	 * @param height the height
	 * @param actived the actived
	 */
	public static void paintTitlePane(Graphics g,int x,int y,int width
			,int height,boolean actived)
	{
		Graphics2D g2 = (Graphics2D)g;

		//����ͼ�ν�������
		Paint oldpaint = g2.getPaint();
		g2.setPaint(BEUtils.createTexturePaint(
				actived?__IconFactory__.getInstance().getFrameTitleHeadBg_active().getImage()
						:__IconFactory__.getInstance().getFrameTitleHeadBg_inactive().getImage()));
		g2.fillRect(x, y, width, height);
		g2.setPaint(oldpaint);
	}

	/**
	 * Actions used to <code>close</code> the <code>Window</code>.
	 */
	private class CloseAction extends AbstractAction
	{
		
		/**
		 * Instantiates a new close action.
		 */
		public CloseAction()
		{
			super("�ر�(C)");
		}

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e)
		{
			close();
		}
	}

	/**
	 * Actions used to <code>iconfiy</code> the <code>Frame</code>.
	 */
	private class IconifyAction extends AbstractAction
	{
		
		/**
		 * Instantiates a new iconify action.
		 */
		public IconifyAction()
		{
			super("��С��(N)");
		}

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e)
		{
			iconify();
		}
	}

	/**
	 * Actions used to <code>restore</code> the <code>Frame</code>.
	 */
	private class RestoreAction extends AbstractAction
	{
		
		/**
		 * Instantiates a new restore action.
		 */
		public RestoreAction()
		{
			super("��ԭ(R)");
		}

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e)
		{
			restore();
		}
	}

	/**
	 * Actions used to <code>restore</code> the <code>Frame</code>.
	 */
	private class MaximizeAction extends AbstractAction
	{
		
		/**
		 * Instantiates a new maximize action.
		 */
		public MaximizeAction()
		{
			super("���(X)");
		}

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e)
		{
			maximize();
		}
	}

	/**
	 * Class responsible for drawing the system menu. Looks up the
	 * image to draw from the Frame associated with the
	 * <code>JRootPane</code>.
	 */
	private class SystemMenuBar extends JMenuBar
	{
		
		/* (non-Javadoc)
		 * @see javax.swing.JComponent#paint(java.awt.Graphics)
		 */
		public void paint(Graphics g)
		{
			Frame frame = getFrame();

			if (isOpaque())
			{
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
			}
			Image image = (frame != null) ? frame.getIconImage() : null;
			if (image != null)
			{
				g.drawImage(image, 0, 0, IMAGE_WIDTH, IMAGE_HEIGHT, null);
			}
			else
			{
				Icon icon = UIManager.getIcon("Frame.icon");//"InternalFrame.icon");
				if (icon != null)
				{
					icon.paintIcon(this, g, 0, 0);
				}
			}
		}

		/* (non-Javadoc)
		 * @see javax.swing.JComponent#getMinimumSize()
		 */
		public Dimension getMinimumSize()
		{
			return getPreferredSize();
		}

		/* (non-Javadoc)
		 * @see javax.swing.JComponent#getPreferredSize()
		 */
		public Dimension getPreferredSize()
		{
			Dimension size = super.getPreferredSize();

			return new Dimension(Math.max(IMAGE_WIDTH, size.width), Math.max(
					size.height, IMAGE_HEIGHT));
		}
	}

	/**
	 * The Class TitlePaneLayout.
	 */
	private class TitlePaneLayout implements LayoutManager
	{
		
		/* (non-Javadoc)
		 * @see java.awt.LayoutManager#addLayoutComponent(java.lang.String, java.awt.Component)
		 */
		public void addLayoutComponent(String name, Component c)
		{
		}

		/* (non-Javadoc)
		 * @see java.awt.LayoutManager#removeLayoutComponent(java.awt.Component)
		 */
		public void removeLayoutComponent(Component c)
		{
		}

		/* (non-Javadoc)
		 * @see java.awt.LayoutManager#preferredLayoutSize(java.awt.Container)
		 */
		public Dimension preferredLayoutSize(Container c)
		{
			int height = computeHeight();
			return new Dimension(height, height);
		}

		/* (non-Javadoc)
		 * @see java.awt.LayoutManager#minimumLayoutSize(java.awt.Container)
		 */
		public Dimension minimumLayoutSize(Container c)
		{
			return preferredLayoutSize(c);
		}

		/**
		 * Compute height.
		 *
		 * @return the int
		 */
		private int computeHeight()
		{
			FontMetrics fm = rootPane.getFontMetrics(getFont());
			int fontHeight = fm.getHeight();
			fontHeight += 7;
			int iconHeight = 0;
			if (getWindowDecorationStyle() == JRootPane.FRAME)
//					||getWindowDecorationStyle() == JRootPane.PLAIN_DIALOG)//
			{
				iconHeight = IMAGE_HEIGHT;
			}

			int finalHeight = Math.max(fontHeight, iconHeight);
			return finalHeight+2;//* �ı�˴��ķ��ؽ����ֱ�Ӹı䴰�ڱ���ĸ߶�Ŷ
		}

		/* (non-Javadoc)
		 * @see java.awt.LayoutManager#layoutContainer(java.awt.Container)
		 */
		public void layoutContainer(Container c)
		{
			boolean leftToRight = (window == null) ? getRootPane()
					.getComponentOrientation().isLeftToRight() : window
					.getComponentOrientation().isLeftToRight();

			int w = getWidth();
			int x;
			int y = 3;
			int spacing;
			int buttonHeight;
			int buttonWidth;

			if (closeButton != null && closeButton.getIcon() != null)
			{
				buttonHeight = closeButton.getIcon().getIconHeight();
				buttonWidth = closeButton.getIcon().getIconWidth();
			}
			else
			{
				buttonHeight = IMAGE_HEIGHT;
				buttonWidth = IMAGE_WIDTH;
			}

			// assumes all buttons have the same dimensions
			// these dimensions include the borders

			x = leftToRight ? w : 0;

			spacing = 5;
			x = leftToRight ? spacing : w - buttonWidth - spacing;
			if (menuBar != null)
			{
				//* js 2010-03-30
				//* ԭMetalTitledPane��Bug:�����ڹرհ�ťʱ������ͼ��Ĵ�С���ѹرհ�ť�Ĵ�С�������ģ�����������
				menuBar.setBounds(x
						, y + 2//+2ƫ������Jack Jiang��2012-09-24�ռ��ϣ�Ŀ����ʹ��ͼ�����ı�������ͬһ����λ��
							   // TODO ĿǰBueautyEye��MetalLookAndFeel�ı���ͼ��λ���㷨�����Ż�����أ�y�������Զ���title�߶Ⱦ��л�
							   //	        ���ø��ೡ�������ڵ��㷨���title�߶ȱ�ĺܴ�����Щλ�ö��ǹ̶���������MetalLNF��˼·����Щ�߶�
							   //	        ������������һ������Ӧ������Ķ��ģ�Ҳ����˵����Ҫ�Ż���Ŀǰ����ô�İɣ�û�й�ϵ��
						, IMAGE_HEIGHT,IMAGE_WIDTH);//buttonWidth, buttonHeight);
			}

			x = leftToRight ? w : 0;
			spacing = 4;
			x += leftToRight ? -spacing - buttonWidth : spacing;
			if (closeButton != null)
			{
				closeButton.setBounds(x, y, buttonWidth, buttonHeight);
			}

			if (!leftToRight)
				x += buttonWidth;

			if (getWindowDecorationStyle() == JRootPane.FRAME)
			{
				if (Toolkit.getDefaultToolkit().isFrameStateSupported(
						Frame.MAXIMIZED_BOTH))
				{
					if (toggleButton.getParent() != null)
					{
						spacing = 2;//10!!!
						x += leftToRight ? -spacing - buttonWidth : spacing;
						toggleButton.setBounds(x, y, buttonWidth, buttonHeight);
						if (!leftToRight)
						{
							x += buttonWidth;
						}
					}
				}

				if (iconifyButton != null && iconifyButton.getParent() != null)
				{
					spacing = 2;
					x += leftToRight ? -spacing - buttonWidth : spacing;
					iconifyButton.setBounds(x, y, buttonWidth, buttonHeight);
					if (!leftToRight)
					{
						x += buttonWidth;
					}
				}
				
				//�����á���ť
				if(setupButton != null )
				{
					spacing = 2;
					int stringWidth = BEUtils.getStrPixWidth(setupButton.getFont(), setupButton.getText());
					x += leftToRight ? -spacing - buttonWidth - stringWidth : spacing;
					setupButton.setBounds(x, y, buttonWidth + stringWidth, buttonHeight);
					if (!leftToRight)
					{
						x += buttonWidth;
					}
				}
			}
			buttonsWidth = leftToRight ? w - x : x;
		}
	}

	/**
	 * PropertyChangeListener installed on the Window. Updates the necessary
	 * state as the state of the Window changes.
	 */
	private class PropertyChangeHandler implements PropertyChangeListener
	{
		
		/* (non-Javadoc)
		 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
		 */
		public void propertyChange(PropertyChangeEvent pce)
		{
			String name = pce.getPropertyName();

			// Frame.state isn't currently bound.
			if ("resizable".equals(name) || "state".equals(name))
			{
				Frame frame = getFrame();

				if (frame != null)
				{
					setState(frame.getExtendedState(), true);
				}
				if ("resizable".equals(name))
				{
					getRootPane().repaint();
				}
			}
			else if ("title".equals(name))
			{
				repaint();
			}
			else if ("componentOrientation".equals(name)
					|| "iconImage".equals(name))
			{
				revalidate();
				repaint();
			}
		}
	}

	/**
	 * WindowListener installed on the Window, updates the state as necessary.
	 */
	private class WindowHandler extends WindowAdapter
	{
		
		/* (non-Javadoc)
		 * @see java.awt.event.WindowAdapter#windowActivated(java.awt.event.WindowEvent)
		 */
		public void windowActivated(WindowEvent ev)
		{
			setActive(true);
		}

		/* (non-Javadoc)
		 * @see java.awt.event.WindowAdapter#windowDeactivated(java.awt.event.WindowEvent)
		 */
		public void windowDeactivated(WindowEvent ev)
		{
			setActive(false);
		}
	}
}
