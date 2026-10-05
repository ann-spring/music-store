package musicstore;

import java.util.Arrays;

public class AlbumRepositoryImpl implements AlbumRepository {

    private Album[] storage;
    private int size;

    public AlbumRepositoryImpl() {
        this.storage = new Album[10];
        this.size = 0;
    }

    public void add(Album album) {
        if (album == null) {
            throw new IllegalArgumentException("Album cannot be null");
        }
        if (size == storage.length) {
            resizeStorage();
        }
        storage[size++] = album;
    }

    private void resizeStorage() {
        storage = Arrays.copyOf(storage, storage.length * 2);
    }

    @Override
    public Album findByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getTitle().equals(title)) {
                return storage[i];
            }
        }
        return null;
    }

    @Override
    public Album[] findByArtist(String artist) {
        Album[] tmp = new Album[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (storage[i].getArtist().equals(artist)) {
                tmp[count++] = storage[i];
            }
        }
        return trim(tmp, count);
    }

    @Override
    public Album[] findAll() {
        Album[] result = new Album[size];
        for (int i = 0; i < size; i++) {
            result[i] = storage[i];
        }
        return result;
    }

    private Album[] trim(Album[] arr, int length) {
        Album[] result = new Album[length];
        for (int i = 0; i < length; i++) {
            result[i] = arr[i];
        }
        return result;
    }
}
