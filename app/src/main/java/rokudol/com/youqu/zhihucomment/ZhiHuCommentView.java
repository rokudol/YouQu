package rokudol.com.youqu.zhihucomment;

import rokudol.com.youqu.adapter.ZhiHuCommentDetailsAdapter;
import rokudol.com.youqu.base.BaseView;

/**
 * Created by rokudo on 2017/4/14.
 */

public interface ZhiHuCommentView extends BaseView {
	//设置适配器
	void setItem(ZhiHuCommentDetailsAdapter adapter);

}
