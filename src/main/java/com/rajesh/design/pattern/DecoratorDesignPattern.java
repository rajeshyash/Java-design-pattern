package com.rajesh.design.pattern;

/*
* Decorator design pattern is Structural design pattern
* When we want to change functionality of an Object at run time
* it should not change the individual Object functionality.
* */

interface Dress {
    void assemble();
}

class BasicDress implements Dress{
    @Override
    public void assemble() {
        System.out.println("BasicDress Dress Features");
    }
}


class DressDecorator implements Dress{
    protected Dress dress;

    public DressDecorator(Dress dress){
        this.dress = dress;
    }

    @Override
    public void assemble() {
        this.dress.assemble();
    }
}

class CasualDress extends DressDecorator{

    public CasualDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding the Casual Dress!");
    }
}

class SportyDress extends DressDecorator{

    public SportyDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding the Sporty Dress!");
    }
}







public class DecoratorDesignPattern {
    public static void main(String[] args) {

        Dress sportyDress = new SportyDress(new BasicDress());
        sportyDress.assemble();
        System.out.println();

        Dress facnyDress = new SportyDress(new CasualDress(new BasicDress()));
        facnyDress.assemble();


    }
}
