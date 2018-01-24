package com.shijc.coder.pat.basictruth;

import java.util.Scanner;

/**
 * 部分A+B
 * 题目描述
 * 正整数A的“DA（为1位整数）部分”定义为由A中所有DA组成的新整数PA。
 * 例如：给定A = 3862767，DA = 6，则A的“6部分”PA是66，因为A中有2个6。
 * 现给定A、DA、B、DB，请编写程序计算PA + PB。
 * 输入描述:
 * 输入在一行中依次给出A、DA、B、DB，中间以空格分隔，其中0 < A, B < 1010。
 * 输出描述:
 * 在一行中输出PA + PB的值。
 * 输入例子:
 * 3862767 6 13530293 3
 * 输出例子:
 * 399
 *
 * @author shijiacheng
 * @date 2018/1/24
 */
public class B1006PartAB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int DA = sc.nextInt();
        int B = sc.nextInt();
        int DB = sc.nextInt();

        int PA = getPartNumber(A, DA);
        int PB = getPartNumber(B, DB);
        System.out.println(PA + PB);

    }

    public static int getPartNumber(int num, int D) {
        int P = 0;
        int count = 0;
        while (num > 0) {
            if (num % 10 == D) {
                count++;
            }
            num = num / 10;
        }

        if (count > 0) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < count; i++) {
                builder.append(D);
            }
            P = Integer.parseInt(builder.toString());
        }
        return P;
    }
}
