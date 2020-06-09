package com.liusx.sword.day20200608;

import java.util.HashSet;
import java.util.Set;

/**
 * description: NoRepeatChar 无重复字符的最长子串<br>
 * date: 2020/6/8 22:38 <br>
 * author: liusx <br>
 * version: 1.0 <br>
 */
public class NoRepeatChar {

    /*
    *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    示例 1:
    输入: "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

    示例 2:
    输入: "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

    示例 3:
    输入: "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
         请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
    *
    * */

    /*
    * 思路：
    * 1、无重复首先应该想到的是set，将字符串转换为字符数组来进行遍历
    * 2、如果当前存储的set中出现重复的数字了，那么就应该讲这个set置为空，然后继续遍历这个字符数组
    *
    * */

    public static int lengthOfLongestSubstring(String s) {
        //将字符转换为字符数组
        char[] strArr = s.toCharArray();
        //存放遍历字符数组变量的集合
        Set<Character> noRepeat = new HashSet<Character>();
        //存放最大长度变量
        int length = 0;
        //开始遍历，需要两层循环
        for (int i = 0; i < strArr.length ; i++) {

            //内层循环开始之前，需要将set集合清空，防止上一轮的结尾影响到下一轮。
            noRepeat.clear();//不能放在内层循环结束的位置，因为会影响到特殊情况 s = " " 的情况
            for (int j = i; j < strArr.length ; j++) {
                if(!noRepeat.add(strArr[j])){
                    //如果出现重复
                    if(noRepeat.size() > length){
                        //首先判断当前的set大小是否大于最大长度，如果大于则将该改长度赋值给length变量
                        length = noRepeat.size();
                    }
                    //清空set
                    noRepeat.clear();
                    //把当前遍历的元素重新添加到set中。
                    noRepeat.add(strArr[j]);
                }
            }
            if(noRepeat.size() > length){
                //这个地方也需要判断一下，因为上面做了清空的操作
                length = noRepeat.size();
            }
        }

        //循环结束之后，判断一下。集合大小是否大于length
        if(length < noRepeat.size()){
            return noRepeat.size();
        }
        return length;
    }

    public static void main(String[] args) {
        String s = "au";

        System.out.println(lengthOfLongestSubstring(s));

    }



}
