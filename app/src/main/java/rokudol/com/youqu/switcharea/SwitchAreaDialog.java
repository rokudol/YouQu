package rokudol.com.youqu.switcharea;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.aigestudio.wheelpicker.WheelPicker;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rokudol.com.youqu.R;
import rokudol.com.youqu.home.HomeActivity;

/**
 * Created by rokudo on 2017/4/18.
 */

public class SwitchAreaDialog extends DialogFragment implements SwitchAreaView {
	@BindView(R.id.area_cancel)
	TextView cancel;
	@BindView(R.id.area_yes)
	TextView yes;
	@BindView(R.id.province)
	WheelPicker provincePicker;
	@BindView(R.id.city)
	WheelPicker cityPicker;
	@BindView(R.id.area)
	WheelPicker areaPicker;

	private SwitchAreaPresenterImpl mPresenter;
	private boolean isEmpty = true;//areaPicker中是否有数据
	private String city;//点击确定后得到的城市名
	private HomeActivity mActivity;
	/*
	* 省城区的名字
	* */
	private List<String> provinceNameList;
	private List<String> cityNameList;
	private List<String> areaNameList;

	/*
	* 省城区的ID
	* */
	private List<String> provinceIdList;
	private List<String> cityIdList;
	private List<String> areaIdList;


	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
		View view = inflater.inflate(R.layout.dialog_switcharea, container, false);
		ButterKnife.bind(this, view);
		mActivity = (HomeActivity) getActivity();
		provincePicker.setCyclic(false);
		cityPicker.setCyclic(false);
		areaPicker.setCyclic(false);
		mPresenter = new SwitchAreaPresenterImpl(this);
		mPresenter.requestProvince("0");
		mPresenter.requestCity("1");
		setPicker();
		return view;
	}

	/*
	* 省市两级滑动时操作的数据
	* */
	private void setPicker() {
		provincePicker.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
			@Override
			public void onItemSelected(WheelPicker picker, Object data, int position) {
				if (cityNameList != null) {
					cityNameList.clear();
					cityIdList.clear();
				}
				mPresenter.requestCity(provinceIdList.get(position));
			}
		});
		cityPicker.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
			@Override
			public void onItemSelected(WheelPicker picker, Object data, int position) {
				if (areaNameList != null) {
					areaNameList.clear();
					areaIdList.clear();
				}
				mPresenter.requestArea(cityIdList.get(position));
			}
		});
	}

	/*
	* 将省数据添加进第一级控件
	* */
	@Override
	public void addProvince(List<String> provinceNameList, List<String> provinceIdList) {
		this.provinceNameList = provinceNameList;
		this.provinceIdList = provinceIdList;
		provincePicker.setData(provinceNameList);
	}
	/*
	* 将城数据添加进第二级控件
	* */
	@Override
	public void addCity(List<String> cityNameList, List<String> cityIdList) {
		this.cityNameList = cityNameList;
		this.cityIdList = cityIdList;
		cityPicker.setData(cityNameList);
	}
	/*
	* 将区数据添加进第三级控件
	* */
	@Override
	public void addArea(List<String> areaNameList, List<String> areaIdList) {
		this.areaNameList = areaNameList;
		this.areaIdList = areaIdList;
		areaPicker.setData(areaNameList);
		isEmpty = false;
	}
	/*
	* 没有更多数据时清空数据
	* */
	@Override
	public void noMore(List<String> noMore) {
		areaPicker.setData(noMore);
		isEmpty = true;
	}

	@OnClick({R.id.area_cancel, R.id.area_yes})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.area_cancel:
				dismiss();
				break;
			case R.id.area_yes:
				if (isEmpty) {
					city = cityNameList.get(cityPicker.getCurrentItemPosition());
					mActivity.mPresenter.request(city);
					dismiss();
				} else {
					city = areaNameList.get(areaPicker.getCurrentItemPosition());
					mActivity.mPresenter.request(city);
					dismiss();
				}
		}
	}

}
