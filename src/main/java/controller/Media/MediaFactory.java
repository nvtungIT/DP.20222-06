public abstract class MediaFactory {
    public abstract Media createMedia(int id, String title, String category, int price, int quantity, String type, Object... args);
}