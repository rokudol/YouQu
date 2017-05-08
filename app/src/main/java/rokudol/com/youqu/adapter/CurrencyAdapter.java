package rokudol.com.youqu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import rokudol.com.youqu.R;
import rokudol.com.youqu.jsons.AllCurrency;
import rokudol.com.youqu.utils.CountryImgUtil;

/**
 * Created by rokudo on 2017/5/8.
 */

public class CurrencyAdapter extends BaseAdapter {
	private List<AllCurrency.Result> list;
	private Context mContext;

	public CurrencyAdapter(List<AllCurrency.Result> list, Context mContext) {
		this.list = list;
		this.mContext = mContext;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		CurrencyViewHolder holder = null;
		if (convertView == null) {
			holder = new CurrencyViewHolder();
			convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.currency_item, parent, false);
			holder.currencyCode = (TextView) convertView.findViewById(R.id.item_currency_code);
			holder.currencyName = (TextView) convertView.findViewById(R.id.item_currency_name);
			holder.currencyImg = (ImageView) convertView.findViewById(R.id.item_flag_img);
			convertView.setTag(holder);
		} else {
			holder = (CurrencyViewHolder) convertView.getTag();
		}
		CountryImgUtil.setCountryImg(holder.currencyImg, list.get(position).getCurrency());
		holder.currencyName.setText(list.get(position).getName());
		holder.currencyCode.setText(list.get(position).getCurrency());
		return convertView;
	}

	static class CurrencyViewHolder {
		private ImageView currencyImg;
		private TextView currencyCode;
		private TextView currencyName;
	}
}
