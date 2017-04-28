package rokudol.com.youqu.home;

import rokudol.com.youqu.jsons.WeatherJson;
import rokudol.com.youqu.requests.RequesCallback;

/**
 * Created by rokudo on 2017/4/17.
 */

public interface HomeModel {
	//请求数据
	void request(String area, RequesCallback<WeatherJson> callback);
}
