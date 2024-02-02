package org.gr40in;

import java.time.LocalDate;

public class Cat extends Animal {

    PurrpurrLevel purrLevel;

    public void makePurr() {
        switch (purrLevel) {
            case MEGA_PURR -> System.out.println("PPRRRrrrr PRRRrrrr");
            case MEDIUM_PURR -> System.out.println("Prrr prr");
            case MICRO_PURR -> System.out.println("prr");
        }
    }

    public Cat() {
    }

    public Cat(String name, LocalDate birthDate, PurrpurrLevel purrLevel) {
        super(name, birthDate);
        this.purrLevel = purrLevel;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}
