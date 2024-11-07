import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testEx1noam {
    @Test
    public void testrandomNum() {
        boolean[] boolarray = {true, false, true, true, true, false, true, true, true};
        int num = Ex1.randomNum(boolarray);
        assertEquals(boolarray[num], true);

    }

    @Test
    public void testBoolPgiah() {
        int[] res = {0, 0};
        int[] testit = {1, 2, 3, 4};
        int num = 5678;
        int b = 0;
        int c = 0;
        boolean ans = Ex1.boolPgiah(testit, num, b, c);
        assertEquals(ans, true);
    }

    @Test
    public void testcompareNumberWithGuess() {
        int[] res = {1, 1};
        int b = 1;
        int c = 1;
        assertEquals(Ex1.compareNumberWithGuess(res, b, c), true);
    }

    static int countForEachNumber = 0;
    // int countForAll = 0;

    /**
     * the test here is aotomatic function that takes oll
     * number between 2--6 and math their average for 100 games
     * in addition the function math the average off oll the 500 games!
     */
    @Test
    public void testAutogame() {
        double countForAll=0;
        int TestNum;
        for(int i=2;i<7;i++) {
            TestNum = i;
            for (int j = 0; j < 100; j++) {
                System.out.println("testing");
                BP_Server game = new BP_Server();
                game.startGame(213015480, TestNum);
                Ex1.autoEx1Game(game);
            }
            double average = countForEachNumber / 100.0;
            System.out.println("the average of 100 games for the number ;" + TestNum +"is: "+average);
            assertTrue(average < 7.5);//after i did a test i know how much the average need to do
            countForAll+=average;
            countForEachNumber = 0;
        }
        double averageOf500 = countForAll / 5.0;
        assertTrue(averageOf500 < 7.0);//after i did a test i know how much the average need to do
        System.out.println("the average of 500 games for 500 games is ;" + averageOf500);
    }
}
