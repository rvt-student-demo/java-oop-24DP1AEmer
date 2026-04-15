package rvt;

public class Counter {

    public int addToNumber(int number) {
        return number + 1;
    }
    
    public int subtractFromNumber(int number) {
        return number - 1;
    }
}

----------------------

public class SuperCounter extends Counter {

    @Override
    public int addToNumber(int number) {
        return number + 5;
    }
    
}

----------------------

public static void main(String[] args) {
    Counter counter = new Counter();
    Counter superCounter = new SuperCounter();
    int number = 3;
    number = superCounter.subtractFromNumber(number);
    number = superCounter.subtractFromNumber(number);
    number = counter.addToNumber(number);
    System.out.println(number);
}
