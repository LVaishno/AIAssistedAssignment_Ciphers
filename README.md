# Project Name
This project is a Java application that implements encryption and decryption algorithms using the Vigenere and Trithemius ciphers.

# Java Version and Testing Framework
The project was developed using Java (version 11.0.19). For testing purposes, the JUnit testing framework was used.

# Code Smells and SOLID/CA Violations
There are no CA or SOLID violations, however there are a few code smells.

The code smell and their reasoning for being there are as follows:
1. Magic Numbers: The number 26 is used frequently since we are dealing with alphabets. This could be made into a constant, however it is not really necessary since only a small part of the algorithm is using it in a computation and it is never changed
2. Switch Statements: There are switch statements being used in the factory class. They were not removed since their presence makes it easier to modify the factory when a new cipher is added. Also they are relatively simple
3. There is some duplicate code in the encryption and decryption logic. It is only a few lines so it didnt seem necessary to extract it. Doing so will also make the code more tedious to read

# New Features
The program is modular enough that a new cipher can be easily added. This is primarily thanks to the use of strategy and factory design patterns.
