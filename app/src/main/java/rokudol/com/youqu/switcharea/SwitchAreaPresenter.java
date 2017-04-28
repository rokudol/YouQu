package rokudol.com.youqu.switcharea;

/**
 * Created by rokudo on 2017/4/18.
 */

public interface SwitchAreaPresenter {
	//请求省数据
	void requestProvince(String id);
	//请求城数据
	void requestCity(String id);
	//请求区数据
	void requestArea(String id);
}
