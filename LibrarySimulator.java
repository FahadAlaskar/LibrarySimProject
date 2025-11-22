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

        int books1 = 0, books2 = 0, books3 = 0;
        int activeBooks = 0, return1 = 0, return2 = 0, return3 = 0;
        int activeReturn = 0, adminBorrow = 0, adminReturn = 0;
        double fees1 = 0, fees2 = 0, fees3 = 0;
        double activeFees = 0.0, adminFees = 0.0;

        System.out.println("\n\nWelcome to the library simulator!\n");

        int selection;

        do {
            System.out.println("\n1. Select a user account.\n2. Login as Adminstrator.\n3. Exit the program.\n");

            if (read.hasNextInt()) {
                selection = read.nextInt();
                read.nextLine();
            } else {
                System.out.println("\nInvalid input. Please enter a valid number.\n");
                read.nextLine();
                selection = 0;
                continue;
            }

            if (selection == 1)
            {
                System.out.println(
                    "\nOption\tID\tName\n" +
                    "1.\t" + id1 + "\t" + usrName1 + "\n" +
                    "2.\t" + id2 + "\t" + usrName2 + "\n" +
                    "3.\t" + id3 + "\t" + usrName3 + "\n"
                );

                int account = 0;

                if (read.hasNextInt()) {
                    account = read.nextInt();
                    read.nextLine();
                } else {
                    System.out.println("\nInvalid input.\n");
                    read.nextLine();
                    account = 0;
                    continue;
                }

                switch (account)
                {
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
                        System.out.println("\nError. Enter a valid selection.\n");
                        continue;
                }

                int borrowTotal = 0, returnTotal = 0;
                double feesTotal = 0.0;
                int userSelection;

                do {
                    System.out.println(
                        "\n1. View Borrowed Books Count.\n" +
                        "2. Borrow Book.\n" +
                        "3. Return Book.\n" +
                        "4. View Session Summary.\n" +
                        "5. Exit to main menu.\n"
                    );

                    if (read.hasNextInt()) {
                        userSelection = read.nextInt();
                        read.nextLine();
                    } else {
                        System.out.println("\nInvalid input.\n");
                        read.nextLine();
                        userSelection = 0;
                        continue;
                    }

                    if (userSelection == 1)
                    {
                        System.out.println("\nYour currently owned books are: " + activeBooks);
                    }
                    else if (userSelection == 2)
                    {
                        if (activeBooks >= 5) {
                            System.out.println("\nYou can't borrow more than 5 books.");
                        } else {
                            activeFees += 0.5;
                            feesTotal += 0.5;
                            adminFees += 0.5;

                            activeBooks += 1;
                            borrowTotal += 1;
                            adminBorrow += 1;
                        }
                    }
                    else if (userSelection == 3)
                    {
                        if (activeBooks == 0) {
                            System.out.println("\nYou have no books to return.");
                        } else {
                            activeBooks -= 1;
                            returnTotal += 1;
                            adminReturn += 1;
                        }
                    }
                    else if (userSelection == 4)
                    {
                        System.out.println(
                            "\nNumber of books borrowed: " + borrowTotal +
                            "\nNumber of books returned: " + returnTotal +
                            "\nTotal fees: " + feesTotal
                        );
                    }
                    else if (userSelection == 5)
                    {
                        System.out.println("\nExiting to main menu...\n");
                    }
                    else
                    {
                        System.out.println("\nInvalid option.\n");
                    }

                } while (userSelection != 5);

                if (activeId == id1) {
                    books1 = activeBooks;
                    return1 = activeReturn;
                    fees1 = activeFees;
                } else if (activeId == id2) {
                    books2 = activeBooks;
                    return2 = activeReturn;
                    fees2 = activeFees;
                } else {
                    books3 = activeBooks;
                    return3 = activeReturn;
                    fees3 = activeFees;
                }

            }
            else if (selection == 2)
            {
                System.out.println("\nWelcome to Admin Page.");

                int adminSelection = 0;

                do {
                    System.out.println(
                        "\n1. View total Revenue.\n" +
                        "2. Most frequent Operation.\n" +
                        "3. Exit.\n"
                    );

                    if (read.hasNextInt()) {
                        adminSelection = read.nextInt();
                        read.nextLine();
                    } else {
                        System.out.println("\nInvalid input.\n");
                        read.nextLine();
                        adminSelection = 0;
                        continue;
                    }

                    if (adminSelection == 1)
                    {
                        System.out.println("\nTotal fees collected: " + adminFees);
                    }
                    else if (adminSelection == 2)
                    {
                        if (adminBorrow > adminReturn) {
                            System.out.println("\nMost frequent operation: Borrow (" + adminBorrow + ")");
                        }
                        else if (adminReturn > adminBorrow) {
                            System.out.println("\nMost frequent operation: Return (" + adminReturn + ")");
                        }
                        else {
                            System.out.println(
                                "\nBorrow and Return operations are equal.\n" +
                                "Borrows: " + adminBorrow + "\nReturns: " + adminReturn
                            );
                        }
                    }
                    else if (adminSelection == 3)
                    {
                        System.out.println("\nExiting Admin Menu...\n");
                    }
                    else {
                        System.out.println("\nInvalid selection.\n");
                    }

                } while (adminSelection != 3);
            }
            else if (selection == 3)
            {
                System.out.println("\nExiting program...\n");
            }
            else
            {
                System.out.println("\nInvalid option.\n");
            }

        } while (selection != 3);

        read.close();
    }
}
