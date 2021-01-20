package com.example.mobiustask.ui.main

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.mobiustask.MainActivity
import com.example.mobiustask.R
import com.example.mobiustask.model.DataModel
import com.example.mobiustask.model.DataModelItem
import com.example.mobiustask.model.Slab

class MainFragment : Fragment() {
var mcontext : Context? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mcontext=context;
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.init()
        viewModel.getNewsRepository()!!.observe(this, Observer { t->
            var data : DataModelItem=t.get(0);
            var slabs =data.slabs
            var slab : Slab=slabs.get(0)
            Log.e("Code",data.code)
            Log.e("Valid Until",data.valid_until)
            Log.e("Ribben Message",data.ribbon_msg)
            Log.e("wager_to_release_ratio_numerator", data.wager_to_release_ratio_numerator.toString())
            Log.e("wager_to_release_ratio_denominator", data.wager_to_release_ratio_denominator.toString())
            Log.e("wager_bonus_expiry", data.wager_bonus_expiry.toString())
            Log.e("slab.max", slab.max.toString())
            Log.e("slab.min", slab.min.toString())
            Log.e("slab.wagered_max", slab.wagered_max.toString())
            Log.e("slab.wagered_percent", slab.wagered_percent.toString())
            Log.e("slab.otc_max", slab.otc_max.toString())
            Log.e("slab.otc_percent", slab.otc_percent.toString())











        })
    }

}


