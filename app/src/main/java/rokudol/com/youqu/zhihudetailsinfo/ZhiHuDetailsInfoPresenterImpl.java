package rokudol.com.youqu.zhihudetailsinfo;

import javax.inject.Inject;

import rokudol.com.youqu.base.BasePresenterImpl;
import rokudol.com.youqu.beans.ZhiHuBean;
import rokudol.com.youqu.requests.RequesCallback;

/**
 * Created by rokudo on 2017/4/13.
 */

public class ZhiHuDetailsInfoPresenterImpl extends BasePresenterImpl<ZhiHuDetailsInfo, ZhiHuBean> implements ZhiHuDetailsInfoPresenter, RequesCallback<ZhiHuBean> {

	private ZhiHuDetailsInfoModelImpl mModel;

	@Inject
	public ZhiHuDetailsInfoPresenterImpl(ZhiHuDetailsInfoModelImpl mModel) {
		this.mModel = mModel;
	}


	@Override
	public void requestInfo(int id) {
		mModel.requestInfo(id, this);
	}


	@Override
	public void OnSuccess(ZhiHuBean data) {
		mView.setWeb(data.getBody(), data.getCss(), data.getJs());
		mView.setComment(data.getComments(),data.getShort_comments(),data.getLong_comments());
	}
}
