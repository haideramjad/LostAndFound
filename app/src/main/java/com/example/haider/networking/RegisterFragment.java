package com.example.haider.networking;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {
    Button button,button2;
    EditText name;
    EditText email;
    EditText password;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        button = (Button)view.findViewById(R.id.signup);
        button2 = (Button)view.findViewById(R.id.login);
        name = (EditText)view.findViewById(R.id.name);
        email = (EditText)view.findViewById(R.id.email);
        password = (EditText)view.findViewById(R.id.password);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String a=name.getText().toString();
            String b=email.getText().toString();
            String c=password.getText().toString();
            Log.e("sas", "onClick: "+a );
//                    NetworkRequestAndResponse asyncTask = new NetworkRequestAndResponse(getActivity());
//
            /*asyncTask.execute(a,b);*/
            final IUser userRequest = Register_Request.retrofit().create(IUser.class);
            final HashMap<String, Object> map=new HashMap<>();
            map.put("name",a);
            map.put("email",b);
            map.put("password",c);
            final ProgressDialog pro=new ProgressDialog(getActivity());
            pro.setCancelable(false);
            pro.setMessage("Please Wait...");
            pro.show();

            retrofit2.Call<register> call=userRequest.registerUser(map);
            call.enqueue(new Callback<register>() {
                @Override
                public void onResponse(Call<register> call, Response<register> response) {
                    Log.e(TAG, "onResponse: "+response.code() );
                    Log.e(TAG, "onResponse: "+response.body() );
                    Log.e(TAG, "onResponse: "+response.toString() );
                    if(response.code()==200){
                        pro.dismiss();
                        Toast.makeText(getActivity(), response.body().getBolean(), Toast.LENGTH_SHORT).show();
                    }else {
                        pro.dismiss();
                        Toast.makeText(getActivity(), "Already Exist", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<register> call, Throwable throwable) {
                    Log.e("Fail", "onFailure: ",throwable );
                    pro.dismiss();
                    Toast.makeText(getActivity(), "Fail", Toast.LENGTH_SHORT).show();

                }
            });
            }
        });
        return view;
    }
}
