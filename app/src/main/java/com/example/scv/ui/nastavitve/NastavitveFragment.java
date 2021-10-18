//Koda za Nastavitve
package com.example.scv.ui.nastavitve;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.scv.databinding.FragmentNastavitveBinding;

public class NastavitveFragment extends Fragment {

    private NastavitveViewModel nastavitveViewModel;
    private WebView webView;
    private FragmentNastavitveBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        nastavitveViewModel =
                new ViewModelProvider(this).get(NastavitveViewModel.class);

        binding = FragmentNastavitveBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        //ImageView imageView = (ImageView) root.findViewById(R.id.imageView2);
        


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}