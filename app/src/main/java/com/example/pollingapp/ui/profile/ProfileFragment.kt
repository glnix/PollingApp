package com.example.pollingapp.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pollingapp.data.Profile
import com.example.pollingapp.databinding.FragmentProfileBinding
import com.example.pollingapp.setTextWithDefaultTag

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    lateinit var homeViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)
        homeViewModel.setContext(context!!)
        homeViewModel.state.observe(viewLifecycleOwner) {
            setState(it)
        }
        homeViewModel.loadProfile()
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root
        initViews()
        return root
    }

    private fun setState(state: Profile) {
        binding.inputName.tag =
        binding.inputName.setTextWithDefaultTag(state.name)
        binding.inputBirthday.setTextWithDefaultTag(state.birthday)
        binding.inputSpecialization.setTextWithDefaultTag(state.specialization)
    }

    private fun initViews() {
        binding.inputName.addTextChangedListener {
            if (binding.inputName.tag == null)
                homeViewModel.onNameChanged(it.toString())
        }

        binding.inputBirthday.addTextChangedListener {
            if (binding.inputBirthday.tag == null)
                homeViewModel.onBirthdayChanged(it.toString())
        }

        binding.inputSpecialization.addTextChangedListener {
            if (binding.inputSpecialization.tag == null)
                homeViewModel.onSpecializationChanged(it.toString())
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}