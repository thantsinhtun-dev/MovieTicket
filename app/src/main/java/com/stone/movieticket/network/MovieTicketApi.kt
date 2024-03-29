package com.stone.movieticket.network

import com.google.gson.Gson
import com.stone.movieticket.data.vos.CheckOutVO
import com.stone.movieticket.network.responses.*
import com.stone.movieticket.utils.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*

interface MovieTicketApi {

    @FormUrlEncoded
    @POST(API_REGISTER)
    fun registerWithEmail(
        @Field(PARAM_NAME) name: String,
        @Field(PARAM_EMAIL) email: String,
        @Field(PARAM_PHONE) phone: String,
        @Field(PARAM_PASSWORD) password: String,
    ): Call<UserInfoResponse>

    @FormUrlEncoded
    @POST(API_LOGIN)
    fun loginWithEmail(
        @Field(PARAM_EMAIL) email: String,
        @Field(PARAM_PASSWORD) password: String,
    ): Call<UserInfoResponse>

    //    @GET(API_GET_PROFILE)
//    fun getProfile(
//        @Header(PARAM_AUTHORIZATION) token: String,
//    ): Call<ProfileResponse>
    @GET(API_PROFILE)
    fun getProfile(
        @Header(PARAM_AUTHORIZATION) token: String,
    ): Call<RegisterResponse>

    @GET(API_GET_NOW_SHOWING)
    fun getNowShowingMovie(
        @Query(PARAM_STATUS) status: String = "current"
    ): Call<MovieListResponse>

    @GET("$API_MOVIE_DETAIL/{movie_id}")
    fun getMovieDetailById(
        @Path("movie_id") movieId: String
    ): Call<MovieDetailResponse>


    @POST(API_LOGOUT)
    fun logout(
        @Header(PARAM_AUTHORIZATION) token: String,
    ): Call<RegisterResponse>

    @GET(API_CINEMA_TIME_SLOT)
    fun getTimeSlotByDate(
        @Header(PARAM_AUTHORIZATION) token: String,
        @Query(PARAM_DATE) date: String,
        @Query(PARAM_MOVIE_ID) movieId: String
    ): Call<CinemaResponse>

    @GET(API_MOVIE_SEAT)
    fun getMovieSeats(
        @Header(PARAM_AUTHORIZATION) token: String,
        @Query(PARAM_CINEMA_TIMESLOT_ID) timeSlotId: String,
        @Query(PARAM_BOOKING_DATE) bookingDate: String
    ): Call<MovieSeatResponse>

    @GET(API_SNACK)
    fun getSnacks(
        @Header(PARAM_AUTHORIZATION) token: String,
    ): Call<SnackResponse>

    @GET(API_PAYMENT)
    fun getPaymentMethod(
        @Header(PARAM_AUTHORIZATION) token: String,
    ): Call<PaymentResponse>

    @FormUrlEncoded
    @POST(API_CARD)
    fun createCard(
        @Header(PARAM_AUTHORIZATION) token: String,
        @Field(PARAM_CARD_NUMBER) cardNumber: String,
        @Field(PARAM_CARD_HOLDER) cardHolder: String,
        @Field(PARAM_EXPIRATION_DATE) expirationDate: String,
        @Field(PARAM_CVC) cvc: String,
    ): Call<CardResponse>

    @Headers("Content-Type: application/json")
    @POST(API_CHECKOUT)
    fun checkOut(
        @Header(PARAM_AUTHORIZATION) token: String,
        @Body checkOut: CheckOutVO
    ): Call<CheckOutResponse>

}