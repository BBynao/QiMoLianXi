package com.lc.qimolianxitwo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lc.qimolianxitwo.fragment.FindFragment;
import com.lc.qimolianxitwo.fragment.GroupFragment;
import com.lc.qimolianxitwo.fragment.HomeFragment;
import com.lc.qimolianxitwo.fragment.MeFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    /**
     * 主页
     */
    private RadioButton mRbHome;
    /**
     * 发现
     */
    private RadioButton mRbFind;
    /**
     * 成长
     */
    private RadioButton mRbGroup;
    /**
     * 我的
     */
    private RadioButton mRbMe;
    private RadioGroup mRg;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mRg = (RadioGroup) findViewById(R.id.rg);
        mRbHome = (RadioButton) findViewById(R.id.rb_home);
        mRbFind = (RadioButton) findViewById(R.id.rb_find);
        mRbGroup = (RadioButton) findViewById(R.id.rb_group);
        mRbMe = (RadioButton) findViewById(R.id.rb_me);

        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new FindFragment());
        fragments.add(new GroupFragment());
        fragments.add(new MeFragment());

        mVp.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        mRg.check(R.id.rb_home);
                        break;
                    case 1:
                        mRg.check(R.id.rb_find);
                        break;
                    case 2:
                        mRg.check(R.id.rb_group);
                        break;
                    case 3:
                        mRg.check(R.id.rb_me);
                        break;

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });




        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_home:
                        mVp.setCurrentItem(0);
                        break;
                        case R.id.rb_find:
                            mVp.setCurrentItem(1);
                        break;
                        case R.id.rb_group:
                            mVp.setCurrentItem(2);
                        break;
                        case R.id.rb_me:
                            mVp.setCurrentItem(3);
                        break;
                }

            }
        });

    }
}
