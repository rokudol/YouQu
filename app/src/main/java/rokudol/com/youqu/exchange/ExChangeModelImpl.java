package rokudol.com.youqu.exchange;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import rokudol.com.youqu.beans.ExChangeBean;
import rokudol.com.youqu.constants.Constants;
import rokudol.com.youqu.jsons.AllCurrency;
import rokudol.com.youqu.requests.RequesCallback;
import rokudol.com.youqu.requests.Request;

/**
 * Created by rokudo on 2017/4/21.
 */

public class ExChangeModelImpl implements ExChangeModel {
	@Inject
	public ExChangeModelImpl() {
	}

	@Inject
	ExChangeBean bean;


	@Override
	public void getAllCurrency(final RequesCallback<ExChangeBean> callback) {
		Request.RequestAliYun(Constants.EXCHANGEURL).getCurrency()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<AllCurrency>() {
					@Override
					public void onSubscribe(Disposable d) {

					}

					@Override
					public void onNext(AllCurrency value) {
						bean.setCurrencyList(value.getResult());
						callback.OnSuccess(bean);
					}

					@Override
					public void onError(Throwable e) {

					}

					@Override
					public void onComplete() {

					}
				});
	}
}
