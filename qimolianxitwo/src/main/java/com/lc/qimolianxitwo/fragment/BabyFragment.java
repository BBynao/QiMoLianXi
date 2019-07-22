package com.lc.qimolianxitwo.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lc.qimolianxitwo.R;
import com.lc.qimolianxitwo.adapter.FoodAdapter;
import com.lc.qimolianxitwo.adapter.LadyAdapter;
import com.lc.qimolianxitwo.api.BabyService;
import com.lc.qimolianxitwo.bean.FoodBean;
import com.lc.qimolianxitwo.bean.LadyBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class BabyFragment extends Fragment {


    private View view;
    private RecyclerView mRev;
    private RecyclerView mRev2;
    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<LadyBean.ResultsBean> mList;
    private ArrayList<FoodBean.DataBean> foodlist;
    private FoodAdapter foodAdapter;
    private LadyAdapter ladyAdapter;
    private ArrayList<Fragment> fragments;


    public BabyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_baby, container, false);
        initView(inflate);
        return inflate;
    }

    private void initLady() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRev.setLayoutManager(linearLayoutManager);
        initData();


    }

    private void initFood() {
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRev2.setLayoutManager(linearLayoutManager1);
        FoodinitData();
    }

    private void initView(View inflate) {
        mRev = (RecyclerView) inflate.findViewById(R.id.rev);
        initLady();
        mRev2 = (RecyclerView) inflate.findViewById(R.id.rev2);
        initFood();
        mTab = (TabLayout) inflate.findViewById(R.id.tab);
        mVp = (ViewPager) inflate.findViewById(R.id.vp);
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new GroupFragment());
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
        mTab.getTabAt(0).setText("全部最新");
        mTab.getTabAt(1).setText("最热精选");
    }

    private void FoodinitData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BabyService.Foodurl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BabyService babyService = retrofit.create(BabyService.class);

        Observable<FoodBean> call = babyService.FoodinitData();

        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FoodBean>() {


                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FoodBean foodBean) {
                        foodlist = new ArrayList<>();
                        List<FoodBean.DataBean> data = foodBean.getData();
                        foodlist.addAll(data);
                        foodAdapter = new FoodAdapter(getContext(), foodlist);
                        mRev.setAdapter(foodAdapter);
                        //foodAdapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("tag", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BabyService.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BabyService babyService = retrofit.create(BabyService.class);

        Observable<LadyBean> call = babyService.initData();

        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LadyBean>() {


                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LadyBean ladyBean) {
                        mList = new ArrayList<>();
                        List<LadyBean.ResultsBean> results = ladyBean.getResults();
                        mList.addAll(results);
                        ladyAdapter = new LadyAdapter(getContext(), mList);
                        mRev.setAdapter(ladyAdapter);

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
