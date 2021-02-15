package com.example.franklinjimenezanchorbook

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.franklinjimenezanchorbook.remoto.Book
import com.example.franklinjimenezanchorbook.remoto.BookDetail
import com.example.franklinjimenezanchorbook.remoto.RetrofitClient
import kotlinx.coroutines.launch

class BookViewModel : ViewModel(){
    private val bookList = MutableLiveData<List<Book>>()
    private lateinit var selected : Book

    fun booklist(): LiveData<List<Book>> = bookList

    fun getBooks() {
        viewModelScope.launch {
            val response = RetrofitClient.retrofitInstance().getBooks()
            Log.d("BookViewModel", "cargando info")

            response.let {
                when (it.isSuccessful) {
                    true -> bookList.value = response.body()
                    false -> Log.d("BookViewModel", "error")
                }
            }
            Log.d("BookViewModel", response.body().toString())
        }
    }


    private val detail = MutableLiveData<BookDetail>()


    fun getBook(): LiveData<BookDetail> = detail


    fun getBook(id: Int) {

        viewModelScope.launch {
            val response = RetrofitClient.retrofitInstance().getBook(id)

            when (response.isSuccessful) {

                true -> detail.value = response.body()
                false -> Log.d("BookViewModel", "error en el detalle ${response.code()}")
            }

        }
    }
    fun setSelected(book: Book) {
        selected = book
    }

    fun getSelected() = selected
}
