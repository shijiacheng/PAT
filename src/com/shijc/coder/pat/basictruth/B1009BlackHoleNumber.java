package com.shijc.coder.pat.basictruth;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 数字黑洞
 * 题目描述
 * 给定任一个各位数字不完全相同的4位正整数，如果我们先把4个数字按非递增排序，再按非递减排序，
 * 然后用第1个数字减第2个数字，将得到一个新的数字。一直重复这样做，我们很快会停在有“数字黑洞”
 * 之称的6174，这个神奇的数字也叫Kaprekar常数。
 * 例如，我们从6767开始，将得到
 * 7766 - 6677 = 1089
 * 9810 - 0189 = 9621
 * 9621 - 1269 = 8352
 * 8532 - 2358 = 6174
 * 7641 - 1467 = 6174
 * ... ...
 * 现给定任意4位正整数，请编写程序演示到达黑洞的过程。
 * 输入描述:
 * 输入给出一个(0, 10000)区间内的正整数N。
 * 输出描述:
 * 如果N的4位数字全相等，则在一行内输出“N - N = 0000”；否则将计算的每一步在一行内输出，
 * 直到6174作为差出现，输出格式见样例,每行中间没有空行。注意每个数字按4位数格
 * 式输出。
 * 输入例子:
 * 6767
 * 输出例子:
 * 7766 - 6677 = 1089
 * 9810 - 0189 = 9621
 * 9621 - 1269 = 8352
 * 8532 - 2358 = 6174
 *
 * @author shijiacheng
 * @date 2018/1/26
 */
public class B1009BlackHoleNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        try {
            String s = String.valueOf(N);
            if (s.length() < 4) {
                int length = s.length();
                for (int i = 0; i < 4-length; i++) {
                    s = "0" + s;
                }
            }
            char[] chars = s.toCharArray();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < chars.length; i++) {
                set.add(chars[i]);
            }
            if (set.size()==1) {
                System.out.println(N + " - " + N + " = 0000");
            } else if (N==6174){
                String str = String.valueOf(N);
                int n1 = Integer.valueOf(new String(sort(str.toCharArray(), 1)));
                int n2 = Integer.valueOf(new String(sort(str.toCharArray(), 0)));
                N = n1 - n2;

                System.out.println(new String(sort(str.toCharArray(), 1))
                        + " - " + new String(sort(str.toCharArray(), 0))
                        + " = " + "6174");
            }else {

                while (N != 6174) {
                    String str = String.valueOf(N);
                    if (str.length() < 4) {
                        int length = str.length();
                        for (int i = 0; i < 4-length; i++) {
                            str = "0" + str;
                        }
                    }

                    int n1 = Integer.valueOf(new String(sort(str.toCharArray(), 1)));
                    int n2 = Integer.valueOf(new String(sort(str.toCharArray(), 0)));
                    N = n1 - n2;
                    String strnew = String.valueOf(N);
                    if (strnew.length() < 4) {
                        int length = strnew.length();
                        for (int i = 0; i < 4 - length; i++) {
                            strnew = "0" + strnew;
                        }
                    }
                    System.out.println(new String(sort(str.toCharArray(), 1))
                            + " - " + new String(sort(str.toCharArray(), 0))
                            + " = " + strnew);
                }


            }
        }catch (NumberFormatException e){

        }

    }

    public static char[] sort(char[] chars, int order) {
        if (order == 0) {
            //升序123456
            Arrays.sort(chars);
            return chars;
        } else {
            //降序54321
            Arrays.sort(chars);
            char[] chartemp = new char[4];
            for (int i = 0; i < chars.length; i++) {
                chartemp[i] = chars[chars.length - 1 - i];
            }
            return chartemp;
        }


    }
}
