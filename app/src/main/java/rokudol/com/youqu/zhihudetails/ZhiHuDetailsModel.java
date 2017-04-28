package rokudol.com.youqu.zhihudetails;

import rokudol.com.youqu.beans.ZhiHuBean;
import rokudol.com.youqu.requests.RequesCallback;

/**
 * Created by rokudo on 2017/4/13.
 */

public interface ZhiHuDetailsModel {
	//请求数据
	void request(RequesCallback<ZhiHuBean> callback);


	void init();
}
