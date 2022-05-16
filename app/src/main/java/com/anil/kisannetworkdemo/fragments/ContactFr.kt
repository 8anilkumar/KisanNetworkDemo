package com.anil.kisannetworkdemo.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.anil.kisannetworkdemo.adapters.ContactAdapter
import com.anil.kisannetworkdemo.databinding.FragmentContactBinding
import com.anil.kisannetworkdemo.models.ContactResponse
import com.anil.kisannetworkdemo.utils.NetworkListener
import com.anil.kisannetworkdemo.viewModel.MainViewModel
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class ContactFr : Fragment() {

    private lateinit var mainViewModel: MainViewModel
    private var binding: FragmentContactBinding? = null

    private lateinit var networkListener: NetworkListener

    var userFnameList = ArrayList<String>()
    var userLnameList = ArrayList<String>()
    var userNumberList = ArrayList<String>()
    private lateinit var mAdapter:ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentContactBinding.inflate(inflater,container,false)

        setHasOptionsMenu(true)
        requestApiData()

        return binding?.root
    }


    private fun requestApiData() {
        Log.d("RecipesFragment", "requestApiData called!")

        try {
            val jsonObject = JSONObject(JsonDataFromAsset())
            val jsonArray = jsonObject.getJSONArray("users");

            for (i in 0 until jsonArray.length()) {
                val userContact: JSONObject = jsonArray.getJSONObject(i)
                userFnameList.add(userContact.getString("fName"))
                userLnameList.add(userContact.getString("lName"))
                userNumberList.add(userContact.getString("number"))

                mAdapter = ContactAdapter(requireContext(),userFnameList,userLnameList,userNumberList)
                binding?.recyclerview?.adapter = mAdapter
                binding?.recyclerview?.layoutManager = LinearLayoutManager(requireContext())
                mAdapter.notifyDataSetChanged()
            }


        } catch (e:Exception){
            e.printStackTrace()
        }


    }

    private fun JsonDataFromAsset(): String? {
        var json: String? = null
        try {
            val inputStream: InputStream? = activity?.getAssets()?.open("UserContacts.json")
            val sizeOffFile = inputStream?.available()
            val bufferData = sizeOffFile?.let { ByteArray(it) }
            inputStream?.read(bufferData)
            inputStream?.close()
            json = bufferData?.let { String(it) }
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }

        return json
    }

}