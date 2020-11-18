package fr.paulficot.artisbus.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import fr.paulficot.artisbus.Interface.ItemClickListener;
import fr.paulficot.artisbus.Model.RSSObject;
import fr.paulficot.artisbus.R;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;


class FeedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    public TextView txtTitle,txtContent;
    private ItemClickListener itemClickListener;

    public FeedViewHolder(View itemView) {
        super(itemView);

        txtTitle = itemView.findViewById(R.id.txtTitle);
        txtContent = itemView.findViewById(R.id.txtContent);

        //Set Event
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {

        itemClickListener.onClick(v,getAdapterPosition(),false);

    }

    @Override
    public boolean onLongClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),true);
        return true;
    }
}

public class FeedAdapter extends RecyclerView.Adapter<FeedViewHolder> {

    private RSSObject rssObject;
    private Context rssContext;
    private LayoutInflater inflater;

    public FeedAdapter(RSSObject rssObject, Context rssContext) {
        this.rssObject = rssObject;
        this.rssContext = rssContext;
        inflater = LayoutInflater.from(rssContext);
    }

    @NonNull
    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View itemView = inflater.inflate(R.layout.row,parent,false);
        return new FeedViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(FeedViewHolder holder, int position) {

        holder.txtTitle.setText(" " + rssObject.getItems().get(position).getTitle() + " ");
        holder.txtContent.setText((rssObject.getItems().get(position).getContent()).replaceAll("\\n<img.*>\\n *\\n *", ""));

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(!isLongClick)
                {
                    String url = rssObject.getItems().get(position).getLink();
                    //Toast.makeText(rssContext, url, Toast.LENGTH_SHORT).show();
                    Intent intentWeb = new Intent();
                    intentWeb.setAction(Intent.ACTION_VIEW);
                    intentWeb.addCategory(Intent.CATEGORY_BROWSABLE);

                    intentWeb.setData(Uri.parse(url));
                    intentWeb.setFlags(FLAG_ACTIVITY_NEW_TASK);
                    rssContext.startActivity(intentWeb);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return rssObject.items.size();
    }
}
