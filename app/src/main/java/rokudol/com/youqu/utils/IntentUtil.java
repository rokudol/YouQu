package rokudol.com.youqu.utils;

import android.content.Context;
import android.content.Intent;

import rokudol.com.youqu.constants.Constants;
import rokudol.com.youqu.home.HomeActivity;
import rokudol.com.youqu.zhihudetailsinfo.ZhiHuDetailsInfo;

/**
 * Created by rokudo on 2017/4/13.
 */

public class IntentUtil {
	public static void setEmptyStart(Context context, Class<?> cls) {
		Intent intent = new Intent(context,cls);
		context.startActivity(intent);
	}

	public static void setZhiHuDestailsId(HomeActivity context, Class<?> zhiHuDetailsInfo, int id) {
		Intent intent = new Intent(context, zhiHuDetailsInfo);
		intent.putExtra(Constants.ZHIHUDETAILSID, id);
		context.startActivity(intent);
	}

	public static int getZhiHuDestailsId(ZhiHuDetailsInfo activity) {
		Intent intent = activity.getIntent();
		return intent.getIntExtra(Constants.ZHIHUDETAILSID, 0);
	}
}
