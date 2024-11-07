import java.util.Arrays;
import java.util.Random;


/**
 * * Name; Noam Glikman   ID; 213015480
 *
 *
 * Introduction to Computer Science, Ariel University, Ex1 (manual Example + a Template for your solution)
 * See: https://docs.google.com/document/d/1C1BZmi_Qv6oRrL4T5oN9N2bBMFOHPzSI/edit?usp=sharing&ouid=113711744349547563645&rtpof=true&sd=true
 * <p>
 * Ex1 Bulls & Cows - Automatic solution.
 * **** Add a general readme text here ****
 * explanation here:
 * first of all in the main we deceid with how much number we play and go to autoEx1Game(game);

 *1. we creat an arr at the size of 10^NumOfDigits
 * we fill the array with "true" values.
 * then we get a random number using the function "randomNum(boolean[] boolarr)" and send it to the game,
 * from the game we get a result that says how many bulls and cows we have.
 *
 *
 * 2.In the next step we go throw the arr and compares between our bulls and cows from the game and the bulls and cows
 * that my random number and the indexes have----->>>
 * for an example 1)code:78,myGuess:01,b:0,c:0.
 *                2)myGuess:01,arr:67,b:0,c:0.
 *                3)i will put in arr[67] true.
 * 3.
 * we will take a new random number.
 * if there is a false we move to the next number, if we have gone out of bounds
 * The array we reset the number and continue running.
 * If we reach a suitable number, we will take it and check how much bowls and cows it has with the secret code
 * Inside each number for which you get a bulls and cows with the random number
 * as the random number had with the code we will fil the index "true"
 * else, we will put in the index false
 * and do it oll over again until we know the code
 * **** Results ****
 * Make sure to state the average required guesses
 * for 2,3,4,5,6 digit code:
 * <p>
 * Average required guesses 2: 6.32
 * Average required guesses 3: 6.18
 * Average required guesses 4: 6.05
 * Average required guesses 5: 6.65
 * Average required guesses 6: 7.16
 */
public class Ex1 {
    public static final String Title = "Ex1 demo: manual Bulls & Cows game";
    private static Random random;


    public static void main(String[] args) {
        //double a = average(4);//if you want to get the average you can delete the "//".and put "//" next to the autoEx1Game(game, 4, boolarr);
        BP_Server game = new BP_Server();   // Starting the "game-server"
        long myID = 213015480;             // Your ID should be written here
        game.startGame(myID, 6);  // Starting a game so you need to pick a number
        autoEx1Game(game);



        //manualEx1Game(game);
    }


    /*public static void manualEx1Game(BP_Server game) {

        Scanner sc = new Scanner(System.in);

        int ind = 1;      // Index of the guess
        int numOfDigits = game.getNumOfDigits();
        double max = Math.pow(10, numOfDigits);
        while (game.isRunning()) {           // While the game is running (the code has not been found yet
            System.out.println(ind + ") enter a guess: ");
            int g = sc.nextInt();
            if (g >= 0 && g < max) {
                int[] guess = toArray(g, numOfDigits); // int to digit array
                int[] res = game.play(guess); // Playing a round and getting the B,C
                System.out.println(ind + ") B: " + res[0] + ",  C: " + res[1]); // Prints the Bulls [0], and the Cows [1]
                ind += 1;               // Increasing the index
            }
        }
        System.out.println(game.getStatus());
    }

     */



    /**
     * Simple parsing function that gets an int and returns an array of digits
     *
     * @param a    - a natural number (as a guess)
     * @param size - number of digits (to handle the 00 case).
     * @return an array of digits
     */
    private static int[] toArray(int a, int size) {
        int[] c = new int[size];
        for (int j = c.length - 1; j >= 0; j--) {
            c[j] = a % 10;
            a = a / 10;
        }
        return c;
    }
////////////////////////////////////////////////////


    /**
     * The function receives the number of digits and calculates the size of the array.
     * Then initializes into the boolean array "true".
     * while (game.isRunning()) As long as the game continues and I failed to guess the code,
     * we will generate a random number using the function "randomNum(boolean[] boolarr)"
     * We will insert the random number into an array with the help of the function "toArray(int a, int size)"
     * We will check how many bowls and cows the random number has with the game code.
     * for (int i = 0; i < arr.length; i++) We will go through the array , we will put in arr[i] true or false
     * after we got answer frome boolPgiah.
     *
     * @param game
     * @return
     */
    public static int autoEx1Game(BP_Server game) {
        int digits=game.getNumOfDigits();
        boolean[] boolarr = new boolean[(int) (Math.pow(10, digits))];
       // int sizeOfArr = (int) Math.pow(10, digits);
        int count = 0;
        for (int i = 0; i < boolarr.length; i++) {
            boolarr[i] = true;
        }
        while (game.isRunning()) {

            int ge = randomNum(boolarr);//enter to ge a random number
            int[] myGuess = toArray(ge, digits);//chang ge to array
            int[] res = game.play(myGuess);//found how much b and c ge have
            testEx1noam.countForEachNumber++;

            count++;//count the guess
            int b = res[0];//so we would check if b and c are even to others index
            int c = res[1];
            System.out.println(count + ") Got Guess " + Arrays.toString(myGuess) + " B: " + res[0] + ",  C: " + res[1]);
            for (int i = 0; i < boolarr.length; i++) {
                if (boolarr[i]) {
                    boolarr[i] = boolPgiah(myGuess, i, b, c);
                }

            }
        }
        return count;
    }

    /**
     * the mathood gets a boolean arr and give me a random number
     * if this index have true in it.
     * if its have false she continues until we have a relevant number
     *
     * @param boolarr
     * @return random number
     */

    public static int randomNum(boolean[] boolarr) {
        Random random = new Random();
        int num = random.nextInt(boolarr.length);
        if (boolarr[num]) {
            return num;
        } else {
            while (true) {//until else is not correct
                num = num + 1;
                if (num > boolarr.length - 1) {
                    //The number is reset and continues to run on all indexes
                    num = 0;
                }
                if (boolarr[num]) {
                    return num;
                }
            }

        }

    }

    /**
     * the mathood checks how much bowls and cows my guess and some number(one of the index) have.
     * she calls the function compareNumberWithGuess to see if they even.
     * so that we can insert "true"(if they even) or "false" in.
     *
     *
     * @param firstGuess
     * @param number
     * @param b
     * @param c
     * @return
     */
    public static boolean boolPgiah(int[] firstGuess, int number, int b, int c) {//gets an option numer and our gess
        //counts how much b and c the tow index have
        int bowls = 0;
        int[] firstGuessCopy = Arrays.copyOf(firstGuess, firstGuess.length);
        int[] numberToArray = toArray(number, firstGuess.length);//change some to toArray
        for (int i = 0; i < firstGuessCopy.length; i++) {
            if ((numberToArray[i] == firstGuessCopy[i]) && (numberToArray[i] != -1 && firstGuessCopy[i] != -1)) {
                bowls += 1;
                numberToArray[i] = -1;
                firstGuessCopy[i] = -2;
            }
        }
        int cows = 0;
        for (int i = 0; i < numberToArray.length; i++) {
            for (int j = 0; j < firstGuessCopy.length; j++) {
                if (i != j && (numberToArray[i] == firstGuessCopy[j])) {
                    cows += 1;
                    numberToArray[i] = -7;
                    firstGuessCopy[j] = -8;
                }
            }

        }
        int[] res1 = new int[2];
        res1[0] = bowls;
        res1[1] = cows;
        return compareNumberWithGuess(res1, b, c);

    }

    /**
     * The function checks whether the number of b and c they received are equal to the number of b and c we received from the game
     *
     * @param res1
     * @param b
     * @param c
     * @return if they even return true,else-false
     */
    public static boolean compareNumberWithGuess(int[] res1, int b, int c) {
        if ((res1[0] == b) && (res1[1] == c)) {
            return true;
        }
        return false;
    }

}


