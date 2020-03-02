package solution.controller;

import com.app.controllers.MainController;
import com.app.model.UserLogModel;
import com.app.model.dto.UserLogDTO;

public class AppController {
	
	private static AppController instance;
	
	private MainController _mc = null;
	private AppPathController _apc = null;
	
	private AppController() {
		this._apc = new AppPathController();
		System.out.println("[AppController] - Start AppController.");
		System.out.println("[AppController] - AppPath: " + this._apc.getRootPath() + ".");
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
		System.out.println("[AppController.setDataBase] - Data Base: " + database);
		this._mc.useDataBase(database);
	}

	public boolean isUserSignUp(UserLogDTO userLog) {
		UserLogModel mUserLog;
		boolean UserSignUp = false;
		
		mUserLog = new UserLogModel();
		
		if (mUserLog.existsUser(userLog)) {
			UserSignUp = true;
		}
		
		return UserSignUp;
	}
}