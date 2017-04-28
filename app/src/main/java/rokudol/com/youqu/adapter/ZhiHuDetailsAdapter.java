package rokudol.com.youqu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rokudol.com.youqu.R;
import rokudol.com.youqu.beans.ZhiHuBean;
import rokudol.com.youqu.utils.GlideUtil;

/**
 * Created by rokudo on 2017/4/13.
 */

public class ZhiHuDetailsAdapter extends RecyclerView.Adapter<ZhiHuDetailsAdapter.ZhiHuDetailsHolder>{
	private Context mContext;
	private List<ZhiHuBean> list;
	private OnItemClickLisener mOnItemClickLisener;
	private View view;

	public interface OnItemClickLisener {
		void OnItemClick(View view, int position);
	}

	public ZhiHuDetailsAdapter(Context mContext, List<ZhiHuBean> list) {
		this.mContext = mContext;
		this.list = list;
	}

	public void setOnItemClickLisener(OnItemClickLisener lisener) {
		this.mOnItemClickLisener = lisener;
	}

	@Override
	public ZhiHuDetailsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		view = LayoutInflater.from(mContext).inflate(R.layout.zhihudetails_item, parent, false);
		ZhiHuDetailsHolder holder = new ZhiHuDetailsHolder(view);
		return holder;
	}

	@Override
	public void onBindViewHolder(final ZhiHuDetailsHolder holder, final int position) {
		holder.itemView.setTag(position);
		holder.title.setText(list.get(0).getStories().get(position).getTitle());
		GlideUtil.setImage(mContext, list.get(0).getStories().get(position).getImages().get(0),
				R.drawable.ic_load_fail, holder.img);
		holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mOnItemClickLisener != null) {
					mOnItemClickLisener.OnItemClick(holder.img, position);
				}
			}
		});
	}


	@Override
	public int getItemCount() {
		return list == null ? 0 : list.get(0).getStories().size();
	}

	class ZhiHuDetailsHolder extends RecyclerView.ViewHolder {
		@BindView(R.id.zhihudetails_title)
		TextView title;
		@BindView(R.id.zhihudetails_img)
		ImageView img;

		public ZhiHuDetailsHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
	}
}
