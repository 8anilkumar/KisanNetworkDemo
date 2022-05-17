package com.anil.kisannetworkdemo.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.anil.kisannetworkdemo.R
import com.anil.kisannetworkdemo.adapters.ContactAdapter
import com.anil.kisannetworkdemo.adapters.ContactDetailsAdapter
import com.anil.kisannetworkdemo.data.network.HistoryDatabase
import com.anil.kisannetworkdemo.databinding.FragmentContactBinding
import com.anil.kisannetworkdemo.databinding.FragmentContactDetailsBinding
import com.anil.kisannetworkdemo.models.MessageEntity
import com.anil.kisannetworkdemo.utils.Constants
import com.anil.kisannetworkdemo.utils.observeOnce
import com.anil.kisannetworkdemo.viewModel.MainViewModel
import kotlinx.coroutines.launch

class ContactDetailsFr : Fragment() {

    private lateinit var mainViewModel: MainViewModel
    private var binding: FragmentContactDetailsBinding? = null
    private lateinit var historyDatabase: HistoryDatabase
    private lateinit var mAdapter: ContactDetailsAdapter
    var contactDetailsList = ArrayList<MessageEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentContactDetailsBinding.inflate(inflater,container,false)

        setUpDB()
        readDatabase()

        return binding?.root

    }

    private fun readDatabase() {
        lifecycleScope.launch {
            mainViewModel.readContacts.observe(viewLifecycleOwner) { database ->
                if (database.isNotEmpty()) {
                    mAdapter = ContactDetailsAdapter(requireContext(),database)
                    binding?.recyclerview?.adapter = mAdapter
                    binding?.recyclerview?.layoutManager = LinearLayoutManager(requireContext())
                    mAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    private fun setUpDB() {
        historyDatabase = Room.databaseBuilder(requireContext(), HistoryDatabase::class.java, Constants.DATABASE_NAME)
            .allowMainThreadQueries().build()
    }
}


