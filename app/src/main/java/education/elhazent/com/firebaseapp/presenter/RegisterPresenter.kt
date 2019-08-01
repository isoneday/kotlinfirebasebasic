package education.elhazent.com.firebaseapp.presenter

import education.elhazent.com.firebaseapp.base.BasePresenter
import education.elhazent.com.firebaseapp.view.RegisterView
import android.widget.Toast
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.AuthResult
import com.google.android.gms.tasks.Task
import android.support.annotation.NonNull
import com.google.android.gms.tasks.OnCompleteListener
import android.R.attr.password
import com.google.firebase.auth.FirebaseAuth


class RegisterPresenter(var view: RegisterView?):BasePresenter<RegisterView> {
    fun prosesRegister(mAuth:FirebaseAuth,username:String,email:String,password:String){
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(OnCompleteListener {
                if (it.isSuccessful){
                    val firebaseUser: FirebaseUser? = mAuth.currentUser
                    val userId = firebaseUser?.uid
                    view?.moveActivity()
                } else{

                }
            })
    }


    override fun onAttach(view: RegisterView) {
        this.view = view
    }

    override fun onDetach() {
        this.view = null
    }
}