package com.example.haider.networking;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreateNewMessageFragment extends Fragment {
    Activity activity;

    public CreateNewMessageFragment(Activity activity) {
        this.activity = activity;
    }

    public CreateNewMessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_new_message, container, false);
        final EditText title = (EditText) view.findViewById(R.id.title);
        final EditText message = (EditText) view.findViewById(R.id.message);
        final EditText product = (EditText) view.findViewById(R.id.product);
        Button button = (Button) view.findViewById(R.id.createbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CreateMessageAsynctask createMessageAsynctask = new CreateMessageAsynctask(title.getText().toString() , message.getText().toString() , product.getText().toString() , activity);
                createMessageAsynctask.execute();

            }
        });

        return view;
    }

}
