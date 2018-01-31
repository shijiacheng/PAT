package com.shijc.coder.pat.basictruth;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 到底买不买
 * 题目描述
 * 小红想买些珠子做一串自己喜欢的珠串。卖珠子的摊主有很多串五颜六色的珠串，但是不肯把任何一串拆散了卖。
 * 于是小红要你帮忙判断一下，某串珠子里是否包含了全部自己想要的珠子？如果是，那么告诉她有多少多余的珠子；
 * 如果不是，那么告诉她缺了多少珠子。
 * 为方便起见，我们用[0-9]、[a-z]、[A-Z]范围内的字符来表示颜色。例如，YrR8RrY是小红想做的珠串；
 * 那么ppRYYGrrYBR2258可以买，因为包含了全部她想要的珠子，还多了8颗不需要的珠子；ppRYYGrrYB225不
 * 能买，因为没有黑色珠子，并且少了一颗红色的珠子。
 * 输入描述:
 * 每个输入包含1个测试用例。每个测试用例分别在2行中先后给出摊主的珠串和小红想做的珠串，两串都不超过
 * 1000个珠子。
 * 输出描述:
 * 如果可以买，则在一行中输出“Yes”以及有多少多余的珠子；如果不可以买，则在一行中输出“No”以及缺了多少
 * 珠子。其间以1个空格分隔。
 * 输入例子:
 * ppRYYGrrYBR2258
 * YrR8RrY
 * 输出例子:
 * Yes 8
 *
 * @author shijiacheng
 * @date 2018/1/31
 */
public class B1029BuyOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String oldStr = sc.nextLine();
        String needStr = sc.nextLine();

        Map<Character, Integer> map = new HashMap<>();
        char[] chars = oldStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                int count = map.get(chars[i]);
                map.put(chars[i], count + 1);
            } else {
                map.put(chars[i], 1);
            }
        }

        char[] needChars = needStr.toCharArray();
        int lastCount = 0;
        for (int i = 0; i < needChars.length; i++) {
            if (map.containsKey(needChars[i])) {
                if (map.get(needChars[i]) > 0) {
                    int count = map.get(needChars[i]);
                    map.put(needChars[i], count - 1);
                } else {
                    lastCount++;
                }
            } else {

                lastCount++;
            }
        }

        if (lastCount == 0) {
            System.out.println("Yes " + (oldStr.length() - needStr.length()));
        } else {
            System.out.println("No " + lastCount);
        }

    }
}
