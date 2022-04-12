package com.shinemirai.jiaodazhushou.entity;

import java.io.Serializable;

public class ScheduleEntity implements Serializable {
    private String className;//课程名称
    private String teacherName;//教师姓名
    private String classRoomName;//教室地点
    private String classTime;//上课时间

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getClassRoomName() {
        return classRoomName;
    }

    public void setClassRoomName(String classRoomName) {
        this.classRoomName = classRoomName;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }
}
