import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("HELLO!!PLEASE TELL YOUR MARKS OF EACH SUBJECTS");
        float math_marks;
        float eng_marks;
        float sst_marks;
        float science_marks;
        float punjabi_marks;
        float hindi_marks;
        System.out.println("Enter marks in Maths:");
        math_marks=s.nextFloat();
        System.out.println("Enter marks in English:");
        eng_marks=s.nextFloat();
        System.out.println("Enter marks in Social Studies:");
        sst_marks=s.nextFloat();
        System.out.println("Enter marks in Science:");
        science_marks=s.nextFloat();
        System.out.println("Enter marks in Punjabi:");
        punjabi_marks=s.nextFloat();
        System.out.println("Enter marks in Hindi:");
        hindi_marks=s.nextFloat();
        float totalMarks=math_marks+eng_marks+sst_marks+science_marks+punjabi_marks+hindi_marks;
        System.out.printf("Total marks obtained is: %.2f\n",totalMarks);
        float averageMarks=totalMarks/600;
        float percentage=averageMarks *100;
        System.out.printf("Percentage is: %,2f\n",percentage);
        if(percentage>90){
            System.out.println("Grade:A");
        }
        else if(percentage>80 && percentage<=90){
            System.out.println("Grade:A-");
        }
        else if(percentage>70 && percentage<=80){
            System.out.println("Grade:B");
        }
        else if(percentage>60 && percentage<=70){
            System.out.println("Grade:B-");
        }
        else if(percentage>50 && percentage<=60){
            System.out.println("Grade C");
        }
        else if(percentage>40 && percentage<=50){
            System.out.println("Grade:C-");
        }
        else{
            System.out.println("Grade:F");
        }
    }
}
