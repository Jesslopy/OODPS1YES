/* 
 * program to test methods in Book
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;

public class BookTestOne
{
	public static void main (String [] args)
	{
		// get list of banned books
		String [] banned = {"Catcher in the Rye", "To Kill a Mockingbird",
			"Grapes of Wrath"};
		for (int i = 0; i < banned.length; i++)
		{
			Book.addBannedTitle(banned[i]);
		}
		System.out.println("\nWhich books are on the banned book list?");
		System.out.println(Book.bannedBooks());

		// create some book objects
		Book b1 = new Book();
		Book b2 = new Book("Harry Potter and the Philosopher's Stone", 
			223, "brown");
		Book b3 = new Book();
		Book b4 = new Book("Murder on the Orient Express", 212, "yellow");
		Book b5 = new Book("Mastering the Art of French Cooking", 68, "green");
		List<Book> books = new ArrayList<>(Arrays.asList(b1, b2, b3, b4, b5));
		System.out.println("\nThere are " + Book.numberOfBooks() 
			+ " books in our collection:\n");

		// print information about each book
		Iterator<Book> iter = books.iterator();
		while (iter.hasNext())
		{
			Book b = iter.next();
			System.out.println(b.toString() + "\n");
		}

		// view and modify their properties
		System.out.println("What's the title of book 2? ");
		System.out.println(b2.getTitle());
		System.out.println("Let's change it to the American title: ");
		b2.setTitle("Harry Potter and the Sorcerer's Stone");
		System.out.println(b2.getTitle());
		System.out.println("\nHow many pages in book 5? " + b5.getPages());
		System.out.println("That should be 684 pages! ");
		b5.setPages(684);
		System.out.println(b5.getPages());
		System.out.println("\nWhat color is book 4's cover? " +
		b4.getColor());
		System.out.println("The cover is actually white- easily fixed!");
		b4.setColor("white");
		System.out.println(b4.getColor());

		// compare books
		System.out.println("\nDo books 1 and 2 have the same number of "
			+ "pages? " + (b1.hasSamePages(b2) ? "yes" : "no"));
		System.out.println("Do books 1 and 3 have the same number of "
			+ "pages? " + (b1.hasSamePages(b3) ? "yes" : "no"));
		System.out.println("\nAre books 1 and 4 the same? " 
			+ (b1.equals(b4) ? "yes" : "no"));
		System.out.println("Are books 1 and 3 the same? " 
			+ (b1.equals(b3) ? "yes" : "no"));
		System.out.println("\nHere are their hashcodes (for the "
			+ "curious...):");
		System.out.println("1 " + b1.hashCode() + "\n4 " + b4.hashCode()
			+ "\n3 " + b3.hashCode());
		int result = b2.compareTo(b4);
		System.out.println("\nWhich book has more pages, 2 or 4? " 
			+ (result > 0 ? "2" : result < 0 ? "4" : "both the same"));
		result = b2.compareTo(b5);
		System.out.println("Which book has more pages, 2 or 5? " 
			+ (result > 0 ? "2" : result < 0 ? "5" : "both the same"));
		result = b1.compareTo(b3);
		System.out.println("Which book has more pages, 1 or 3? " 
			+ (result > 0 ? "1" : result < 0 ? "3" : "both the same"));

		// add books to different kinds of sets
		System.out.println("\nLet's see what unique books we have");
		System.out.println("Adding books to a ...\n\nlinked set" 
			+ " (in order added)");
		Set<Book> uniqueBooks = new LinkedHashSet<>(books);
		for (Book b : uniqueBooks)
		{
			System.out.printf("%-40s%d\n", b.getTitle(), b.getPages());
		}
		System.out.println("\nhash set (by algorithm)");
		uniqueBooks = new HashSet<>(uniqueBooks);
		for (Book b : uniqueBooks)
		{
				System.out.printf("%-40s%d\n", b.getTitle(), b.getPages());
		}
		System.out.println("\ntree set (sorted by pages)");
		uniqueBooks = new TreeSet<>(uniqueBooks);
		for (Book b : uniqueBooks)
		{
			System.out.printf("%-40s%d\n", b.getTitle(), b.getPages());
		}
	}
}
