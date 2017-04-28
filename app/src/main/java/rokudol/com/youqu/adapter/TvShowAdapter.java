package rokudol.com.youqu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rokudol.com.youqu.R;
import rokudol.com.youqu.jsons.TvShowJson;

/**
 * Created by rokudo on 2017/4/20.
 */

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder> {
	private List<TvShowJson.Result.Program> list;
	private Context mContext;

	public TvShowAdapter(List<TvShowJson.Result.Program> list, Context mContext) {
		this.list = list;
		this.mContext = mContext;
	}

	@Override
	public TvShowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(mContext).inflate(R.layout.tvshow_item, parent, false);
		TvShowViewHolder holder = new TvShowViewHolder(view);
		return holder;
	}

	@Override
	public void onBindViewHolder(TvShowViewHolder holder, int position) {
		holder.tvShowName.setText(list.get(position).getName());
		holder.tvShowTime.setText(list.get(position).getStarttime());
	}

	@Override
	public int getItemCount() {
		return list == null ? 0 : list.size();
	}

	class TvShowViewHolder extends RecyclerView.ViewHolder {
		@BindView(R.id.tvshow_name)
		TextView tvShowName;
		@BindView(R.id.tvshow_time)
		TextView tvShowTime;

		public TvShowViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
	}
}
