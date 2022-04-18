package andlima.hafizhfy.ch5listcountry.adapter

import andlima.hafizhfy.ch5listcountry.R
import andlima.hafizhfy.ch5listcountry.model.GetAllCountryResponseItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_country.view.*

class AdapterCountry(private val listCountry : List<GetAllCountryResponseItem>) : RecyclerView.Adapter<AdapterCountry.ViewHolder>() {

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterCountry.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_country, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AdapterCountry.ViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listCountry[position].flags.png)
            .override(100, 100)
            .into(holder.itemView.iv_bendera)
        holder.itemView.tv_negara.text = listCountry[position].name
        holder.itemView.tv_timezone.text = listCountry[position].timezones[0]
        holder.itemView.tv_benua.text = listCountry[position].region
    }

    override fun getItemCount(): Int {
        return listCountry.size
    }

}