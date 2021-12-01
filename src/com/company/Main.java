package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        part2();
    }

    private static List<String> readFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<String> result = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            result.add(line);
        }
        return result;
    }

    private static int[] parseStringsToInt(List<String> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = Integer.parseInt(list.get(i));
        }
        return result;
    }

    private static void part1() throws IOException {
        List<String> fileStrings = readFile(new File(Main.class.getResource("/resources/day1.txt").getFile()));
        int[] inputs = parseStringsToInt(fileStrings);
        int count = 0;
        for (int i = 1; i < inputs.length; i++) {
            if (inputs[i - 1] < inputs[i]) {
                count++;
            }
        }
        System.out.println("Number of times a depth measurement increases: " + count);
    }

    private static boolean compareArrays(int[] a, int[] b) {
        return sumArray(a) < sumArray(b);
    }

    private static int sumArray(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        return result;
    }

    private static void part2() throws IOException {
        List<String> fileStrings = readFile(new File(Main.class.getResource("/resources/day1.txt").getFile()));
        int[] inputs = parseStringsToInt(fileStrings);
        int[] a = new int[3];
        int[] b = new int[3];
        int counter = 0;
        for (int i = 3; i < inputs.length; i++) {
            a[0] = inputs[i - 3];
            a[1] = inputs[i - 2];
            a[2] = inputs[i - 1];

            b[0] = inputs[i - 2];
            b[1] = inputs[i - 1];
            b[2] = inputs[i];

            if (compareArrays(a, b)) {
                counter++;
            }
        }
        System.out.println("Number of times a depth measurement increases: " + counter);
    }

}
