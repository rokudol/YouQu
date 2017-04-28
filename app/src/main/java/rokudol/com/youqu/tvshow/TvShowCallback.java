package rokudol.com.youqu.tvshow;

/**
 * Created by rokudo on 2017/4/20.
 */

public interface TvShowCallback<T> {
	void onTvShowSuccess(T dada);

	void onTvShowFailed(String msg);
}
