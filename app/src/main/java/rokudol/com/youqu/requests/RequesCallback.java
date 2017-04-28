package rokudol.com.youqu.requests;

/**
 * Created by rokudo on 2017/4/11.
 */

public interface RequesCallback<E> {
	//请求成功
	void OnSuccess(E data);

	//请求失败
	void OnFailed(String msg);
}
