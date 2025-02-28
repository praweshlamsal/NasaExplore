import com.example.nasaexplorer.data.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NasaApi {
//    private val retrofit = Retrofit.Builder()
//        .baseUrl("https://api.nasa.gov/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()

//    val apiService: ApiService = retrofit.create(ApiService::class.java)
    val retrofitService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}