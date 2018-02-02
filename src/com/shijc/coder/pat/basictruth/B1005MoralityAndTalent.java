package com.shijc.coder.pat.basictruth;

import java.util.*;

/**
 * 德才论
 * 题目描述
 * 宋代史学家司马光在《资治通鉴》中有一段著名的“德才论”：“是故才德全尽谓之圣人，才德兼亡谓之愚人，
 * 德胜才谓之君子，才胜德谓之小人。凡取人之术，苟不得圣人，君子而与之，与其得小人，不若得愚人。”
 * 现给出一批考生的德才分数，请根据司马光的理论给出录取排名。
 * 输入描述:
 * 输入第1行给出3个正整数，分别为：N（<=105），即考生总数；L（>=60），为录取最低分数线，即德分
 * 和才分均不低于L的考生才有资格被考虑录取；H（<100），为优先录取线——德分和才分均不低于此线的被
 * 定义为“才德全尽”，此类考生按德才总分从高到低排序；才分不到但德分到线的一类考生属于“德胜才”，
 * 也按总分排序，但排在第一类考生之后；德才分均低于H，但是德分不低于才分的考生属于“才德兼亡”但尚
 * 有“德胜才”者，按总分排序，但排在第二类考生之后；其他达到最低线L的考生也按总分排序，但排在第三
 * 类考生之后。随后N行，每行给出一位考生的信息，包括：准考证号、德分、才分，其中准考证号为8位整数，
 * 德才分为区间[0, 100]内的整数。数字间以空格分隔。
 * 输出描述:
 * 输出第1行首先给出达到最低分数线的考生人数M，随后M行，每行按照输入格式输出一位考生的信息，考生
 * 按输入中说明的规则从高到低排序。当某类考生中有多人总分相同时，按其德分降序排列；若德分也并列，
 * 则按准考证号的升序输出。
 * 输入例子:
 * 14 60 80
 * 10000001 64 90
 * 10000002 90 60
 * 10000011 85 80
 * 10000003 85 80
 * 10000004 80 85
 * 10000005 82 77
 * 10000006 83 76
 * 10000007 90 78
 * 10000008 75 79
 * 10000009 59 90
 * 10000010 88 45
 * 10000012 80 100
 * 10000013 90 99
 * 10000014 66 60
 * 输出例子:
 * 12
 * 10000013 90 99
 * 10000012 80 100
 * 10000003 85 80
 * 10000011 85 80
 * 10000004 80 85
 * 10000007 90 78
 * 10000006 83 76
 * 10000005 82 77
 * 10000002 90 60
 * 10000014 66 60
 * 10000008 75 79
 * 10000001 64 90
 *
 * @author shijiacheng
 * @date 2018/1/26
 */
public class B1005MoralityAndTalent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int H = sc.nextInt();

        List<Student> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Student s = new Student();
            s.id = sc.nextInt();
            s.dScore = sc.nextInt();
            s.cScore = sc.nextInt();
            list.add(s);
        }
        List<Student> list1 = new ArrayList<>();
        List<Student> list2 = new ArrayList<>();
        List<Student> list3 = new ArrayList<>();
        List<Student> list4 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).cScore >= H && list.get(i).dScore >= H) {
                list1.add(list.get(i));
            } else if (list.get(i).cScore >= L && list.get(i).cScore < H
                    && list.get(i).dScore >= H) {
                list2.add(list.get(i));
            } else if (list.get(i).dScore >= L && list.get(i).cScore >= L
                    && list.get(i).cScore < H && list.get(i).dScore < H
                    && list.get(i).dScore >= list.get(i).cScore) {
                list3.add(list.get(i));
            } else if (list.get(i).dScore >= L && list.get(i).cScore >= L) {
                list4.add(list.get(i));
            }
        }

        Collections.sort(list1, c);
        Collections.sort(list2, c);
        Collections.sort(list3, c);
        Collections.sort(list4, c);
        System.out.println(list1.size() + list2.size() + list3.size() + list4.size());
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i).toString());
        }
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i).toString());
        }
        for (int i = 0; i < list3.size(); i++) {
            System.out.println(list3.get(i).toString());
        }
        for (int i = 0; i < list4.size(); i++) {
            System.out.println(list4.get(i).toString());
        }
    }

    static Comparator<Student> c = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.getTotalScore() > o2.getTotalScore()) {
                return -1;
            } else if (o1.getTotalScore() < o2.getTotalScore()) {
                return 1;
            } else {
                if (o1.dScore > o2.dScore) {
                    return -1;
                } else if (o1.dScore < o2.dScore) {
                    return 1;
                } else {
                    if (o1.id > o2.id) {
                        return 1;
                    } else if (o1.id < o2.id) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        }
    };

    static class Student {
        int id;
        int dScore;
        int cScore;

        public int getTotalScore() {
            return dScore + cScore;
        }

        @Override
        public String toString() {
            return id + " " + dScore + " " + cScore;
        }
    }
}
