package rokudol.com.youqu.base;

import android.support.annotation.NonNull;

/**
 * Created by rokudo on 2017/4/13.
 */

public interface BasePresenter {
	/*
	* 与V层生命周期同步
	* */

	void onCreatePresenter();

	void onAttachView(@NonNull BaseView view);

	void onDestroyPrensenter();
}
