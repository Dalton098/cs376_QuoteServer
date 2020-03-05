### Quote Server

- store multiple files with the genre names has file name
- use “2 Food” format for taking in genre and number of quotes. Take the genre to lower case to make things easy
- loop for number inputted to get quotes
  - https://stackoverflow.com/questions/2218005/how-to-get-a-random-line-of-a-text-file-in-java
  - follow this for reading in random line. randomize a number between 0 and length of the file. Seek to that position. Then seek left till you hit a \n or \r. Store the quotes that have been gotten in a map/arraylist and check if the quote was already grabbed. If already grabbed redo (probably decrement counter of loop)
  - (Could just read in the entire file that is designated by the cmdline instead probably easier)

### Client Server

- Could make menu system that list all the genre’s and a number to select them with. If number selected then can type in the number of quotes you want after genre has been selected.
- With this information then a call is made to the quote server from the client server to pull quotes





### Order to do in

- Random file access (Or just read in whole file)
-  command line file name and loop for number of quotes
  - (Not done via serving yet, just print)
- Simple client and quote server connection
- menu system for client server



