package dev.ananda.design.patterns.strategy;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class TotalStrategy {

    public static int totalValues(List<Integer> values, Predicate<Integer> elementFilter){

        /*
        int result = 0;
        for(int e : values){
            if(selector.test(e)){
                result += e;
            }
        }
        return result;
        */
        return values.stream()
                .filter(elementFilter)
                //.reduce(0, Integer::sum);
                .mapToInt(e->e)
                .sum();
    }
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // total sum of all values
        System.out.println(totalValues(numbers, e-> true));

        // total sum of even values
        System.out.println(totalValues(numbers, e->e%2==0));

        // total sum of odd values
        System.out.println(totalValues(numbers, e->e%2!=0));

    }
}
