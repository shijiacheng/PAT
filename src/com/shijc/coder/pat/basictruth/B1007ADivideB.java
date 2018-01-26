package com.shijc.coder.pat.basictruth;

import java.util.Scanner;

/**
 * A除以B
 * 题目描述
 * 本题要求计算A/B，其中A是不超过1000位的正整数，B是1位正整数。
 * 你需要输出商数Q和余数R，使得A = B * Q + R成立。
 * 输入描述:
 * 输入在1行中依次给出A和B，中间以1空格分隔。
 * 输出描述:
 * 在1行中依次输出Q和R，中间以1空格分隔。
 * 输入例子:
 * 123456789050987654321 7
 * 输出例子:
 * 17636684150141093474 3
 *
 * @author shijiacheng
 * @date 2018/1/26
 */
public class B1007ADivideB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        int B = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        int y = 0;//余数
        int curNum = A.charAt(0) - '0';
        if (curNum > B) {
            sb.append(curNum / B);
        }

        for (int i = 1; i < A.length(); i++) {
            y = curNum % B;
            curNum = y * 10 + A.charAt(i) - '0';
            sb.append(curNum / B);
        }

        y = curNum % B;
        if (A.length() == 1 && A.charAt(0) - '0' < B) {
            System.out.println(0 + " " + (A.charAt(0) - '0'));
        } else {
            System.out.println(sb.toString() + " " + y);
        }
    }
}
