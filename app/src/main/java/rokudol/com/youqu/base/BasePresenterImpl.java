package rokudol.com.youqu.base;

import android.support.annotation.NonNull;

import rokudol.com.youqu.requests.RequesCallback;

/**
 * Created by rokudo on 2017/4/13.
 */

public class BasePresenterImpl<T extends BaseView,E> implements BasePresenter, RequesCallback<E> {
	protected T mView;

	@Override
	public void onCreatePresenter() {

	}

	@Override
	public void onAttachView(@NonNull BaseView view) {
		this.mView = (T) view;
	}

	@Override
	public void onDestroyPrensenter() {

	}

	@Override
	public void OnSuccess(E data) {
		mView.hideProgress();
	}

	@Override
	public void OnFailed(String msg) {
		mView.hideProgress();
		mView.showMsg(msg);
	}
}
