package com.example.miretrofit2avanzada

class Users(
    var id: Int,
    var name: String,
    var username: String,
    var email: String,     /*Variable de la clase User*/
    street: String,
    suite: String,         /*Variable de Tipo String Adress*/
    city: String,
    zipcode: String,
    lan: String,          /*Variable de Tipo String Geo*/
    lng: String,
    var phone: String,
    var website: String,
    nameCompany: String,
    catchPhrase: String,
    bs: String
) {

    var address: Address
    var company: Company

    init {
        address = Address(street, suite, city, zipcode, lan, lng)
        company = Company(nameCompany, catchPhrase, bs)
    }

}
