package tr.com.mertkolgu.firebaseinstagramclone.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import tr.com.mertkolgu.firebaseinstagramclone.R;

public class FeedRecyclerAdapter extends RecyclerView.Adapter<FeedRecyclerAdapter.PostHolder> {

    private ArrayList<String> userMailList;
    private ArrayList<String> userCommentList;
    private ArrayList<String> userImageList;

    public FeedRecyclerAdapter(ArrayList<String> userMailList, ArrayList<String> userCommentList, ArrayList<String> userImageList) {
        this.userMailList = userMailList;
        this.userCommentList = userCommentList;
        this.userImageList = userImageList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_row, parent, false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        holder.mailText.setText(userMailList.get(position));
        holder.commentText.setText(userCommentList.get(position));
        Picasso.get().load(userImageList.get(position)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return userCommentList.size();
    }

    class PostHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView mailText;
        TextView commentText;

        public PostHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.recyclerViewImage);
            mailText = itemView.findViewById(R.id.recyclerViewTextMail);
            commentText = itemView.findViewById(R.id.recyclerViewTextComment);
        }
    }
}
