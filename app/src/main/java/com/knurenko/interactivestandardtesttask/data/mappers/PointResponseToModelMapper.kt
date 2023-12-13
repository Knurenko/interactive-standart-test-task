package com.knurenko.interactivestandardtesttask.data.mappers

import com.knurenko.interactivestandardtesttask.data.model.PointResponse
import com.knurenko.interactivestandardtesttask.domain.model.PointModel

/**
 * @author Knurenko Bogdan 12.12.2023
 */
class PointResponseToModelMapper {
    fun map(response: PointResponse): PointModel = PointModel(
        x = response.x,
        y = response.y
    )
}