package com.ioase.network

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.e
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressBar = findViewById<ProgressBar>(R.id.pb_home)
        val datasource = NetworkProvider.providesHttpAdapter().create(
            HomeDatasource::class.java)
        datasource.discoverMovie().enqueue(object : Callback<HomeResponse>{
            override fun onResponse(call: Call<HomeResponse>,response:
            Response<HomeResponse>){
                progressBar.visibility = View.GONE

                val results = response.body()?.results
                val itemAdapter = findViewById<RecyclerView>(R.id.rv_home)
                itemAdapter.addItemDecoration(DividerItemDecoration(this@MainActivity,DividerItemDecoration.VERTICAL))
                itemAdapter.adapter = HomeAdapter(results ?: emptyList() )
            }

            override fun onFailure(call: Call<HomeResponse>, t: Throwable){
                Log.e(MainActivity:: class.java.simpleName, "${t.printStackTrace()}")
            }
        })

    }
}
