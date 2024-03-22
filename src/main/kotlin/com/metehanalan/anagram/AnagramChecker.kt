package com.metehanalan.anagram

interface AnagramChecker {
    fun isAnagram(firstInput: String, secondInput: String): Boolean
    fun findAnagrams(input: String): Set<String>
}
