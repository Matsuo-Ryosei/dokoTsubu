package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.LoginUserCheckLogic;
import model.LoginUserErrorMessage;
import model.User;



@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
//		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		// Userインスタンスの生成
		User user = new User(name, pass);
		
		// エラーチェック
		LoginUserCheckLogic errorCheck = new LoginUserCheckLogic(user);
		LoginUserErrorMessage errorMsg = errorCheck.execute();
		if (errorMsg != null) {
			request.setAttribute("errorMsg", errorMsg);
			request.setAttribute("user", user);
			forward("index.jsp", request, response);
		}
		// ログイン処理
		LoginLogic loginLogic = new LoginLogic();
		boolean isLogin = loginLogic.execute(user);
		System.out.println("ログインテスト:" + isLogin);
		
		// ログイン成功時の処理
		if (isLogin) {
			// ユーザー情報をセッションスコープに保存
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
			// フォワード
			forward("WEB-INF/jsp/loginResult.jsp", request, response);
		} else {
			// フォワード
			forward("WEB-INF/jsp/loginFault.jsp", request, response);
		}
		
	}

	public void forward(String page, HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}
	
}
