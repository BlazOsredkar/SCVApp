//Urniki Easistent
package com.example.scv.ui.dashboard;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
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
import com.example.scv.Sola;
import com.example.scv.Sole;
import com.example.scv.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private WebView webView;
    private FragmentDashboardBinding binding;
    private Sole SoleP = new Sole();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        SoleP.Load();

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        SharedPreferences prefs = getActivity().getSharedPreferences(SoleP.PREFS_NAME, MODE_PRIVATE);
        String krajsava = prefs.getString(SoleP.PREF_IZBRANA_SOLA_KEY,"ERŠ");
        SoleP.shraniIzbranoSolo(krajsava);
        Sola izbranaSola = SoleP.dobiTrenutnoSolo();


        webView = (WebView) root.findViewById(R.id.webView3);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(izbranaSola.url_urnik);

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