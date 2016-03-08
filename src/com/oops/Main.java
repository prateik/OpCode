package com.oops;



/*main()
invokes Derived.<init>() (the implicit nullary constructor)
invokes Base.<init>()
sets Base.x to 1.
invokes Derived.foo()
prints Derived.x, which still has the default value of 0
sets Derived.x to 2.
invokes Derived.foo().
prints Derived.x, which is now 2.*/

 abstract class Base {
    public int x = 1;
    public Base() {
        foo();
    }
    public abstract void foo();
}

 class Derived extends Base {
    int x = 2;
    @Override
    public void foo() {
        System.out.println("Derived: "+x);
    }
}

public class Main {
    public static void main(String... args) {
        Base base = new Derived();
        base.foo();
    }
}