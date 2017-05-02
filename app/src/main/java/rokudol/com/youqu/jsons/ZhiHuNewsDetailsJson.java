package rokudol.com.youqu.jsons;

import java.util.List;

/**
 * Created by rokudo on 2017/4/12.
 */

public class ZhiHuNewsDetailsJson {
	/*
	* @param body:HTML 格式的新闻
	* @param image_source:图片的内容提供方。为了避免被起诉非法使用图片，在显示图片时最好附上其版权信息。
	* @param title:新闻标题
	* @param image:获得的图片同 最新消息 获得的图片分辨率不同。这里获得的是在文章浏览界面中使用的大图。
	* @param share_url:供在线查看内容与分享至 SNS 用的 URL
	* @param js: 供手机端的 WebView(UIWebView) 使用
	* @param ga_prefix:供 Google Analytics 使用
	* @param type:新闻的类型
	* @param id:新闻的 id
	* @param css:供手机端的 WebView(UIWebView) 使用
	* */
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

	public void setBody(String body) {
		this.body = body;
	}

	public void setGa_prefix(String ga_prefix) {
		this.ga_prefix = ga_prefix;
	}

	public void setCss(List<String> css) {
		this.css = css;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setImage_source(String image_source) {
		this.image_source = image_source;
	}

	public void setJs(List<String> js) {
		this.js = js;
	}

	public void setShare_url(String share_url) {
		this.share_url = share_url;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public int getType() {
		return type;
	}

	public List<String> getCss() {
		return css;
	}

	public List<String> getJs() {
		return js;
	}

	public String getBody() {
		return body;
	}

	public String getGa_prefix() {
		return ga_prefix;
	}

	public String getImage() {
		return image;
	}

	public String getImage_source() {
		return image_source;
	}

	public String getShare_url() {
		return share_url;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "ZhihuDetailBean{" +
				"body='" + body + '\'' +
				", image_source='" + image_source + '\'' +
				", title='" + title + '\'' +
				", image='" + image + '\'' +
				", share_url='" + share_url + '\'' +
				", ga_prefix='" + ga_prefix + '\'' +
				", type=" + type +
				", id=" + id +
				", js=" + js +
				", css=" + css +
				'}';
	}
}
