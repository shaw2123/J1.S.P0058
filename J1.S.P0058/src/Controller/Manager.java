import Controller.Validation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Manager {
    Validation vali = new Validation();

    //add new word
    public void addNewWord(HashMap<String, String> hm) {
        System.out.print("Enter Enlish: ");
        String english = vali.checkInputString();
        if (!checkKeywordExist(hm, english)) {
            if (!vali.checkInputYN()) {
                return;
            }
        }
        System.out.print("Enter Vietnamese: ");
        String vietnam = vali.checkInputString();
        //check key word english exist or not
        hm.put(english, vietnam);
        System.err.println("Add successful.");
    }

    //delete word
    public void deleteWord(HashMap<String, String> hm) {
        System.out.print("Enter english: ");
        String english = vali.checkInputString();
        hm.remove(english);
        System.err.println("Delete successful.");
    }

    //translate
    public void translate(HashMap<String, String> hm) {
        System.out.print("Enter english: ");
        String english = vali.checkInputString();
        Set<Map.Entry<String, String>> entries = hm.entrySet();
        for (Map.Entry entry : entries) {
            if (entry.getKey().equals(english)) {
                System.out.println("Vietnamese: " + entry.getValue());
                return;
            }
        }
        System.err.println("Not found in data");
    }

    //check key englist exist
    public boolean checkKeywordExist(HashMap<String, String> hm, String english) {
        Set set = hm.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            if (english.equalsIgnoreCase(mentry.getKey().toString())) {
                return false;
            }
        }
        return true;
    }
}
