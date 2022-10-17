package ua.lviv.lgs11;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    private String text;

    public static void main(String[] args) {

        String text = "Enter values:\n 1-Print toString() of these array elements to the console. "
                + "\n 2-For all objects of this array, visit the same object of class Auto" + "\n 0-To finish \n";
        createArrayInteger();
        int choice = readText(text);

        Car[][] twoDimArray = new Car[getRandomValue(5, 10)][getRandomValue(1, 3)];
        do {
            switch (choice) {

            case 1:
                for (int i = 0; i < twoDimArray.length; i++) {
                    for (int j = 0; j < twoDimArray[i].length; j++) {
                        twoDimArray[i][j] = new Car(getRandomValue(75, 115), getRandomValue(2000, 2022),
                                getRandomValue(2, 8), getRandomValue(200, 400), getRandomValue(1, 2));
                    }
                }

                break;

            case 2:
                for (Car[] row : twoDimArray)
                    Arrays.fill(row, new Car(75, 2022, 300, 6, 1));
                break;
            }
            System.out.println(Arrays.deepToString(twoDimArray));
            choice = readText(text);
        } while (choice != 0);
    }

    public static int readText(String text) {
        Scanner scan = new Scanner(System.in);
        System.out.print(text);
        int input = scan.nextInt();
        return input;
    }

    public static void createArrayInteger() {
        Integer[] integerArray = new Integer[22];
        for (int i = 0; i < integerArray.length; i++) {
            Random r = new Random();
            integerArray[i] = r.nextInt(100) + 1;
        }

        System.out.println("Before sorting");
        System.out.println(Arrays.toString(integerArray));

        System.out.println("After sorting asc");
        Arrays.sort(integerArray);
        System.out.println(Arrays.toString(integerArray));

        System.out.println("After sorting desc");
        Arrays.sort(integerArray, Collections.reverseOrder());
        System.out.println(Arrays.toString(integerArray));
    }

    public static int getRandomValue(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("min value must be smaller than max value");
        }

        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

}
