package net.megastudy.mvvmnavernewspractice_0429

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    open fun launchViewModelScope(doWork: suspend () -> Unit) =
        viewModelScope.launch(viewModelScope.coroutineContext + Dispatchers.IO) {
            doWork()
        }

    open val isLoading = MutableLiveData(View.INVISIBLE)
    open fun showLoading() = isLoading.postValue(View.VISIBLE)
    open fun hideLoading() = isLoading.postValue(View.INVISIBLE)


}