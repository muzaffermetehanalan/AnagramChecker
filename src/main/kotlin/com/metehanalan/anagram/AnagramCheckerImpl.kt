package com.metehanalan.anagram

import com.google.common.collect.HashMultiset
import com.google.common.collect.Multiset
import java.util.*

class AnagramCheckerImpl : AnagramChecker{

    private val anagramCache = hashMapOf<Int, HashSet<String>>()

    override fun isAnagram(firstInput: String, secondInput: String): Boolean {
        if (firstInput.length != secondInput.length) {
            return false
        }

        val multiSetFirstInput = firstInput.normalizeInputAndCreateMultiSet()
        val multiSetSecondInput = secondInput.normalizeInputAndCreateMultiSet()

        val firstInputHashCode = multiSetFirstInput.hashCode()
        val secondInputHashCode = multiSetSecondInput.hashCode()

        saveToCache(firstInput, secondInput, firstInputHashCode, secondInputHashCode)

        val areAnagrams = multiSetFirstInput == multiSetSecondInput
        return areAnagrams
    }

    override fun findAnagrams(input: String): Set<String> {
        val hashCode = input.normalizeInputAndCreateMultiSet().hashCode()
        val anagrams = anagramCache[hashCode] ?: emptySet()
        return anagrams
    }


    private fun saveToCache(
        firstInput: String,
        secondInput: String,
        firstInputHashCode: Int,
        secondInputHashCode: Int
    ) {
        anagramCache.getOrPut(firstInputHashCode) { hashSetOf() }.add(firstInput)
        anagramCache.getOrPut(secondInputHashCode) { hashSetOf() }.add(secondInput)
    }


    private fun String.toMultiset(): Multiset<Char> {
        val multiset = HashMultiset.create<Char>()
        this.forEach { char ->
            multiset.add(char)
        }
        return multiset
    }

    private fun String.normalizeInputAndCreateMultiSet() =
        this.lowercase().toMultiset()

}
