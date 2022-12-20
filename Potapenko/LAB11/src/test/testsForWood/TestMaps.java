package testsForWood;

import java.util.*;

public class TestMaps {
    public static void main(String[] args) {

        System.out.println("HashMap");
        Map<String, String> map = new HashMap<>();

        map.put("file","файл");
        map.put("block","блок");
        map.put("dictionary","словник");

        map.entrySet().forEach(System.out::println);


        System.out.println("LinkedHashMap");
        Map<String, String> mapLinked = new LinkedHashMap<>();

        mapLinked.put("file","файл");
        mapLinked.put("block","блок");
        mapLinked.put("dictionary","словник");

        mapLinked.entrySet().forEach(System.out::println);


        System.out.println("TreeMap");
        Map<String, String> mapTree = new TreeMap<>();

        mapTree.put("file","файл");
        mapTree.put("block","блок");
        mapTree.put("dictionary","словник");

        mapTree.entrySet().forEach(System.out::println);

        //properties testin
        System.out.println("Properties");
        Properties properties = System.getProperties();
        properties.forEach((k,v)-> System.out.println(k + " = " + v));


    }

}
