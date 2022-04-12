package com.shinemirai.jiaodazhushou.fragment;

import android.app.NativeActivity;
import android.content.Context;
import android.content.Intent;
import android.gesture.GestureOverlayView;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gjiazhe.multichoicescirclebutton.MultiChoicesCircleButton;
import com.scalified.fab.ActionButton;
import com.shinemirai.jiaodazhushou.R;
import com.shinemirai.jiaodazhushou.activity.HomeActivity;
import com.shinemirai.jiaodazhushou.activity.SClassRoomActivity;
import com.shinemirai.jiaodazhushou.adapter.ClassRoomAdapter;
import com.shinemirai.jiaodazhushou.adapter.ScheduleAdapter;
import com.shinemirai.jiaodazhushou.entity.ClassRoomEntity;
import com.shinemirai.jiaodazhushou.util.CookieUtils;

import java.util.ArrayList;
import java.util.List;

public class ClassRoomFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView = null;

    public ClassRoomFragment()
    {

    }

    public static ClassRoomFragment newInstance()
    {
        ClassRoomFragment fragment = new ClassRoomFragment();
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
        view = inflater.inflate(R.layout.fragment_classroom,container,false);
        recyclerView = view.findViewById(R.id.recyeclerViewClassroom);
        initButton();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //嵌套到Application组件
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        //垂直排列
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        ClassRoomAdapter classroomAdapter = new ClassRoomAdapter(getActivity(),CookieUtils.classRoomEntities);
        recyclerView.setAdapter(classroomAdapter);
    }

    public void initButton()
    {
        MultiChoicesCircleButton.Item item1 = new MultiChoicesCircleButton.Item("CLASS 1", getResources().getDrawable(R.drawable.number1), 10);
        MultiChoicesCircleButton.Item item2 = new MultiChoicesCircleButton.Item("CLASS 2", getResources().getDrawable(R.drawable.number2), 36);
        MultiChoicesCircleButton.Item item3 = new MultiChoicesCircleButton.Item("CLASS 3", getResources().getDrawable(R.drawable.number3), 62);
        MultiChoicesCircleButton.Item item4 = new MultiChoicesCircleButton.Item("CLASS 4", getResources().getDrawable(R.drawable.number4), 90);
        MultiChoicesCircleButton.Item item5 = new MultiChoicesCircleButton.Item("CLASS 5", getResources().getDrawable(R.drawable.number5), 118);
        MultiChoicesCircleButton.Item item6 = new MultiChoicesCircleButton.Item("CLASS 6", getResources().getDrawable(R.drawable.number6), 144);
        MultiChoicesCircleButton.Item item7 = new MultiChoicesCircleButton.Item("CLASS 7", getResources().getDrawable(R.drawable.number7), 170);

        List<MultiChoicesCircleButton.Item> buttonItems = new ArrayList<>();
        buttonItems.add(item1);
        buttonItems.add(item2);
        buttonItems.add(item3);
        buttonItems.add(item4);
        buttonItems.add(item5);
        buttonItems.add(item6);
        buttonItems.add(item7);
        MultiChoicesCircleButton multiChoicesCircleButton = (MultiChoicesCircleButton) view.findViewById(R.id.multiChoicesCircleButton);
        multiChoicesCircleButton.setExpandRadius(325);
        multiChoicesCircleButton.setItemDistanceToCentre(250);
        multiChoicesCircleButton.setItemRadius(38);
        multiChoicesCircleButton.setTextSize(75);
        multiChoicesCircleButton.setShowBackgroundShadowEnable(true);
        multiChoicesCircleButton.setIcon(getResources().getDrawable(R.drawable.search));
        multiChoicesCircleButton.setButtonItems(buttonItems);

        multiChoicesCircleButton.setOnSelectedItemListener(new MultiChoicesCircleButton.OnSelectedItemListener() {
            @Override
            public void onSelected(MultiChoicesCircleButton.Item item, int index) {
                if(index==0)
                    CookieUtils.sclassNum = 1;
                if(index==1)
                    CookieUtils.sclassNum = 2;
                if(index==2)
                    CookieUtils.sclassNum = 3;
                if(index==3)
                    CookieUtils.sclassNum = 4;
                if(index==4)
                    CookieUtils.sclassNum = 5;
                if(index==5)
                    CookieUtils.sclassNum = 6;
                if(index==6)
                    CookieUtils.sclassNum = 7;
                Intent intent = new Intent(getActivity(),SClassRoomActivity.class);
                startActivity(intent);
            }
        });

    }

}
