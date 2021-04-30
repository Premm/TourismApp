package com.example.tourismapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ItemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ItemFragment extends Fragment {

    private static String title;
    private static String desc;
    private static int image;


    public ItemFragment() {
        // Required empty public constructor
    }

    public static ItemFragment newInstance(TourismItem item) {
        ItemFragment fragment = new ItemFragment();
        title = item.getTitle();
        desc = item.getDescription();
        image = item.getImage();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_item, container, false);
        view.findViewById(R.id.item_image).setBackgroundResource(image);
        TextView itemDesc = view.findViewById(R.id.item_desc);
        itemDesc.setText(desc);
        TextView itemTitle = view.findViewById(R.id.item_title);
        itemTitle.setText(title);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { }
        });
        return view;
    }
    public void back(View view){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.popBackStack();
    }


}