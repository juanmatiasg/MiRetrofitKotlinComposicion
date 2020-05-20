package com.example.miretrofit2avanzada

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class UserAdapter : RecyclerView.Adapter<ViewHolder>() {

    var list: MutableList<Users> = mutableListOf()
    lateinit var context: Context

    fun UserAdapter(list: MutableList<Users>, context: Context) {
        this.list = list
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_users, parent, false))
    }

    override fun getItemCount(): Int {
        return this.list.size
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val item = list.get(position)
        holder.bind(item)
    }

}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    /*User*/
    val id = view.findViewById<TextView>(R.id.textViewId)
    val name = view.findViewById<TextView>(R.id.textViewName)
    val userName = view.findViewById<TextView>(R.id.textViewUserName)
    val email = view.findViewById<TextView>(R.id.textViewEmail)

    /*Adress*/

    val street = view.findViewById<TextView>(R.id.textViewStreet)
    val suite = view.findViewById<TextView>(R.id.textViewSuite)
    val city = view.findViewById<TextView>(R.id.textViewCity)
    val zipcode = view.findViewById<TextView>(R.id.textViewZipCode)

    /*Geo*/

    val lat = view.findViewById<TextView>(R.id.textViewLat)
    val lng = view.findViewById<TextView>(R.id.textViewLng)

    /*User*/
    val phone = view.findViewById<TextView>(R.id.textViewPhone)
    val website = view.findViewById<TextView>(R.id.textViewWebsite)

    /*Company*/
    val nameCompany = view.findViewById<TextView>(R.id.textViewNameCompany)
    val catchPhrase = view.findViewById<TextView>(R.id.textViewCatchPhrase)
    val bs = view.findViewById<TextView>(R.id.textViewBs)


    fun bind(user: Users) {
        id.text = user.id.toString()
        name.text = user.name
        userName.text = user.username
        email.text = user.email
        street.text = user.address.street
        suite.text = user.address.suite
        city.text = user.address.city
        zipcode.text = user.address.zipcode /*Composicion*/
        lat.text = user.address.geo.lat  /*Composicion*/
        lng.text = user.address.geo.lng /*Composicion*/
        phone.text = user.phone
        website.text = user.website
        nameCompany.text = user.company.name
        catchPhrase.text = user.company.catchPhrase
        bs.text = user.company.bs

    }
}



