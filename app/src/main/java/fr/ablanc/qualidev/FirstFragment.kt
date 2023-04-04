package fr.ablanc.qualidev

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
class FirstFragment : Fragment() {
    //private Button button
    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
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
        binding.btnSortList.setOnClickListener(View.OnClickListener { binding.txtListAfterSort.text=binding.txtListBeforeSort.text })


        val vm = ViewModelProvider(requireActivity()).get(MainVM::class.java)


        val nameObserver = Observer<String> { newName ->
            binding.txtListBeforeSort.text = newName

        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
      //  vm.currentName.observe(this, nameObserver)
        vm.word.observe(viewLifecycleOwner,nameObserver)

        vm.getData()
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}