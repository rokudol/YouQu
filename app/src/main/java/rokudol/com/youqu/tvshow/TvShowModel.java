package rokudol.com.youqu.tvshow;

import rokudol.com.youqu.beans.TvShowBean;

/**
 * Created by rokudo on 2017/4/19.
 */

public interface TvShowModel {
	//获取所有电视台
	void requestTv(TvCallback<TvShowBean> callback);

	//获取当前电视台的节目
	void requestTvShow(String time, String id, TvShowCallback<TvShowBean> callback);
}
