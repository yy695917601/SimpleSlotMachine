package simpleSlotMachine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameStartTest {
    GameStart gameStart = new GameStart();

    @Test
    public void testValidateNumberFormatException(){
        String input1 = "fje";
        try{
            gameStart.validate(input1);
            fail("Expected NumberFormatException not throw");
        }catch (InsufficientFundsException e) {
            fail("Incorrect exception was throw.");
        }catch (NumberFormatException e){
            return;
        }
    }
    @Test
    public void testValidateInsufficientFundsException(){
        String input1 = "0";
        try{
            gameStart.validate(input1);
            fail("Expected InsufficientFundsException not throw");
        }catch (NumberFormatException e) {
            fail("Incorrect exception was throw.");
        }catch (InsufficientFundsException e){
            return;
        }
    }


}