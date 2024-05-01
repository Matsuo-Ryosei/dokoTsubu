package model;

public class RegistUserCheckLogic {
	private final User user;

	public RegistUserCheckLogic(User user) {
		if (user == null) {
			throw new NullPointerException("\n【警告】userがnullです。userを指定してください");
		}
		this.user = user;
	}
	
	public RegistUserErrorMsg execute() {
		String name = null;
		String pass = null;
		UsersDAO users = new UsersDAO();
		boolean registered = false;
		if (user.getName() == null || user.getName().isEmpty()) {
			name = "名前が入力されていません";
		}
		if (user.getPass() == null || user.getPass().isEmpty()) {
			pass = "パスワードが入力されていません";
		}
		if (!(user.getPass().length() >= 4)) {
			pass = "パスワードは4文字以上で入力してください";
		}
		if (name == null && pass == null) {
			return null;
		}
		return new RegistUserErrorMsg(name, pass);
		
	}
	
	

	
}
