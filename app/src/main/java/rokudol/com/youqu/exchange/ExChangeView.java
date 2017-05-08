package rokudol.com.youqu.exchange;

import java.util.List;

import rokudol.com.youqu.adapter.CurrencyAdapter;
import rokudol.com.youqu.base.BaseView;
import rokudol.com.youqu.jsons.AllCurrency;

/**
 * Created by rokudo on 2017/4/21.
 */

public interface ExChangeView extends BaseView {
	//给spinner设置适配器
	void setSpinnerAdapter(CurrencyAdapter adapter, List<AllCurrency.Result> list);
	//设置汇率换算后的价格
	void setMoney(String money);
}
