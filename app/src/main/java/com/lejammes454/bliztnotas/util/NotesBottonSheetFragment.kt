package com.lejammes454.bliztnotas.util

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.lejammes454.bliztnotas.R
import kotlinx.android.synthetic.main.fragment_notes_bottom_sheet.*

class NotesBottonSheetFragment :BottomSheetDialogFragment(){

    var colorSeleccionado = "#171C26"

    companion object{
        fun newInstance():NotesBottonSheetFragment{
            var args = Bundle()
            val fragment=NotesBottonSheetFragment()
            fragment.arguments=args
            return fragment
        }
    }

    @SuppressLint("RestrictedApi")
    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)

        val view = LayoutInflater.from(context).inflate(R.layout.fragment_notes_bottom_sheet,null)
        dialog.setContentView(view)

        val param = (view.parent as View).layoutParams as CoordinatorLayout.LayoutParams

        val behavior = param.behavior

        if (behavior is BottomSheetBehavior<*>){
            behavior.setBottomSheetCallback(object :BottomSheetBehavior.BottomSheetCallback(){
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    var state=""
                    when(newState){
                        BottomSheetBehavior.STATE_DRAGGING -> {
                            state = "Dragggin"
                        }
                        BottomSheetBehavior.STATE_SETTLING -> {
                            state = "Settling"
                        }
                        BottomSheetBehavior.STATE_EXPANDED -> {
                            state = "Expanded"
                        }
                        BottomSheetBehavior.STATE_COLLAPSED -> {
                            state = "Collapsed"
                        }
                        BottomSheetBehavior.STATE_HIDDEN->{
                            state = "Hidden"
                            dismiss()
                            behavior.state=BottomSheetBehavior.STATE_COLLAPSED
                        }

                    }
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    TODO("Not yet implemented")
                }

            })
        }
    }

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_notes_bottom_sheet,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }
    private fun setListener(){
        fNota1.setOnClickListener {

            imgNota1.setImageResource(R.drawable.ic_check)
            imgNota2.setImageResource(0)
            imgNota4.setImageResource(0)
            imgNota5.setImageResource(0)
            imgNota6.setImageResource(0)
            imgNota7.setImageResource(0)
            colorSeleccionado = "#4e33ff"

            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action","Blue")
            intent.putExtra("selectedColor",colorSeleccionado)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)

        }

        fNota2.setOnClickListener {
            imgNota1.setImageResource(0)
            imgNota2.setImageResource(R.drawable.ic_check)
            imgNota4.setImageResource(0)
            imgNota5.setImageResource(0)
            imgNota6.setImageResource(0)
            imgNota7.setImageResource(0)
            colorSeleccionado = "#ffd633"

            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action","Yellow")
            intent.putExtra("selectedColor",colorSeleccionado)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)

        }

        fNota4.setOnClickListener {
            imgNota1.setImageResource(0)
            imgNota2.setImageResource(0)
            imgNota4.setImageResource(R.drawable.ic_check)
            imgNota5.setImageResource(0)
            imgNota6.setImageResource(0)
            imgNota7.setImageResource(0)
            colorSeleccionado = "#ae3b76"

            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action","Purple")
            intent.putExtra("selectedColor",colorSeleccionado)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)

        }

        fNota5.setOnClickListener {
            imgNota1.setImageResource(0)
            imgNota2.setImageResource(0)
            imgNota4.setImageResource(0)
            imgNota5.setImageResource(R.drawable.ic_check)
            imgNota6.setImageResource(0)
            imgNota7.setImageResource(0)
            colorSeleccionado = "#0aebaf"

            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action","Green")
            intent.putExtra("selectedColor",colorSeleccionado)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
        }

        fNota6.setOnClickListener {

            imgNota1.setImageResource(0)
            imgNota2.setImageResource(0)
            imgNota4.setImageResource(0)
            imgNota5.setImageResource(0)
            imgNota6.setImageResource(R.drawable.ic_check)
            imgNota7.setImageResource(0)
            colorSeleccionado = "#ff7746"
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action","Orange")
            intent.putExtra("selectedColor",colorSeleccionado)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
        }

        fNota7.setOnClickListener {
            imgNota1.setImageResource(0)
            imgNota2.setImageResource(0)
            imgNota4.setImageResource(0)
            imgNota5.setImageResource(0)
            imgNota6.setImageResource(0)
            imgNota7.setImageResource(R.drawable.ic_check)
            colorSeleccionado = "#202734"

            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action","Black")
            intent.putExtra("colorSeleccionado",colorSeleccionado)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
        }


        layoutImagen.setOnClickListener{
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action","Image")
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
        }
        /*
        layoutWebUrl.setOnClickListener{
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action","WebUrl")
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
            dismiss()
        }
        layoutDeleteNote.setOnClickListener {
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action","DeleteNote")
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
            dismiss()
        }

         */
    }
}