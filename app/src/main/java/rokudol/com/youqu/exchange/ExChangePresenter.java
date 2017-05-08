package rokudol.com.youqu.exchange;

import rokudol.com.youqu.base.BasePresenter;

/**
 * Created by rokudo on 2017/4/21.
 */

public interface ExChangePresenter extends BasePresenter {
	//获取全部货币数据
	void getAllCurrency();
	//汇率换算
	void getExchange(String fromCode,String toCode,String moeny);
}
