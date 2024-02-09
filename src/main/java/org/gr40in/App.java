package org.gr40in;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.Arrays;

public class App {
    public static final String METHOD_NAME = "makeSound";

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {

        for (Animal animal : getSomeAnimal()) {
            System.out.println(getInformationAboutObject(animal));
            runSomeMethod(animal, METHOD_NAME);
        }
    }

    private static void runSomeMethod(Object object, String methodName) throws IllegalAccessException, InvocationTargetException {
        Arrays.stream(object.getClass().getMethods())
                .filter(method -> method.getName().equals(methodName))
                .findFirst()
                .map(method -> {
                    try {
                        return method.invoke(object);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    public static Animal[] getSomeAnimal() {
        return new Animal[]{new Dog("Oy", LocalDate.of(1996, 11, 5), GrrGrrLevel.MEGA_GRR),
                new Dog("Scooby Doo", LocalDate.of(2002, 5, 7), GrrGrrLevel.MICRO_GRR),
                new Dog("Bolt", LocalDate.of(2007, 10, 10), GrrGrrLevel.MEGA_GRR),
                new Cat("Saimon", LocalDate.of(2003, 6, 13), PurrpurrLevel.MEGA_PURR),
                new Cat("Tom", LocalDate.of(1991, 4, 1), PurrpurrLevel.MICRO_PURR),
                new Cat("Garfild", LocalDate.of(2006, 12, 11), PurrpurrLevel.MEDIUM_PURR)};
    }

    public static String getInformationAboutObject(Object object) throws IllegalAccessException {
        StringBuilder result = new StringBuilder();
        Class<?> clazz = object.getClass();
        result
                .append(clazz.getSimpleName())
                .append(" (").append(clazz.getName())
                .append(")")
                .append(System.lineSeparator())
                .append(getFieldsInfoFromObject(object, clazz));
        Class<?> parent = clazz.getSuperclass();
        while (parent != null) {
            result.append(getFieldsInfoFromObject(object, parent));
            parent = parent.getSuperclass();
        }
        result.append(getMethodsInfoFromObject(object, clazz));
        return result.toString();
    }

    private static StringBuilder getFieldsInfoFromObject(Object object, Class<?> clazz) throws IllegalAccessException {
        StringBuilder fieldsInfo = new StringBuilder();
        for (var field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            fieldsInfo.append("\t ");
            if (!object.getClass().equals(clazz)) {
                fieldsInfo
                        .append("(super.").append(clazz.getSimpleName()).append(") ");
            }
            fieldsInfo
                    .append(Modifier.toString(field.getModifiers())).append(" ")
                    .append(field.getType().getSimpleName()).append(" ")
                    .append(field.getName())
                    .append(" = ")
                    .append(field.get(object))
                    .append(System.lineSeparator());
        }
        return fieldsInfo;
    }

    private static StringBuilder getMethodsInfoFromObject(Object object, Class<?> clazz) {
        StringBuilder methodsInfo = new StringBuilder();

        for (Method method : clazz.getMethods()) {
            if (Arrays.asList(Object.class.getMethods()).contains(method)) {
                continue;
            }
            methodsInfo
                    .append("\t\t")
                    .append(Modifier.toString(method.getModifiers())).append(" ")
                    .append(method.getReturnType().getSimpleName()).append(" ")
                    .append(method.getName()).append(" ");

            Class<?>[] array = method.getParameterTypes();
            if (array.length > 0) {
                methodsInfo.append("(");
                for (var clazzOfParameter : array)
                    methodsInfo.append(clazzOfParameter.getSimpleName());
                methodsInfo.append(")");
            }
            methodsInfo
                    .append(System.lineSeparator());

        }
        return methodsInfo;

    }


}
