package rokudol.com.youqu.zhihucomment;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rokudol.com.youqu.adapter.ZhiHuCommentDetailsAdapter;
import rokudol.com.youqu.base.BasePresenterImpl;
import rokudol.com.youqu.beans.ZhiHuBean;
import rokudol.com.youqu.requests.RequesCallback;

/**
 * Created by rokudo on 2017/4/17.
 */

public class ZhiHuCommentPresenterImpl extends BasePresenterImpl<ZhiHuCommentFragment, ZhiHuBean> implements ZhiHuCommentPresenter, RequesCallback<ZhiHuBean> {
	private ZhiHuCommentModelImpl mModel;
	private List<ZhiHuBean> list;

	@Inject
	public ZhiHuCommentPresenterImpl(ZhiHuCommentModelImpl mModel) {
		this.mModel = mModel;
	}


	@Override
	public void OnSuccess(ZhiHuBean data) {
		list = new ArrayList<>();
		list.add(data);
		if (data.getCommentlist().size() == 0) {
			mView.rv.setVisibility(View.GONE);
			mView.empty.setVisibility(View.VISIBLE);
		} else {
			mView.rv.setVisibility(View.VISIBLE);
			mView.empty.setVisibility(View.GONE);
		}
		ZhiHuCommentDetailsAdapter adapter = new ZhiHuCommentDetailsAdapter(mView.getActivity(), list);
		mView.setItem(adapter);
	}

	@Override
	public void requestLong(int id) {
		mModel.init();
		mModel.requestLong(id, this);
	}

	@Override
	public void requestShort(int id) {
		mModel.init();
		mModel.requestShort(id, this);
	}
}
