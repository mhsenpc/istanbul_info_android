package sibpardazan.gharb.istanbulinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    private List<SearchActivity.SearchResult> searchResults;
    private OnPlaceClickListener listener;

    public interface OnPlaceClickListener {
        void onPlaceClick(SearchActivity.SearchResult searchResult);
    }

    public SearchAdapter(List<SearchActivity.SearchResult> searchResults, OnPlaceClickListener listener) {
        this.searchResults = searchResults;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_search_result, parent, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        SearchActivity.SearchResult searchResult = searchResults.get(position);
        holder.bind(searchResult);
    }

    @Override
    public int getItemCount() {
        return searchResults.size();
    }

    class SearchViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPlaceImage;
        private TextView tvPlaceTitle;
        private TextView tvPlaceOriginalName;
        private TextView tvPlaceDescription;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPlaceImage = itemView.findViewById(R.id.iv_place_image);
            tvPlaceTitle = itemView.findViewById(R.id.tv_place_title);
            tvPlaceOriginalName = itemView.findViewById(R.id.tv_place_original_name);
            tvPlaceDescription = itemView.findViewById(R.id.tv_place_description);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && listener != null) {
                    listener.onPlaceClick(searchResults.get(position));
                }
            });
        }

        public void bind(SearchActivity.SearchResult searchResult) {
            PlaceData.PlaceContent place = searchResult.placeContent;

            tvPlaceTitle.setText(place.title);
            tvPlaceOriginalName.setText(place.originalName);
            tvPlaceDescription.setText(searchResult.description);

            // Load place image
            loadImage(place.imageName);
        }

        private void loadImage(String imageName) {
            try {
                Context context = itemView.getContext();
                int imageResourceId = context.getResources().getIdentifier(
                        imageName.contains(".") ? imageName.substring(0, imageName.lastIndexOf('.')) : imageName,
                        "drawable",
                        context.getPackageName()
                );

                if (imageResourceId != 0) {
                    ivPlaceImage.setImageResource(imageResourceId);
                } else {
                    // Use default placeholder
                    ivPlaceImage.setImageResource(R.drawable.ic_launcher_foreground);
                }
            } catch (Exception e) {
                // Use default placeholder on error
                ivPlaceImage.setImageResource(R.drawable.ic_launcher_foreground);
            }
        }
    }
}