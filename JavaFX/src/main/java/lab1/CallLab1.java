package lab1;

public class CallLab1 {
    public static String callLab1(int choice) {
        Hero hero = new Hero("Rilay");
        String result;
        if (choice == 1) {

            result = hero.move(new Walk());
        } else if (choice == 2) {
            result = hero.move(new RideTheHorse());
        } else if (choice == 3) {
            result = hero.move(new Fly());
        } else {
            result = "Hero's stopped";
            choice = 0;
        }


        return result;
    }

}

