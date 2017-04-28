package rokudol.com.youqu.zhihudetailsinfo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import rokudol.com.youqu.R;
import rokudol.com.youqu.base.BaseActivity;
import rokudol.com.youqu.component.DaggerComponent;
import rokudol.com.youqu.constants.Constants;
import rokudol.com.youqu.utils.GlideUtil;
import rokudol.com.youqu.utils.HtmlUtil;
import rokudol.com.youqu.zhihucomment.ZhiHuComment;

/**
 * Created by rokudo on 2017/4/13.
 */

public class ZhiHuDetailsInfo extends BaseActivity implements ZhiHuDetailsInfoView {
	@BindView(R.id.zhihudetailsinfo_web)
	WebView web;
	@BindView(R.id.app_bar)
	AppBarLayout appBar;
	@BindView(R.id.toolbar_layout)
	CollapsingToolbarLayout toolbarLayout;
	@BindView(R.id.zhihudetailsinfo_img)
	ImageView img;
	@BindView(R.id.mask_view)
	View maskView;
	@BindView(R.id.toolbar)
	Toolbar toolbar;
	@BindView(R.id.fl_detail_bottom)
	FrameLayout detailFramelayout;
	@BindView(R.id.nsv_zhihu_detail)
	NestedScrollView zhiHuNestedView;
	@BindView(R.id.tv_detail_bottom_comment)
	TextView commentView;
	@BindView(R.id.share)
	TextView share;

	@Inject
	ZhiHuDetailsInfoPresenterImpl mPresenter;

	private int id;
	private String title;
	private String imgUrl;
	private ZhiHuDetailsInfo mActivity;
	private String data;

	//判断底部栏是否显示
	private boolean isShowBottom;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
			Transition explode = TransitionInflater.from(this).inflateTransition(R.transition.explode);
			getWindow().setReenterTransition(explode);
		}
		super.onCreate(savedInstanceState);
	}

	@Override
	protected int getLayoutId() {
		return R.layout.activity_zhihudetailsinfo;
	}

	@Override
	protected void initView() {
		mActivity = this;
		Intent intent = getIntent();
		id = intent.getIntExtra(Constants.ZHIHUDETAILSID, 0);
		title = intent.getStringExtra(Constants.ZHIHUDETAILSTITLE);
		imgUrl = intent.getStringExtra(Constants.ZHIHUBASEURL);
		DaggerComponent.builder().build().inject(this);
		mPrensenter = this.mPresenter;
		mPrensenter.onAttachView(this);
		WebSettings settings = web.getSettings();
		settings.setAppCacheEnabled(true);
		settings.setDomStorageEnabled(true);
		settings.setDatabaseEnabled(true);
		settings.setCacheMode(WebSettings.LOAD_DEFAULT);
		settings.setJavaScriptEnabled(true);
		settings.setLoadWithOverviewMode(true);
		settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
		settings.setSupportZoom(true);
		web.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
		});
		zhiHuNestedView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
			@Override
			public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
				if (scrollY - oldScrollY > 0 && isShowBottom) {  //下移隐藏
					isShowBottom = false;
					detailFramelayout.animate().translationY(detailFramelayout.getHeight());
				} else if (scrollY - oldScrollY < 0 && !isShowBottom) {    //上移出现
					isShowBottom = true;
					detailFramelayout.animate().translationY(0);
				}
			}
		});
		share.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			}
		});
	}

	@Override
	protected void initToolbar() {
		toolbar.setTitle(title);
		setSupportActionBar(toolbar);
		toolbar.setTitleTextColor(Color.WHITE);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);//显示toolbar的返回按钮
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onBackPressed();
			}
		});
		GlideUtil.setImage(this, imgUrl, R.drawable.ic_load_fail, img);
	}

	@Override
	protected void initDrawer() {

	}

	@Override
	protected void work() {
		mPresenter.requestInfo(id);
	}

	@Override
	public void showProgress() {

	}

	@Override
	public void hideProgress() {

	}

	@Override
	public void showMsg(String msg) {

	}

	@Override
	public void setWeb(String body, List<String> cssList, List<String> jsList) {
		data = HtmlUtil.createHtmlData(body, cssList, jsList);
		web.loadData(data, HtmlUtil.MIME_TYPE, HtmlUtil.ENCODING);
	}

	@Override
	public void setComment(final int comment, final int shortComment, final int longComment) {
		commentView.setText(comment + "条评论");
		commentView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(mActivity, ZhiHuComment.class);
				intent.putExtra(Constants.ZHIHUDETAILSID, id);
				intent.putExtra(Constants.ZHIHUCOMMENT, comment);
				intent.putExtra(Constants.ZHIHUSHORTCOMMENT, shortComment);
				intent.putExtra(Constants.ZHIHULONGCOMMENT, longComment);
				ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity);
				startActivity(intent, options.toBundle());
			}
		});
	}

}
