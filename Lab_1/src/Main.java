import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Hero hero = new Hero("Liroy");
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
 //       choice = scanner.nextInt();
        while (choice != 0 ){
            choice = scanner.nextInt();
            if (choice == 1){
   //             hero.printName();
                hero.move(new Walk());
            }
            else if (choice == 2){
                hero.move(new RideTheHorse());
            }
            else if (choice==3) {
                hero.move(new Fly());
            }
            else {
                System.out.println("Hero's stopped");
                choice =0;
            }
        }

    }

}
