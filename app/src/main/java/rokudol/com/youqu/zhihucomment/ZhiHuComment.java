package rokudol.com.youqu.zhihucomment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rokudol.com.youqu.R;
import rokudol.com.youqu.adapter.ZhiHuCommentAdapter;
import rokudol.com.youqu.base.BaseActivity;
import rokudol.com.youqu.constants.Constants;

/**
 * Created by rokudo on 2017/4/14.
 */

public class ZhiHuComment extends BaseActivity {

	@BindView(R.id.zhihucomment_vp)
	ViewPager vp;
	@BindView(R.id.tab_toolbar)
	Toolbar toolbar;
	@BindView(R.id.tab)
	TabLayout tab;

	public int id;
	private int allComment;
	private int shortComment;
	private int longComment;

	private List<Fragment> fragmentList;
	private List<String> titleList;


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
			Transition explode = TransitionInflater.from(this).inflateTransition(R.transition.explode);
			getWindow().setEnterTransition(explode);
			getWindow().setExitTransition(explode);
			getWindow().setReenterTransition(explode);
		}
		super.onCreate(savedInstanceState);
	}


	@Override
	protected int getLayoutId() {
		return R.layout.activity_zhihucomment;
	}

	@Override
	protected void initView() {
		Intent intent = getIntent();
		id = intent.getIntExtra(Constants.ZHIHUDETAILSID, 0);
		allComment = intent.getIntExtra(Constants.ZHIHUCOMMENT, 0);
		shortComment = intent.getIntExtra(Constants.ZHIHUSHORTCOMMENT, 0);
		longComment = intent.getIntExtra(Constants.ZHIHULONGCOMMENT, 0);
		initFragmentList();
		ZhiHuCommentAdapter adapter = new ZhiHuCommentAdapter(getSupportFragmentManager(), fragmentList, titleList);
		vp.setAdapter(adapter);
		adapter.notifyDataSetChanged();
		tab.setTabMode(TabLayout.MODE_FIXED);
		tab.setupWithViewPager(vp);
	}

	@Override
	protected void initToolbar() {
		toolbar.setTitle(allComment + "条评论");
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
	}

	@Override
	protected void initDrawer() {

	}

	@Override
	protected void work() {

	}

	private void initFragmentList() {
		fragmentList = new ArrayList<>();
		titleList = new ArrayList<>();

		titleList.add(shortComment + "条短评论");
		titleList.add(longComment + "条长评论");

		fragmentList.add(new ZhiHuCommentFragment(true));
		fragmentList.add(new ZhiHuCommentFragment(false));
	}

}
