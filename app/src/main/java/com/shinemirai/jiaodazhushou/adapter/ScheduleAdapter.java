package com.shinemirai.jiaodazhushou.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shinemirai.jiaodazhushou.R;
import com.shinemirai.jiaodazhushou.entity.ScheduleEntity;

import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<ScheduleEntity> mDatas;

    public ScheduleAdapter(Context context, List<ScheduleEntity> datas)
    {
        this.mContext = context;
        this.mDatas = datas;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_schedule,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        ViewHolder viewHolder = (ViewHolder) holder;
        ScheduleEntity scheduleEntity = mDatas.get(position);

        viewHolder.className.setText(scheduleEntity.getClassName());
        viewHolder.classRoomName.setText(scheduleEntity.getClassRoomName());
        viewHolder.teacherName.setText(scheduleEntity.getTeacherName());
        viewHolder.classTime.setText(scheduleEntity.getClassTime());
    }

    @Override
    public int getItemCount()
    {
        return mDatas.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView className;//课程名称
        private TextView teacherName;//教师姓名
        private TextView classRoomName;//教室地点
        private TextView classTime;//上课时间

        public ViewHolder(@NonNull View view)
        {
            super(view);
            className = view.findViewById(R.id.schedule_className);
            teacherName = view.findViewById(R.id.schedule_teacherName);
            classRoomName = view.findViewById(R.id.schedule_classRoom);
            classTime = view.findViewById(R.id.schedule_classTime);
        }
    }
}

