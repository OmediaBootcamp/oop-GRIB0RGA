package dev.omedia.section_8.exercise_40;

public class Car {
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels = 4;

    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
    }

    public int getCylinders() {
        return this.cylinders;
    }

    public String getName() {
        return this.name;
    }

    public String startEngine() {
        return "Car engine is starting";
    }

    public String accelerate() {
        return "Car is accelerating";
    }

    public String brake() {
        return "Car is braking";
    }

    // Udemy-ს ტესტ ქეისებმა არ გამიშვა თორე რეალურად ოვერრაიდიებიც არ არის საჭირო დანარჩენ კლასებში,
    // შემეძლო პირდაპირ ასე დამეწერა რადგან კლასნეიმს ამოიღებდა მაინც იმ კლასისსას რომლითაც შევქმენი

//     public String startEngine() {
//         return getClass().getSimpleName() + " engine is starting";
//     }
//
//     public String accelerate() {
//         return getClass().getSimpleName() + " is accelerating";
//     }
//
//     public String brake() {
//         return getClass().getSimpleName() + " is braking";
//     }
}
