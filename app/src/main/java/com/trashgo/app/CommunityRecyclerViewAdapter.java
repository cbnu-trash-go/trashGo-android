package com.trashgo.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
/*by dotom*/
public class CommunityRecyclerViewAdapter extends RecyclerView.Adapter<CommunityRecyclerViewAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_Title_item;
        TextView txt_Content_item;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_Title_item = (TextView) itemView.findViewById(R.id.title);
            txt_Content_item = (TextView) itemView.findViewById(R.id.content);
        }
    }

    private ArrayList<CommunityRecyclerItem> mList = null;

    public CommunityRecyclerViewAdapter(ArrayList<CommunityRecyclerItem> mList) {
        this.mList = mList;
    }

    // 아이템 뷰를 위한 뷰홀더 객체를 생성하여 리턴
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.community_recycler_item, parent, false);
        CommunityRecyclerViewAdapter.ViewHolder vh = new CommunityRecyclerViewAdapter.ViewHolder(view);
        return vh;
    }

    // position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시
    @Override
    public void onBindViewHolder(@NonNull CommunityRecyclerViewAdapter.ViewHolder holder, int position) {
        CommunityRecyclerItem item = mList.get(position);

        holder.txt_Title_item.setText(item.getTitle());
        holder.txt_Content_item.setText(item.getContent());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


}