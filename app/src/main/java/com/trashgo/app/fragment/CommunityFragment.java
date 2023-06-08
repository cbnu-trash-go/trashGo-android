package com.trashgo.app.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.trashgo.app.CommunityRecyclerItem;
import com.trashgo.app.CommunityRecyclerViewAdapter;
import com.trashgo.app.MainActivity;
import com.trashgo.app.MyCommunityRecyclerViewAdapter;
import com.trashgo.app.R;
import com.trashgo.app.placeholder.PlaceholderContent;

import java.sql.Array;
import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 */
/** 커뮤니티 By dotom*/
public class CommunityFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    private RecyclerView mRecyclerView;
    private ArrayList<CommunityRecyclerItem> mList;
    private MyCommunityRecyclerViewAdapter mRecyclerViewAdapter;
    MainActivity mainActivity;
    Button writebutton;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CommunityFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static CommunityFragment newInstance(int columnCount) {
        CommunityFragment fragment = new CommunityFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }


    }

    /**
     * by dotom
     */
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        mainActivity = (MainActivity) getActivity();
    }

    /**
     * by dotom
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_community_list, container, false);

        // Set the adapter

        mList = new ArrayList<>();
        addItem("6월 플로깅 같이 하실 분 구합니다", "플로깅 같이 하실 분 구합니다. 현재 2명 모여있습니다! 연락 주세요. ...");
        addItem("플로깅 장소 추천", "이번에 충북대학교에 플로깅을 하러 다녀왔는데 학교가 널찍하니 좋더라고요. 추천합니다! ...");
        addItem("분리수거 어떻게 하시나요?", "분리수거 하려고 하는데 도통 뭐가 뭔지를 잘 모르겠네요.. 다들 어떤 식으로 알 ...");
        addItem("청주) 플로깅 조끼 나눔합니다.", "플로깅 할 때 입고 다니려고 맞춘 조끼가 여러개 있는데, 무료 나눔합니다! 연락주 ...");
        addItem("6월 9일에 한강 플로깅 하려 하는데 오실 분 계신가요?", "한강에서 밤에 해 지고 시원해지면 플로깅 좀 하려고 합니다 ...");
        addItem("플로깅 장소 추천해주세요.", "건강이랑 환경 좀 돌볼겸 플로깅 해보려 하는데 어디가 좋나요? 처음이 ...");


        mRecyclerView = (RecyclerView) view.findViewById(R.id.list);
        mRecyclerViewAdapter = new MyCommunityRecyclerViewAdapter(mList);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

        writebutton = view.findViewById(R.id.writebutton);
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        writebutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mainActivity.fragmentChange(1);
            }
        });
        return view;
    }
    /** By dotom*/
    public void addItem(String title, String content){
        CommunityRecyclerItem item = new CommunityRecyclerItem();

        item.setTitle(title);
        item.setContent(content);

        mList.add(item);
    }

}