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

import com.trashgo.app.CommunityRecyclerItem;
import com.trashgo.app.CommunityRecyclerViewAdapter;
import com.trashgo.app.MyCommunityRecyclerViewAdapter;
import com.trashgo.app.R;
import com.trashgo.app.placeholder.PlaceholderContent;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 */
public class CommunityFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    private RecyclerView mRecyclerView;
    private ArrayList<CommunityRecyclerItem> mList;
    private CommunityRecyclerViewAdapter mRecyclerViewAdapter;

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

        mList = new ArrayList<>();
        for(int i=0;i<10;i++){
            addItem("Title"+i, "Content"+i);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_community_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyCommunityRecyclerViewAdapter(mList));
        }
        return view;
    }

    public void addItem(String title, String content){
        CommunityRecyclerItem item = new CommunityRecyclerItem();

        item.setTitle(title);
        item.setContent(content);

        mList.add(item);
    }
}