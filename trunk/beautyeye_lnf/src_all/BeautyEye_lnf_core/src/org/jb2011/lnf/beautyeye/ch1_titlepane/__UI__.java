/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * __UI__.java at 2012-9-24 17:20:09, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch1_titlepane;

import javax.swing.UIManager;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.utils.BEUtils;

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
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ����ui�ĸ��������趨
		//*~ ��������Jack Jiang�����趨�ģ�Java��Metal����Ĭ�϶Է�Frame����Ĵ���ͼ��ȡ����InternalFrame.icon�����ǲ��Ե�
		UIManager.put("Frame.icon",__IconFactory__.getInstance().getFrameIcon_16_16());
		UIManager.put("Frame.iconifyIcon",__IconFactory__.getInstance().getInternalIconfiedIcon());
		UIManager.put("Frame.minimizeIcon",__IconFactory__.getInstance().getInternalFrameMinIcon());
		UIManager.put("Frame.maximizeIcon",__IconFactory__.getInstance().getInternalFrameMaxIcon());
		UIManager.put("Frame.closeIcon",__IconFactory__.getInstance().getInternalFrameCloseIcon());
		//�趨������ʾ֮�õġ����á���ťͼ��
		UIManager.put("Frame.setupIcon",__IconFactory__.getInstance().getInternalFrameSetupIcon());
		
//		UIManager.put("activeCaption",new ColorUIResource(Windows2LookAndFeel.activeCaption));
		UIManager.put("activeCaptionText",new ColorUIResource(BeautyEyeLNFHelper.activeCaptionTextColor));
//		UIManager.put("activeCaptionBorder",new ColorUIResource(Windows2LookAndFeel.activeCaptionBorder));
//		UIManager.put("inactiveCaption",new ColorUIResource(GraphicHandler.getColor(activeCaption,64,42,22)));
		UIManager.put("inactiveCaptionText",new ColorUIResource(BEUtils.getColor(BeautyEyeLNFHelper.activeCaptionTextColor,-49,-27,-7)));
//		UIManager.put("inactiveCaptionBorder",new ColorUIResource(GraphicHandler.getColor(activeCaptionBorder,64,42,22)));
		//�����Լ���BeautyEye LNF�Ĵ��ڱ�����ʵ��
		UIManager.put("RootPaneUI", BERootPaneUI.class.getName());
		
		// These bindings are only enabled when there is a default
		// button set on the rootpane.
		UIManager.put("RootPane.defaultButtonWindowKeyBindings", new Object[] {
				"ENTER", "press",
				"released ENTER", "release",
				"ctrl ENTER", "press",
				"ctrl released ENTER", "release"
		});
		
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> OptionPane�ĸ���ui�����趨
		Object dialogBorder = new BorderUIResource(BeautyEyeLNFHelper.__getFrameBorder());//BorderFactory.createLineBorder(new Color(181,181,181)));
		UIManager.put("RootPane.frameBorder", dialogBorder);
		UIManager.put("RootPane.plainDialogBorder", dialogBorder);
		UIManager.put("RootPane.informationDialogBorder", dialogBorder);
		UIManager.put("RootPane.errorDialogBorder", dialogBorder);
		UIManager.put("RootPane.colorChooserDialogBorder", dialogBorder);
		UIManager.put("RootPane.fileChooserDialogBorder", dialogBorder);
		UIManager.put("RootPane.questionDialogBorder", dialogBorder);
		UIManager.put("RootPane.warningDialogBorder", dialogBorder);
	}
}
