package com.shinhan.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/*
 * @WebFilter("/*.do") : 언제 이 필터를 수행 할 것인지에 대한 URL pattern
 */
@WebFilter("*.do")
public class EncodingFilter extends HttpFilter implements Filter {
       
    
    public EncodingFilter() {
    	System.out.println("EncodingFilter 생성");
    }

	public void destroy() {
    	System.out.println("EncodingFilter 소멸");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 요청사항이 들어오면 무조건 들어옴
		// TODO Auto-generated method stub
		// place your code here
		request.setCharacterEncoding("utf-8");
		
		// pass the request along the filter chain
		chain.doFilter(request, response); //절대 건들지 말 것.
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
