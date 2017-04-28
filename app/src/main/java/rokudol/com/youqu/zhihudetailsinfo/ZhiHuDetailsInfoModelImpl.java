package rokudol.com.youqu.zhihudetailsinfo;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import rokudol.com.youqu.beans.ZhiHuBean;
import rokudol.com.youqu.component.DaggerComponent;
import rokudol.com.youqu.constants.Constants;
import rokudol.com.youqu.jsons.ZhiHuExtraJson;
import rokudol.com.youqu.jsons.ZhiHuNewsDetailsJson;
import rokudol.com.youqu.requests.RequesCallback;
import rokudol.com.youqu.requests.Request;

/**
 * Created by rokudo on 2017/4/13.
 */

public class ZhiHuDetailsInfoModelImpl implements ZhiHuDetailsInfoModel {
	@Inject
	ZhiHuBean bean;

	@Inject
	public ZhiHuDetailsInfoModelImpl() {

	}

	@Override
	public void init() {
		DaggerComponent.builder().build().inject(this);
	}

	@Override
	public void requestInfo(final int id, final RequesCallback<ZhiHuBean> callback) {


		Observable<ZhiHuNewsDetailsJson> getZhiHuNewsDetails = Request.getApi(Constants.ZHIHUBASEURL).
				getDetailInfo(id).subscribeOn(Schedulers.io());
		Observable<ZhiHuExtraJson> getZhiHuExtra = Request.getApi(Constants.ZHIHUBASEURL).
				getDetailExtraInfo(id).subscribeOn(Schedulers.io());

		Observable.zip(getZhiHuNewsDetails, getZhiHuExtra, new BiFunction<ZhiHuNewsDetailsJson, ZhiHuExtraJson, ZhiHuBean>() {
			@Override
			public ZhiHuBean apply(ZhiHuNewsDetailsJson zhiHuNewsDetailsJson, ZhiHuExtraJson zhiHuExtraJson)
					throws Exception {
				bean.setComments(zhiHuExtraJson.getComments());
				bean.setShort_comments(zhiHuExtraJson.getShort_comments());
				bean.setLong_comments(zhiHuExtraJson.getLong_comments());
				bean.setBody(zhiHuNewsDetailsJson.getBody());
				bean.setJs(zhiHuNewsDetailsJson.getJs());
				bean.setCss(zhiHuNewsDetailsJson.getCss());
				return bean;
			}
		}).observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Consumer<ZhiHuBean>() {
					@Override
					public void accept(ZhiHuBean zhiHuBean) throws Exception {
						callback.OnSuccess(bean);
					}
				});

	}

}
