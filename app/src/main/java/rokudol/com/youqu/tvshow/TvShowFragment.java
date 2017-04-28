package rokudol.com.youqu.tvshow;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.andexert.library.RippleView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import rokudol.com.youqu.R;
import rokudol.com.youqu.adapter.TvShowAdapter;
import rokudol.com.youqu.base.BaseFragment;
import rokudol.com.youqu.component.DaggerComponent;
import rokudol.com.youqu.constants.Constants;
import rokudol.com.youqu.home.HomeActivity;
import rokudol.com.youqu.jsons.TvJson;
import rokudol.com.youqu.switchtime.SwitchTimeDialog;
import rokudol.com.youqu.utils.SharedPreferencesUtil;
import rokudol.com.youqu.utils.ToastUtil;

/**
 * Created by rokudo on 2017/4/19.
 */

public class TvShowFragment extends BaseFragment<TvShowPresenterImpl> implements TvShowView {
	@BindView(R.id.tvshow_rv)
	RecyclerView rv;
	@BindView(R.id.query_time)
	TextView queryTime;
	@BindView(R.id.query_tvname)
	AutoCompleteTextView queryName;
	@BindView(R.id.tv_query)
	Button query;
	@BindView(R.id.tv_name)
	TextView tvShowName;
	@BindView(R.id.rip)
	RippleView rip;
	private HomeActivity mActivity;
	private String tvName;
	private String tvId;
	private String time;
	private List<TvJson.Result> list;//获取保存的list集合

	@Inject
	TvShowPresenterImpl mPresenter;

	@Inject
	public TvShowFragment() {
	}

	@Override
	public void showProgress() {

	}

	@Override
	public void hideProgress() {

	}

	@Override
	public void showMsg(String msg) {
		ToastUtil.ToastShort(getActivity(), msg);
	}

	@Override
	protected int getLayoutId() {
		return R.layout.framgnet_tvshow;
	}

	@Override
	protected void initView() {
		mActivity = (HomeActivity) getActivity();
		DaggerComponent.builder().build().inject(this);
		Bundle bundle = getArguments();
		if (bundle != null) {
			String time = bundle.getString("time");
			queryTime.setText(time);
		}
		mPrensenter = mPresenter;
		mPrensenter.onAttachView(this);
		tvName = SharedPreferencesUtil.getString(getActivity(), Constants.TVNAME, "");
		tvId = SharedPreferencesUtil.getString(getActivity(), Constants.TVID, "");
		if (tvName.equals("") && tvId.equals("") || tvName == null && tvId == null) {
			mPresenter.requestTv();
		} else {
			queryName.setText(tvName);
			queryName.setSelection(queryName.getText().length());
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(new Date());
		mPresenter.requestTvShow(date, "755");
	}

	@Override
	protected void initToolbar() {

	}

	@Override
	protected void work() {

	}

	@OnClick({R.id.query_time, R.id.rip, R.id.query_tvname})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.query_time:
				SwitchTimeDialog fragment = new SwitchTimeDialog();
				fragment.show(getFragmentManager(), "switchTimeDialog");
				break;
			case R.id.query_tvname:
				setTvItem();
				break;
			case R.id.rip:
				if (queryName.getText().equals("")) {
					showMsg("请输入要查询的电视台");
				} else if (queryTime.getText().equals("")) {
					showMsg("请选择要查询的时间");
				} else {
					time = queryTime.getText() + "";
					mPresenter.requestTvShow(time, tvId);
				}
				break;

		}
	}

	private void setTvItem() {
		list = new ArrayList<>();
		list = SharedPreferencesUtil.getTvList(getActivity(), Constants.TVLIST, "");
		Log.i("`````````````", list + "");
		if (list != null) {
			final List<String> nameList = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				nameList.add(list.get(i).getName());
			}
			ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getActivity(), R.layout.tv_item, nameList);
			queryName.setAdapter(myAdapter);
			queryName.setThreshold(1);
			queryName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					tvName = queryName.getText() + "";
					queryName.setText(tvName);
					for (int i = 0; i < list.size(); i++) {
						String name = list.get(i).getName();
						if (name.equals(tvName)) {
							tvId = list.get(i).getTvid();
							SharedPreferencesUtil.setString(getActivity(), Constants.TVID, tvId);
							SharedPreferencesUtil.setString(getActivity(), Constants.TVNAME, tvName);
							queryName.setSelection(queryName.getText().length());
							break;
						}
					}
				}
			});
		} else {
			mPresenter.requestTv();
		}
	}

	@Override
	public void setTextItem(ArrayAdapter<String> adapter) {
		queryName.setAdapter(adapter);
		queryName.setThreshold(1);
	}

	@Override
	public void setRvItem(TvShowAdapter adapter, String tvName) {
		rv.setLayoutManager(new LinearLayoutManager(getActivity()));
		rv.setAdapter(adapter);
		tvShowName.setText(tvName);
	}
}
