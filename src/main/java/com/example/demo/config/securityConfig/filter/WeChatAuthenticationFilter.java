package com.example.demo.config.securityConfig.filter;


import com.alibaba.fastjson2.JSONObject;
import com.example.demo.config.securityConfig.token.WeChatAuthenticationToken;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.util.EntityUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import sun.applet.AppletIOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author: xxm
 * @description:微信openid登陆验证的过滤器
 * @date: 2021/3/11 14:58
 */
public class WeChatAuthenticationFilter extends AbstractAuthenticationProcessingFilter {


    private String codeParmter = "code";

    @Value("${wechat.appid}")
    private String APPID;

    @Value("${wechat.secret}")
    private String APPSecret;

    public WeChatAuthenticationFilter() {
        super("/wechat/login");
        //super.setAuthenticationFailureHandler(new MyAuthenticationFailureHandler());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException {

//todo 在这里拿到openid
        if (!request.getMethod().equals(HttpMethod.GET.name())) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }

        String code = obtainOpenid(request);
        System.out.println("我的code      "+code);
        System.out.println("我的appid    "+APPID+"       "+APPSecret);
        if (code == null || code.length() == 0) {
            throw new BadCredentialsException("uid or openid is null.");
        }

        StringBuilder url = new StringBuilder("https://api.weixin.qq.com/sns/jscode2session?");
        url.append("appid=");//appid设置
        url.append(APPID);
        url.append("&secret=");//secret设置
        url.append(APPSecret);
        url.append("&js_code=");//code设置
        url.append(code);
        url.append("&grant_type=authorization_code");
        Map<String, Object> map = null;

            HttpClient client = HttpClientBuilder.create().build();//构建一个Client
            HttpGet get = new HttpGet(url.toString());    //构建一个GET请求
            HttpResponse wechatResponse = client.execute(get);//提交GET请求
            HttpEntity result = wechatResponse.getEntity();//拿到返回的HttpResponse的"实体"
            String content = EntityUtils.toString(result);

            System.out.println(content);//打印返回的信息
//            JSONObject res = JSONObject.fromObject(content);//把信息封装为json
            //把信息封装到map
//            map = TestController.parseJSON2Map(res);//这个小工具的代码在下面

        System.out.println("你好 大师傅但是");
        JSONObject jsonObject=JSONObject.parseObject(content);
        String openid=jsonObject.getString("openid");
//        if(openid==null){
//            throw new BadCredentialsException("uid or openid is null.");
//        }
//        openid="skadjsahdsdasd+nnnnn";
        //todo  后面将要检查非空什么的
        WeChatAuthenticationToken authRequest = new WeChatAuthenticationToken(openid);

        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));

        return this.getAuthenticationManager().authenticate(authRequest);

    }

    protected String obtainOpenid(HttpServletRequest request) {
        String code = request.getParameter(this.codeParmter);
        return code == null ? "" : code.trim();
    }

}
