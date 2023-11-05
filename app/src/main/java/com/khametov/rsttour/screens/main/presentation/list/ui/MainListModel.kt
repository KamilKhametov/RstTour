package com.khametov.rsttour.screens.main.presentation.list.ui

import com.khametov.rsttour.common.helpers.ItemUi
import com.khametov.rsttour.screens.main.domain.entity.FlightEntity

sealed class FlightsListModel : ItemUi {

    object Loading : FlightsListModel()

    data class Flight(
        val a: String
    ) : FlightsListModel() {

        companion object {

            fun FlightEntity.map2AdapterItem(): Flight {
                return Flight(
                    a = ""
                )
            }

            fun Flight.map2Entity(): FlightEntity {
                return FlightEntity(
                    a = ""
                )
            }
        }
    }
}
