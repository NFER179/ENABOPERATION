package solution.login;

import com.app.model.dto.UserLogDTO;

import solution.controller.AppController;

public class AppSession {
	
	private AppController _appCtr;
	private UserLogDTO _userLog;
	
	public AppSession(AppController appController, UserLogDTO userLog) {
		this._appCtr = appController;
		this._userLog = userLog;
	}

	public boolean logInOk() {
		boolean logInOk = false;
		
		if (this._appCtr.isUserSignUp(this._userLog)) {
			logInOk = true;
		}
		
		return logInOk;
	}
}