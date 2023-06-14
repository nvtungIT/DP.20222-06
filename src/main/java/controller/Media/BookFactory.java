public class BookFactory extends MediaFactory {
    public Media createMedia(int id, String title, String category, int price, int quantity, String type, Object... args) {
        String author = (String) args[0];
        String coverType = (String) args[1];
        String publisher = (String) args[2];
        Date publishDate = (Date) args[3];
        Int numOfPages = (Int) args[4];
        String language = (String) args[5];
        String bookCategory = (String) args[6];
        return new Book(int id, String title, String category, int price, int quantity, String type, String author,
            String coverType, String publisher, Date publishDate, int numOfPages, String language,
            String bookCategory);
    }
}