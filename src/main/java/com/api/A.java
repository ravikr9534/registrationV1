package com.api;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class A {
    public static void main(String[] args) {
     List<Employee> data=   Arrays.asList(
               new Employee(1,"Ravi",5000),
                new Employee(2,"Monty",2000),
                new Employee(3,"sid",2000),
                        new Employee(4,"Sush",10000)
        );
       /* List<Employee>newData=data.stream().filter(e->e.getName().startsWith("R")).collect(Collectors.toList());
       for(Employee emp:newData){
           System.out.println(emp.getId());
           System.out.println(emp.getName());
           System.out.println(emp.getSal());
       }*/
      Map<Integer ,List<Employee>>newData= data.stream().collect(Collectors.groupingBy(e->e.getSal()));
        System.out.println(newData);
      /*  List<Integer>newData=data.stream().map(Employee::getSal).collect(Collectors.toList());
        //System.out.println(newData);
       newData.forEach(System.out::println);*/
    }
}
