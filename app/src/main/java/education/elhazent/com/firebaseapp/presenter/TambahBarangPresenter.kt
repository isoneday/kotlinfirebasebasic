package education.elhazent.com.firebaseapp.presenter

import com.google.firebase.database.FirebaseDatabase
import education.elhazent.com.firebaseapp.base.BasePresenter
import education.elhazent.com.firebaseapp.model.Barang
import education.elhazent.com.firebaseapp.view.TambahBarangView

class TambahBarangPresenter (var view: TambahBarangView?): BasePresenter<TambahBarangView>{


    fun tambahDataBarang(
        nama: String,
        jumlah: String,
        keterangan: String,
        namaTable: String
    ) {
        val data = FirebaseDatabase.getInstance().getReference(namaTable)
        val key = data.push().key
        var b =Barang(nama,jumlah,keterangan)
        data.child(key!!).setValue(b)
        view?.moveActivity()
    }


    override fun onAttach(view: TambahBarangView) {
        this.view = view
    }

    override fun onDetach() {
        this.view = null
    }
}