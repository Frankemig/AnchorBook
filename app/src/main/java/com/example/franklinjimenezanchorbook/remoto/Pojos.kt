package com.example.franklinjimenezanchorbook.remoto

data class Book(
    val code: Int,
    val author: String,
    val country: String,
    val imageLink: String,
    val language: String,
    val title: String
)

data class BookDetail(
    val id: Int,
    val author: String,
    val country: String,
    val imageLink: String,
    val language: String,
    val link: String,
    val pages: String,
    val title: String,
    val year: String,
    val price: String,
    val lastPrice: String,
    val delivery: Boolean
)