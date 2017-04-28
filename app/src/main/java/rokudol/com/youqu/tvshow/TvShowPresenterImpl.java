package rokudol.com.youqu.tvshow;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rokudol.com.youqu.R;
import rokudol.com.youqu.adapter.TvShowAdapter;
import rokudol.com.youqu.base.BasePresenterImpl;
import rokudol.com.youqu.beans.TvShowBean;
import rokudol.com.youqu.constants.Constants;
import rokudol.com.youqu.jsons.TvJson;
import rokudol.com.youqu.jsons.TvShowJson;
import rokudol.com.youqu.utils.SharedPreferencesUtil;

/**
 * Created by rokudo on 2017/4/19.
 */

public class TvShowPresenterImpl extends BasePresenterImpl<TvShowFragment, TvShowBean> implements TvShowPresenter, TvCallback<TvShowBean>, TvShowCallback<TvShowBean> {
	private TvShowModelImpl mModel;
	private List<TvJson.Result> tvList;
	private List<TvShowJson.Result.Program> tvShowList;
	private String tvId;
	private String tvName;

	@Inject
	public TvShowPresenterImpl(TvShowModelImpl mModel) {
		this.mModel = mModel;
	}


	@Override
	public void requestTv() {
		mModel.requestTv(this);
	}

	@Override
	public void requestTvShow(String time, String id) {
		mModel.requestTvShow(time, id, this);
	}

	@Override
	public void onTvSuccess(TvShowBean data) {
		tvList = data.getTvResults();
		SharedPreferencesUtil.setTvList(mView.getActivity(), Constants.TVLIST, tvList);
		final List<String> nameList = new ArrayList<>();
		for (int i = 0; i < tvList.size(); i++) {
			nameList.add(tvList.get(i).getName());
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(mView.getActivity(), R.layout.tv_item, nameList);
		mView.setTextItem(adapter);
		mView.queryName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				tvName = mView.queryName.getText() + "";
				mView.queryName.setText(tvName);
				for (int i = 0; i < tvList.size(); i++) {
					String name = tvList.get(i).getName();
					if (name.equals(tvName)) {
						tvId = tvList.get(i).getTvid();
						SharedPreferencesUtil.setString(mView.getActivity(), Constants.TVID, tvId);
						SharedPreferencesUtil.setString(mView.getActivity(), Constants.TVNAME, tvName);
						mView.queryName.setSelection(mView.queryName.getText().length());
						break;
					}
				}
			}
		});
	}

	@Override
	public void onTvFailed(String msg) {

	}

	@Override
	public void onTvShowSuccess(TvShowBean dada) {
		tvShowList = dada.getTvShowList();
		TvShowAdapter adapter = new TvShowAdapter(tvShowList, mView.getActivity());
		String tvName = dada.getTvName();
		mView.setRvItem(adapter, tvName);
	}

	@Override
	public void onTvShowFailed(String msg) {
		mView.showMsg(msg);
	}
}
