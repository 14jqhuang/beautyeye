/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * __UI__.java at 2012-9-24 17:22:51, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch9_menu;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.UIManager;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.InsetsUIResource;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class __UI__.
 */
public class __UI__
{
	
	/**
	 * Ui impl.
	 */
	public static void uiImpl()
	{
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> margin��border���� START
//		UIManager.put("MenuBar.border",new org.jb2011.lnf.windows2.ch10.EWindowsMenuBarUI.MenuBarBorder(Color.red,Color.BLUE));
		//ȥ���˵����·���border��Ĭ����һ��2�����ظߵĺ��ߣ��μ�WindowsMenuBarUI.MenuBarBorder��
		UIManager.put("MenuBar.border",BorderFactory.createEmptyBorder());
		
		//��ʾ��margin��border��������������ײ�����֪����ʵ�ٷ�ʵ���ǣ�������marginʱ����Border��ʹ��
		//marginBorder����Border�����õ����margin��������Insets��
		//BueatyEye LNF���Ƽ�ʵ���ǣ�����margin�ĸ��ʡ�Ļ�������ֱ��ʹ��border��������ֱ�Ӹ���insets������
		UIManager.put("CheckBoxMenuItem.margin",new InsetsUIResource(0,0,0,0));//iuir);
		UIManager.put("RadioButtonMenuItem.margin",new InsetsUIResource(0,0,0,0));//iuir);
		UIManager.put("Menu.margin",new InsetsUIResource(0,0,0,0));//iuir);//windows lnf��Ĭ����2��2��2��2
		UIManager.put("MenuItem.margin",new InsetsUIResource(0,0,0,0));//iuir);//windows lnf��Ĭ����2��2��2��2//javax.swing.plaf.basic.BasicBorders$MarginBorder@1a1c887
//		UIManager.put("MenuItem.margin",new InsetsUIResource(10,2,10,2));//top=2,left=2,bottom=2,right=2
		
		//��ע�⣺�����margin�Ѿ�ȫ��Ϊ0��Ŷ
		UIManager.put("Menu.border",new BorderUIResource(BorderFactory.createEmptyBorder(4,3,5,3)));//javax.swing.plaf.basic.BasicBorders.MarginBorder;
		UIManager.put("MenuItem.border",new BorderUIResource(BorderFactory.createEmptyBorder(4,3,5,3)));//
		UIManager.put("CheckBoxMenuItem.border",new BorderUIResource(BorderFactory.createEmptyBorder(4,3,5,3)));//javax.swing.plaf.basic.BasicBorders.MarginBorder;
		UIManager.put("RadioButtonMenuItem.border",new BorderUIResource(BorderFactory.createEmptyBorder(4,3,5,3)));//		
//		UIManager.put("PopupMenu.border",new BorderUIResource(BorderFactory.createEmptyBorder(20,10,20,10)));//	
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> margin��border���� END
		
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ��ɫ���� START
		UIManager.put("MenuBar.foreground",new ColorUIResource(BeautyEyeLNFHelper.commonForegroundColor));
		UIManager.put("RadioButtonMenuItem.foreground",new ColorUIResource(BeautyEyeLNFHelper.commonForegroundColor));
		UIManager.put("Menu.foreground",new ColorUIResource(BeautyEyeLNFHelper.commonForegroundColor));
		UIManager.put("PopupMenu.foreground",new ColorUIResource(BeautyEyeLNFHelper.commonForegroundColor));
		UIManager.put("CheckBoxMenuItem.foreground",new ColorUIResource(BeautyEyeLNFHelper.commonForegroundColor));
		UIManager.put("MenuItem.foreground",new ColorUIResource(BeautyEyeLNFHelper.commonForegroundColor));
		
		UIManager.put("MenuBar.background",new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));
		UIManager.put("Menu.background",new ColorUIResource(new Color(255,255,255,0)));
		UIManager.put("PopupMenu.background",new ColorUIResource(new Color(255,255,255,0)));
		
		UIManager.put("RadioButtonMenuItem.disabledForeground",new ColorUIResource(BeautyEyeLNFHelper.commonDisabledForegroundColor));
		UIManager.put("MenuItem.disabledForeground",new ColorUIResource(BeautyEyeLNFHelper.commonDisabledForegroundColor));
		
		UIManager.put("Menu.selectionForeground",new ColorUIResource(BeautyEyeLNFHelper.commonSelectionForegroundColor));
		UIManager.put("MenuItem.selectionForeground",new ColorUIResource(BeautyEyeLNFHelper.commonSelectionForegroundColor));
		UIManager.put("CheckBoxMenuItem.selectionForeground",new ColorUIResource(BeautyEyeLNFHelper.commonSelectionForegroundColor));
		UIManager.put("RadioButtonMenuItem.selectionForeground",new ColorUIResource(BeautyEyeLNFHelper.commonSelectionForegroundColor));
		
		UIManager.put("Menu.selectionBackground",new ColorUIResource(BeautyEyeLNFHelper.commonSelectionBackgroundColor));
		UIManager.put("MenuItem.selectionBackground",new ColorUIResource(BeautyEyeLNFHelper.commonSelectionBackgroundColor));
		UIManager.put("CheckBoxMenuItem.selectionBackground",new ColorUIResource(BeautyEyeLNFHelper.commonSelectionBackgroundColor));
		UIManager.put("RadioButtonMenuItem.selectionBackground",new ColorUIResource(BeautyEyeLNFHelper.commonSelectionBackgroundColor));
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ��ɫ���� END

		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> �������� START
		//��ֵ��ζ�ŵ����˵�X�᷽���ϵ�ƫ��������BE LNF�м��˱߿�����Ҫ��ƫ���Ա�õ����˵���������˵������ÿ�һЩ
		UIManager.put("Menu.menuPopupOffsetX",-3);//win lnf��Ĭ��ֵ��0
		//��ֵ��ζ�ŵ����˵�Y�᷽���ϵ�ƫ��������BE LNF�м��˱߿�����Ҫ��ƫ���Ա�õ����˵���������˵������ÿ�һЩ
		UIManager.put("Menu.menuPopupOffsetY",2);///win lnfĬ��ֵ��0
		//��ֵ��ζ�ŵ����Ӳ˵�X�᷽���ϵ�ƫ��������BE LNF�м��˱߿�����Ҫ��ƫ���Ա�õ����˵���������˵������ÿ�һЩ
		UIManager.put("Menu.submenuPopupOffsetX", -2);///win lnfĬ��ֵ��-4
		//��ֵ��ζ�ŵ����Ӳ˵�Y�᷽���ϵ�ƫ��������BE LNF�м��˱߿�����Ҫ��ƫ���Ա�õ����˵���������˵������ÿ�һЩ
		UIManager.put("Menu.submenuPopupOffsetY", -5);///win lnfĬ��ֵ��-3
		
		//��ѡ��ťʽ�Ĳ˵���ѡ������ͼ��ʵ���趨
		UIManager.put("CheckBoxMenuItem.checkIcon",new org.jb2011.lnf.beautyeye.ch9_menu.BECheckBoxMenuItemUI.CheckBoxMenuItemIcon());//javax.swing.plaf.basic.BasicIconFactory.CheckBoxMenuItemIcon);
		//��ѡ��ťʽ�Ĳ˵���ѡ������ͼ��ʵ���趨
		UIManager.put("RadioButtonMenuItem.checkIcon",new org.jb2011.lnf.beautyeye.ch9_menu.BERadioButtonMenuItemUI.RadioButtonMenuItemIcon());
		
		//�Ӹ߲˵����������Ӿ�����
		UIManager.put("MenuBar.height",30);//default value is 19
		
		//������trueʱ�������õĲ˵�����ܱ�rover��������roverЧ����BE LNF��
		//�����״̬roverʱ������ɫӰ���Ӿ�Ч�������Ըɴ����֮���߼���Ҳ�ܺ���
		UIManager.put("MenuItem.disabledAreNavigable",false);// windows lnf��Ĭ����true
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> �������� END
		
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> UIʵ�������� START
		UIManager.put("MenuBarUI",org.jb2011.lnf.beautyeye.ch9_menu.BEMenuBarUI.class.getName());
		UIManager.put("MenuUI",org.jb2011.lnf.beautyeye.ch9_menu.BEMenuUI.class.getName());
		UIManager.put("MenuItemUI",org.jb2011.lnf.beautyeye.ch9_menu.BEMenuItemUI.class.getName());
		UIManager.put("RadioButtonMenuItemUI",org.jb2011.lnf.beautyeye.ch9_menu.BERadioButtonMenuItemUI.class.getName());
		UIManager.put("CheckBoxMenuItemUI",org.jb2011.lnf.beautyeye.ch9_menu.BECheckBoxMenuItemUI.class.getName());
		UIManager.put("PopupMenuSeparatorUI",org.jb2011.lnf.beautyeye.ch9_menu.BEPopupMenuSeparatorUI.class.getName());
		UIManager.put("PopupMenuUI",org.jb2011.lnf.beautyeye.ch9_menu.BEPopupMenuUI.class.getName());
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> UIʵ�������� END
	}
}
