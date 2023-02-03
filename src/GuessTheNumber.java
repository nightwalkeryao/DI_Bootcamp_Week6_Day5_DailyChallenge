import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public final int tries = 10;
    public boolean win = false;
    public int secretNumber;
    public int attempts = 0;

    public GuessTheNumber() {
        super();
        this.secretNumber = new Random().nextInt(0, 101);
    }

    private boolean compareNumbers(int userNumber, int secretNumber) {
        if (userNumber == secretNumber) {
            System.out.println("WiNNER!!!");
            return true;
        } else
            System.out.println(userNumber > secretNumber ? "Your number is bigger than the computer's, guess again" : "Your number is smaller than the computer's, guess again");
        if(attempts > tries)
            System.out.println("Out of chances");
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to play the game? Yes/No");
        if(!sc.nextLine().trim().equalsIgnoreCase("yes"))
            System.out.println("No problem, Goodbye!");
        else {
            GuessTheNumber game = new GuessTheNumber();
            String input;
            int userNumber = -1;
            System.out.println("A secret number has been generated. Can you guess it?");
            // System.out.println("Secret number: "+game.secretNumber);
            do {
                do {
                    System.out.println("Enter a number between 0 and 100");
                    input = sc.nextLine();
                    try {
                        userNumber = Integer.valueOf(input);
                    } catch (Exception e) {
                        System.out.println("Wrong input: " + e.getMessage());
                    }
                } while (userNumber == -1 || userNumber < 0 || userNumber > 100);
                game.attempts++;
                game.win = game.compareNumbers(userNumber, game.secretNumber);
            } while (!game.win && game.attempts <= game.tries);
        }
    }
}
