package uo.mp.lab.minesweeper.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Console {

    protected static BufferedReader kbd = new BufferedReader(
	    new InputStreamReader(System.in));

    public static Integer readInt() {
	try {
	    return Integer.parseInt(kbd.readLine());
	} catch (NumberFormatException nfe) {
	    return null;
	} catch (IOException ioe) {
	    throw new RuntimeException(ioe);
	}
    }

    public static Long readLong() {
	try {

	    return Long.parseLong(kbd.readLine());

	} catch (NumberFormatException nfe) {
	    return null;
	} catch (IOException ioe) {
	    throw new RuntimeException(ioe);
	}
    }

    public static Double readDouble() {
	try {
	    return Double.parseDouble(kbd.readLine());
	} catch (NumberFormatException nfe) {
	    return null;
	} catch (IOException ioe) {
	    throw new RuntimeException(ioe);
	}
    }

    public static String readString() {
	try {
	    return kbd.readLine();
	} catch (IOException e) {
	    throw new RuntimeException(e);
	}
    }

    public static String readString(String msg) {
	String res = "";
	while (res.isEmpty()) {
	    print(msg + ": ");
	    res = readString();
	}
	return res;
    }

    public static Long readLong(String msg) {
	Long res = null;
	while (res == null) {
	    print(msg + ": ");
	    res = readLong();
	}
	return res;
    }

    public static Integer readInt(String msg) {
	Integer res = null;
	while (res == null) {
	    print(msg + ": ");
	    res = readInt();
	}
	return res;
    }

    public static Double readDouble(String msg) {
	Double res = null;
	while (res == null) {
	    print(msg + ": ");
	    res = readDouble();
	}
	return res;
    }

    public static LocalDate readDate(String userInput) {
	String date = Console
	    .readString("Type date to finish the contract (mm/yyyy): ");
	DateTimeFormatter dateFormat = new DateTimeFormatterBuilder()
	    .appendPattern("MM/yyyy")
	    .parseDefaulting(ChronoField.DAY_OF_MONTH, 31)
	    .toFormatter();
	LocalDate parsedDate = LocalDate.parse(date, dateFormat);
	return parsedDate;
    }

    /**
     * Reads an character from the standard input (usually the keyboard)
     * 
     * @return
     */
    public static int readCharacter() {
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(isr);
	int character = 0;
	try {
	    character = br.read();
	} catch (IOException e) {
	    System.out.println("An error has happen with the data input!");
	    System.exit(0);
	}
	return character;
    }

    private static void print(String string) {
	System.out.println(string);
    }
}
