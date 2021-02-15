package com.example.franklinjimenezanchorbook.remoto

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://my-json-server.typicode.com/Himuravidal/anchorBooks/"
class RetrofitClient {
    companion object {
        fun retrofitInstance(): BooksAPI {
            val retrofit = Retrofit.Builder()

                .baseUrl(BASE_URL)

                .addConverterFactory(GsonConverterFactory.create())

                .build()

            return retrofit.create(BooksAPI::class.java)
        }
    }
}