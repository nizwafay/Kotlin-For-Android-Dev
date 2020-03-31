package com.example.kotlinforandroiddev.domain.commands

interface Command<out T> {
    suspend fun execute(): T
}