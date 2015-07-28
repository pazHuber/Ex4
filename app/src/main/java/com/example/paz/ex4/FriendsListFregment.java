package com.example.paz.ex4;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class FriendsListFregment extends Fragment {
    private ListView l;
    private ArrayList<String> names = new ArrayList<String>();
    public FriendsListFregment() {
        names.add("Eran Ozery-Broom");
        names.add("Paz Huber-Bride");
        names.add("Ella Huber");
        names.add("Shlomo Huber");
        names.add("Ravit Hadar");
        names.add("Ortal Rivkin");
        names.add("Matan Huber");
        names.add("Nava Ozery");
        names.add("Doron Ozery");
        names.add("Adi Ozery");
        names.add("Omer Ozery");
        names.add("Michal Ben Simon");
        names.add("Inbal Gerstein");
        names.add("Amit Shaham");
        names.add("Tal Zeevi");
        names.add("Mor Vinokour");
        names.add("Amit Roitman");
        names.add("Iftach Avital");
        names.add("Shaked Nimri");
        names.add("Shahar Sharvit");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_friends_list, container, false);

        ListView lstMenu = (ListView) view.findViewById(R.id.friendsListView);
        lstMenu.setOnTouchListener(new OnSwipeTouchListener(getActivity()) {
            @Override
            public void onSwipeLeft() {
                setFragment();
            }

            @Override
            public void onSwipeRight() {
                setFragment();
            }
            });
        List<MenuItem> friendsItems = new ArrayList<MenuItem>() ;
        for(int i=0;i<20;i++){
            friendsItems.add(new MenuItem(names.get(i), R.mipmap.icon_wed1, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), ChatActivity.class);
                    startActivity(intent);
                }
            }));
        }
        MenuAdapter menuAdapter = new MenuAdapter((Activity) getActivity(), friendsItems);
        lstMenu.setAdapter(menuAdapter);
        return view;
    }

    private  void setFragment() {
        if(getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE) {
            FragmentManager fm1 = getFragmentManager();
            FragmentTransaction ft1 = fm1.beginTransaction();
            fm1.popBackStack();
            //ft1.add(R.id.map_Layout, new MapFragment());
            //ft1.addToBackStack(null);
            ft1.commit();
        }
    }
}