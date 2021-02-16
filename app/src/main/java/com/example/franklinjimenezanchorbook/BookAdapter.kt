package com.example.franklinjimenezanchorbook

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.franklinjimenezanchorbook.databinding.ItemListBinding
import com.example.franklinjimenezanchorbook.remoto.Book
import com.squareup.picasso.Picasso

class BookAdapter: RecyclerView.Adapter<BookAdapter.BookVH>() {

    private val selectedItem = MutableLiveData<Book>()
    private var bookList = listOf<Book>()
    fun selectedItem(): LiveData<Book> = selectedItem


    class BookVH(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(book: Book?) {

            binding.tvTitle.text = book?.title

            Picasso.get().load(book?.imageLink)
                .resize(200, 300)
                .placeholder(R.drawable.ic_idea_comodin)
                .centerCrop()
                .into(binding.imageView)
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookVH {
        val binding=ItemListBinding.inflate(LayoutInflater.from(parent.context))

        return BookVH(binding)
    }

    override fun onBindViewHolder(holder: BookVH, position: Int) {
        val book= bookList[position]
        holder.bind(book)
        holder.itemView.setOnClickListener {
            selectedItem.value = book

        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }
    fun update(booklist: List<Book>) {
        bookList = booklist
        notifyDataSetChanged()
    }
}