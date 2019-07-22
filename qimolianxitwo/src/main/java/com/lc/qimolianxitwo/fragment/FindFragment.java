package com.lc.qimolianxitwo.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lc.qimolianxitwo.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends Fragment {


    private View view;
    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<Fragment> fragments;

    public FindFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_find, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mTab = (TabLayout) inflate.findViewById(R.id.tab);
        mVp = (ViewPager) inflate.findViewById(R.id.vp);

        fragments = new ArrayList<>();
        fragments.add(new ZhuanFragment());
        fragments.add(new BabyFragment());

        mVp.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

        mTab.setupWithViewPager(mVp);
        mTab.getTabAt(0).setText("专属活动");
        mTab.getTabAt(1).setText("人气宝贝");

    }
}
