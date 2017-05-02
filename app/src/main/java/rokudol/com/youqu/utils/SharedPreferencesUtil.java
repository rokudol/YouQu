package rokudol.com.youqu.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import rokudol.com.youqu.jsons.TvJson;

/**
 * Created by rokudo on 2017/4/11.
 * SP的工具类
 */

public class SharedPreferencesUtil {
	public static void setBoolean(Context context, String key, boolean value) {
		SharedPreferences preferences = context.getSharedPreferences("user", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = preferences.edit();
		editor.remove(key);
		editor.putBoolean(key, value).apply();
	}

	public static boolean getBoolean(Context context, String key, boolean vlaue) {
		SharedPreferences preferences = context.getSharedPreferences("user", Context.MODE_PRIVATE);
		return preferences.getBoolean(key, vlaue);
	}

	public static void setString(Context context, String key, String value) {
		SharedPreferences preferences = context.getSharedPreferences("user", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = preferences.edit();
		editor.remove(key);
		editor.putString(key, value).apply();
	}

	public static String getString(Context context, String key, String vlaue) {
		SharedPreferences preferences = context.getSharedPreferences("user", Context.MODE_PRIVATE);
		return preferences.getString(key, vlaue);
	}

	/*
	* 存储电视台集合
	* */

	public static void setTvList(Context context, String key, List<TvJson.Result> list) {
		Gson gson = new Gson();
		String str = gson.toJson(list);
		SharedPreferences preferences = context.getSharedPreferences("user", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = preferences.edit();
		editor.remove(key);
		editor.putString(key, str).apply();
	}
	/*
	* 获取电视台集合
	* */

	public static List<TvJson.Result> getTvList(Context context, String key, String value) {
		SharedPreferences preferences = context.getSharedPreferences("user", Context.MODE_PRIVATE);
		String str = preferences.getString(key, value);
		Gson gson = new Gson();
		List<TvJson.Result> list = gson.fromJson(str, new TypeToken<List<TvJson.Result>>() {
		}.getType());
		return list;
	}
}
