package rokudol.com.youqu.exchange;

import android.util.Log;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import rokudol.com.youqu.beans.ExChangeBean;
import rokudol.com.youqu.constants.Constants;
import rokudol.com.youqu.jsons.AllCurrency;
import rokudol.com.youqu.jsons.ExChangeJson;
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
	public void getAllCurrency(final AllCurrencyCallback<ExChangeBean> callback) {
		Request.RequestAliYun(Constants.EXCHANGEURL).getAllCurrency()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<AllCurrency>() {
					@Override
					public void onSubscribe(Disposable d) {

					}

					@Override
					public void onNext(AllCurrency value) {
						bean.setAllCurrencyList(value.getResult());
						callback.onAllCurrencySuccess(bean);
					}

					@Override
					public void onError(Throwable e) {
						Log.i("``````````", e.toString());
					}

					@Override
					public void onComplete() {
					}
				});
	}

	@Override
	public void getExchange(String fromCode, String toCode, String money, final ExchangeCallback<ExChangeBean> callback) {
		Request.RequestAliYun(Constants.EXCHANGEURL).getExchange(money, fromCode, toCode)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<ExChangeJson>() {
					@Override
					public void onSubscribe(Disposable d) {

					}

					@Override
					public void onNext(ExChangeJson value) {
						bean.setToMoney(value.getResult().getCamount());
						callback.onExchangeSuccess(bean);
					}

					@Override
					public void onError(Throwable e) {
						Log.i("````````", e.toString());
					}

					@Override
					public void onComplete() {

					}
				});
	}
}
