package com.nacho.betago.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.nacho.betago.Activity.BookActivity;
import com.nacho.betago.R;

public class BookFragment extends Fragment implements View.OnClickListener {

    private LinearLayout ll_gobook;

    public BookFragment() { }

    public static BookFragment newInstance() {
        BookFragment fragment = new BookFragment();
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
        View view = inflater.inflate(R.layout.fragment_book, container, false);

        ll_gobook = view.findViewById(R.id.ll_gobook);
        ll_gobook.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_gobook:
                Intent intent = new Intent(getActivity(), BookActivity.class);
                startActivity(intent);
                break;
        }
    }
}