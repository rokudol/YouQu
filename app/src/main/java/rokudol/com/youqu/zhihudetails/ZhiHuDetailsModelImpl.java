package rokudol.com.youqu.zhihudetails;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import rokudol.com.youqu.beans.ZhiHuBean;
import rokudol.com.youqu.component.DaggerComponent;
import rokudol.com.youqu.constants.Constants;
import rokudol.com.youqu.jsons.ZhiHuNewsJson;
import rokudol.com.youqu.requests.RequesCallback;
import rokudol.com.youqu.requests.Request;

/**
 * Created by rokudo on 2017/4/13.
 */

public class ZhiHuDetailsModelImpl implements ZhiHuDetailsModel {
	@Inject
	ZhiHuBean bean;

	@Inject
	public ZhiHuDetailsModelImpl() {

	}

	@Override
	public void init() {
		DaggerComponent.builder().build().inject(this);
	}

	@Override
	public void request(final RequesCallback<ZhiHuBean> callback) {

		Request.getApi(Constants.ZHIHUBASEURL).getDailyList()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<ZhiHuNewsJson>() {
					@Override
					public void onSubscribe(Disposable d) {

					}

					@Override
					public void onNext(ZhiHuNewsJson value) {
						bean.setDate(value.getDate());
						bean.setStories(value.getStories());
						bean.setTop_stories(value.getTop_stories());
						callback.OnSuccess(bean);
					}

					@Override
					public void onError(Throwable e) {
						callback.OnFailed(e.toString());
					}

					@Override
					public void onComplete() {

					}
				});
	}
}
