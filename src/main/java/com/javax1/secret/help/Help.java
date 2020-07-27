package com.javax1.secret.help;

import com.javax1.secret.base.Entrance;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * If you tried your best but did not succeed, look here for some help.
 */
public class Help {
    /**
     * Here is a main method for convenience.
     */
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        fieldFinder();
        fieldValues();
        methodFinder();
        modified();
    }

    // Here are two classes. One extends the other.

    /**
     * First, the base class.
     */
    static class Base {
        protected String a = "Hello ";
        public String b;
        private String c;

        public static void foo() {
        }

        public void bar() {
        }

        private void goo() {
        }

        protected void gar() {
        }
    }

    /**
     * Then, the extension class
     */
    static class Extend extends Base {
        protected static String d = "World!";
        public String e;
        private String f = "Catch me if you can.";

        private static void dar() {
        }

        public void har() {
        }
    }

    private static void fieldFinder() {
        Class<Extend> klass = Extend.class;
        Field[] declaredFields = klass.getDeclaredFields(); // What will this return? Try to guess!
        printFields(declaredFields);
        Field[] fields = klass.getFields(); // What will this return? Try to guess!
        printFields(fields);
        Field[] baseFields = Base.class.getDeclaredFields(); // What will this return? Try to guess!
        printFields(baseFields);
    }

    private static void printFields(Field[] fields) {
        System.out.println(Stream.of(fields).map(Field::getName).collect(joining(", ")));
    }

    private static void fieldValues() throws NoSuchFieldException, IllegalAccessException {
        Field baseField = Base.class.getDeclaredField("a");
        System.out.print(baseField.get(new Base()));

        Field extendField = Extend.class.getDeclaredField("d");
        System.out.println(extendField.get(null));

        Field privateField = Extend.class.getDeclaredField("f");
        try {
            System.out.println(privateField.get(new Extend()));
        } catch (IllegalAccessException oops) {
            System.out.println("There was an IllegalAccessException thrown here.");
            privateField.setAccessible(true);
            System.out.println(privateField.get(new Extend()));
        }
    }

    private static void methodFinder() {
        Class<Extend> klass = Extend.class;
        Method[] declaredMethods = klass.getDeclaredMethods();
        printMethods(declaredMethods);
        Method[] methods = klass.getMethods();
        printMethods(methods);
        Method[] baseMethods = Base.class.getDeclaredMethods();
        printMethods(baseMethods);
    }

    private static void printMethods(Method[] methods) {
        System.out.println(Stream.of(methods).map(Method::getName).collect(joining(",")));
    }

    private static void modified() throws NoSuchMethodException {
        Method method = Base.class.getMethod("foo");
        int modifiers = method.getModifiers(); // An int? But why?
        System.out.println(modifiers);
        System.out.println(modifiers & Modifier.FINAL); // Bitmasking here
    }

}
