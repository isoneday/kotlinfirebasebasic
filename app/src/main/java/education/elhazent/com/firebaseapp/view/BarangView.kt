package education.elhazent.com.firebaseapp.view

import education.elhazent.com.firebaseapp.base.BaseView
import education.elhazent.com.firebaseapp.model.Barang

interface BarangView :BaseView{
    fun tampilDataBarang(barang : ArrayList<Barang?>)
}