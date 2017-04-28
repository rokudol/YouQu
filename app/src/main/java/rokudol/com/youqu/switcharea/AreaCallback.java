package rokudol.com.youqu.switcharea;

/**
 * Created by rokudo on 2017/4/18.
 */

public interface AreaCallback<E> {
	//请求成功
	void OnAreaSuccess(E data);

	//请求失败
	void OnAreaFailed(E msg);
}
