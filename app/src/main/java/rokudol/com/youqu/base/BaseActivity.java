package rokudol.com.youqu.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by rokudo on 2017/4/13.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

	protected T mPrensenter;

	protected abstract int getLayoutId();

	protected abstract void initView();

	protected abstract void initToolbar();

	protected abstract void initDrawer();

	protected abstract void work();

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutId());
		ButterKnife.bind(this);
		initView();
		initToolbar();
		initDrawer();
		if (mPrensenter != null) {
			mPrensenter.onCreatePresenter();
		}
		work();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (mPrensenter != null) {
			mPrensenter.onDestroyPrensenter();
		}
	}
}
