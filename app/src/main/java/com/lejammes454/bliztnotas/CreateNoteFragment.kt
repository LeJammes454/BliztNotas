package com.lejammes454.bliztnotas

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.lejammes454.bliztnotas.DB.Notes
import com.lejammes454.bliztnotas.DB.NotesDataBase
import com.lejammes454.bliztnotas.util.NotesBottonSheetFragment
import kotlinx.android.synthetic.main.fragment_create_note.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import java.util.jar.Manifest

class CreateNoteFragment : FragmentosBase(){

    var colorSeleccionado = "#171c26"
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
        Toast.makeText(context,"Realizando pendejadas",Toast.LENGTH_SHORT).show()

        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(
            BroadcastReceiver, IntentFilter("botton_sheet_action")
        )


        val tiempo = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        currenDate = tiempo.format(Date())
        colorView.setBackgroundColor(Color.parseColor(colorSeleccionado))

        imgDone.setOnClickListener {
            guardarNotas()
            Toast.makeText(context, "Se agrego la nota :)",Toast.LENGTH_SHORT).show()
        }


        imgBack.setOnClickListener {
           requireActivity().supportFragmentManager.popBackStack()
        }
        imgMore.setOnClickListener {
            var noteBottonSheetFragment=NotesBottonSheetFragment.newInstance()
            noteBottonSheetFragment.show(requireActivity().supportFragmentManager,"Nota Bottom Sheet Fragment")
        }
    }

    private fun guardarNotas(){
        if(etNotasTitulo.text.isNullOrEmpty()){
            Toast.makeText(context,"La Nota Requiere un Titulo",Toast.LENGTH_SHORT).show()
        }
        if(etNotaSubtitulo.text.isNullOrEmpty()){
            Toast.makeText(context,"La Nota Requiere un SubTitulo",Toast.LENGTH_SHORT).show()
        }
        if(etNotasDescripcion.text.isNullOrEmpty()){
            Toast.makeText(context,"La Nota Requiere una Descripcion",Toast.LENGTH_SHORT).show()
        }
        launch {
            val notas = Notes()
            notas.titulo=etNotasTitulo.text.toString()
            notas.subtitulo=etNotaSubtitulo.text.toString()
            notas.notaTexto=etNotasDescripcion.text.toString()
            notas.dateTime=currenDate
            context?.let {
                NotesDataBase.getDatabase(it).noteDao().insertarnotas(notas)
                etNotasTitulo.setText("")
                etNotaSubtitulo.setText("")
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

    private val BroadcastReceiver:BroadcastReceiver=object :BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
            var actionColor = p1!!.getStringExtra("action")
            Toast.makeText(context,"Ingreso al BroadCastRecevir",Toast.LENGTH_SHORT).show()
            when(actionColor!!){

                "Blue" -> {
                    colorSeleccionado = p1.getStringExtra("colorSeleccionado")!!
                    colorView.setBackgroundColor(Color.parseColor(colorSeleccionado))

                }

                "Yellow" -> {
                    colorSeleccionado = p1.getStringExtra("colorSeleccionado")!!
                    colorView.setBackgroundColor(Color.parseColor(colorSeleccionado))

                }


                "Purple" -> {
                    colorSeleccionado = p1.getStringExtra("colorSeleccionado")!!
                    colorView.setBackgroundColor(Color.parseColor(colorSeleccionado))

                }


                "Green" -> {
                    colorSeleccionado = p1.getStringExtra("colorSeleccionado")!!
                    colorView.setBackgroundColor(Color.parseColor(colorSeleccionado))

                }


                "Orange" -> {
                    colorSeleccionado = p1.getStringExtra("colorSeleccionado")!!
                    colorView.setBackgroundColor(Color.parseColor(colorSeleccionado))

                }


                "Black" -> {
                    colorSeleccionado = p1.getStringExtra("colorSeleccionado")!!
                    colorView.setBackgroundColor(Color.parseColor(colorSeleccionado))

                }
                "Image" ->{
                   // readStorageTask()
                   // layoutWebUrl.visibility = View.GONE
                }

                else->{
                    colorSeleccionado = p1.getStringExtra("colorSeleccionado")!!
                    colorView.setBackgroundColor(Color.parseColor(colorSeleccionado))
                }

                /*


                "WebUrl" ->{
                    layoutWebUrl.visibility = View.VISIBLE
                }
                "DeleteNote" -> {
                    //delete note
                    deleteNote()
                }




                else -> {
                    layoutImage.visibility = View.GONE
                    imgNote.visibility = View.GONE
                    layoutWebUrl.visibility = View.GONE
                    selectedColor = p1.getStringExtra("selectedColor")!!
                    colorView.setBackgroundColor(Color.parseColor(selectedColor))

                }

                 */
        }
    }
    }
    override fun onDestroy(){
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(BroadcastReceiver)
        super.onDestroy()
    }

}