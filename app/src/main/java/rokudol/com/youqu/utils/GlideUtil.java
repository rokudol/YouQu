package rokudol.com.youqu.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by rokudo on 2017/4/12.
 */

public class GlideUtil {

	public static void setImage(Context context, String url, int errorImgId, ImageView img) {
		Glide.with(context).load(url).error(errorImgId).into(img);
	}
}
