package com.example.pollingapp.ui.polls

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pollingapp.R
import com.example.pollingapp.databinding.FragmentPollsBinding
import com.example.pollingapp.ui.polling.PollingFragmentArgs

class PollsFragment : Fragment() {

    private lateinit var pollsViewModel: PollsViewModel
    private var _binding: FragmentPollsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        pollsViewModel =
            ViewModelProvider(this).get(PollsViewModel::class.java)
        pollsViewModel.setContext(requireContext())
        _binding = FragmentPollsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        pollsViewModel.pollsLiveData.observe(viewLifecycleOwner) {
            binding.rvPolls.adapter = PollsAdapter(it) {
                findNavController().navigate(PollsFragmentDirections.toPolling(it))
            }
        }
        pollsViewModel.loadPolls()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}