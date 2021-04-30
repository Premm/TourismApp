package com.example.tourismapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<TourismItem> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private boolean mIsVertical;

    RecyclerAdapter(Context context, List<TourismItem> data){
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Here I switch between the layout it should use depending on if mIsVertical is true or not. (I couldn't figure out how to get access to LayoutManager.orientation.)
        View view = mInflater.inflate(mIsVertical ? R.layout.item_row : R.layout.item_image, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        if(mIsVertical) {
            holder.itemTitle.setText(mData.get(position).getTitle());
            holder.itemDesc.setText(mData.get(position).getDescription());
        }
        holder.itemImage.setImageResource(mData.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView itemTitle;
        TextView itemDesc;
        ImageView itemImage;

        ViewHolder(View itemView) {
            super(itemView);
            itemTitle = itemView.findViewById(R.id.item_title);
            itemDesc = itemView.findViewById(R.id.item_desc);
            itemImage = itemView.findViewById(R.id.item_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    TourismItem getItem(int id) {
        return mData.get(id);
    }


    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // set the orientation of the recycler view. This way we dont need to make 2 different adapters.
    void setOrientation(boolean isVertical){
        mIsVertical = isVertical;
    }


    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
