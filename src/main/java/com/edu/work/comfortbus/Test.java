package com.edu.work.comfortbus;

import org.apache.logging.log4j.util.BiConsumer;

import java.util.function.*;

public class Test {

    public static void main(String[] args) {

        Function<Integer, Integer> function = e -> e * 10;
        Integer apply = function.apply(10);

        BiFunction<String, String, Integer> biFunction = (a, b) -> a.length() + b.length();
        Integer apply1 = biFunction.apply("123", "123");

        Consumer<String> consumer = customer -> System.out.println("Hello " + customer);
//        consumer.accept("Jack");

        BiConsumer<String, Boolean> biConsumer = (a, b) -> {
            boolean b1 = b.booleanValue();

            String s = b ? a : "John";

//            System.out.println("Hello " + s);
        };
        biConsumer.accept("Yura", true);


        Predicate<String> predicate = s -> s.startsWith("@");
        boolean test = predicate.test("1@");
//        System.out.println(test);

        Predicate<String> and = predicate.and(e -> e.endsWith("1"));

        boolean test1 = and.test("@1");
//        System.out.println(test1);


        Supplier<String> stringSupplier = () -> "db url";
//        System.out.println(stringSupplier.get());


    }

}
