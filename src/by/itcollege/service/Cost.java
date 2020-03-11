package by.itcollege.service;

import by.itcollege.entity.CarType;

public class Cost {

    private static int ONE_DAY_BUSINESS_CAR = 100;
    private static int ONE_DAY_SPORT_CAR = 50;
    private static int ONE_DAY_NORMAL_CAR = 30;

    public static double count(int numberOfDays, CarType carType) {
        double pricePerDay;
        switch (carType) {
            case SPORT: pricePerDay = ONE_DAY_SPORT_CAR; break;
            case NORMAL: pricePerDay = ONE_DAY_NORMAL_CAR; break;
            case BUSINESS: pricePerDay = ONE_DAY_BUSINESS_CAR; break;
            default: pricePerDay = 0;
        }
        double price = numberOfDays * pricePerDay;
        if (numberOfDays >= 30) price *= 0.85;
        if (numberOfDays < 30 && numberOfDays >= 10) price *= 0.9;
        return price;
    }

}
