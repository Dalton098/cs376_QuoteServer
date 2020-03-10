## Programming Assignment #1: Analysis

##### Dalton Rothenberger

##### CS 376 - Operating Systems



#### Reading in on Startup vs. Randomly Accessing During Run Time

​	Reading the file in on startup some advantages over randomly accessing the file during run time. In terms of runtime loading the file in on startup takes more time because you have to load every line of the file. Having the file loading into the program however does provide the benefit of being easier to manipulate for the programmer because they have direct access to it as a variable now. In terms of space, loading the whole file takes more space up as well because you are loading every line in from the file instead of only what you need so you will end of with extra lines that are never used. One of the biggest benefits of loading in the whole file at start up is that you free up other operating system resources. Once all the data has been loaded into RAM, then the disk memory no longer needs to be accessed and as a result frees up the disk controller.

​	Randomly accessing the file during run time has advantages over reading in on startup. In terms of run time, randomly accessing the file is faster because instead of loading in the entire file and potentially loading in lines from the file that will never be used, the program is only loading in exactly as much as it needs. However, randomly accessing a file is more difficult for the programmer to work with. The programmer must implement some form of random sampling from the file instead of storing it in something such as an ArrayList. Java provides a RandomAccessFile API but for me personally I was more familiar with ArrayList so they were easier for me to work with. Also, this leads to an advantage in terms of space in comparison to reading the whole file in as well. The program only loads in the necessary amount of data and nothing more so it minimizes the use of space. One disadvantage of randomly accessing the file is that it takes up more operating system resources than reading in on start up. The disk controller is used every time an access needs to be made to the file whereas in reading on startup can access the copied version of the file without bothering the disk controller.

#### Implementation: OS Class vs. Large Internet Environment

​	In the context of an OS class environment I personally chose to implement reading in on startup. I chose this method because it was easier for me to program and the program is of a small enough scale that the disadvantages of this method do not outweigh the benefit of it being easier for me to code.

​	In the context of a large internet environment randomly accessing the file during run time would be much better. This is especially true when thinking about including various genres of quotes. My implementation of the various quotes was to have separate text files for each genre so randomly accessing them is much more efficient because the program does not have to load a different file for each request. Rather it would access the specified file and read in the quotes it needs. The added difficulty in programming is outweighed but the efficiency gains from the random accessing.