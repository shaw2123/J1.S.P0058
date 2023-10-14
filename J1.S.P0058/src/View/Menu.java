
import Controller.Validation;
import java.util.HashMap;

public class Menu {

    public void realMenu() {
        HashMap<String, String> hm = new HashMap<>();
        Manager mn = new Manager();
        //loop until user want to exit
        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    mn.addNewWord(hm);
                    break;
                case 2:
                    mn.deleteWord(hm);
                    break;
                case 3:
                    mn.translate(hm);
                    break;
                case 4:
                    return;
            }
        }
    }
    public int menu() {
        Validation vali = new Validation();
        System.out.println("1. Add new word.");
        System.out.println("2. Delete word.");
        System.out.println("3. Search word.");
        System.out.println("4. Exit.");
        System.out.print("Enter your choice: ");
        int choice = vali.checkInputIntLimit(1, 4);
        return choice;
    }
}
