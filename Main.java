package org.example;

import java.util.Scanner;

public class Main {

    private static final double EARTH_RADIUS_KM = 6371.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Создаем функцию, которая принимает данные и выводит их.

        // Ввододим первые точки
        System.out.println("Введите широту первой точки:");
        double shir1 = scanner.nextDouble();
        System.out.println("Введите долготу первой точки:");
        double dol1 = scanner.nextDouble();

        // Вводим вторые точки
        System.out.println("Введите широту второй точки:");
        double shir2 = scanner.nextDouble();
        System.out.println("Введите долготу второй точки:");
        double dol2 = scanner.nextDouble();

        // Рассчет расстояния
        double distance = calculateDistance(dol1, shir1, dol2, shir2);

        // Вывод результата
        System.out.println("Расстояние между точками: " + distance + " км");

        scanner.close();
    }

    private static double calculateDistance(double dol1, double shir1, double dol2, double shir2) {
        // Перевод координат из градусов в радианы
        double lat1Rad = Math.toRadians(shir1);
        double lon1Rad = Math.toRadians(dol1);
        double lat2Rad = Math.toRadians(shir2);
        double lon2Rad = Math.toRadians(dol2);

        // Вычисление разницы координат
        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;

        // Вычисление расстояния с использованием формулы гаверсинусов
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS_KM * c;
    }
}
