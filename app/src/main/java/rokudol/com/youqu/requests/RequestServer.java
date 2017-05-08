package rokudol.com.youqu.requests;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rokudol.com.youqu.jsons.AllCurrency;
import rokudol.com.youqu.jsons.AreaJson;
import rokudol.com.youqu.jsons.ExChangeJson;
import rokudol.com.youqu.jsons.TvJson;
import rokudol.com.youqu.jsons.TvShowJson;
import rokudol.com.youqu.jsons.WeatherJson;
import rokudol.com.youqu.jsons.ZhiHuCommentJson;
import rokudol.com.youqu.jsons.ZhiHuExtraJson;
import rokudol.com.youqu.jsons.ZhiHuNewsDetailsJson;
import rokudol.com.youqu.jsons.ZhiHuNewsJson;

/**
 * Created by rokudo on 2017/4/13.
 */

public interface RequestServer {
	//知乎日报
	@GET("news/latest")
	Observable<ZhiHuNewsJson> getDailyList();

	//知乎日报详情
	@GET("news/{id}")
	Observable<ZhiHuNewsDetailsJson> getDetailInfo(@Path("id") int id);

	//知乎日报详情的额外信息
	@GET("story-extra/{id}")
	Observable<ZhiHuExtraJson> getDetailExtraInfo(@Path("id") int id);

	//知乎日报详情的长评论
	@GET("story/{id}/long-comments")
	Observable<ZhiHuCommentJson> getLongCommentInfo(@Path("id") int id);

	//知乎日报详情的段评论
	@GET("story/{id}/short-comments")
	Observable<ZhiHuCommentJson> getShortCommentInfo(@Path("id") int id);

	//天气
	@GET("hour24")
	Observable<WeatherJson> getWeather(@Query("area") String area);

	//省城区
	@GET("area/query")
	Observable<AreaJson> getArea(@Query("parentid") String parentid);

	//获取电视台
	@GET("tv/channel")
	Observable<TvJson> getTv();

	//获取电视节目
	@GET("tv/query")
	Observable<TvShowJson> getTvShow(@Query("date") String date, @Query("tvid") String tvid);

	//获取所有货币
	@GET("exchange/currency")
	Observable<AllCurrency> getAllCurrency();

	//汇率换算
	@GET("/exchange/convert")
	Observable<ExChangeJson> getExchange(@Query("amount") String amount, @Query("from") String from, @Query("to") String to);

}
