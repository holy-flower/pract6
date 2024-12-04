package com.example.pract6

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitAPI {
    @GET("16ba-c071-4e5f-9f89")
    fun getAllUsers(): Call<ArrayList<User>>
}

/*
[
  {
    "name": "John Doe",
    "email": "john.doe@example.com",
    "birth_date": "1990-01-01",
    "gender": "Male",
    "age": 33
  },
  {
    "name": "Bob bbb",
    "email": "bob.bbb@example.com",
    "birth_date": "1990-06-09",
    "gender": "Male",
    "age": 37
  }
]
 */