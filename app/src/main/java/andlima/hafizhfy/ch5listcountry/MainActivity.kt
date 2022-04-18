package andlima.hafizhfy.ch5listcountry

import andlima.hafizhfy.ch5listcountry.adapter.AdapterCountry
import andlima.hafizhfy.ch5listcountry.model.GetAllCountryResponseItem
import andlima.hafizhfy.ch5listcountry.network.ApiClient
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getDataCountry()
    }

    fun getDataCountry() {
        ApiClient.instance.getAllCountry()
            .enqueue(object : retrofit2.Callback<List<GetAllCountryResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllCountryResponseItem>>,
                    response: Response<List<GetAllCountryResponseItem>>
                ) {
                    if (response.isSuccessful) {
                        val dataCountry = response.body()

                        val adapter = AdapterCountry(dataCountry!!)
                        val lm = LinearLayoutManager(
                            applicationContext,
                            LinearLayoutManager.VERTICAL,
                            false
                        )
                        rv_country.layoutManager = lm
                        rv_country.adapter = adapter
                    } else {
                        Toast.makeText(
                            this@MainActivity,
                            response.message(),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                override fun onFailure(call: Call<List<GetAllCountryResponseItem>>, t: Throwable) {
                    Toast.makeText(
                        this@MainActivity,
                        t.message,
                        Toast.LENGTH_LONG
                    ).show()
                }

            })
    }
}