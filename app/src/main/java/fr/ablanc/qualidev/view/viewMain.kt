package fr.ablanc.qualidev.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import fr.ablanc.qualidev.databinding.FragmentFirstBinding
import fr.ablanc.qualidev.viewmodel.MainVM

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class viewMain : Fragment() {
    private var _binding: FragmentFirstBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val vm = ViewModelProvider(requireActivity()).get(MainVM::class.java)

        binding.btnSortList.setOnClickListener(View.OnClickListener { vm.sortListCard()})


        val listAfterSortObserver= Observer<String> { listAfterSort ->
            binding.txtListAfterSort.text = listAfterSort }

        val listCard = Observer<String> { newName ->
            binding.txtListBeforeSort.text = newName
        }

        vm.list.observe(viewLifecycleOwner,listCard)
        vm.listAfterSort.observe(viewLifecycleOwner,listAfterSortObserver)

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}