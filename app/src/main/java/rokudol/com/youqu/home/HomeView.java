package rokudol.com.youqu.home;

import rokudol.com.youqu.base.BaseView;

/**
 * Created by rokudo on 2017/4/17.
 */

public interface HomeView extends BaseView {
	//设置天气数据
	void setWeather(String imgUrl, String type, String temperature, String area);
}
