package com.loginandsignup.account;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loginandsignup.models.Address;
import com.loginandsignup.R;

import java.util.ArrayList;


public class MyAddressFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Address> addressArrayList;
    MyAddressAdapter myAddressAdapter;
    Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_address, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        toolbar = view.findViewById(R.id.toolbar_my_orders);
        toolbar.inflateMenu(R.menu.toolbar_menu);




        recyclerView=view.findViewById(R.id.my_address_recycler_view);
        addressArrayList=new ArrayList<>();
        addressArrayList.add(new Address("Aman Pandey",
                "New Delhi",
                "C-26 Vijay Vihar Phase -2 Rohini Delhi -85","Delhi -110085","9000000001"));

        addressArrayList.add(new Address("Vipasha Bhaskar",
                "New Delhi",
                "C-52 Vijay Vihar Phase -2 Rohini Delhi -85","Delhi -110085","9000000002"));

        myAddressAdapter=new MyAddressAdapter(getActivity(),addressArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(myAddressAdapter);

    }
}