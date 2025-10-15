package sibpardazan.gharb.istanbulinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkAdapter.BookmarkViewHolder> {

    private List<Integer> bookmarkedPlaces;
    private OnPlaceClickListener listener;
    private Context context;

    public interface OnPlaceClickListener {
        void onPlaceClick(int placeIndex);
    }

    public BookmarkAdapter(List<Integer> bookmarkedPlaces, OnPlaceClickListener listener) {
        this.bookmarkedPlaces = bookmarkedPlaces;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BookmarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_bookmark, parent, false);
        return new BookmarkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookmarkViewHolder holder, int position) {
        int placeIndex = bookmarkedPlaces.get(position);
        PlaceData.PlaceContent place = PlaceData.getPlace(placeIndex, context);

        if (place != null) {
            holder.titleText.setText(place.title);
            holder.originalNameText.setText(place.originalName);

            // Try to load image
            loadImage(holder.imageView, place.imageName);

            holder.cardView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onPlaceClick(placeIndex);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return bookmarkedPlaces.size();
    }

    private void loadImage(ImageView imageView, String imageName) {
        try {
            int imageResourceId = context.getResources().getIdentifier(
                imageName.contains(".") ? imageName.substring(0, imageName.lastIndexOf('.')) : imageName,
                "drawable",
                context.getPackageName()
            );

            if (imageResourceId != 0) {
                imageView.setImageResource(imageResourceId);
            } else {
                imageView.setImageResource(R.drawable.ic_launcher_foreground);
            }
        } catch (Exception e) {
            imageView.setImageResource(R.drawable.ic_launcher_foreground);
        }
    }

    static class BookmarkViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView cardView;
        TextView titleText;
        TextView originalNameText;
        ImageView imageView;

        BookmarkViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_bookmark);
            titleText = itemView.findViewById(R.id.tv_bookmark_title);
            originalNameText = itemView.findViewById(R.id.tv_bookmark_original_name);
            imageView = itemView.findViewById(R.id.iv_bookmark_image);
        }
    }
}