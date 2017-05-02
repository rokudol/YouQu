package rokudol.com.youqu.beans;

import java.util.List;

import javax.inject.Inject;

import rokudol.com.youqu.jsons.ZhiHuCommentJson;
import rokudol.com.youqu.jsons.ZhiHuNewsJson;

/**
 * Created by rokudo on 2017/4/13.
 */

public class ZhiHuBean {
	/*
	* @param date:日期
	* @param stories:当日新闻
	* @param top_stories:界面顶部 ViewPager 滚动显示的显示内容
	* @param body:HTML 格式的新闻
	* @param image_source:图片的内容提供方。为了避免被起诉非法使用图片，在显示图片时最
	* @param title:新闻标题
	* @param image:获得的图片同 最新消息 获得的图片分辨率不同。这里获得的是在文章浏览界面中
	* @param share_url:供在线查看内容与分享至 SNS 用的 URL
	* @param js: 供手机端的 WebView(UIWebView) 使用
	* @param ga_prefix:供 Google Analytics 使用
	* @param type:新闻的类型
	* @param id:新闻的 id
	* @param css:供手机端的 WebView(UIWebView) 使用
	* @param long_comments:长评论总数
	* @param popularity:点赞总数
	* @param short_comments:短评论总数
	* @param comments:评论总数
	* @param:commentlist:评论列表
	* */
	@Inject
	public ZhiHuBean() {
	}

	private String date;

	private List<ZhiHuNewsJson.StoriesBean> stories;

	private List<ZhiHuNewsJson.TopStoriesBean> top_stories;

	private String body;

	private String image_source;

	private String title;

	private String image;

	private String share_url;

	private String ga_prefix;

	private int type;

	private int id;

	private List<String> js;

	private List<String> css;

	private int long_comments;
	private int popularity;
	private int short_comments;
	private int comments;

	private List<ZhiHuCommentJson.Comments> commentlist;

	public List<ZhiHuCommentJson.Comments> getCommentlist() {
		return commentlist;
	}

	public void setCommentlist(List<ZhiHuCommentJson.Comments> commentlist) {
		this.commentlist = commentlist;
	}

	public int getLong_comments() {
		return long_comments;
	}

	public void setLong_comments(int long_comments) {
		this.long_comments = long_comments;
	}

	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public int getShort_comments() {
		return short_comments;
	}

	public void setShort_comments(int short_comments) {
		this.short_comments = short_comments;
	}

	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getImage_source() {
		return image_source;
	}

	public void setImage_source(String image_source) {
		this.image_source = image_source;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getShare_url() {
		return share_url;
	}

	public void setShare_url(String share_url) {
		this.share_url = share_url;
	}

	public String getGa_prefix() {
		return ga_prefix;
	}

	public void setGa_prefix(String ga_prefix) {
		this.ga_prefix = ga_prefix;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<String> getJs() {
		return js;
	}

	public void setJs(List<String> js) {
		this.js = js;
	}

	public List<String> getCss() {
		return css;
	}

	public void setCss(List<String> css) {
		this.css = css;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<ZhiHuNewsJson.StoriesBean> getStories() {
		return stories;
	}

	public void setStories(List<ZhiHuNewsJson.StoriesBean> stories) {
		this.stories = stories;
	}

	public List<ZhiHuNewsJson.TopStoriesBean> getTop_stories() {
		return top_stories;
	}

	public void setTop_stories(List<ZhiHuNewsJson.TopStoriesBean> top_stories) {
		this.top_stories = top_stories;
	}
}
