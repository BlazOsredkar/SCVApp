//Koda spletno stran sole
package com.example.scv.ui.home;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import com.example.scv.BaseFragment;
import com.example.scv.R;
import com.example.scv.Sola;
import com.example.scv.Sole;
import com.example.scv.databinding.FragmentHomeBinding;

public class HomeFragment extends BaseFragment {

    private HomeViewModel homeViewModel;
    public WebView webView;
    private FragmentHomeBinding binding;
    private Sole SoleP = new Sole();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SoleP.Load();
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        SharedPreferences prefs = getActivity().getSharedPreferences(SoleP.PREFS_NAME, MODE_PRIVATE);
        String krajsava = prefs.getString(SoleP.PREF_IZBRANA_SOLA_KEY,"ERŠ");
        SoleP.shraniIzbranoSolo(krajsava);
        Sola izbranaSola = SoleP.dobiTrenutnoSolo();

        webView = (WebView) root.findViewById(R.id.webView1);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(izbranaSola.url_strani);

        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.getSettings().setUseWideViewPort(true);
        Log.d("Test","Lol2");


        return root;
    }

    @Override
    public boolean onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
            Log.d("Test","Lol");
        }

        return true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}