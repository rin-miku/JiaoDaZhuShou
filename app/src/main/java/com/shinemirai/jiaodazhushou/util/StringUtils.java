package com.shinemirai.jiaodazhushou.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static boolean isEmpty(String str)//字符串判空函数
    {
        if(str == null || str.length() <= 0)
        {
            return true;
        }
        else
            return false;
    }

    public static boolean isClass(String str)//正则表达式
    {
        int teachWeek = Integer.valueOf(CookieUtils.teachWeek);
        String[] nums;

        //提取第...周中间内容
        String regex="第(.*?)周";
        Pattern p=Pattern.compile(regex);
        Matcher m=p.matcher(str);
        while(m.find())
        {
            str = m.group(1);
        }

        if(str.charAt(2) == '-')
        {
            //区间周
            nums = str.split("\\-");
            if(nums.length == 2)
            {
                int start = 0; int end = 0;
                String startStr = nums[0];
                String endStr = nums[1];
                start = Integer.valueOf(startStr);
                end = Integer.valueOf(endStr);
                if(teachWeek >=start && teachWeek <= end)
                    return true;
            }
        }
        else
        {
            //单双周
            nums = str.split("\\,");
            for(String s : nums)
            {
                s = s.replaceAll(" ","");
                if(Integer.valueOf(s) == teachWeek)
                    return true;
            }
        }
        return false;
    }
}
