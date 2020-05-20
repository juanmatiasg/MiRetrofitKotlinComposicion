package com.example.miretrofit2avanzada

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var mRecyclerView: RecyclerView
    var mAdapter: UserAdapter = UserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun setupRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)

        var llamar = getRetrofit().create(UserApi::class.java)
        llamar.getAllUser().enqueue(object : Callback<List<Users>> {
            override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "No se han cargado los datos", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                if (response.isSuccessful) {
                    val objeto = response.body() as MutableList
                    mAdapter.UserAdapter(objeto, this@MainActivity)
                    mRecyclerView.adapter = mAdapter
                }
            }

        })

    }
}
