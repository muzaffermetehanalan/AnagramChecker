# Anagram Checker

An interactive Kotlin application that provides two features:

1. Check if two texts are anagrams of each other.
2. Find all anagrams for a given string.

## Features

### Check if Two Texts are Anagrams

This feature allows the user to input two texts and determines whether they are anagrams of each other. Anagrams are words or phrases formed by rearranging the letters of another word or phrase, typically using all the original letters exactly once.

### Find All Anagrams for a Given String

This feature enables the user to input a string and retrieves all known anagrams for that string. The application maintains a cache of previously checked anagrams to improve performance.

## Usage

1. Clone the repository to your local machine.
2. Ensure you have Kotlin and Maven installed.
3. Run the Maven build command to compile the project:
   ```bash
   mvn clean compile
4. You can afterward run the main method in Application class.


## Dependencies
- Kotlin
- Google Guava (for Multiset support)
- SLF4J (for logging)
- JUnit Jupiter (for testing)