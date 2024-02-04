package ru.igor.dm.lesson2.cycles;

public class Task3 {

    /*Программист Ваня сразу после окончания курсов dmdev устроился в IT компанию на позицию
    Junior Java Developer с зарплатой 600$ в месяц.
    Ему обещали, что будут поднимать зарплату на 400$ каждые 6 месяцев.
    300$ в месяц Ваня тратит на еду и развлечения.
    10% от зарплаты Ваня ежемесячно переводит на банковский счет брокера, чтобы инвестировать в акции
    с доходностью 2% в месяц.

    Посчитать, сколько Ваня будет иметь средств на своем счету и на счету брокера за 3 года
     и 2 месяца.

    Для интереса: попробовать увеличить процент, которые Ваня инвестирует из своей зарплаты
    добавить комментарий к уроку
    */

    public static void main(String[] args) {
        double salary = 600.00;
        //каждые 6 месяцев повышение з/п
        double upSalary = 400.00;
        //ежемесячные затраты
        double wastes = 300.00;
        //ежемесячно с з/п перевод брокеру 10%
        double percentOfInvestments = 0.1;
        //ежемесячно зарабатывает брокер 2% от суммы инвестиций
        double percentOfDividends = 0.02;
        //3 года и 2 месяца
        double month = 38.00;

        sumBankAccount(salary, wastes, percentOfInvestments, upSalary, month);
        sumBrokerAccount(salary, percentOfInvestments, upSalary, percentOfDividends, month);
        //если Ваня инвестирует 25 процентов от з/п
        sumBankAccount(salary, wastes, 0.35, upSalary, month);
        sumBrokerAccount(salary, 0.35, upSalary, percentOfDividends, month);
        //если Ваня инвестирует 35 процентов от з/п
        sumBankAccount(salary, wastes, 0.5, upSalary, month);
        sumBrokerAccount(salary, 0.5, upSalary, percentOfDividends, month);
    }

    private static void sumBankAccount(double salary, double wastes, double percentOfInvestments, double upSalary, double month) {
        double sumBankAccount = 0;

        for (int i = 1; i <= month; i++) {
            System.out.println("месяц - " + i);
            System.out.println("зарплата - " + salary);
            double investments = salary * percentOfInvestments;
            if (i % 6 != 0) {
                sumBankAccount += salary - wastes - investments;
            } else {
                sumBankAccount += salary - wastes;
                salary += upSalary;
            }
            System.out.println("Ежемесячные затраты - " + wastes + "$");
            System.out.println("Ежемесячные переводы на брокерский счет - " + investments + "$");
            System.out.println("остаток на банковском счете после " + i + " месяца - " + sumBankAccount + "$");

        }
    }

    // получение з/п происходит в конце месяца, соответственно дивиденды от брокерской деятельности мы получаем только в конце 2 месяца
    private static void sumBrokerAccount(double salary, double percentOfInvestments, double upSalary, double percentOfDividends, double month) {
        double sumBrokerageAccount = 0;

        for (int i = 1; i <= month; i++) {
            // сумма, которую мы переводим ежемесячно на брокерский счет
            double moneyForInvestments = salary * percentOfInvestments;
            String dividends = "Ежемесячные дивиденды от брокерского счета - " + sumBrokerageAccount * percentOfDividends + "$";
            String transaction = "Ежемесячные переводы на брокерский счет - " + moneyForInvestments + "$";
            System.out.println("месяц - " + i);
            System.out.println("зарплата - " + salary + "$");

            if (i == 1) {
                sumBrokerageAccount += moneyForInvestments;
            } else if (i == 2) {
                System.out.println(transaction);
                System.out.println("Ежемесячные дивиденды от брокерского счета - " + (moneyForInvestments) * percentOfDividends + "$");
                sumBrokerageAccount += sumBrokerageAccount * percentOfDividends + moneyForInvestments;
            } else if (i % 6 != 0) {
                System.out.println(dividends + "\n" + transaction);
                sumBrokerageAccount += moneyForInvestments + sumBrokerageAccount * percentOfDividends;
            } else {
                System.out.println(dividends + "\n" + transaction);
                sumBrokerageAccount += moneyForInvestments + sumBrokerageAccount * percentOfDividends;
                salary += upSalary;
            }
            System.out.println("остаток на брокерском счете после " + i + " месяца - " + sumBrokerageAccount + "$" + "\n ->");
        }
    }
}