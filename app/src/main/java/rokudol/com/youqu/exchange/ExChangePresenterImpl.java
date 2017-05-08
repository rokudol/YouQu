package rokudol.com.youqu.exchange;

import java.util.List;

import javax.inject.Inject;

import rokudol.com.youqu.adapter.CurrencyAdapter;
import rokudol.com.youqu.base.BasePresenterImpl;
import rokudol.com.youqu.beans.ExChangeBean;
import rokudol.com.youqu.constants.Constants;
import rokudol.com.youqu.jsons.AllCurrency;
import rokudol.com.youqu.utils.SharedPreferencesUtil;

/**
 * Created by rokudo on 2017/4/21.
 */

public class ExChangePresenterImpl extends BasePresenterImpl<ExChangeFragment, ExChangeBean> implements ExChangePresenter, AllCurrencyCallback<ExChangeBean>, ExchangeCallback<ExChangeBean> {
	private ExChangeModelImpl mModel;

	@Inject
	public ExChangePresenterImpl(ExChangeModelImpl mModel) {
		this.mModel = mModel;
	}

	/*
	* 先从缓存中获取数据，如果缓存中没有则请求网络数据
	* */
	@Override
	public void getAllCurrency() {
		List<AllCurrency.Result> list = SharedPreferencesUtil.getAllCurrencyList(mView.getActivity(), Constants.ALLCURRENCYLIST, "");
		if (list != null) {
			CurrencyAdapter adapter = new CurrencyAdapter(list, mView.getActivity());
			mView.setSpinnerAdapter(adapter, list);
		} else {
			mModel.getAllCurrency(this);
		}
	}

	@Override
	public void getExchange(String fromCode, String toCode, String moeny) {
		mModel.getExchange(fromCode, toCode, moeny, this);
	}

	@Override
	public void onExchangeSuccess(ExChangeBean data) {
		String money = data.getToMoney();
		mView.setMoney(money);
	}

	@Override
	public void onExchangeFailed(String msg) {

	}

	@Override
	public void onAllCurrencySuccess(ExChangeBean data) {
		if (SharedPreferencesUtil.setAllCurrencyList(mView.getActivity(), Constants.ALLCURRENCYLIST, data.getAllCurrencyList())) {
			List<AllCurrency.Result> list =
					SharedPreferencesUtil.getAllCurrencyList(mView.getActivity(), Constants.ALLCURRENCYLIST, "");
			CurrencyAdapter adapter = new CurrencyAdapter(list, mView.getActivity());
			mView.setSpinnerAdapter(adapter, list);
		}
	}

	@Override
	public void onAllCurrencyFailed(String msg) {

	}
}
