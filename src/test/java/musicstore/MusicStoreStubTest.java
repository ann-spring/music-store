package musicstore;

import musicstore.stubs.AlbumRepositoryStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("MusicStore (со стабом)")
class MusicStoreStubTest {

    // TODO: позитивная проверка — AlbumRepositoryStub заполнен →
    //       isStoreEmpty() = false, getAlbumCount() = 5

    // TODO: негативная проверка — пустой AlbumRepositoryImpl →
    //       isStoreEmpty() = true, getAlbumCount() = 0
}
