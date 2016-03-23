### 第一步：如何开始？ ###

首先把 **`beautyeye_lnf.jar`** 文件作为lib放入你的项目并引用之.<br>
目前，<b><code>beautyeye_lnf.jar</code></b> 文件位于all_in_one.zip包中的位置是：<code>all_in_one/dist/</code>


<h3>第二步：如何使用BeautyEye L&F？</h3>

<font color='#2A779D'>加入以下代码，即可将你的Java程序界面更换成Beauty Eye的外观：</font>
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
    ..................... 你的程序代码 .........................<br>
    ..................... 你的程序代码 .........................<br>
}<br>
</code></pre>

<br>
<hr />

<h3>[附录1]：如何定义窗口边框类型？</h3>

<pre><code>public static void main(String[] args)<br>
{<br>
    try<br>
    {<br>
        //设置本属性将改变窗口边框样式定义<br>
        BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;<br>
        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();<br>
    }<br>
    catch(Exception e)<br>
    {<br>
        //TODO exception<br>
    }<br>
    ..................... 你的程序代码 .........................<br>
    ..................... 你的程序代码 .........................<br>
}<br>
</code></pre>

<h3>[附录2]：有几种窗口边框类型？</h3>

<table><thead><th> <b>序号</b> </th><th> <b>窗口边框尖型</b> </th><th> <b>代码</b> </th><th> <b>BeautyEye中默认使用</b> </th><th> <b>效果图</b> </th></thead><tbody>
<tr><td> 1         </td><td> 系统默认边框        </td><td> <code>FrameBorderStyle.osLookAndFeelDecorated</code> </td><td>                       </td><td> <img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/screenshots/x3.png' /> </td></tr>
<tr><td> 2         </td><td> 强立体感半透明边框     </td><td> <code>FrameBorderStyle.translucencyAppleLike</code> </td><td> java1.6.0_u10及更高版本时   </td><td> <img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/screenshots/x4.png' /> </td></tr>
<tr><td> 3         </td><td> 弱立体感半透明边框     </td><td> <code>FrameBorderStyle.translucencySmallShadow</code> </td><td>                       </td><td> <img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/screenshots/x1.png' /> </td></tr>
<tr><td> 4         </td><td> 普通不透明边框       </td><td> <code>FrameBorderStyle.generalNoTranslucencyShadow</code> </td><td> java1.5版本时            </td><td> <img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/screenshots/x2.png' /> </td></tr></tbody></table>

<h3>[附录3]：如何使用不同颜色的按钮？</h3>

<table><thead><th> <b>序号</b> </th><th> <b>代码</b> </th><th> <b>BeautyEye中默认</b> </th><th> <b>效果图</b> </th></thead><tbody>
<tr><td> 1         </td><td>  <code>btnInstance.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.normal));</code> </td><td> YES                 </td><td> <img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/screenshots/btn2.png' /> </td></tr>
<tr><td> 2         </td><td>  <code>btnInstance.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));</code> </td><td>                     </td><td> <img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/screenshots/btn1.png' /> </td></tr>
<tr><td> 3         </td><td>  <code>btnInstance.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));</code> </td><td>                     </td><td> <img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/screenshots/btn3.png' /> </td></tr>
<tr><td> 4         </td><td>  <code>btnInstance.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.blue));</code> </td><td>                     </td><td> <img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/screenshots/btn4.png' /> </td></tr>
<tr><td> 5         </td><td>  <code>btnInstance.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));</code> </td><td>                     </td><td> <img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/screenshots/btn5.png' /> </td></tr></tbody></table>

<h3>[附录4]：如何隐藏“设置”按钮？</h3>

<img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/screenshots/y1.png' />

<b>说明：</b> 该按钮目前仅作为演示窗口标题按钮的自定义能力之用，未来将开放自定义功能，目前你可选择隐藏之。<br>
<pre><code>    UIManager.put("RootPane.setupButtonVisible", false);<br>
</code></pre>

<h3>[附录5]：如何开启/关闭窗口在不活动时的半透明效果？</h3>

<b><code>@since v3.2</code></b>

<pre><code>//设置此开关量为false即表示关闭之，BeautyEye LNF中默认是true<br>
BeautyEyeLNFHelper.translucencyAtFrameInactive = false;<br>
</code></pre>

<h3>[附录6]：怎样让JToolBar的ui不使用渐变图片而使用传统的纯色来填充背景？</h3>

<b><code>@since v3.4</code></b>

<img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/screenshots/toolbar_bg_paint_contrast.png' />

<b>方法1：</b>
<pre><code>//设置属性即可：true表示使用ToolBar.background颜色实现纯<br>
//色填充背景，BeautyEye中此属性默认是false<br>
UIManager.put("ToolBar.isPaintPlainBackground", Boolean.TRUE);<br>
</code></pre>

<b>方法2：</b>
<pre><code>//使用ClientProperty单独设置控制每个toolbar：true表示使用ToolBar.background<br>
//颜色实现纯色填充背景，BeautyEye中此属性默认是false<br>
toolbarInstance.putClientProperty("ToolBar.isPaintPlainBackground", Boolean.TRUE);<br>
</code></pre>

<b>说明:</b> 方法2可以单独控制每一个JToolBar组件，而方法1是全局属性，方法2的优先级高于方法1。<br>
<br>
<h3>[附录7]：如何自定义JToolBar ui的border？</h3>

<b><code>@since v3.4</code></b>

加入以下代码，使用你自已的border：<br>
<pre><code>//自定义JToolBar ui的border<br>
Border bd = new org.jb2011.lnf.beautyeye.ch8_toolbar.BEToolBarUI.ToolBarBorder(<br>
        UIManager.getColor("ToolBar.shadow")     //Floatable时触点的颜色<br>
        , UIManager.getColor("ToolBar.highlight")//Floatable时触点的阴影颜色<br>
        , new Insets(6, 0, 11, 0));              //border的默认insets<br>
UIManager.put("ToolBar.border",new BorderUIResource(bd));<br>
</code></pre>

<b>说明:</b> 以上代码必须在 “<code>BeautyEyeLNFHelper.launchBeautyEyeLNF();</code>” 之后执行方能起效哦。<br>
<br>
<h3>[附录8]：如何设置BeantuEye外观下JTabbedPane的左缩进？</h3>

<img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/screenshots/tab_indent_desc_pic.png' />

参见以下代码实现：<br>
<pre><code>//改变InsetsUIResource参数的值即可实现<br>
UIManager.put("TabbedPane.tabAreaInsets"<br>
	, new javax.swing.plaf.InsetsUIResource(3,20,2,20));<br>
</code></pre>

<b>说明:</b> 以上代码必须在 “<code>BeautyEyeLNFHelper.launchBeautyEyeLNF();</code>” 之后执行方能起效哦。<br>
<br>
<h3>[附录9]：如何调置窗体背景全透明并完全隐藏一个窗体的标题栏？</h3>

<img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/screenshots/help_about_trasparent.png' />

在你的窗体被setVisible(true)前调用以下代码即可：<br>
<pre><code>// set frame full transparent<br>
frame.setUndecorated(true);<br>
AWTUtilities.setWindowOpaque(frame, false);<br>
frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);<br>
</code></pre>

<b>说明:</b> 以上代码适用于所有处于非系统窗体标题栏的情况，包括官方MetalLookAndFeel外观等。<br>
<br>
<h3>[附录10]：如何解决切换输入法导致白屏的问题？</h3>

<b>说明:</b> 切换输入法导致白屏问题是由于官方的透明API的bug引起，与BeautyEye本身无关。<br>
<br>
解决方法参见：<br>
<a href='http://hi.baidu.com/shenaodong/item/423419d57354feea55347fe5'>http://hi.baidu.com/shenaodong/item/423419d57354feea55347fe5</a>
或者<br>
<a href='http://stackoverflow.com/questions/14374111/input-method-removes-transparent-effect-from-jframe-in-swing'>http://stackoverflow.com/questions/14374111/input-method-removes-transparent-effect-from-jframe-in-swing</a>

<br>
<hr />

<h3>附录11：API文档</h3>

<a href='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/doc/api_doc/index.html'>在线阅读</a> or  <a href='http://code.google.com/p/beautyeye/downloads/list'>下载all_in_one包</a>

<h3>附录12：为何java1.6.0_10或update 11版不能启用BeautyEye L&F的窗口透明？</h3>
因为该版本存在一个Bug，具体<a href='https://code.google.com/p/beautyeye/wiki/java_1_6_0_u10_BUG_6750920'>请看这里</a>.<br>
<br>
<h3>附录13：关于win7平台下某些java版本上的文本字体发虚的问题说明</h3>
该问题具体请参见 <a href='https://code.google.com/p/beautyeye/issues/detail?id=25'>issue 25</a>

<b>解决方案：</b>
把默认的字体换成win7平台下默认的微软雅黑，则字体效果会大有改善。<br>
<pre><code>/** UIManager中UI字体相关的key */<br>
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
<pre><code>// 调整默认字体<br>
for (int i = 0; i &lt; DEFAULT_FONT.length; i++)<br>
	UIManager.put(DEFAULT_FONT[i],new Font("微软雅黑", Font.PLAIN,14));<br>
</code></pre>

<h3>附录14：关于使用了BeautyEye后窗口的contentPane变成全透明的说明</h3>

首先申明这不是BeautyEye的bug，这其实是官方窗口透明API的实现，JFrame（包括JDialog）的contentPane实质就是JPanel，它被认为是窗口的一部分，官方窗口透明API在透明窗口其它部件的同时也把它透明了（我没看过源码，目前还不能确切的说），但这是合理的，因为它将能实现你还没想到的全透明场景。<br>
<br>
<b>解决办法：</b> 在contentPane上再加一层JPanel即可。