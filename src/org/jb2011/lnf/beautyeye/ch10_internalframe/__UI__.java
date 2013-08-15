/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * __UI__.java at 2012-9-24 17:20:34, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch10_internalframe;

import javax.swing.UIManager;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.widget.border.BEShadowBorder;

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
		//�ڲ�����ı߿���ɫ��BueaytyEye�������壬ԭ����BeautyEye LNF�е�border��ʹ��NPͼʵ�֣�
		UIManager.put("InternalFrame.borderColor",new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));
		UIManager.put("InternalFrame.minimizeIconBackground", new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));
//		UIManager.put("InternalFrame.paletteCloseIcon"//��������beautyEye�в�����Ч��
//				,org.jb2011.lnf.windows2.ch1.__IconFactory__.getInstance().getInternalFrameCloseIcon());
		UIManager.put("InternalFrame.icon"
				,org.jb2011.lnf.beautyeye.ch1_titlepane.__IconFactory__.getInstance().getInternelFrameIcon());
		UIManager.put("InternalFrame.iconifyIcon"
				,org.jb2011.lnf.beautyeye.ch1_titlepane.__IconFactory__.getInstance().getInternalIconfiedIcon());
		UIManager.put("InternalFrame.minimizeIcon"
				,org.jb2011.lnf.beautyeye.ch1_titlepane.__IconFactory__.getInstance().getInternalFrameMinIcon());
		UIManager.put("InternalFrame.maximizeIcon"
				,org.jb2011.lnf.beautyeye.ch1_titlepane.__IconFactory__.getInstance().getInternalFrameMaxIcon());
		UIManager.put("InternalFrame.closeIcon"
				,org.jb2011.lnf.beautyeye.ch1_titlepane.__IconFactory__.getInstance().getInternalFrameCloseIcon());
		UIManager.put("InternalFrameUI",org.jb2011.lnf.beautyeye.ch10_internalframe.BEInternalFrameUI.class.getName());
//		UIManager.put("InternalFrame.paletteTitleHeight",40);//��������beautyEye�в�����Ч��
//		UIManager.put("InternalFrame.titlePaneHeight",38);//default is 25
//		UIManager.put("InternalFrame.borderWidth",10);
		Object internalFrameBorder = new BorderUIResource(new BEShadowBorder());
		UIManager.put("InternalFrame.border", internalFrameBorder);
		UIManager.put("InternalFrame.paletteBorder", internalFrameBorder);
		UIManager.put("InternalFrame.optionDialogBorder", internalFrameBorder);
		
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> JDesktopPane���ui�����趨
		//JDesktopPane�ı���ɫ
		UIManager.put("Desktop.background",new ColorUIResource(BeautyEyeLNFHelper.commonBackgroundColor));
		//��������������
//		UIManager.put("Desktop.minOnScreenInsets",new InsetsUIResource(10,10,10,10));//default is 3,3,3,3
		//JDesktopPane���ڲ�������С��ʱ�Ĵ���������
		UIManager.put("DesktopIcon.width",180);//Ĭ����160
		//BeautyEye LNF���ڲ����������ʵ��
		UIManager.put("DesktopIconUI",org.jb2011.lnf.beautyeye.ch10_internalframe.BEDesktopIconUI.class.getName());
	}
}
