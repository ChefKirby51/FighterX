import java.util.InputMismatchException;
import java.util.Scanner;

public class Player extends Fighter
{
    protected Scanner sc;

    public Player(Scanner sc)
    {
        this.sc = sc;
    }
    @Override
    public void makeDecision()
    {
        //when the game starts we want to add a menu selection of start or exit. if the player chooses
        //to start, then we kick off our game logic.
        Menu decisionMenu = new Menu("Do you want to Attack or Defend?", sc);
        decisionMenu.addOption("Attack.");
        decisionMenu.addOption("Defend.");
        decisionMenu.setChoiceMadeCallback((choice) -> {
            this.decision = Fighter.Decisions.values()[choice - 1];
            return choice;
        });
        decisionMenu.show();

        System.out.println(this.decision);


     /*   int decisionInput;
        while (true) {
            try {
                decisionInput = this.sc.nextInt();

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
                this.sc.next();
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
                actionInput = this.sc.nextInt();
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
                this.sc.next();
            }
        }*/
    }
}
