/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BEPopupMenuUI.java at 2012-9-24 17:22:51, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch9_menu;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicPopupMenuUI;

// TODO: Auto-generated Javadoc
/**
 * BeautyEye L&F�ĵ����˵�����ʵ����.
 * 
 * @author Jack Jiang(jb2011@163.com), 2012-09-14
 * @version 1.0
 * @since 3.1
 */
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� Start
//* �����ʵ�ֲο���WindowsPopupMenuUI��
//* >������˵����WindowsPopupMenuUI����java1.6.0_u10�����ܲ�������1.6.0_u10����java1.6.0�в�����������⣩
//* >�л��жϣ��������Vista����˵xpƽ̨ʱ(����֤������win7ƽ̨������Щ����)����windowsϵ
//* >ͳʵ�ֽ��б�����䣬����1.6.0_u18�����ܲ����ڴ˰汾�У�ȡ�����������жϣ���Ϊֱ�Ӽ���
//* >BasicPopupMenuUI��ʵĬ��ʵ�֡���˶������Ĳ���ʹ��BE LNF�ڲ�ͬ��java�汾�u10����
//* >�����ʹ��windowsϵͳʵ��.�����Ŀ�ľ���Ҫȥ�����ֲ��죬��Ȼ���ɸ���BasicPopupMenuUI
//* >ʵ�ּ��ɣ����ƵĹٷ�Metal LNFҲ�ǲ�����BeautyEyeһ���Ĵ����߼���.
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� END
public class BEPopupMenuUI extends BasicPopupMenuUI 
{
    
    /**
     * Creates the ui.
     *
     * @param c the c
     * @return the component ui
     */
    public static ComponentUI createUI(JComponent c) {
    	return new BEPopupMenuUI();
    }
}
