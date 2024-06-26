package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;


@WebFilter("/*")
public class SetEncodingFilter extends HttpFilter implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// サーブレットクラス実行前の処理
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
		// サーブレットクラス実行後に行なわせたい処理を記述
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {}
	@Override
	public void destroy() {}


}
