import java.util.InputMismatchException;
import java.util.Scanner;
public class Game {
    public static void start()
    {
        //when the game starts we want to add a menu selection of start or exit. if the player chooses
        //to start, then we kick off our game logic.
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to Fighters-X!");
        System.out.println("======================");
        System.out.println("Type 1 to begin a new fight.");
        System.out.println("Type 2 to end the game.");

        int menuInput;

        while (true) {
            try {
                menuInput = keyboard.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                keyboard.next(); // this consumes the invalid token
            }
        }

        if (menuInput == 1) {
            fight(keyboard);
        } else {
            System.out.println("Goodbye.");
            System.exit(StatusCodes.OK);
        }
    }

    public static void fight(Scanner keyboard)
    {
        Player player = new Player(keyboard);
        Enemy enemy = new Enemy();

        player.makeDecision();
        //have enemy make their decision

        //have player and enemy do damage to eachother based on their choices
        //make decisions again and repeat until one is dead, game over
    }
}
