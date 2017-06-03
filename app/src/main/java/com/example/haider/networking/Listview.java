package com.example.haider.networking;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Listview extends Fragment {

    List<MessagePojo> list;
    Activity activity;

    public Listview(List<MessagePojo> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_listview, container, false);
        final ListView listView = (ListView) view.findViewById(R.id.listview);
        CustomViewAdapter customViewAdapter = new CustomViewAdapter(activity,list);
        listView.setAdapter(customViewAdapter);
       final Button button = (Button) view.findViewById(R.id.userbutton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                CreateNewMessageFragment createNewMessageFragment = new CreateNewMessageFragment(activity );
                fragmentManager.beginTransaction().replace(R.id.fragmentwrapper , createNewMessageFragment).commit();
                button.setVisibility(View.INVISIBLE);

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(activity, "Title : " + list.get(i).getTitle() + "\nProduct : " + list.get(i).getProduct() +
                        "\nMessage : " + list.get(i).getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
