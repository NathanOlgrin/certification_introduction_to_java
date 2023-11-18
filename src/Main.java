import java.util.*;

public class Main {

    private static HashMap<String, ArrayList<Long>> phoneBook = new HashMap<>();
    private static LinkedHashMap<String, ArrayList<Long>> sorted_phoneBook = new LinkedHashMap<>();
    public void PhoneBook(){
        phoneBook = new HashMap<>();
    }

    public void Sorted_phoneBook(){
        sorted_phoneBook = new LinkedHashMap<>();
    }
    public static void add(String name, Long phoneNum) {
        ArrayList<Long> phoneNums = phoneBook.getOrDefault(name, new ArrayList<>());

        phoneNums.add(phoneNum);

        phoneBook.put(name, phoneNums);
    }

    public static void add_abonents(){
        boolean check = false;
        while(!check){
            System.out.println("Введите имя: ");
            Scanner insert_name = new Scanner(System.in);
            String in_name = insert_name.next();
            System.out.println("Введите телефон: ");
            Scanner insert_number = new Scanner(System.in);
            Long in_number = insert_name.nextLong();
            add(in_name, in_number);
            System.out.println("Если хотите ввести ещё одну запись, нажмите 1, если нет, то 2");
            Scanner insert_choice = new Scanner(System.in);
            int choice = insert_name.nextInt();
            if(choice == 2){
                check = true;
                insert_name.close();
                insert_number.close();
                insert_choice.close();
            }
        }
    }

    public static void sort_phonebook(){
        int count_number = 0;
        String check_name = "";
        while(!phoneBook.isEmpty()){
            for(Map.Entry<String, ArrayList<Long>> entry : phoneBook.entrySet() ){
                if(entry.getValue().size() > count_number){
                    count_number= entry.getValue().size();
                    check_name = entry.getKey();
                }
            }
            sorted_phoneBook.put(check_name, phoneBook.get(check_name));
            phoneBook.remove(check_name);
            count_number = 0;
            check_name = "";
        }
        System.out.println(sorted_phoneBook);
    }

    public static void out_phonebook(){
        sort_phonebook();
    }

    public static void main(String[] args) {


        add_abonents();
        System.out.println("check1");
        System.out.println(phoneBook);
        System.out.println("check2");
        sort_phonebook();

    }
}