package education.elhazent.com.firebaseapp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import education.elhazent.com.firebaseapp.R
import education.elhazent.com.firebaseapp.model.Barang


class CustomAdapter(callback: Context, data: ArrayList<Barang?>) : RecyclerView.Adapter<MyHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyHolder {
        var v = inflater.inflate(R.layout.list_item, p0, false)
        return MyHolder(v)
    }

    val data: ArrayList<Barang?>
    val b: Context
    var inflater: LayoutInflater

    init {
        this.inflater = LayoutInflater.from(callback)
        this.data = data
        this.b = callback
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.textnama.setText(data.get(position)?.nama)
        holder.textketerangan.setText(data.get(position)?.keterangan)
        holder.textjumlah.setText(data.get(position)?.jumlah.toString())
    }



}


class MyHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
    var textnama = itemView?.findViewById(R.id.textnama) as TextView
    var textketerangan = itemView?.findViewById(R.id.textketerangan) as TextView
    var textjumlah = itemView?.findViewById(R.id.textjumlah) as TextView
}