package com.poly.testwaveaccess.ui.userList

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.poly.testwaveaccess.R
import com.poly.testwaveaccess.common.Logger
import com.poly.testwaveaccess.databinding.FragmentUserListBinding
import com.poly.testwaveaccess.mvi.MviView
import com.poly.testwaveaccess.ui.UserListAdapter
import com.poly.testwaveaccess.ui.userList.mvi.UserListNews
import com.poly.testwaveaccess.ui.userList.mvi.UserListState
import com.poly.testwaveaccess.ui.userList.mvi.UserListWish
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class UserListFragment : Fragment(), MviView<UserListState, UserListNews> {

    @Inject
    lateinit var logger: Logger

    private val userListViewModel: UserListViewModel by viewModels()

    private var _binding: FragmentUserListBinding? = null
    private val binding get() = _binding!!

    lateinit var userListRecycler: RecyclerView
    lateinit var userListAdapter: UserListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        logger.connect(javaClass)

        userListRecycler = binding.userList
        userListAdapter = UserListAdapter { user ->
            if (user.isActive == "true") {
                val action = UserListFragmentDirections.actionUserListFragmentToUserDetailsFragment(
                    userId = user.id
                )
                view.findNavController().navigate(action)
            } else {
                Snackbar.make((binding.snack as View), "User is inactive at this moment", Snackbar.LENGTH_SHORT)
                    .show()
            }
        }
        userListRecycler.layoutManager = LinearLayoutManager(this.requireContext())
        userListRecycler.adapter = userListAdapter

        with(userListViewModel) {
            bind(viewLifecycleOwner.lifecycleScope, this@UserListFragment)
        }

        val settings: SharedPreferences = requireActivity().getSharedPreferences(PREFS_NAME, 0)
        if (settings.getBoolean(SETTINGS_FIRST_TIME, true)) {
            userListViewModel.obtainWish(UserListWish.RefreshFromNetwork)
            logger.log("First time")

            settings.edit().putBoolean(SETTINGS_FIRST_TIME, false).apply()
        } else {
            userListViewModel.obtainWish(UserListWish.Refresh)
        }


        binding.refreshUserList.setOnRefreshListener {
            userListViewModel.obtainWish(UserListWish.RefreshFromNetwork)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun renderState(state: UserListState) {
        binding.refreshUserList.isRefreshing = state.isLoading

        if (state.users.isNotEmpty()) {
            userListAdapter.submitList(state.users)
        }
    }

    override fun renderNews(new: UserListNews) {
        when (new) {
            is UserListNews.Message -> {
                Toast.makeText(requireContext(), new.content, Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val PREFS_NAME = "PrefsFile"
        private const val SETTINGS_FIRST_TIME = "first_time"
    }
}