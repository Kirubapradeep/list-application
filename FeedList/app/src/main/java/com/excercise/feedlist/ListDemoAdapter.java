package com.excercise.feedlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.excercise.feedlist.model.ListItem;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by pradeepraj-ext on 27-04-2016.
 */
public class ListDemoAdapter extends RecyclerView.Adapter<ListDemoAdapter.ViewHolder> {

    private final List<ListItem> mItems;
    private final Picasso mPicasso;

    public ListDemoAdapter(List<ListItem> listItems, Context context) {
        mItems = listItems;
        mPicasso = Picasso.with(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ListItem item = mItems.get(position);

        holder.title.setText(item.getTitle());
        holder.description.setText(item.getDescription());
        mPicasso.load(item.getImageHref())
                .placeholder(R.drawable.placeholder)
                .resizeDimen(R.dimen.image_width, R.dimen.image_height)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView title;
        final TextView description;
        final ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            imageView = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
