package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            integers.add(random.nextInt(100));
        }
        System.out.println("Initial Array:");
        System.out.println(integers);

        // 1. Find out all the even numbers exist in the list using Stream functions
        List<Integer> evenNumbers =  integers.stream()
                .filter(integer -> integer%2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even Array:");
        System.out.println(evenNumbers);

        // 2. Find out all the numbers starting with 1 using Stream functions
        List<Integer> startWith1 = integers.stream()
                .filter(integer -> {
                    String check = String.valueOf(integer);
                    return check.startsWith("1");
                })
                .collect(Collectors.toList());
        System.out.println("Start with 1 Array:");
        System.out.println(startWith1);

        // 3. Find the total number of elements present in the list using Stream functions
        Integer sumNumber = integers.stream()
                .reduce(0, (subTotal, element) -> subTotal + element);
        System.out.println("Sum of Array:");
        System.out.println(sumNumber);

        // 4. Sort all the values present in it using Stream functions
        List<Integer> sortedNumbers = integers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted Array:");
        System.out.println(sortedNumbers);
    }
}
