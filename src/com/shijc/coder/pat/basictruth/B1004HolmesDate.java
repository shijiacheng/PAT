package com.shijc.coder.pat.basictruth;

import java.util.Scanner;

/**
 * 福尔摩斯的约会
 * 题目描述
 * 大侦探福尔摩斯接到一张奇怪的字条：“我们约会吧！ 3485djDkxh4hhGE 2984akDfkkkkggEdsb
 * s&hgsfdk d&Hyscvnm”。大侦探很快就明白了，字条上奇怪的乱码实际上就是约会的时间“星期四 14:04”，
 * 因为前面两字符串中第1对相同的大写英文字母（大小写有区分）是第4个字母'D'，代表星期四；第2对相同的
 * 字符是'E'，那是第5个英文字母，代表一天里的第14个钟头（于是一天的0点到23点由数字0到9、以及大写字
 * 母A到N表示）；后面两字符串第1对相同的英文字母's'出现在第4个位置（从0开始计数）上，代表第4分钟。
 * 现给定两对字符串，请帮助福尔摩斯解码得到约会的时间。
 * 输入描述:
 * 输入在4行中分别给出4个非空、不包含空格、且长度不超过60的字符串。
 * 输出描述:
 * 在一行中输出约会的时间，格式为“DAY HH:MM”，其中“DAY”是某星期的3字符缩写，即MON表示星期一，
 * TUE表示星期二，WED表示星期三，THU表示星期四，FRI表示星期五，SAT表示星期六，SUN表示星期日。
 * 题目输入保证每个测试存在唯一解。
 * 输入例子:
 * 3485djDkxh4hhGE
 * 2984akDfkkkkggEdsb
 * s&hgsfdk
 * d&Hyscvnm
 * 输出例子:
 * THU 14:04
 *
 * @author shijiacheng
 * @date 2018/2/2
 */
public class B1004HolmesDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        String s3 = sc.next();
        String s4 = sc.next();

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        char[] chars3 = s3.toCharArray();
        char[] chars4 = s4.toCharArray();
        int length1 = s1.length();
        int length2 = s3.length();
        if (s1.length() > s2.length()) {
            length1 = s2.length();
        }
        if (s3.length() > s4.length()) {
            length2 = s4.length();
        }
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        for (int i = 0; i < length1; i++) {
            if (chars1[i] == chars2[i] && chars1[i] >= 'A' && chars1[i] <= 'G') {
                String day = getWeekDay(String.valueOf(chars1[i]));
                sb.append(day);
                sb.append(" ");
                temp = i;
                break;
            }
        }

        for (int i = temp + 1; i < length1; i++) {
            if (chars1[i] == chars2[i]) {
                if (chars1[i] >= 'A' && chars1[i] <= 'N') {
                    int hour = chars1[i] - 'A' + 10;
                    sb.append(hour);
                    sb.append(":");
                    break;
                }
                if (chars1[i] >= '0' && chars1[i] <= '9') {
                    sb.append("0");
                    sb.append(chars1[i]);
                    sb.append(":");
                    break;
                }
            }
        }

        for (int i = 0; i < length2; i++) {
            if (chars3[i] == chars4[i] && ((chars3[i] >= 'A' && chars3[i] <= 'Z') || (chars3[i] >= 'a' && chars3[i] <= 'z'))) {
                int min = i;
                if (min < 10) {
                    sb.append("0");
                }
                sb.append(min);
                break;
            }
        }
        System.out.println(sb.toString());
    }

    /**
     * MON表示星期一，TUE表示星期二，WED表示星期三，THU表示星期四，
     * FRI表示星期五，SAT表示星期六，SUN表示星期日
     *
     * @param week
     * @return
     */
    public static String getWeekDay(String week) {
        String weekDay = "";
        switch (week) {
            case "A":
                weekDay = "MON";
                break;
            case "B":
                weekDay = "TUE";
                break;
            case "C":
                weekDay = "WED";
                break;
            case "D":
                weekDay = "THU";
                break;
            case "E":
                weekDay = "FRI";
                break;
            case "F":
                weekDay = "SAT";
                break;
            case "G":
                weekDay = "SUN";
                break;
        }
        return weekDay;
    }
}
