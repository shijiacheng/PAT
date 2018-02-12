package com.shijc.coder.pat.basicpractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 客似云来
 * 题目描述
 * NowCoder开了一家早餐店，这家店的客人都有个奇怪的癖好：他们只要来这家店吃过一次早餐，
 * 就会每天都过来；并且，所有人在这家店吃了两天早餐后，接下来每天都会带一位新朋友一起来品尝。
 * 于是，这家店的客人从最初一个人发展成浩浩荡荡成百上千人：1、1、2、3、5……
 * 现在，NowCoder想请你帮忙统计一下，某一段时间范围那他总共卖出多少份早餐（假设每位客人只吃一份早餐）。
 * 输入描述:
 * 测试数据包括多组。每组数据包含两个整数from和to(1≤from≤to≤80)，分别代表开店的第from天和第to天。
 * 输出描述:
 * 对应每一组输入，输出从from到to这些天里（包含from和to两天），需要做多少份早餐。
 * 输入例子:
 * 1 10
 * 2 8
 * 36 80
 * 输出例子:
 * 143
 * 53
 * 61305790697453774
 *
 * @author shijiacheng
 * @date 2018/2/12.
 */
public class BP1004GuestArrive {
    private static Map<Integer, Long> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            long count = 0;
            for (int i = from; i <= to; i++) {
                count = count + getPersonCount(i);
            }
            System.out.println(count);
        }

    }

    public static long getPersonCount(int day) {
        if (day == 1) {
            return 1;
        }
        if (day == 2) {
            return 1;
        }
        //1、1、2、3、5……
        long prePreNum = 1;
        long preNum = 1;
        long result = 0;
        if (map.containsKey(day)) {
            return map.get(day);
        } else {
            for (int i = 3; i <= day; i++) {
                result = prePreNum + preNum;
                map.put(i, result);
                prePreNum = preNum;
                preNum = result;
            }
            return result;
        }

    }
}
