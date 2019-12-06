package Day1;

import Day1.LaunchModule;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

    public static List<Integer> getIntegerLinesFromFile(String fileName){
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
