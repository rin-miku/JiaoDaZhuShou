package com.shinemirai.jiaodazhushou.activity;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.shinemirai.jiaodazhushou.R;
import com.shinemirai.jiaodazhushou.adapter.MyPagerAdapter;
import com.shinemirai.jiaodazhushou.entity.TabEntity;
import com.shinemirai.jiaodazhushou.fragment.ClassRoomFragment;
import com.shinemirai.jiaodazhushou.fragment.HomeFragment;
import com.shinemirai.jiaodazhushou.util.CookieUtils;
import com.shinemirai.jiaodazhushou.util.SpDataUtils;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity{
    private String[] mTitles = { "课程表", "教室资源"};
    private int[] mIconUnselectIds = {
            R.mipmap.tab_home_unselect,
            R.mipmap.tab_application_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.tab_home_select,
            R.mipmap.tab_application_select};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ViewPager viewPager;
    private CommonTabLayout commonTabLayout;

    @Override
    protected int initLayout()
    {
        return R.layout.home_activity;
    }

    @Override
    protected void initView()
    {
        viewPager = findViewById(R.id.viewpager);
        commonTabLayout = findViewById(R.id.commonTabLayout);

        //保存到sp
        SpDataUtils.saveAccountDatas(this, CookieUtils.accountCookie,CookieUtils.passwordCookie);
    }

    @Override
    protected void initData()
    {
        mFragments.add(HomeFragment.newInstance());
        mFragments.add(ClassRoomFragment.newInstance());

        for(int i = 0; i < mTitles.length; i++)
        {
            mTabEntities.add(new TabEntity(mTitles[i],mIconSelectIds[i],mIconUnselectIds[i]));
        }
        commonTabLayout.setTabData(mTabEntities);
        commonTabLayout.setOnTabSelectListener(new OnTabSelectListener()
        {
            @Override
            public void onTabSelect(int position)
            {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position)
            {

            }
        });

        //设置预加载
        viewPager.setOffscreenPageLimit(mFragments.size());

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                commonTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),mTitles,mFragments));


    }
}
