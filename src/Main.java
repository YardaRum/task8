import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String a) {
        name = a;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {

        return name + ", возраст " + age + " лет";
    }
}

class UserComparator implements java.util.Comparator<User> {
    @Override
    public int compare(User a, User b) {
        return a.getName().compareTo(b.getName());
    }
}

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, ArrayList<User>> Users = new HashMap<Integer, ArrayList<User>>();
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Введите имя пользователя " + (i + 1));
            String name = scan.next();
            System.out.println("Введите возраст пользователя " + (i + 1));
            int age = scan.nextInt();
            User u = new User(name, age);

            ArrayList<User> UserList = Users.get(age);
            if (UserList == null) {
                UserList = new ArrayList<User>();
                Users.put(age, UserList);
            }
            UserList.add(u);
        }
        System.out.println("Введите требуемый возраст");
        int age = scan.nextInt();
        ArrayList<User> UserList = Users.get(age);
        if (UserList == null) {
            System.out.println("Пользователь с возрастом '" + age + "' не найден");
        } else {
            Collections.sort(UserList, new UserComparator());
            for (int i = 0; i < UserList.size(); i++) {
                System.out.println(UserList.get(i).toString());
            }
        }

    }

}