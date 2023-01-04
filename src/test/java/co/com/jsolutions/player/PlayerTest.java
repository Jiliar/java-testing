package co.com.jsolutions.player;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerTest {

        //@Test //According to the dice generates random numbers the unit test is inefficient
        /*public void testLoosesWhenDiceNumberIsTooLowBad(){
            Dice dice = new Dice(6);
            Player player = new Player(dice, 5);
            assertFalse(player.play());
        }*/

        @Test
        public void testLoosesWhenDiceNumberIsTooLow(){
            Dice dice = Mockito.mock(Dice.class);
            Mockito.when(dice.roll()).thenReturn(2);
            Player player = new Player(dice, 5);
            assertFalse(player.play());
        }

        @Test
        public void testWinWhenDiceNumberIsBig(){
            Dice dice = Mockito.mock(Dice.class);
            Mockito.when(dice.roll()).thenReturn(5);
            Player player = new Player(dice, 4);
            assertTrue(player.play());
        }
}