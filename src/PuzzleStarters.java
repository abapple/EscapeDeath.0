import java.awt.im.InputContext;
import java.io.*;
import java.util.*; 

public class PuzzleStarters {
    public static HashMap<String, HashMap<Integer, String>> hints = new HashMap<>();

    // <Room, <HintNum, HintText>>
    // hint(puzzleName, hintNumber)
    public static int giveHint(String Room, int hintCnt) {
        switch (hintCnt) {
        case 3: {
            // first hint
            System.out.println(hints.get(Room).get(3));
            break;
        }
        case 2: {
            // second hint
            System.out.println(hints.get(Room).get(2));
            break;
        }
        case 1: {
            // third hint
            System.out.println(hints.get(Room).get(1));
            break;
        }
        default: {
            // out of hints
            System.out.println("You alone");
            break;
        }
        }
        hintCnt -= 1;
        return hintCnt;

    }

    public static void readInHints() {
        Scanner hn = null;
        try {
            hn = new Scanner(new File("src/hints.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while (hn.hasNext()) {
            String input = hn.nextLine();
            // skip empty lines
            if (input.equals("")) {
                input = hn.nextLine();
            }
            String room = input;
            // initialize new key (the name and species of the character)
            hints.put(room, new HashMap<>());
            // for next 6 lines, add each skill and level pair to
            // character's hashmap
            for (int i = 0; i < 3; i++) {
                int num = Integer.parseInt(hn.nextLine());
                String hint = hn.nextLine();
                hints.get(room).put(num, hint);
            }

        }
        hn.close();

    }

    public static void main(String[] args) {
        // fluffy introductions
        readInHints();
        System.out.println("Lets Begin!!");
        Scanner sc = new Scanner(System.in);
        int hintCnt = 3;
        System.out.println(hints);
        /*
         * Recursion Room // generate random number 1-20 // check if number = 10. if so,
         * +5 or -5
         */
        System.out.println("Find your way out!!");
        int number = 1 + (int) (Math.random() * ((20 - 1) + 1));
        if (number == 10)
            number = 15;
        recRoom(number, hintCnt);

       

    }

    public static void library_morse(){

    }
    public static void library_books(int hintCnt){
        //THE KEY TO GET HERE IS MYSTERY 
        Scanner sc = new Scanner(System.in);
        boolean trapped = true;
        // recursion room implementing queue and while loop boolean trapped = true;
        Queue<Character> directions = new LinkedList();
        char[] map = { 'L', 'R', 'L', 'L', 'R', 'R' };

        HashMap<String, String> books = new HashMap();
        books.put("Agatha Christie", "The Murder on the Orient Express");
        books.put("", "The Murder on the Orient Express");
        books.put("Agatha Christie", "The Murder on the Orient Express");
        books.put("Agatha Christie", "The Murder on the Orient Express");
        books.put("Agatha Christie", "The Murder on the Orient Express");
        books.put("Agatha Christie", "The Murder on the Orient Express");

        String code = "Escape";
        //authors names author.charAt(0) add to String completeCOde
        //compare that string to code above

        String in = sc.nextLine();







        System.out.println("Find your way out!!");
        while (trapped) {
            // fun hallway statement
            System.out.println("Press L for left or R for right"); // input L or R for
            // direction // later implementation in application, use a L button or a button
            String input = sc.nextLine();

            char dir = input.charAt(0);
            if (dir == 'l' || dir == 'L') {
                directions.offer('L');

            } else if (dir == 'r' || dir == 'R') {
                directions.offer('R');

            } else if (input.equalsIgnoreCase("hint")) {
                hintCnt = giveHint("Recursion", hintCnt);
                System.out.println("Are you dumb?");
            } else {
                System.out.println("Not an option my friend");
            }
            if (directions.size() == map.length) {
                for (int i = 0; i < map.length; i++) {
                    if (directions.peek() == map[i]) {
                        directions.poll();
                        if (directions.isEmpty()) {
                            trapped = false;
                        }
                    } else {
                        System.out.println("You took a wrong turn!! Go back!"); // start a tbeginning
                        directions.clear();
                        trapped = true;
                        break; // put back at beginning
                    }
                }
            }
        }
        System.out.println("You win"); // end of recursion room
        sc.close();
    }

    public static void recRoom(int turns, int hintCnt) {
        // door will be turns num; doors are "locked" until
        // finding door #10
        System.out.println(turns);
        if (turns == 10) {
            System.out.println("You made it!");
            // return;
        } else {
            if (turns >= 7 && turns <= 13) {
                tauntPlayer(true);
            } else if (turns <= 0 || turns >= 20) {
                tauntPlayer(false);
            }
            Scanner in = new Scanner(System.in);
            System.out.println("Press L for left or R for right");
            String input = in.nextLine();
            char dir = input.charAt(0);
            if (dir == 'l' || dir == 'L') {
                recRoom(turns - 1, hintCnt);
            } else if (dir == 'r' || dir == 'R') {
                recRoom(turns + 1, hintCnt);
            } else if (input.equalsIgnoreCase("hint")) {
                hintCnt = giveHint("Recursion", hintCnt);
                System.out.println("Are you dumb?");
                recRoom(turns, hintCnt);
            } else {
                System.out.println("Not an option my friend");
                recRoom(turns, hintCnt);
            }
            in.close();
        }
    }

    public static void tauntPlayer(boolean close) {
        ArrayList<String> enCourage = new ArrayList<>();
        ArrayList<String> disCourage = new ArrayList<>();

        Scanner tnt = null;
        try {
            tnt = new Scanner(new File("src/taunts.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            enCourage.add(tnt.nextLine());
        }
        for (int i = 0; i < 5; i++) {
            disCourage.add(tnt.nextLine());
        }
        if (close) {
            int number = 0 + (int) (Math.random() * ((4 - 0) + 1));
            System.out.println(enCourage.get(number));
        } else {
            int number = 0 + (int) (Math.random() * ((4 - 0) + 1));
            System.out.println(disCourage.get(number));
        }
        tnt.close();
    }

}
