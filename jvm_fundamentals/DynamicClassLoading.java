package jvm_fundamentals;

import java.lang.reflect.Method;
import java.util.Random;

public class DynamicClassLoading {
    public static void main(String[] args) throws ClassNotFoundException {
        //Dynamically loading the Random class
        Class Random = Class.forName("java.util.Random");

        //Fetches all the methods inside the Random class
        Method[] methods = Random.getMethods();
        System.out.println("There are " + methods.length + " method inside Random Class");

        //Fetch first 3 methods
        System.out.println("-> Top 3 methods : ");
        for (int i = 0; i < 3; i++) {
            System.out.println(methods[i]);
        }

        //Class is loaded only once
        Random random = new Random();
        Class Random1 = random.getClass();
        System.out.println("Address of Random and Random1 is same? "
                + (Random.hashCode() == Random1.hashCode()));

        //It will give null because it is loaded by BootStrap class loader
        //which is written in C/C++
        System.out.println("Random class Loaded by : " +
                Random.getClassLoader() + "( BootStrap)");

        //User defined classes are loaded by Application class loader
        DynamicClassLoading dcl = new DynamicClassLoading();
        Class DCL = dcl.getClass();
        System.out.println("DynamicClassLoading class is Loaded by : " + DCL.getClassLoader());

        /*
            Output:
                There are 30 method inside Random Class
                -> Top 3 methods :
                public int java.util.Random.nextInt()
                public int java.util.Random.nextInt(int)
                public double java.util.Random.nextDouble()
                Address of Random and Random1 is same? true
                Random class Loaded by : null( BootStrap)
                DynamicClassLoading class is Loaded by : sun.misc.Launcher$AppClassLoader@18b4aac2
         */
    }
}

