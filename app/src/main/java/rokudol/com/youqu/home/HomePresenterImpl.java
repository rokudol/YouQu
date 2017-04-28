package rokudol.com.youqu.home;

import javax.inject.Inject;

import rokudol.com.youqu.base.BasePresenterImpl;
import rokudol.com.youqu.jsons.WeatherJson;

/**
 * Created by rokudo on 2017/4/17.
 */

public class HomePresenterImpl extends BasePresenterImpl<HomeActivity, WeatherJson> implements HomePresenter {
	private HomeModelImpl mModel;

	@Inject
	public HomePresenterImpl(HomeModelImpl mModel) {
		this.mModel = mModel;
	}

	@Override
	public void request(String area) {
		mModel.request(area, this);
	}

	@Override
	public void OnSuccess(WeatherJson data) {
		String temperature = data.getShowapi_res_body().getHourList().get(0).getTemperature();
		String type = data.getShowapi_res_body().getHourList().get(0).getWeather();
		String imgUrl = data.getShowapi_res_body().getHourList().get(0).getWeather_code();
		String area = data.getShowapi_res_body().getArea();
		mView.setWeather(imgUrl, type, temperature, area);
	}

	@Override
	public void OnFailed(String msg) {
		mView.showMsg(msg);
	}
}
