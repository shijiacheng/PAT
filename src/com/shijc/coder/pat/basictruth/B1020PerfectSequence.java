package com.shijc.coder.pat.basictruth;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 完美数列
 * 题目描述
 * 给定一个正整数数列，和正整数p，设这个数列中的最大值是M，最小值是m，如果M <= m * p，
 * 则称这个数列是完美数列。
 * 现在给定参数p和一些正整数，请你从中选择尽可能多的数构成一个完美数列。
 * 输入描述:
 * 输入第一行给出两个正整数N和p，其中N（<= 105）是输入的正整数的个数，p（<= 109）是给定的参数。
 * 第二行给出N个正整数，每个数不超过109。
 * 输出描述:
 * 在一行中输出最多可以选择多少个数可以用它们组成一个完美数列。
 * 输入例子:
 * 10 8
 * 2 3 20 4 5 1 6 7 8 9
 * 输出例子:
 * 8
 *
 * @author shijiacheng
 * @date 2018/1/29
 */
public class B1020PerfectSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int p = sc.nextInt();

        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        int length = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + length; j < N; j++) {
                if (array[j] > array[i] * p)
                    break;
                length++;
            }

        }
        System.out.println(length);
    }
}
