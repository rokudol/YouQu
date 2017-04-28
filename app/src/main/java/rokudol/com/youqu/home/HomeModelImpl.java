package rokudol.com.youqu.home;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import rokudol.com.youqu.constants.Constants;
import rokudol.com.youqu.jsons.WeatherJson;
import rokudol.com.youqu.requests.RequesCallback;
import rokudol.com.youqu.requests.Request;

/**
 * Created by rokudo on 2017/4/17.
 */

public class HomeModelImpl implements HomeModel {

	@Inject
	public HomeModelImpl() {
	}

	@Override
	public void request(String area, final RequesCallback<WeatherJson> callback) {
		Request.RequestAliYun(Constants.WEATHERURL).getWeather(area)
				.subscribeOn(Schedulers.newThread())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<WeatherJson>() {
					@Override
					public void onSubscribe(Disposable d) {

					}

					@Override
					public void onNext(WeatherJson value) {
						callback.OnSuccess(value);
					}

					@Override
					public void onError(Throwable e) {
						callback.OnFailed("出错啦，请选择其他地区或稍后重试");
					}

					@Override
					public void onComplete() {

					}
				});
	}
}
