package com.knurenko.interactivestandardtesttask.data.network

import com.knurenko.interactivestandardtesttask.data.model.PointListResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Knurenko Bogdan 12.12.2023
 */
interface PointsService {
    @GET("points")
    suspend fun fetchPoints(@Query("count") count: Int): PointListResponse
}