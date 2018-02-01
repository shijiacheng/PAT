package com.shijc.coder.pat.basictruth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 人口普查
 * 题目描述
 * 某城镇进行人口普查，得到了全体居民的生日。现请你写个程序，找出镇上最年长和最年轻的人。
 * 这里确保每个输入的日期都是合法的，但不一定是合理的——假设已知镇上没有超过200岁的老人，
 * 而今天是2014年9月6日，所以超过200岁的生日和未出生的生日都是不合理的，应该被过滤掉。
 * 输入描述:
 * 输入在第一行给出正整数N，取值在(0, 105]；随后N行，每行给出1个人的姓名（由不超过5个
 * 英文字母组成的字符串）、以及按“yyyy/mm/dd”（即年/月/日）格式给出的生日。题目保证最
 * 年长和最年轻的人没有并列。
 * 输出描述:
 * 在一行中顺序输出有效生日的个数、最年长人和最年轻人的姓名，其间以空格分隔。
 * 输入例子:
 * 5
 * John 2001/05/12
 * Tom 1814/09/06
 * Ann 2121/01/30
 * James 1814/09/05
 * Steve 1967/11/20
 * 输出例子:
 * 3 Tom John
 *
 * @author shijiacheng
 * @date 2018/2/1
 */
public class B1018Census {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Person p = new Person();
            p.name = sc.next();
            p.setDateStr(sc.next());
            list.add(p);
        }

        int count = 0;
        int min = 0;
        int max = Integer.MAX_VALUE;
        String maxName = "";
        String minName = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).date >= 18140906 && list.get(i).date <= 20140906) {
                count++;
                if (list.get(i).date < max) {
                    max = list.get(i).date;
                    maxName = list.get(i).name;
                }

                if (list.get(i).date > min) {
                    min = list.get(i).date;
                    minName = list.get(i).name;
                }
            }

        }
        System.out.println(count + " " + maxName + " " + minName);
    }

    static class Person {
        String name;
        int date;
        String dateStr;

        public void setDateStr(String dateStr) {
            this.dateStr = dateStr;
            String[] str = dateStr.split("/");
            this.date = Integer.parseInt(str[0]) * 10000
                    + Integer.parseInt(str[1]) * 100 + Integer.parseInt(str[2]);
        }
    }
}
