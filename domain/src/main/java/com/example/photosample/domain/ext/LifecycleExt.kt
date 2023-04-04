package com.example.photosample.domain.ext

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

fun <T> LifecycleOwner.observe(livedata: LiveData<T>, observer: (t: T) -> Unit) {
    livedata.observe(this) {
        it?.let { t -> observer(t) }
    }
}