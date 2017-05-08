package rokudol.com.youqu.exchange;

/**
 * Created by rokudo on 2017/5/8.
 */

public interface ExchangeCallback<T> {
	void onExchangeSuccess(T data);
	void onExchangeFailed(String msg);
}
