package com.shijc.coder.pat.basictruth;

import java.util.Scanner;

/**
 * 打印沙漏
 * 题目描述
 * 本题要求你写个程序把给定的符号打印成沙漏的形状。例如给定17个“*”，要求按下列格式打印
 * *****
 *  ***
 *   *
 *  ***
 * *****
 * 所谓“沙漏形状”，是指每行输出奇数个符号；各行符号中心对齐；相邻两行符号数差2；符号数
 * 先从大到小顺序递减到1，再从小到大顺序递增；首尾符号数相等。
 * 给定任意N个符号，不一定能正好组成一个沙漏。要求打印出的沙漏能用掉尽可能多的符号。
 * 输入描述:
 * 输入在一行给出1个正整数N（<=1000）和一个符号，中间以空格分隔。
 * 输出描述:
 * 首先打印出由给定符号组成的最大的沙漏形状，最后在一行中输出剩下没用掉的符号数。
 * 输入例子:
 * 19 *
 * 输出例子:
 * *****
 *  ***
 *   *
 *  ***
 * *****
 * 2
 *
 * @author shijiacheng
 * @date 2018/2/1
 */
public class B1017PrintHourglass {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();

        double temp = Math.pow((N+1)*1.0/2,0.5);
        int n = (int) temp;

        for (int i = n; i > 1; i--) {
            for (int j = 0; j < n-i; j++) {
                System.out.print(" ");
            }
            for(int k = 0; k < 2*i-1; k++){   //每行要打印的符号的个数（相对于前一行多两个）
                System.out.print(str);
            }
            System.out.println();   //换行打印
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n-i; j++) {
                System.out.print(" ");
            }
            for(int k = 0; k < 2*i-1; k++){   //每行要打印的符号的个数（相对于前一行多两个）
                System.out.print(str);
            }
            System.out.println();   //换行打印
        }
        int sum = N-(2*n*n-1);
        System.out.println(sum);
    }
}
