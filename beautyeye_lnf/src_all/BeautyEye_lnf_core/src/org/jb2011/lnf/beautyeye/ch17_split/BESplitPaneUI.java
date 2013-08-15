/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BESplitPaneUI.java at 2012-9-24 17:22:19, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch17_split;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;

// TODO: Auto-generated Javadoc
/**
 * 分栏面板的UI实现.
 * 
 * @author Jack Jiang(jb2011@163.com), 2012-07-10
 * @version 1.0
 */
public class BESplitPaneUI  extends BasicSplitPaneUI
{
    
    /**
     * Instantiates a new bE split pane ui.
     */
    public BESplitPaneUI() 
    {
    	super();
    }

    /**
     * Creates a new BESplitPaneUI instance.
     *
     * @param x the x
     * @return the component ui
     */
    public static ComponentUI createUI(JComponent x) 
    {
    	return new BESplitPaneUI();
    }

    /**
     * Creates the default divider.
     *
     * @return the basic split pane divider
     */
    public BasicSplitPaneDivider createDefaultDivider() 
    {
    	return new BESplitPaneDivider(this);
    }
}
