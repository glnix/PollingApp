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
    private lateinit var homeViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)
        homeViewModel.setContext(requireContext())
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
        with(binding) {
            inputEmail.setTextWithDefaultTag(state.email)
            inputPhone.setTextWithDefaultTag(state.phone)
            tvName.text = state.name
            tvMiddlename.text = state.middleName
            tvLastname.text = state.lastName
            tvBirthdate.text = state.birthday
            tvInstitute.text = state.institute
            tvProfile.text = state.profile
            tvGrpup.text = state.group
            tvSpec.text = state.specialization
            tvYear.text = state.year
            tvPeriod.text = state.period
        }
    }

    private fun initViews() {

        binding.inputPhone.addTextChangedListener {
            if (binding.inputPhone.tag == null)
                homeViewModel.onPhoneChanged(it.toString())
        }

        binding.inputEmail.addTextChangedListener {
            if (binding.inputEmail.tag == null)
                homeViewModel.onEmailChanged(it.toString())
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}