package Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class StabilityInArray {
}


 class MyStabilityComparator implements Comparator<Employees> {

    @Override
    public int compare(Employees o1, Employees o2) {
        if(o2.getAge() == o1.getAge()){
            return o1.getName().compareTo(o2.getName());
        }
        return o2.getAge() - o1.getAge();
    }
}


class Employees {
    private String name;
    private int age;

    public Employees(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }
}


class TestClass {

    public static void main(String[] args) {
        Employees[] employees = {
                new Employees("Sagar",5),
                new Employees("Akash",4),
                new Employees("Bishal",4)
        };

        Arrays.sort(employees, new MyStabilityComparator());
        displayArray(employees);
    }

    private static void displayArray(Employees[] employees) {
        for (Employees employee: employees)
            System.out.println("Name - Age: " + employee.getName() + " - "+ employee.getAge());
    }
}

