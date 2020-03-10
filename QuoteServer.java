import java.net.*;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

/**
 * Quote Server
 * Interacts with the QuoteClient to determine how many quotes it needs to 
 * retrieve and what genre to pull the quotes from. Uses the quote files 
 * included with submission to retrieve quotes. Sends a string of the quotes
 * back to the client so that the client can print the quotes.
 * 
 * Instructions:
 * -   To compile the file run: javac QuoteServer.java
 *      from a terminal while in the directory containing the file
 * -   To run the file (after it has been compiled): java QuoteServer &
 *      The & puts the QuoteServer in the background
 * 
 * CS 376
 * 3/10/2020
 * @author Dalton Rothenberger
 */
public class QuoteServer {

    public static void main(String[] args) {
        
        try {
            ServerSocket sock = new ServerSocket(6013);

            // Listening for connections
            while (true) {

                Socket client = sock.accept();

                // Output to client
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                // Input from client
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

                // Getting numQuotes and genre from the client
                int numQuotes = Integer.parseInt(in.readLine());
                String genre = in.readLine();

                // Checking if a file exist for inputted genre
                File temp = new File(genre+".txt");
                if (temp.exists()) {

                    // Reading in the file and getting quotes
                    ArrayList<String> lines = readGenreQuotes(genre);
                    String quotes = getQuotes(lines, numQuotes);

                    // Sending quotes back to the client
                    out.println(quotes);

                    // Closing the socket and resuming
                    client.close();

                } else {
                    out.println("Error in server: Genre type does not exist\n");
                }

            }

        } catch (Exception ioe) {
            System.err.println("Error in server: An exception has occurred.");
        }
    }

    /**
     * Reads in the genre file specifed from the client
     * 
     * @param genre The genre which is used to determine the file to read in
     * @return An string arraylist containing all the quotes from the file
     * @throws Exception
     */
    public static ArrayList<String> readGenreQuotes(String genre) throws Exception {

        ArrayList<String> toReturn = new ArrayList<String>();

        String fileName = genre + ".txt";
        File file = new File(fileName);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        while ((line = br.readLine()) != null) {
            toReturn.add(line);
        }

        br.close();
        return toReturn;
    }

    /**
     * Retrieves the number of quotes specified from the client and appends it all
     * into one string
     * 
     * @param lines     The array list containing the lines from the quote file
     * @param numQuotes The number of quotes to be collected
     * @return A string of the quotes appended together
     */
    public static String getQuotes(ArrayList<String> lines, int numQuotes) {

        String toReturn = "";

        Random random = new Random();

        for (int i = 0; i < numQuotes; i++) {
            int randomInt = random.nextInt(lines.size());
            toReturn += lines.get(randomInt) + "\n";
        }

        return toReturn;
    }

}