package com.example.demo.config.securityConfig;


import com.example.demo.config.securityConfig.filter.JwtAuthenticationTokenFilter;
import com.example.demo.config.securityConfig.filter.WeChatAuthenticationFilter;
import com.example.demo.config.securityConfig.handler.WxAccessDeniedHandlerImpl;
import com.example.demo.config.securityConfig.handler.WxAuthenticationFailureHandler;
import com.example.demo.config.securityConfig.handler.WxAuthenticationnSuccessHandler;
import com.example.demo.config.securityConfig.provider.WeChatAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)//这个注解是开启授权功能
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    WxAuthenticationnSuccessHandler wxAuthenticationnSuccessHandler;
    @Autowired
    WxAuthenticationFailureHandler wxAuthenticationFailureHandler;

    @Autowired
    WxAccessDeniedHandlerImpl wxAccessDeniedHandler;

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    /**
     * 此处给AuthenticationManager添加登陆验证的逻辑。
     * 这里添加了两个AuthenticationProvider分别用于用户名密码登陆的验证以及token授权登陆两种方式。
     * 在处理登陆信息的过滤器执行的时候会调用这两个provider进行登陆验证。
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //用户名和密码登陆
//        auth.userDetailsService(customUserService()).passwordEncoder(new BCryptPasswordEncoder());
        //微信openid登陆
        auth.authenticationProvider(weChatAuthenticationProvider());
    }



    @Bean
    public WeChatAuthenticationProvider weChatAuthenticationProvider() {
        return new WeChatAuthenticationProvider();
    }

    /**
     * 添加微信openid登陆验证的过滤器
     */
    @Bean
    public WeChatAuthenticationFilter weChatAuthenticationFilter() throws Exception {
        WeChatAuthenticationFilter filter = new WeChatAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManagerBean());
        filter.setAuthenticationSuccessHandler(wxAuthenticationnSuccessHandler);
        filter.setAuthenticationFailureHandler(wxAuthenticationFailureHandler);
        return filter;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //关闭csrf
                .csrf().disable()
                //不通过Session获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 对于登录接口 允许匿名访问
                .antMatchers("/wechat/login").anonymous()
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated()
                .and()
                .addFilterAt(weChatAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        http.exceptionHandling().accessDeniedHandler(wxAccessDeniedHandler);
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
