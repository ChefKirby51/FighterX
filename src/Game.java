import java.util.InputMismatchException;
import java.util.Scanner;
public class Game {
    public static void start(Scanner sc)
    {
        Menu mainMenu = new Menu("Welcome to Fighters-X!", sc);
        mainMenu.addOption("Begin a new fight.");
        mainMenu.addOption("Exit.");
        mainMenu.setChoiceMadeCallback((choice) -> {
            if (choice == 1) { //fight
                Game.fight(sc);
            } else { //exit
                Game.exit();
            }
            return choice;
        });
        mainMenu.show();
    }

    public static void exit()
    {
        System.out.println("Goodbye.");
        System.exit(StatusCodes.OK);
    }

    public static void fight(Scanner sc)
    {
        Player player = new Player(sc);
        Enemy enemy = new Enemy();

        player.makeDecision();
        //have enemy make their decision

        //have player and enemy do damage to eachother based on their choices
        //make decisions again and repeat until one is dead, game over
    }
}
