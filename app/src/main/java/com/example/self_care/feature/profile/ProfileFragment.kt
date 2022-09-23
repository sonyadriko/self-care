package com.example.self_care.feature.profile

import android.app.Activity.RESULT_OK
import android.app.Dialog
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.self_care.R
import com.example.self_care.databinding.FragmentProfileBinding
import com.example.self_care.feature.auth.LoginActivity
import com.example.self_care.feature.auth.SignUpActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.fragment_profile.*
import java.io.ByteArrayOutputStream

class ProfileFragment : Fragment() {


    private lateinit var auth: FirebaseAuth
    private var databaseReference :  DatabaseReference? = null
    private var database: FirebaseDatabase? = null

    private lateinit var binding : FragmentProfileBinding
    private lateinit var storageReference : StorageReference
    private lateinit var imageUri : Uri
    private lateinit var dialog : Dialog

    companion object{
        const val REQUEST_CAMERA = 100
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater)







        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("profile")

//        binding.buttonEditProfile.setOnClickListener {
//            val intent = Intent(context, SignUpActivity::class.java)
//            startActivity(intent)
//        }

//        binding.ivProfile.setOnClickListener{
//            intentCamera()
//        }

//        binding.buttonSaveProfile.setOnClickListener {
//            uploadProfilePic()
//        }



        loadProfile()


    }

//    private fun uploadProfilePic() {
//        imageUri = Uri.parse("android.resource://${activity?.packageName}/${R.drawable.profile}")
//        storageReference = FirebaseStorage.getInstance().getReference("Users"+auth.currentUser?.uid)
//        storageReference.putFile(imageUri).addOnSuccessListener {
//            Toast.makeText(context, "Profile successfuly updated", Toast.LENGTH_SHORT).show()
//        }.addOnFailureListener{
//            Toast.makeText(context, "Failed to upload the image", Toast.LENGTH_SHORT).show()
//        }
//
//    }




    private fun loadProfile() {
        val user = auth.currentUser
        val userreference = databaseReference?.child(user?.uid!!)

//        tvEmailAkun.text = user?.email

        userreference?.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                tvNamaAkun.text = snapshot.child("Name").value.toString()
                tvEmailAkun.text = snapshot.child("Email").value.toString()

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        buttonLogout.setOnClickListener {
            auth.signOut()
            startActivity(Intent(context, LoginActivity::class.java))
            activity?.finish()
        }

    }



//    private fun intentCamera() {
//        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also {
//                intent ->
//            activity?.packageManager?.let {
//                intent.resolveActivity(it).also {
//                    startActivityForResult(intent, REQUEST_CAMERA)
//                }
//            }
//        }
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == REQUEST_CAMERA && requestCode == RESULT_OK){
//            val imgBitmap = data?.extras?.get("data") as Bitmap
//            uploadImage(imgBitmap)
//        }
//    }
//
//    private fun uploadImage(imgBitmap: Bitmap) {
//        TODO("Not yet implemented")
//        val baos = ByteArrayOutputStream()
//        val ref = FirebaseStorage.getInstance().reference.child("img/${FirebaseAuth.getInstance().currentUser?.uid}")
//
//        imgBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
//        val image = baos.toByteArray()
//
//        ref.putBytes(image)
//            .addOnCompleteListener{ it ->
//                if (it.isSuccessful){
//                    ref.downloadUrl.addOnCompleteListener {
//                        it.result?.let {
//                            imageUri = it
//                            ivProfile.setImageBitmap(imgBitmap)
//                        }
//                    }
//                }
//            }
//    }


}