package education.elhazent.com.firebaseapp.presenter

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import education.elhazent.com.firebaseapp.base.BasePresenter
import education.elhazent.com.firebaseapp.view.LoginView

class LoginPresenter(var view: LoginView?) : BasePresenter<LoginView> {

    fun prosesLogin(email: String, password: String, mAuth: FirebaseAuth) {
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(OnCompleteListener {
                if (it.isSuccessful){
                    view?.moveActivity()
                }
            })
    }


    override fun onAttach(view: LoginView) {
        this.view = view
    }

    override fun onDetach() {
        this.view = null
    }

}