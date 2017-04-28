package rokudol.com.youqu.zhihudetailsinfo;

import java.util.List;

import rokudol.com.youqu.base.BaseView;

/**
 * Created by rokudo on 2017/4/13.
 */

public interface ZhiHuDetailsInfoView extends BaseView {
	//设置web
	void setWeb(String body, List<String> cssList, List<String> jsList);

	//设置评论数
	void setComment(int comment,int shortComment,int longComment);

}
