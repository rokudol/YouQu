package rokudol.com.youqu.switchtime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aigestudio.wheelpicker.widgets.WheelDayPicker;
import com.aigestudio.wheelpicker.widgets.WheelMonthPicker;
import com.aigestudio.wheelpicker.widgets.WheelYearPicker;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rokudol.com.youqu.R;
import rokudol.com.youqu.tvshow.TvShowFragment;

/**
 * Created by rokudo on 2017/4/20.
 */

public class SwitchTimeDialog extends DialogFragment {
	@BindView(R.id.time_yes)
	TextView yes;
	@BindView(R.id.time_cancel)
	TextView cancel;
	@BindView(R.id.switch_year)
	WheelYearPicker yearPicker;
	@BindView(R.id.switch_month)
	WheelMonthPicker monthPicker;
	@BindView(R.id.switch_day)
	WheelDayPicker dayPicker;

	private String year;
	private String month;
	private String day;

	public static final String RESPONSE = "response";//fragment传值所需标记

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		getDialog().requestWindowFeature(STYLE_NO_TITLE);
		View view = inflater.inflate(R.layout.dialog_switchtime, container, false);
		ButterKnife.bind(this, view);
		return view;
	}

	private String getYear() {
		year = yearPicker.getData().get(yearPicker.getCurrentItemPosition()) + "";
		return year;
	}

	private String getMonth() {
		month = monthPicker.getData().get(monthPicker.getCurrentItemPosition()) + "";
		return month;
	}

	private String getDay() {
		day = dayPicker.getData().get(dayPicker.getCurrentItemPosition()) + "";
		return day;
	}

	@OnClick({R.id.time_yes, R.id.time_cancel})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.time_yes:
				setResult();
				dismiss();
				break;
			case R.id.time_cancel:
				dismiss();
				break;

		}
	}

	protected void setResult() {
		//如果没有targetFragment则不执行该方法
		if (getTargetFragment() == null) {
			return;
		} else {
			Intent intent = new Intent();
			intent.putExtra(RESPONSE, getYear() + "-" + getMonth() + "-" + getDay());
			getTargetFragment().onActivityResult(TvShowFragment.REQUEST,
					Activity.RESULT_OK, intent);
		}
	}

}
