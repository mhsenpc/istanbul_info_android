package sibpardazan.gharb.istanbulinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.card.MaterialCardView;

public class PlaceFragment extends Fragment {

    private static final String ARG_PLACE_INDEX = "place_index";

    private int placeIndex;

    public PlaceFragment() {
        // Required empty public constructor
    }

    public static PlaceFragment newInstance(int placeIndex) {
        PlaceFragment fragment = new PlaceFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PLACE_INDEX, placeIndex);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            placeIndex = getArguments().getInt(ARG_PLACE_INDEX);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_place, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get views
        TextView titleText = view.findViewById(R.id.tv_title);
        TextView historyText = view.findViewById(R.id.tv_history);
        TextView infoText = view.findViewById(R.id.tv_info);
        TextView tipsText = view.findViewById(R.id.tv_tips);
        ImageView imageView = view.findViewById(R.id.iv_place);
        TextView originalNameText = view.findViewById(R.id.tv_original_name);

        // Try to load actual content
        PlaceData.PlaceContent placeContent = PlaceData.getPlace(placeIndex, requireContext());

        if (placeContent != null) {
            titleText.setText(placeContent.title);
            historyText.setText(placeContent.history);
            infoText.setText(placeContent.info);
            tipsText.setText(placeContent.tips);

            // Display image information
            originalNameText.setText(getString(R.string.original_name_label) + " " + placeContent.originalName);

            // Make image info visible
            originalNameText.setVisibility(View.VISIBLE);

            // Try to load image with error handling
            loadImageWithFallback(imageView, placeContent.imageName);

            // Debug logging
            android.util.Log.d("PlaceFragment", "Loaded place " + placeIndex + ": " + placeContent.title);
        } else {
            android.util.Log.e("PlaceFragment", "Failed to load place content for index: " + placeIndex);
            // Show error message
            titleText.setText(getString(R.string.error_loading_content));
            historyText.setText(getString(R.string.error_content_unavailable));
            infoText.setText(getString(R.string.error_try_again));
            tipsText.setText("");

            // Hide image info on error
            originalNameText.setVisibility(View.GONE);

            // Show default placeholder
            imageView.setImageResource(R.drawable.ic_launcher_foreground);
        }
    }

    private void loadImageWithFallback(ImageView imageView, String imageName) {
        try {
            // Try to get image resource by name
            int imageResourceId = getResourceIdByName(imageName);
            if (imageResourceId != 0) {
                imageView.setImageResource(imageResourceId);
                android.util.Log.d("PlaceFragment", "Successfully loaded image: " + imageName);
            } else {
                // Image not found, use placeholder
                showImagePlaceholder(imageView, imageName);
            }
        } catch (Exception e) {
            android.util.Log.e("PlaceFragment", "Error loading image: " + imageName, e);
            showImagePlaceholder(imageView, imageName);
        }
    }

    private void showImagePlaceholder(ImageView imageView, String imageName) {
        // Use default launcher icon as placeholder
        imageView.setImageResource(R.drawable.ic_launcher_foreground);
        android.util.Log.w("PlaceFragment", "Image not found: " + imageName + ", using placeholder");
    }

    private int getResourceIdByName(String imageName) {
        // Remove file extension if present
        String resourceName = imageName.contains(".") ?
            imageName.substring(0, imageName.lastIndexOf('.')) : imageName;

        return requireContext().getResources().getIdentifier(
            resourceName,
            "drawable",
            requireContext().getPackageName()
        );
    }
}