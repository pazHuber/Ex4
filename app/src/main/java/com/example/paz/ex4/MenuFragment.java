    package com.example.paz.ex4;


import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;


    /**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    private Button newFriend;
    private Button listFriend;
    private Button back;
    private Button settings;
    private View view;

    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_menu, container, false);
        newFriend = (Button) view.findViewById(R.id.menuNewFriendButton);
        newFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NewFriendActivity.class);
                startActivity(intent);
            }
        });
        listFriend = (Button) view.findViewById(R.id.friendList);
        listFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                fm.popBackStack();
                Fragment flf = new FriendsListFregment();
                ft.add(R.id.VerticalFriendList_Layout, flf);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        back = (Button) view.findViewById(R.id.menuBackButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm1 = getFragmentManager();
                FragmentTransaction ft1 = fm1.beginTransaction();
                fm1.popBackStack();
                ft1.commit();

            }
        });
        settings = (Button) view.findViewById(R.id.menuSetting);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //settings fragment
            }
        });
        return view;
    }

    private void setFragment() {
        if(getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE) {
            FragmentManager fm1 = getFragmentManager();
            FragmentTransaction ft1 = fm1.beginTransaction();
            fm1.popBackStack();
            ft1.add(R.id.MainActivityMenu, new MenuFragment());
            ft1.addToBackStack(null);
            ft1.commit();
        }

    }


}
