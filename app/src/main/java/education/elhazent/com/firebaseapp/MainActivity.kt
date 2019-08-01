package education.elhazent.com.firebaseapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import education.elhazent.com.firebaseapp.login.LoginActivity
import education.elhazent.com.firebaseapp.register.RegisterActivity
import education.elhazent.com.firebaseapp.view.RegisterView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener {
            startActivity(Intent(this@MainActivity,LoginActivity::class.java))
        }

        btn_register.setOnClickListener {
            startActivity(Intent(this@MainActivity,RegisterActivity::class.java))
        }
    }
}
