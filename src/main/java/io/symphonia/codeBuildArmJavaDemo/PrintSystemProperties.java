package io.symphonia.codeBuildArmJavaDemo;

import java.util.Comparator;

public class PrintSystemProperties {
    public static void main(String[] args) {
        System.getProperties().entrySet().stream()
                .sorted(Comparator.comparing(a -> a.getKey().toString()))
                .forEach(entry -> System.out.println(entry.toString()));
    }
}
