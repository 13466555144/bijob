package com.ziroom.biJob.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 权限控制标签，暂时验证是否登录，暂未时间写是否有权限访问
 * 
 * @author zhanghp11
 * @data Jan 13, 2016
 */
public class SecurityAMSFilter implements Filter {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityAMSFilter.class);
    
    protected FilterConfig filterConfig = null;

    private String notCheckLoginUrl = null;

    public void destroy() {

    }

    /**
     * 安全过滤
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
	HttpServletRequest request = (HttpServletRequest) servletRequest;
	HttpServletResponse response = (HttpServletResponse) servletResponse;

	// 获取当前访问URL
	String currentUrl = request.getServletPath() + (request.getPathInfo() == null ? "" : request.getPathInfo());

	LOGGER.info("***********当前请求的URL为：***********" + currentUrl + ",请求字符?" +request.getCharacterEncoding());

	Thread.currentThread().setName(Thread.currentThread().getName()+","+currentUrl);
	if (currentUrl.indexOf("/security/security!selectCity.action") >= 0) {
	    filterChain.doFilter(servletRequest, servletResponse);
	    return;
	}
	if (currentUrl.indexOf("/checkPaymentVoucher/checkPaymentVoucher") >= 0) {
	    filterChain.doFilter(servletRequest, servletResponse);
	    return;
	}

	filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * 初始化不验证的的URL
     */
    public void init(FilterConfig filterConfig) throws ServletException {
    	
    }
}
