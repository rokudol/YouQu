package rokudol.com.youqu.zhihucomment;

import android.annotation.SuppressLint;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import rokudol.com.youqu.R;
import rokudol.com.youqu.adapter.ZhiHuCommentDetailsAdapter;
import rokudol.com.youqu.base.BaseFragment;
import rokudol.com.youqu.component.DaggerComponent;

/**
 * Created by rokudo on 2017/4/17.
 */
@SuppressLint("ValidFragment")
public class ZhiHuCommentFragment extends BaseFragment<ZhiHuCommentPresenterImpl> implements ZhiHuCommentView {
	private boolean isShort;//是否加载短评论
	private ZhiHuComment mActivity;

	@BindView(R.id.comment_rv)
	RecyclerView rv;
	@BindView(R.id.empty_tv)
	TextView empty;

	@Inject
	ZhiHuCommentPresenterImpl mPresenter;


	public ZhiHuCommentFragment(boolean isShort) {
		this.isShort = isShort;
	}


	@Override
	protected int getLayoutId() {
		return R.layout.fragment_comment;
	}

	@Override
	protected void initView() {
		mActivity = (ZhiHuComment) this.getActivity();
		DaggerComponent.builder().build().inject(this);
		mPrensenter = this.mPresenter;
		mPrensenter.onAttachView(this);
	}

	@Override
	protected void initToolbar() {

	}

	@Override
	protected void work() {
		if (isShort) {
			mPresenter.requestShort(mActivity.id);
		} else {
			mPresenter.requestLong(mActivity.id);
		}
	}

	@Override
	public void setItem(ZhiHuCommentDetailsAdapter adapter) {
		rv.setLayoutManager(new LinearLayoutManager(mActivity));
		rv.setItemAnimator(new DefaultItemAnimator());
		rv.setAdapter(adapter);
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

}
