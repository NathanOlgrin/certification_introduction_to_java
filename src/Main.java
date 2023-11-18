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

        /* Данный метод добавляет один номер и одно имя в телефонную книгу*/

        ArrayList<Long> phoneNums = phoneBook.getOrDefault(name, new ArrayList<>());
        phoneNums.add(phoneNum);
        phoneBook.put(name, phoneNums);
    }

    public static void add_abonents(){

        /*Данный метод реализует заполнение телефонной книги до тех пор, пока пользователь не сочтет нужным прекратить добавление*/

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

        /*Данный метод сортирует телефонную книгу*/

        int count_number = 0;
        String check_name = "";
        while(!phoneBook.isEmpty()){
            for(Map.Entry<String, ArrayList<Long>> entry : phoneBook.entrySet() ){ // переборка телефонной книги в целях поиска максимального количества номеров
                if(entry.getValue().size() > count_number){ // проверка количества номеров
                    count_number= entry.getValue().size();
                    check_name = entry.getKey(); //ввод в буферную переменную имени абонента с максимальным на данный момент количеством номеров
                }
            }
            sorted_phoneBook.put(check_name, phoneBook.get(check_name)); // добавление данных в отсортированную телефонную книгу
            phoneBook.remove(check_name); //удаление данных из первичной телефонной книги
            count_number = 0;
            check_name = "";
        }
        System.out.println(sorted_phoneBook);
    }

    public static void main(String[] args) {

        add_abonents();
        sort_phonebook();
    }
}