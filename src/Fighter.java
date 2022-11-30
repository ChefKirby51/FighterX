import java.util.Random;
import java.util.Scanner;
public class Fighter
{
    protected enum AttackActions {
        PUNCH,
        KICK;

        private static final AttackActions[] VALUES = values();
        private static final int SIZE = VALUES.length;
        private static final Random RANDOM = new Random();

        public static AttackActions getRandom() {
            return VALUES[RANDOM.nextInt(SIZE)];
        }
    }

    protected enum DefenseActions
    {
        BLOCK,
        CROUCH;

        private static final DefenseActions[] VALUES = values();
        private static final int SIZE = VALUES.length;
        private static final Random RANDOM = new Random();

        public static DefenseActions getRandom() {
            return VALUES[RANDOM.nextInt(SIZE)];
        }
    }

    protected enum Decisions
    {
        Attack,
        Defend;

        private static final Decisions[] VALUES = values();
        private static final int SIZE = VALUES.length;
        private static final Random RANDOM = new Random();

        public static Decisions getRandom() {
            return VALUES[RANDOM.nextInt(SIZE)];
        }
    }

    private double hp = 100.0;

    /**
     *
     * @param otherFighter
     * @param action
     */
    public void doDamage(Fighter otherFighter, AttackActions action)
    {
        double damage = Helpers.randRange(5.0, 15.0);

        otherFighter.takeDamage(damage, action);
    }

    public void makeDecision()
    {
        //for npcs a decision will be random

        //for players a decision will be entered into the command prompt
    }

    public void block(Fighter fighter)
    {

    }

    /** docblock/docstring
     * Given a damage number and an attack action, take hp from this fighter
     * @param damage - the amount of damage the fighter should take.
     * @param action - the attack action being done to this fighter
     */
    public void takeDamage(double damage, AttackActions action)
    {
        if (action == AttackActions.KICK)
        {
            //if we decided to crouch, take half damage, otherwise take full damage

        } else if (action == AttackActions.PUNCH) {
            //if we decided to block take half damage, otherwise take full damage
        }
        hp -= damage;
    }
}
