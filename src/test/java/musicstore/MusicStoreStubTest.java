package musicstore;

import musicstore.stubs.AlbumRepositoryStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("MusicStore (со стабом)")
class MusicStoreStubTest {
    
    // Стаб заполнен 5 альбомами → магазин не пуст
    @Test
    @DisplayName("непустой стаб → магазин не пуст")
    void isStoreEmpty_returnsFalse_whenStubHasAlbums() {
        MusicStore store = new MusicStore(new AlbumRepositoryStub());
        assertThat(store.isStoreEmpty()).isFalse();
        assertThat(store.getAlbumCount()).isEqualTo(5);
    }
    // Пустой репозиторий → магазин пуст
    @Test
    @DisplayName("пустой репозиторий → магазин пуст")
    void isStoreEmpty_returnsTrue_whenRepositoryIsEmpty() {
        MusicStore store = new MusicStore(new AlbumRepositoryImpl());
        assertThat(store.isStoreEmpty()).isTrue();
        assertThat(store.getAlbumCount()).isZero();
    }
}
