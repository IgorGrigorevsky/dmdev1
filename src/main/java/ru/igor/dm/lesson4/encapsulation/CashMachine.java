package ru.igor.dm.lesson4.encapsulation;

public class CashMachine {

    /*Создать класс, описывающий банкомат.

    Банкомат задается тремя свойствами:
            - количеством купюр номиналом 10, 20 и 50.

    +Создать конструктор с тремя параметрами - количеством купюр каждого номинала.
    + Сделать методы для добавления денег в банкомат.
    Сделать метод, снимающий деньги: он принимает сумму денег, а возвращает булево значение - успешность выполнения операции.
    При снятии денег метод должен распечатывать каким количеством купюр какого номинала выдаётся сумма.
    Сначала банкомат будет пытаться рассчитаться 50, далее добавит недостающие 20, и только затем 10
    (не нужно рассматривать более сложные варианты выдачи наличных, чтобы не усложнять алгоритм).*/

    private final int countTenNote;
    private final int countTwentyNote;
    private final int countFiftyNote;

    private static int sumInCashMachine = 0;

    public CashMachine(int countTenNote, int countTwentyNote, int countFiftyNote) {
        this.countTenNote = countTenNote;
        this.countTwentyNote = countTwentyNote;
        this.countFiftyNote = countFiftyNote;
        this.addNote(countTenNote, countTwentyNote, countFiftyNote);
    }

    // Метод публичный, т.к. пользователь должен добавлять купюры извне
    public void addNote(int countTenNote, int countTwentyNote, int countFiftyNote) {
        if (countTenNote > 0) {
            sumInCashMachine += countTenNote * 10;
        }
        if (countTwentyNote > 0) {
            sumInCashMachine += countTwentyNote * 20;
        }
        if (countFiftyNote > 0) {
            sumInCashMachine += countFiftyNote * 50;
        }
    }

    // Метод публичный, т.к. пользователь должен получать купюры извне
    public boolean getNode(int sumGetCash) {

        if (sumGetCash % 10 != 0 && sumGetCash > 0) {
            System.out.println("запрошена некорректная сумма");
            return false;
        } else {
            if (sumGetCash > sumInCashMachine) {
                System.out.println("недостаточно средств");
                return false;
            }

            int REMAINDER_DIVISION_BY_50 = sumGetCash / 50;
            if (sumGetCash % 50 == 0) {
                System.out.println("выдано количество купюр по 50 - " + REMAINDER_DIVISION_BY_50);
                sumInCashMachine -= sumGetCash;
                return true;
            } else {
                System.out.println("выдано количество купюр по 50 - " + REMAINDER_DIVISION_BY_50);
                sumInCashMachine -= REMAINDER_DIVISION_BY_50 * 50;
                sumGetCash -= REMAINDER_DIVISION_BY_50 * 50;
                int REMAINDER_DIVISION_BY_20 = sumGetCash / 20;
                if (sumGetCash % 20 == 0) {
                    System.out.println("выдано количество купюр по 20 - " + REMAINDER_DIVISION_BY_20);
                    sumInCashMachine -= sumGetCash;
                    return true;
                } else {
                    System.out.println("выдано количество купюр по 20 - " + REMAINDER_DIVISION_BY_20);
                    sumInCashMachine -= REMAINDER_DIVISION_BY_20 * 20;
                    sumGetCash -= REMAINDER_DIVISION_BY_20 * 20;
                    int REMAINDER_DIVISION_BY_10 = sumGetCash / 10;
                    System.out.println("выдано количество купюр по 10 - " + REMAINDER_DIVISION_BY_10);
                    sumInCashMachine -= REMAINDER_DIVISION_BY_10 * 10;

                }
            }
        }
        return true;
    }

    // Метод публичный, т.к. пользователь должен получать состояние баланса извне
    public static int getSumInCashMachine() {
        return sumInCashMachine;
    }
}
