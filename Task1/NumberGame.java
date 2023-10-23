import java.util.*;
public class NumberGame {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("WELCOME TO GAME OF 'GUESS THE NUMBER' ");
        System.out.println("-------------------------------------");
        System.out.println("RULES:-");
        System.out.println("1.You will be given a chance to input number between 1 and 100");
        System.out.println("2.If your number is the same number as computer chosen then you won the game otherwise you will be given chances to select again");
        System.out.println("3.At max you can have 10 attempts");
        Random r=new Random();
        int cmpChoice=r.nextInt(1,101);
        int attempt=0;
        int inp=0;
        int lowerBound=1;
        int upperBound=100;
        System.out.println();
        System.out.println("Lets Play The Game");
        System.out.println();
        do{
            try{
                System.out.println("-----------------------");
                System.out.println("Attempt No "+(attempt+1));
                System.out.println("-------------------------");
                System.out.println("Enter a number between "+lowerBound+" and "+upperBound+"("+lowerBound+" and "+upperBound+") included");
                inp=s.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("You should enter a number");
                s.next();
                continue;
            }
            if(inp<lowerBound || inp>upperBound){
                System.out.println("Please enter in required range");
                continue;
            }
            else if(inp==cmpChoice){
                System.out.println("Congratulations!! You won the game");
                System.out.println("You guessed the number in "+(attempt+1)+" attempts");
                break;
            }
            else{
                if(inp>cmpChoice){
                    if(attempt!=9){
                        System.out.println("The number you entered is greater than the number computer has chosen");
                        System.out.println("Now because of your guess the range is decreased");
                    }
                    upperBound=inp;
                }
                else{
                    if(attempt!=9){
                        System.out.println("The number you entered is lower than the number computer has chosen");
                        System.out.println("Now because of your guess the range is decreased");
                    }
                    lowerBound=inp;
                }
            }
            attempt++;
        }while(attempt!=10);
        if(attempt==10){
            System.out.println("BETTER LUCK NEXT TIME");
            System.out.println("The number computer has chosen was "+cmpChoice);
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }
}
