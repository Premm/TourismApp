package com.example.tourismapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecyclerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecyclerFragment extends Fragment implements AdapterView.OnItemSelectedListener, RecyclerAdapter.ItemClickListener {

    private static final List<TourismItem> items = Arrays.asList(
            new TourismItem("Title", "Description", R.drawable.ic_launcher_background),
            new TourismItem("Title2", "Description2", R.drawable.ic_launcher_background),
            new TourismItem("Title", "Description", R.drawable.ic_launcher_background),
            new TourismItem("Title2", "Description2", R.drawable.ic_launcher_background),
            new TourismItem("Title", "Description", R.drawable.ic_launcher_background),
            new TourismItem("Title2", "Description2", R.drawable.ic_launcher_background)
    );

    private RecyclerAdapter adapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RecyclerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecyclerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecyclerFragment newInstance(String param1, String param2) {
        RecyclerFragment fragment = new RecyclerFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_recycler, container, false);

        RecyclerView verticalRecyclerView = rootView.findViewById(R.id.vertical_item_list);
        verticalRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RecyclerAdapter(getActivity(), items);
        adapter.setClickListener((RecyclerAdapter.ItemClickListener)this);
        adapter.setOrientation(true);
        verticalRecyclerView.setAdapter(adapter);

        RecyclerView recyclerView = rootView.findViewById(R.id.horizontal_item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        adapter = new RecyclerAdapter(getActivity(), items);
        adapter.setClickListener((RecyclerAdapter.ItemClickListener) this);
        adapter.setOrientation(false);
        recyclerView.setAdapter(adapter);

        return rootView;

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(View view, int position) {
        Fragment fragment = ItemFragment.newInstance(items.get(position));
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.recycler_fragment, fragment).addToBackStack("RecyclerFragment").commit();
    }
}