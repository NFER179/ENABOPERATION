package solution.controller;

import com.app.controllers.MainController;
import com.app.manager.LogMng;
import com.app.model.UserLogModel;
import com.app.model.dto.UserLogDTO;

import solution.login.LogIn;

public class AppController {
	
	private static AppController instance;
	
	private MainController _mc = null;
	private AppPathController _apc = null;
	
	private AppController() {
		this._apc = new AppPathController();
		this.writeLog(this, LogMng.INFO, "Start AppController.");
		this.writeLog(this, LogMng.INFO, "AppPath: " + this._apc.getRootPath() + ".");
		//this._mc = new MainController(this._apc.getRootPath());
	}
	
	public static AppController getInstance() {
		if (instance == null)
			instance = new AppController();
		return instance;
	}
	
	public void setPathRoot(String path) {
		this._mc = new MainController(path);
	}
	
	public String[] getDataBasesNames() {
		return this._mc.getDataBases();
	}

	public void setDataBase(String database) {
		this.writeLog(this, LogMng.INFO, "Data Base: " + database);
		this._mc.useDataBase(database);
	}

	public boolean isUserSignUp(UserLogDTO userLog) {
		UserLogModel mUserLog;
		boolean UserSignUp = false;
		
		mUserLog = new UserLogModel();
		
		this.writeLog(this, LogMng.INFO, userLog.getsUserName());
		this.writeLog(this, LogMng.INFO, userLog.getsUserPass());
		
		if (mUserLog.existsUser(userLog)) {
			UserSignUp = true;
		}
		
		return UserSignUp;
	}

	public void writeLog(Object object, String logType, String msg) {
		if (this._mc == null) {
			System.out.println(object.getClass().getSimpleName() + " - >> " + msg);
		} else {
			this._mc.writeLog(object, logType, msg);
		}
	}
}