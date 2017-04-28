package rokudol.com.youqu.home;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

import javax.inject.Inject;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;
import rokudol.com.youqu.R;
import rokudol.com.youqu.base.BaseActivity;
import rokudol.com.youqu.component.DaggerComponent;
import rokudol.com.youqu.constants.Constants;
import rokudol.com.youqu.exchange.ExChangeFragment;
import rokudol.com.youqu.switcharea.SwitchAreaDialog;
import rokudol.com.youqu.tvshow.TvShowFragment;
import rokudol.com.youqu.utils.GlideUtil;
import rokudol.com.youqu.utils.SharedPreferencesUtil;
import rokudol.com.youqu.utils.ToastUtil;
import rokudol.com.youqu.zhihudetails.ZhiHuDetails;

/**
 * Created by rokudo on 2017/4/17.
 */

public class HomeActivity extends BaseActivity implements HomeView {
	@BindView(R.id.normal_toolbar)
	Toolbar toolbar;
	@BindView(R.id.drawer)
	DrawerLayout drawer;
	@BindView(R.id.framelayout)
	FrameLayout frameLayout;
	@BindView(R.id.nav)
	NavigationView nav;
	@Inject
	ZhiHuDetails zhiHuDetails;
	@Inject
	TvShowFragment tvShow;


	private BaseActivity mActivity;
	@Inject
	public HomePresenterImpl mPresenter;

	//声明AMapLocationClient类对象
	public AMapLocationClient mLocationClient = null;
	//声明AMapLocationClientOption对象
	public AMapLocationClientOption mLocationOption = null;
	//声明定位回调监听器
	public AMapLocationListener mLocationListener = new AMapLocationListener() {
		@Override
		public void onLocationChanged(AMapLocation aMapLocation) {
			if (aMapLocation != null) {
				if (aMapLocation.getErrorCode() == 0) {
					//可在其中解析aMapLocation获取相应内容。
					Log.i("``````````", aMapLocation.getDistrict());
					mPresenter.request(aMapLocation.getDistrict());
				} else {
					//定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
					Log.e("AmapError", "location Error, ErrCode:"
							+ aMapLocation.getErrorCode() + ", errInfo:"
							+ aMapLocation.getErrorInfo());
				}
			}
		}
	};


	@Override
	protected int getLayoutId() {
		return R.layout.activity_main;
	}

	@Override
	protected void initView() {
		mActivity = this;
		initNightModeSwitch();
		DaggerComponent.builder().build().inject(this);
		mPrensenter = this.mPresenter;
		mPrensenter.onAttachView(this);
		setLocation();
	}

	@Override
	protected void initToolbar() {
		setSupportActionBar(toolbar);
	}

	@Override
	protected void initDrawer() {
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
				R.string.navigation_drawer_open, R.string.navigation_drawer_close);
		drawer.addDrawerListener(toggle);
		toggle.syncState();

		nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem item) {
				switch (item.getItemId()) {
					case R.id.zhihu_details:
						toolbar.setTitle(R.string.zhihu_details);
						goZhiHuDetails();
						break;
					case R.id.tvshow:
						toolbar.setTitle(R.string.tvshow);
						goTvShow();
						break;
					case R.id.exchange:
						toolbar.setTitle(R.string.exchange);
						goExChange();
						break;
				}
				drawer.closeDrawer(Gravity.START);
				return false;
			}
		});
	}

	private void initNightModeSwitch() {
		MenuItem menuNightMode = nav.getMenu().findItem(R.id.night_mode);
		SwitchCompat dayNightSwitch = (SwitchCompat) MenuItemCompat
				.getActionView(menuNightMode);
		setCheckedState(dayNightSwitch);
		setCheckedEvent(dayNightSwitch);
	}

	private void setCheckedState(SwitchCompat dayNightSwitch) {
		boolean isNight = SharedPreferencesUtil.getBoolean(mActivity, Constants.ISNIGHT, false);
		if (isNight) {
			dayNightSwitch.setChecked(true);
		} else {
			dayNightSwitch.setChecked(false);
		}
	}

	private void setCheckedEvent(SwitchCompat dayNightSwitch) {
		dayNightSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					SharedPreferencesUtil.setBoolean(mActivity, Constants.ISNIGHT, true);
					AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
				} else {
					SharedPreferencesUtil.setBoolean(mActivity, Constants.ISNIGHT, false);
					AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
				}
				drawer.closeDrawer(GravityCompat.START);
				recreate();
			}
		});
	}

	@Override
	protected void work() {
		goZhiHuDetails();
	}

	private void goZhiHuDetails() {
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		Fragment fragment = zhiHuDetails;
//		if (getCurrentfragment() == null) {
		ft.replace(R.id.framelayout, fragment);
//			ft.addToBackStack(null);
		ft.commit();
//		} else {
//			ft.hide(getCurrentfragment());
//			ft.add(R.id.framelayout, fragment);
//			ft.addToBackStack(null);
//			ft.commit();
//		}
	}

	private void goExChange() {
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		Fragment fragment = new ExChangeFragment();
		ft.replace(R.id.framelayout, fragment);
		ft.commit();
	}

	private void goTvShow() {
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		Fragment fragment = tvShow;
		ft.replace(R.id.framelayout, fragment);
		ft.commit();
	}


	public Fragment getCurrentfragment() {
		Fragment current = getSupportFragmentManager().findFragmentById(R.id.framelayout);
		if (current != null && current.isHidden()) {
			Fragment fragment = zhiHuDetails;
			if (!fragment.isHidden()) {
				current = fragment;
			}
		}
		return current;
	}

	private void setLocation() {
		//初始化定位
		mLocationClient = new AMapLocationClient(getApplicationContext());
		//设置定位回调监听
		mLocationClient.setLocationListener(mLocationListener);
		//初始化AMapLocationClientOption对象
		mLocationOption = new AMapLocationClientOption();
		//设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
		mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
		//获取一次定位结果：
		//该方法默认为false。
		mLocationOption.setOnceLocation(true);
		//获取最近3s内精度最高的一次定位结果：
		//设置setOnceLocationLatest(boolean b)接口为true，启动定位时SDK会返回最近3s内精度最高的一次定位结果。如果设置其为true，setOnceLocation(boolean b)接口也会被设置为true，反之不会，默认为false。
		mLocationOption.setOnceLocationLatest(true);
		//给定位客户端对象设置定位参数
		mLocationClient.setLocationOption(mLocationOption);
		//启动定位
		mLocationClient.startLocation();
	}

	@Override
	public void showProgress() {

	}

	@Override
	public void hideProgress() {

	}

	@Override
	public void showMsg(String msg) {
		ToastUtil.ToastShort(this, msg);
	}

	@Override
	public void setWeather(String imgUrl, String type, String temperature, String area) {
		View view = nav.getHeaderView(0);
		CircleImageView img;
		TextView temperatureTv, typeTv, areaTv;
		img = (CircleImageView) view.findViewById(R.id.weather_icon);
		temperatureTv = (TextView) view.findViewById(R.id.weather_temperature);
		typeTv = (TextView) view.findViewById(R.id.weather_type);
		areaTv = (TextView) view.findViewById(R.id.weaher_area);
		GlideUtil.setImage(this, Constants.WEATHERIMGURL +
				imgUrl + ".png", R.drawable.ic_load_fail, img);
		temperatureTv.setText("当前温度：" + temperature + "度");
		typeTv.setText("天气：" + type);
		areaTv.setText(area);
		areaTv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				SwitchAreaDialog fragment = new SwitchAreaDialog();
				fragment.show(getSupportFragmentManager(), "switchAreaDialog");
			}
		});
	}
}
