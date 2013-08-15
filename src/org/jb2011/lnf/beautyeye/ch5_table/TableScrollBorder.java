/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * TableScrollBorder.java at 2012-9-24 17:22:40, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch5_table;

import java.awt.Insets;

import org.jb2011.lnf.beautyeye.widget.border.NinePatchBorder;

// TODO: Auto-generated Javadoc
/**
 * 表格UI所在滚动条的边框实现类.
 * 
 * @author Jack Jiang(jb2011@163.com), 2012-08-30
 * @version 1.0
 */
class TableScrollBorder extends NinePatchBorder
{
	
	/**
	 * Instantiates a new table scroll border.
	 */
	public TableScrollBorder()
	{
		super(new Insets(3, 5, 10, 5)//3, 2, 5, 2
				, org.jb2011.lnf.beautyeye.ch5_table.__Icon9Factory__.getInstance().getTableScrollBorder1());
	}
}
