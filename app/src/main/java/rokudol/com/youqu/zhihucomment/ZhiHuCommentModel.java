package rokudol.com.youqu.zhihucomment;

import rokudol.com.youqu.beans.ZhiHuBean;
import rokudol.com.youqu.requests.RequesCallback;

/**
 * Created by rokudo on 2017/4/14.
 */

public interface ZhiHuCommentModel {
	//请求长评论数据
	void requestLong(int id, RequesCallback<ZhiHuBean> callback);

	//请求短评论数据
	void requestShort(int id, RequesCallback<ZhiHuBean> callback);

	//初始化
	void init();
}
