package rokudol.com.youqu.switcharea;

import rokudol.com.youqu.beans.AreaBean;

/**
 * Created by rokudo on 2017/4/18.
 */

public interface SwitchAreaModel {
	//请求省数据
	void requestProvince(String id, ProvinceCallback<AreaBean> callback);

	//请求城数据
	void requestCity(String id, CityCallback<AreaBean> callback);

	//请求区数据
	void requestArea(String id, AreaCallback<AreaBean> callback);
}
