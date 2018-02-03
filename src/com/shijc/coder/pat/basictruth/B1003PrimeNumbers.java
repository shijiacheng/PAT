package com.shijc.coder.pat.basictruth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 数素数 (20)
 * 题目描述
 * 令Pi表示第i个素数。现任给两个正整数M <= N <= 10000，请输出PM到PN的所有素数。
 * 输入描述:
 * 输入在一行中给出M和N，其间以空格分隔。
 * 输出描述:
 * 输出从PM到PN的所有素数，每10个数字占1行，其间以空格分隔，但行末不得有多余空格。
 * 输入例子:
 * 5 27
 * 输出例子:
 * 11 13 17 19 23 29 31 37 41 43
 * 47 53 59 61 67 71 73 79 83 89
 * 97 101 103
 *
 * @author shijiacheng
 * @date 2018/1/23
 */
public class B1003PrimeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int a = 2; a < Integer.MAX_VALUE; a++) {
            int temp = (int) Math.sqrt(a);
            if (a == 2 || a==3) {
                list.add(a);
            } else {
                for (int i = 2; i <= temp; i++) {
                    if (a % i == 0) {
                        break;
                    }
                    if (i >= temp) {
                        list.add(a);
                    }
                }
            }
            if (list.size() == N + M) {
                break;
            }
        }

        int temp = 1;
        for (int i = M; i <= N; i++) {
            if (temp % 10 == 0){
                temp =1;
                System.out.println(list.get(i-1));
            }else {
                temp++;
                if (i == N){
                    System.out.print(list.get(i-1));
                }else {
                    System.out.print(list.get(i-1)+" ");
                }

            }
        }

    }

}
