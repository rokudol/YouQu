package rokudol.com.youqu.zhihudetails;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rokudol.com.youqu.adapter.ZhiHuDetailsAdapter;
import rokudol.com.youqu.base.BasePresenterImpl;
import rokudol.com.youqu.beans.ZhiHuBean;
import rokudol.com.youqu.requests.RequesCallback;

/**
 * Created by rokudo on 2017/4/13.
 */

public class ZhiHuDetailsPresenterImpl extends BasePresenterImpl<ZhiHuDetails, ZhiHuBean> implements ZhiHuDetailsPresenter, RequesCallback<ZhiHuBean> {
	private ZhiHuDetailsModelImpl mModel;
	private List<ZhiHuBean> list;

	@Inject
	public ZhiHuDetailsPresenterImpl(ZhiHuDetailsModelImpl mModel) {
		this.mModel = mModel;
	}

	@Override
	public void OnSuccess(ZhiHuBean data) {
		list = new ArrayList<>();
		list.add(data);
		ZhiHuDetailsAdapter adapter = new ZhiHuDetailsAdapter(mView.getActivity(), list);
		mView.setItem(adapter);
		adapter.setOnItemClickLisener(new ZhiHuDetailsAdapter.OnItemClickLisener() {
			@Override
			public void OnItemClick(View view, int position) {
				int id = list.get(0).getStories().get(position).getId();
				String title = list.get(0).getStories().get(position).getTitle();
				String imgUrl = list.get(0).getStories().get(position).getImages().get(0);
				mView.goDetailsInfo(id, title, imgUrl, view);
			}
		});
	}

	@Override
	public void request() {
		mModel.request(this);
	}
}