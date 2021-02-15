package com.example.franklinjimenezanchorbook.remoto

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BooksAPI {
  @GET("books")
  suspend fun getBooks() : Response<List<Book>>

  @GET("books/{bookId}")
    suspend fun getBook(@Path("bookId") id: Int) : Response<BookDetail>

}