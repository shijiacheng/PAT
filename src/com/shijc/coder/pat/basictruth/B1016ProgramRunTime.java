package com.shijc.coder.pat.basictruth;

import java.util.Scanner;

/**
 * 程序运行时间
 * 题目描述
 * 要获得一个C语言程序的运行时间，常用的方法是调用头文件time.h，其中提供了clock()函数，
 * 可以捕捉从程序开始运行到clock()被调用时所耗费的时间。这个时间单位是clock tick，即
 * “时钟打点”。同时还有一个常数CLK_TCK，给出了机器时钟每秒所走的时钟打点数。于是为了获
 * 得一个函数f的运行时间，我们只要在调用f之前先调用clock()，获得一个时钟打点数C1；在f执
 * 行完成后再调用clock()，获得另一个时钟打点数C2；两次获得的时钟打点数之差(C2-C1)就是
 * f运行所消耗的时钟打点数，再除以常数CLK_TCK，就得到了以秒为单位的运行时间。这里不妨简
 * 单假设常数CLK_TCK为100。现给定被测函数前后两次获得的时钟打点数，请你给出被测函数运行的时间。
 * 输入描述:
 * 输入在一行中顺序给出2个整数C1和C2。注意两次获得的时钟打点数肯定不相同，即C1 < C2，并且
 * 取值在[0, 107]
 * 输出描述:
 * 在一行中输出被测函数运行的时间。运行时间必须按照“hh:mm:ss”（即2位的“时:分:秒”）格式
 * 输出；不足1秒的时间四舍五入到秒。
 * 输入例子:
 * 123 4577973
 * 输出例子:
 * 12:42:59
 *
 * @author shijiacheng
 * @date 2018/2/1
 */
public class B1016ProgramRunTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C1 = sc.nextInt();
        int C2 = sc.nextInt();

        float temp = (C2 - C1) * 1.0f / 100;
        int time = Math.round(temp);
        int hour = time / 3600;
        time = time - hour * 3600;
        int min = time / 60;
        time = time - min * 60;
        int second = time;

        StringBuilder sb = new StringBuilder();
        if (hour < 10) {
            sb.append(0);
        }
        sb.append(hour);
        sb.append(":");
        if (min < 10) {
            sb.append(0);
        }
        sb.append(min);
        sb.append(":");
        if (second < 10) {
            sb.append(0);
        }
        sb.append(second);
        System.out.println(sb.toString());
    }
}
