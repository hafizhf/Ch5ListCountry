package andlima.hafizhfy.ch5listcountry.network

import andlima.hafizhfy.ch5listcountry.model.GetAllCountryResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("all")
    fun getAllCountry() : Call<List<GetAllCountryResponseItem>>
}