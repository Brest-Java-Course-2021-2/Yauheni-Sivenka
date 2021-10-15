package com.epam.brest;

import com.epam.brest.calc.CalcImpl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BigDecimal weight, pricePerKg, distance, pricePerKm;
        boolean res, inputFromFile;
        String charInputFromFile;

        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Are you want take a prices from file? (y/n)");
            charInputFromFile = in.next();
            inputFromFile = (charInputFromFile.equals("y"));
            do{
                System.out.println("Input any char for exit:");
                weight = getValueFromCon(in, "Input weight: ");
                distance = getValueFromCon(in, "Input distance: ");
                if (!inputFromFile) {
                    pricePerKg = getValueFromCon(in, "Input price/kg : ");
                    pricePerKm = getValueFromCon(in, "Input price/km: ");
                } else {
                    pricePerKg = getValueFromFile(weight,"/home/yauheni/Development/Project/Yauheni-Sivenka/resources/pricePerKg.csv");
                    pricePerKm = getValueFromFile(distance,"/home/yauheni/Development/Project/Yauheni-Sivenka/resources/pricePerKm.csv");
                }
                res = !((weight.compareTo(BigDecimal.valueOf(0))<0) |
                        (pricePerKg.compareTo(BigDecimal.valueOf(0))<0) |
                        (distance.compareTo(BigDecimal.valueOf(0))<0) |
                        (pricePerKm.compareTo(BigDecimal.valueOf(0))<0));
                if (res) {
                    System.out.println("Weight = " + weight + "; distance = " + distance + "; price per kg = " + pricePerKg + "; price per km = " + pricePerKm);
                    BigDecimal result = new CalcImpl().handle(weight, pricePerKg, distance, pricePerKm);
                    System.out.println("Result: " + result);
                } else
                    System.out.println("Bye!");
            } while (res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BigDecimal getValueFromCon(Scanner scanner, String outputMessage) {
        BigDecimal value;
        try {
            System.out.print(outputMessage);
            value = scanner.nextBigDecimal();
        }
        catch (Exception e) {
            value = BigDecimal.valueOf(-1);
        }
        return value;
    }

    private static BigDecimal  getValueFromFile(BigDecimal value, String fileName) throws IOException {
        FileReader x = new FileReader(fileName);
        BufferedReader varRead = new BufferedReader(x);
        String oneLine;
        String[] oneLineByWords;
        BigDecimal minValue;
        BigDecimal price = BigDecimal.valueOf(0);

        while ((oneLine = varRead.readLine()) != null) {
            oneLineByWords = oneLine.split(",");
            minValue = BigDecimal.valueOf(Double.parseDouble(oneLineByWords[0]));
            if (value.compareTo(minValue)<0) {
                break;
            }
            price = BigDecimal.valueOf(Double.parseDouble(oneLineByWords[1]));
        }
        varRead.close();
        return price;
    }

}

