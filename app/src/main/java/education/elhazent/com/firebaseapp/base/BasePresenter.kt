package education.elhazent.com.firebaseapp.base

interface BasePresenter<X:BaseView> {
    fun onAttach(view :X)
    fun onDetach()
}