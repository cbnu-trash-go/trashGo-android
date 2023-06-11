package com.trashgo.app.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.trashgo.app.MainActivity;
import com.trashgo.app.NoticeUpdateActivity;
import com.trashgo.app.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NoticeUpdateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoticeUpdateFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    NoticeUpdateActivity noticeUpdateActivity;

    public NoticeUpdateFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NoticeUpdateFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NoticeUpdateFragment newInstance(String param1, String param2) {
        NoticeUpdateFragment fragment = new NoticeUpdateFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        noticeUpdateActivity = (NoticeUpdateActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notice_update, container, false);

        Button btnNotice1 = view.findViewById(R.id.btnnotice1);
        btnNotice1.setOnClickListener(v -> noticeUpdateActivity.notice1Clicked());

        Button btnNotice2 = view.findViewById(R.id.btnnotice2);
        btnNotice2.setOnClickListener(v -> noticeUpdateActivity.notice2Clicked());

        Button btnUpdate1 = view.findViewById(R.id.btnupdate1);
        btnUpdate1.setOnClickListener(v -> noticeUpdateActivity.update1Clicked());

        Button btnUpdate2 = view.findViewById(R.id.btnupdate2);
        btnUpdate2.setOnClickListener(v -> noticeUpdateActivity.update2Clicked());
        return view;
    }
}