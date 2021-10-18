package com.example.scv;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.scv.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private WebView webView;
    public Sole SoleP = new Sole();
    private Sola sola;

    private void checkFirstRun() {

        final String PREFS_NAME = "MyPrefsFile";
        final String PREF_VERSION_CODE_KEY = "version_code";
        final int DOESNT_EXIST = -1;

        // Get current version code
        int currentVersionCode = BuildConfig.VERSION_CODE;

        // Get saved version code
        SharedPreferences prefs = getSharedPreferences(SoleP.PREFS_NAME, MODE_PRIVATE);
        int savedVersionCode = prefs.getInt(PREF_VERSION_CODE_KEY, DOESNT_EXIST);
        String krajsava = prefs.getString(SoleP.PREF_IZBRANA_SOLA_KEY,"ERŠ");
        Log.d("Krajsava",krajsava);
        SoleP.shraniIzbranoSolo(krajsava);

        // Check for first run or upgrade
        sola = SoleP.dobiTrenutnoSolo();
        setTheme(sola.barva);
        MenuInflater menu = getMenuInflater();
        //urnik_item.setVisible(false);


        if (savedVersionCode == DOESNT_EXIST) {

            Intent intent = new Intent(this,IzberiSolo.class);
            startActivity(intent);


        } else if (currentVersionCode > savedVersionCode) {

            // TODO This is an upgrade
        }

        // Update the shared preferences with the current version code
        prefs.edit().putInt(PREF_VERSION_CODE_KEY, currentVersionCode).apply();
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SoleP.Load();
        checkFirstRun();


        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications,R.id.navigation_easistent,R.id.navigation_nastavitve)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);



        Menu menu = navView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        if(sola.krajsava.equals("VSŠ") || sola.krajsava.equals("MIC")){
            menuItem.setVisible(false);
        }





        //webView = (WebView) findViewById(R.id.webView1);
        //webView.setWebViewClient(new WebViewClient());
        //webView.loadUrl("https://ers.scv.si/sl/");


    }



    @Override
    public void onBackPressed() {

        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();

        Fragment fr = fragmentList.get(0);

        boolean handled = false;
        for(Fragment f : fr.getChildFragmentManager().getFragments()) {

            if(f instanceof BaseFragment) {

                handled = ((BaseFragment)f).onBackPressed();
                if(handled) {
                    Log.e("BaseActivity","Dela!");
                    break;
                }
            }
        }

        if(!handled) {
            super.onBackPressed();
            Log.e("BaseActivity","No handle!");
        }
    }

    public void goToIzberiSolo(View view){
        Intent intent = new Intent(this, IzberiSolo.class);
        startActivity(intent);
    }

}


