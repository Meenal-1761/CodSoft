import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        ArrayList<ATM> accounts=new ArrayList<>();
        ATM u1=new ATM(1,23,10000);
        ATM u2=new ATM(2,89,20000);
        ATM u3=new ATM(3,13,9000);
        ATM u4=new ATM(4,18,5000);
        ATM u5=new ATM(5,87,50000);
        accounts.add(u1);accounts.add(u2);accounts.add(u3);accounts.add(u4);accounts.add(u5);
        Scanner s=new Scanner(System.in);
        System.out.println("Enter user Id:");
        int id=s.nextInt();
        System.out.println("Enter pin:");
        int pin=s.nextInt();
        boolean userExist=false;
        int index=-1;
        for(int i=0;i<accounts.size();i++){
            userExist=accounts.get(i).check(id,pin);
            if(userExist==true){
                index=i;
                break;
            }
        }
        if(!userExist){
            System.out.println("User Id or pin is incorrect");
        }
        else{
            int num=0;
            do{
                System.out.println("Enter 1 to deposit amount");
                System.out.println("Enter 2 to withdraw");
                System.out.println("Enter 3 to transfer amount");
                System.out.println("Enter 4 to show transaction history");
                System.out.println("Enter 5 to show balance");
                System.out.println("Enter 6 to quit");
                System.out.println("Enter number");
                num=s.nextInt();
                if(num==1){
                    accounts.get(index).deposit();
                }
                else if(num==2){
                    accounts.get(index).withDraw();
                }
                else if(num==3){
                    System.out.println("Enter user Id of person to whose bank you want to transfer the amount");
                    int user=s.nextInt();
                    int in=-1;
                    boolean exist=false;
                    for(int i=0;i<accounts.size();i++){
                        exist=accounts.get(i).check(user);
                        if(exist==true){
                            in=i;
                            break;
                        }
                    }
                    if(!exist){
                        System.out.println("User doesn't exist");
                    }
                    else{
                        accounts.get(index).transfer(accounts.get(in));
                    }
                }
                else if(num==4){
                    accounts.get(index).transactionHistory();
                }
                else if(num==5){
                    accounts.get(index).showBalance();
                }
                else if(num==6){
                    System.out.println();
                    System.out.println("Exiting the program");
                    System.out.println("---------------------------------------------------------------------");
                }
                else{
                    System.out.println("Incorrect Input");
                }
            }while(num!=6);
        }
    }
}
class ATM{
    private int id;
    private int userPin;

    private int balance=0;

    private ArrayList<String> history;
    ATM(){

    }

    ATM(int id,int userPin,int balance){
        this.id=id;
        this.userPin=userPin;
        this.balance=balance;
        history=new ArrayList<>();
    }

    boolean check(int id,int userPin){
        if(id==this.id && userPin==this.userPin){
            return  true;
        }
        else{
            return false;
        }
    }

    void showBalance(){
        System.out.println();
        System.out.println("**************************************************");
        System.out.println("Balance in account is Rs "+this.balance);
        System.out.println("*****************************************************");
    }

    boolean check(int id){
        if(id==this.id){
            return true;
        }
        else{
            return false;
        }
    }

    void withDraw(){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the amount you want to withdraw:");
        int amnt=s.nextInt();
        if(amnt>this.balance){
            System.out.println("You don't have enough amount in the bank to withdraw");
        }
        else{
            System.out.println("Rs "+amnt+" withdrawn from bank with user ID "+this.id);
            this.balance=this.balance-amnt;
            System.out.println("Remaining balance in account is Rs"+this.balance);
            history.add("Rs"+amnt+" withdrawn from account on "+ LocalDate.now());
        }
    }


    void deposit(){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the amount you want to deposit:");
        int amnt=s.nextInt();
        if(amnt<0){
            System.out.println("Enter correct amount");
        }
        else{
            this.balance=this.balance+amnt;
            System.out.println("Total amount in account now is Rs "+this.balance);
            history.add("Rs"+amnt+" deposited in account on"+LocalDate.now());
        }
    }


    void transactionHistory(){
        System.out.println("------------------------------------------------------------------------");
        System.out.println("TRANSACTION HISTORY IS: ");
        System.out.println("------------------------------------------------------------------------");
        for(int i=0;i<history.size();i++){
            System.out.println(history.get(i));
        }
        if(history.size()==0){
            System.out.println("Empty");
        }
        System.out.println("----------------------------------------------------------------------------");
    }

    void transfer(ATM obj){
        System.out.println(this.id+"  "+obj.id);
        Scanner s=new Scanner(System.in);
        System.out.println("Enter amount you want to transfer:");
        int amnt=s.nextInt();
        if(amnt<0){
            System.out.println("Enter correct amount");
        }
        else{
            this.balance=this.balance-amnt;
            obj.balance=obj.balance+amnt;
            System.out.println("Rs "+amnt+" transferred to account with user Id "+obj.id);
            history.add("Rs "+amnt+"transferred from account to account with user Id"+obj.id+" on "+LocalDate.now());
        }
    }
}
