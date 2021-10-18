package com.example.scv;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.List;

public class BaseActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {

        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();

        boolean handled = false;
        for(Fragment f : fragmentList) {
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
}
