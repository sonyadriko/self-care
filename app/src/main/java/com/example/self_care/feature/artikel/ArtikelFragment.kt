package com.example.self_care.feature.artikel

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
import com.github.core.common.listener.OnClickListener

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

        imageId = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
        )
        heading = arrayOf(
            getString(R.string.head_1),
            getString(R.string.head_2),
            getString(R.string.head_3),
            getString(R.string.head_4),
            getString(R.string.head_5),
            getString(R.string.head_6),
            getString(R.string.head_7),
            getString(R.string.head_8),
        )

        artikel = arrayOf(
            getString(R.string.news_a),
            getString(R.string.news_b),
            getString(R.string.news_c),
            getString(R.string.news_d),
            getString(R.string.news_e),
            getString(R.string.news_f),
            getString(R.string.news_g),
            getString(R.string.news_h),


            )

        for (i in imageId.indices) {
            val artikel = Artikel(imageId[i], heading[i], artikel[i])
            artikelArrayList.add(artikel)
        }

    }

    override fun onClick(data: Any, position: Int) {
        val intent = Intent(requireContext(), ArtikelActivity::class.java).putExtra(
            "heading",
            data as Artikel
        )
        startActivity(intent)
    }
}