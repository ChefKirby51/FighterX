import java.util.InputMismatchException;
import java.util.Scanner;

public class Player extends Fighter
{
    protected Scanner keyboard;

    public Player(Scanner keyboard)
    {
        this.keyboard = keyboard;
    }
    @Override
    public void makeDecision()
    {
        //when the game starts we want to add a menu selection of start or exit. if the player chooses
        //to start, then we kick off our game logic.
        System.out.println("Do you want to Attack or Defend?");
        System.out.println("======================");
        System.out.println("Type 1 to use offensive action.");
        System.out.println("Type 2 to use defensive action.");

        int decisionInput;
        while (true) {
            try {
                decisionInput = this.keyboard.nextInt();

                if (decisionInput == 1) {
                    decision = Decisions.ATTACK;
                } else if ( decisionInput == 2) {
                    decision = Decisions.DEFEND;
                } else {
                    System.out.println("Invalid input. Please try again.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                this.keyboard.next();
            }
        }

        //number of actions based on the players decision
        int actionsLength = 0;

        //if the player decides to attack...
        if (decision == Fighter.Decisions.ATTACK) {
            //loop over all the attack options and print them out as a user decision
            System.out.println("Choose your offensive action.");

            int index = 1;
            actionsLength = Fighter.AttackActions.values().length;
            for (Fighter.AttackActions action : Fighter.AttackActions.values()) {
                String formatted = String.format("%d. %s", index, action);
                System.out.println(formatted);
                index += 1;
            }
        //if the player decides to defend...
        } else if (decision == Fighter.Decisions.DEFEND) {
            //loop over all the defense options and print them out as a user decision
            System.out.println("Choose your defensive action.");

            int index = 1;
            actionsLength = Fighter.DefenseActions.values().length;
            for (Fighter.DefenseActions action : Fighter.DefenseActions.values()) {
                String formatted = String.format("%d. %s", index, action);
                System.out.println(formatted);
                index += 1;
            }
        }

        int actionInput;
        while (true) {
            try {
                actionInput = this.keyboard.nextInt();
                //if the user typed in (actionInput) is between the min (1) and max (length of the actions).
                // actionInput >= 1 and action input <= actionsLength
                if (actionInput >= 1 && actionInput <= actionsLength) {
                    actionIndex = actionInput - 1;
                } else {
                    System.out.println("Invalid input. Please try again.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                this.keyboard.next();
            }
        }
    }
}
