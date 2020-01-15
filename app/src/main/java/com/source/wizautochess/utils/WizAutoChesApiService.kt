package com.source.wizautochess.utils

import com.source.wizautochess.models.IdModel
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * where GET and POST requests are made
 */
interface WizAutoChesApiService {


    /**
     * start call that initializes the game
     */
    @GET("/")
    fun startCall():
            Observable<IdModel.Result>


    /**
     * start call that initializes the game
     */
    @GET("/adduser")
    fun addUser():
            Observable<IdModel.Result>

    companion object {

        //api endpoint URL -> change to AWS endpoint when server is turned on
        private const val baseURL = "http:/flask-env.jjxav9tgia.us-east-2.elasticbeanstalk.com/"

        fun create(): WizAutoChesApiService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(
                    RxJava2CallAdapterFactory.create())
                .addConverterFactory(
                    GsonConverterFactory.create())
                .baseUrl(baseURL)
                .build()

            return retrofit.create(WizAutoChesApiService::class.java)
        }
    }
}