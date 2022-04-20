package com.mauriciogs.databindingexample.data

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.squareup.picasso.Picasso

class OfferViewModel : ViewModel() {
    private val _title = MutableLiveData("Sport shoes")
    private val _price = MutableLiveData("$35.00")
    private val _desc = MutableLiveData("Color Rosa\n" +
            "Construcción superior de malla brinda ligereza, flexibilidad y mayor frescura. " +
            "Detalles en gamuza. Detalles en material sintético.\n")
    //private val _imgUrl = MutableLiveData("https://www.innvictus.com/medias/IN-CU4874-600-1.jpg?context=bWFzdGVyfGltYWdlc3w5MzcyNHxpbWFnZS9qcGVnfGltYWdlcy9oMTYvaGZkLzEwNzkwNjQ1ODI1NTY2LmpwZ3w1NjZkNTA5YmI1YmRiMDhlYzhjMWRlM2M3NTNhM2FmZTAxNDk4NDY2YzAwYjkwZWJkNjYyM2NiZjdlZmNkMWRl")
    private val _stock = MutableLiveData(48)


    val title : LiveData<String> = _title
    val price : LiveData<String> = _price
    val desc : LiveData<String> = _desc
    //val urlImg : LiveData<String?> = _imgUrl
    val stock : LiveData<Int> = _stock
    val stockStr = "Stock: "

    val disponibility : LiveData<Disponibility> = Transformations.map(_stock){
        when{
            it > 25 -> Disponibility.HIGH
            it > 10 -> Disponibility.NORMAL
            else -> {
                Disponibility.LOW
            }
        }
    }

    fun onBuy() {
        _stock.value = if (_stock.value == 0) 0 else _stock.value?.minus(1)
    }
}

enum class Disponibility {
    LOW,
    NORMAL,
    HIGH
}