package com.example.scv.ui.nastavitve;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NastavitveViewModel extends ViewModel {


    private MutableLiveData<String> mText;

    public NastavitveViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}