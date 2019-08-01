package education.elhazent.com.firebaseapp.register

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import education.elhazent.com.firebaseapp.R
import com.google.firebase.auth.FirebaseAuth
import education.elhazent.com.firebaseapp.MainActivity
import education.elhazent.com.firebaseapp.presenter.RegisterPresenter
import education.elhazent.com.firebaseapp.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity(),RegisterView {


    lateinit var mAuth: FirebaseAuth
    lateinit var presenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()
        presenter = RegisterPresenter(this)

        btn_sigup.setOnClickListener {
            prosesRegister()
        }
    }

    private fun prosesRegister() {
        val username = edt_username.text.toString()
        val email = edt_email.text.toString()
        val password = edt_password.text.toString()

        if (TextUtils.isEmpty(username)){
            edt_username.error = "Username tidak boleh kosong"
        } else if (TextUtils.isEmpty(email)){
            edt_email.error = "Email tidak boleh kosong"
        } else if (TextUtils.isEmpty(password)){
            edt_password.error = "Password tidak boleh kosong"
        } else if (password.length < 6){
            edt_password.error = "Password harus lebih dari 6 karakter"
        } else {
            presenter.prosesRegister(mAuth,username,email,password)
        }
    }


    override fun moveActivity() {
        val intent = Intent(this@RegisterActivity,MainActivity::class.java)
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
