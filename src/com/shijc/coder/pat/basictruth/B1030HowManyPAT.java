package com.shijc.coder.pat.basictruth;

import java.util.Scanner;

/**
 * 有几个PAT
 * 题目描述
 * 字符串APPAPT中包含了两个单词“PAT”，其中第一个PAT是第2位(P),第4位(A),第6位(T)；
 * 第二个PAT是第3位(P),第4位(A),第6位(T)。现给定字符串，问一共可以形成多少个PAT？
 * 输入描述:
 * 输入只有一行，包含一个字符串，长度不超过105，只包含P、A、T三种字母。
 * 输出描述:
 * 在一行中输出给定字符串中包含多少个PAT。由于结果可能比较大，只输出对1000000007取余数的结果。
 * 输入例子:
 * APPAPT
 * 输出例子:
 * 2
 *
 * @author shijiacheng
 * @date 2018/2/1
 */
public class B1030HowManyPAT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();

        int countT = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'T') {
                countT++;
            }
        }
        int countP = 0;
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'P') {
                countP++;
            }
            if (chars[i] == 'T') {
                countT--;
            }
            if (chars[i] == 'A') {
                result = (result + (countP * countT) % 1000000007) % 1000000007;
            }
        }

        System.out.println(result);
    }
}
