package ru.igor.dm.lesson3.oop;

public class Runner {


    /* Представить в виде классов и их композиции следующую модель.

   - Каждый дом содержит свой номер (int), и множество этажей (массив).

               - Каждый этаж содержит номер этажа (int), и множество квартир (массив).

               - Каждая квартира содержит свой номер (int), и множество комнат (массив).

               - Каждая комната содержит поле проходная она или нет (boolean).

       В каждом классе реализовать метод print, который на консоль выводит информацию об объекте (должны присутствовать все поля объекта!).

       Например, метод print класса этаж должен выводить на консоль:

               “Этаж 2, количество квартир 18”

       Создание всех объектов вынести в отдельный класс с методом main.

       Там же реализовать метод printAllInformation, который на вход принимает объект типа дом,
       и выводит информацию о нем, его этажах, квартирах и комнатах, вызывая методы print.
   */
    public static void main(String[] args) {

        House house1 = new House(1, 5, 4, 2);

        House.Floor floor = house1.getFloors()[1];
        House.Floor.Apartment apartment = floor.getApartments()[1];
        House.Floor.Apartment.Room room = apartment.getRooms()[1];

        System.out.println("Номер дома " + house1.getNumber());
        house1.printAllInformation();

        System.out.println("Номер этажа " + floor.getNumber());
        floor.print();

        System.out.println("Номер квартиры " + apartment.getNumber());
        apartment.print();

        System.out.printf("Комната %sпроходная %n", room.isWalkThrough() ? "" : "не ");
        room.print();

    }
}
