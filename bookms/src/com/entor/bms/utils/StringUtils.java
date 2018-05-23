package com.entor.bms.utils;

public class StringUtils {

    /**
     * 判断字符序列是否包含指定的字符序列，忽略英文字母大小写
     *
     * @param str  包含的序列
     * @param str2 被包含的序列
     * @return 是否包含
     */
    public static boolean containsIgnoreCase(String str, String str2) {

        // 序列大小写、长度、顺序可能不一致
        if (str == null || str2 == null)
            throw new RuntimeException("参数null指针异常！");

        // 子序列长度超长
        if (str.length() < str2.length())
            return false;

        // 从包含序列的第一个字符开始，长度为str2的字符序列整体与str2进行equalsIgnoreCase比较
        // 每次向后挪动一个位置，直到结束
        for (int i = 0; i < str.length() - str2.length() + 1; i++) {
            // 取字符序列，长度str2.length
            String subStr = str.substring(i, i + str2.length());
            // 忽略大小写equals
            if (subStr.equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }
}
