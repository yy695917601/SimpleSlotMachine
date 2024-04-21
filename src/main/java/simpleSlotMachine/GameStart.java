package simpleSlotMachine;

import java.util.Scanner;

public class GameStart {
    Player player = new Player();
    SlotGame slotGame = new SlotGame(3);

    public void start() throws InsufficientFundsException {
        System.out.println("One dollar per spain, JackPot will add two dollar to your account");
        System.out.println("Please enter your credit amount");
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        validate(input);
        int play = 1;
        while (player.getMoney() >= 1 && play != 2) {
            System.out.println("Enter 1 to Spin");
            System.out.println("Enter 2 to Quit");
            play = s.nextInt();
            if (play == 1) {
                player.setMoney(player.getMoney() - 1);
                System.out.println(slotGame);
                //two credit per jackpot
                int point = slotGame.jackPot() * 2;
                if (point != 0) {
                    player.setMoney(player.getMoney() + point);
                    System.out.println("You Win " + point / 2 + " Jackpot!");
                    System.out.println("Your remain credit: " + player.getMoney());
                } else {
                    System.out.println("No Jackpot");
                    System.out.println("Your remain credit: " + player.getMoney());
                }
            }
        }


    }

    //input validation check if input is a integer
    public void validate(String input) throws InsufficientFundsException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(input + " is not a valid integer");
        }

        player.setMoney(Integer.parseInt(input));
        if (player.getMoney() < 1) {
            throw new InsufficientFundsException(
                    "Error: Insufficient Funds: " + player.getMoney()
            );
        }
    }
}
