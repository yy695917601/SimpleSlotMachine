package simpleSlotMachine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SlotGameTest {
    SlotGame slotGame = new SlotGame(3);

    @Test
    public void testJockPotOne(){
        slotGame.result = new int[][]{
                {1, 1, 1},
                {2, 3, 4},
                {5, 6, 7}};

        assertEquals(1, slotGame.jackPot());
        assertNotEquals(2,slotGame.jackPot());

    }

    @Test
    public void testJockPotTwo(){
        slotGame.result = new int[][]{
                {1, 1, 1},
                {2, 1, 4},
                {5, 6, 1}};

        assertEquals(2, slotGame.jackPot());
        assertNotEquals(1,slotGame.jackPot());

    }

}