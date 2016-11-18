package com.boohee.boohee;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fragment> fragList=null;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private int currentfragmentIndex=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void tabFragment(int fragmentIndex){
        if(currentfragmentIndex!=fragmentIndex){
            manager=getSupportFragmentManager();
            transaction=manager.beginTransaction();
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
            Fragment formFragment=fragList.get(currentfragmentIndex);
            Fragment toFragment=fragList.get(fragmentIndex);
            if(!toFragment.isAdded()){
                transaction.hide(formFragment).add(R.id.mainFrag,toFragment);
            }else{
                transaction.hide(formFragment).show(toFragment);
            }
//                transaction.addToBackStack(null);
            transaction.commit();
            currentfragmentIndex=fragmentIndex;
        }
    }
}
