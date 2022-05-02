package net.megastudy.mvvmnavernewspractice_0429

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import net.megastudy.mvvmnavernewspractice_0429.data.Items
import net.megastudy.mvvmnavernewspractice_0429.databinding.ActivityMainBinding
import net.megastudy.mvvmnavernewspractice_0429.util.Status

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private lateinit var mMainNewsAdapter: MainNewsRecyclerAdapter
    private val itemList: ArrayList<Items> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        mainViewModel.abc()
//        mainViewModel.test()
        mainViewModel.newsData3()

        mMainNewsAdapter = MainNewsRecyclerAdapter(this, itemList)
        binding.recyclerNews.adapter = mMainNewsAdapter
        binding.recyclerNews.layoutManager = LinearLayoutManager(this)

        binding.buttonSearch.setOnClickListener {
            getNewsData3()
        }

//        getNewsData()
//        getNewsData2()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun getNewsData3() {
        mainViewModel.newsData3.observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    Log.e("tetest", "Status.Success")
                    Log.e("mainViewModel.newsData.toString()", mainViewModel.newsData.toString())

                    itemList.clear()
                    itemList.addAll(mainViewModel.newsData3.value!!.data!!.items)

                    mMainNewsAdapter.notifyDataSetChanged()
                }
                Status.ERROR -> {
                    Log.e("tetest", "Status.ERROR")
                }
                Status.LOADING -> {
                    Log.e("tetest", "Status.LOADING")
                }
                Status.EMPTY -> {
                    Log.e("tetest", "Status.EMPTY")
                }
            }
        }
    }


//    private fun getNewsData() {
//        mainViewModel.newsData.observe(this) {
//            when(it.status) {
//                Status.SUCCESS -> {
//                    Log.e("tetest", "Status.Success")
//                    Log.e("mainViewModel.newsData.toString()", mainViewModel.newsData.toString())
//
//                    itemList.clear()
//                    itemList.addAll(mainViewModel.newsData.)
//
//                    mMainNewsAdapter.notifyDataSetChanged()
//                }
//                Status.ERROR -> {
//                    Log.e("tetest", "Status.ERROR")
//                }
//                Status.LOADING -> {
//                    Log.e("tetest", "Status.LOADING")
//                }
//                Status.EMPTY -> {
//                    Log.e("tetest", "Status.EMPTY")
//                }
//            }
//        }
//    }
//
//    private fun getNewsData2() {
//        mainViewModel.newsData2.observe(this) {
//            when(it.status) {
//                Status.SUCCESS -> {
//                    Log.e("tetest", "Status.Success")
//                }
//                Status.ERROR -> {
//                    Log.e("tetest", "Status.ERROR")
//                }
//                Status.LOADING -> {
//                    Log.e("tetest", "Status.LOADING")
//                }
//                Status.EMPTY -> {
//                    Log.e("tetest", "Status.EMPTY")
//                }
//            }
//        }
//    }
}