/*
 * Copyright (C) 2012 - 2012 The BeautyEye Open Source Project
 * Project URL:https://code.google.com/p/beautyeye/
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * BEFileChooserUICross.java at 2012-9-24 17:22:31, original version by Jack Jiang.
 * You can contact original author with jb2011@163.com.
 */
package org.jb2011.lnf.beautyeye.ch20_filechooser;

import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.metal.MetalFileChooserUI;

// TODO: Auto-generated Javadoc
/**
 * BeautyEye L&F implementation of a FileChooser.
 * <p>
 * Ŀǰ��ͨ�ÿ�ƽ̨ר��UIʵ����.
 *
 * @author Jack Jiang(jb2011@163.com), 2012-09-17
 * @version 1.0
 */
public class BEFileChooserUICross extends MetalFileChooserUI 
{
	
	/**
	 * Instantiates a new bE file chooser ui cross.
	 *
	 * @param filechooser the filechooser
	 */
	public BEFileChooserUICross(JFileChooser filechooser)
	{
		super(filechooser);
	}

	//
    // ComponentUI Interface Implementation methods
    //
    /**
	 * Creates the ui.
	 *
	 * @param c the c
	 * @return the component ui
	 */
	public static ComponentUI createUI(JComponent c) 
    {
        return new BEFileChooserUICross((JFileChooser) c);
    }
    
    //* modified by Jack Jiang 2012-09-17
    /**
     * ��д���෽������ʵ�ֶ��ļ��鿴�б�Ķ�������.
     * <p>
     * ΪʲôҪ��д�˷�����û�и��õķ�����<br>
     * ������ķ�װ�ṹ���ѣ�filePane��private˽�У��������޷�ֱ�����ã�
     * Ҫ���filePane�е����б�������ã�Ŀǰ��д�������Ǹ�û�а취�ķ���.
     * <p>
     * sun.swing.FilePaneԴ��ɲ鿴��ַ��<a href="http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/6-b14/sun/swing/FilePane.java">Click here.</a>
     *
     * @param fc the fc
     * @return the j panel
     */
    protected JPanel createList(JFileChooser fc) 
    {
    	JPanel p = super.createList(fc);
    	
    	//* ���´�������þ��ǽ��ļ��б�JList�������ø��һ�����ͨ�������ĸ�����в������������
    	//* �����޷��Ӹ�����ֱ�ӻ���б�����ֱ�����ã�ֻ���ô˱��취��
    	if(p.getComponentCount() > 0)
    	{
    		Component scollPane = p.getComponent(0);
    		if(scollPane != null && scollPane instanceof JScrollPane)
    		{
    			JViewport vp = ((JScrollPane)scollPane).getViewport();
    			if(vp != null)
    			{
    				Component fileListView = vp.getView();
    				//�����ҵ����ļ��б��ʵ������
    				if(fileListView != null && fileListView instanceof JList)
    				{
    					//���б���и߸ĳ�-1�����Զ������б�ÿ����Ԫ���и߶���ָ���̶�ֵ��
    					//* ˵������BeautyEye LNF�У�Ϊ�˱�JList��UI���ÿ�����û������������ǰ
    					//* ���¾���JList��BEListUI�и���������Ĭд�и�32����JFildChooser�е�
    					//* �ļ��б�����˶�ʹ�õ�Ԫ�иߺܴ󡪡��Ӷ������ļ��б���ѿ����˴����ǻָ�
    					//* �ļ��б�Ԫ�иߵ��Զ����㣬����ָ���̶��иߡ�
    					//*
    					//* ˵��2��Ϊʲô��������list.getClientProperty("List.isFileList")�Ӷ���JList
    					//* ��ui�н����жϲ�����Դ��Ƿ����ļ��б��أ�
    					//* ����Ϊ"List.isFileList"����BasicFileChooserUI�����õģ�Ҳ����˵��Ϊ�����Ա�
    					//* ���õ�ʱ��JFileChooser�е��ļ��б��Ѿ�ʵ������ɣ���������ui��ʼ���������Դ�ʱ
    					//* �����JList��ui���������ǲ����ܵģ�������û�б����ã����������Ҫ�ǹ�BasicListUI
    					//* �ڱ�ʵ������ɺ����첽����������Եģ�ͨ���������Ըı��¼���ʵ�ֵģ�
    					((JList)fileListView).setFixedCellHeight(-1);
    				}
    			}
    		}
    	}
    	
        return p;
    }
    
//    //
//    // Renderer for Types ComboBox
//    //
//    protected FilterComboBoxRenderer createFilterComboBoxRenderer() 
//    {
//    	return new BEFilterComboBoxRenderer();
//    }
//    /**
//     * Render different type sizes and styles.
//     */
//    protected class BEFilterComboBoxRenderer extends FilterComboBoxRenderer 
//    {
//    	public BEFilterComboBoxRenderer()
//    	{
//    		super();
//    		
////    		//���ó�͸����������ζ�Ų���Ҫ������䣬�������е�Ӧ�ó����е�����
////            //����Ĭ�ϵ�render��UI�ﲻ��Ҫ���Ʊ���������±���ſɽ���NinePatchͼ��Ϊ�����������
////            setOpaque(false);
//            //TODO ��border��render���ڳģ�������Ϊһ��UIManager������Ŷ�������Ժ�����
//            //ע�����ڳ��Ǿ����б�Ԫ����������ҿհ׵Ĺؼ�Ŷ��
////            setBorder(BorderFactory.createEmptyBorder(5, 8, 5, 8));
//    	}
//    	
//    	//����˵�������е��Ƿ�ѡ�б������ʵ���߼���Render��UI��ʵ����Ϊ����������
//        //������Ǵ�����UIʵ���У��������ײ�����ͻ���ʶ��������Զ���Uiʵ�֣��ɴ�Ӳ�������ֱ��
//        public void paintComponent(Graphics g) 
//        {
//        	//** ��HACK��Ϊ�˽�� Issue 30����JFileChooser�е��ļ�����ѡ���������render
//        	//** ������render�����Զ���ģ�����ʹ�õ�ComboxUI����BE LNF����õ�render��
//        	//** ���µ��Ӿ�Ч�����ѵ�����
//        	//##### HACK��ǿ�аѻ����������ơ����ơ����Ա�ʹ������ߵĿ��۶�һ�㣬Ҫ��Ȼ��̫�ѿ���
//        	g.translate(5, 1);
//        	
//        	//�ճ����ƣ�ֻ��֮ǰ�����걻����һ�¶��ѣ�
//        	super.paintComponent(g);
//        	
//        	//##### HACK���ָ�����
//        	g.translate(-5, -1);
//    	 }
//    }
}
