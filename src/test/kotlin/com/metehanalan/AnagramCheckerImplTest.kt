package com.metehanalan

import com.metehanalan.anagram.AnagramCheckerImpl
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AnagramCheckerImplTest {

    private val anagramChecker = AnagramCheckerImpl()

    @Test
    fun `should return true when inputs are anagrams`() {
        assertTrue(anagramChecker.isAnagram("listen", "silent"))
    }

    @Test
    fun `should return false when the inputs are not anagrams`() {
        assertFalse(anagramChecker.isAnagram("hello", "world"))
    }

    @Test
    fun `should return true when inputs are different case but anagrams`() {
        assertTrue(anagramChecker.isAnagram("LiStEn", "SIlEnT"))
    }

    @Test
    fun `should return correct list when call find anagrams once`() {
        anagramChecker.isAnagram("listen", "silent")
        assertEquals(setOf("listen", "silent"), anagramChecker.findAnagrams("lesint"))
    }

    @Test
    fun `should return empty when no anagrams are found`() {
        assertEquals(emptySet<String>(), anagramChecker.findAnagrams("hello"))
    }

    @Test
    fun `should return correct lists when call find anagrams twice with different input`() {
        anagramChecker.isAnagram("listen", "silent")
        anagramChecker.isAnagram("train", "intra")
        assertEquals(setOf("listen", "silent"), anagramChecker.findAnagrams("SILTEN"))
        assertEquals(setOf("train", "intra"), anagramChecker.findAnagrams("ARTIN"))

    }
}
