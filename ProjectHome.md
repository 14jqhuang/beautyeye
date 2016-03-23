<br><br>

<hr />

<h1><font color='#FF0000'>2015-01-30日起本工程已迁移至<a href='https://github.com/JackJiang2011/beautyeye'>Github</a>。</font></h1>

<h1><font color='#FF0000'>Since 2015-01-30, BeautyEye has migrated to <a href='https://github.com/JackJiang2011/beautyeye'>Github</a>.</font></h1>

<hr />
<br><br>

<h1>About BeautyEye</h1>
<table><thead><th>BeautyEye is a Java Swing cross-platform look and feel. Thanks to NinePatch technology, BeautyEye is so different.<br>BeautyEye is free, you can study, learn, even for commercial use. Enjoy it, thanks.</th></thead><tbody></tbody></table>

<h1>Latest Release</h1>

<img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/release_notes/v3.5_release_note.png' />

<h1><font color='#ff0000'>特别说明</font></h1>
各种开发问题及技巧请参见：<a href='http://code.google.com/p/beautyeye/wiki/Introduction'>BeautyEye L&amp;F简明开发者指南</a>。<br>
<br>
另，<font color='#2A779D'>关于“切换输入法导致白屏的问题”请见指南之“附录10”</font>。<br>
<br>
<h1>Compatibility</h1>
BeautyEye 可运行于java 1.5、1.6以及1.7之上，但推荐至少应运行在<a href='http://www.java.com/zh_CN/download/'>java1.6.0_12或更新版本</a><br><font color='#FF6600'>(<a href='https://code.google.com/p/beautyeye/wiki/java_1_6_0_u10_BUG_6750920'>为何java1.6.0_10或u11版不行？</a>)</font>，因为这些版本将能带来窗口透明特性，更重要的是Swing的性能提升。<br>
<br>
另附：<a href='http://code.google.com/p/beautyeye/wiki/Compatibility_test_results'>BeautyEye外观(look and feel)兼容性测试结果</a>.<br>
<br>
<h1>Feature</h1>
<ul>
<li>更好的兼容性，可运行于java 1.5、1.6、1.7，SUN的非公开API被移除？木有关系</li>
<li>遵从当前主流审美，与时俱进</li>
<li>跨平台</li>
<li>使用NinePatch技术，用最少的代码实现最满意的外观，Synth、Nimbus都是浮云</li>
</ul>

<h1>Demos</h1>
<b>提示:</b>  请确保已安装JRE(最低java1.5版)，如需BeautyEye外观支持透明效果，则推荐java1.6.0_12或更新版本<br><font color='#FF6600'>(<a href='https://code.google.com/p/beautyeye/wiki/java_1_6_0_u10_BUG_6750920'>为何java1.6.0_10或u11版不行？</a>)</font>，这些版本才能支持窗口透明特性.<br>
<ul>
<li>
<a href='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/demo/applet/SwingSet2_for_be_lnf.html'>Demo在线加载1</a><i>(applet方式）</i> <font color='#FF6600'>[注：如浏览器不能正常解析，请“另存为...”后本地打开]</font></li>
<li>or<br>
<a href='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/demo/jnlp/launch.jnlp'>Demo在线加载2</a><i>(Java Web Start方式)</i> <font color='#FF6600'>[注：如浏览器不能正常解析，请“另存为...”后本地打开]</font></li>
<li>or<br>
<a href='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/demo/excute_jar/SwingSets2(BeautyEyeLNFDemo).jar'>下载可执行jar包(Swingsets2)</a></li>
<li>or<br>
<a href='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/demo/excute_jar/swingset3_beautyeye.jar'>下载可执行jar包(Swingsets3)</a> <font color='#FF6600'>[推荐]</font></li>
</ul>

<h1>Download</h1>
all_in_one.zip压缩包：<a href='http://code.google.com/p/beautyeye/downloads/list'>Click HERE</a>（内含demo、api文档、核心分发jar包等）.<br><br>
<font color='#2A779D'>友情提示：核心分发jar包 <b><code>beautyeye_lnf.jar</code></b> 位于all_in_one.zip包中的位置是：<b>“<code>all_in_one/dist/</code>”</b></font>

<h1>Development Guide</h1>

<font color='#2A779D'>加入以下代码，即可将你的Java程序界面更换成Beauty Eye的外观：</font>
<pre><code>public static void main(String[] args)<br>
{<br>
    try<br>
    {<br>
        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();<br>
    }<br>
    catch(Exception e)<br>
    {<br>
        //TODO exception<br>
    }<br>
    ..................... 你的程序代码 .........................<br>
    ..................... 你的程序代码 .........................<br>
}<br>
</code></pre>

关于开发详情请查看：<a href='http://code.google.com/p/beautyeye/wiki/Introduction'>BeautyEye L&amp;F简明开发者指南</a>.<br>
<br>
<br>
<h1>Contact</h1>
<img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/screenshots/js2.png' />
<ul>
<li>如有bug及建议等，请直接提交“Issues”或邮件至：jb2011@163.com；</li>
<li>另有一QQ群供Swing爱好者讨论交流，1群：259448663；</li>
<li>另：有偿提供应用软件整体或局部美化咨询、方案制作、编码实现等，如有需求请联系QQ：413980957；</li>
<li>你也可前往 <a href='http://t.qq.com/jackjiang_is_here/'>Jack Jiang的微博</a> 进行交流。</li>
</ul>

<h1>License</h1>
你可永久免费且自由地使用BeautyEye外观(look and feel)，如：用于研究、学习、甚至商业用途，但禁止在未经授权的情况下用于商业用途等，请尊重知识产权。<br>
<br>
<h1>Preview</h1>
<b>Part 1/2：</b> 欲查看清晰原图请<a href='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/preview/be_lnf_preview.png'>"另存为..."</a><br>
<img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/preview/be_lnf_preview.png' />

<b>Part 2/2：</b> 欲查看清晰原图请<a href='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/preview/be_lnf_preview2.png'>"另存为..."</a><br>
<img src='http://beautyeye.googlecode.com/svn/trunk/beautyeye_lnf/preview/be_lnf_preview2.png' />

<h1>More Screenshots</h1>
<a href='http://code.google.com/p/beautyeye/wiki/screenshots_all_in_one'>Click here</a>