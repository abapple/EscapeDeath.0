// import java.awt.im.InputContext;
import java.io.*;
import java.util.*;
import javax.sound.sampled.*;
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
        hn.close();
    }

    static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // fluffy introductions
        readInHints();
        System.out.println(
                "As you are walking home one evening," + "\nyou decide to take a short cut through the woods."
                        + "\nHowever, the farther you enter the more it seems unfamiliar to you."
                        + "\nSuddenly, you hear a second set of footsteps from behind you. Then a third."
                        + "\nFear fuels you as you begin to run deeper into the unknown."
                        + "\nBut alas - you trip on an invisible branch and tumble to the ground."
                        + "\nPain fills your mind as darkness clouds your vision,"
                        + "\nand as your consiousness fades all that you recall is weird laughter...");

        System.out.println("" + " -----------------------------------------------------------------------------------"
                + "\n -----------------------------------------------------------------------------------"
                + "\nWhen your eyes open back up, you see two figures looking down at you."
                + "\nYou look see through them and see a sprawling, definitely haunted mansion named "
                + "\n'The Midnight Manor'"
                + "\nWait, see through them?! 'What? Never seen a ghost before,' the one on the right smirked."
                + "\nThe one on the left continued,'Well, guess you can say you've met two now."
                + "\nAnyway, we're bored so you're gonna play these games at our house "
                + "\nor else you'll die or whatever.'"
                + "\nStill in disbelief, you try to back away "
                + "\nbut they grab both your arms and drag you to the entrance. "
                + "\n'Find your way out!' They gleefully say in chorus as they push you through the door,"
                + "\n'Or stay here and become a ghost, lol. Have fun :)'"
                + "\nThe door shuts behind you and disappears."
                + "\nYou find yourself in a hallway that seems to stretch endlessly in both directions.");
        int hintCnt = 3;
        int number = 1 + (int) (Math.random() * ((20 - 1) + 1));
        if (number == 10) {
            number = 15;
        }
        recRoom(number, hintCnt);
        library_morse(hintCnt);
        library_books(hintCnt);
        gameRoom(hintCnt);
    }

    public static void gameRoom(int hintCnt) {
        // buttons on which game to play
        int coins = 0;
        while (true) {
            System.out.println("In this room, you have multiple games to play!"
                    + "\nTo play each game, enter corresponding input: " + "\nCup Game : CG" + "\nBlack Jack : BJ"
                    + "\nMystery Game : ???" + "\nSlot Machine : SM"
                    + "\nAs always, if you need a hint, just type in 'hint'");
            String userInput = "";
            userInput = scan.nextLine();
            if (userInput.equalsIgnoreCase("CG")) {
                coins = cupGame(coins);
            } else if (userInput.equalsIgnoreCase("BJ")) {
                coins = blackJack(coins);
            } else if (userInput.equalsIgnoreCase("???")) {
                coins = mysteryGame(hintCnt, coins);
            } else if (userInput.equalsIgnoreCase("hint")) {
                hintCnt = giveHint("Casino", hintCnt);
                System.out.println("Are you dumb?");
            } else if (userInput.equalsIgnoreCase("SM")) {
                if (coins == 3) {
                    slotMachine(hintCnt, coins);
                } else {
                    System.out.println("You can't afford to play this yet.");
                }
            }
        }
    }

    public static int cupGame(int coins) {
        System.out.println("There are 4 silver chalices upside down on a table before you."
                + "\nA mysterious spirit whispers to you that a small, golden ball lies under one of them."
                + "\nIf you guess correctly you may earn a shiny token."
                + "\nChoose a number 1 - 4 to get started.");
        // ArrayList<Integer> chalices = new ArrayList<Integer>();
        // for (int m = 0; m < 4; m++) {
        // chalices.add(m + 1);
        // }
        boolean won = false;
        while (!won) {
            int smallBall = 1 + (int) (Math.random() * ((4 - 1) + 1));
            int guess = scan.nextInt();
            if (guess == smallBall) {
                System.out.println("The ball is here! You found it :) Here is your reward.");
                File coinByte = new File("src/coin.wav");
                play(3, coinByte);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return coins + 1;
            } else {
                System.out.println(
                        "The ball was not there." + "\nThe cups proceed to switch around unaided by any human means,"
                                + "\nand you now must try again.");
            }
        }
        return coins;
    }

    public static int dealCard(Stack<String> pHand, Stack<String> hand) {
        String newCard = "";
        int card;
        int suit;
        int value = 0;
        String[] suits = { "Spades", "Hearts", "Clubs", "Diamonds" };
        String[] faces = { "King", "Queen", "Jack" };
        boolean falseCard = true;
        card = 1 + (int) (Math.random() * ((13 - 1) + 1));
        suit = 1 + (int) (Math.random() * ((3 - 1) + 1));
        while (falseCard) {
            card = 1 + (int) (Math.random() * ((13 - 1) + 1));
            suit = 1 + (int) (Math.random() * ((3 - 1) + 1));
            if (1 < card && card < 10) {
                newCard = "" + card + " of " + suits[suit];
                if (!hand.contains(newCard)) {
                    hand.push(newCard);
                    pHand.push(newCard);
                    value = card;
                    break;
                }
                // normal cards
            } else if (card > 10) {
                int face = 1 + (int) (Math.random() * ((2 - 1) + 1));
                newCard = "" + faces[face] + " of " + suits[suit];
                if (!hand.contains(newCard)) {
                    hand.push(newCard);
                    pHand.push(newCard);
                    value = 10;
                    break;
                }
                // face cards j-k
            } else {
                newCard = "Ace" + " of " + suits[suit];
                if (!hand.contains(newCard)) {
                    hand.push(newCard);
                    pHand.push(newCard);
                    value = 0;
                    break;
                } else {
                    falseCard = true;
                }
                // ace
            }
        }
        return value;
    }

    public static int blackJack(int coins) {
        int pTotal = 0;
        int dTotal = 0;
        Stack<String> Uhand = new Stack<>();
        // Stack<String> Uhand2 = new Stack<>();
        Stack<String> Dhand = new Stack<>();
        Stack<String> comboHand = new Stack<>();
        // String newCard;
        System.out.println("The cards flit about in the air and the hands are dealt out.");
        for (int i = 0; i < 2; i++) {
            pTotal += dealCard(Uhand, comboHand);
            dTotal += dealCard(Dhand, comboHand);
        }
        // users turn
        System.out.println("The dealer has " + Dhand.peek() + " facing up.");
        while (true) {
            System.out.println("You have : " + Uhand.toString());
            System.out.println(
                    "Enter what you would like to do... " + "\nHit : H" + "\nStay : P" /** + "\n Split : S" */
            );
            String in = scan.nextLine();
            if (in.equalsIgnoreCase("H")) {
                pTotal += dealCard(Uhand, comboHand);
                System.out.println("You recieved a(n) " + Uhand.peek());
                // pTotal += countTotal(Uhand);
                if (pTotal > 21) {
                    System.out.println("You busted!!");
                    pTotal = -1;
                    break;
                }
            } else if (in.equalsIgnoreCase("P")) {
                System.out.println("You passed your turn.");
                break;
            } else
                System.out.println("Invalid input");
            // else if (in.equalsIgnoreCase("S") && Uhand.size() == 2) {
            // String c1 = Uhand.pop();
            // String c2 = Uhand.pop();
            // String[] card1 = c1.split(" ");
            // String[] card2 = c2.split(" ");
            // if (card1[1].equals(card2[1])) {
            // Uhand.push(c1);
            // // Uhand2.push(c2);
            // }
            // }
        }
        boolean dealer = true;
        while (dealer) {
            System.out.println("The dealer has " + Dhand.toString());
            if (pTotal == -1 || (dTotal > pTotal && dTotal <= 21)) {
                System.out.println("You lose.");
                dealer = false;
            } else if (dTotal < pTotal) {
                System.out.println("He hits.");
                dTotal += dealCard(Dhand, comboHand);
            } else if (dTotal > 21) {
                System.out.println("The dealer busted!!");
                if (pTotal <= 21) {
                    System.out.println("You win! Heres a coin.");
                    coins += 1;
                    File coinByte = new File("src/coin.wav");
                    play(3, coinByte);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    return coins;
                } else
                    System.out.println("You lose.");

                dealer = false;
            }
        }
        Uhand.clear();
        Dhand.clear();
        while (true) {
            System.out.println("Would you like to try again? Y/N ");
            String in = scan.nextLine();
            if (in.equalsIgnoreCase("n")) {
                System.out.println("Thank you for playing");
                break;

            } else if (in.equalsIgnoreCase("y")) {
                System.out.println("Lets play again!");
                coins += blackJack(coins);
                break;
            } else {
                System.out.println("Invalid input");
            }
        }
        return coins;
    }

    public static int mysteryGame(int hintCnt, int coins) {
        // the answer will have to be related to the theme
        return 0;
    }

    public static void slotMachine(int hintCnt, int coins) {
    }

    public static void library_morse(int hintCnt) {
        System.out.println("You see a dusty record player on a table in the middle of the room. "
                + "\nAs you approach, it begins to play an odd series of beeps and blips...\n");
        File morseByte = new File("src/morse.wav");
        play(5, morseByte);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("A paper peeks from beneath the record player. \nYou pull it out to reveal "
                + "the international morse code alphabet");
        System.out.println(" A = .-    B = -..." + "\n C = -.-.  D = -.." + "\n E = .     F = ..-."
                + "\n G = --.   H = ...." + "\n I = ..    J = .---" + "\n K = -.-   L = .-.." + "\n M = --    N = -."
                + "\n O = ---   P = .--." + "\n Q = --.-  R = .-." + "\n S = ...   T = -" + "\n U = ..-   V = ...-"
                + "\n W = .--   X = -..-" + "\n Y = -.--  Z = --..");
        String answer = "Mystery";
        while (true) {
            System.out.println("Translate the morse code and enter your guess.");
            System.out.println("If you would like to play the sound again, press P"
                    + "\nIf you need a hint, just type in 'hint'");
            String input = scan.nextLine();
            if (input.equalsIgnoreCase("p")) {
                play(1, morseByte);
            } else if (input.equalsIgnoreCase("hint")) {
                hintCnt = giveHint("Morse", hintCnt);
                System.out.println("Are you dumb?");

            } else if (input.equalsIgnoreCase("Mystery")) {
                System.out.println("What a mystery indeed - Good Job.");
                break;
            } else {
                System.out.println("Try again. Listen closely.");
            }
        }
    }

    public static void play(int delay, File f) {
        try {
            Thread.sleep(delay * 1000);
            File yourFile = new File("src/morse.wav");
            AudioInputStream stream;
            AudioFormat format;
            DataLine.Info info;
            Clip clip;
            stream = AudioSystem.getAudioInputStream(f);
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
            // Thread.sleep(1000);
        } catch (Exception e) {
            // whatevers
        }
    }

    public static void printOptions(String[] shelf, Queue<Character> pile) {
        System.out.println("Choose a book.");
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
        boolean trapped = true;
        // book puzzle implementing queue and while loop boolean trapped = true;
        Queue<Character> pileOfBooks = new LinkedList();
        char[] sctMsg = { 'E', 'S', 'C', 'A', 'P', 'e' };
        String[] bookList = { "The Name of this Book is Secret - Pseudonymous Bosch (NBS) P",
                "The Hound of the Baskervilles - Sir Arthur Conan Doyle (HB) S",
                "The Great Mouse Detective: Basil of Baker Street - Eve Titus (GMD) E",
                "The Murder on the Orient Express - Agatha Christie (MOE) A",
                "The Girl Who Lived - Christopher Greyson (GWL) C", "The Westing Game - Ellen Raskin (WG) e" };
        System.out.println("\nYou take a look around, and in the mystery section of the library"
                + "\nyou find a bookshelf that has several novels piled upon it haphazardly."
                + "\nThe titles and authors are barely legible on most of them,"
                + "\nbut you notice 6 books that are bound in leather with prominent gold lettering on their bindings."
                + "\nYou clear the other books away to reveal subtle indentations on the shelf - six of them."
                + "\nYou take a closer look at the ornately decorated books - they read as follows: ");
        System.out.println(" " + "-----------------------------------------------------------------------------------"
                + "\n -----------------------------------------------------------------------------------");
        for (int i = 0; i < bookList.length; i++) {
            System.out.println(bookList[i].substring(0, bookList[i].length() - 1));
        }
        System.out.println(" " + "-----------------------------------------------------------------------------------"
                + "\n -----------------------------------------------------------------------------------"
                + "\nInput the book's code (the letters in parentheses) to place it on the shelf."
                + "\nAnd if you need a hint, just type in 'hint'\n");
        // ArrayList<String> shelf = new ArrayList<>();
        // for(int i = 0; i <bookList.length; i++){
        // shelf.add(bookList[i]);
        // }
        String[] shelf = { "The Name of this Book is Secret - Pseudonymous Bosch (NBS) P",
                "The Hound of the Baskervilles - Sir Arthur Conan Doyle (HB) S",
                "The Great Mouse Detective: Basil of Baker Street - Eve Titus (GMD) E",
                "The Murder on the Orient Express - Agatha Christie (MOE) A",
                "The Girl Who Lived - Christopher Greyson (GWL) C", "The Westing Game - Ellen Raskin (WG) e" };
        while (trapped) {
            // Input the book's code in parentheses to place it in the queue
            // Later implementation in application, use mouse to drag
            printOptions(shelf, pileOfBooks);
            String input = scan.nextLine();
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
                        for (int c = 0; c < bookList.length; c++) {
                            shelf[c] = bookList[c];
                        }
                        trapped = true;
                        break; // put back at beginning
                    }
                }
            }
        }
        System.out.println(
                "You line the books correctly on the shelf to reveal a secret message, but maybe it is more literal than you think..."
                        + "\nThe bookshelf slides open to reveal a grand entertainment room full of games.");
        File doorOpenByte = new File("src/door_open.wav");
        play(3, doorOpenByte);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void recRoom(int turns, int hintCnt) {
        // door will be turns num; doors are "locked" until
        // finding door #10
        System.out.println(turns);
        if (turns == 10) {
            System.out.println("An oddly large doorway sized painting looms in front of you now."
                    + "\nYou move it aside to reveal an opening into a private library.");
            File doorOpenByte = new File("src/door_open.wav");
            play(3, doorOpenByte);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // return;
        } else {
            if (turns >= 7 && turns <= 13) {
                tauntPlayer(true);
            } else if (turns <= 0 || turns >= 20) {
                tauntPlayer(false);
            }
            System.out.println("Press L for left or R for right, and if you need a hint, just type in 'hint'");
            String input = scan.nextLine();
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