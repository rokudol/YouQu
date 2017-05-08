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

	private List<AllCurrency.Result> allCurrencyList;
	private String toMoney;

	public String getToMoney() {
		return toMoney;
	}

	public void setToMoney(String toMoney) {
		this.toMoney = toMoney;
	}

	public List<AllCurrency.Result> getAllCurrencyList() {
		return allCurrencyList;
	}

	public void setAllCurrencyList(List<AllCurrency.Result> allCurrencyList) {
		this.allCurrencyList = allCurrencyList;
	}
}
