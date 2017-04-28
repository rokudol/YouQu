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
import rokudol.com.youqu.jsons.AllCurrency;
import rokudol.com.youqu.utils.CountryImgUtil;

/**
 * Created by rokudo on 2017/4/27.
 */

public class ExChangeAdapter extends RecyclerView.Adapter<ExChangeAdapter.ExChangeViewHolder> {
	private List<AllCurrency.Result> list;
	private Context mContext;

	public ExChangeAdapter(List<AllCurrency.Result> list, Context mContext) {
		this.list = list;
		this.mContext = mContext;
	}

	@Override
	public ExChangeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(mContext).inflate((R.layout.currency_item), parent, false);
		ExChangeViewHolder holder = new ExChangeViewHolder(view);
		return holder;
	}

	@Override
	public void onBindViewHolder(ExChangeViewHolder holder, int position) {
		CountryImgUtil.getCountryImg(holder.countryImg, list.get(position).getCurrency());
		holder.currencyName.setText(list.get(position).getName());
	}

	@Override
	public int getItemCount() {
		return list.size();
	}

	class ExChangeViewHolder extends RecyclerView.ViewHolder {
		@BindView(R.id.item_flag_img)
		ImageView countryImg;
		@BindView(R.id.item_currency_name)
		TextView currencyName;
		@BindView(R.id.item_currency_code)
		TextView currencyCode;
		@BindView(R.id.item_money)
		TextView money;


		public ExChangeViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
	}
}
