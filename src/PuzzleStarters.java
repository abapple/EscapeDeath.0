import java.io.*;
import java.util.*;
import javax.sound.sampled.*;
import javax.sound.sampled.AudioInputStream;

public class PuzzleStarters {
    public static HashMap<String, HashMap<Integer, String>> hints = new HashMap<>();

    // <Room, <HintNum, HintText>>
    // hint(puzzleName, hintNumber)
    public static int GRID_SIZE = 6;
    public static char[][] grid;

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

    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // fluffy introductions
        readInHints();
        // System.out.println(
        //         "As you are walking home one evening," + "\nyou decide to take a short cut through the woods."
        //                 + "\nHowever, the farther you enter the more it seems unfamiliar to you."
        //                 + "\nSuddenly, you hear a second set of footsteps from behind you. Then a third."
        //                 + "\nFear fuels you as you begin to run deeper into the unknown."
        //                 + "\nBut alas - you trip on an invisible branch and tumble to the ground."
        //                 + "\nPain fills your mind as darkness clouds your vision,"
        //                 + "\nand as your consiousness fades all that you recall is weird laughter...");
        // final File atmosByte = new File("Game_Sounds/Outdoor_Ambiance.wav");
        // play(0, atmosByte);
        // try {
        //     Thread.sleep(9000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // footSteps();
        // final File laughByte = new File("Game_Sounds/zapsplat_horror_evil_demonic_laugh_001_12149.wav");
        // play(2, laughByte);
        // try {
        //     Thread.sleep(3000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // System.out.println("" + " -----------------------------------------------------------------------------------"
        //         + "\n -----------------------------------------------------------------------------------"
        //         + "\nWhen your eyes open back up, you see two figures looking down at you."
        //         + "\nYou look see through them and see a sprawling, definitely haunted mansion named "
        //         + "\n'The Midnight Manor'"
        //         + "\nWait, see through them?! 'What? Never seen a ghost before,' the one on the right smirked."
        //         + "\nThe one on the left continued,'Well, guess you can say you've met two now."
        //         + "\nAnyway, we're bored so you're gonna play these games at our house "
        //         + "\nor else you'll die or whatever.'"
        //         + "\nStill in disbelief, you try to back away "
        //         + "\nbut they grab both your arms and drag you to the entrance. "
        //         + "\n'Find your way out!' They gleefully say in chorus as they push you through the door,"
        //         + "\n'Or stay here and become a ghost, lol. Have fun :)'"
        //         + "\nThe door shuts behind you and disappears."
        //         + "\nYou find yourself in a hallway that seems to stretch endlessly in both directions.");
        int hintCnt = 3;
        int number = 1 + (int) (Math.random() * ((20 - 1) + 1));
        if (number == 10) {
            number = 15;
        }
        recRoom(number, hintCnt);
        library_morse(hintCnt);
        library_books(hintCnt);
        gameRoom(hintCnt);
        mazeGame();
    }
    public static void footSteps(){
        File stepByte1 = null;
        File stepByte2 = null;
        File stepByte3 = null;
        File stepByte4 = null;
        for(int f = 0; f < 8; f++)
        {
        stepByte1 = new File("Game_Sounds/Corsica_S-Walking_on_snow_covered_gravel_01.flac");
        play(0, stepByte1);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stepByte2 = new File("Game_Sounds/Corsica_S-Walking_on_snow_covered_gravel_06.flac");
        play(1, stepByte2);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stepByte3 = new File("Game_Sounds/Corsica_S-Walking_on_snow_covered_gravel_03.flac");
        play(5, stepByte3);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stepByte4 = new File("Game_Sounds/Corsica_S-Walking_on_snow_covered_gravel_07.flac");
        play(2, stepByte4);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }

    public static void gameRoom(int hintCnt) {
        // Buttons on which game to play
        int probability = 0;
        int coins = 0;
        while (true) {
            System.out.println("In this room, you have multiple games to play!"
                    + "\nCurrently you have " + coins + " amount of coins"
                    + "\nTo play each game, enter corresponding input: " + "\nCup Game : CG" + "\nBlack Jack : BJ"
                    + "\nMystery Game : ???" + "\nSlot Machine : SM"
                    + "\nAs always, if you need a hint, just type in 'hint'");
            String userInput = "";
            try {
                userInput = scan.next();
            } catch (Exception e) {
                System.out.println("Not an option");
            }
            if (userInput.equalsIgnoreCase("CG")) {
                coins += cupGame();
            } else if (userInput.equalsIgnoreCase("BJ")) {
                coins += blackJack();
            } else if (userInput.equalsIgnoreCase("???")) {
                coins += mazeGame();
            } else if (userInput.equalsIgnoreCase("hint")) {
                hintCnt = giveHint("Casino", hintCnt);
                System.out.println("Are you dumb?");
            } else if (userInput.equalsIgnoreCase("SM")) {
                if (coins >= 3) {
                    coins = slotMachine(hintCnt, coins, probability);
                    if (probability >= 6) {
                        break;
                    }
                    probability++;

                } else {
                    System.out.println("You can't afford to play this yet.");
                }
            } else {
                System.out.println("Not an option");

            }
        }
        // go onto next part of game.

    }

    public static int cupGame() {
        int coins = 0;
        System.out.println("There are 4 silver chalices upside down on a table before you."
                + "\nA mysterious spirit whispers to you that a small, golden ball lies under one of them."
                + "\nIf you guess correctly you may earn a shiny token."
                + "\nChoose a number 1 - 4 to get started.");
        boolean won = false;
        while (!won) {
            int smallBall = 1 + (int) (Math.random() * ((4 - 1) + 1));
            int guess = 0;
            try {
                guess = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Not an option");
            }

            if (guess == smallBall) {
                System.out.println("The ball is here! You found it :) Here is your reward.");
                File coinByte = new File("Game_Sounds/coin.wav");
                play(3, coinByte);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
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
                // Normal number cards
            } else if (card > 10) {
                int face = 1 + (int) (Math.random() * ((2 - 1) + 1));
                newCard = "" + faces[face] + " of " + suits[suit];
                if (!hand.contains(newCard)) {
                    hand.push(newCard);
                    pHand.push(newCard);
                    value = 10;
                    break;
                }
                // Face cards j-k
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
                // Ace
            }
        }
        return value;
    }

    public static int AceCard(int total, Stack<String> hand) {
        int value = 0;
        int acesT = 0;
        int cnt = 0;
        for (String a : hand) {
            String card = a.substring(0, 3);
            if (card.equalsIgnoreCase("Ace")) {
                cnt++;
            }
        }
        while (cnt > 0) {
            value = 0;
            cnt--;
            if ((total + 11 + cnt) <= 21) {
                value = 11;
                acesT += 11;
            } else {
                value = 1;
                acesT += 1;

            }
            total += value;
        }

        return acesT;

    }

    public static int blackJack() {
        int pTotal = 0;
        int dTotal = 0;
        int coins = 0;
        Stack<String> Uhand = new Stack<>();
        Stack<String> Dhand = new Stack<>();
        Stack<String> comboHand = new Stack<>();
        System.out.println("The cards flit about in the air and the hands are dealt out.");
        for (int i = 0; i < 2; i++) {
            pTotal += dealCard(Uhand, comboHand);
            dTotal += dealCard(Dhand, comboHand);
        }
        // Users turn
        int pATotal = 0;
        System.out.println("The dealer has " + Dhand.peek() + " facing up.");
        while (true) {
            System.out.println("You have : " + Uhand.toString());
            pATotal += AceCard(pTotal, Uhand);

            System.out.println(
                    "Enter what you would like to do... " + "\nHit : H" + "\nStay : P" /** + "\n Split : S" */
            );
            String in = "";
            try {
                in = scan.next();
            } catch (Exception e) {
                System.out.println("Not an option");
            }
            if (in.equalsIgnoreCase("H")) {
                pATotal = 0;
                pTotal += dealCard(Uhand, comboHand);
                System.out.println("You recieved a(n) " + Uhand.peek());
                pATotal += AceCard(pTotal, Uhand);
                System.out.println("Your total is :" + (pTotal + pATotal));
                if (pTotal + pATotal > 21) {
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
        int dATotal = 0;
        while (dealer) {
            dATotal = 0;
            System.out.println("The dealer has " + Dhand.toString());
            dATotal += AceCard(dTotal, Dhand);
            System.out.println("His total is " + (dTotal + dATotal));

            if (pTotal + pATotal == -1 || (dTotal + dATotal > pTotal + pATotal && dTotal + dATotal <= 21)) {
                System.out.println("You lose.");
                dealer = false;
            } else if ((dTotal + dATotal <= pTotal + pATotal) && (dTotal + dATotal < 21)) {
                System.out.println("He hits.");
                dTotal += dealCard(Dhand, comboHand);
                // dATotal = 0;
                // dATotal += AceCard(dTotal, Dhand);

            } else if (dTotal + dATotal > 21) {
                System.out.println("The dealer busted!!");
                if (pTotal <= 21) {
                    System.out.println("You win! Heres a coin.");
                    coins += 1;
                    File coinByte = new File("Game_Sounds/coin.wav");
                    play(3, coinByte);
                    try {
                        Thread.sleep(3000);
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

    public static int slotMachine(int hintCnt, int coins, int prob) {
        int slot1;
        int slot2;
        int slot3;

        while (coins > 0) {
            slot1 = 1 + (int) (Math.random() * ((7 - 1) + 1));
            slot2 = 1 + (int) (Math.random() * ((7 - 1) + 1));
            slot3 = 1 + (int) (Math.random() * ((7 - 1) + 1));
            coins--;
            if (prob >= 2) {
                slot1 = 7;
            }
            if (prob >= 4) {
                slot3 = 7;
            }
            if (prob >= 6) {
                slot2 = 7;
            }
            System.out.println("||   || " +
                    " ||   || " + " ||   ||");
            System.out.println("|| " + slot1 + " || " +
                    " || " + slot2 + " || " + " || " + slot3 + " ||");
            System.out.println("||   || " +
                    " ||   || " + " ||   ||");
            if (slot1 == 7 && slot2 == 7 && slot3 == 7) {
                System.out.println("JACKPOT!!");
                // coins jingling/ key drop
                System.out.println("Hundreds of coins spill out the slot machine, followed by an old rusted key.");
                break;
            } else if (slot1 == 6 && slot2 == 6 && slot3 == 6) {
                // spoopy
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

    public static void library_morse(int hintCnt) {
        System.out.println("You see a dusty record player on a table in the middle of the room. "
                + "\nAs you approach, it begins to play an odd series of beeps and blips...\n");
        final File file = new File("Morse_Code");
        for (final File child : file.listFiles()) {
            play(2, child);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
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
            String input = " ";
            try {
                input = scan.next();
            } catch (Exception e) {
                System.out.println("Not an option");
            }
            if (input.equalsIgnoreCase("p")) {
                for (final File child : file.listFiles()) {
                    play(2, child);
                }
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
        // Book puzzle implementing queue and while loop boolean trapped = true;
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
        String[] shelf = { "The Name of this Book is Secret - Pseudonymous Bosch (NBS) P",
                "The Hound of the Baskervilles - Sir Arthur Conan Doyle (HB) S",
                "The Great Mouse Detective: Basil of Baker Street - Eve Titus (GMD) E",
                "The Murder on the Orient Express - Agatha Christie (MOE) A",
                "The Girl Who Lived - Christopher Greyson (GWL) C", "The Westing Game - Ellen Raskin (WG) e" };
        while (trapped) {
            // Input the book's code in parentheses to place it in the queue
            printOptions(shelf, pileOfBooks);
            String input = "";
            try {
                input = scan.next();
            } catch (Exception e) {
                System.out.println("Not an option");
            }
            // P == NBS;
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
            // Checking if all books are on shelf
            if (pileOfBooks.size() == sctMsg.length) {
                for (int i = 0; i < sctMsg.length; i++) {
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
        File doorOpenByte = new File("src/door_open.wav");
        play(3, doorOpenByte);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void recRoom(int turns, int hintCnt) {
        System.out.println(turns);
        if (turns == 10) {
            System.out.println("An oddly large doorway sized painting looms in front of you now."
                    + "\nYou move it aside to reveal an opening into a private library.");
            File doorOpenByte = new File("src/door_open.wav");
            play(3, doorOpenByte);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
        }
    }

    public static void tauntPlayer(boolean close) {
        ArrayList<String> enCourage = new ArrayList<>();
        ArrayList<String> disCourage = new ArrayList<>();
        Scanner tnt = null;
        try {
            tnt = new Scanner(new File("src/taunts.txt"));
        } catch (FileNotFoundException e) {
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

    public static int mazeGame() {
        grid = new char[GRID_SIZE][GRID_SIZE];
        
        // method to input spaces(path) into grid array
        HashMap<Integer, int[]> mazes = new HashMap();
        int[] p1 = { 1, 4, 2, 4, 2, 3, 2, 2, 3, 2, 4, 2, 4, 3, 5, 3, 6, 3 };
        mazes.put(1, p1);
        // p1 = {};
        // mazes.put(2, p1);
        // p1 = {};
        // mazes.put(3, p1);
        // p1 = {};
        // mazes.put(4, p1);

        // randomize the maze
        int mazeNum = 1 + (int) (Math.random() * (((mazes.size() - 1) - 1) + 1));
        makeMaze(mazes.get(mazeNum));
        Knight user = new Knight(mazes.get(mazeNum));
        printMaze(user);

        boolean clear = false;
        char dir = ' ';
        while (true) {
            makeMaze(mazes.get(mazeNum));
            printMaze(user);
            while (true) {
                // stuff about the game
                System.out.println("Enter which direction you would like to go");
                dir = scan.nextLine().charAt(0);
                clear = user.move(dir, grid);
                if(clear){
                    break;
                }
            }
            if (grid[user.x][user.y] == 'C') {
                System.out.println("You made it to the castle!!");
                System.out.println("You've earned a coin.");
                File coinByte = new File("src/coin.wav");
                play(3, coinByte);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        return 1;

    }

    public static void makeMaze(int[] path) {
        // while (!path.isEmpty()) {
        // grid[path.poll() - 1][path.poll() - 1] = ' ';
        // }
         for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = 'o';
            }
        }
        
        for (int i = 1; i < path.length; i += 2) {
            grid[path[i - 1] - 1][path[i]] = ' ';
        }

        grid[path[path.length - 2]-1][path[path.length-1]] = 'C';

    }

    public static void printMaze(Knight user) {
        grid[user.x][user.y] = user.symbol;
        System.out.println();
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
