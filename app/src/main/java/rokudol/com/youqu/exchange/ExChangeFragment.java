package rokudol.com.youqu.exchange;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import rokudol.com.youqu.R;
import rokudol.com.youqu.adapter.CurrencyAdapter;
import rokudol.com.youqu.base.BaseFragment;
import rokudol.com.youqu.component.DaggerComponent;
import rokudol.com.youqu.jsons.AllCurrency;

/**
 * Created by rokudo on 2017/4/25.
 */

public class ExChangeFragment extends BaseFragment<ExChangePresenterImpl> implements ExChangeView {
	@Inject
	ExChangePresenterImpl mPresenter;
	@BindView(R.id.from_currency)
	Spinner fromCurrency;
	@BindView(R.id.from_money)
	EditText fromMoney;
	@BindView(R.id.to_currency)
	Spinner toCurrency;
	@BindView(R.id.to_money)
	TextView toMoney;
	@BindView(R.id.exchange_query)
	Button query;
	private List<AllCurrency.Result> list;

	@Override
	public void showProgress() {

	}

	@Override
	public void hideProgress() {

	}

	@Override
	public void showMsg(String msg) {

	}

	@Override
	protected int getLayoutId() {
		return R.layout.fragment_exchange;
	}

	@Override
	protected void initView() {
		DaggerComponent.builder().build().inject(this);
		mPrensenter = mPresenter;
		mPrensenter.onAttachView(this);
	}

	@Override
	protected void initToolbar() {

	}

	@Override
	protected void work() {
		mPresenter.getAllCurrency();
	}

	@OnClick(R.id.exchange_query)
	public void onClick() {
		String fromCode = list.get(fromCurrency.getSelectedItemPosition()).getCurrency();
		String toCode = list.get(toCurrency.getSelectedItemPosition()).getCurrency();
		String money = fromMoney.getText().toString();
		mPresenter.getExchange(fromCode, toCode, money);
	}

	@Override
	public void setSpinnerAdapter(CurrencyAdapter adapter, List<AllCurrency.Result> list) {
		fromCurrency.setAdapter(adapter);
		toCurrency.setAdapter(adapter);
		this.list = list;
	}

	@Override
	public void setMoney(String money) {
		toMoney.setText(money);
	}
}
