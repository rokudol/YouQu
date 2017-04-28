package rokudol.com.youqu.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by rokudo on 2017/4/12.
 */

public class ToastUtil {
	public static void ToastShort(Context mContext, String msg) {
		Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
	}

	public static void ToastLong(Context mContext, String msg) {
		Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
	}
}
