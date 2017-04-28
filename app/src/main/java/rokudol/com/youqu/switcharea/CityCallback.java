package rokudol.com.youqu.switcharea;

/**
 * Created by rokudo on 2017/4/18.
 */

public interface CityCallback<E> {
	//请求成功
	void OnCitySuccess(E data);

	//请求失败
	void OnCityFailed(String msg);
}
