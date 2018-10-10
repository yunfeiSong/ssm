<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>index</title>
  <!-- 国内使用 -->
  <script type="text/javascript" charset="utf-8" src="//g.alicdn.com/sd/ncpc/nc.js?t=2015052012"></script>
  <!-- 若您的主要用户来源于海外，请替换使用下面的js资源 -->
  <!-- <script type="text/javascript" charset="utf-8" src="//aeis.alicdn.com/sd/ncpc/nc.js?t=2015052012"></script> -->
</head>
<body>
<c:out value="${jsessionId}"/>
<br/>
<c:out value="${userAgent}"/>
<br/>
<a href="${pageContext.request.contextPath}/con/getRole/10.do">redirectToRole</a>
<br/><br/><br/>
<%--滑动验证码--阿里云 --%>
<div id="your-dom-id" class="nc-container"></div> <!--No-Captcha渲染的位置，其中 class 中必须包含 nc-container-->

<script type="text/javascript">
  var nc_token = ["CF_APP_1", (new Date()).getTime(), Math.random()].join(':');
  var NC_Opt =
    {
      renderTo: "#your-dom-id",
      appkey: "CF_APP_1",
      scene: "register",
      token: nc_token,
      customWidth: 300,
      trans: {"key1": "code0"},
      elementID: ["usernameID"],
      is_Opt: 0,
      language: "cn",
      isEnabled: true,
      timeout: 3000,
      times: 5,
      apimap: {
        // 'analyze': '//a.com/nocaptcha/analyze.jsonp',
        // 'get_captcha': '//b.com/get_captcha/ver3',
        // 'get_captcha': '//pin3.aliyun.com/get_captcha/ver3'
        // 'get_img': '//c.com/get_img',
        // 'checkcode': '//d.com/captcha/checkcode.jsonp',
        // 'umid_Url': '//e.com/security/umscript/3.2.1/um.js',
        // 'uab_Url': '//aeu.alicdn.com/js/uac/909.js',
        // 'umid_serUrl': 'https://g.com/service/um.json'
      },
      callback: function (data) {
        window.console && console.log(nc_token)
        window.console && console.log(data.csessionid)
        window.console && console.log(data.sig)
      }
    }
  var nc = new noCaptcha(NC_Opt)
  nc.upLang('cn', {
    _startTEXT: "请按住滑块，拖动到最右边",
    _yesTEXT: "验证通过",
    _error300: "哎呀，出错了，点击<a href=\"javascript:__nc.reset()\">刷新</a>再来一次",
    _errorNetwork: "网络不给力，请<a href=\"javascript:__nc.reset()\">点击刷新</a>",
  })
</script>

</body>

</html>
