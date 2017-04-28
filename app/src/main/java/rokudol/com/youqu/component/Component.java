package rokudol.com.youqu.component;

import rokudol.com.youqu.exchange.ExChangeFragment;
import rokudol.com.youqu.exchange.ExChangeModelImpl;
import rokudol.com.youqu.exchange.ExChangePresenterImpl;
import rokudol.com.youqu.home.HomeActivity;
import rokudol.com.youqu.home.HomePresenterImpl;
import rokudol.com.youqu.tvshow.TvShowFragment;
import rokudol.com.youqu.tvshow.TvShowModelImpl;
import rokudol.com.youqu.tvshow.TvShowPresenterImpl;
import rokudol.com.youqu.zhihucomment.ZhiHuCommentFragment;
import rokudol.com.youqu.zhihucomment.ZhiHuCommentModelImpl;
import rokudol.com.youqu.zhihudetails.ZhiHuDetails;
import rokudol.com.youqu.zhihudetails.ZhiHuDetailsModelImpl;
import rokudol.com.youqu.zhihudetails.ZhiHuDetailsPresenterImpl;
import rokudol.com.youqu.zhihudetailsinfo.ZhiHuDetailsInfo;
import rokudol.com.youqu.zhihudetailsinfo.ZhiHuDetailsInfoModelImpl;

/**
 * Created by rokudo on 2017/4/18.
 */
@dagger.Component
public interface Component {
	void inject(HomeActivity HomeActivity);

	void inject(ZhiHuDetails zhiHuDetails);

	void inject(ZhiHuDetailsInfo zhiHuDetailsInfo);

	void inject(ZhiHuDetailsModelImpl zhiHuDetailsModel);

	void inject(ZhiHuDetailsPresenterImpl zhiHuDetailsPresenter);

	void inject(ZhiHuDetailsInfoModelImpl zhiHuDetailsInfoModel);

	void inject(ZhiHuCommentFragment zhiHuCommentFragment);

	void inject(ZhiHuCommentModelImpl zhiHuCommentModel);

	void inject(HomePresenterImpl homePresenter);

	void inject(TvShowPresenterImpl tvShowPresenter);

	void inject(TvShowFragment tvShowFragment);

	void inject(TvShowModelImpl tvShowModel);

	void inject(ExChangePresenterImpl exChangePresenter);

	void inject(ExChangeFragment exChangeFragment);

	void inject(ExChangeModelImpl exChangeModel);

}
