import java.util.Random;
import java.util.Scanner;
public class Fighter
{
    protected Decisions decision;

    protected int actionIndex;

    protected enum AttackActions {
        PUNCH,
        KICK,
    }

    protected enum DefenseActions
    {
        BLOCK,
        CROUCH
    }

    protected enum Decisions
    {
        ATTACK,
        DEFEND
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

    /** docblock/docstring
     * Given a damage number and an attack action, take hp from this fighter
     * @param damage - the amount of damage the fighter should take.
     * @param action - the attack action being done to this fighter
     */
    public void takeDamage(double damage, AttackActions action)
    {
        switch(action) {
            case KICK:
                //if our last choice is to crouch
                damage /= 2;
                break;
            case PUNCH:
                //do something
                break;
            default:
                //do something default
                break;
        }

        hp -= damage;
    }
}
