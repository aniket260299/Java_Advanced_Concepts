package java_8_features;

interface ForMethodReference {
    int add(int a, int b);
}

interface ForConstructorMapping {
    MethodPool get(String value);
}

class MethodPool {
    String value;

    public MethodPool(String value) {
        this.value = value;
        System.out.println("Inside constructor using " + value);
    }

    public int add(int a, int b) {
        return a + b;
    }

    public static int Add(int a, int b) {
        return a + b;
    }
}

public class MethodReferenceDemo {
    public static void main(String[] args) {
        //Method referencing using static method
        ForMethodReference fmr1 = MethodPool::Add;
        System.out.println("Static method reference add(1, 3) : " + fmr1.add(1, 3));

        //Method referencing using instance method
        MethodPool methodPool = new MethodPool("Normal Object creation");
        ForMethodReference fmr2 = methodPool::add;
        System.out.println("Instance method reference add(2, 3) : " + fmr2.add(2, 3));

        //Constructor reference
        ForConstructorMapping fcm1 = MethodPool::new;
        MethodPool mp = fcm1.get("Constructor reference");

        //For sending constructor we can also use Lambda
        ForConstructorMapping fcm2 = x -> new MethodPool(x);
        MethodPool mp1 = fcm2.get("Lambda");

        /*
            Output:
                Static method reference add(1, 3) : 4
                Inside constructor using Normal Object creation
                Instance method reference add(2, 3) : 5
                Inside constructor using Constructor reference
                Inside constructor using Lambda
         */
    }

}
