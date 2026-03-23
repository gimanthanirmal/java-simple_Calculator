
import java.util.Scanner;


class MathProcessor //All the math functions
{
    public static double add(double a,double b) {return a+b;}

    public static double sub(double a,double b) {return a-b;}

    public static double div(double a,double b) {return a/b;}

    public static double mul(double a,double b) {return a*b;}
}

class ScheduledExit{

    public static void exitAfterDelay(int seconds){
        System.out.println("Programme Will exit in "+seconds);

        for(int i=1;i<=3;i++){
            System.out.println(i);

            try{
            Thread.sleep(seconds*500);

            } catch(InterruptedException e){

            e.printStackTrace();
            }
        }
        System.exit(0);

        
        


    }

}

    

class CalStart //Main menu & input
{
    static Scanner input = new Scanner(System.in);
    static char choices[]={'+','-','/','*','!','#','@'};  //Choices array
    static double history[]=new double[5];

    public char mainMenu()
    {
        while(true)
        {
            System.out.println("""
                START CALCULATING !
                    Main Menu

                1.Addition: +
                2.Subtraction: -
                3.Division: /
                4.Multiplication: * 
                5.Reset: !
                6.Terminate: #
                7.History: @
            """);

            System.out.print("Enter your Choice: ");
            char choice = input.next().charAt(0);
            
            System.out.println("You chose: " +choice +"\n");

            if(choice=='@'){
                printHistory();
                continue;
            }else if(choice=='#'){

                System.out.println("Terminating....\n");
                System.exit(0);
            }

            boolean choiceFound=false;
            for(char ch:choices){

                if(ch==choice){
                    choiceFound=true;
                    calInputs(choice);
                    break;
                }
            }
            if(!choiceFound){
                System.out.println("Wrong Input try again..!\n");
                continue;     
            }    
            
        }
    }

    public static void calInputs(char choice)
    {
            String numIn01;
            String numIn02;

            double num01;
            double num02;

            
            while (true) {

                System.out.print("Enter 1st number: ");
                numIn01 = input.next();

                if (numIn01.equals("!")) {

                    System.out.println("Reseting...\n");
                    return;

                }else if(numIn01.equals("#")){

                    System.out.println("\nTerminating....\n");
                    ScheduledExit.exitAfterDelay(3);
                    
                

                }
                try{

                    num01=Double.parseDouble(numIn01);

                }catch(NumberFormatException e){

                    System.out.println("Wrong Input Try again.");
                    continue;

                }

                System.out.print("Enter 2nd Number: ");
                numIn02 = input.next();

                if(numIn02.equals("!" )){

                    System.out.print("Reseting..\n");
                    return;

                }else if(numIn02.equals("#")){

                    System.out.println("\nTerminating....\n");
                    ScheduledExit.exitAfterDelay(3);
                }
                
                try {
                    num02=Double.parseDouble(numIn02);
                } catch (NumberFormatException e) {
                    System.out.println("Wrong input try again..");
                    continue;
                    
                }
                if(choice=='/' && num02==0){

                    System.out.println("Can't Devide by 0\n");

                    continue;

                }else{
                        break;
                    }
                
            }
            Calculate(choice, num01, num02);  
    }

    public static void Calculate (char choice,double num01,double num02){
        double result = switch (choice) {

                case '+' -> MathProcessor.add(num01,num02);
                case '-' -> MathProcessor.sub(num01,num02);
                case '/' -> MathProcessor.div(num01,num02);
                case '*' -> MathProcessor.mul(num01,num02);

                default -> 0;
        };
            System.out.println("Result: "+result + "\n");
            showHistory(history, result);
    }
    public static void showHistory(double[] history,double result){

        for(int i=0; i<history.length-1; i++){
            history[i] = history[i+1];

        }
        history[history.length - 1] = result; 

    }
    public static void printHistory(){
        System.out.println("HISTORY\n");
        for(int i=0; i< history.length; i++){
            if(history[i]== 0.0){
                continue;
            }
            System.out.println(history[i]+"\n");
        }

    }
           
}
public class CalculatorApp {
    public static void main(String args[])
    {
        var start = new CalStart();

        start.mainMenu();
        
        


    }
    
}


