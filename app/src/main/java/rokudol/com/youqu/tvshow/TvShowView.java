package rokudol.com.youqu.tvshow;

import android.widget.ArrayAdapter;

import rokudol.com.youqu.adapter.TvShowAdapter;
import rokudol.com.youqu.base.BaseView;

/**
 * Created by rokudo on 2017/4/19.
 */

public interface TvShowView extends BaseView {
	//设置AutoCompleteTextView适配器
	void setTextItem(ArrayAdapter<String> adapter);
	//设置RecyclerView适配器
	void setRvItem(TvShowAdapter adapter,String tvName);
}
