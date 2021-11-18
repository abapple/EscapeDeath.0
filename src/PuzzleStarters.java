
// import java.awt.im.InputContext;
import java.io.*;
import java.util.*;
import javax.sound.sampled.*;
import javax.crypto.NullCipher;
import javax.management.monitor.MonitorSettingException;
import javax.sound.sampled.AudioInputStream;

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
        // hn.close();

    }

    public static void main(String[] args) {
        // fluffy introductions
        readInHints();
        System.out.println("Lets Begin!!");
        // Scanner sc = new Scanner(System.in);
        int hintCnt = 3;

        System.out.println("Find your way out!!");
        int number = 1 + (int) (Math.random() * ((20 - 1) + 1));
        if (number == 10)
            number = 15;
        
        recRoom(number, hintCnt);
        library_morse(hintCnt);
        library_books(hintCnt);

    }

    public static void library_morse(int hintCnt) {
        System.out.println("You see a dusty record player on a table in the middle of the library. "+
        "\n As you approach, it begins to play an odd series of beeps and blips...\n");
        play(5);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("A paper peeks from beneath the record player. \n You pull it out to reveal " + 
        "the international morse code alphabet");
        Scanner sc = new Scanner(System.in);
        String answer = "Mystery";
        while (true) { 
            System.out.println("Translate the morse code and enter your guess");
            System.out.println("If you would like to play the sound again, press P");
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("p")){
                play(1);
            }else if(input.equalsIgnoreCase("hint")){
                hintCnt = giveHint("Morse", hintCnt);
                System.out.println("Are you dumb?");
    
            }else if(input.equalsIgnoreCase("Mystery")){
                System.out.println("Good job");
                break;
            }else {
                System.out.println("Try again. Listen closely");
            }
            
        }
       
       
    }

    public static void play(int delay){
        try{
            Thread.sleep(delay * 1000);

            File yourFile = new File("src/morse.wav");
            AudioInputStream stream;
            AudioFormat format;
            DataLine.Info info;
            Clip clip;
        
            stream = AudioSystem.getAudioInputStream(yourFile);
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
            // Thread.sleep(1000);

            
            
        }
        catch (Exception e) {
            //whatevers
        }

    }


    public static void printOptions(String[] shelf, Queue<Character> pile) {
        System.out.println("Choose another book.");
        for (char b : pile) {
            for (int i = 0; i < shelf.length; i++) {
                if (shelf[i] != null && b == shelf[i].charAt(shelf[i].length() - 1)) {
                    shelf[i] = null;
                }
            }

        }
        for (int i = 0; i < shelf.length; i++) {
            if (shelf[i] != null) {
                System.out.println(shelf[i].substring(0, shelf[i].length() - 1));

            }

        }
    }

    public static void library_books(int hintCnt) {
        // THE KEY TO GET HERE IS MYSTERY
        Scanner sc1 = new Scanner(System.in);
        boolean trapped = true;
        // book puzzle implementing queue and while loop boolean trapped = true;
        Queue<Character> pileOfBooks = new LinkedList();
        char[] sctMsg = { 'E', 'S', 'C', 'A', 'P', 'e' };

        String[] bookList = { "The Name of this Book is Secret - Pseudonymous Bosch (NBS) P",
                "The Hound of the Baskervilles - Sir Arthur Conan Doyle (HB) S",
                "The Great Mouse Detective: Basil of Baker Street - Eve Titus (GMD) E",
                "The Murder on the Orient Express - Agatha Christie (MOE) A",
                "The Girl Who Lived - Christopher Greyson (GWL) C", "The Westing Game - Ellen Raskin (WG) e" };

        System.out.println("\n In the mystery section of the library,"
                + "\n you find a bookshelf that has several novels piled upon it haphazardly."
                + "\n The titles and authors are barely legible on most of them,"
                + "\n but you notice 6 books that are bound in leather with prominent gold lettering on their bindings."
                + "\n You clear the other books away to reveal subtle indentations on the shelf - six of them."
                + "\n You take a closer look at the ornately decorated books - they read as follows: ");

        System.out.println(" " + "-----------------------------------------------------------------------------------"
                + "\n -----------------------------------------------------------------------------------");
        for (int i = 0; i < bookList.length; i++) {
            System.out.println(bookList[i].substring(0, bookList[i].length() - 1));
        }
        System.out.println(" " + "-----------------------------------------------------------------------------------"
                + "\n -----------------------------------------------------------------------------------"
                + "\n Input the book's code (the letters in parentheses) to place it on the shelf.\n");

        String[] shelf = { "The Name of this Book is Secret - Pseudonymous Bosch (NBS) P",
                "The Hound of the Baskervilles - Sir Arthur Conan Doyle (HB) S",
                "The Great Mouse Detective: Basil of Baker Street - Eve Titus (GMD) E",
                "The Murder on the Orient Express - Agatha Christie (MOE) A",
                "The Girl Who Lived - Christopher Greyson (GWL) C", "The Westing Game - Ellen Raskin (WG) e" };

        while (trapped) {
            // Input the book's code in parentheses to place it in the queue
            // Later implementation in application, use mouse to drag
            printOptions(shelf, pileOfBooks);

            String input = sc1.nextLine();
            // p == NBS;
            if (input.equalsIgnoreCase("NBS")) {
                if (!pileOfBooks.contains('P')) {
                    pileOfBooks.offer('P');
                }

            } else if (input.equalsIgnoreCase("HB")) {
                if (!pileOfBooks.contains('S')) {
                    pileOfBooks.offer('S');
                }

            } else if (input.equalsIgnoreCase("GMD")) {
                if (!pileOfBooks.contains('E')) {
                    pileOfBooks.offer('E');
                }

            } else if (input.equalsIgnoreCase("MOE")) {
                if (!pileOfBooks.contains('A')) {
                    pileOfBooks.offer('A');
                }

            } else if (input.equalsIgnoreCase("GWL")) {
                if (!pileOfBooks.contains('C')) {
                    pileOfBooks.offer('C');
                }

            } else if (input.equalsIgnoreCase("WG")) {
                if (!pileOfBooks.contains('e')) {
                    pileOfBooks.offer('e');
                }

            } else if (input.equalsIgnoreCase("hint")) {
                hintCnt = giveHint("Books", hintCnt);
                System.out.println("Are you dumb?");

            } else {
                System.out.println("We don't have that book.");
            }
            // checking if all books are on shelf
            if (pileOfBooks.size() == sctMsg.length) {
                for (int i = 0; i < sctMsg.length; i++) {
                    if (pileOfBooks.peek() == sctMsg[i]) {
                        pileOfBooks.poll();
                        if (pileOfBooks.isEmpty()) {
                            trapped = false;
                        }
                    } else {
                        System.out.println("Wrong order! Try Again."); // start at beginning
                        pileOfBooks.clear();
                        shelf = bookList;
                        trapped = true;
                        break; // put back at beginning
                    }
                }
            }

        }
        System.out.println(
                "You line the books correctly on the shelf to reveal a secret message, but maybe it is more literal than you think...");

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
            // in.close();
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
