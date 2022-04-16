package com.example.andrometrixlite.CreateProject;

import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.andrometrixlite.BuildConfig;
import com.example.andrometrixlite.R;

public class FragmentNavigationManager implements NavigationManager {
    private static FragmentNavigationManager mInstance;
    private FragmentManager mFragmentManager;
    private ProjectCreationActivity projectCreationActivity;

    public static FragmentNavigationManager getInstance(ProjectCreationActivity projectCreationActivity){
        if(mInstance ==null)
            mInstance = new FragmentNavigationManager();
           // mInstance.configure(projectCreationActivity);
            return mInstance;
    }

    private void configure(ProjectCreationActivity projectCreationActivity) {
        this.projectCreationActivity =projectCreationActivity;
        mFragmentManager = projectCreationActivity.getSupportFragmentManager();
    }


    public void showFragment(String title){
        Toast.makeText(projectCreationActivity, title, Toast.LENGTH_SHORT).show();
        //showFragment(FragmentContent.newInstance(title),false);
   }
   public void showFragment(Fragment fragmentcontent, Boolean b){
        FragmentManager fm = mFragmentManager;
       FragmentTransaction ft = fm.beginTransaction().replace(R.id.container,fragmentcontent);
       ft.addToBackStack(null);
       if (b || !BuildConfig.DEBUG)
           ft.commitAllowingStateLoss();
       else
           ft.commit();
       fm.executePendingTransactions();
   }
}
