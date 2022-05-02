package net.megastudy.mvvmnavernewspractice_0429

import android.util.Log
import androidx.lifecycle.MutableLiveData
import net.megastudy.mvvmnavernewspractice_0429.data.NewsSearchData
import net.megastudy.mvvmnavernewspractice_0429.util.NetworkInterface
import net.megastudy.mvvmnavernewspractice_0429.util.Resource
import net.megastudy.mvvmnavernewspractice_0429.util.RetrofitAdapter
import net.megastudy.mvvmnavernewspractice_0429.util.ServerAPI
import retrofit2.create
import java.lang.Exception

class MainViewModel : BaseViewModel() {

    private val clientId = "JKYo0rymvqruwdnb5Rge"
    private val clientSecret = "uWTGgkfh0R"

    val newsData = MutableLiveData<Resource<List<NewsSearchData>>>()
    val newsData2 = MutableLiveData<Resource<List<NewsSearchData>>>()
    val newsData3: MutableLiveData<Resource<NewsSearchData>> = MutableLiveData()

//    val getTimeTableinfo: MutableLiveData<Resource<TimeTableInfo>> = MutableLiveData()

    private val apiHelp = ServerAPI.getRetrofit().create(NetworkInterface::class.java)
    val retrofit = RetrofitAdapter.setupRetrofitWithTikXml()
    val apiService : NetworkInterface = retrofit.create(NetworkInterface::class.java)

//    fun abc() {
//        launchViewModelScope {
//            newsData.postValue(Resource.loading())
//            try {
//                newsData.postValue(
//                    Resource.success(
//                        apiHelp.getRequestNewsList(
//                            clientId, clientSecret, "test"
//                        ).aData
//                    )
//                )
//            } catch (e: Exception) {
//                newsData.postValue(Resource.error("에러 발생", null))
//            }
//            Log.e("tetest", "viewModel")
//        }
//    }
//
//    fun test() {
//        launchViewModelScope {
//            newsData2.postValue(Resource.loading())
//            try {
//                newsData2.postValue(
//                    Resource.success(
//                        apiService.getRequestNewsList(
//                            clientId, clientSecret, "test"
//                        ).aData
//                    )
//                )
//            } catch (e: Exception) {
//                newsData2.postValue(Resource.error("에러 발생", null))
//            }
//            Log.e("tetest", "viewModel")
//        }
//    }

    fun newsData3() {
        launchViewModelScope {
            newsData3.postValue(Resource.loading())
            try {
                val data = apiHelp.getRequestNewsList(clientId, clientSecret, "test")
                newsData3.postValue(Resource.success(data))
            } catch (e: Exception) {
                newsData3.postValue(Resource.error(e.toString(), null))
            }
        }
    }
}