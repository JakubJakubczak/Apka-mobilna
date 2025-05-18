package com.example.myapplication

import com.example.myapplication.models.Book
import com.example.myapplication.ui.screens.filterBooksByGenre
import com.example.myapplication.ui.screens.filterFavouriteBooks
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class BookFilterTest {
    @Test
    fun filtersBooksCorrectly() {
        val books = listOf(
            Book("A", 1, "author", "description",  R.drawable.atomowe_nawyki),
            Book("B", 2, "author", "description",  R.drawable.atomowe_nawyki),
        )
        val result = filterBooksByGenre(books, 1)

        assert(result.size == 1)
        assert(result[0].title == "A")
    }


    @Test
    fun filterFavouriteBooks_returnsOnlyFavourites() {
        val books = listOf(
            Book("A", 1, "Author 1", "desc", R.drawable.atomowe_nawyki).apply { isFavouriteState = true },
            Book("B", 1, "Author 2", "desc", R.drawable.atomowe_nawyki).apply { isFavouriteState = false },
            Book("C", 1, "Author 3", "desc", R.drawable.atomowe_nawyki).apply { isFavouriteState = true },
        )

        val result = filterFavouriteBooks(books)

        assertEquals(2, result.size)
        assertTrue(result.all { it.isFavouriteState })
        assertTrue(result.any { it.title == "A" })
        assertTrue(result.any { it.title == "C" })
    }
}