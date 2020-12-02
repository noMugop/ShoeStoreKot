package com.udacity.shoestore.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class AddShoeViewModel : ViewModel() {

    private val _dataToSave = MutableLiveData<Shoe>()
    val dataToSave: LiveData<Shoe>
        get() = _dataToSave

    private val _nameIsCorrect = MutableLiveData<Boolean>()
    val nameIsCorrect: LiveData<Boolean>
        get() = _nameIsCorrect

    private val _descriptionIsCorrect = MutableLiveData<Boolean>()
    val descriptionIsCorrect: LiveData<Boolean>
        get() = _descriptionIsCorrect

    private val _companyIsCorrect = MutableLiveData<Boolean>()
    val companyIsCorrect: LiveData<Boolean>
        get() = _companyIsCorrect

    private val _sizeIsCorrect = MutableLiveData<Boolean>()
    val sizeIsCorrect: LiveData<Boolean>
        get() = _sizeIsCorrect

    fun resetErrors() {
        _nameIsCorrect.value = true
        _descriptionIsCorrect.value = true
        _companyIsCorrect.value = true
        _sizeIsCorrect.value = true
    }

    fun saveData(
        name: String?,
        description: String?,
        company: String?,
        size: String?
    ) {
        val nameIsCorrect = !name.isNullOrBlank()
        _nameIsCorrect.value = nameIsCorrect
        val descriptionIsCorrect = !description.isNullOrBlank()
        _descriptionIsCorrect.value = descriptionIsCorrect
        val companyIsCorrect = !company.isNullOrBlank()
        _companyIsCorrect.value = companyIsCorrect
        val sizeIsCorrect = !size.isNullOrBlank()
        _sizeIsCorrect.value = sizeIsCorrect

        val dataIsReady = nameIsCorrect && descriptionIsCorrect && companyIsCorrect && sizeIsCorrect

        if (dataIsReady && name != null && size != null && company != null && description != null) {
            val shoe = Shoe(name, size.toDouble(), company, description)
            _dataToSave.value = shoe
        }
    }
}