package education.elhazent.com.firebaseapp.presenter

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import education.elhazent.com.firebaseapp.base.BasePresenter
import education.elhazent.com.firebaseapp.model.Barang
import education.elhazent.com.firebaseapp.view.BarangView


class BarangPresenter(var view: BarangView?) : BasePresenter<BarangView> {


    fun getData(namaTabel: String) {
        val data = FirebaseDatabase.getInstance().getReference(namaTabel)

        data.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                val listBarang = ArrayList<Barang?>()
                for (ds in p0.children) {

                    val dataBarang = ds.getValue(Barang::class.java)
                    listBarang.add(dataBarang)
                    view?.tampilDataBarang(listBarang)
                }

            }

        })
    }

    override fun onAttach(view: BarangView) {
        this.view = view
    }

    override fun onDetach() {
        this.view = null
    }
}