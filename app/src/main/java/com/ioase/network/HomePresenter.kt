package com.ioase.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(private val view: HomeView) {

    fun discoverMovie(){
        view.onShowLoading()

        val datasource = NetworkProvider.providesHttpAdapter().create(HomeDatasource::class.java)
        datasource.discoverMovie().enqueue(object : Callback<HomeResponse>{
            override fun onResponse(call: Call<HomeResponse>, response: Response<HomeResponse>) {
                view.onHideLoading()
                view.onResponse(response.body()?.results ?: emptyList())
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onFailure(call: Call<HomeResponse>, t: Throwable) {
                view.onHideLoading()
                view.onFailure(t)
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

    }
}