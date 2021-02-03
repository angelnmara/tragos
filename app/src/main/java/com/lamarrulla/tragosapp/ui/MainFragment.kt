package com.lamarrulla.tragosapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.lamarrulla.tragosapp.R
import com.lamarrulla.tragosapp.data.model.DataSource
import com.lamarrulla.tragosapp.data.model.Drink
import com.lamarrulla.tragosapp.domain.RepoImpl
import com.lamarrulla.tragosapp.ui.viewModel.MainViewModel
import com.lamarrulla.tragosapp.ui.viewModel.VMFactory
import com.lamarrulla.tragosapp.vo.Resource
import kotlinx.android.synthetic.main.fragment_main.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment(), MainAdapter.OnTragoClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val viewModel by viewModels<MainViewModel> { VMFactory(RepoImpl(DataSource())) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupSearchView()
        setupObserver()
    }

    private fun setupObserver(){
        viewModel.fetchTragosList.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    progressBar.visibility=View.VISIBLE
                }
                is Resource.Success -> {
                    progressBar.visibility=View.GONE
                    rv_tragos.adapter=MainAdapter(requireContext(), result.data, this)
                }
                is Resource.Failure -> {
                    progressBar.visibility=View.GONE
                    Toast.makeText(requireContext(), "Ocurrio un error al traer los datos ${result.exception}", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun setupRecyclerView(){
        rv_tragos.layoutManager= LinearLayoutManager(requireContext())
        rv_tragos.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
    }

    private fun setupSearchView(){
        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener, androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                viewModel.setTrago(p0!!)
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }

        })
    }

    override fun onTragoClick(drink: Drink) {
        val bundle = Bundle()
        bundle.putParcelable("drink", drink)
        findNavController().navigate(R.id.tragosDetalleFragment, bundle)
    }

}
