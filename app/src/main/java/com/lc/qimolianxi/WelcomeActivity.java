package com.lc.qimolianxi;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    private ImageView mIv;
    /**
     * 5
     */
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initView();
    }

    private void initView() {
        mIv = (ImageView) findViewById(R.id.iv);
        mTv = (TextView) findViewById(R.id.tv);

        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 5, 0, 5);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 5, 0, 5);
        RotateAnimation rotateAnimation = new RotateAnimation(0, 720);
        AnimationSet animationSet = new AnimationSet(this,null);

        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(rotateAnimation);
        mIv.setAnimation(animationSet);

        new CountDownTimer(6000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTv.setText("倒计时：" + millisUntilFinished / 1000);

            }

            @Override
            public void onFinish() {
                startActivity(new Intent(WelcomeActivity.this,MainActivity.class));

            }
        }.start();

    }
}
