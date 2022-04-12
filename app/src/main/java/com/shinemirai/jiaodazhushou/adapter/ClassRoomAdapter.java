package com.shinemirai.jiaodazhushou.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bigkoo.alertview.AlertView;
import com.bigkoo.alertview.OnItemClickListener;
import com.shinemirai.jiaodazhushou.R;
import com.shinemirai.jiaodazhushou.entity.ClassRoomEntity;

import java.util.List;

public class ClassRoomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context mContext;
    private List<ClassRoomEntity> mDatas;

    public ClassRoomAdapter(Context context, List<ClassRoomEntity> datas)
    {
        this.mContext = context;
        this.mDatas = datas;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_classroom,parent,false);
        ClassRoomAdapter.ViewHolder viewHolder = new ClassRoomAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        ClassRoomAdapter.ViewHolder viewHolder = (ClassRoomAdapter.ViewHolder) holder;
        ClassRoomEntity classroomEntity = mDatas.get(position);
        viewHolder.className.setText(classroomEntity.getClassName());
        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
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
                        mContext, AlertView.Style.ActionSheet, new OnItemClickListener(){
                    public void onItemClick(Object o,int position){
                    }
                }).show();
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return mDatas.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView className;//课程名称
        private LinearLayout linearLayout;
        public ViewHolder(@NonNull View view)
        {
            super(view);
            className = view.findViewById(R.id.classroom_className);
            linearLayout = view.findViewById(R.id.classroomCard);
        }
    }
}
