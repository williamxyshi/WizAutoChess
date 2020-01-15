package com.source.wizautochess.utils

import android.graphics.ColorSpace
import com.source.wizautochess.models.ResultModel
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

/**
 * where GET and POST requests are made
 */
interface WizAutoChesApiService {


    /**
     * basic testcall that sees if server returns a response
     */
    @GET("/")
    fun testCall():
            Observable<ResultModel.Result>


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