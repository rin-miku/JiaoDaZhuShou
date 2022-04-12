package com.shinemirai.jiaodazhushou.entity;

import java.io.Serializable;

public class ClassRoomEntity implements Serializable {
    //教室名称
    private String className;
    //1-7课次占用情况
    private String class_1;
    private String class_2;
    private String class_3;
    private String class_4;
    private String class_5;
    private String class_6;
    private String class_7;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClass_1() {
        return class_1;
    }

    public void setClass_1(String class_1) {
        this.class_1 = class_1;
    }

    public String getClass_2() {
        return class_2;
    }

    public void setClass_2(String class_2) {
        this.class_2 = class_2;
    }

    public String getClass_3() {
        return class_3;
    }

    public void setClass_3(String class_3) {
        this.class_3 = class_3;
    }

    public String getClass_4() {
        return class_4;
    }

    public void setClass_4(String class_4) {
        this.class_4 = class_4;
    }

    public String getClass_5() {
        return class_5;
    }

    public void setClass_5(String class_5) {
        this.class_5 = class_5;
    }

    public String getClass_6() {
        return class_6;
    }

    public void setClass_6(String class_6) {
        this.class_6 = class_6;
    }

    public String getClass_7() {
        return class_7;
    }

    public void setClass_7(String class_7) {
        this.class_7 = class_7;
    }

}
