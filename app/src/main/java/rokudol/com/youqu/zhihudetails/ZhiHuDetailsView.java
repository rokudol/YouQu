package rokudol.com.youqu.zhihudetails;

import android.view.View;

import rokudol.com.youqu.adapter.ZhiHuDetailsAdapter;
import rokudol.com.youqu.base.BaseView;

/**
 * Created by rokudo on 2017/4/13.
 */

public interface ZhiHuDetailsView extends BaseView {
	//设置适配器
	void setItem(ZhiHuDetailsAdapter adapter);

	//跳转到日报详情页
	void goDetailsInfo(int id, String title, String imgUrl, View view);
}
