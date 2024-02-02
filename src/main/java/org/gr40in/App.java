package org.gr40in;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {


    }

    public static Animal[] getSomeAnimal() {
        return new Animal[]{
                new Dog("Oy", LocalDate.of(1996, 11, 5), GrrGrrLevel.MEGA_GRR),
                new Dog("Scooby Doo", LocalDate.of(2002, 5, 7), GrrGrrLevel.MICRO_GRR),
                new Dog("Bolt", LocalDate.of(2007, 10, 10), GrrGrrLevel.MEGA_GRR),
                new Cat("Saimon", LocalDate.of(2003, 6, 13), PurrpurrLevel.MEGA_PURR),
                new Cat("Tom", LocalDate.of(1991, 4, 1), PurrpurrLevel.MICRO_PURR),
                new Cat("Garfild", LocalDate.of(2006, 12, 11), PurrpurrLevel.MEDIUM_PURR)};
    }

    public static
}
