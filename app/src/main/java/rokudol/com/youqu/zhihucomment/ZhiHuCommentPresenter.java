package rokudol.com.youqu.zhihucomment;

import rokudol.com.youqu.base.BasePresenter;

/**
 * Created by rokudo on 2017/4/14.
 */

public interface ZhiHuCommentPresenter extends BasePresenter{
	//请求长评论数据
	void requestLong(int id);
	//请求短评论数据
	void requestShort(int id);
}
