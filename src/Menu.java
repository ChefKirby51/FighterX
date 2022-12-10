import java.util.function.IntFunction;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu
{
    protected String title;

    protected String separator;

    protected ArrayList<String> options;

    protected Menu childMenu;

    protected Menu parentMenu;

    protected int choice;

    protected IntFunction<Integer> choiceMadeCallback;

    protected Scanner keyboard;

    public Menu(String title, Scanner keyboard)
    {
        this.setTitle(title);
        this.setOptions(new ArrayList<String>());
        this.setScanner(keyboard);
        this.setSeparator("========================");
    }

    public int getChoice()
    {
        return this.choice;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setSeparator(String separator)
    {
        this.separator = separator;
    }
    public void setOptions(ArrayList<String> options)
    {
        this.options = options;
    }

    public void setScanner(Scanner keyboard)
    {
        this.keyboard = keyboard;
    }

    public void addOption(String option)
    {
        this.options.add(option);
    }

    public void setChildMenu(Menu menu)
    {
        this.childMenu = menu;

        menu.parentMenu = this;
    }

    public boolean hasParentMenu()
    {
        return this.parentMenu != null;
    }

    public boolean hasChildMenu()
    {
        return this.childMenu != null;
    }

    public boolean hasChoiceMadeCallback()
    {
        return this.choiceMadeCallback != null;
    }

    public void setChoiceMadeCallback(IntFunction<Integer> callback)
    {
        this.choiceMadeCallback = callback;
    }

    public void show()
    {
        this.choice = 0;

        ArrayList<String> optionsClone = Helpers.arrayListDeepClone(this.options);

        if (this.hasParentMenu()) {
            optionsClone.add("Go Back");
        }

        System.out.println(this.title);

        System.out.println(this.separator);

        int index = 1;
        for (String option : optionsClone) {
            String formatted = String.format("%d => %s", index, option);
            System.out.println(formatted);
            index ++;
        }

        while (this.choice == 0) {
            try {
                int input = this.keyboard.nextInt();

                if (input >= 1 && input <= optionsClone.size()) {
                    this.choice = input;
                    if (this.hasChoiceMadeCallback()) {
                        this.choiceMadeCallback.apply(this.choice);
                    }
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

        if (this.hasParentMenu() && this.choice == optionsClone.size()) {
            this.parentMenu.show();
        } else if (this.hasChildMenu()) {
            this.childMenu.show();
        }
    }
}
