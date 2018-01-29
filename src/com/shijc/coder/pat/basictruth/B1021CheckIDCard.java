package com.shijc.coder.pat.basictruth;

import java.util.*;

/**
 * 查验身份证
 * 题目描述
 * 一个合法的身份证号码由17位地区、日期编号和顺序编号加1位校验码组成。校验码的计算规则如下：
 * 首先对前17位数字加权求和，权重分配为：{7，9，10，5，8，4，2，1，6，3，7，9，10，5，8，4，2}；
 * 然后将计算的和对11取模得到值Z；最后按照以下关系对应Z值与校验码M的值：
 * Z：0 1 2 3 4 5 6 7 8 9 10
 * M：1 0 X 9 8 7 6 5 4 3 2
 * 现在给定一些身份证号码，请你验证校验码的有效性，并输出有问题的号码。
 * 输入描述:
 * 输入第一行给出正整数N（<= 100）是输入的身份证号码的个数。随后N行，每行给出1个18位身份证号码。
 * 输出描述:
 * 按照输入的顺序每行输出1个有问题的身份证号码。这里并不检验前17位是否合理，只检查前17位是否全为
 * 数字且最后1位校验码计算准确。如果所有号码都正常，
 * 则输出“All passed”。
 * 输入例子:
 * 4
 * 320124198808240056
 * 12010X198901011234
 * 110108196711301866
 * 37070419881216001X
 * 输出例子:
 * 12010X198901011234
 * 110108196711301866
 * 37070419881216001X
 *
 * @author shijiacheng
 * @date 2018/1/29
 */
public class B1021CheckIDCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] weight = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        Map<Integer, String> vertify = new HashMap<>();
        for (int i = 0; i < 11; i++) {
            if (i < 2) {
                vertify.put(i, String.valueOf(1 - i));
            } else if (i == 2) {
                vertify.put(i, "X");
            } else {
                vertify.put(i, String.valueOf(12 - i));
            }
        }
        int N = sc.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(sc.next());
        }
        List<String> errorList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 18) {
                if (list.get(i).contains("X")) {
                    if (list.get(i).charAt(17) == 'X') {
                        if (!vertify(list.get(i), weight, vertify)) {
                            errorList.add(list.get(i));
                        }
                    } else {
                        errorList.add(list.get(i));
                    }
                } else {
                    if (!vertify(list.get(i), weight, vertify)) {
                        errorList.add(list.get(i));
                    }
                }
            } else {
                errorList.add(list.get(i));
            }
        }

        if (errorList.size() == 0) {
            System.out.println("All passed");
        } else {
            for (int i = 0; i < errorList.size(); i++) {
                System.out.println(errorList.get(i));
            }
        }

    }

    public static boolean vertify(String id, int[] weight, Map<Integer, String> vertify) {

        int sum = 0;
        for (int i = 0; i < 17; i++) {
            int temp = id.charAt(i) - '0';
            sum += temp * weight[i];
        }

        int result = sum % 11;
        if (vertify.get(result).equals(String.valueOf(id.charAt(17)))) {
            return true;
        } else {
            return false;
        }
    }
}
