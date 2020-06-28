package com.nobb.sunnyweather.logic

import androidx.lifecycle.liveData
import com.nobb.sunnyweather.logic.model.Place
import com.nobb.sunnyweather.logic.network.SunnyWeatherNetWork
import kotlinx.coroutines.Dispatchers

object Repository {

    fun searchPlaces(query: String) = liveData(Dispatchers.IO){
        var result = try {
            val placeResponse= SunnyWeatherNetWork.searchPlaces(query)
            if (placeResponse.status == "ok"){
                val places = placeResponse.places
                Result.success(places)
            }else{
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        }catch (e:Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result as Result<List<Place>>)
    }

}