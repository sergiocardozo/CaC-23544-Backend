package ar.com.codoacodo.filters;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = { "/*" })
public class CorsFilters implements Filter{

	private List<String> origins = List.of("http://localhost:5500", "http://127.0.0.1:5500", "https://sergiocardozo.github.io");
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String origin = ((HttpServletRequest) request).getHeader("origin");
		
		if(origin != null && origins.contains(origin)) {
			((HttpServletResponse) response).addHeader("Access-Control-Allow-Origin", origin);
			((HttpServletResponse) response).addHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS, HEAD");
			((HttpServletResponse) response).addHeader("Access-Control-Allow-Headers", "*");
		}
		chain.doFilter(request, response);
	}

}
