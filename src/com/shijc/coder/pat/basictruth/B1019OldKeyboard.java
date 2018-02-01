package com.shijc.coder.pat.basictruth;

import java.util.*;

/**
 * 旧键盘
 * 题目描述
 * 旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的
 * 一段文字、以及实际被输入的文字，请你列出肯定坏掉的那些键。
 * 输入描述:
 * 输入在2行中分别给出应该输入的文字、以及实际被输入的文字。每段文字是不超过80个字符的串，
 * 由字母A-Z（包括大、小写）、数字0-9、以及下划线“_”（代表空格）组成。题目保证2个字符串均非空。
 * 输出描述:
 * 按照发现顺序，在一行中输出坏掉的键。其中英文字母只输出大写，每个坏键只输出一次。题目保证至少有1个坏键。
 * 输入例子:
 * 7_This_is_a_test
 * _hs_s_a_es
 * 输出例子:
 * 7TI
 *
 * @author shijiacheng
 * @date 2018/2/1
 */
public class B1019OldKeyboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String old = sc.next();
        String result = sc.next();

        Map<Character, Integer> mapResult = new HashMap<>();
        Map<Character, Integer> mapOld = new HashMap<>();

        char[] charsResult = result.toUpperCase().toCharArray();
        char[] charsOld = old.toUpperCase().toCharArray();

        for (int i = 0; i < charsResult.length; i++) {
            if (!mapResult.containsKey(charsResult[i])) {
                mapResult.put(charsResult[i], i);
            }
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < charsOld.length; i++) {
            if (!mapResult.containsKey(charsOld[i])) {
                if (!mapOld.containsKey(charsOld[i])) {
                    mapOld.put(charsOld[i], i);
                    list.add(charsOld[i]);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }
}
