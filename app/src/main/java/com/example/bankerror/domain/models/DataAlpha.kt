package com.example.bankerror.domain.models

import com.google.gson.annotations.SerializedName

data class DataAlpha(@SerializedName("rates") val rate:List<BodyDataAlpha>)