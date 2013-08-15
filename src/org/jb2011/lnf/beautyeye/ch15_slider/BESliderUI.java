/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BESliderUI.java at 2012-9-24 17:21:57, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch15_slider;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSliderUI;

import org.jb2011.lnf.beautyeye.utils.BEUtils;

// TODO: Auto-generated Javadoc
/**
 * JSlider��uiʵ���ࡣ.
 *
 * @author Jack Jiang(jb2011@163.com)
 * @version 1.0
 */
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� Start
//�����ʵ�ֲο���WindowsComboBoxUI
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% һЩ˵�� END
public class BESliderUI extends BasicSliderUI
{
	
	/** ˮƽSlider��Thumb�߶�. */
	protected final int THUMB_HEIGHT_HORIZONAL = 7;// TODO �����Կ���ȡΪUi���ԣ������Ժ����ã���СӦ��NPͼ����С�߶ȣ����ֵ�ÿ�JSlider�ĸ߶��ˣ�
	
	/** ��ֱSlider��Thumb���. */
	protected final int THUMB_WIDTH_VERTICAL = 7;// TODO �����Կ���ȡΪUi���ԣ������Ժ����ã���СӦ��NPͼ����С�߶ȣ����ֵ�ÿ�JSlider�ĸ߶��ˣ�
	
	/**
	 * Instantiates a new bE slider ui.
	 *
	 * @param b the b
	 */
	public BESliderUI(JSlider b){
		super(b);
	}

	/**
	 * Creates the ui.
	 *
	 * @param b the b
	 * @return the component ui
	 */
	public static ComponentUI createUI(JComponent b) {
		return new BESliderUI((JSlider)b);
	}
	
	//copy from BasicSliderUI and modified by jb2011
    /* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicSliderUI#paintTrack(java.awt.Graphics)
	 */
	public void paintTrack(Graphics g)  {        
        Rectangle trackBounds = trackRect;
        if ( slider.getOrientation() == JSlider.HORIZONTAL ) 
        {
            int cy = (trackBounds.height / 2) - 2;
            int cw = trackBounds.width;

            g.translate(trackBounds.x, trackBounds.y + cy);
//            g.setColor(getShadowColor());
//            g.drawLine(0, 0, cw - 1, 0);
//            g.drawLine(0, 1, 0, 2);
//            g.setColor(getHighlightColor());
//            g.drawLine(0, 3, cw, 3);
//            g.drawLine(cw, 0, cw, 3);
//            g.setColor(Color.black);
//            g.drawLine(1, 1, cw-2, 1);
            
            if(slider.isEnabled())
            {
            	//�������
            	__Icon9Factory__.getInstance().getSliderTrack()
            		.draw((Graphics2D)g, 0,0, cw, THUMB_HEIGHT_HORIZONAL);
            	//�������䵽��ǰ�̶�ֵ����
            	__Icon9Factory__.getInstance().getSliderTrack_forground()
        			.draw((Graphics2D)g, 0,0, thumbRect.x, THUMB_HEIGHT_HORIZONAL);
            }
            else
            {
            	//�������
            	__Icon9Factory__.getInstance().getSliderTrack_disable()
        			.draw((Graphics2D)g, 0,0, cw, THUMB_HEIGHT_HORIZONAL);
            	//�������䵽��ǰ�̶�ֵ����
            	__Icon9Factory__.getInstance().getSliderTrack_forground_disable()
    				.draw((Graphics2D)g, 0,0, thumbRect.x, THUMB_HEIGHT_HORIZONAL);
            }

            g.translate(-trackBounds.x, -(trackBounds.y + cy));
        }
        else 
        {
            int cx = (trackBounds.width / 2) - 2;
            int ch = trackBounds.height;

            g.translate(trackBounds.x + cx, trackBounds.y);

//            g.setColor(getShadowColor());
//            g.drawLine(0, 0, 0, ch - 1);
//            g.drawLine(1, 0, 2, 0);
//            g.setColor(getHighlightColor());
//            g.drawLine(3, 0, 3, ch);
//            g.drawLine(0, ch, 3, ch);
//            g.setColor(Color.black);
//            g.drawLine(1, 1, 1, ch-2);
            
            if(slider.isEnabled())
            {
            	//�������
            	__Icon9Factory__.getInstance().getSliderTrack_VERITICAL()
        			.draw((Graphics2D)g, 0,0, THUMB_WIDTH_VERTICAL, ch);
            	//�������䵽��ǰ�̶�ֵ����
            	// TODO BUG����ǰ�и�bug������SwingSets2��ʾ�У���thumb�߶Ƚ�Сʱ�������Բ�α�����������ܸ�����thumbRect�м����в��Yͬ����ʱ�����о��ɣ��ٷ��Ժ�汾�����ܽ��Ŷ
            	__Icon9Factory__.getInstance().getSliderTrack_VERTICAL_forground()
    				.draw((Graphics2D)g, 0,thumbRect.y, THUMB_WIDTH_VERTICAL, ch - thumbRect.y);
            }
            else
            {
            	//�������
            	__Icon9Factory__.getInstance().getSliderTrack_VERITICAL_disable()
    			.draw((Graphics2D)g, 0,0, THUMB_WIDTH_VERTICAL, ch);
            	//�������䵽��ǰ�̶�ֵ����
            	__Icon9Factory__.getInstance().getSliderTrack_VERTICAL_forground_disable()
    				.draw((Graphics2D)g, 0,thumbRect.y, THUMB_WIDTH_VERTICAL, ch - thumbRect.y);
            }
            
            g.translate(-(trackBounds.x + cx), -trackBounds.y);
        }
    }
    
    /* (non-Javadoc)
     * @see javax.swing.plaf.basic.BasicSliderUI#paintFocus(java.awt.Graphics)
     */
    public void paintFocus(Graphics g)  
    {        
    	g.setColor( getFocusColor() );

//    	BasicGraphicsUtils.drawDashedRect( g, focusRect.x, focusRect.y,
//    					   focusRect.width, focusRect.height );
    	BEUtils.drawDashedRect(g, focusRect.x, focusRect.y,
    					   focusRect.width, focusRect.height);
    }

    //copy from BasicSliderUI and modified by jb2011
	/* (non-Javadoc)
     * @see javax.swing.plaf.basic.BasicSliderUI#paintThumb(java.awt.Graphics)
     */
    public void paintThumb(Graphics g)
	{
		Rectangle knobBounds = thumbRect;
		int w = knobBounds.width;
		int h = knobBounds.height;

		g.translate(knobBounds.x, knobBounds.y);
		if (slider.isEnabled())
		{
			g.setColor(slider.getBackground());
		}
		else
		{
			g.setColor(slider.getBackground().darker());
		}

		//* ��4�д��뱻Jack Jiang�������˷��� isPaintArrowThumb()
//		Boolean paintThumbArrowShape = (Boolean) slider
//				.getClientProperty("Slider.paintThumbArrowShape");
//		if ((!slider.getPaintTicks() && paintThumbArrowShape == null)
//				|| paintThumbArrowShape == Boolean.FALSE)
		if(isPaintNoTrangleThumb())
		{
			if(slider.getOrientation() == JSlider.HORIZONTAL)
				g.drawImage(
						slider.isEnabled()?__IconFactory__.getInstance().getSliderTick1_notrangle().getImage()
								:__IconFactory__.getInstance().getSliderTick1_notrangle_disable().getImage()
					, 0, 0, null);
			else
				g.drawImage(slider.isEnabled()?__IconFactory__.getInstance().getSliderTick1_notrangle_vertical().getImage()
						:__IconFactory__.getInstance().getSliderTick1_notrangle_VERTICAL_disable().getImage()
						, 0, 0, null);
		}
		else if (slider.getOrientation() == JSlider.HORIZONTAL)
		{
			g.drawImage(slider.isEnabled()?__IconFactory__.getInstance().getSliderTick1().getImage()
							:__IconFactory__.getInstance().getSliderTick1_disable().getImage()
					, 0, 0, null);
		}
		else
		{ // vertical
			g.drawImage(slider.isEnabled()?__IconFactory__.getInstance().getSliderTick1_vertical().getImage()
							:__IconFactory__.getInstance().getSliderTick1_VERTICAL_disable().getImage()
					, 0, 0, null);
		}

		g.translate(-knobBounds.x, -knobBounds.y);
	}
	
	//* ��������jb2011����
	//��thumb�Ƿ�����3�Ǽ�ͷ����ʽ��true��ʾ��3���ͷ����Բ��thumb����false��ʾ��3�Ǽ�ͷ��ʽ
	/**
	 * Checks if is paint no trangle thumb.
	 *
	 * @return true, if is paint no trangle thumb
	 */
	protected boolean isPaintNoTrangleThumb()
	{
		Boolean paintThumbArrowShape = (Boolean) slider
				.getClientProperty("Slider.paintThumbArrowShape");

		//�������м�ͷ��ʶ��thumb��ʽ(����ͨԲ��thumb)
		return (!slider.getPaintTicks() && paintThumbArrowShape == null)
				|| paintThumbArrowShape == Boolean.FALSE;
	}

	//copy from BasicSliderUI and modified by jb2011
	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicSliderUI#getThumbSize()
	 */
	protected Dimension getThumbSize()
	{
		boolean isPaintNoTrangle = isPaintNoTrangleThumb();
		
		Dimension size = new Dimension();
		if (slider.getOrientation() == JSlider.VERTICAL)
		{
			size.width = 17;//20;
			size.height = isPaintNoTrangle?16:12;//14;
		}
		else
		{
			size.width = isPaintNoTrangle?16:12;//14;
			size.height = 17;//20;
		}
		return size;
	}
}

