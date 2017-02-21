##**Project-Management-Dynamic**
This project will be developed in Java. Each developer will push to his corresponding branch, and merged at the end for the delivery. All problems will receive all the inputs froma file, and print all the outputs to the terminal.
###Problem 1: *Weird Queries*
For the full explanation of the problem, visit [Code Chef](https://www.codechef.com/problems/SBSTCNT)

For execution, first compile Detective.java, then execute Detective with the txt file for the input as parameter.
     
     javac Detective.java
     java Detective detectiveCase1.txt

As input:

 1. The first line contains M (Quantity of numbers to read) and Q (Quantity of queries to process).
 2. The next line contains M quantity of integers each one separated by a space. This integers represent the array A.
 3. Then, a Q quantity of lines follow, each one containing a query. Each query consist of four integers: l, r, n, k. In that order, each separated by a space.

Example of input:

    5 2
    4 5 4 6 2
    0 3 1 1
    2 2 2 3
The expected output should of Q lines, each one with a unique answer for the query.

Example output:

    480
    1

###Problem 2: *Chef Detective*
For the full explanation of the problem, visit [Code Chef](https://www.codechef.com/problems/CHEFDETE)

As input:

 1. The first line contains the integer N (Quantity of integers to read in the next line).
 2. The next line contains N quantity of integers each one separated by a space. This integers represent the array R, where each integer in the array has as value the position in the array which it responds to.

Example of input:

    6
    0 1 1 2 2 3
    (Note: R1 responds to none, R2 and R3 respond to R1, R4 and R5 respond to R2 and R6 responds to R3)

The expected output should of 1 line, with the indexes of the array R that are the answer.

Example of output:

    4 5 6

###Problem 3: *Task for Alex*
For the full explanation of the problem, visit [Code Chef](https://www.codechef.com/problems/ALEXTASK)

As input:

 1. The first line contains the integer T (Quantity of test cases to process. Each test case consist of 2 input lines).
 2. The first line of the test case contains a single integer N (Quantity of integers, frequencies of sensors, in the next line to process).
 3. The second line of the test case contains N integers. Each integer represents the time it takes to that sensor to send a signal.

Example of input:

    3
    3
    2 3 5
    4
    1 8 7 11
    4
    4 4 5 6

The expected output should of T lines, where each line is the answer for each test case.

Example of output:

    6
    7
    4


