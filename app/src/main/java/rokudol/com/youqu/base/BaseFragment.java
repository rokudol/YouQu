package rokudol.com.youqu.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by rokudo on 2017/4/13.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment {
	protected T mPrensenter;

	protected abstract int getLayoutId();

	protected abstract void initView();

	protected abstract void initToolbar();

	protected abstract void work();

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(getLayoutId(), container, false);
		ButterKnife.bind(this, view);
		initView();
		initToolbar();
		work();
		return view;
	}
	/*
	* 若prensenter不为空则在执行onDestroy时摧毁mPrensenter
	* */
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		if (mPrensenter != null) {
			mPrensenter.onDestroyPrensenter();
		}
	}
}
