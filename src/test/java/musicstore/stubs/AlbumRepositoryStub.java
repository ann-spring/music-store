package musicstore.stubs;

import musicstore.Album;
import musicstore.AlbumRepositoryImpl;

/**
 * Тестовый стаб: репозиторий, заполненный набором альбомов по умолчанию.
 * Наследует рабочую реализацию AlbumRepositoryImpl,
 * но не требует ручного наполнения в каждом тесте.
 */
public class AlbumRepositoryStub extends AlbumRepositoryImpl {

    public AlbumRepositoryStub() {
        super();
        addDefaultAlbums();
    }

    private void addDefaultAlbums() {
        add(new Album("Nevermind", "Nirvana", 1991, 19.99));
        add(new Album("In Utero", "Nirvana", 1993, 15.50));
        add(new Album("Bad", "Michael Jackson", 1987, 12.99));
        add(new Album("Thriller", "Michael Jackson", 1982, 14.99));
        add(new Album("Hybrid Theory", "Linkin Park", 2000, 21.50));
    }
}
