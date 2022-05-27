package com.example.pollingapp.ui.polling

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.liveData
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.pollingapp.R
import com.example.pollingapp.databinding.FragmentPollingBinding
import com.example.pollingapp.databinding.FragmentPollsBinding

class PollingFragment : Fragment() {

    private lateinit var viewModel: PollingViewModel
    private val args: PollingFragmentArgs by navArgs()
    private var _binding: FragmentPollingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(PollingViewModel::class.java)
        _binding = FragmentPollingBinding.inflate(inflater, container, false)
        initViews()
        viewModel.pollLiveData.observe(viewLifecycleOwner) {
            binding.rvPolls.adapter = PollingAdapter(it) { questionId, answerId, isChecked ->
                viewModel.setAnswer(questionId, answerId, isChecked)

            }
        }
        viewModel.setContext(requireContext())
        viewModel.loadPoll(args.id)
        return binding.root
    }

    private fun initViews() {
        requireActivity().onBackPressedDispatcher.addCallback(object :
            OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        })

        binding.submit.setOnClickListener {
            viewModel.submit()
            findNavController().popBackStack()
        }
    }


}