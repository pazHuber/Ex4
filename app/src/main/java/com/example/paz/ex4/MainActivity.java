package com.example.paz.ex4;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends FragmentActivity {
    private Button menuBtn;
    private TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            menuBtn = (Button) findViewById(R.id.menuButton);
            menuBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    fm.popBackStack();
                    ft.add(R.id.MainActivityMenu, new MenuFragment());
                    ft.addToBackStack(null);
                    ft.commit();
                }
            });
            t = (TextView) findViewById(R.id.swipeHelper);
            t.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
                @Override
                public void onSwipeLeft() {
                    setFragment();
                }

                @Override
                public void onSwipeRight() {
                    setFragment();
                }
            });
        }


        //if the android device is in landscape position:
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Fragment newFriendsFragment = new FriendsListFregment();
            ft.add(R.id.friendsList_Layout, newFriendsFragment);
        }
        Fragment mapFragmant = new com.example.paz.ex4.MapFragment();
        ft.add(R.id.map_Layout, mapFragmant);
        ft.commit();


    }
    private void setFragment() {
        if(getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE) {
            FragmentManager fm1 = getSupportFragmentManager();
            FragmentTransaction ft1 = fm1.beginTransaction();
            fm1.popBackStack();
            ft1.add(R.id.VerticalFriendList_Layout, new FriendsListFregment());
            ft1.addToBackStack(null);
            ft1.commit();
        }

    }


}
