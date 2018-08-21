package com.autchariya.kiklik.makeuptutorial4.mode


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.autchariya.kiklik.makeuptutorial4.R
import com.autchariya.kiklik.makeuptutorial4.dialog.SelectDialog
import kotlinx.android.synthetic.main.fragment_mode4.*

/**
 * A simple [Fragment] subclass.
 *
 */
class Mode4Fragment : Fragment() {
    companion object {
        @JvmStatic
        fun newInstance() = Mode4Fragment()
    }

    var Tutor1: String = "55xM7Roer0Y"
    var Tutor2: String = "LdC5cKBJrXQ"
    var Tutor3: String = "t75_kC1QQLc"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mode4, container, false)
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
}
