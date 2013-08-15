/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * TranslucentPopupFactory.java at 2012-9-24 17:22:46, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch7_popup;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Window;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JToolTip;
import javax.swing.JWindow;
import javax.swing.MenuElement;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicComboPopup;

import org.jb2011.lnf.beautyeye.utils.WindowTranslucencyHelper;
import org.jb2011.lnf.beautyeye.widget.ImageBgPanel;

// TODO: Auto-generated Javadoc
/**
 * �Զ���͸�������ĵ�������ʵ����.
 * ������ʵ��Swing��UI���ƹ���������ȫ���Զ�����L&Fʹ�á�
 * 
 * @author Jack Jiang(jb2011@163.com), 2012-05-18
 * @version 1.0
 */
public class TranslucentPopupFactory extends PopupFactory
{
	
	/* (non-Javadoc)
	 * @see javax.swing.PopupFactory#getPopup(java.awt.Component, java.awt.Component, int, int)
	 */
	@Override
	public Popup getPopup(Component owner, Component contents, int x, int y)
			throws IllegalArgumentException
	{
		// A more complete implementation would cache and reuse popups
		return new TranslucentPopup(owner, contents, x, y);
	}

	/**
	 * ͸��������Popupʵ����.
	 * <p>
	 * ����Ĵ󲿷ִ��붼��ԭ�ⲻ���زο���Popup����(JDK�汾��1.6_u18���Դ��)����ΪPopup��
	 * ���еĶ�����������ʹ�õİ��ڿɼ��ԣ�����û��ֱ�Ӽ̳У������ֲ������3��������չ����
	 * ����Swing��׼����Ƚ��ټ�����֪ԭ�����ǳ��ں��ֿ��ǣ�������������ʵ�����൱��ǷȱԶ
	 * ���ԣ������������LNF��ܳ�����
	 */
	protected class TranslucentPopup extends Popup
	{
		//copy all from parent class
		/**
		 * The Component representing the Popup.
		 */
		private Component component;

		//copy all from parent class
		/**
		 * Creates a <code>Popup</code> for the Component <code>owner</code>
		 * containing the Component <code>contents</code>. <code>owner</code>
		 * is used to determine which <code>Window</code> the new
		 * <code>Popup</code> will parent the <code>Component</code> the
		 * <code>Popup</code> creates to.
		 * A null <code>owner</code> implies there is no valid parent.
		 * <code>x</code> and
		 * <code>y</code> specify the preferred initial location to place
		 * the <code>Popup</code> at. Based on screen size, or other paramaters,
		 * the <code>Popup</code> may not display at <code>x</code> and
		 * <code>y</code>.
		 *
		 * @param owner    Component mouse coordinates are relative to, may be null
		 * @param contents Contents of the Popup
		 * @param x        Initial x screen coordinate
		 * @param y        Initial y screen coordinate
		 */
		public TranslucentPopup(Component owner, Component contents, int x,
				int y)
		{
			this();
			if (contents == null)
			{
				throw new IllegalArgumentException("Contents must be non-null");
			}
			
			reset(owner, contents, x, y);
		}

		//copy all from parent class
		/**
		 * Creates a <code>Popup</code>. This is provided for subclasses.
		 */
		public TranslucentPopup()
		{
		}

		/**
		 * <p>
		 * Makes the <code>Popup</code> visible. If the <code>Popup</code> is
		 * currently visible, this has no effect.<br>
		 * 
		 * �������Ľṹ��ȫcopy�Ը��෽�����������component.repaint();�ĵ���.
		 * </p>
		 */
		public void show()
		{
			Component component = getComponent();
			
			if (component != null)
			{
				component.setVisible(true);
				
				//���д������Ҫ�У������������Ϊû�йر�˫���棨getRootPane().
				//setUseTrueDoubleBuffering(false)����������ǰ��ڿɼ������Ա�����û������
				//���������½���û���ػ棺Ҫ������UIû�л������Ҫ�����ǳ��ֿհ׵�popup��û�����������
				component.repaint();
			}
		}

		//copy all from parent class
		/**
		 * Hides and disposes of the <code>Popup</code>. Once a
		 * <code>Popup</code> has been disposed you should no longer invoke
		 * methods on it. A <code>dispose</code>d <code>Popup</code> may be
		 * reclaimed and later used based on the <code>PopupFactory</code>. As
		 * such, if you invoke methods on a <code>disposed</code>
		 * <code>Popup</code>, indeterminate behavior will result.
		 */
		public void hide()
		{
			Component component = getComponent();

			if (component instanceof JWindow)
			{
				component.hide();
				((JWindow) component).getContentPane().removeAll();
			}
			dispose();
		}

		//copy all from parent class
		/**
		 * Frees any resources the <code>Popup</code> may be holding onto.
		 */
		protected void dispose()
		{
			Component component = getComponent();
			Window window = SwingUtilities.getWindowAncestor(component);

			if (component instanceof JWindow)
			{
				((Window) component).dispose();
				component = null;
			}
			// If our parent is a DefaultFrame, we need to dispose it, too.
			if (window instanceof DefaultFrame)
			{
				window.dispose();
			}
		}

		/**
		 * <p>
		 * Resets the <code>Popup</code> to an initial state.<br>
		 * 
		 * �������Ľṹ��ȫcopy�Ը��෽�����������а���������͸������ͼƬʵ�ֱ����������ڵ��޸�.
		 * </p>
		 *
		 * @param owner the owner
		 * @param contents the contents
		 * @param ownerX the owner x
		 * @param ownerY the owner y
		 */
		protected void reset(Component owner, Component contents, int ownerX, int ownerY)
		{
			if (getComponent() == null)
			{
				component = createComponent(owner);
			}

			Component c = getComponent();
			if (c instanceof JWindow)
			{
				JWindow component = (JWindow) getComponent();
				component.setLocation(ownerX, ownerY);
				
				boolean isTooltip = ((JComponent)contents instanceof JToolTip);
				//���contents��BasicComboPopup���������ǵ�ǰ��Ӧ��������������ĵ����б���
				boolean isComboBoxPopup = (contents instanceof BasicComboPopup);
				
				//ÿ����͸��
//				com.sun.awt.AWTUtilities.setWindowOpaque(component, false);
				WindowTranslucencyHelper.setWindowOpaque(component, false);
				//���������͸��
//				com.sun.awt.AWTUtilities.setWindowOpacity(component,
//						isTooltip ? 1.0f : 0.95f);//0.85f : 0.95f);//0.8f : 0.95f);
				WindowTranslucencyHelper.setOpacity(component,
						isTooltip ? 1.0f : isComboBoxPopup?0.95f : 0.95f);//0.85f : 0.95f);//0.8f : 0.95f);
				
//				component.getContentPane().add(contents, BorderLayout.CENTER);
//				contents.invalidate();
//				if (component.isVisible())
//				{
//					// Do not call pack() if window is not visible to
//					// avoid early native peer creation
//					pack();
//				}
				
				//ͼƬ��䱳�����������
				ImageBgPanel imageContentPane = new ImageBgPanel().setN9(
						isTooltip?
								__Icon9Factory__.getInstance().getTooltipBg()
								:isComboBoxPopup?//���������б���ʹһ����JScrollPaneһ���ı���ͼ���ÿ���
										org.jb2011.lnf.beautyeye.ch4_scroll.__Icon9Factory__.getInstance().getScrollPaneBorderBg()
										:__Icon9Factory__.getInstance().getPopupBg()
				);
				imageContentPane.setLayout(new BorderLayout());
				imageContentPane.add(contents, BorderLayout.CENTER);
				
				//Ϊÿһ��Ҫ��ʾ�����������������һ����border��Ŀ��
				//��ʹ�ø����ı���ͼƬ��ʾ��Ч������
				if(contents instanceof JComponent)
				{
					((JComponent)contents).setOpaque(false);
					//* ######################################### Bug FIX START ############################################
					//* ����Java Bug 6683775,��ַ��http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=6683775�������java1.6.0_14
					//* 
					//* ��Bug˵������
					//* ��java1.6.0_14֮ǰ(��Ȼ��>=u10��)�������ô���͸��ʱ�������÷���
					//* AWTUtilities.setWindowOpaque(component, false)ʹ�ô���͸����������λ��
					//* Windows�ϵĵ�1��JPanelҲΪ͸��ʱ(��JPanel.setOpaque(false))������������
					//* �ںܾ���ǰ��JPanel����һ����͸��ɫ����alphaС��255��ʱ���ֵĲ���ȷpaint�����
					//* ֱ�ӵ���������ĵ����б�uiˢ�³��ֻ��ң������Ͳ��ܼ�ʱˢ�£�uiһ����Ϳ�������.
					//* 
					//* ��java1.6.0_14��ǰ��ν������
					//* ��Bug 6683775�ڱ��ٷ����ǰ����ô���ܱ������uiˢ��
					//* �����أ�Bug 6683775�ϵĹٷ��ظ������˽��������JPanel.setDoubleBuffered(false)���ٷ���Ϊ
					//* ������JPanel.setOpaque(false)�ǲ����ģ�����ȡ��˫������У����������ڹٷ���u14���Ժ�İ汾��
					//* ���׽�����������.
					//* 
					//* ��ĿǰBeautyEye L&F����ν��������
					//* Ϊ�����ڸ�Bug�����ǰ����javaС��java1.6.0_14�棩BE LNFҲ���������У�ֻ����΢����һ��ui���ܣ�
					//* ���ٷ��������������JPanel.setDoubleBuffered(false)���������.
					((JComponent)contents).setDoubleBuffered(false);
					//* ######################################### Bug FIX END ##############################################
					
					((JComponent)contents).setBorder(
							isTooltip?
									BorderFactory.createEmptyBorder(6,8,12,12)//6,8,12,8)
									:isComboBoxPopup?BorderFactory.createEmptyBorder(6,4,6,4)
											:BorderFactory.createEmptyBorder(5,3,6,3));//10,2,10,4));//5,5,20,5));
				}
				
				//���BasicComboPopup��������Ӧ����ComboBox��ĵ����˵���Ϊ��ʹN9
				//�����ܱ�����չ�ֳ�����Ҫ��combox�����б����ڵ�JScrollPane����͸������
				//����Ϊ���������͸��������pop��NPͼ������ֻ����ʾ��Ե�����ҵױ���һ�㱻
				//��ס�����ÿ�����ע����JScrollPane��BEComboBoxUI�б�������һ��EmptyBorder������
				//û����ScrollPaneUI�ж��ϵ��Ǹ�ScrollBorderŶ��û���Ǹ�border��Ŀ�ľ���Ϊ����Щʹ��
				//pop�ı�������
				if(isComboBoxPopup)//contents instanceof BasicComboPopup)//* add by jb2011 2012-08-31
	        	{
					Component[] cs = ((BasicComboPopup)contents).getComponents();
					//��JScrollPane����contents�ĵ�һ���������
					if(cs != null && cs.length>0)
					{
						//�������ҳ���
						for(Component com : cs)
						{
							if(com instanceof JScrollPane)
								((JScrollPane)com).setOpaque(false);
						}
					}
//					BEUtils.componentsOpaque(((BasicComboPopup)contents).getComponents(), false);
	        	}
				//����ǲ˵�������������JMenuItemҲ����͸��,jb2011 2009-08-29
				else if(contents instanceof JPopupMenu)
	        	{
	        		MenuElement[]  mes=((JPopupMenu)contents).getSubElements();
	        		for(int i=0;i<mes.length;i++)
	        		{
	        			if(mes[i] instanceof JMenuItem)
	        				((JMenuItem)mes[i]).setOpaque(false);
	        		}
	        	}
				
				// add the contents to the popup
	        	component.setContentPane(imageContentPane);
//				popupWindow.getContentPane().add(p, BorderLayout.CENTER);
//				contents.invalidate();
				if (component.isVisible())
				{
					// Do not call pack() if window is not visible to
					// avoid early native peer creation
					pack();
				}
			}
		}

		//copy all from parent class
		/**
		 * Causes the <code>Popup</code> to be sized to fit the preferred size
		 * of the <code>Component</code> it contains.
		 */
		protected void pack()
		{
			Component component = getComponent();

			if (component instanceof Window)
			{
				((Window) component).pack();
			}
		}

		//copy all from parent class
		/**
		 * Returns the <code>Window</code> to use as the parent of the
		 * <code>Window</code> created for the <code>Popup</code>. This creates
		 * a new <code>DefaultFrame</code>, if necessary.
		 *
		 * @param owner the owner
		 * @return the parent window
		 */
		protected Window getParentWindow(Component owner)
		{
			Window window = null;

			if (owner instanceof Window)
			{
				window = (Window) owner;
			}
			else if (owner != null)
			{
				window = SwingUtilities.getWindowAncestor(owner);
			}
			if (window == null)
			{
				window = new DefaultFrame();
			}
			return window;
		}

		//copy all from parent class
		/**
		 * Creates the Component to use as the parent of the <code>Popup</code>.
		 * The default implementation creates a <code>Window</code>, subclasses
		 * should override.
		 *
		 * @param owner the owner
		 * @return the component
		 */
		protected Component createComponent(Component owner)
		{
			if (GraphicsEnvironment.isHeadless())
			{
				// Generally not useful, bail.
				return null;
			}

			return new HeavyWeightWindow(getParentWindow(owner));
		}

		//copy all from parent class
		/**
		 * Returns the <code>Component</code> returned from
		 * <code>createComponent</code> that will hold the <code>Popup</code>.
		 *
		 * @return the component
		 */
		protected Component getComponent()
		{
			return component;
		}
		
		//copy all from parent class
		/**
		 * Used if no valid Window ancestor of the supplied owner is found.
		 * <p>
		 * PopupFactory uses this as a way to know when the Popup shouldn't be
		 * cached based on the Window.
		 */
		protected class DefaultFrame extends Frame
		{}
		
		//copy all from parent class
		/**
		 * Component used to house window.
		 */
		protected class HeavyWeightWindow extends JWindow// implements ModalExclude
		{
			
			/**
			 * Instantiates a new heavy weight window.
			 *
			 * @param parent the parent
			 */
			public HeavyWeightWindow(Window parent)
			{
				super(parent);
				setFocusableWindowState(false);
				setName("###overrideRedirect###");
				// Popups are typically transient and most likely won't benefit
				// from true double buffering. Turn it off here.
//				getRootPane().setUseTrueDoubleBuffering(false);//�����������ڰ��ⱻ����
				// Try to set "always-on-top" for the popup window.
				// Applets usually don't have sufficient permissions to do it.
				// In this case simply ignore the exception.
				try
				{
					setAlwaysOnTop(true);
				}
				catch (SecurityException se)
				{
					// setAlwaysOnTop is restricted,
					// the exception is ignored
				}
			}

			/* (non-Javadoc)
			 * @see javax.swing.JWindow#update(java.awt.Graphics)
			 */
			public void update(Graphics g)
			{
				paint(g);
			}

			/* (non-Javadoc)
			 * @see java.awt.Window#show()
			 */
			public void show()
			{
				this.pack();
				super.show();
			}
		}
	}
}