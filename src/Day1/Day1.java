package Day1;

import Day1.LaunchModule;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

    public static int getSumOfFuelRequirements (List<LaunchModule> launchModules){
        int sum = 0;
        for (LaunchModule launchModule : launchModules){
            sum += launchModule.calculateFuelRequirement();
        }
        return sum;
    }

    /**
     * Reads a list of mass integer values from a file and creates corresponding LaunchModules
     */
    public static List<LaunchModule> getLaunchModulesFromFile(String fileName){
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
