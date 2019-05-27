import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class RegService {

    private Vehicle vehicle1 = new Vehicle("Toyota", "Corolla", 2018);
    private Vehicle vehicle2 = new Vehicle("Subaru", "Impreza", 2019);
    private Vehicle vehicle3 = new Vehicle("Audi", "Q5", 2019);

    private Scanner sc = new Scanner(System.in);

    private Random random = new Random();

    private Map <String, Vehicle> vehicles = new HashMap<>();

    public void controlLoop(){

        Option option;

        do{
            displayOptions();
            option = takeUserOption();

            switch (option){

                case EXIT:
                    exit();
                    break;

                case REGISTER_VEHICLE:
                    registerNewVehicle();
                    break;

                case DISPLAY_VEHICLES:
                    displayRegisteredVehicles();
                    break;

            }
        } while (option!=Option.EXIT);
    }

    private void displayOptions(){
        System.out.println("WYBIERZ OPCJĘ:");
        for (Option x : Option.values()) {
            System.out.println(x.getValue() + " - " + x.getDescription());
        }
    }

    private Option takeUserOption() {
        boolean error = true;
        Option option = Option.EXIT;

        do {
            try {
                option = Option.createFromInt(sc.nextInt());
                error = false;
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException exc) {
                System.out.println("spróbuj wybrać liczbę spośród podanych możliwości");
            } finally {
                sc.nextLine();
            }
        } while (error);

        return option;
    }

    private void displayAvaliableVahicles(){
        System.out.println("dostępne pojazdy: ");
        System.out.println("1 - "+vehicle1.toString());
        System.out.println("2 - "+vehicle2.toString());
        System.out.println("3 - "+vehicle3.toString());
    }

    private void exit(){
        System.out.println("koniec programu");
        sc.close();
    }

    private void registerNewVehicle(){
        String plate = "GD "+(10000+random.nextInt(89999));

        if (!checkForDuplicates(plate)) {

            System.out.println("dodajemy nowy samochód, wolna tablica to: " + plate);
            displayAvaliableVahicles();

            int userChoice = sc.nextInt();
            //sc.nextLine();

            switch (userChoice) {
                case 1:
                    vehicles.put(plate, vehicle1);
                    break;
                case 2:
                    vehicles.put(plate, vehicle2);
                    break;
                case 3:
                    vehicles.put(plate, vehicle3);
                    break;
            }
        } else {
            System.out.println("system wygenerował istniejącą tablicę, spróbuj ponownie");
        }
            sc.nextLine();
    }

    private void displayRegisteredVehicles(){

        for(String key:vehicles.keySet()){
            System.out.println(key+ " "+vehicles.get(key).toString());
        }

    }

    private boolean checkForDuplicates(String plate){

        return vehicles.containsKey(plate);
    }
}
