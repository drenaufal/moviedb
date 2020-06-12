package com.ioase.network

interface HomeView {
    fun onShowLoading()
    fun onHideLoading()
    fun onResponse(result: List<Result>)
    fun onFailure(error: Throwable)
}