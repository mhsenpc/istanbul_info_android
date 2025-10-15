package sibpardazan.gharb.istanbulinfo;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

public class BookmarkManager {
    private static final String PREFS_NAME = "bookmarks_prefs";
    private static final String KEY_BOOKMARKED_PLACES = "bookmarked_places";

    private SharedPreferences prefs;
    private static BookmarkManager instance;

    private BookmarkManager(Context context) {
        prefs = context.getApplicationContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized BookmarkManager getInstance(Context context) {
        if (instance == null) {
            instance = new BookmarkManager(context);
        }
        return instance;
    }

    public void addBookmark(int placeIndex) {
        Set<String> bookmarks = getBookmarkedPlacesSet();
        bookmarks.add(String.valueOf(placeIndex));
        prefs.edit().putStringSet(KEY_BOOKMARKED_PLACES, bookmarks).apply();
    }

    public void removeBookmark(int placeIndex) {
        Set<String> bookmarks = getBookmarkedPlacesSet();
        bookmarks.remove(String.valueOf(placeIndex));
        prefs.edit().putStringSet(KEY_BOOKMARKED_PLACES, bookmarks).apply();
    }

    public boolean isBookmarked(int placeIndex) {
        return getBookmarkedPlacesSet().contains(String.valueOf(placeIndex));
    }

    public void toggleBookmark(int placeIndex) {
        if (isBookmarked(placeIndex)) {
            removeBookmark(placeIndex);
        } else {
            addBookmark(placeIndex);
        }
    }

    private Set<String> getBookmarkedPlacesSet() {
        return new HashSet<>(prefs.getStringSet(KEY_BOOKMARKED_PLACES, new HashSet<>()));
    }

    public int[] getBookmarkedPlaces() {
        Set<String> bookmarkedStrings = getBookmarkedPlacesSet();
        int[] bookmarkedPlaces = new int[bookmarkedStrings.size()];
        int i = 0;
        for (String str : bookmarkedStrings) {
            try {
                bookmarkedPlaces[i] = Integer.parseInt(str);
                i++;
            } catch (NumberFormatException e) {
                // Ignore invalid entries
            }
        }
        return bookmarkedPlaces;
    }

    public int getBookmarkedCount() {
        return getBookmarkedPlacesSet().size();
    }
}