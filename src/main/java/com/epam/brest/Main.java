package com.epam.brest;

import com.epam.brest.calc.CalcImpl;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BigDecimal weight, pricePerKg, distance, pricePerKm;
        try (Scanner in = new Scanner(System.in)) {
        //    while (!in.hasNext("q")) {
            do{
                weight = getValueFromCon(in, "Input weight: ");
                pricePerKg = getValueFromCon(in, "Input price/kg : ");
                distance = getValueFromCon(in, "Input distance: ");
                pricePerKm = getValueFromCon(in, "Input price/km: ");
                System.out.println("Weight = "+weight+"; distance = "+distance+"; price per kg = "+pricePerKg+"; price per km = "+pricePerKm);
                BigDecimal result = new CalcImpl().handle(weight,pricePerKg,distance,pricePerKm);
                System.out.println("Result: "+result);
                System.out.println("Input q for exit or c for continue");
            } while (!in.hasNext("q"));
            // TODO: сделать правильный ввод
        // }
        }
    }

    private static BigDecimal getValueFromCon(Scanner scanner, String outputMessage) {
        BigDecimal value;
        System.out.print(outputMessage);
        value = scanner.nextBigDecimal();
        return value;
    }
}

