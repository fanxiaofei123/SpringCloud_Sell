package com.imooc.eureka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.springframework.cglib.core.CollectionUtils.filter;

public class Test {

    public static void main(String[] args) {
          List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
          for (String feature : features) {
              System.out.println(feature);
          }

//            features.forEach(n -> System.out.println(n));
            features.forEach(System.out::println);

             System.out.println("==========================");
             List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

           System.out.println("Languages which starts with J :");
           filter(languages, (str)->str.startsWith("J"));

           System.out.println("Languages which ends with a ");
           filter(languages, (str)->str.endsWith("a"));

           System.out.println("Print all languages :");
           filter(languages, (str)->true);

            System.out.println("Print no language : ");
            filter(languages, (str)->false);

            System.out.println("Print language whose length greater than 4:");
            filter(languages, (str)->str.length() > 4);
           System.out.println("==========================");
           Predicate<String> startWithJ = (n) -> n.startsWith("J");
           Predicate<String> fourLength = (n) -> n.length() == 4;

           List<String> languagess = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
           languagess.stream().filter(startWithJ.and(fourLength))
                       .forEach(System.out::println);

        System.out.println("==========================");
//              List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//              for (Integer cost : costBeforeTax) {
//                    double price = cost + .12*cost;
//                    System.out.println(price);
//              }
          System.out.println("============使用Lambda实现Map 和 Reduce==============");
          List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
          costBeforeTax.stream().map((cost) -> cost + .12*cost).forEach(System.out::println);
          System.out.println("============通过filtering 创建一个字符串String的集合==============");
          //Filtering是对大型Collection操作的一个通用操作，Stream提供filter()方法，接受一个Predicate对象，意味着你能传送lambda表达式作为一个过滤逻辑进入这个方法
          List<String>       strList=new ArrayList<String>();
              strList.add(" ")  ;
              strList.add("wew")  ;
              strList.add("we")  ;
              strList.add("rrr")  ;
              strList.add("ttt")  ;
              strList.add("")  ;
          List<String> filtered = strList.stream().filter(x -> x.length()> 2)
                                                  .collect(Collectors.toList());
          System.out.printf("Original List : %s, filtered list : %s %n",
                            strList, filtered);
         System.out.println("===========对集合中每个元素应用函数===============");
          List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany",
                                          "Italy", "U.K.","Canada");
          String G7Countries = G7.stream().map(x -> x.toUpperCase())
                                          .collect(Collectors.joining(", "));
          System.out.println(G7Countries);
         System.out.println("============使用Stream的distinct()方法过滤集合中重复元素==============");
          List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
          List<Integer> distinct = numbers.stream().map( i -> i*i).distinct()
                                                   .collect(Collectors.toList());
          System.out.printf("Original List : %s,  Square Without duplicates :%s %n", numbers, distinct);

          System.out.println("============计算List中的元素的最大值，最小值，总和及平均值==============");
          List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
          IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x)
                                                      .summaryStatistics();
          System.out.println("Highest prime number in List : " + stats.getMax());
          System.out.println("Lowest prime number in List : " + stats.getMin());
          System.out.println("Sum of all prime numbers : " + stats.getSum());
          System.out.println("Average of all prime numbers : " + stats.getAverage());
    }

    public static void filter(List<String> names, Predicate<String> condition) {
       for(String name: names)  {
          if(condition.test(name)) {
             System.out.println(name + " ");
          }
       }
     }

}