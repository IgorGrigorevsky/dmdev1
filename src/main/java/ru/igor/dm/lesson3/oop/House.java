package ru.igor.dm.lesson3.oop;

import java.util.Random;

public class House {

    private final int number;

    private final Floor[] floors;

    public House(int number, int floorsCount, int apartmentsOnFloorCount, int roomsInApartmentCount) {
        this.number = number;
        this.floors = new Floor[floorsCount];

        for (int i = 0; i < floors.length; i++) {
            floors[i] = new Floor(i + 1, apartmentsOnFloorCount, roomsInApartmentCount);
        }
    }

    public void printAllInformation() {
        System.out.println("House number = " + number);
        for (Floor floor : floors) {
            System.out.print("\t");
            floor.print();
            for (Floor.Apartment apartment : floor.apartments) {
                System.out.print("\t\t");
                apartment.print();
                for (Floor.Apartment.Room room : apartment.rooms) {
                    System.out.print("\t\t\t");
                    room.print();
                }
            }
        }
    }

    public int getNumber() {
        return number;
    }

    public Floor[] getFloors() {
        return floors;
    }

    public static class Floor {

        private final int number;

        private final Apartment[] apartments;

        private Floor(int number, int apartmentsOnFloorCount, int roomsInApartmentCount) {
            this.number = number;
            this.apartments = new Apartment[apartmentsOnFloorCount];

            for (int i = 0; i < apartments.length; i++) {
                apartments[i] = new Apartment(i + 1, roomsInApartmentCount);
            }
        }

        public void print() {
            System.out.printf("Этаж %d, количество квартир %d%n", number, apartments.length);

        }

        public int getNumber() {
            return number;
        }

        public Apartment[] getApartments() {
            return apartments;
        }


        public static class Apartment {

            private static final Random RANDOM = new Random();

            private final int number;

            private final Room[] rooms;

            private Apartment(int number, int roomsInApartmentCount) {
                this.number = number;
                this.rooms = new Room[roomsInApartmentCount];

                for (int i = 0; i < rooms.length; i++) {
                    rooms[i] = new Room(RANDOM.nextBoolean());
                }
            }

            public void print() {
                System.out.printf("Номер квартиры %d, количество комнат %d%n", number, rooms.length);
            }

            public int getNumber() {
                return number;
            }

            public Room[] getRooms() {
                return rooms;
            }


            public static class Room {

                private final boolean isWalkThrough;

                private Room(boolean isWalkThrough) {

                    this.isWalkThrough = isWalkThrough;
                }

                public void print() {
                    System.out.printf("Комната %sпроходная %n", isWalkThrough ? "" : "не ");
                }

                public boolean isWalkThrough() {
                    return isWalkThrough;
                }
            }
        }
    }
}

