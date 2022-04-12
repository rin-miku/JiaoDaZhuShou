package com.shinemirai.jiaodazhushou.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bigkoo.alertview.AlertView;
import com.bigkoo.alertview.OnItemClickListener;
import com.shinemirai.jiaodazhushou.R;
import com.shinemirai.jiaodazhushou.entity.ClassRoomEntity;
import com.shinemirai.jiaodazhushou.util.CookieUtils;

import java.util.ArrayList;
import java.util.List;

public class SClassRoomActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    List<ClassRoomEntity> temp = new ArrayList<ClassRoomEntity>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showToast("空闲教室筛选完毕~");
        setContentView(R.layout.activity_sclassroom);
        recyclerView = findViewById(R.id.recyeclerViewSClassroom);

        // 课次筛选
        int flag = CookieUtils.sclassNum;

        if(flag == 1)
            for(ClassRoomEntity classRoomEntity:CookieUtils.classRoomEntities)
            {
                if(classRoomEntity.getClass_1().indexOf("空闲教室")!=-1)
                    temp.add(classRoomEntity);
            }
        if(flag == 2)
            for(ClassRoomEntity classRoomEntity:CookieUtils.classRoomEntities)
            {
                if(classRoomEntity.getClass_2().indexOf("空闲教室")!=-1)
                    temp.add(classRoomEntity);
            }
        if(flag == 3)
            for(ClassRoomEntity classRoomEntity:CookieUtils.classRoomEntities)
            {
                if(classRoomEntity.getClass_3().indexOf("空闲教室")!=-1)
                    temp.add(classRoomEntity);
            }
        if(flag == 4)
            for(ClassRoomEntity classRoomEntity:CookieUtils.classRoomEntities)
            {
                if(classRoomEntity.getClass_4().indexOf("空闲教室")!=-1)
                    temp.add(classRoomEntity);
            }
        if(flag == 5)
            for(ClassRoomEntity classRoomEntity:CookieUtils.classRoomEntities)
            {
                if(classRoomEntity.getClass_5().indexOf("空闲教室")!=-1)
                    temp.add(classRoomEntity);
            }
        if(flag == 6)
            for(ClassRoomEntity classRoomEntity:CookieUtils.classRoomEntities)
            {
                if(classRoomEntity.getClass_6().indexOf("空闲教室")!=-1)
                    temp.add(classRoomEntity);
            }
        if(flag == 7)
            for(ClassRoomEntity classRoomEntity:CookieUtils.classRoomEntities)
            {
                if(classRoomEntity.getClass_7().indexOf("空闲教室")!=-1)
                    temp.add(classRoomEntity);
            }

        myAdapter = new MyAdapter();
            recyclerView.setAdapter(myAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(SClassRoomActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder>
    {

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.list_sclassroom, parent,false);
            MyViewHolder myViewHoder = new MyViewHolder(view);
            return myViewHoder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            ClassRoomEntity classroomEntity = temp.get(position);
            holder.sclassroomName.setText(classroomEntity.getClassName());
            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new AlertView(classroomEntity.getClassName(), null, "确定", null,
                            new String[]{
                                    classroomEntity.getClass_1(),
                                    classroomEntity.getClass_2(),
                                    classroomEntity.getClass_3(),
                                    classroomEntity.getClass_4(),
                                    classroomEntity.getClass_5(),
                                    classroomEntity.getClass_6(),
                                    classroomEntity.getClass_7()},
                            SClassRoomActivity.this, AlertView.Style.ActionSheet, new OnItemClickListener(){
                        public void onItemClick(Object o,int position){
                        }
                    }).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return temp.size();
        }
    }


    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView sclassroomName;
        LinearLayout linearLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sclassroomName = itemView.findViewById(R.id.sclassroom_className);
            linearLayout = itemView.findViewById(R.id.sclassroomCard);
        }
    }

    public void showToast(String message)//Toast提示函数
    {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

}
