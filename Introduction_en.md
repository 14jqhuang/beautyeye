### Step 1:How to start？ ###

File **`beautyeye_lnf.jar`** should go under YOUR\_PROJECT/lib and added to build path.<br>
Notes: <b><code>beautyeye_lnf.jar</code></b> is located <code>all_in_on/dist/</code> which place all_in_one.zip to unpack<br>
<br>
<br>
<h3>Step 2:How to use BeautyEye L&F in my code？</h3>

<font color='#2A779D'>Add the following code to your Java project,the GUI look and feel styles will replaced the  BeautyEye L&F:</font>
<pre><code>public static void main(String[] args)<br>
{<br>
    try<br>
    {<br>
        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();<br>
    }<br>
    catch(Exception e)<br>
    {<br>
        //TODO exception<br>
    }<br>
    ..................... your code .........................<br>
    ..................... your code .........................<br>
}<br>
</code></pre>

<br>
<hr />

<h3>Appendix 1:Method to setting frame window border style.</h3>

<pre><code>public static void main(String[] args)<br>
{<br>
    try<br>
    {<br>
        //frame window border style here<br>
        BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;<br>
        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();<br>
    }<br>
    catch(Exception e)<br>
    {<br>
        //TODO exception<br>
    }<br>
    ..................... your code .........................<br>
    ..................... your code .........................<br>
}<br>
</code></pre>

<h3>Appendix 2:Frame window border style list.</h3>

<table><thead><th> <b>#</b> </th><th> <b>Border style</b> </th><th> <b>code</b> </th><th> <b>BeautyEye test on jdk</b> </th><th> <b>Screenshot</b> </th></thead><tbody>
<tr><td> 1        </td><td> System default      </td><td> <code>FrameBorderStyle.osLookAndFeelDecorated</code> </td><td>                              </td><td> <img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/screenshots/x3.png' /> </td></tr>
<tr><td> 2        </td><td> Powerful modeling translucence border </td><td> <code>FrameBorderStyle.translucencyAppleLike</code> </td><td> java1.6.0_u10 or higher      </td><td> <img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/screenshots/x4.png' /> </td></tr>
<tr><td> 3        </td><td> Weak modeling translucence border </td><td> <code>FrameBorderStyle.translucencySmallShadow</code> </td><td>                              </td><td> <img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/screenshots/x1.png' /> </td></tr>
<tr><td> 4        </td><td> Nomarl opacity border </td><td> <code>FrameBorderStyle.generalNoTranslucencyShadow</code> </td><td> java1.5                      </td><td> <img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/screenshots/x2.png' /> </td></tr></tbody></table>

<h3>Appendix 3：How to use different color buttons？</h3>

<table><thead><th> <b>No</b> </th><th> <b>Code</b> </th><th> <b>Default in BeautyEye</b> </th><th> <b>Effect</b> </th></thead><tbody>
<tr><td> 1         </td><td>  <code>btnInstance.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.normal));</code> </td><td> YES                         </td><td> <img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/screenshots/btn2.png' /> </td></tr>
<tr><td> 2         </td><td>  <code>btnInstance.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));</code> </td><td>                             </td><td> <img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/screenshots/btn1.png' /> </td></tr>
<tr><td> 3         </td><td>  <code>btnInstance.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));</code> </td><td>                             </td><td> <img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/screenshots/btn3.png' /> </td></tr>
<tr><td> 4         </td><td>  <code>btnInstance.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.blue));</code> </td><td>                             </td><td> <img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/screenshots/btn4.png' /> </td></tr>
<tr><td> 5         </td><td>  <code>btnInstance.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));</code> </td><td>                             </td><td> <img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/screenshots/btn5.png' /> </td></tr></tbody></table>

<h3>Appendix 4：How to hide “设置” button？</h3>

<img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/screenshots/y1.png' />

<b>Note：</b> This button is only as a demo window title button ability of custom now,the future will open the custom function,you can choose hide it now.<br>
<pre><code>    UIManager.put("RootPane.setupButtonVisible", false);<br>
</code></pre>

<h3>Appendix 5：How to open/close the translucent effect when window inactive？</h3>

<b><code>@since v3.2</code></b>

<pre><code>//Set this switch is "false"，is means close it. It's default "true" in BeautyEye LNF.<br>
BeautyEyeLNFHelper.translucencyAtFrameInactive = false;<br>
</code></pre>

<h3>Appendix 6：How to keep the JToolBar UI using conventional solid color to fill the background and never use gradient images？</h3>

<b><code>@since v3.4</code></b>

<img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/screenshots/toolbar_bg_paint_contrast.png' />

<b>Method 1：</b>
<pre><code>//Set properties："true" means used "ToolBar.background" corol fill the background<br>
//This is "false" in BeautyEye's default setting.<br>
UIManager.put("ToolBar.isPaintPlainBackground", Boolean.TRUE);<br>
</code></pre>

<b>Method 2：</b>
<pre><code>//Use ClientProperty Separate settings control every toolbar："true"means use ToolBar.background<br>
//This is "false" in BeautyEye's default setting.<br>
toolbarInstance.putClientProperty("ToolBar.isPaintPlainBackground", Boolean.TRUE);<br>
</code></pre>

<b>Note:</b> Method 2 can control every JToolBar component,but Method 1 Is global properties,Method 2's priority is higher than Method 1.<br>
<br>
<h3>Appendix 7：How to define JToolBar ui's border？</h3>

<b><code>@since v3.4</code></b>

Put in the following code to use your own border：<br>
<pre><code>//Custom JToolBar ui's border<br>
Border bd = new org.jb2011.lnf.beautyeye.ch8_toolbar.BEToolBarUI.ToolBarBorder(<br>
        UIManager.getColor("ToolBar.shadow")     //When Floatable contact's color<br>
        , UIManager.getColor("ToolBar.highlight")//When Floatable contact's shadow color<br>
        , new Insets(6, 0, 11, 0));              //Border's default insets<br>
UIManager.put("ToolBar.border",new BorderUIResource(bd));<br>
</code></pre>

<b>Note:</b> The abover code must be follow “<code>BeautyEyeLNFHelper.launchBeautyEyeLNF();</code>”so that can work well.<br>
<br>
<br>
<br>
<h3>Appendix 8：How to set JTabbedPane's left indent in BeantuEye？</h3>

<img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/screenshots/tab_indent_desc_pic.png' />

You can easy to realize by following codes：<br>
<pre><code>//Change InsetsUIResource's parameters can realize<br>
UIManager.put("TabbedPane.tabAreaInsets"<br>
	, new javax.swing.plaf.InsetsUIResource(3,20,2,20));<br>
</code></pre>

<b>Note:</b> The abover code must be follow “<code>BeautyEyeLNFHelper.launchBeautyEyeLNF();</code>”so that can work well.<br>
<br>
<h3>Appendix 9：How to set background transparent and completely hide the title bar for a frame？</h3>

<img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/screenshots/help_about_trasparent.png' />

Transfer the following code before you frame has be setVisible(true)：<br>
<pre><code>// set frame full transparent<br>
frame.setUndecorated(true);<br>
AWTUtilities.setWindowOpaque(frame, false);<br>
frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);<br>
</code></pre>

<b>NOte:</b> The abover code apply to all frame'title include official MetalLookAndFeel<br>
<blockquote>except system's.</blockquote>

<br>
<hr />

<h3>Appendix 10：API Document</h3>

<a href='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/doc/api_doc/index.html'>Online reading</a> or  <a href='http://code.google.com/p/beautyeye/downloads/list'>Download all_in_one</a>

<h3>Appendix 11：Why can't use BeautyEye L&F to make the window transparent with java1.6.0_10 or update 11 versions？</h3>
Because this versions has a Bug,concreteness:<a href='https://code.google.com/p/beautyeye/wiki/java_1_6_0_u10_BUG_6750920'>Look at here</a>.<br>
<br>
<h3>Appendix 12：Specification for text font breezing problem on some Java version of Windows 7</h3>
Please specific look at <a href='https://code.google.com/p/beautyeye/issues/detail?id=25'>issue 25</a>

<b>Solution：</b>
Change the default font to Microsoft Accor black (win7's default font),The font effect will be greatly improved.<br>
<pre><code>/**The key be related to font of UIManager's UI */<br>
public static String[] DEFAULT_FONT  = new String[]{<br>
	"Table.font"<br>
	,"TableHeader.font"<br>
	,"CheckBox.font"<br>
	,"Tree.font"<br>
	,"Viewport.font"<br>
	,"ProgressBar.font"<br>
	,"RadioButtonMenuItem.font"<br>
	,"ToolBar.font"<br>
	,"ColorChooser.font"<br>
	,"ToggleButton.font"<br>
	,"Panel.font"<br>
	,"TextArea.font"<br>
	,"Menu.font"<br>
	,"TableHeader.font"<br>
	// ,"TextField.font"<br>
	,"OptionPane.font"<br>
	,"MenuBar.font"<br>
	,"Button.font"<br>
	,"Label.font"<br>
	,"PasswordField.font"<br>
	,"ScrollPane.font"<br>
	,"MenuItem.font"<br>
	,"ToolTip.font"<br>
	,"List.font"<br>
	,"EditorPane.font"<br>
	,"Table.font"<br>
	,"TabbedPane.font"<br>
	,"RadioButton.font"<br>
	,"CheckBoxMenuItem.font"<br>
	,"TextPane.font"<br>
	,"PopupMenu.font"<br>
	,"TitledBorder.font"<br>
	,"ComboBox.font" <br>
};<br>
</code></pre>
<pre><code>// Change default font.<br>
for (int i = 0; i &lt; SwingUtils.DEFAULT_FONT.length; i++)<br>
	UIManager.put(SwingUtils.DEFAULT_FONT[i],new Font("微软雅黑", Font.PLAIN,14));<br>
</code></pre>

<h3>Appendix 13：Specification for window's contentPane become transparent by uesed BeautyEye</h3>

First of all declare,this is not BeautyEye's bug，actually this is official's Window Transparency come true,JFrame(include JDialog)'scontentPane actually is JPanel,it is considered be a part of window，it has be transparented when other component be transparented by official's Window Transparency API（I did not see the source code,it is not exactly now.）.But it is reasonable,because it will be able to make transparent you also have never thought of the scene.<br>
<br>
<b>Solution：</b> Add a new JPanel on contentPane.