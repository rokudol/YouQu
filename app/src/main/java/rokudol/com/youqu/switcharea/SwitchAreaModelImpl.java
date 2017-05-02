package rokudol.com.youqu.switcharea;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import rokudol.com.youqu.beans.AreaBean;
import rokudol.com.youqu.constants.Constants;
import rokudol.com.youqu.jsons.AreaJson;
import rokudol.com.youqu.requests.Request;

/**
 * Created by rokudo on 2017/4/18.
 */

public class SwitchAreaModelImpl implements SwitchAreaModel {

	@Override
	public void requestProvince(String id, final ProvinceCallback<AreaBean> callback) {
		Request.RequestAliYun(Constants.AREAURL).getArea(id)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<AreaJson>() {
					@Override
					public void onSubscribe(Disposable d) {

					}

					@Override
					public void onNext(AreaJson value) {
						List<String> nameList = new ArrayList<>();
						List<String> idList = new ArrayList<>();
						for (int i = 0; i < value.getResult().size(); i++) {
							nameList.add(value.getResult().get(i).getName());
							idList.add(value.getResult().get(i).getId() + "");
						}
						AreaBean bean = new AreaBean();
						bean.setIdList(idList);
						bean.setNameList(nameList);
						callback.OnProvinceSuccess(bean);
					}

					@Override
					public void onError(Throwable e) {

					}

					@Override
					public void onComplete() {

					}
				});
	}

	@Override
	public void requestCity(String id, final CityCallback<AreaBean> callback) {
		Request.RequestAliYun(Constants.AREAURL).getArea(id)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<AreaJson>() {
					@Override
					public void onSubscribe(Disposable d) {

					}

					@Override
					public void onNext(AreaJson value) {
						List<String> nameList = new ArrayList<>();
						List<String> idList = new ArrayList<>();
						for (int i = 0; i < value.getResult().size(); i++) {
							nameList.add(value.getResult().get(i).getName());
							idList.add(value.getResult().get(i).getId() + "");
						}
						AreaBean bean = new AreaBean();
						bean.setIdList(idList);
						bean.setNameList(nameList);
						callback.OnCitySuccess(bean);
					}

					@Override
					public void onError(Throwable e) {

					}

					@Override
					public void onComplete() {

					}
				});
	}

	@Override
	public void requestArea(String id, final AreaCallback<AreaBean> callback) {
		Request.RequestAliYun(Constants.AREAURL).getArea(id)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<AreaJson>() {
					@Override
					public void onSubscribe(Disposable d) {

					}

					@Override
					public void onNext(AreaJson value) {
						List<String> nameList = new ArrayList<>();
						List<String> idList = new ArrayList<>();
						AreaBean bean = new AreaBean();
						for (int i = 0; i < value.getResult().size(); i++) {
							nameList.add(value.getResult().get(i).getName());
							idList.add(value.getResult().get(i).getId() + "");
						}
						bean.setIdList(idList);
						bean.setNameList(nameList);
						callback.OnAreaSuccess(bean);
					}

					@Override
					public void onError(Throwable e) {
						List<String> noMore = new ArrayList<>();
						AreaBean bean = new AreaBean();
						noMore.add("没有更多数据了");
						bean.setNoMore(noMore);
						callback.OnAreaFailed(bean);
					}

					@Override
					public void onComplete() {

					}
				});
	}
}
