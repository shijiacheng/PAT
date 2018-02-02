package com.shijc.coder.pat.basictruth;


import java.text.DecimalFormat;
import java.util.*;

/**
 * 月饼
 * 题目描述
 * 月饼是中国人在中秋佳节时吃的一种传统食品，不同地区有许多不同风味的月饼。现给定所有种类
 * 月饼的库存量、总售价、以及市场的最大需求量，请你计算可以获得的最大收益是多少。
 * 注意：销售时允许取出一部分库存。样例给出的情形是这样的：假如我们有3种月饼，其库存量分别
 * 为18、15、10万吨，总售价分别为75、72、45亿元。如果市场的最大需求量只有20万吨，那么我
 * 们最大收益策略应该是卖出全部15万吨第2种月饼、以及5万吨第3种月饼，
 * 获得72 + 45/2 = 94.5（亿元）。
 * 输入描述:
 * 每个输入包含1个测试用例。每个测试用例先给出一个不超过1000的正整数N表示月饼的种类数、
 * 以及不超过500（以万吨为单位）的正整数D表示市场最大需求量。随后一行给出N个正数表示每
 * 种月饼的库存量（以万吨为单位）；最后一行给出N个正数表示每种月饼的总售价（以亿元为单
 * 位）。数字间以空格分隔。
 * 输出描述:
 * 对每组测试用例，在一行中输出最大收益，以亿元为单位并精确到小数点后2位。
 * 输入例子:
 * 3 20
 * 18 15 10
 * 75 72 45
 * 输出例子:
 * 94.50
 *
 * @author shijiacheng
 * @date 2018/2/2
 */
public class B1010MoonCake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        List<Mooncake> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Mooncake model = new Mooncake();
            model.count = sc.nextInt();
            list.add(model);
        }

        for (int i = 0; i < N; i++) {
            list.get(i).price = sc.nextInt();
            list.get(i).profit = list.get(i).price * 1.0 / list.get(i).count;
        }

        Collections.sort(list, new Comparator<Mooncake>() {
            @Override
            public int compare(Mooncake o1, Mooncake o2) {
                double profitA = o1.getProfit();
                double profitB = o2.getProfit();
                if (profitA > profitB) {
                    return -1;
                } else if (profitA < profitB) {
                    return 1;
                } else {
                    return 0;
                }

            }
        });

        double result = 0.0;
        boolean flag = true;
        while (flag) {
            for (int i = 0; i < N; i++) {
                if (D >= list.get(i).count) {
                    result += list.get(i).price;
                    D -= list.get(i).count;
                } else if (D < list.get(i).count) {
                    result += D * list.get(i).profit;
                    flag = false;
                    break;
                }
            }
        }

        DecimalFormat df = new DecimalFormat("###.00");
        System.out.println(df.format(result));

    }

    static class Mooncake {

        int count;
        int price;//售价
        double profit;//利润

        public double getProfit() {
            return profit;
        }
    }
}
