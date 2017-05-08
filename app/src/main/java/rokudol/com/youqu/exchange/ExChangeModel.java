package rokudol.com.youqu.exchange;

import rokudol.com.youqu.beans.ExChangeBean;

/**
 * Created by rokudo on 2017/4/21.
 */

public interface ExChangeModel {
	//获取所有货币
	void getAllCurrency(AllCurrencyCallback<ExChangeBean> callback);
	//汇率换算
	void getExchange(String fromCode,String toCode,String money,ExchangeCallback<ExChangeBean> callback);
}
