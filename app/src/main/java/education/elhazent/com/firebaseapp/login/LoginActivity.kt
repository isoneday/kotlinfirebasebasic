package education.elhazent.com.firebaseapp.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import education.elhazent.com.firebaseapp.BarangActivity
import education.elhazent.com.firebaseapp.MainActivity
import education.elhazent.com.firebaseapp.R
import education.elhazent.com.firebaseapp.presenter.LoginPresenter
import education.elhazent.com.firebaseapp.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),LoginView {

    lateinit var presenter:LoginPresenter
    lateinit var mAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mAuth = FirebaseAuth.getInstance()
        presenter = LoginPresenter(this)
        btn_signin.setOnClickListener {
            prosesLogin()
        }

    }

    private fun prosesLogin() {
        val email = edt_email_log.text.toString()
        val password = edt_password_log.text.toString()

        if (TextUtils.isEmpty(email)){
            edt_email_log.error = "Email tidak boleh kosong"
        } else if (TextUtils.isEmpty(password)){
            edt_password_log.error = "Password tidak boleh kosong"
        } else {
            presenter.prosesLogin(email,password,mAuth)
        }
    }

    override fun moveActivity() {
        val intent = Intent(this@LoginActivity, BarangActivity::class.java)
        Toast.makeText(applicationContext,"Anda berhasil login",Toast.LENGTH_LONG).show()
        startActivity(intent)
        finish()
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
}
