package dev.omedia.section_8.exercise_40;


public class Mitsubishi extends Car {

    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return super.startEngine() + " ||| manufacturer = " + getClass().getSimpleName();
    }

    @Override
    public String accelerate() {
        return super.accelerate() + " ||| manufacturer = " + getClass().getSimpleName();
    }

    @Override
    public String brake() {
        return super.brake() + " ||| manufacturer = " + getClass().getSimpleName();
    }
}
