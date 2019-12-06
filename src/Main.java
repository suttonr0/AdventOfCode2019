import Day1.*;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        System.out.println("Calculating sum of fuel requirements:");
        List<LaunchModule> launchModules = Day1.getLaunchModulesFromFile("src/Day1/module_masses.txt");
        int fuelRequirement = Day1.getSumOfFuelRequirements(launchModules);
        System.out.println(fuelRequirement);
    }
}
