package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException{
        day1();
    }
    private static List<String> readFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<String> result = new ArrayList<>();
        String line;
        while((line = br.readLine())!=null){
            result.add(line);
        }
        return result;
    }
    private static int[] parseStringsToInt(List<String> list){
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = Integer.parseInt(list.get(i));
        }
        return result;
    }

    private static void day1() throws IOException{
        List<String> fileStrings = readFile(new File(Main.class.getResource("/resources/day1.txt").getFile()));
        int[] inputs = parseStringsToInt(fileStrings);
        int count = 0;
        for (int i = 1; i < inputs.length; i++) {
            if(inputs[i-1]<inputs[i]){
                count++;
            }
        }
        System.out.println("Number of times a depth measurement increases: "+count);
    }

}
