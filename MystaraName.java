/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Rafael Perez
 */
public class MystaraName {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int charType = 0; //this integer determines the type of the player character
        String charClass = null; //this string will hold the name of the player character's type, depending on charType
        String charName = null; //this is the name of the player character
        int total = 0; //this is the sum of all the values inside the character's name
        int error = 0; //if an error occurs, this is set to 1, so loops will repeat until a correct input is made.
        
        
        Scanner input = new Scanner(System.in);
        
    
        do{
        error = 0;
        System.out.println("Enter the name of your character. The name should be no longer than 6 characters.\nAll letters, numbers, and the symbols ., &, -, !,?, are allowed.");
        charName = input.nextLine(); //name is received
        charName = charName.toUpperCase(); //capitalizes string name in case it isn't capitalized on input.
        char[] charInfo = charName.toCharArray(); //the characters in the name are split individually and placed in array
        if (charInfo.length > 5){
             charName = charName.substring(0, 6); // the string is limited to 6 characters in case of wrong input.
         }
        
        for (int i = 0; i < charInfo.length; i++){ // the value of all the characters in the name are added up
           try{ 
            if (charInfo[i] == 'A' || charInfo[i] == 'F' || charInfo[i] == 'K' || charInfo[i] == 'P' || charInfo[i] == 'U' || charInfo[i] == 'Z') 
                 total += 0; 
             else if (charInfo[i] == 'B' || charInfo[i] == 'G' || charInfo[i] == 'L' || charInfo[i] == 'Q' || charInfo[i] == 'V')
                 total += 1;
             else if (charInfo[i] == 'C' || charInfo[i] == 'H' || charInfo[i] == 'M' || charInfo[i] == 'R' || charInfo[i] == 'W')
                 total += 2;
             else if (charInfo[i] == 'D' || charInfo[i] == 'I' || charInfo[i] == 'N' || charInfo[i] == 'S' || charInfo[i] == 'X')
                 total += 3;
             else if (charInfo[i] == 'E' || charInfo[i] == 'J' || charInfo[i] == 'O' || charInfo[i] == 'T' || charInfo[i] == 'Y')
                 total += 4;
             else if (charInfo[i] == '0' || charInfo[i] == '5' || charInfo[i] == '.')
                 total += 5;
             else if (charInfo[i] == '1' || charInfo[i] == '6' || charInfo[i] == '&')
                 total += 6;
             else if (charInfo[i] == '2' || charInfo[i] == '7' || charInfo[i] == ' ')
                 total += 7;
             else if (charInfo[i] == '3' || charInfo[i] == '8' || charInfo[i] == '-')
                 total += 8;
             else if (charInfo[i] == '4' || charInfo[i] == '9' || charInfo[i] == '!' || charInfo[i] == '?')
                 total += 9;
             else { error = 1; //if a character cannot be assigned a value, then it is not a valid character, and an error is created.
                    throw new InputMismatchException("Invalid characters in input. Remember, all letters, numbers, and the symbols ., &, -, !,?, are allowed ");
                  }
             if (i == 5){ //since names are not allowed to be longer than 6, the loop breaks here, in case the user entered a name that's too long.
                 break;
             }
           }
             catch (InputMismatchException e){ //error is set to 1 and the loop will repeat if the input is invalid.
                     System.out.println("Invalid characters in input.");
                     error = 1;
                     }
             }
         
        }
        while (error != 0); //if there are no errors, then the loop ends.
        
        
        do{
        error = 0; 
        System.out.println("What your character's class?\nEnter 1 for Fighter\nEnter 2 for Dwarf\nEnter 3 for Elf\nEnter 4 for Cleric\nEnter 5 for Thief\nEnter 6 for Magic User");
        try{
        charType = input.nextInt(); //character type is received.
            if (charType <= 0 || charType > 6){ //if a number that is not between 1 and 6 is entered, then an error occurrs.
                throw new ArithmeticException("Incorrect number. Enter a number between 1 and 6.");
            }
           }
        catch (ArithmeticException n){ //in the case of a wrong number, error is set to 1, and the loop repeats until a correct input is made
            System.out.println("Incorrect number. Try again.");
            error = 1;
        }
        catch (InputMismatchException m){ //if something other than a number is entered, error is set to 1, loop repeats until correct input
            System.out.println("Incorrect input. Try again.");
            error = 1;
            input.next();
        }    
        }
        while (error != 0);
        
         
         
         
         
         
         switch(charType){ //character type is determined, and appropiate string is assigned to charClass
             case 1:
                 charClass = "Fighter";
                 break;
             case 2:
                 charClass = "Dwarf";
                 break;
             case 3:
                 charClass = "Elf";
                 break;
             case 4:
                 charClass = "Cleric";
                 break;
             case 5:
                 charClass = "Thief";
                 break;
             case 6:
                 charClass = "Magic User";
                 break;
         }
         
         
         
         //System.out.printf("The sum is %d\n", total);
         
         while (total >= 10){ //the value to determine type must be a single digit number, so if it is greater than 10, the individual digits of
             total = (total % 10) + (total / 10); //of this number are added together. Loop repeats if the number is still greater or equal to 10.
         }
         
       // System.out.printf("The value is %d\n", total);
	  //  System.out.printf("The charType is %d\n", charType);
         
         System.out.printf("Your character's name is %s the %s\n", charName, charClass); //information about the player character is printed.
         switch(total){
             case 0:
                 System.out.println("You are Type A. You shall receive a medal.");
                 break;
             case 1:
                 System.out.println("You are Type B. You shall receive the boots of speed.");
                 break;
             case 2:
                    if (charType == 3){
                        System.out.println("You are Type C. You shall receive a circlet.");
						break;
                    }
                    else if (charType == 1 || charType == 2){
                        System.out.println("You are Type C. You shall receive a helmet.");
                        break;
                    }
                     else if (charType == 4 || charType == 5 || charType == 6){
                        System.out.println("You are Type C. You shall receive a hat.");
                        break;
                    }
             case 3:
                 System.out.println("You are Type D. You shall receive a ring of protection.");
                 break;
             case 4:
                 System.out.println("You are Type E. You shall receive a ring of fire resistance.");
                 break;
             case 5:
                 System.out.println("You are Type F. You shall receive a ring of spell turning.");
                 break;
             case 6:
                 System.out.println("You are Type G. You shall receive the gauntlets of ogre power.");
                 break;
             case 7:
                    if (charType == 6){
                        System.out.println("You are Type H. You shall receive the rod of fire.");
                        break;
                    }
                    else if(charType == 3){
                        System.out.println("You are Type H. You shall receive earrings");
                        break;
                    }
                    else if(charType == 1 || charType == 2){
                        System.out.println("You are Type H. You shall receive an anklet");
                        break;
                    }
                    else if(charType == 4 || charType == 5){
                        System.out.println("You are Type H. You shall receive a brooch");
                        break;
                    }
             case 8:
                    if (charType == 6){
                        System.out.println("You are type I. You shall receive the rod of cold.");
                        break;
                    }
                    else 
                        System.out.println("You are Type I. You shall receive a bracelet.");
                        break;
             case 9:
                    if (charType == 6){
                        System.out.println("You are Type J. You shall receive the rod of thunder.");
                        break;
                    }
                    else if (charType == 3){
                        System.out.println("You are Type J. You shall receive a necklace.");
                        break;
                    }
                    else
                        System.out.println("You are Type J. You shall receive an orb.");
                 
         }
        
    }
    
}
