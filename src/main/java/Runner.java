import Guest.Group;
import Guest.Guest;
import Rooms.Bedroom;
import Rooms.Room;
import Rooms.RoomType;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

    private Hotel hotel;

    public Runner (Hotel hotel) {
        this.hotel = hotel;
    }

    public static void main(String[] args) {

        Hotel hotel2 = new Hotel("Club Tropicana");
        Bedroom bedroom1 = new Bedroom(RoomType.SINGLE, 80.0, 101, 2);
        Bedroom bedroom2 = new Bedroom(RoomType.DOUBLE, 200.0, 102, 2);
        Bedroom bedroom3 = new Bedroom(RoomType.PENTHOUSE, 300.0, 103, 4);
        Bedroom bedroom4 = new Bedroom(RoomType.SINGLE, 300.0, 104, 2);
        Bedroom bedroom5 = new Bedroom(RoomType.DOUBLE, 300.0, 105, 2);
        Guest guest1 = new Guest("Lacey", 300.0);
        Guest guest2 = new Guest("Alex", 120.0);
        Guest guest3 = new Guest("Bill", 220.0);
        Guest guest4 = new Guest("Steve", 120.0);
        Guest guest5 = new Guest("Jenny", 300.0);
        Guest guest6 = new Guest("Sarah", 300.0);
        Group group2 = new Group();
        Group group3 = new Group();
        Group group4 = new Group();

        hotel2.addBedRoom(bedroom1);
        hotel2.addBedRoom(bedroom2);
        hotel2.addBedRoom(bedroom3);
        hotel2.addBedRoom(bedroom4);
        hotel2.addBedRoom(bedroom5);
        group2.addGuest(guest1);
        group2.addGuest(guest2);
        group3.addGuest(guest3);
        group3.addGuest(guest4);
        group4.addGuest(guest5);
        group4.addGuest(guest6);

        hotel2.checkIn(bedroom1, group2, 1);
        hotel2.checkIn(bedroom2, group3, 1);
        hotel2.checkIn(bedroom3, group4, 1);

        Runner runner = new Runner(hotel2);
        runner.run();


    }

    public void run(){
        String choice;
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        do {
            System.out.println("Welcome to " + hotel.getHotelName() + " Admin Services");
            System.out.println("Menu Options:\n" +
                    "1. View all Rooms\n" +
                    "2. View Unoccupied Rooms\n" +
                    "3. View Number of Guests in Hotel\n" +
                    "4. Total money paid in\n" +
                    "5. To check-in guests\n" +
                    "Q. Quit program\n");
            String input = scanner.nextLine().toLowerCase();
            choice = input;
            switch (choice) {
                case "1":
                    System.out.println(hotel.allRoomInfo());
                    System.out.println("Press any key return to the main menu");
                    String input2 = scanner.nextLine();
                    choice = input2.toLowerCase();
                    break;
                case "2":
                    System.out.println(hotel.unoccupiedRooms());
                    System.out.println("Press any key return to the main menu");
                    String input3 = scanner.nextLine();
                    choice = input3.toLowerCase();
                    break;
                case "3":
                    System.out.println(hotel.totalNumberOfGuests() + " guests");
                    System.out.println("Press any key return to the main menu");
                    String input4 = scanner.nextLine();
                    choice = input4.toLowerCase();
                    break;
                case "4":
                    System.out.println("£" + hotel.getMoneyMade());
                    System.out.println("Press any key to return to the main menu");
                    String input5 = scanner.nextLine();
                    choice = input5.toLowerCase();
                    break;
                case "5":
                    Group temporaryGuestList = new Group();
                    System.out.println("Number of Customers: ");
                    Integer numberOfGuests = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < numberOfGuests; i++) {
                            System.out.println("Guest name: ");
                            String guestName = scanner.nextLine();
                            System.out.println("Guest wallet: ");
                            Double guestWallet = Double.parseDouble(scanner.nextLine());
                            temporaryGuestList.addGuest(new Guest(guestName, guestWallet));
                        }
                    ArrayList<Bedroom> roomList = new ArrayList<>();
                    System.out.println("Number of rooms: ");
                    Integer numberOfRooms = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < numberOfRooms; i++){
                            System.out.println(hotel.unoccupiedRooms());
                            System.out.println("Choose Room(s): ");
                            Integer roomNumber = Integer.parseInt(scanner.nextLine());
                            roomList.add(hotel.findRoom(roomNumber));
                        }
                            String answer = "";
                            for (int i = 0; i < roomList.size(); i++) {
                            Group group = new Group();
                            while (!answer.equals("next")) {
                                System.out.println("Who will go in " + roomList.get(i).getRoomNumber() + "?");
                                System.out.println(temporaryGuestList.getGuestsList());
                                String searchName = scanner.nextLine();
                                 for(Guest guest : temporaryGuestList.getGuestsList()){
                                     if (searchName == guest.getName()){
                                         Guest result = guest;
                                         group.addGuest(result);
                                         System.out.println(group.getGuestsList());
                                     }
                                     System.out.println(group.getGuestsList());
                                 }
                                System.out.println("Type continue to add another guest or next to go to the next room");
                                answer = scanner.nextLine();
                            }
                            hotel.checkIn(roomList.get(i), group, 1);
                            group.removeAll();


                }
                    temporaryGuestList.removeAll();
                    System.out.println(hotel.allRoomInfo());
                        break;

                case "q":
                    System.exit(0);
                    break;
            }
        } while (!choice.equals("q"));
    }


}
