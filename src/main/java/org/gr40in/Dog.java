package org.gr40in;

import java.time.LocalDate;

public class Dog extends Animal {

    public GrrGrrLevel grrGrrLevel;

    public void makePurr() {
        switch (grrGrrLevel) {
            case MEGA_GRR -> System.out.println("GGRRRrrrr GGRRrrrr");
            case MEDIUM_GRR -> System.out.println("Grrr Grr");
            case MICRO_GRR -> System.out.println("Grr");
        }
    }

    public Dog() {
    }

    public Dog(String name, LocalDate birthDate, GrrGrrLevel grrGrrLevel) {
        super(name, birthDate);
        this.grrGrrLevel = grrGrrLevel;
    }

    @Override
    public void makeSound() {
        System.out.println("Woof woof!!");
    }
}
