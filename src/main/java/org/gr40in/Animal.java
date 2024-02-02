package org.gr40in;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Animal {
    private String name;
    private LocalDate birthDate;

    public Animal() {
    }

    public Animal(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public abstract void makeSound();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal animal)) return false;
        return Objects.equals(name, animal.name) && Objects.equals(birthDate, animal.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
