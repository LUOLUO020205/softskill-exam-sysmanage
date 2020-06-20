package com.softskill.exam.tools;

public class StringUtils {

    /**
     * 判断字符串是否不为空
     *
     * @param data
     * @return
     */
    public static boolean isNotBlank(String data) {
        if (null == data || "".equalsIgnoreCase(data)) {
            return false;
        }
        return true;
    }

    /**
     * 判断字符串是否为空
     *
     * @param data
     * @return
     */
    public static boolean isBlank(String data) {
        return !isNotBlank(data);
    }

}
