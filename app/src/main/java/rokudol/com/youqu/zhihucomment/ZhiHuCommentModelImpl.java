package rokudol.com.youqu.zhihucomment;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import rokudol.com.youqu.beans.ZhiHuBean;
import rokudol.com.youqu.component.DaggerComponent;
import rokudol.com.youqu.constants.Constants;
import rokudol.com.youqu.jsons.ZhiHuCommentJson;
import rokudol.com.youqu.requests.RequesCallback;
import rokudol.com.youqu.requests.Request;

/**
 * Created by rokudo on 2017/4/17.
 */

public class ZhiHuCommentModelImpl implements ZhiHuCommentModel {
	@Inject
	ZhiHuBean zhiHuBean;

	@Inject
	public ZhiHuCommentModelImpl() {

	}

	@Override
	public void requestLong(int id, final RequesCallback<ZhiHuBean> callback) {
		Request.getApi(Constants.ZHIHUBASEURL).getLongCommentInfo(id)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<ZhiHuCommentJson>() {
					@Override
					public void onSubscribe(Disposable d) {

					}

					@Override
					public void onNext(ZhiHuCommentJson value) {
						zhiHuBean.setCommentlist(value.getComments());
						callback.OnSuccess(zhiHuBean);
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
	public void requestShort(int id, final RequesCallback<ZhiHuBean> callback) {
		Request.getApi(Constants.ZHIHUBASEURL).getShortCommentInfo(id)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<ZhiHuCommentJson>() {
					@Override
					public void onSubscribe(Disposable d) {

					}

					@Override
					public void onNext(ZhiHuCommentJson value) {
						zhiHuBean.setCommentlist(value.getComments());
						callback.OnSuccess(zhiHuBean);
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
	public void init() {
		DaggerComponent.builder().build().inject(this);
	}
}
