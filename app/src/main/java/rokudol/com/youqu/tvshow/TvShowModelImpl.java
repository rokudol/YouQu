package rokudol.com.youqu.tvshow;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import rokudol.com.youqu.beans.TvShowBean;
import rokudol.com.youqu.constants.Constants;
import rokudol.com.youqu.jsons.TvJson;
import rokudol.com.youqu.jsons.TvShowJson;
import rokudol.com.youqu.requests.Request;

/**
 * Created by rokudo on 2017/4/19.
 */

public class TvShowModelImpl implements TvShowModel {
	@Inject
	public TvShowModelImpl() {
	}

	@Inject
	TvShowBean bean;

	@Override
	public void requestTv(final TvCallback<TvShowBean> callback) {
		Request.RequestAliYun(Constants.TVURL).getTv()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<TvJson>() {
					@Override
					public void onSubscribe(Disposable d) {

					}

					@Override
					public void onNext(TvJson value) {
						bean.setTvResults(value.getResult());
						callback.onTvSuccess(bean);
					}

					@Override
					public void onError(Throwable e) {

					}

					@Override
					public void onComplete() {

					}
				});
	}

	@Override
	public void requestTvShow(String time, String id, final TvShowCallback<TvShowBean> callback) {
		Request.RequestAliYun(Constants.TVURL).getTvShow(time, id)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<TvShowJson>() {
					@Override
					public void onSubscribe(Disposable d) {

					}

					@Override
					public void onNext(TvShowJson value) {
						bean.setTvShowList(value.getResult().getProgram());
						bean.setTvName(value.getResult().getName());
						callback.onTvShowSuccess(bean);
					}

					@Override
					public void onError(Throwable e) {
						callback.onTvShowFailed("这个电视台没有节目哦，请查询其他电视台");
					}

					@Override
					public void onComplete() {

					}
				});
	}
}
