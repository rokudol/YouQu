package rokudol.com.youqu.zhihudetailsinfo;

import rokudol.com.youqu.beans.ZhiHuBean;
import rokudol.com.youqu.requests.RequesCallback;

/**
 * Created by rokudo on 2017/4/13.
 */

public interface ZhiHuDetailsInfoModel {
	//请求详情数据
	void requestInfo(int id, RequesCallback<ZhiHuBean> callback);

	void init();
}
