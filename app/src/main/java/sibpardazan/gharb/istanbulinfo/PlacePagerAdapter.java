package sibpardazan.gharb.istanbulinfo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PlacePagerAdapter extends FragmentStateAdapter {

    public PlacePagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return PlaceFragment.newInstance(position);
    }

    @Override
    public int getItemCount() {
        return PlaceData.getPlaceCount();
    }
}