package com.example.haider.networking;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
public class LoginFragment extends Fragment {
    Button button, button2;
    EditText ed1 , ed2;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_auth, container, false);
        button = (Button)view.findViewById(R.id.login);
        button2 = (Button)view.findViewById(R.id.signup);
        ed1 = (EditText)view.findViewById(R.id.email);
        ed2 = (EditText)view.findViewById(R.id.password);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                RegisterFragment blankFragment = new RegisterFragment();
                fragmentTransaction.replace(android.R.id.content, blankFragment).commit();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a=ed1.getText().toString();
                String b=ed2.getText().toString();
                Log.e("sas", "onClick: "+a );
                final IUser userRequest = NetworkRequestAndResponse.retrofit().create(IUser.class);
                final HashMap<String, Object> map=new HashMap<>();
                map.put("email",a);
                map.put("password",b);
                final ProgressDialog pro=new ProgressDialog(getActivity());
                pro.setCancelable(false);
                pro.setMessage("Authenticating...");
                pro.show();

                retrofit2.Call<login> call=userRequest.loginUser(map);
                call.enqueue(new Callback<login>() {
                    @Override
                    public void onResponse(Call<login> call, Response<login> response) {
                        Log.e(TAG, "onResponse: "+response.code() );
                        Log.e(TAG, "onResponse: "+response.body() );
                        Log.e(TAG, "onResponse: "+response.toString() );
                        if(response.code()==200){
                            pro.dismiss();
                            Intent intent = new Intent(getContext() , AdminPanel.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            getActivity().finish();
                            startActivity(intent);
                        }else {
                            pro.dismiss();
                            Toast.makeText(getActivity(), "Invalid Email or Password", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<login> call, Throwable throwable) {
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
