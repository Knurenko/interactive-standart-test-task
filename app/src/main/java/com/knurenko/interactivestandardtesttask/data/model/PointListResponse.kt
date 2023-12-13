package com.knurenko.interactivestandardtesttask.data.model

import com.google.gson.annotations.SerializedName

/**
 * @author Knurenko Bogdan 12.12.2023
 */
data class PointListResponse(
    @SerializedName("points")
    val points: List<PointResponse>
)
