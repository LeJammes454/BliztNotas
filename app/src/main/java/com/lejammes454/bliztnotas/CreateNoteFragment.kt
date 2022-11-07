package com.lejammes454.bliztnotas

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.lejammes454.bliztnotas.DB.Notes
import com.lejammes454.bliztnotas.DB.NotesDataBase
import kotlinx.android.synthetic.main.fragment_create_note.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class CreateNoteFragment : FragmentosBase() {
    var currenDate:String? =null

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

        return inflater.inflate(R.layout.fragment_create_note, container, false)

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CreateNoteFragment().apply {
                arguments = Bundle().apply {
                    Log.i("JUAN","INGRESO AL FRAGMENTO JUTAN")
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tiempo = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        currenDate = tiempo.format(Date())

        imgDone.setOnClickListener {
            guardarNotas()
        }

        imgback.setOnClickListener {
            remplazarFragmento(HomeFragment.newInstance(),false)
        }
    }

    private fun guardarNotas(){
        if(etNotasTitulo.text.isNullOrEmpty()){
            Toast.makeText(context,"La Nota Requiere un Titulo",Toast.LENGTH_SHORT).show()
        }
        if(etNotasSubtitulo.text.isNullOrEmpty()){
            Toast.makeText(context,"La Nota Requiere un SubTitulo",Toast.LENGTH_SHORT).show()
        }
        if(etNotasDescripcion.text.isNullOrEmpty()){
            Toast.makeText(context,"La Nota Requiere una Descripcion",Toast.LENGTH_SHORT).show()
        }
        launch {
            val notas = Notes()
            notas.titulo=etNotasTitulo.text.toString()
            notas.subtitulo=etNotasSubtitulo.text.toString()
            notas.notaTexto=etNotasDescripcion.text.toString()
            notas.dateTime=currenDate
            context?.let {
                NotesDataBase.getDatabase(it).noteDao().insertarnotas(notas)
                etNotasTitulo.setText("")
                etNotasSubtitulo.setText("")
                etNotasDescripcion.setText("")
            }
        }
    }

    fun remplazarFragmento(fragment:Fragment, istransition:Boolean){
        val fragmentTransition = requireActivity().supportFragmentManager.beginTransaction()

        if (istransition){
            fragmentTransition.setCustomAnimations(android.R.anim.slide_out_right,android.R.anim.slide_in_left)
        }
        fragmentTransition.replace(R.id.frame_layout,fragment).addToBackStack(fragment.javaClass.simpleName).commit()
    }


}