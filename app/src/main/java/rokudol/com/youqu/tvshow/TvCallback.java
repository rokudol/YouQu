package rokudol.com.youqu.tvshow;

/**
 * Created by rokudo on 2017/4/20.
 */

public interface TvCallback<T> {
	void onTvSuccess(T data);

	void onTvFailed(String msg);
}
