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
                    context.getString(R.string.hagia_sophia),
                    context.getString(R.string.hagia_sophia_history),
                    context.getString(R.string.hagia_sophia_info),
                    context.getString(R.string.hagia_sophia_tips),
                    "hagia_sophia.png",
                    context.getString(R.string.hagia_sophia_original)
                );
            case 1:
                return new PlaceContent(
                    context.getString(R.string.blue_mosque),
                    context.getString(R.string.blue_mosque_history),
                    context.getString(R.string.blue_mosque_info),
                    context.getString(R.string.blue_mosque_tips),
                    "blue_mosque.png",
                    context.getString(R.string.blue_mosque_original)
                );
            case 2:
                return new PlaceContent(
                    context.getString(R.string.topkapi_palace),
                    context.getString(R.string.topkapi_palace_history),
                    context.getString(R.string.topkapi_palace_info),
                    context.getString(R.string.topkapi_palace_tips),
                    "topkapi_palace.png",
                    context.getString(R.string.topkapi_palace_original)
                );
            case 3:
                return new PlaceContent(
                    context.getString(R.string.suleymaniye_mosque),
                    context.getString(R.string.suleymaniye_mosque_history),
                    context.getString(R.string.suleymaniye_mosque_info),
                    context.getString(R.string.suleymaniye_mosque_tips),
                    "suleymaniye_mosque.png",
                    context.getString(R.string.suleymaniye_mosque_original)
                );
            case 4:
                return new PlaceContent(
                    context.getString(R.string.grand_bazaar),
                    context.getString(R.string.grand_bazaar_history),
                    context.getString(R.string.grand_bazaar_info),
                    context.getString(R.string.grand_bazaar_tips),
                    "grand_bazaar.png",
                    context.getString(R.string.grand_bazaar_original)
                );
            case 5:
                return new PlaceContent(
                    context.getString(R.string.dolmabahce_palace),
                    context.getString(R.string.dolmabahce_palace_history),
                    context.getString(R.string.dolmabahce_palace_info),
                    context.getString(R.string.dolmabahce_palace_tips),
                    "dolmabahce_palace.png",
                    context.getString(R.string.dolmabahce_palace_original)
                );
            case 6:
                return new PlaceContent(
                    context.getString(R.string.galata_tower),
                    context.getString(R.string.galata_tower_history),
                    context.getString(R.string.galata_tower_info),
                    context.getString(R.string.galata_tower_tips),
                    "galata_tower.png",
                    context.getString(R.string.galata_tower_original)
                );
            case 7:
                return new PlaceContent(
                    context.getString(R.string.galata_bridge),
                    context.getString(R.string.galata_bridge_history),
                    context.getString(R.string.galata_bridge_info),
                    context.getString(R.string.galata_bridge_tips),
                    "galata_bridge.png",
                    context.getString(R.string.galata_bridge_original)
                );
            case 8:
                return new PlaceContent(
                    context.getString(R.string.basilica_cistern),
                    context.getString(R.string.basilica_cistern_history),
                    context.getString(R.string.basilica_cistern_info),
                    context.getString(R.string.basilica_cistern_tips),
                    "basilica_cistern.png",
                    context.getString(R.string.basilica_cistern_original)
                );
            case 9:
                return new PlaceContent(
                    context.getString(R.string.hagia_sophia_museum),
                    context.getString(R.string.hagia_sophia_museum_history),
                    context.getString(R.string.hagia_sophia_museum_info),
                    context.getString(R.string.hagia_sophia_museum_tips),
                    "hagia_sophia_museum.png",
                    context.getString(R.string.hagia_sophia_museum_original)
                );
            case 10:
                return new PlaceContent(
                    context.getString(R.string.maidens_tower),
                    context.getString(R.string.maidens_tower_history),
                    context.getString(R.string.maidens_tower_info),
                    context.getString(R.string.maidens_tower_tips),
                    "maidens_tower.png",
                    context.getString(R.string.maidens_tower_original)
                );
            case 11:
                return new PlaceContent(
                    context.getString(R.string.beylerbeyi_palace),
                    context.getString(R.string.beylerbeyi_palace_history),
                    context.getString(R.string.beylerbeyi_palace_info),
                    context.getString(R.string.beylerbeyi_palace_tips),
                    "beylerbeyi_palace.png",
                    context.getString(R.string.beylerbeyi_palace_original)
                );
            case 12:
                return new PlaceContent(
                    context.getString(R.string.istiklal_avenue),
                    context.getString(R.string.istiklal_avenue_history),
                    context.getString(R.string.istiklal_avenue_info),
                    context.getString(R.string.istiklal_avenue_tips),
                    "istiklal_avenue.png",
                    context.getString(R.string.istiklal_avenue_original)
                );
            case 13:
                return new PlaceContent(
                    context.getString(R.string.ahrida_synagogue),
                    context.getString(R.string.ahrida_synagogue_history),
                    context.getString(R.string.ahrida_synagogue_info),
                    context.getString(R.string.ahrida_synagogue_tips),
                    "ahrida_synagogue.png",
                    context.getString(R.string.ahrida_synagogue_original)
                );
            case 14:
                return new PlaceContent(
                    context.getString(R.string.turkish_islamic_arts_museum),
                    context.getString(R.string.turkish_islamic_arts_museum_history),
                    context.getString(R.string.turkish_islamic_arts_museum_info),
                    context.getString(R.string.turkish_islamic_arts_museum_tips),
                    "turkish_islamic_arts_museum.png",
                    context.getString(R.string.turkish_islamic_arts_museum_original)
                );
            case 15:
                return new PlaceContent(
                    context.getString(R.string.ataturk_airport),
                    context.getString(R.string.ataturk_airport_history),
                    context.getString(R.string.ataturk_airport_info),
                    context.getString(R.string.ataturk_airport_tips),
                    "ataturk_airport.png",
                    context.getString(R.string.ataturk_airport_original)
                );
            case 16:
                return new PlaceContent(
                    context.getString(R.string.egyptian_bazaar),
                    context.getString(R.string.egyptian_bazaar_history),
                    context.getString(R.string.egyptian_bazaar_info),
                    context.getString(R.string.egyptian_bazaar_tips),
                    "egyptian_bazaar.png",
                    context.getString(R.string.egyptian_bazaar_original)
                );
            case 17:
                return new PlaceContent(
                    context.getString(R.string.rumeli_fortress),
                    context.getString(R.string.rumeli_fortress_history),
                    context.getString(R.string.rumeli_fortress_info),
                    context.getString(R.string.rumeli_fortress_tips),
                    "rumeli_fortress.png",
                    context.getString(R.string.rumeli_fortress_original)
                );
            case 18:
                return new PlaceContent(
                    context.getString(R.string.gulhane_park),
                    context.getString(R.string.gulhane_park_history),
                    context.getString(R.string.gulhane_park_info),
                    context.getString(R.string.gulhane_park_tips),
                    "gulhane_park.png",
                    context.getString(R.string.gulhane_park_original)
                );
            case 19:
                return new PlaceContent(
                    context.getString(R.string.theodosian_walls),
                    context.getString(R.string.theodosian_walls_history),
                    context.getString(R.string.theodosian_walls_info),
                    context.getString(R.string.theodosian_walls_tips),
                    "theodosian_walls.png",
                    context.getString(R.string.theodosian_walls_original)
                );
            default:
                return null;
        }
    }

    public static String[] getAllPlaceNames(Context context) {
        String[] placeNames = new String[getPlaceCount()];

        placeNames[0] = context.getString(R.string.hagia_sophia);
        placeNames[1] = context.getString(R.string.blue_mosque);
        placeNames[2] = context.getString(R.string.topkapi_palace);
        placeNames[3] = context.getString(R.string.suleymaniye_mosque);
        placeNames[4] = context.getString(R.string.grand_bazaar);
        placeNames[5] = context.getString(R.string.dolmabahce_palace);
        placeNames[6] = context.getString(R.string.galata_tower);
        placeNames[7] = context.getString(R.string.galata_bridge);
        placeNames[8] = context.getString(R.string.basilica_cistern);
        placeNames[9] = context.getString(R.string.hagia_sophia_museum);
        placeNames[10] = context.getString(R.string.maidens_tower);
        placeNames[11] = context.getString(R.string.beylerbeyi_palace);
        placeNames[12] = context.getString(R.string.istiklal_avenue);
        placeNames[13] = context.getString(R.string.ahrida_synagogue);
        placeNames[14] = context.getString(R.string.turkish_islamic_arts_museum);
        placeNames[15] = context.getString(R.string.ataturk_airport);
        placeNames[16] = context.getString(R.string.egyptian_bazaar);
        placeNames[17] = context.getString(R.string.rumeli_fortress);
        placeNames[18] = context.getString(R.string.gulhane_park);
        placeNames[19] = context.getString(R.string.theodosian_walls);

        return placeNames;
    }

    public static int getPlaceCount() {
        return 20;
    }
}