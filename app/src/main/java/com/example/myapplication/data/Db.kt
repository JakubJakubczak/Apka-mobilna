//package com.example.myapplication.data
//
//import androidx.room.*
//import kotlinx.coroutines.flow.Flow
//
//@Entity(tableName = "genres")
//data class GenreEntity(
//    @PrimaryKey(autoGenerate = true) val id: Int = 0,
//    val name: String
//)
//
//@Entity(
//    tableName = "books",
//    foreignKeys = [ForeignKey(
//        entity = GenreEntity::class,
//        parentColumns = ["id"],
//        childColumns = ["genreId"],
//        onDelete = ForeignKey.CASCADE
//    )]
//)
//data class BookEntity(
//    @PrimaryKey(autoGenerate = true) val id: Int = 0,
//    val title: String,
//    val genreId: Int,
//    val isFavourite: Boolean = false
//)
//
//@Dao
//interface BookDao {
//    @Query("SELECT * FROM genres")
//    fun getAllGenres(): Flow<List<GenreEntity>>
//
//    @Query("SELECT * FROM books WHERE genreId = :genreId")
//    fun getBooksForGenre(genreId: Int): Flow<List<BookEntity>>
//
//    @Query("SELECT * FROM books WHERE isFavourite = 1")
//    fun getFavouriteBooks(): Flow<List<BookEntity>>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertGenre(genre: GenreEntity)
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertBook(book: BookEntity)
//
//    @Update
//    suspend fun updateBook(book: BookEntity)
//
//    @Delete
//    suspend fun deleteBook(book: BookEntity)
//}
//
//@Database(entities = [GenreEntity::class, BookEntity::class], version = 1)
//abstract class BookDatabase : RoomDatabase() {
//    abstract fun bookDao(): BookDao
//}
//
//
