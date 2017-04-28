package rokudol.com.youqu.exchange;

import rokudol.com.youqu.beans.ExChangeBean;
import rokudol.com.youqu.requests.RequesCallback;

/**
 * Created by rokudo on 2017/4/21.
 */

public interface ExChangeModel {
	//获取所有货币
	void getAllCurrency(RequesCallback<ExChangeBean> callback);
}
