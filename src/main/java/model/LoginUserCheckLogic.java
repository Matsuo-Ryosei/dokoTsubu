package model;

public class LoginUserCheckLogic {
	private final User user;

	public LoginUserCheckLogic(User user) {
		if (user == null) {
			throw new NullPointerException("\n【警告】userがnullです。userを指定してください");
		}
		this.user = user;
	}
	
	public LoginUserErrorMessage execute() {
		String name = null;
		String pass = null;
		if (user.getName() == null || user.getName().isEmpty()) {
			name = "名前が入力されていません";
		}
		if (user.getPass() == null || user.getPass().isEmpty()) {
			pass = "パスワードが入力されていません";
		}
		if (name == null && pass == null) {
			return null;
		}
		return new LoginUserErrorMessage(name, pass);
		
	}
	
	
}
