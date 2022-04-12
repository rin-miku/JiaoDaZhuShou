package com.shinemirai.jiaodazhushou.util;

import com.shinemirai.jiaodazhushou.entity.ClassRoomEntity;
import com.shinemirai.jiaodazhushou.entity.ScheduleEntity;

import java.util.List;
import java.util.Map;

public class CookieUtils {
    public static Map<String,String> currentCookies;
    public static String studentName;
    public static String studengNumber;
    public static String teachWeek;
    public static String teachYear;
    public static int currentWeek;
    public static int currentHour;

    public static String accountCookie;
    public static String passwordCookie;


    //public static List<GradeHistoryEntity> gradeHistoryEntities;
    //public static List<GradeCurrentEntity> gradeCurrentEntities;
    //public static List<TestPlanEntity> testPlanEntities;
    public static List<ClassRoomEntity> classRoomEntities;
    public static List<ScheduleEntity> scheduleEntities;

    public static String temperature;
    public static String weather;
    public static String updateTime;
    public static String windDir;
    public static String windScale;
    public static String windSpeed;


    //  排课占用 #e46868    228,104,104
    //  考试占用 #394ed6    57,78,214
    //  实验占用 #FF1493    255,20,147
    //  个人占用 #d8cc56    216,204,86
    //  空闲教室 #77bf6d    119,191,109
    public static int sclassNum;
}
