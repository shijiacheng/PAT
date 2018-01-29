package com.shijc.coder.pat.basictruth;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * 挖掘机技术哪家强
 * 题目描述
 * 为了用事实说明挖掘机技术到底哪家强，PAT组织了一场挖掘机技能大赛。现请你根据比赛结果统计出技术最强
 * 的那个学校。
 * 输入描述:
 * 输入在第1行给出不超过105的正整数N，即参赛人数。随后N行，每行给出一位参赛者的信息和成绩，包括其所
 * 代表的学校的编号（从1开始连续编号）、及其比赛成绩（百分制），中间以空格分隔。
 * 输出描述:
 * 在一行中给出总得分最高的学校的编号、及其总分，中间以空格分隔。题目保证答案唯一，没有并列。
 * 输入例子:
 * 6
 * 3 65
 * 2 80
 * 1 100
 * 2 70
 * 3 40
 * 3 0
 * 输出例子:
 * 2 150
 *
 * @author shijiacheng
 * @date 2018/1/29
 */
public class B1022TheBestSchool {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int key = sc.nextInt();
            int value = sc.nextInt();
            int score = 0;
            if (map.containsKey(key)) {
                score += map.get(key) + value;
            } else {
                score = value;
            }
            map.put(key, score);
        }

        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
        int value = -1;
        int key = -1;
        while (entries.hasNext()) {

            Map.Entry<Integer, Integer> entry = entries.next();
            if (entry.getValue() > value) {
                value = entry.getValue();
                key = entry.getKey();
            }
        }
        System.out.println(key + " " + value);
    }
}
