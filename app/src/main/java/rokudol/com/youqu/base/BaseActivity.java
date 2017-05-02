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
	//获取布局xml的id
	protected abstract int getLayoutId();
	//初始化view
	protected abstract void initView();
	//初始化toolbar
	protected abstract void initToolbar();
	//初始化drawerlayout
	protected abstract void initDrawer();
	//在所有初始化工作完成后需要做的工作
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
	/*
	* 若prensenter不为空则在执行onDestroy时摧毁mPrensenter
	* */
	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (mPrensenter != null) {
			mPrensenter.onDestroyPrensenter();
		}
	}
}
