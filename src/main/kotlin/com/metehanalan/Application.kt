package com.metehanalan

import com.metehanalan.anagram.AnagramCheckerImpl
import java.util.Scanner

class Application {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val anagramChecker = AnagramCheckerImpl()
            val scanner = Scanner(System.`in`)

            while (true) {
                println(
                    """
                        Please choose an option:
                        1. Check if two texts are anagrams
                        2. Find all anagrams for a given string
                        3. Exit the application
                    """.trimIndent()
                )
                print("Enter your choice: ")

                when (scanner.nextInt()) {
                    1 -> {
                        println("Enter first text:")
                        val text1 = scanner.next()
                        println("Enter second text:")
                        val text2 = scanner.next()
                        val areAnagrams = anagramChecker.isAnagram(text1, text2)
                        println("Result: Texts are ${if (areAnagrams) "" else "not "}anagrams of each other")
                    }

                    2 -> {
                        println("Enter a string to find anagrams:")
                        val input = scanner.next()
                        val anagrams = anagramChecker.findAnagrams(input)
                        println("Anagrams for \"$input\": $anagrams")
                    }

                    3 -> {
                        println("Exiting...")
                        return
                    }

                    else -> println("Invalid option. Please choose again.")
                }
            }
        }
    }
}
