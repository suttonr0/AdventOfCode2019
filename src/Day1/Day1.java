package Day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

    public static void runDay1(){
        List<LaunchModule> launchModules = Day1.getLaunchModulesFromFile("src/Day1/module_masses.txt");
        System.out.println("Calculating sum of fuel requirements:");
        System.out.println(Day1.getSumOfFuelRequirements(launchModules));
        System.out.println("Calculating sum of fuel requirements accounting fuel mass:");
        System.out.println(Day1.getSumOfFuelRequirementsConsideringFuelMass(launchModules));
    }

    private static int getSumOfFuelRequirements (List<LaunchModule> launchModules){
        int sum = 0;
        for (LaunchModule launchModule : launchModules){
            sum += launchModule.calculateFuelRequirement();
        }
        return sum;
    }

    private static int getSumOfFuelRequirementsConsideringFuelMass(List<LaunchModule> launchModules){
        int sum = 0;
        for (LaunchModule launchModule : launchModules){
            sum += launchModule.calculateFuelRequirementConsideringFuelMass();
        }
        return sum;
    }


    /**
     * Reads a list of mass integer values from a file and creates corresponding LaunchModules
     */
    private static List<LaunchModule> getLaunchModulesFromFile(String fileName){
        List<LaunchModule> launchModules = new ArrayList<>();
        List<Integer> masses = getIntegerLinesFromFile(fileName);
        if(masses != null) {
            for (Integer mass : masses) {
                LaunchModule launchModule = new LaunchModule(mass);
                launchModules.add(launchModule);
            }
            return launchModules;
        }
        else
            return null;
    }

    private static List<Integer> getIntegerLinesFromFile(String fileName){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            return getIntegerLinesFromBufferedReader(br);
        } catch (FileNotFoundException e){
            System.out.println(String.format("Missing file with exception %s", e));
        } catch (IOException e){
            System.out.println(String.format("IO exception %s", e));
        }
        return null;
    }

    private static List<Integer> getIntegerLinesFromBufferedReader(BufferedReader br){
        List<Integer> integers = new ArrayList<>();
        String line;
        try{
            while ((line = br.readLine()) != null){
                integers.add(Integer.parseInt(line));
            }
        } catch (IOException e){
            System.out.println(String.format("IO exception %s", e));
        }
        return integers;
    }
}
