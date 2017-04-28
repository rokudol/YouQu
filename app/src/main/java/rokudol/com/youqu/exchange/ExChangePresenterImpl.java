package rokudol.com.youqu.exchange;

import java.util.List;

import javax.inject.Inject;

import rokudol.com.youqu.adapter.ExChangeAdapter;
import rokudol.com.youqu.base.BasePresenterImpl;
import rokudol.com.youqu.beans.ExChangeBean;
import rokudol.com.youqu.jsons.AllCurrency;
import rokudol.com.youqu.requests.RequesCallback;

/**
 * Created by rokudo on 2017/4/21.
 */

public class ExChangePresenterImpl extends BasePresenterImpl<ExChangeFragment, ExChangeBean> implements ExChangePresenter, RequesCallback<ExChangeBean> {
	private ExChangeModelImpl mModel;

	@Inject
	public ExChangePresenterImpl(ExChangeModelImpl mModel) {
		this.mModel = mModel;
	}


	@Override
	public void OnSuccess(ExChangeBean data) {
		List<AllCurrency.Result> list = data.getCurrencyList();
		ExChangeAdapter adapter = new ExChangeAdapter(list, mView.getActivity());
		mView.setItem(adapter);
	}

	@Override
	public void requestAllCurrency() {
		mModel.getAllCurrency(this);
	}
}
