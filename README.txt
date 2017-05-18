
/*
 * Name - Satish Kumar
 * 
 * Email ID - skumar34@uncc.edu
 * 
 * Student ID - 800966466
 * 
 * 
 * */


DESCRIPTION OF PROGRAM DESIGN:-
=============================

I have written two separate class to implement LZW Encoder and Decoder algoritm to show that we don't need to transmit the table implemented for Encoder to the Decoder logic.
My program first read the respective input file, apply the given LZW encoder and decoder algorithms separately and finally display the respective output in console as well as write the outputs in files.  

DATA STRUCTURE DESIGN:-
====================== 
I have implemented Hashmap to store the input strings and the respective ASCII value while reading the input file characterwise/bitwise.

For Encoder the implemented Haspmap is in the below format:-
Map<String, Integer> table = new HashMap<String, Integer>();

For Decoder the implemented Haspmap is in the below format:-
Map<Integer, String> table = new HashMap<Integer, String>();

Note:- We can use Arraylist as well for above implementation, but for the shake of better readability and understandabilty I have used Hashmap which facilitate me to stote the data in Key-Value pair.

BREAKDOWN OF FILES:-
===================

LZWEncoder.java --> For LZW Encoding algorithm implementation
LZWDecoder.java --> For LZW Decoding algorithm implementation

input1.txt --> Input file for Encoder
input1.lzw --> Output file for Encoder/Input file for Decoder
input1_decoded.txt --> Output file for Decoder

SUMMARY OF WHAT WORKS IN PROGRAM:-
=================================
My Program is able to read the provided input file and code the content in the required format. It also reads the output of encoder and decode them back to the original input file content.

PROGRAMMING LANGUAGE AND COMPILER VERSION USED:-
===============================================

Programming Language - Java (java version "1.8.0_102")
Compiler Version - javac 1.8.0_101
 
HOW TO RUN THE PROGRAM:-
=======================

For Encoder:-
------------

Step1: Go to src directory where our source code is present

cd C:\WorksapceProject\AlgoAssignment\src

Step 2: Compile the code

javac LZWEncoder.java

Step 3: provide the command line argument

java LZWEncoder input1.txt 12

Step 4: See the output in console and in the output file input1.lzw generated

For Decoder:-
------------

Step1: Go to src directory where our source code is present

cd C:\WorksapceProject\AlgoAssignment\src

Step 2: Compile the code

javac LZWDecoder.java

Step 3: provide the command line argument

java LZWDecoder input1.lzw 12

Step 4: See the output in console and in the output file input1_decoded.txt generated

