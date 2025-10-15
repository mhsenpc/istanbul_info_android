package sibpardazan.gharb.istanbulinfo;

import android.content.Context;

public class PlaceData {

    public static class PlaceContent {
        public String title;
        public String history;
        public String info;
        public String tips;
        public String imageName;
        public String originalName;

        public PlaceContent(String title, String history, String info, String tips, String imageName, String originalName) {
            this.title = title;
            this.history = history;
            this.info = info;
            this.tips = tips;
            this.imageName = imageName;
            this.originalName = originalName;
        }
    }

    public static PlaceContent getPlace(int index, Context context) {

        switch (index) {
            case 0:
                return new PlaceContent(
                    context.getString(R.string.brandenburg_gate),
                    context.getString(R.string.brandenburg_gate_history),
                    context.getString(R.string.brandenburg_gate_info),
                    context.getString(R.string.brandenburg_gate_tips),
                    "brandenburg_gate.png",
                    context.getString(R.string.brandenburg_gate_original)
                );
            case 1:
                return new PlaceContent(
                    context.getString(R.string.berlin_wall),
                    context.getString(R.string.berlin_wall_history),
                    context.getString(R.string.berlin_wall_info),
                    context.getString(R.string.berlin_wall_tips),
                    "berlin_wall.png",
                    context.getString(R.string.berlin_wall_original)
                );
            case 2:
                return new PlaceContent(
                    context.getString(R.string.reichstag),
                    context.getString(R.string.reichstag_history),
                    context.getString(R.string.reichstag_info),
                    context.getString(R.string.reichstag_tips),
                    "reichstag.png",
                    context.getString(R.string.reichstag_original)
                );
            case 3:
                return new PlaceContent(
                    context.getString(R.string.museum_island),
                    context.getString(R.string.museum_island_history),
                    context.getString(R.string.museum_island_info),
                    context.getString(R.string.museum_island_tips),
                    "museum_island.png",
                    context.getString(R.string.museum_island_original)
                );
            case 4:
                return new PlaceContent(
                    context.getString(R.string.charlottenburg_palace),
                    context.getString(R.string.charlottenburg_palace_history),
                    context.getString(R.string.charlottenburg_palace_info),
                    context.getString(R.string.charlottenburg_palace_tips),
                    "charlottenburg_palace.png",
                    context.getString(R.string.charlottenburg_palace_original)
                );
            case 5:
                return new PlaceContent(
                    context.getString(R.string.berlin_cathedral),
                    context.getString(R.string.berlin_cathedral_history),
                    context.getString(R.string.berlin_cathedral_info),
                    context.getString(R.string.berlin_cathedral_tips),
                    "berlin_cathedral.png",
                    context.getString(R.string.berlin_cathedral_original)
                );
            case 6:
                return new PlaceContent(
                    context.getString(R.string.alexanderplatz),
                    context.getString(R.string.alexanderplatz_history),
                    context.getString(R.string.alexanderplatz_info),
                    context.getString(R.string.alexanderplatz_tips),
                    "alexanderplatz.png",
                    context.getString(R.string.alexanderplatz_original)
                );
            case 7:
                return new PlaceContent(
                    context.getString(R.string.potzdamer_platz),
                    context.getString(R.string.potzdamer_platz_history),
                    context.getString(R.string.potzdamer_platz_info),
                    context.getString(R.string.potzdamer_platz_tips),
                    "potsdamer_platz.png",
                    context.getString(R.string.potsdamer_platz_original)
                );
            case 8:
                return new PlaceContent(
                    context.getString(R.string.checkpoint_charlie),
                    context.getString(R.string.checkpoint_charlie_history),
                    context.getString(R.string.checkpoint_charlie_info),
                    context.getString(R.string.checkpoint_charlie_tips),
                    "checkpoint_charlie.png",
                    context.getString(R.string.checkpoint_charlie_original)
                );
            case 9:
                return new PlaceContent(
                    context.getString(R.string.berlin_zoo),
                    context.getString(R.string.berlin_zoo_history),
                    context.getString(R.string.berlin_zoo_info),
                    context.getString(R.string.berlin_zoo_tips),
                    "berlin_zoo.png",
                    context.getString(R.string.berlin_zoo_original)
                );
            case 10:
                return new PlaceContent(
                    context.getString(R.string.tv_tower),
                    context.getString(R.string.tv_tower_history),
                    context.getString(R.string.tv_tower_info),
                    context.getString(R.string.tv_tower_tips),
                    "tv_tower.png",
                    context.getString(R.string.tv_tower_original)
                );
            case 11:
                return new PlaceContent(
                    context.getString(R.string.holocaust_memorial),
                    context.getString(R.string.holocaust_memorial_history),
                    context.getString(R.string.holocaust_memorial_info),
                    context.getString(R.string.holocaust_memorial_tips),
                    "holocaust_memorial.png",
                    context.getString(R.string.holocaust_memorial_original)
                );
            case 12:
                return new PlaceContent(
                    context.getString(R.string.unter_den_linden),
                    context.getString(R.string.unter_den_linden_history),
                    context.getString(R.string.unter_den_linden_info),
                    context.getString(R.string.unter_den_linden_tips),
                    "unter_den_linden.png",
                    context.getString(R.string.unter_den_linden_original)
                );
            case 13:
                return new PlaceContent(
                    context.getString(R.string.kaiser_wilhelm_church),
                    context.getString(R.string.kaiser_wilhelm_church_history),
                    context.getString(R.string.kaiser_wilhelm_church_info),
                    context.getString(R.string.kaiser_wilhelm_church_tips),
                    "kaiser_wilhelm_church.png",
                    context.getString(R.string.kaiser_wilhelm_church_original)
                );
            case 14:
                return new PlaceContent(
                    context.getString(R.string.gropius_bau),
                    context.getString(R.string.gropius_bau_history),
                    context.getString(R.string.gropius_bau_info),
                    context.getString(R.string.gropius_bau_tips),
                    "gropius_bau.png",
                    context.getString(R.string.gropius_bau_original)
                );
            case 15:
                return new PlaceContent(
                    context.getString(R.string.tempelhof_airport),
                    context.getString(R.string.tempelhof_airport_history),
                    context.getString(R.string.tempelhof_airport_info),
                    context.getString(R.string.tempelhof_airport_tips),
                    "tempelhof_airport.png",
                    context.getString(R.string.tempelhof_airport_original)
                );
            case 16:
                return new PlaceContent(
                    context.getString(R.string.hackescher_markt),
                    context.getString(R.string.hackescher_markt_history),
                    context.getString(R.string.hackescher_markt_info),
                    context.getString(R.string.hackescher_markt_tips),
                    "hackescher_markt.png",
                    context.getString(R.string.hackescher_markt_original)
                );
            case 17:
                return new PlaceContent(
                    context.getString(R.string.spandau_citadel),
                    context.getString(R.string.spandau_citadel_history),
                    context.getString(R.string.spandau_citadel_info),
                    context.getString(R.string.spandau_citadel_tips),
                    "spandau_citadel.png",
                    context.getString(R.string.spandau_citadel_original)
                );
            case 18:
                return new PlaceContent(
                    context.getString(R.string.treptower_park),
                    context.getString(R.string.treptower_park_history),
                    context.getString(R.string.treptower_park_info),
                    context.getString(R.string.treptower_park_tips),
                    "treptower_park.png",
                    context.getString(R.string.treptower_park_original)
                );
            case 19:
                return new PlaceContent(
                    context.getString(R.string.east_side_gallery),
                    context.getString(R.string.east_side_gallery_history),
                    context.getString(R.string.east_side_gallery_info),
                    context.getString(R.string.east_side_gallery_tips),
                    "east_side_gallery.png",
                    context.getString(R.string.east_side_gallery_original)
                );
            default:
                return null;
        }
    }

    public static String[] getAllPlaceNames(Context context) {
        String[] placeNames = new String[getPlaceCount()];

        placeNames[0] = context.getString(R.string.brandenburg_gate);
        placeNames[1] = context.getString(R.string.berlin_wall);
        placeNames[2] = context.getString(R.string.reichstag);
        placeNames[3] = context.getString(R.string.museum_island);
        placeNames[4] = context.getString(R.string.charlottenburg_palace);
        placeNames[5] = context.getString(R.string.berlin_cathedral);
        placeNames[6] = context.getString(R.string.alexanderplatz);
        placeNames[7] = context.getString(R.string.potzdamer_platz);
        placeNames[8] = context.getString(R.string.checkpoint_charlie);
        placeNames[9] = context.getString(R.string.berlin_zoo);
        placeNames[10] = context.getString(R.string.tv_tower);
        placeNames[11] = context.getString(R.string.holocaust_memorial);
        placeNames[12] = context.getString(R.string.unter_den_linden);
        placeNames[13] = context.getString(R.string.kaiser_wilhelm_church);
        placeNames[14] = context.getString(R.string.gropius_bau);
        placeNames[15] = context.getString(R.string.tempelhof_airport);
        placeNames[16] = context.getString(R.string.hackescher_markt);
        placeNames[17] = context.getString(R.string.spandau_citadel);
        placeNames[18] = context.getString(R.string.treptower_park);
        placeNames[19] = context.getString(R.string.east_side_gallery);

        return placeNames;
    }

    public static int getPlaceCount() {
        return 20;
    }
}