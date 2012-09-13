/*
 * @(#)ListDemo.java	1.17 05/11/17
 * 
 * Copyright (c) 2006 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * -Redistribution of source code must retain the above copyright notice, this
 *  list of conditions and the following disclaimer.
 * 
 * -Redistribution in binary form must reproduce the above copyright notice, 
 *  this list of conditions and the following disclaimer in the documentation
 *  and/or other materials provided with the distribution.
 * 
 * Neither the name of Sun Microsystems, Inc. or the names of contributors may 
 * be used to endorse or promote products derived from this software without 
 * specific prior written permission.
 * 
 * This software is provided "AS IS," without a warranty of any kind. ALL 
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING
 * ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
 * OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN MIDROSYSTEMS, INC. ("SUN")
 * AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE
 * AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 * DERIVATIVES. IN NO EVENT WILL SUN OR ITS LICENSORS BE LIABLE FOR ANY LOST 
 * REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL, 
 * INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY 
 * OF LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE THIS SOFTWARE, 
 * EVEN IF SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 * 
 * You acknowledge that this software is not designed, licensed or intended
 * for use in the design, construction, operation or maintenance of any
 * nuclear facility.
 */

/*
 * @(#)ListDemo.java	1.17 05/11/17
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.AbstractListModel;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jb2011.lnf.beautyeye.widget.N9ComponentFactory;

/**
 * List Demo. This demo shows that it is not
 * always necessary to have an array of objects
 * as big as the size of the list stored.
 *
 * Indeed, in this example, there is no array
 * kept for the list data, rather it is generated
 * on the fly as only those elements are needed.
 *
 * @version 1.17 11/17/05
 * @author Jeff Dinkins
 */
public class ListDemo extends DemoModule {
    JList list;

    JPanel prefixList;
    JPanel suffixList;

    Action prefixAction;
    Action suffixAction;

    GeneratedListModel listModel;

    Vector checkboxes = new Vector();

    /**
     * main method allows us to run as a standalone demo.
     */
    public static void main(String[] args) {
	ListDemo demo = new ListDemo(null);
	demo.mainImpl();
    }
    
    @Override public String getName() {
    	return "列表";
    };

    /**
     * ListDemo Constructor
     */
    public ListDemo(SwingSet2 swingset) {
	super(swingset, "ListDemo"
			, "toolbar/JList.gif");

	loadImages();

	//modified by jb2011
	JLabel description = N9ComponentFactory.createLabel_style2(getString("ListDemo.description"));
	getDemoPanel().add(description, BorderLayout.NORTH);
	JPanel centerPanel = new JPanel();
	centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));
	centerPanel.add(Box.createRigidArea(HGAP10));
	getDemoPanel().add(centerPanel, BorderLayout.CENTER);

	JPanel listPanel = new JPanel();
	listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
	listPanel.add(Box.createRigidArea(VGAP10));

	centerPanel.add(listPanel);
	centerPanel.add(Box.createRigidArea(HGAP30));

	// Create the list
	list = new JList();
	//* 由jb2011注释掉，以便测试Ui里的通用renderer
//	list.setCellRenderer(new CompanyLogoListCellRenderer());
	listModel = new GeneratedListModel(this);
	list.setModel(listModel);
        
	// Set the preferred row count. This affects the preferredSize
	// of the JList when it's in a scrollpane.
	list.setVisibleRowCount(22);

	// Add list to a scrollpane
	JScrollPane scrollPane = new JScrollPane(list);
	listPanel.add(scrollPane);
	listPanel.add(Box.createRigidArea(VGAP10));

	// Add the control panel (holds the prefix/suffix list and prefix/suffix checkboxes)
	centerPanel.add(createControlPanel());

	// create prefixes and suffixes
	addPrefix("Tera", true);  
	addPrefix("Micro", false);     
	addPrefix("Southern", false);       
	addPrefix("Net", true);   
	addPrefix("YoYo", true);       
	addPrefix("Northern", false);       
	addPrefix("Tele", false); 
	addPrefix("Eastern", false);   
	addPrefix("Neo", false);            
	addPrefix("Digi", false); 
	addPrefix("National", false);  
	addPrefix("Compu", true);          
	addPrefix("Meta", true);  
	addPrefix("Info", false);      
	addPrefix("Western", false);        
	addPrefix("Data", false); 
	addPrefix("Atlantic", false); 
	addPrefix("Advanced", false);        
	addPrefix("Euro", false);      
	addPrefix("Pacific", false);   
	addPrefix("Mobile", false);       
	addPrefix("In", false);        
	addPrefix("Computa", false);          
	addPrefix("Digital", false);   
	addPrefix("Analog", false);       

	addSuffix("Tech", true);      
	addSuffix("Soft", true);      
	addSuffix("Telecom", true);
	addSuffix("Solutions", false); 
	addSuffix("Works", true);     
	addSuffix("Dyne", false);
	addSuffix("Services", false);  
	addSuffix("Vers", false);      
	addSuffix("Devices", false);
	addSuffix("Software", false);  
	addSuffix("Serv", false);      
	addSuffix("Systems", true);
	addSuffix("Dynamics", true);  
	addSuffix("Net", false);       
	addSuffix("Sys", false);
	addSuffix("Computing", false); 
	addSuffix("Scape", false);     
	addSuffix("Com", false);
	addSuffix("Ware", false);      
	addSuffix("Widgets", false);   
	addSuffix("Media", false);     
	addSuffix("Computer", false);
	addSuffix("Hardware", false);  
	addSuffix("Gizmos", false);    
	addSuffix("Concepts", false);
    }

    void updateDragEnabled(boolean dragEnabled) {
        list.setDragEnabled(dragEnabled);
    }

    public JPanel createControlPanel() {
	JPanel controlPanel = new JPanel() {
	    Insets insets = new Insets(0, 4, 10, 10);
	    public Insets getInsets() {
		return insets;
	    }
	};
	controlPanel.setOpaque(false);//* add by jb2011
	controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));

	JPanel prefixPanel = new JPanel();
	prefixPanel.setLayout(new BoxLayout(prefixPanel, BoxLayout.Y_AXIS));
	
	//* modified by jb2011：改成一个灰色圆色背景的label
	//prefixPanel.add(new JLabel(getString("ListDemo.prefixes")));
	prefixPanel.add(N9ComponentFactory.createLabel_style4(" "+getString("ListDemo.prefixes")+" "));

	JPanel suffixPanel = new JPanel();
	suffixPanel.setLayout(new BoxLayout(suffixPanel, BoxLayout.Y_AXIS));
	//* modified by jb2011：改成一个灰色圆色背景的label
	//prefixPanel.add(new JLabel(getString("ListDemo.suffixes")));
	suffixPanel.add(N9ComponentFactory.createLabel_style4(" "+getString("ListDemo.suffixes")+" "));

	prefixList = new JPanel() {
	    Insets insets = new Insets(0, 2, 0, 0);
	    public Insets getInsets() {
		return insets;
	    }
	};
	prefixList.setBackground(Color.white);//* add by jb2011
	prefixList.setLayout(new BoxLayout(prefixList, BoxLayout.Y_AXIS));
	JScrollPane scrollPane = new JScrollPane(prefixList);
    scrollPane.getVerticalScrollBar().setUnitIncrement(10);
    prefixPanel.add(Box.createRigidArea(HGAP5));//* add by jb2011
	prefixPanel.add(scrollPane);
	prefixPanel.add(Box.createRigidArea(HGAP10));

	suffixList = new JPanel() {
	    Insets insets = new Insets(0, 2, 0, 0);
	    public Insets getInsets() {
		return insets;
	    }
	};
	suffixList.setBackground(Color.white);//* add by jb2011
	suffixList.setLayout(new BoxLayout(suffixList, BoxLayout.Y_AXIS));
	scrollPane = new JScrollPane(suffixList);
    scrollPane.getVerticalScrollBar().setUnitIncrement(10);
    suffixPanel.add(Box.createRigidArea(HGAP5));//* add by jb2011
	suffixPanel.add(scrollPane);
	suffixPanel.add(Box.createRigidArea(HGAP10));

	controlPanel.add(prefixPanel);
	controlPanel.add(Box.createRigidArea(HGAP15));
	controlPanel.add(suffixPanel);
	
	return controlPanel;
    }
    
    private FocusListener listFocusListener = new FocusAdapter() { 
        public void focusGained(FocusEvent e) {
            JComponent c = (JComponent)e.getComponent();
            c.scrollRectToVisible(new Rectangle(0, 0, c.getWidth(), c.getHeight())); 
        }
    };

    public void addPrefix(String prefix, boolean selected) {
	if(prefixAction == null) {
	    prefixAction = new UpdatePrefixListAction(listModel);
	}
	final JCheckBox cb = (JCheckBox) prefixList.add(new JCheckBox(prefix));
	cb.setOpaque(false);//* add by jb2011
	checkboxes.addElement(cb);
	cb.setSelected(selected);
	cb.addActionListener(prefixAction);
	if(selected) {
	    listModel.addPrefix(prefix);
	}
        cb.addFocusListener(listFocusListener);
    }

    public void addSuffix(String suffix, boolean selected) {
	if(suffixAction == null) {
	    suffixAction = new UpdateSuffixListAction(listModel);
	}
	final JCheckBox cb = (JCheckBox) suffixList.add(new JCheckBox(suffix));
	cb.setOpaque(false);//* add by jb2011
	checkboxes.addElement(cb);
	cb.setSelected(selected);
	cb.addActionListener(suffixAction);
	if(selected) {
	    listModel.addSuffix(suffix);
	}
        cb.addFocusListener(listFocusListener);
    }

    class UpdatePrefixListAction extends AbstractAction {
	GeneratedListModel listModel;
        protected UpdatePrefixListAction(GeneratedListModel listModel) {
	    this.listModel = listModel;
        }
	
        public void actionPerformed(ActionEvent e) {
	    JCheckBox cb = (JCheckBox) e.getSource();
	    if(cb.isSelected()) {
		listModel.addPrefix(cb.getText());
	    } else {
		listModel.removePrefix(cb.getText());
	    }
	}
    }

    class UpdateSuffixListAction extends AbstractAction {
	GeneratedListModel listModel;
        protected UpdateSuffixListAction(GeneratedListModel listModel) {
	    this.listModel = listModel;
        }
	
        public void actionPerformed(ActionEvent e) {
	    JCheckBox cb = (JCheckBox) e.getSource();
	    if(cb.isSelected()) {
		listModel.addSuffix(cb.getText());
	    } else {
		listModel.removeSuffix(cb.getText());
	    }
	}
    }

    
    class GeneratedListModel extends AbstractListModel {
	ListDemo demo;
	Permuter permuter;

	public Vector prefix = new Vector();
	public Vector suffix = new Vector();

	public GeneratedListModel (ListDemo demo) {
	    this.demo = demo;
	}

	private void update() {
	    permuter = new Permuter(getSize());
	    fireContentsChanged(this, 0, getSize());
	}

	public void addPrefix(String s) {
	    if(!prefix.contains(s)) {
		prefix.addElement(s);
		update();
	    }
	}

	public void removePrefix(String s) {
	    prefix.removeElement(s);
	    update();
	}

	public void addSuffix(String s) {
	    if(!suffix.contains(s)) {
		suffix.addElement(s);
		update();
	    }
	}

	public void removeSuffix(String s) {
	    suffix.removeElement(s);
	    update();
	}

	public int getSize() {
	    return prefix.size() * suffix.size();
	}

	public Object getElementAt(int index) {
	    if(permuter == null) {
		update();
	    }
	    // morph the index to another int -- this has the benefit of
	    // causing the list to look random.
	    int j = permuter.map(index);
	    int ps = prefix.size();
	    int ss = suffix.size();
	    return (String) prefix.elementAt(j%ps) + (String) suffix.elementAt((j/ps)%ss);
	}
    }

    ImageIcon images[] = new ImageIcon[7];
    void loadImages() {
	    images[0] = createImageIcon("list/red.gif",  getString("ListDemo.red"));
	    images[1] = createImageIcon("list/blue.gif",  getString("ListDemo.blue"));
	    images[2] = createImageIcon("list/yellow.gif",  getString("ListDemo.yellow"));
	    images[3] = createImageIcon("list/green.gif",  getString("ListDemo.green"));
	    images[4] = createImageIcon("list/gray.gif",  getString("ListDemo.gray"));
	    images[5] = createImageIcon("list/cyan.gif",  getString("ListDemo.cyan"));
	    images[6] = createImageIcon("list/magenta.gif",  getString("ListDemo.magenta"));
    }

  //* 由jb2011注释掉，以便测试Ui里的通用renderer
//    class CompanyLogoListCellRenderer extends DefaultListCellRenderer {
//       public Component getListCellRendererComponent(
//            JList list,
//            Object value,
//            int index,
//            boolean isSelected,
//            boolean cellHasFocus)
//        {
//            Component retValue = super.getListCellRendererComponent(
//		list, value, index, isSelected, cellHasFocus
// 	    );
//            setIcon(images[index%7]);
//	    return retValue;
//        }
//    }
}
