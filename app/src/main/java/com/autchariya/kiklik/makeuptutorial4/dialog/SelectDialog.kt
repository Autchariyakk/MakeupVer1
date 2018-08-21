package com.autchariya.kiklik.makeuptutorial4.dialog


import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.autchariya.kiklik.makeuptutorial4.R
import android.content.Intent
import android.net.Uri
import com.autchariya.kiklik.makeuptutorial4.mode.ModeActivity
import com.autchariya.kiklik.makeuptutorial4.style.VideoMode
import com.autchariya.kiklik.makeuptutorial4.style.VideoTutorial
import kotlinx.android.synthetic.main.dialog_select_dialog.*


/**
 * A simple [Fragment] subclass.
 *
 *
 */



class SelectDialog : DialogFragment() {


      lateinit var URL :String


    companion object {
        fun newInstance(url:String): SelectDialog{
            val fragment:SelectDialog = SelectDialog()
            val bundle:Bundle = Bundle()
            bundle.putString("url",url)
            fragment.arguments = bundle
            return  fragment
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen)

//        if(arguments != null){
//            URL = arguments!!["url"] as String
//            Log.e("url","url :$URL ")
//        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.dialog_select_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        URL = arguments!!["url"] as String

      //  btn_video.setOnClickListener {showVideo() }

        //val url = additional
//        val intent = Intent(Intent.ACTION_VIEW)
//        intent.data = Uri.parse(URL)
//        startActivity(intent)

        btn_video.setOnClickListener {showVideo()  }



    }
    private fun showVideo() {

//        val intent = Intent (context, VideoTutorial::class.java)
//        startActivity(intent)

        val intent = Intent(context,VideoTutorial::class.java)
       // startActivity(intent)
       // val s = URL

        intent.putExtra("value1", URL)
        startActivity(intent)
//        VideoTutorial.newInstance(URL)
//        Log.e("url","url :$URL ")


    }

}
