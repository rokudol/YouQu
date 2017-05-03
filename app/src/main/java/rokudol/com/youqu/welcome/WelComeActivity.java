package rokudol.com.youqu.welcome;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import rokudol.com.youqu.R;
import rokudol.com.youqu.home.HomeActivity;

/**
 * Created by rokudo on 2017/5/3.
 */

public class WelComeActivity extends AppCompatActivity {
	@BindView(R.id.welcome_img)
	ImageView welcomeImg;
	private static final int[] WALLPAPERARRAY = {
			R.mipmap.wallpaper0,
			R.mipmap.wallpaper1,
			R.mipmap.wallpaper2,
			R.mipmap.wallpaper3,
			R.mipmap.wallpaper4,
			R.mipmap.wallpaper5
	};
	private static final float SCALE_END = 1.13F;
	private static final int ANIMATION_DURATION = 2000;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		ButterKnife.bind(this);
		Random random = new Random(SystemClock.elapsedRealtime());
		welcomeImg.setImageResource(WALLPAPERARRAY[random.nextInt(WALLPAPERARRAY.length)]);
		animateImage();
	}

	private void animateImage() {
		ObjectAnimator animatorX = ObjectAnimator.ofFloat(welcomeImg, "scaleX", 1f, SCALE_END);
		ObjectAnimator animatorY = ObjectAnimator.ofFloat(welcomeImg, "scaleY", 1f, SCALE_END);
		AnimatorSet set = new AnimatorSet();
		set.setDuration(ANIMATION_DURATION).play(animatorX).with(animatorY);
		set.start();

		set.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				finishActivity();
			}
		});
	}

	private void finishActivity() {
		io.reactivex.Observable.timer(1000, TimeUnit.MILLISECONDS)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<Long>() {
					@Override
					public void onSubscribe(Disposable d) {

					}

					@Override
					public void onNext(Long value) {
						startActivity(new Intent(WelComeActivity.this, HomeActivity.class));
						overridePendingTransition(0, android.R.anim.fade_out);
						finish();
					}

					@Override
					public void onError(Throwable e) {

					}

					@Override
					public void onComplete() {

					}
				});
	}
}
