//Eric Crudup CS141 10:30-11:30

/*
Description: Create a program that sorts an array of random numbers. The # of random numbers
will be chosen by the user. The user will also choose a min and a max, and the random numbers
that are generated will all be equal to or between these values. The user will be asked if 
they want to print the unsorted and sorted lists of random numbers.
*/

import java.util.*;

public class Final_Project
{	/*
	Main:
	1) Ask the user for input						(F)
	2) Generate, possibly print, and sort random numbers based on input	(F)
	*/
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int[] parameters = new int[3];
		String[] printer = new String[2];
		
		input(scan, parameters, printer);
		sort(parameters, printer);
	}
	
	/*
	Step 1 of Main:
	NAME: input
	DESCR: takes input from user as parameters(not the programming kind) for 
	creating the list of random numbers. 
	PARAMS: Scanner scan, int[] parameters, String[] printer
	RETURN: void
	1)ask user for a min							
	2)ask user for a max
	3)ask user for the # of randoms
	4)ask user if they would like to see the unsorted list
	5)ask user if they would like to see the final sorted list
	*/
	public static void input(Scanner scan, int[] parameters, String[] printer)
	{
		
		System.out.print("How many random numbers would you like, sir? ");
		parameters[0] = scan.nextInt();
		System.out.print("Define a min for the random #'s: ");
		parameters[1] = scan.nextInt();
		System.out.print("Define a max for the random #'s: ");
		parameters[2] = scan.nextInt();
		System.out.print("Would you like to print out the unsorted list? (y/n):");
		printer[0] = scan.next();
		System.out.print("Would you like to print out the sorted list? (y/n):");
		printer[1] = scan.next();
		
	}
	
	/*
	Step 2 of Main:
	NAME: sort
	DESCR: creates a list of random numbers based on the users input, asks if the user wants to 
	print the unsorted list, then sorts the list.
	PARAMS: int[] parameters, String[] printer
	RETURN: void
	1)create an array of random numbers based on user input values		(F)
	2)sort the array from lowest number to highest				(F)
	*/
	public static void sort(int[] parameters, String[] printer)
	{
		int howmany = parameters[0];
		int min = parameters[1];
		int max = parameters[2];
		
		int i = 0, j = 0;
		int[] list = new int[ parameters[0] ];
		
		
		list_generator(howmany, max, min, i, list, printer);
		list_sorter(howmany, max, min, i, j, list, printer);
	}
	
	/*
	Step 1 of sort
	NAME: list_generator
	DESCR: create an array of random numbers based on user input values
	PARAMS: int howmany, int max, int min, int i, int[] list, int[] printer
	1)fill an array (list[]) with random numbers between a max and min
	*/
	public static void list_generator(int howmany, int max, int min, int i, int[] list, String[] printer)
	{
		Random gen = new Random();
		
		for( i = 0; i < howmany; i++ )	//creates random integers in a user defined range
		{
			list[i] = gen.nextInt();
			list[i] = Math.abs( list[i] ) % ( max - min + 1) + min;
			
			if ( printer[0].equalsIgnoreCase("y") || printer[0].equalsIgnoreCase("yes" ) )
				System.out.println("unsorted element #" + (i + 1) + " is: " + list[i]);
		}
		
	}
	
	/*
	Step 2 of sort
	NAME: list_sorter
	DESCR: sort the array from lowest to highest
	PARAMS: int howmany, int max, int min, int i, int j, int[] list, String[] printer
	RETURN: void
	1)Have a 2nd array (int[] count) count the instances of each separate 
	value between the max and min in the first array
	2)take each value between max and min from the 2nd array and apply it to
	the first array the number of times it was counted
	*/
	public static void list_sorter(int howmany, int max, int min, int i, int j, int[] list, String[] printer)
	{
		int[] count = new int[ max - min + 1 ];
		
		// This loops through the array "list[]" as many times as there are numbers between max and min
		for( i = 0; i < max - min + 1; i++ )	
		{				
			// Loops through list[], it counts the number of instances of a particular number in the array, starting with min and ending with max
			// Each time i goes up by 1, it loops through the array again counting the instances of min + i, until min + i is equal to max
			for ( j = 0; j < howmany; j++ ) 
			{
				if ( list[j] == min + i )	
					count[i]++;
			}
		}
		
		for( i = 0, j = 0; i < max - min + 1; i++ )
		{
			while( count[i] > 0 )
			{
				list[j] = min + i;
				if ( printer[1].equalsIgnoreCase("y") || printer[1].equalsIgnoreCase("yEs") )
					System.out.println("sorted element #" + (j + 1) + " = " + list[j]);
				j++;
				
				count[i] = count[i] - 1;
			}
		}	
	}
}
