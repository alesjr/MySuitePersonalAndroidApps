package com.example.blocknumbercall.Core.Infrastructure.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.blocknumbercall.Core.Application.ViewModel.ViewModelInterface;

public class HomeViewModel extends ViewModel implements ViewModelInterface {
    private final MutableLiveData<String> liveData;

    public HomeViewModel() {
        liveData = new MutableLiveData<>();
        liveData.setValue("This is home fragment");
    }

    public MutableLiveData<String> getLiveData() {
        return liveData;
    }
}
