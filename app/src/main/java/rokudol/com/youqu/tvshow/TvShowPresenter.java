package rokudol.com.youqu.tvshow;

import rokudol.com.youqu.base.BasePresenter;

/**
 * Created by rokudo on 2017/4/19.
 */

public interface TvShowPresenter extends BasePresenter {
	//请求电视台数据
	void requestTv();

	//请求电视节目数据
	void requestTvShow(String time,String id);
}
