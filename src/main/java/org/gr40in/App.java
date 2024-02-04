package org.gr40in;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws IllegalAccessException {

        for (Animal animal : getSomeAnimal()) {
            System.out.println(getInformationAboutObject(animal));
        }
    }

    public static Animal[] getSomeAnimal() {
        return new Animal[]{new Dog("Oy", LocalDate.of(1996, 11, 5), GrrGrrLevel.MEGA_GRR), new Dog("Scooby Doo", LocalDate.of(2002, 5, 7), GrrGrrLevel.MICRO_GRR), new Dog("Bolt", LocalDate.of(2007, 10, 10), GrrGrrLevel.MEGA_GRR), new Cat("Saimon", LocalDate.of(2003, 6, 13), PurrpurrLevel.MEGA_PURR), new Cat("Tom", LocalDate.of(1991, 4, 1), PurrpurrLevel.MICRO_PURR), new Cat("Garfild", LocalDate.of(2006, 12, 11), PurrpurrLevel.MEDIUM_PURR)};
    }

    public static String getInformationAboutObject(Object object) throws IllegalAccessException {
        StringBuilder result = new StringBuilder();
        Class<?> clazz = object.getClass();
        result.append(clazz.getSimpleName()).append(" (").append(clazz.getName()).append(")").append(System.lineSeparator());
        result.append(getFieldsInfoFormObject(object, clazz));
        Class<?> parent = clazz.getSuperclass();
        while (!parent.getName().equals("Object")) {
            result.append(getFieldsInfoFormObject(object, parent));
            parent = parent.getSuperclass();
            if (parent == null) {
                break;
            }
        }
        return result.toString();

    }

    private static StringBuilder getFieldsInfoFormObject(Object object, Class<?> clazz) throws IllegalAccessException {
        StringBuilder fieldsInfo = new StringBuilder();
        for (var field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            var name = field.getName();
            fieldsInfo.append("\t").append(field.).append(name).append(" = ").append(field.get(object));
        }
        return fieldsInfo;
    }
}
