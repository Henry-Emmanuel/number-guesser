package com.company;
import javax.swing.*;
public class Main {

    public static void main(String[] args) {

	   int compNum=(int) (Math.random()*100+1);
	   int userNum=0;
       System.out.println("The correct guess would be "+compNum);
       int count=1;
       Object[] options1={"Proceed","Give up"};

       while (userNum!=compNum){
           String response = JOptionPane.showInputDialog(null,
                   "Enter a guess between 1 and 100", "Guessing Game", 3);
           userNum = Integer.parseInt(response);
           JOptionPane.showMessageDialog(null, ""+ determineGuess(userNum, compNum, count));
           count++;
           if (userNum==compNum) {
               JOptionPane.showMessageDialog(null, "" + rank(count));
               break;
           }
           int result = JOptionPane.showOptionDialog(null,"Would you like to continue?",null,JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,null, options1, null);
           if (result == JOptionPane.NO_OPTION) {
               JOptionPane.showMessageDialog(null,"The correct answer is "+compNum);
               break;
           }


       }
    }
public static String determineGuess(int userNum, int compNum, int count){
        if (userNum<0||userNum>100){
            return "Your guess is invalid.\nTry again" +count;
        }else if (userNum==compNum){
            return "You guessed correctly\nIn " +count+" attempts";
        }else if (userNum<compNum){
            return "Your guess is low, try again.\nTry Number: " +count+" attempts";
        }else if (userNum>compNum){
            return "Your guess is too high, try again.\nTry Number: " +count+" attempts";
        }else {
            return "Your guess is incorrect." +count+" attempts";
        }
    }
public static String rank(int count){
        if (count<10){
            return "You're quite the guesser!";
        }else if (count>10&&count<20){
            return "Could finish up with less attempts.";
        }else{
            return "Are you even trying?";
        }
}
}
