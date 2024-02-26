package ru.igor.dm.lesson4.encapsulation;

import ru.igor.dm.lesson4.encapsulation.CashMachine;

public class Main {

    public static void main(String[] args) {

        CashMachine cashMachine = new CashMachine(1,1,3);
        System.out.println(CashMachine.getSumInCashMachine());
        cashMachine.getNode(90);
        System.out.println(CashMachine.getSumInCashMachine());


    }


}
