package rokudol.com.youqu.switcharea;

/**
 * Created by rokudo on 2017/4/18.
 */

public interface ProvinceCallback<E> {
	//请求成功
	void OnProvinceSuccess(E data);

	//请求失败
	void OnProvinceFailed(String msg);
}
