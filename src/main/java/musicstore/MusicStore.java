package musicstore;

public class MusicStore {

    private final AlbumRepository repository;

    public MusicStore(AlbumRepository repository) {
        if (repository == null) {
            throw new IllegalArgumentException("Repository cannot be null");
        }
        this.repository = repository;
    }

    /**
     * Находит альбом по названию и возвращает его цену.
     * Если альбом не найден — возвращает -1.
     */
    public double getPriceByTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        Album album = repository.findByTitle(title);
        return album == null ? -1 : album.getPrice();
    }

    /**
     * Считает суммарную стоимость всех альбомов исполнителя.
     * Если альбомов нет — 0.0.
     * Результат округляется до копеек.
     */
    public double getTotalPriceByArtist(String artist) {
        if (artist == null || artist.isEmpty()) {
            throw new IllegalArgumentException("Artist cannot be empty");
        }
        Album[] albums = repository.findByArtist(artist);
        double total = 0.0;
        for (int i = 0; i < albums.length; i++) {
            total += albums[i].getPrice();
        }
        return roundToCents(total);
    }

    /**
     * Проверяет, есть ли в магазине хотя бы один альбом.
     */
    public boolean isStoreEmpty() {
        return repository.findAll().length == 0;
    }

    /**
     * Возвращает количество альбомов в магазине.
     */
    public int getAlbumCount() {
        return repository.findAll().length;
    }

    /**
     * Применяет скидку к цене альбома.
     * Результат округляется до копеек.
     *
     * @param title            название альбома
     * @param discountPercent  процент скидки (0..100)
     * @return цена со скидкой, либо -1, если альбом не найден
     */
    public double getDiscountedPrice(String title, int discountPercent) {
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Discount must be between 0 and 100");
        }
        Album album = repository.findByTitle(title);
        if (album == null) {
            return -1;
        }
        double discounted = album.getPrice() * (100 - discountPercent) / 100.0;
        return roundToCents(discounted);
    }

    private double roundToCents(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
