package education.elhazent.com.firebaseapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import education.elhazent.com.firebaseapp.adapter.CustomAdapter
import education.elhazent.com.firebaseapp.model.Barang
import education.elhazent.com.firebaseapp.presenter.BarangPresenter
import education.elhazent.com.firebaseapp.view.BarangView
import kotlinx.android.synthetic.main.activity_barang.*

class BarangActivity : AppCompatActivity(),BarangView {



    lateinit var  presenter:BarangPresenter
    var context :Context?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barang)
        context=this@BarangActivity
        presenter= BarangPresenter(this)
        getDataBarang(context as BarangActivity)
    }

    private fun getDataBarang(context: BarangActivity) {
        presenter.getData("barang")
    }


    override fun tampilDataBarang(barang:ArrayList<Barang?>) {
        recyclerView.adapter= CustomAdapter(this, barang)
        recyclerView.layoutManager= LinearLayoutManager(context)
    }
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


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true}

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var id:Int = item!!.itemId
            if (id==R.id.mn_tambah){
                startActivity(Intent(this@BarangActivity,TambahBarangActivity::class.java))
                finish()
            }
        return super.onOptionsItemSelected(item )
    }
}
