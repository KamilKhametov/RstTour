package com.khametov.rsttour.network.error.parsing

import com.khametov.rsttour.network.error.parsing.NetworkErrorModel
import kotlinx.serialization.SerialName

data class NetworkErrorResponse(
    @SerialName("error") val errorModel: NetworkErrorModel,
)
