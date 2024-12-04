package com.example.pract6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class DatabaseActivity : AppCompatActivity() {
    lateinit var userRV: RecyclerView
    lateinit var userAdapter: UserAdapter
    @Inject
    lateinit var db: AppDatabase
    lateinit var userList: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database)

        userRV = findViewById(R.id.idRVUsers)
        //db = AppDatabase.getDatabase(this)

        userList = ArrayList()
        loadUsersFromDatabase()
    }

    private fun loadUsersFromDatabase() {
        lifecycleScope.launch(Dispatchers.IO) {
            val usersFromDb = db.userDao().getAllUsers()
            userList.addAll(usersFromDb)

            withContext(Dispatchers.Main) {
                userAdapter = UserAdapter(userList)
                userRV.adapter = userAdapter
            }
        }
    }
}