import java.util.Scanner;


public class LibrarySimulator {
	public static void main(String[] args)
	{
		Scanner read = new Scanner(System.in);
		
		int id1 = 123;
		int id2 = 456;
		int id3 = 789;
		int activeId = 0;


		
		String usrName1 = "Saleh";
		String usrName2 = "Khaled";
		String usrName3 = "Fahad";
		
		int books1 = 0, books2 = 0, books3 = 0, activeBooks = 0, return1 = 0, return2 = 0, return3 = 0, activeReturn = 0, adminBorrow = 0, adminReturn = 0;
		double fees1 = 0, fees2 = 0, fees3 = 0, activeFees = 0.0, adminFees = 0.0;


		
		// Welcome message when the program starts
		System.out.println("\n\nWelcome to the library simulator!\n");

		int selection;
		do
		{
			// Menu selection screen to choose the type of login or exit
			System.out.println("\n1. Select a user account.\n2. Login as Adminstrator.\n3. Exit the program.\n\n");

			// Check if input is an integer..
			if (read.hasNextInt())
			{
				// If integer, then accept it as value
				selection = read.nextInt();
				read.nextLine();
			}
			else
			{
				// If not integer, then display error message then reiterate back to the menu screen
				System.out.println("\n\t*** Invalid input. Please enter a number from the menu. ***\n");
				read.nextLine();
				selection = 0;
				continue;
			}
			
			if (selection == 1)
			{
				// Selection screen to select the user account for this session
				System.out.printf("\nOption\tID\tName\n1.\t%d\t%s\n2.\t%d\t%s\n3.\t%d\t%s\n\n", id1, usrName1, id2, usrName2, id3, usrName3);
				
				int account = 0;
				if (read.hasNextInt())
				{
					account = read.nextInt();
					read.nextLine();
				}
				else
				{
					System.out.println("\n\tInvalid input. Please enter a number from the menu.\n");
					read.nextLine();
					account = 0;
					continue;
				}
				
				switch (account)
				{
					// In the case of the first account, etc.
					// Update the active session variables to the selected account values.
					case 1:
						activeId = id1;
						activeBooks = books1;
						activeReturn = return1;
						activeFees = fees1;
						break;

					case 2:
						activeId = id2;
						activeBooks = books2;
						activeReturn = return2;
						activeFees = fees2;
						break;

					case 3:
						activeId = id3;
						activeBooks = books3;
						activeReturn = return3;
						activeFees = fees3;
						break;

					default:
						// If input is an integer but not one from the options, then display error saying such and reiterate back to the selection screen
						System.out.println("\nError. Enter a number from the selection screen..\n");
						continue;
				}
				
				// Initialise the session-wide variables to the base case of '0'
				int borrowTotal = 0, returnTotal = 0;
				double feesTotal = 0.0;

				// Menu for the user opeations menu.
				int userSelection;
				do
				{
					System.out.println("\n\n1. View Borrowed Books Count.\n2. Borrow Book.\n3. Return Book.\n4. View Session Summary.\n5. Exit to main menu.\n");
					if (read.hasNextInt())
					{
						userSelection = read.nextInt();
						read.nextLine();
					}
					else
					{
						System.out.println("\n\tInvalid input. Please enter a number from the menu.");
						read.nextLine();
						userSelection = 0;
						continue;
					}
					
					// View Borrowed Books Count
					if (userSelection == 1)
					{
						System.out.printf("\nYour currently owned books are: %d", activeBooks);
					}
					
					// Borrow Book
					else if (userSelection == 2)
					{
						if (activeBooks >= 5)
						{
							System.out.println("\nYou can't have more than 5 books.");
						}
						else
						{
							activeFees += 0.5;
							feesTotal += 0.5;
							adminFees += 0.5;
							activeBooks += 1;
							borrowTotal += 1;
							adminBorrow += 1;
						}	
					}


					// Return Book
					else if (userSelection == 3)
					{
						if (activeBooks == 0)
						{
							System.out.println("\nYou can't return books if you don't have any.");
						}
						else
						{
							activeBooks -= 1;
							returnTotal += 1;
							adminReturn += 1;
						}
					}
					
					// View Session Summary
					else if (userSelection == 4)
					{
						System.out.printf("\nNumber of books borrowed: %d\nNumber of books returned: %d\nTotal fees: %.2f", borrowTotal, returnTotal, feesTotal);
					}

					else if (userSelection == 5)
					{
						System.out.println("\nExiting..\n");
					}
			

					else
					{
						System.out.println("\nError, please type a number representing the option you would like.");
					}
					
					
					
				}
				while (userSelection != 5); // Exit when 5 is selected.

				// Update currently selected user's data with the active session's data.
				
				if (activeId == id1)
				{
					books1 = activeBooks;
					return1 = activeReturn;
					fees1 = activeFees;
				}
				else if (activeId == id2)
				{
					books2 = activeBooks;
					return2 = activeReturn;
					fees2 = activeFees;
				}
				else // active id == id3
				{
					books3 = activeBooks;
					return3 = activeReturn;
					fees3 = activeFees;
				}
			}

			// Administrator Menu
			else if (selection == 2)
			{
				System.out.println("\nWelcome to Admin Page.");
				int adminSelection = 0;
				do
				{
					// Adminstrator functions
					System.out.println("\n1. View total Revnue.\n2. Most frequent Operation.\n3. Exit.\n");
					if (read.hasNextInt())
					{
						adminSelection = read.nextInt();
						read.nextLine();
					}
					else
					{
						System.out.println("\n\tInvalid input. Please enter a number from the menu.\n");
						read.nextLine();
						adminSelection = 0;
						continue;
					}
					// View Total Revenue
					if (adminSelection == 1)
					{
						System.out.printf("\nTotal fees of all book borrow operations: %.2f\n", (adminFees));
					}
					// Determine Most Frequent Operations
					else if (adminSelection == 2)
					{
						if (adminBorrow > adminReturn)
						{
							System.out.println("\nThe borrows are more common, and they are: " + adminBorrow);
						}
						else if (adminReturn > adminBorrow)
						{
							System.out.println("\nThe returns are more common, and they are: " + adminReturn);
						}
						else
						{
							System.out.println("\nThe return and borrow operations are the same.\n- Borrow operations: " + adminBorrow + "\n- Return operations: " + adminReturn);
						}
						System.out.println();
					}

					else if (adminSelection == 3)
					{
						System.out.println("\nExiting..\n");
					}
					
					else 
					{
						System.out.println("\nError, please type a number representing the option you would like.");
					}
					
				} while (adminSelection != 3); // Exit on option 3
			}

			else if (selection == 3)
			{
				System.out.println("\nExiting..\n");
			}
			
			else
			{
				System.out.println("\nError, please type a number representing the option you would like.");
			}
			
			
		} while (selection!=3);
		

		// Good practice to close the scanner
		read.close();
	}

}