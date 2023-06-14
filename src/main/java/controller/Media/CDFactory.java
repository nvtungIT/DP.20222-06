public class CDFactory extends MediaFactory {
    public Media createMedia(int id, String title, String category, int price, int quantity, String type, Object... args) {
        String artist = (String) args[0];
        String recordLabel = (String) args[1];
        String musicType = (String) args[2];
        Date releasedDate = (Date) args[3];
        return new CD(int id, String title, String category, int price, int quantity, String type, String artist,
            String recordLabel, String musicType, Date releasedDate);
    }
}