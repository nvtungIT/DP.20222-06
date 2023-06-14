public class DVDFactory extends MediaFactory {
    public Media createMedia(int id, String title, String category, int price, int quantity, String type, Object... args) {
        String discType = (String) args[0];
        String director = (String) args[1];
        int runtime = (int) args[2];
        String studio = (String) args[3];
        String subtitles = (String) args[4];
        Date releasedDate = (Date) args[5];
        String filmType = (String) args[6];
        return new DVD(int id, String title, String category, int price, int quantity, String type, String discType,
            String director, int runtime, String studio, String subtitles, Date releasedDate, String filmType);
    }
}