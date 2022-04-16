package com.example.blocknumbercall.Core.Application.Controller;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.blocknumbercall.Core.Application.ViewModel.ViewModelInterface;
import com.example.blocknumbercall.Core.Infrastructure.ViewModel.HomeViewModel;
import com.example.blocknumbercall.R;
import com.example.blocknumbercall.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding homeBinding;

    public View onCreateView(
        @NonNull LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState
    ) {
        ViewModelInterface homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        homeBinding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = homeBinding.getRoot();

        final TextView textView = homeBinding.textHome;
        homeViewModel.getLiveData().observe(getViewLifecycleOwner(), textView::setText);

        Toast.makeText(container.getContext(), "Desgraça", Toast.LENGTH_LONG);
        return root.getRootView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        homeBinding = null;
    }
}
