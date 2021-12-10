import java.io.*;
import java.util.*;
import javax.sound.sampled.*;
import javax.sound.sampled.AudioInputStream;

public class PuzzleStarters {
    public static HashMap<String, HashMap<Integer, String>> hints = new HashMap<>();
    public static final Scanner scan = new Scanner(System.in);

    /**
     * footSteps() is a simple play method
     * used to play a set of files. There are no
     * needed parameters or return values.
     */
    public static void footSteps() {
        File stepByte1 = null;
        File stepByte2 = null;
        File stepByte3 = null;
        File stepByte4 = null;
        for (int f = 0; f < 1; f++) {
            stepByte1 = new File("Game_Sounds/Corsica_S-Walking_on_snow_covered_gravel_02.wav");
            play(0, stepByte1);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stepByte2 = new File("Game_Sounds/Corsica_S-Walking_on_snow_covered_gravel_08.wav");
            play(1, stepByte2);
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stepByte3 = new File("Game_Sounds/Corsica_S-Walking_on_snow_covered_gravel_10.wav");
            play(2, stepByte3);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stepByte4 = new File("Game_Sounds/Corsica_S-Walking_on_snow_covered_gravel_12.wav");
            play(0, stepByte4);
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * readInHints() is the simple method that
     * scans from file hint.txt to load all hints
     * into the hints HashMap.
     */
    public static void readInHints() {
        Scanner hn = null;
        try {
            hn = new Scanner(new File("src/hints.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // while file has next line, read and load hints into hashmap
        while (hn.hasNext()) {
            String input = hn.nextLine();
            // skip empty lines
            if (input.equals("")) {
                input = hn.nextLine();
            }
            String room = input;
            // initialize new key (the room)
            hints.put(room, new HashMap<>());
            // for next 4 lines, add hint number and the hint to hashmap
            for (int i = 0; i <= 3; i++) {
                int num = Integer.parseInt(hn.nextLine());
                String hint = hn.nextLine();
                hints.get(room).put(num, hint);
            }
        }
        hn.close();
    }

    /**
     * play() is the basic play method for sound files.
     * It recieves the chosen sound file and custom delay,
     * simply playing the audio.
     * 
     * @param delay - desired delay time
     * @param f     - the desired sound file
     */
    public static void play(int delay, File f) {
        try {
            Thread.sleep(delay * 1000);
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
        } catch (Exception e) {
        }
    }

    /**
     * Custom play method for longer sound files
     * that may need to be shortened or modified more
     * than a simply sound byte would need.
     * 
     * @param delay
     * @param f
     * @param p
     * @param d2
     */
    public static void playLongAssSound(int delay, File f, char p, int d2) {
        try {
            Thread.sleep(delay * 1000);
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
            if (p == 'P') {
                Thread.sleep(d2);
                long currentFrame = 0L;
                clip.stop();
                clip.close();
            }
        } catch (Exception e) {
        }
    }

    /**
     * main method
     * 
     * @param args
     */
    public static void main(String[] args) {
        readInHints();
        System.out.println("As you are walking home one evening,"
                + "\nyou decide to take a short cut through the woods."
                + "\nHowever, the farther you enter the more it seems unfamiliar to you."
                + "\nSuddenly, you hear a second set of footsteps from behind you. Then a third."
                + "\nFear fuels you as you begin to run deeper into the unknown."
                + "\nBut alas - you trip on an invisible branch and tumble to the ground."
                + "\nPain fills your mind as darkness clouds your vision,"
                + "\nand as your consiousness fades all that you recall is weird laughter...");
        //play the intro sounds
        final File atmosByte = new File("Game_Sounds/Outdoor_Ambiance.wav");
        playLongAssSound(0, atmosByte, 'P', 10000);
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        footSteps();
        final File laughByte = new File("Game_Sounds/zapsplat_horror_evil_demonic_laugh_001_12149.wav");
        play(15, laughByte);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("" + "-----------------------------------------------------------------------------------"
                + "\n-----------------------------------------------------------------------------------"
                + "\nWhen your eyes open back up, you see two figures looking down at you."
                + "\nYou look through them and see a sprawling, definitely haunted mansion named "
                + "\n'The Midnight Manor'"
                + "\nWait, see through them?! 'What? Never seen a ghost before,' the one on the right smirked."
                + "\nThe one on the left continued,'Well, guess you can say you've met two now."
                + "\nAnyway, we're bored so you're gonna play these games at our house "
                + "\nor else you'll die or whatever.'"
                + "\nStill in disbelief, you try to back away "
                + "\nbut they grab both your arms and drag you to the entrance. "
                + "\n'Find your way out!' They gleefully say in chorus as they push you through the door,"
                + "\n'Or stay here and become a ghost, lol. Have fun :)'"
                + "\n\nThe door shuts behind you and disappears."
                + "\nYou find yourself in a hallway that seems to stretch endlessly in both directions.");
        final File doorShutByte = new File("Game_Sounds/skyes_audio_Door_Abandoned_House_Old_Large_Gate_Metal_Lock_Slam_002.wav");
        playLongAssSound(35, doorShutByte, 'P', 4000);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int hintCnt = 3;
        //random number for first game. number cannot equal 10
        int number = 1 + (int) (Math.random() * ((20 - 1) + 1));
        if (number == 10) {
            number = 15;
        }
        while (true) {
            recRoom(number, hintCnt);
            library_morse(hintCnt);
            library_books(hintCnt);
            gameRoom(hintCnt);
        }
    }

    /**
     * This is the first room. It's a recursive method
     * to which only returns when the user reaches turn value 10.
     * Instead of constantly decreasing, the user controls how long
     * they recursively call this method by their left (l) or right (r)
     * inputs.
     * 
     * @param turns   - the current value for the base case
     * @param hintCnt - the left over hints for the room.
     */
    public static void recRoom(int turns, int hintCnt) {
        System.out.println(turns + " is displayed on the door in front of you...");
        if (turns == 10) {
            // base case reached and allowed to exit
            System.out.println("An oddly large doorway sized painting looms in front of you now."
                    + "\nYou move it aside to reveal an opening into a private library.");
            // plays door sound effect
            File doorOpenByte = new File("Game_Sounds/door_open.wav");
            play(3, doorOpenByte);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            // if the user is close to base case, encourage them
            // else, taunt/discourage them.
            if (turns >= 7 && turns <= 13) {
                tauntPlayer(true);
            } else if (turns <= 0 || turns >= 20) {
                tauntPlayer(false);
            }
            System.out.println("Press L for left or R for right, and if you need a hint, just type in 'hint'");
            String input = " ";
            // check for readable input
            try {
                input = scan.next();
            } catch (Exception e) {
                System.out.println("Not an option");
            }
            // if they choose left, recall and decrease turns
            // else if right, recall and increase turns
            char dir = input.charAt(0);
            if (dir == 'l' || dir == 'L') {
                recRoom(turns - 1, hintCnt);
            } else if (dir == 'r' || dir == 'R') {
                recRoom(turns + 1, hintCnt);
            } else if (input.equalsIgnoreCase("hint")) {
                System.out.println(hints.get("Recursion").get(hintCnt));
                if (hintCnt != 0)
                    hintCnt--;
                recRoom(turns, hintCnt);
            } else {
                System.out.println("Not an option my friend");
                recRoom(turns, hintCnt);
            }
        }
    }

    /**
     * Taunts are read in from two files and separated
     * between two ArrayLists. Then a taunt is randomized
     * and printed according to the user's distance from the
     * goal.
     * 
     * @param close - tells if the user is close to the goal. True = yes.
     */
    public static void tauntPlayer(boolean close) {
        ArrayList<String> enCourage = new ArrayList<>();
        ArrayList<String> disCourage = new ArrayList<>();
        Scanner tnt = null;
        try {
            tnt = new Scanner(new File("src/taunts.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // read first 5 lines to enCourage
        for (int i = 0; i < 5; i++) {
            enCourage.add(tnt.nextLine());
        }
        // read next 5 lines to disCourage
        for (int i = 0; i < 5; i++) {
            disCourage.add(tnt.nextLine());
        }
        // if they are close to goal, give them a random encouragement
        // else, give them a discouragement
        if (close) {
            int number = 0 + (int) (Math.random() * ((4 - 0) + 1));
            System.out.println(enCourage.get(number));
        } else {
            int number = 0 + (int) (Math.random() * ((4 - 0) + 1));
            System.out.println(disCourage.get(number));
        }
        tnt.close();
    }

    /**
     * This method contains the morse code puzzle in a library.
     * It plays a series of morse code audio files, then prints out a
     * code guide. When the user enters the correct code, they exit the method.
     * 
     * @param hintCnt - the amount of hints for the room
     */
    public static void library_morse(int hintCnt) {
        System.out.println("\nYou see a dusty record player on a table in the middle of the room. "
                + "\nAs you approach, it begins to play an odd series of beeps and blips...\n");
        // play the morse code audio files
        final File file = new File("Morse_Code");
        for (final File child : file.listFiles()) {
            play(2, child);
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("A paper peeks from beneath the record player. \nYou pull it out to reveal "
                + "the international morse code alphabet");
        System.out.println(" A = .-    B = -..." + "\n C = -.-.  D = -.." + "\n E = .     F = ..-."
                + "\n G = --.   H = ...." + "\n I = ..    J = .---" + "\n K = -.-   L = .-.." + "\n M = --    N = -."
                + "\n O = ---   P = .--." + "\n Q = --.-  R = .-." + "\n S = ...   T = -" + "\n U = ..-   V = ...-"
                + "\n W = .--   X = -..-" + "\n Y = -.--  Z = --..");
        // user guesses, plays audio, or asks for hint until answered correctly. then
        // break
        while (true) {
            System.out.println("Translate the morse code and enter your guess.");
            System.out.println("If you would like to play the sound again, press P"
                    + "\nIf you need a hint, just type in 'hint'");
            String input = " ";
            // check for readable input
            try {
                input = scan.next();
            } catch (Exception e) {
                System.out.println("Not an option");
            }
            if (input.equalsIgnoreCase("p")) {
                // play morse code audio files
                for (final File child : file.listFiles()) {
                    play(2, child);
                }
            } else if (input.equalsIgnoreCase("hint")) {
                // print specific hint from hashmap
                System.out.println(hints.get("Morse").get(hintCnt));
                // decrease amount of hints left until 0
                if (hintCnt != 0)
                    hintCnt--;
            } else if (input.equalsIgnoreCase("Mystery")) {
                System.out.println("What a mystery indeed - Good Job.");
                break;
            } else {
                System.out.println("Try again. Listen closely.");
            }
        }
    }

    /**
     * Compares the Characters in pile to the last character
     * of each shelf string to remove it.
     * Then all of the leftover shelf values are printed
     * for the user to observe.
     * 
     * @param shelf - the list of books
     * @param pile  - the coded books already chosen.
     */
    public static void printOptions(String[] shelf, Queue<Character> pile) {
        System.out.println("Choose a book.");
        // for each char in pile, it is compared to all strings in shelf
        for (char b : pile) {
            // goes through all strings in shelf
            for (int i = 0; i < shelf.length; i++) {
                // if the last char (the code value) in shelf string matches a value in pile
                // set the string index in shelf to null. ignore if already null
                if (shelf[i] != null && b == shelf[i].charAt(shelf[i].length() - 1)) {
                    shelf[i] = null;
                }
            }
        }
        // print out all remaining shelf strings
        for (int i = 0; i < shelf.length; i++) {
            if (shelf[i] != null) {
                System.out.println(shelf[i].substring(0, shelf[i].length() - 1));
            }
        }
    }

    /**
     * The library book puzzle that asks the user to
     * enter the books strings in the correct order.
     * This continues until the user enters the correct order,
     * then the method ends.
     * 
     * @param hintCnt - the amount of hints for the room
     */
    public static void library_books(int hintCnt) {
        // THE KEY TO GET HERE IS MYSTERY
        boolean trapped = true;
        // Book puzzle implementing queue and while loop boolean trapped = true;
        Queue<Character> pileOfBooks = new LinkedList<>();
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
        // repeat but new variable from bookList to prevent erasing book strings
        String[] shelf = { "The Name of this Book is Secret - Pseudonymous Bosch (NBS) P",
                "The Hound of the Baskervilles - Sir Arthur Conan Doyle (HB) S",
                "The Great Mouse Detective: Basil of Baker Street - Eve Titus (GMD) E",
                "The Murder on the Orient Express - Agatha Christie (MOE) A",
                "The Girl Who Lived - Christopher Greyson (GWL) C", "The Westing Game - Ellen Raskin (WG) e" };
        // allows user to continuously guess until entering correct order of books
        while (trapped) {
            // Input the book's code in parentheses to place it in the queue
            printOptions(shelf, pileOfBooks);
            String input = "";
            // check readable input
            try {
                input = scan.next();
            } catch (Exception e) {
                System.out.println("Not an option");
            }
            // when book code is entered, push corresponding char to pileOfBooks
            // no repeating letters.
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
                System.out.println(hints.get("Books").get(hintCnt));
                if (hintCnt != 0)
                    hintCnt--;
            } else if (input.equalsIgnoreCase("cheat")) {
                // cheat code for fast pass through section
                break;
            } else {
                System.out.println("We don't have that book.");
            }
            // Checking if all books are on shelf
            if (pileOfBooks.size() == sctMsg.length) {
                for (int i = 0; i < sctMsg.length; i++) {
                    // compare each book code in order with message
                    // if so, poll. when empty, all matched and user is free
                    if (pileOfBooks.peek() == sctMsg[i]) {
                        pileOfBooks.poll();
                        if (pileOfBooks.isEmpty()) {
                            trapped = false;
                        }
                    } else {
                        System.out.println("Wrong order! Try Again."); // Start at beginning
                        pileOfBooks.clear();
                        for (int c = 0; c < bookList.length; c++) {
                            shelf[c] = bookList[c];
                        }
                        trapped = true;
                        break; // Put back at beginning
                    }
                }
            }
        }
        System.out.println(
                "You line the books correctly on the shelf to reveal a secret message, but maybe it is more literal than you think..."
                        + "\nThe bookshelf slides open to reveal a grand entertainment room full of games.");
        File doorOpenByte = new File("Game_Sounds/door_open.wav");
        play(3, doorOpenByte);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Offers the user multiple options for games.
     * Will send user to corresponding requested game method.
     * When they have reached the winning probability value, it
     * breaks the loop and ends the method.
     * 
     * @param hintCnt - amount of hints for room
     */
    public static void gameRoom(int hintCnt) {
        // Buttons on which game to play
        int probability = 0;
        int coins = 0;
        // user will continously play minigames until probability limit reached
        while (true) {
            System.out.println("\nIn this room, you have multiple games to play!"
                    + "\nCurrently you have " + coins + " coin(s). "
                    + "\nTo play each game, enter corresponding input: " + "\nCup Game : CG" + "\nBlack Jack : BJ"
                    + "\nMystery Game : ???" + "\nSlot Machine : SM"
                    + "\nAs always, if you need a hint, just type in 'hint'");
            String userInput = "";
            // check readable input
            try {
                userInput = scan.next();
            } catch (Exception e) {
                System.out.println("Not an option");
            }
            // send user to requested game
            if (userInput.equalsIgnoreCase("CG")) {
                coins += cupGame();
            } else if (userInput.equalsIgnoreCase("BJ")) {
                coins += blackJack();
            } else if (userInput.equalsIgnoreCase("???")) {
                coins += mazeGame();
            } else if (userInput.equalsIgnoreCase("hint")) {
                System.out.println(hints.get("Casino").get(hintCnt));
                if (hintCnt != 0)
                    hintCnt--;
            } else if (userInput.equalsIgnoreCase("SM")) {
                // need min coins to play
                if (coins >= 3) {
                    coins = slotMachine(coins, probability);
                    // when probability >=4, guaranteed jackpot and win game
                    if (probability >= 4) {
                        break;
                    }
                    probability++;
                    // increase jackpot probability every time they play

                } else {
                    System.out.println("You can't afford to play this yet.");
                }
            } else {
                System.out.println("Not an option");

            }
        }
        // go onto next part of game.

    }

    /**
     * Randomized "cup game". Random number between 1
     * and 4 is generated. If the user guesses correctly,
     * they earn a coin and returned back to gameRoom().
     * 
     * @return earned coin amount
     */
    public static int cupGame() {
        int coins = 0;
        System.out.println("\nThere are 4 silver chalices upside down on a table before you."
                + "\nA mysterious spirit whispers to you that a small, golden ball lies under one of them."
                + "\nIf you guess correctly you may earn a shiny token."
                + "\n\nChoose a number 1 - 4 to get started.");
        boolean won = false;
        // continues in loop until user wins
        while (!won) {
            // play cup shuffle audio file 4 times
            File cupByte = new File("Game_Sounds/household_cups_mugs_x2_place_on_hard_surface_002.wav");
            for (int i = 0; i < 4; i++) {
                play(1, cupByte);
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // randomly generate number 1-4
            int smallBall = 1 + (int) (Math.random() * ((4 - 1) + 1));
            int guess = 0;
            // check for readable int
            try {
                guess = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Not an option");
            }
            if (guess == smallBall) {
                System.out.println("The ball is here! You found it :) Here is your reward.");
                // play coin sound
                File coinByte = new File("Game_Sounds/coin.wav");
                play(3, coinByte);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // return earned coin
                return coins = 1;
            } else {
                System.out.println(
                        "The ball was not there." + "\nThe cups proceed to switch around unaided by any human means,"
                                + "\nand you now must try again.");
            }
        }
        return coins;
    }

    /**
     * Generates a random card based on suit and face.
     * Also checks to see if the card has already been delt.
     * If it is, then endlessly loops until a new card is delt.
     * Then the new card is added to the individual hand and
     * combined hand of all players to keep record of all cards dealt
     * so far.
     * 
     * @param pHand - individual player's collection of cards
     * @param hand  - the record of all cards dealt out so far
     * @return the value of the card according to BlackJack game
     */
    public static int dealCard(Stack<String> pHand, Stack<String> hand) {
        String newCard = "";
        int card;
        int suit;
        int value = 0;
        String[] suits = { "Spades", "Hearts", "Clubs", "Diamonds" };
        String[] faces = { "King", "Queen", "Jack" };
        boolean falseCard = true;
        // randomly generate card number and suit
        card = 1 + (int) (Math.random() * ((13 - 1) + 1));
        suit = 1 + (int) (Math.random() * ((3 - 1) + 1));
        while (falseCard) {
            card = 1 + (int) (Math.random() * ((13 - 1) + 1));
            suit = 1 + (int) (Math.random() * ((3 - 1) + 1));

            if (1 < card && card < 10) {
                // Normal number cards. make card string
                newCard = "" + card + " of " + suits[suit];
                // check if card has been dealt yet
                if (!hand.contains(newCard)) {
                    // record card in dealt stack
                    // give card to player stack
                    hand.push(newCard);
                    pHand.push(newCard);
                    value = card;
                    break;
                }

            } else if (card > 10) {
                // face cards. randomly generate number for face cards
                int face = 1 + (int) (Math.random() * ((2 - 1) + 1));
                newCard = "" + faces[face] + " of " + suits[suit];
                if (!hand.contains(newCard)) {
                    hand.push(newCard);
                    pHand.push(newCard);
                    // all face cards = 10
                    value = 10;
                    break;
                }
            } else {
                // if card == 1, then it is an ace.
                newCard = "Ace" + " of " + suits[suit];
                if (!hand.contains(newCard)) {
                    hand.push(newCard);
                    pHand.push(newCard);
                    // value determined in AceCard()
                    value = 0;
                    break;
                } else {
                    falseCard = true;
                }
            }
        }
        return value;
    }

    /**
     * Determining the special cases for Ace Cards
     * being valued at 11 or 1.
     * Calculates the total possible values of only Ace
     * cards in the hand and adjusts the value depending
     * on the total from normal cards in the players hand to
     * best prevent passing 21.
     * 
     * @param total - the total from normal cards
     * @param hand  - the entire hand of the player
     * @return the possible total values of all combined Aces
     */
    public static int AceCard(int total, Stack<String> hand) {
        int value = 0;
        int acesTotal = 0;
        int cnt = 0;
        // count the amount of Aces in the hand
        for (String a : hand) {
            String card = a.substring(0, 3);
            if (card.equalsIgnoreCase("Ace")) {
                cnt++;
            }
        }
        // calculate aces values one at a time
        while (cnt > 0) {
            // reinitiate value for each new ace card
            value = 0;
            cnt--;
            if ((total + 11 + cnt) <= 21) {
                // if the total plus one ace at value 11
                // plus the additional aces valued at 1
                // is less than or equal to 21, then value that ace as 11
                value = 11;
                acesTotal += 11;
            } else {
                value = 1;
                acesTotal += 1;

            }
            total += value;
        }
        return acesTotal;
    }

    /**
     * Minigame of simplified BlackJack. User is given a set of cards
     * with identified values. They can hit to gain cards or stay
     * to pass their turn to the npc dealer. If the user exceeds 21
     * in card value, they lose. If not, dealer plays their hand until
     * they surpass user's card value or bust, in which the user wins.
     * If user reaches 21, they automatically win. After winning, they recieve
     * a coin, and if not they leave empty handed. Method ends.
     * 
     * @return the coin amount earned.
     */
    public static int blackJack() {
        int pTotal = 0;
        int dTotal = 0;
        int coins = 0;
        Stack<String> Uhand = new Stack<>();
        Stack<String> Dhand = new Stack<>();
        Stack<String> comboHand = new Stack<>();
        System.out.println("\nWelcome to Black Jack, a card game only involving math. "
                + "\n In this version, you and your \"Dealer\" receive 2 cards. "
                + "\n Each card holds a different number value. Face cards are 10, numbers equal their number value and..."
                + "\n Ace cards can be tricky. They are valued at 11 or 1 depending on how you play them."
                + "\n Your goal is to get as close to 21 as you can with your given cards, but don't get greedy..."
                + "\n Good luck gambling!");
        System.out.println("\nThe cards flit about in the air and the hands are dealt out.");
        // deal two cards to each player
        for (int i = 0; i < 2; i++) {
            pTotal += dealCard(Uhand, comboHand);
            dTotal += dealCard(Dhand, comboHand);
        }
        // play shuffle and deal sounds
        File shuffleByte = new File("Game_Sounds/cardShuffle.wav");
        File cFLipByte = new File("Game_Sounds/cardFan1.wav");
        play(3, cFLipByte);
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        play(3, shuffleByte);
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int pATotal = 0;
        int pValue = 0;
        System.out.println("The dealer has " + Dhand.peek() + " facing up.");
        // playing the users turn. continues until they bust or pass their turn
        while (true) {
            System.out.println("You have : " + Uhand.toString());
            // initialize totals in case of stay
            pATotal += AceCard(pTotal, Uhand);
            pValue = pATotal + pTotal;
            System.out.println(
                    "Enter what you would like to do... " + "\nHit : H" + "\nStay : P");
            String in = "";
            try {
                in = scan.next();
            } catch (Exception e) {
                System.out.println("Not an option");
            }
            if (in.equalsIgnoreCase("H")) {
                pATotal = 0;
                pTotal += dealCard(Uhand, comboHand);
                // play card sound
                File cardByte = new File("Game_Sounds/cardSlide4.wav");
                play(0, cardByte);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("You recieved the " + Uhand.peek());
                pATotal += AceCard(pTotal, Uhand);
                // total value of hand
                pValue = pATotal + pTotal;
                if (pValue > 21) {
                    System.out.println("You busted!!");
                    pValue = -1;
                    break;
                } else if (pValue == 21) {
                    System.out.println("You win! Heres a coin.");
                    coins += 1;
                    // play coin audio
                    File coinByte = new File("Game_Sounds/coin.wav");
                    play(3, coinByte);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return coins;
                }
            } else if (in.equalsIgnoreCase("P")) {
                System.out.println("You passed your turn.");
                break;
            } else
                System.out.println("Invalid input");
        }
        boolean dealer = true;
        int dATotal = 0;
        // dealer plays until win or bust
        while (dealer) {
            dATotal = 0;
            System.out.println("The dealer has " + Dhand.toString());
            dATotal += AceCard(dTotal, Dhand);
            int dValue = dATotal + dTotal;
            if (pValue == -1 || ((dValue > pValue) && (dValue <= 21))) {
                // if user busted OR the dealer has greater value than user without busting
                System.out.println("You lose.");
                dealer = false;
            } else if ((dValue <= pValue) && (dValue < 21)) {
                // if dealer has less than user and less than 21, he gets card
                System.out.println("He hits.");
                dTotal += dealCard(Dhand, comboHand);
                File cardByte = new File("Game_Sounds/cardSlide4.wav");
                play(0, cardByte);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (dValue > 21) {
                System.out.println("The dealer busted!!");
                if (pValue <= 21) {
                    System.out.println("You win! Heres a coin.");
                    coins += 1;
                    File coinByte = new File("Game_Sounds/coin.wav");
                    play(3, coinByte);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
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
        return coins;
    }

    /**
     * Slot machine simulation that generates
     * 3 random numbers. If they all equal 7, they reach JackPot,
     * win, and go onto theEndGame(). The user loses a coin every
     * time they play and are offered chances to play again
     * if they lost until out of coins.
     * Probability of winning changes depending on the value of prob.
     * 
     * @param coins - the amount of coins user can spend (amount of times
     *              user can run method)
     * @param prob  - counter to increase probability of winning
     * @return leftover or 0 amount of coins
     */
    public static int slotMachine(int coins, int prob) {
        int slot1;
        int slot2;
        int slot3;
        System.out.println("\n Time to gamble your life away at the slot machine. Literally."
                + "\n Enter a coin into the machine, and pull the lever to test your luck."
                + "\n Hopefully you can reach three lucky 7's in one pull... your life depends on it.");
        // user can play until out of coins
        while (coins > 0) {
            // initally randomize all slots
            slot1 = 1 + (int) (Math.random() * ((7 - 1) + 1));
            slot2 = 1 + (int) (Math.random() * ((7 - 1) + 1));
            slot3 = 1 + (int) (Math.random() * ((7 - 1) + 1));
            coins--;
            // increase probability of winning based on prob number
            if (prob >= 1) {
                slot1 = 7;
            }
            if (prob >= 2) {
                slot3 = 7;
            }
            if (prob >= 4) {
                slot2 = 7;
            }
            System.out.println("||   || " +
                    " ||   || " + " ||   ||");
            File slotByte = new File("Game_Sounds/Blastwave_FX_SlotMachineInsert_SFXB.3999.wav");
            play(3, slotByte);
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("|| " + slot1 + " || " +
                    " || " + slot2 + " || " + " || " + slot3 + " ||");
            play(1, slotByte);
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("||   || " +
                    " ||   || " + " ||   ||");
            play(1, slotByte);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (slot1 == 7 && slot2 == 7 && slot3 == 7) {
                System.out.println("JACKPOT!!");
                // play a bunch of coins falling
                for (int c = 0; c < 10; c++) {
                    play(0, slotByte);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Hundreds of coins spill out the slot machine, followed by an old rusted key.");
                theEndGame();
                return coins;
            } else if (slot1 == 6 && slot2 == 6 && slot3 == 6) {
                theSecretEnding();
                return coins;
            } else {
                System.out.println("Better luck next time. ");
                if (coins <= 0) {
                    break;
                }
                while (true) {
                    System.out.println("Would you like to try your luck again? Y/N ");
                    String in = " ";
                    try {
                        in = scan.next();
                    } catch (Exception e) {
                        System.out.println("Not an option");
                    }
                    if (in.equalsIgnoreCase("cheat")) {
                        // cheat allows instant win
                        prob = 4;
                        break;
                    }
                    if (in.equalsIgnoreCase("n")) {
                        System.out.println("Thank you for gambling");
                        return coins;

                    } else if (in.equalsIgnoreCase("y")) {
                        System.out.println("Lets play again!");
                        break;
                    } else {
                        System.out.println("Invalid input");
                    }
                }
            }
        }
        System.out.println("You ran out of coins!! Play games for more.");
        return coins;

    }

    /**
     * Randomly prints 1 of 4 developed mazes for
     * the user to navigate through. When they reach the goal,
     * they earn a coin and method ends.
     * 
     * @return earned coin
     */
    public static int mazeGame() {

        System.out.println("\n You approach a table at the center of the room."
                + "\n Upon the table there appears to be a chess board with only one piece..."
                + "\n A valiant knight stands at one end of the board, to which you realize isn't a chess board at all."
                + "\n Instead, the white squares on the board form a path to a castle at the other end."
                + "\n Guide the knight through the maze to go save the princess from the #/&!'@*& !!!! ");

        int GRID_SIZE = 7;
        char[][] grid = new char[GRID_SIZE][GRID_SIZE];
        HashMap<Integer, int[]> mazes = new HashMap<>();
        // each int[] holds coordinates for a different maze path
        int[] p1 = { 1, 4, 2, 4, 2, 3, 2, 2, 3, 2, 4, 2, 4, 1, 4, 3, 5, 3, 5, 5, 5, 4, 4, 5, 6, 3 };
        mazes.put(1, p1);
        int[] p2 = { 2, 6, 2, 5, 2, 3, 3, 2, 3, 3, 3, 4, 3, 5, 4, 2, 4, 5, 5, 2, 5, 3, 6, 3 };
        mazes.put(2, p2);
        int[] p3 = { 1, 1, 1, 2, 1, 3, 1, 5, 2, 3, 2, 5, 3, 2, 3, 3, 3, 5, 4, 3, 4, 4, 4, 5, 5, 4, 6, 4, 1, 6, };
        mazes.put(3, p3);
        int[] p4 = { 5, 1, 1, 3, 2, 1, 2, 2, 2, 3, 2, 4, 2, 5, 3, 2, 3, 5, 3, 6, 4, 2, 4, 5, 5, 2, 5, 5, 5, 4 };
        mazes.put(4, p4);
        // randomize the maze
        int mazeNum = 1 + (int) (Math.random() * (((mazes.size() - 1) - 1) + 1));
        Knight user = new Knight(mazes.get(mazeNum));
        boolean clear = false;
        char dir = ' ';
        // play until user breaks by winning
        while (true) {
            makeMaze(mazes.get(mazeNum), user, grid);
            // loop until valid move
            while (true) {
                System.out.println("Enter which direction you would like to go");
                System.out.println("Choose  U for up, D for down, L for left, and R for Right");
                String tempD = scan.next();
                dir = tempD.charAt(0);
                clear = user.move(dir, grid);
                if (clear) {
                    break;
                }
            }
            if (grid[user.x][user.y] == 'C') {
                // user coordinates equal goal coordinates
                System.out.println("You made it to the castle!!");
                System.out.println("You've earned a coin.");
                File coinByte = new File("Game_Sounds/coin.wav");
                play(3, coinByte);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        return 1;
    }

    /**
     * Prints out the current status of the maze
     * including user position and maze map.
     * 
     * @param path - the coordinates for maze path
     * @param user - the user robot
     * @param grid - the basic grid to be modified and printed
     */
    public static void makeMaze(int[] path, Knight user, char[][] grid) {
        // initialize grid as all o
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = 'o';
            }
        }
        // input empty coordinates for maze path
        for (int i = 1; i < path.length; i += 2) {
            grid[path[i - 1] - 1][path[i] - 1] = ' ';
        }
        // input the goal
        grid[path[path.length - 2] - 1][path[path.length - 1] - 1] = 'C';
        // input user start position
        grid[user.x][user.y] = user.symbol;
        System.out.println();
        // print out the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Called to be the end scene of the game,
     * exits the program at the end.
     */
    public static void theEndGame() {
        System.out.println(
                "With key in hand, you stand up from the pile of coins and hear the sounds of two voices bickering back and forth in the distance."
                        + "\nI said we should not have given them hints! Said the one on the right indignantly."
                        + "\nWe can only be fair - it’s not like it has changed anything really. Countered the one on the left."
                        + "\nShhh shhh… Hey, how’s it going? The one on the right hurriedly quiets their companion and looks towards you."
                        + "\nYou find yourself once again faced before your kidnappers."
                        + "\nThe one on the left goes to begin speaking when you dart through them and run to find an exit."
                        + "\nWhy would you wait to talk to them - they are just trying to stall you from being able to escape!"
                        + "\nYou see a door on the far side of the room with a keyhole at the center"
                        + "\nThat has to be it! You thrust the key into the lock, turn, and push the door with all your might."
                        + "\nYou burst into a new room and shut the door behind you. But as you get your bearings, you see written on the wall "
                        + " \"Neverending Escape Room Game\" and laughter fills the space as you drop to your knees in defeat….");
        // end program
        System.exit(0);
    }

    public static void theSecretEnding() {

    }

}