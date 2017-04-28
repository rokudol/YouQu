package rokudol.com.youqu.switcharea;

import rokudol.com.youqu.beans.AreaBean;

/**
 * Created by rokudo on 2017/4/18.
 */

public class SwitchAreaPresenterImpl implements SwitchAreaPresenter, ProvinceCallback<AreaBean>, CityCallback<AreaBean>, AreaCallback<AreaBean> {
	private SwitchAreaDialog mView;
	private SwitchAreaModelImpl mModel;

	public SwitchAreaPresenterImpl(SwitchAreaDialog mView) {
		this.mView = mView;
		mModel = new SwitchAreaModelImpl();
	}


	@Override
	public void requestProvince(String id) {
		mModel.requestProvince(id, this);
	}

	@Override
	public void requestCity(String id) {
		mModel.requestCity(id, this);
	}

	@Override
	public void requestArea(String id) {
		mModel.requestArea(id, this);
	}

	@Override
	public void OnAreaSuccess(AreaBean data) {
		mView.addArea(data.getNameList(), data.getIdList());
	}

	@Override
	public void OnAreaFailed(AreaBean msg) {
		mView.noMore(msg.getNoMore());
	}

	@Override
	public void OnCitySuccess(AreaBean data) {
		mView.addCity(data.getNameList(), data.getIdList());
	}

	@Override
	public void OnCityFailed(String msg) {

	}

	@Override
	public void OnProvinceSuccess(AreaBean data) {
		mView.addProvince(data.getNameList(), data.getIdList());
	}

	@Override
	public void OnProvinceFailed(String msg) {

	}
}
