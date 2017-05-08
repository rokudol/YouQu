package rokudol.com.youqu.exchange;

/**
 * Created by rokudo on 2017/5/8.
 */

public interface AllCurrencyCallback<T> {
	void onAllCurrencySuccess(T data);
	void onAllCurrencyFailed(String msg);
}
