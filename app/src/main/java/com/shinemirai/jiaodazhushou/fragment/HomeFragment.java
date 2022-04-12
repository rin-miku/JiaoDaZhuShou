package com.shinemirai.jiaodazhushou.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shinemirai.jiaodazhushou.R;
import com.shinemirai.jiaodazhushou.activity.AboutActivity;
import com.shinemirai.jiaodazhushou.adapter.ScheduleAdapter;
import com.shinemirai.jiaodazhushou.util.CookieUtils;

public class HomeFragment extends Fragment {

    private TextView updateTime;
    private TextView temperature;
    private TextView weather;
    private TextView windDir;
    private TextView windScale;
    private TextView windSpeed;
    private TextView teachWeek;

    private RecyclerView recyclerView;

    private ImageButton about;
    public HomeFragment()
    {
        // Required empty public constructor
    }

    public static HomeFragment newInstance()
    {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        recyclerView = view.findViewById(R.id.recyeclerViewSchedule);
        about = view.findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AboutActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout relativeLayout = view.findViewById(R.id.img_weather);
        if(CookieUtils.currentHour>6 && CookieUtils.currentHour < 21)
        {
            relativeLayout.setBackgroundResource(R.drawable.bg_day);
        }
        else
            relativeLayout.setBackgroundResource(R.drawable.bg_night);

        updateTime = view.findViewById(R.id.time_weather);
        temperature = view.findViewById(R.id.temperature_weather);
        weather = view.findViewById(R.id.weather);
        windDir = view.findViewById(R.id.windDir);
        windScale = view.findViewById(R.id.windScale);
        windSpeed = view.findViewById(R.id.windSpeed);
        teachWeek = view.findViewById(R.id.teachWeek);

        updateTime.setText("上次更新:"+CookieUtils.updateTime);
        temperature.setText(CookieUtils.temperature );
        weather.setText("℃" + " " +CookieUtils.weather);
        windDir.setText(CookieUtils.windDir);
        windScale.setText("风级:" + CookieUtils.windScale);
        windSpeed.setText("风速:" + CookieUtils.windSpeed);
        teachWeek.setText("当前为第" + CookieUtils.teachWeek + "教学周");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        //嵌套到Application组件
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        //垂直排列
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(getActivity(),CookieUtils.scheduleEntities);
        recyclerView.setAdapter(scheduleAdapter);
    }
}

