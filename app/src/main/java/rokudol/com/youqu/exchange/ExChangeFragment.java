package rokudol.com.youqu.exchange;

import javax.inject.Inject;

import rokudol.com.youqu.R;
import rokudol.com.youqu.adapter.ExChangeAdapter;
import rokudol.com.youqu.base.BaseFragment;
import rokudol.com.youqu.component.DaggerComponent;

/**
 * Created by rokudo on 2017/4/25.
 */

public class ExChangeFragment extends BaseFragment<ExChangePresenterImpl> implements ExChangeView {
	@Inject
	ExChangePresenterImpl mPresenter;

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

	}


	@Override
	public void setItem(ExChangeAdapter adapter) {
	}
}
