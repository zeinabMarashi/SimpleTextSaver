package com.example.simpletextsaver

import android.app.AlertDialog
import android.content.ClipData.Item
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpletextsaver.databinding.DialogEditTextBinding
import com.example.simpletextsaver.databinding.DialogNewTextBinding
import com.example.simpletextsaver.databinding.FragmentHomeBinding
import org.w3c.dom.Text


class home : Fragment() , Adapter.TextEvent {
    lateinit var binding: FragmentHomeBinding
    lateinit var adapter: Adapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        val inclusive = true
        navController.popBackStack(R.id.home, inclusive)


        val data = listOf<DataText>()
        adapter = Adapter(ArrayList(data) , this)
        binding.recyclerHome.adapter = adapter
        binding.recyclerHome.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)

        val swipe = object : SwipeToDeleteCallBack(requireContext()) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                when (direction) {
                    ItemTouchHelper.LEFT -> {
                        adapter.deleteText(viewHolder.adapterPosition)
                    }


                }
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipe)
        itemTouchHelper.attachToRecyclerView(binding.recyclerHome)



        binding.addNewText.setOnClickListener {
            val dialog = AlertDialog.Builder(requireContext()).create()
            val dialogBinding = DialogNewTextBinding.inflate(layoutInflater)
            dialog.setView(dialogBinding.root)
            dialog.setCancelable(true)
            dialog.show()


            dialogBinding.btnSaveText.setOnClickListener {
                if (dialogBinding.newText.text!!.isNotEmpty()) {
                    val text = dialogBinding.newText.text.toString()
                    val newText = DataText(text)
                    adapter.addNewText(newText)
                    dialog.dismiss()


                } else {
                    Toast.makeText(requireContext(), "لطفا متن خود را وارد کنید", Toast.LENGTH_LONG)
                        .show()
                }

            }
            dialogBinding.btnCancel.setOnClickListener {
                dialog.dismiss()
            }
        }


    }

    override fun onClickText(text: DataText , position : Int) {
        val dialog = AlertDialog.Builder(requireContext()).create()
        val viewEdit = DialogEditTextBinding.inflate(layoutInflater)
        viewEdit.newText.setText(text.text)
        dialog.setView(viewEdit.root)
        dialog.setCancelable(true)
        dialog.show()

        viewEdit.btnCancel.setOnClickListener {
            dialog.dismiss()
        }

        viewEdit.btnSaveText.setOnClickListener {
            
            if (viewEdit.newText.length()>0){
                val text = viewEdit.newText.text.toString()
                val newText = DataText(text)

                adapter.updateText(newText , position)
                dialog.dismiss()
            }else{

                Toast.makeText(requireContext(), "لطفا نوشته خود را وارد کنید", Toast.LENGTH_SHORT).show()
            }
  

        }
    }
}