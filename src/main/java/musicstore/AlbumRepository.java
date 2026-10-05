package musicstore;

public interface AlbumRepository {

    /**
     * Возвращает альбом по названию, либо null, если альбом не найден.
     */
    Album findByTitle(String title);

    /**
     * Возвращает все альбомы указанного исполнителя.
     * Никогда не возвращает null; если ничего не найдено — пустой массив.
     */
    Album[] findByArtist(String artist);

    /**
     * Возвращает все альбомы в хранилище.
     * Никогда не возвращает null; если хранилище пустое — пустой массив.
     */
    Album[] findAll();
}
