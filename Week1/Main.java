import java.util.*;

public class Main {

    public static void main(String[] args) {

        //Main.fizzBuzz();

        //System.out.println(Main.isEven(10));
        //System.out.println(Main.isEven(3));


        /*
        Integer[] emptyNums = {};
        Integer[] numbers = {1,2,3,4,5,6,7, -10,20};
        System.out.println(Main.getMinimum(numbers));
        System.out.println(Main.getMinimum(emptyNums));
*/

//        ArrayList<User> users = Main.getParsedUsers(Data.users);
        //System.out.println(users);

        // Main.printUsers_OMN(users);

        // Main.printUsersSortedByAge(users);

        // Main.printUsersOldest10(users);

        //Main.printUserStateStats(users);

        /*
        Set<String> overlap = Main.getWordOverlap(Data.words_1, Data.words_2);
        System.out.println(overlap);
*/

        ArrayList<User> usersA = Main.getParsedUsers(Data.users);
        ArrayList<User> usersB = Main.getParsedUsers(Data.otherUsers);

        System.out.println(Main.getUserOverlap(usersA, usersB));


    }

    //Question 1
    public static void fizzBuzz(){

        for (int i = 1; i <= 20 ; i++) {
            if(i % 3 == 0 && i % 5 == 0){
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0){
                System.out.println("Fizz");
            } else if (i % 5 == 0){
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    //Question 2
    public static boolean isEven(Integer num){
        return (num & 1) == 0;
    }

    //Question 3
    public static Integer getMinimum(Integer[] numbers){
        if(numbers == null || numbers.length == 0){
            return null;
        }

        Integer min = numbers[0];

        for (Integer num: numbers) {
            min = Math.min(num,min);
        }

        return min;
    }

    //Question 4
    public static ArrayList<User> getParsedUsers(String[] strings){
        ArrayList<User> users = new ArrayList<>();

        for (String line: strings) {
            User user = new User(line);
            users.add(user);
        }

        return users;
    }

    //Question 5
    public static void printUsers_OMN(ArrayList<User> users){
        for (User user: users) {
            char ch = user.getFname().charAt(0);
            if(ch == 'O' || ch == 'M' || ch == 'N'){
                System.out.println(user.getFname());
            }
        }
    }

    //Question 6
    public static void printUsersSortedByAge(ArrayList<User> users){
        Collections.sort(users);
        for (User user: users) {
            System.out.println(user.getAge() + " " + user.getFname());
        }
    }


    //Question 7
    public static void printUsersOldest10(ArrayList<User> users){
        Collections.sort(users, Collections.reverseOrder());


        for (int i = 0; i < users.size() && i < 10 ; i++) {
            User user = users.get(i);
            System.out.println(user.getAge() + " " + user.getFname());
        }

    }

    //Question 8
    public static void printUserStateStats(ArrayList<User> users){
        HashMap<String, Integer> result = new HashMap<>();

        for (User user: users) {
            if(result.containsKey(user.getState())){  //check if the state is in the map ?
                result.put(user.getState(), result.get(user.getState()) + 1);
            } else {
                result.put(user.getState(), 1);
            }
        }

        for (String key: result.keySet()) {
            System.out.println(key + ": " + result.get(key));
        }
    }


    //Question 9
    public static Set<String> getWordOverlap(String[] listA, String[] listB){
        HashSet<String> result = new HashSet<>();

        HashSet<String> tempSet = new HashSet<>();

        for (String word: listA) {
            tempSet.add(word);
        }

        for (String word: listB) {
            if(tempSet.contains(word)){
                result.add(word);
            }
        }
        return result;
    }

    //Question 10
    public static ArrayList<User> getUserOverlap(ArrayList<User> usersA, ArrayList<User> usersB){
        HashSet<User> result = new HashSet<>();
        HashSet<User> tempSet = new HashSet<>();

        for (User user: usersA) {
            tempSet.add(user);
        }

        for (User user: usersB) {
            if(tempSet.contains(user)){
                result.add(user);
            }
        }

        return new ArrayList<>(result);
    }


}
