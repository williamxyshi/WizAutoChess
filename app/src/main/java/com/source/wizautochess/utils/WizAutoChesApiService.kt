package com.source.wizautochess.utils

import com.source.wizautochess.models.IdModel
import com.source.wizautochess.models.LobbyDataModel
import com.source.wizautochess.models.UsernameModel
import com.source.wizautochess.models.ReadyModel
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * where GET and POST requests are made
 */
interface WizAutoChesApiService {


    /**
     * start call that initializes the game
     */
    @GET("/start")
    fun startCall():
            Observable<IdModel.Result>


    /**
     * add a user to the lobby
     */
    @GET("/lobby/adduser")
    fun addUser(@Query("id") id: String, @Query("username") username: String ):
            Observable<UsernameModel.Result>

    /**
     * get usernames and ready status of all players in the lobby
     */
    @GET("/lobby/getplayers")
    fun getPlayers():
            Observable<LobbyDataModel.Result>

    /**
     * tell the server this user is ready
     */
    @GET("/lobby/ready")
    fun setReady(@Query("id") id: String):
            Observable<ReadyModel.Result>


    companion object {

        //api endpoint URL -> change to AWS endpoint when server is turned on
        private const val awsURL = "http:/flask-env.jjxav9tgia.us-east-2.elasticbeanstalk.com/"
        private const val localURL = "http:/192.168.0.120:5000/"


        fun create(): WizAutoChesApiService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(
                    RxJava2CallAdapterFactory.create())
                .addConverterFactory(
                    GsonConverterFactory.create())
                .baseUrl(localURL)
                .build()

            return retrofit.create(WizAutoChesApiService::class.java)
        }
    }
}