package rokudol.com.youqu.beans;

import java.util.List;

import javax.inject.Inject;

import rokudol.com.youqu.jsons.AllCurrency;

/**
 * Created by rokudo on 2017/4/25.
 */

public class ExChangeBean {
	/*
	* @param currencyList:货币
	* */
	@Inject
	public ExChangeBean() {

	}

	private List<AllCurrency.Result> currencyList;

	public List<AllCurrency.Result> getCurrencyList() {
		return currencyList;
	}

	public void setCurrencyList(List<AllCurrency.Result> currencyList) {
		this.currencyList = currencyList;
	}
}
