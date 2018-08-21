package com.autchariya.kiklik.makeuptutorial4.mode


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.autchariya.kiklik.makeuptutorial4.R
import com.autchariya.kiklik.makeuptutorial4.dialog.SelectDialog
import kotlinx.android.synthetic.main.fragment_mode3.*


/**
 * A simple [Fragment] subclass.
 *
 */
class Mode3Fragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = Mode3Fragment()
    }

    var Tutor1: String = "-fNrkCqOcJg"
    var Tutor2: String = "CaLPJsDIVlA"
    var Tutor3: String = "z0YIRzXAKzw"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mode3, container, false)
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