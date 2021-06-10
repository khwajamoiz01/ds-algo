package geeks;

public class Interitance {
//    public static void main(String[] args) {
//        Animal tc1 = new Animal();
//        tc1.walk();
//        //tc1.fly();
//        Animal tc2 = new Bird();
//        tc2.walk();
//        //tc2.fly();
//        Bird tc3 = new Bird();
//        tc3.walk();
//        tc3.fly();
//    }
}

class Animal {
    String legs;

    void walk() {
        System.out.println("Animal#walk");
    }
}

class Bird extends Animal {
    String feathers;

    @Override
    void walk() {
        System.out.println("Bird#walk");
    }

    void fly() {
        System.out.println("Bird#fly");
    }

    public static void main(String[] args) {
        Record r = new Highest(10);
    }
}

class Record {
    protected String n[];//name
    protected int m[];//marks
    protected int size;

        public Record(int cap) {
        }

    public void readArray() {
    }

    public void display() {
    }
}

class Highest extends Record {
    private int ind;

    public Highest(int cap) {
        super(cap);
    }

    public void find() {

    }

    public void display() {
        super.display();
    }
}