/*
 * creates a Book class
 *
 * --Alexander Jessop--
 */

import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Book implements Comparable<Book>
{
    private static Set<String> bannedTitles = new HashSet<>();
    private static int count = 0;

    private String title;
    private int pages;
    private String color;

    public Book() {
        this("Unknown", 0, "Unknown");
    }

    public Book(String title, int pages, String color) {
        this.title = title;
        this.pages = pages;
        this.color = color;
        count++;
    }

    public static void addBannedTitle(String title) {
        bannedTitles.add(title);
    }

    public static Set<String> bannedBooks() {
        return bannedTitles;
    }

    public static int numberOfBooks() {
        return count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean hasSamePages(Book other) {
        return this.pages == other.pages;
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book other = (Book) obj;
        return title.equals(other.title) && pages == other.pages && color.equals(other.color);
    }

    @Override
    public int compareTo(Book other) {
        return Integer.compare(this.pages, other.pages);
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Pages: " + pages + ", Color: " + color;
    }
}

