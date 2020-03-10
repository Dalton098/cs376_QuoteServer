import java.net.*;
import java.io.*;

/**
 * Quote Client
 * Takes in command line argument of the form [numQuotes] [genre] when called
 * and interfaces with the QuoteServer to retrieve quotes from the files included
 * in the submission. Then prints out the retrieved quotes
 * 
 * Instructions:
 * -   To compile the file run javac QuoteClient.java 
 *      from a terminal while in the directory containing the file
 * -   NOTE: The QuoteServer should be running before attempting to run the client
 * -   To run the file (after it has been compiled): java QuoteClient [numQuotes] [genre]
 * 
 * CS 376
 * 3/10/2020
 * @author Dalton Rothenberger
 */
public class QuoteClient {

    public static void main(String[] args) {

        int numInputs = 2;
        if (args.length == numInputs) {

            int numQuotes = Integer.parseInt(args[0]);
            String genre = args[1].toLowerCase();

            try {

                // make connection to server socket
                Socket sock = new Socket("127.0.0.1", 6013);

                // Output to server
                PrintWriter out = new PrintWriter(sock.getOutputStream(), true);

                // Input from server
                BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));

                // Sending number of quotes and genre to server
                sendMessage(out, Integer.toString(numQuotes));
                sendMessage(out, genre);

                // Printing the quotes from the server
                printQuotes(in, numQuotes);

                // Close the socket connection
                sock.close();
            } catch (IOException ioe) {
                System.out.println("Error in client: An exception has occurred.");
            }

        } else {
            System.out.println(
                    "Error in client: Expected inputs format is as follows: java QuoteClient [numQuotes] [genre]");
        }

    }

    /**
     * Will communicate with the server and send the genre requested to the server
     * 
     * @param out     The print writer that is connected to the server
     * @param message The message that is being sent to the server
     * @throws IOException
     */
    public static void sendMessage(PrintWriter out, String message) throws IOException {
        out.println(message);
    }

    /**
     * Will read in the quotes from the server until the number of quotes has been
     * reached or till null has been hit
     * 
     * @param in        The buffered reader that is connected to the server
     * @param numQuotes The number of quotes to print from the server
     * @throws IOException
     */
    public static void printQuotes(BufferedReader in, int numQuotes) throws IOException {
        String line;
        int i = 0;
        while ((line = in.readLine()) != null && i < numQuotes) {
            System.out.println(line);
            i++;
        }
    }

}