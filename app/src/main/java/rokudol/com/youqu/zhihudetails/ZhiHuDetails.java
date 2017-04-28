package rokudol.com.youqu.zhihudetails;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import javax.inject.Inject;

import butterknife.BindView;
import rokudol.com.youqu.R;
import rokudol.com.youqu.adapter.ZhiHuDetailsAdapter;
import rokudol.com.youqu.base.BaseFragment;
import rokudol.com.youqu.component.DaggerComponent;
import rokudol.com.youqu.constants.Constants;
import rokudol.com.youqu.home.HomeActivity;
import rokudol.com.youqu.zhihudetailsinfo.ZhiHuDetailsInfo;

/**
 * Created by rokudo on 2017/4/13.
 */

public class ZhiHuDetails extends BaseFragment implements ZhiHuDetailsView {
	@BindView(R.id.zhihu_rv)
	RecyclerView rv;
	private HomeActivity mActivity;

	@Inject
	ZhiHuDetailsPresenterImpl mPresenter;

	@Inject
	public ZhiHuDetails() {
	}

	@Override
	protected int getLayoutId() {
		return R.layout.fragment_zhihudetails;
	}

	@Override
	protected void initView() {
		mActivity = (HomeActivity) this.getActivity();
		DaggerComponent.builder().build().inject(this);
		mPrensenter = this.mPresenter;
		mPrensenter.onAttachView(this);
	}

	@Override
	protected void initToolbar() {

	}

	@Override
	protected void work() {
		mPresenter.request();

	}

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
	public void setItem(ZhiHuDetailsAdapter adapter) {
		rv.setLayoutManager(new LinearLayoutManager(mActivity));
		rv.setItemAnimator(new DefaultItemAnimator());
		rv.setAdapter(adapter);
	}

	@Override
	public void goDetailsInfo(int id, String title, String imgUrl, View view) {
		Intent intent = new Intent(mActivity, ZhiHuDetailsInfo.class);
		intent.putExtra(Constants.ZHIHUDETAILSID, id);
		intent.putExtra(Constants.ZHIHUDETAILSTITLE, title);
		intent.putExtra(Constants.ZHIHUBASEURL, imgUrl);
		ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity,
				view, this.getResources().getString(R.string.transition));
		mActivity.startActivity(intent, options.toBundle());
	}
}
