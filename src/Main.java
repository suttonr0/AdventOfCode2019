import Day1.*;

import java.util.List;


public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        LaunchModule module1 = new LaunchModule(31);
        System.out.println(module1.calculateFuelRequirement());

        System.out.println(System.getProperty("user.dir"));

        List<Integer> test = Day1.getIntegerLinesFromFile("src/Day1/module_masses.txt");
        for(Integer integer : test){
            System.out.println(integer);
        }
    }
}
