package rokudol.com.youqu.base;

/**
 * Created by rokudo on 2017/4/13.
 */

public interface BaseView {

	//显示进度条
	void showProgress();

	//隐藏进度条
	void hideProgress();

	//显示提示
	void showMsg(String msg);

}
