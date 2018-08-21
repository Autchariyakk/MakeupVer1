package com.autchariya.kiklik.makeuptutorial4.mode


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.autchariya.kiklik.makeuptutorial4.R
import com.autchariya.kiklik.makeuptutorial4.dialog.SelectDialog
import kotlinx.android.synthetic.main.fragment_mode1.*



fun newInstace(): Mode1Fragment {
    return Mode1Fragment()
}



class Mode1Fragment : Fragment() {
    //    private val btnClose: Button? = null
//    private var btn1,: Button? = null
//    private var btn2:Button? = null
//    private var btn3:Button? = null

    var Tutor1 : String = "fvX8_b4U4I8"
    var Tutor2 : String = "FY8mNzxM8uw"
    var Tutor3 : String = "zW-MqH_iYm8"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_mode1, container, false);

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_tutorial.setOnClickListener { Dialog1() }
        btn_tutorial1.setOnClickListener { Dialog2() }
        btn_tutorial2.setOnClickListener { Dialog3() }

    }


    private fun Dialog1() {

        SelectDialog.newInstance(Tutor1).show(fragmentManager, "select")
    }
    private fun Dialog2() {

        SelectDialog.newInstance(Tutor2).show(fragmentManager, "select")
    }
    private fun Dialog3() {

        SelectDialog.newInstance(Tutor3).show(fragmentManager, "select")


    }
//    private fun onClick(view: View){
//        if (view.getId() == btn_tutorial.getId()) run {
//
//            activity!!.supportFragmentManager.beginTransaction()
//                    .add(SelectDialog.newInstance("URL1"),SelectDialog::class.java.simpleName)
//                    .addToBackStack(SelectDialog::class.java.simpleName)
//                    .commit()
//
//        }
//    }
}

//            rootView = inflater.inflate(R.layout.fragment_mode1, container, false)
//
//            if (rootView != null) {
//                findView()
//                setupComponent()
//            }
//            return rootView
//        }


//        private fun findView() {
////            btn1 = rootView.findViewById(R.id.btn_tutorial)
////            btn2 = rootView.findViewById(R.id.btn_tutorial1)
////            btn3 = rootView.findViewById(R.id.btn_tutorial2)
//        }

//        private fun setupComponent() {
//
//            btn_tutorial.setOnClickListener(this)
//            btn_tutorial1.setOnClickListener(this)
//            btn_tutorial2.setOnClickListener(this)
//        }
//
//
//        override fun onClick(v: View) {
//            if (v.id ==  btn_tutorial.getId()) {
//
//
//                //            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//                //            transaction.replace(R.id.fragment_container, SelectTutorialFragment.newInstance(), SelectTutorialFragment.class.getSimpleName())
//                //                    .setTransition(FragmentTransaction.TRANSIT_NONE)
//                //                    .addToBackStack(SelectTutorialFragment.class.getSimpleName())
//                //                    .commit();
//
//                activity!!.supportFragmentManager.beginTransaction()
//                        .add(R.id.fragment_container, SelectTutorialFragment.newInstace("URL1"), SelectTutorialFragment::class!!.getSimpleName())
//                        .addToBackStack(SelectTutorialFragment::class.java!!.getSimpleName())
//                        .commit()
//
//
//                //            getFragmentManager().beginTransaction()
//                //                    .replace(R.id.fragment_container, SelectTutorialFragment.newInstance())
//                //                    .commit();
//            } else if (v.id ==  btn_tutorial1.getId()) {
//
//                activity!!.supportFragmentManager.beginTransaction()
//                        .add(R.id.fragment_container, SelectTutorialFragment.newInstace("URL2"), SelectTutorialFragment::class.java!!.getSimpleName())
//                        .addToBackStack(SelectTutorialFragment::class.java!!.getSimpleName())
//                        .commit()
//            } else if (v.id ==  btn_tutorial2.getId()) {
//
//                activity!!.supportFragmentManager.beginTransaction()
//                        .add(R.id.fragment_container, SelectTutorialFragment.newInstace("URL3"), SelectTutorialFragment::class.java!!.getSimpleName())
//                        .addToBackStack(SelectTutorialFragment::class.java!!.getSimpleName())
//                        .commit()
//            }
//        }



