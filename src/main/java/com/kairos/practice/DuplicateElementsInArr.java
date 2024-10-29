package com.kairos.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DuplicateElementsInArr {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 2, 3, 4};

        findDupliates();

        Set<Integer> set = new HashSet<>();
        for (int a : arr) {
            set.add(a);
        }

//        set.forEach(t -> System.out.println(t));

        ArrayList<Integer> list = new ArrayList<>();
        Arrays.stream(arr).forEach(el -> {
            if (!list.contains(el)) {
                list.add(el);
            }
        });

//        list.forEach(el -> System.out.println(el));
    }

    private static void findDupliates() {
        int[] arr = {0, 1, 1, 2, 3, 4};

        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        for (int i : arr) {
            if (!s1.add(i)) {
                s2.add(i);
            }
        }

//        s2.forEach(t -> System.out.println(t));
        s1.forEach(t -> System.out.println(t));


    }
}
