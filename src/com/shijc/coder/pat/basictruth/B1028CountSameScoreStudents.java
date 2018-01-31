package com.shijc.coder.pat.basictruth;

import java.util.*;

/**
 * 统计相同成绩的学生
 * 题目描述
 * 本题要求读入N名学生的成绩，将获得某一给定分数的学生人数输出。
 * 输入描述:
 * 输入在第1行给出不超过105的正整数N，即学生总人数。随后1行给出N名学生的百分制整数成绩，
 * 中间以空格分隔。最后1行给出要查询的分数个数K（不超过N的正整数），随后是K个分数，中间以空格分隔。
 * 输出描述:
 * 在一行中按查询顺序给出得分等于指定分数的学生人数，中间以空格分隔，但行末不得有多余空格。
 * 输入例子:
 * 10
 * 60 75 90 55 75 99 82 90 75 50
 * 3 75 90 88
 * 输出例子:
 * 3 2 0
 *
 * @author shijiacheng
 * @date 2018/1/31
 */
public class B1028CountSameScoreStudents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }
        int K = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> checkList = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            int temp = sc.nextInt();
            checkList.add(temp);
            map.put(temp, 0);
        }

        for (int i = 0; i < list.size(); i++) {
            if (map.containsKey(list.get(i))) {
                int count = map.get(list.get(i));
                map.put(list.get(i), count + 1);
            }
        }

        for (int i = 0; i < checkList.size(); i++) {
            if (i < checkList.size() - 1) {
                System.out.print(map.get(checkList.get(i)) + " ");
            } else {
                System.out.println(map.get(checkList.get(i)));
            }
        }
    }
}
