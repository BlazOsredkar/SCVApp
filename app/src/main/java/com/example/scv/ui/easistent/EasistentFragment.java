//Koda za spletno stran Easistent
package com.example.scv.ui.easistent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.scv.R;
import com.example.scv.databinding.FragmentDashboardBinding;
import com.example.scv.ui.dashboard.DashboardViewModel;

public class EasistentFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private WebView webView;
    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        webView = (WebView) root.findViewById(R.id.webView3);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.easistent.com/");

        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.getSettings().setUseWideViewPort(true);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}