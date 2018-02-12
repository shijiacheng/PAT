package com.shijc.coder.pat.basicpractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 诶波那契凤尾
 * 题目描述
 * NowCoder号称自己已经记住了1-100000之间所有的斐波那契数。
 * 为了考验他，我们随便出一个数n，让他说出第n个斐波那契数。当然，斐波那契数会很大。
 * 因此，如果第n个斐波那契数不到6位，则说出该数；否则只说出最后6位。
 * 输入描述:
 * 输入有多组数据。
 * 每组数据一行，包含一个整数n (1≤n≤100000)。
 * 输出描述:
 * 对应每一组输入，输出第n个斐波那契数的最后6位。
 * 输入例子:
 * 1
 * 2
 * 3
 * 4
 * 100000
 * 输出例子:
 * 1
 * 2
 * 3
 * 5
 * 537501
 *
 * @author shijiacheng
 * @date 2018/2/12.
 */
public class BP1005FibonacciTail {
    static Map<Integer, Long> map = new HashMap<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            long result = getFibonacci(n);
            int length = String.valueOf(result).length();
            if (length>6){
                String str = String.valueOf(result).substring(length-6);
                System.out.println(str);
            }else {
                System.out.println(result);
            }

        }

    }

    public static long getFibonacci(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        //1、1、2、3、5……
        long prePreNum = 1;
        long preNum = 2;
        long result = 0;
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            for (int i = 3; i <= n; i++) {
                result = prePreNum + preNum;
                map.put(i, result);
                prePreNum = preNum;
                preNum = result;
            }
            return result;
        }


    }
}
