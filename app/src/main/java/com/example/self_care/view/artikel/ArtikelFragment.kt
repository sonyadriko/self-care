package com.example.self_care.view.artikel

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.self_care.R
import com.example.self_care.domain.Artikel
import com.github.core.listener.OnClickListener

class ArtikelFragment : Fragment(), OnClickListener {

    private lateinit var adapter: ArtikelListAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var artikelArrayList: ArrayList<Artikel>

    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>
    lateinit var artikel: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_artikel, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = ArtikelListAdapter(artikelArrayList, this@ArtikelFragment)
        recyclerView.adapter = adapter
    }

    private fun dataInitialize() {
        artikelArrayList = arrayListOf<Artikel>()

        for (i in imageId.indices) {
            val artikel = Artikel(imageId[i], heading[i])
            artikelArrayList.add(artikel)
        }

    }

    override fun onClick(data: Any, position: Int) {
        val intent = Intent(requireContext(), ArtikelActivity::class.java)
        startActivity(intent)
    }
}