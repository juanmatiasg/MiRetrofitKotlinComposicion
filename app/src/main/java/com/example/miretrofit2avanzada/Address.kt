package com.example.miretrofit2avanzada

class Address(var street:String,var suite:String,var city:String,var zipcode:String,lan:String,lng:String){
    var geo:Geo

    init {
        geo=Geo(lan,lng)
    }

}
