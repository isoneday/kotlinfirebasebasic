package education.elhazent.com.firebaseapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import education.elhazent.com.firebaseapp.presenter.TambahBarangPresenter
import education.elhazent.com.firebaseapp.view.TambahBarangView
import kotlinx.android.synthetic.main.activity_tambah_barang.*

class TambahBarangActivity : AppCompatActivity(),TambahBarangView {


    lateinit var  presenter: TambahBarangPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_barang)
        presenter = TambahBarangPresenter(this)
        btnmasuk.setOnClickListener { 
            presenter.tambahDataBarang(edtnamabarang.text.toString(),edtjumlahbarang.text.toString(),edtketeranganbarang.text.toString(),"barang")
        }
        
    }

    override fun moveActivity() {
        val intent = Intent(this@TambahBarangActivity, BarangActivity::class.java)
        startActivity(intent)
        finish() }

    override fun onAttachView() {
        presenter.onAttach(this)
    }

    override fun onDetachView() {
        presenter.onDetach()
    }

    override fun onStart() {
        super.onStart()
        onAttachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        onDetachView()
    }

}
