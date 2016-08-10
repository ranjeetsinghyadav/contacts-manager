package org.contacts;

import java.util.List;
import java.util.Scanner;

/**
 * Main method or Driver class, Provides console for doing operations for
 * Contacts - add, search
 * 
 * Assumptions: 
 * 
 * 1. I am storing contacts in memory only, Assuming no big data
 * here hence no persistence layer is involved 
 * 
 * 2. Search operation is case sensitive
 * 
 * @author ranjeet singh yadav
 */
public class ContactsManager {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		TernarySearchTree contacts = new TernarySearchTree();

		while (true) {

			System.out.println("1) Add Contact 2) Search 3) Show All Contacts 4) Exit ");

			int choice = 0;

			if (scanner.hasNextLine()) {
				String readString = scanner.nextLine();
				try {
					choice = Integer.parseInt(readString);
				} catch (Exception e) {
					choice = -1;
				}
			}

			switch (choice) {
			case 1:
				System.out.print("Enter Name: ");
				String name = scanner.nextLine();
				contacts.add(name);
				break;
			case 2:
				System.out.print("Enter Name: ");
				String query = scanner.nextLine();
				List<String> result = contacts.search(query);
				if (result != null && !result.isEmpty()) {
					for (String str : result) {
						System.out.println(str);
					}
				} else {
					System.out.println("No matching record found.");
				}
				break;
			case 3:
				System.out.println("All Contacts= " + contacts);
				break;
			case 4:
				System.out.println("Happy Searching !! \n");
				System.exit(0);
				break;
			case -1:
				System.out.println("Please TYPE 1, 2, 3 or 4 ONLY to do one of the following jobs...");
				break;
			default:
				System.out.println("No such Option is available :( ");
				break;
			}

		}
	}
}
