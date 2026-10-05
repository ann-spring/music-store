package musicstore;
import musicstore.stubs.AlbumRepositoryStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DisplayName("MusicStore (Hamcrest)")
class MusicStoreHamcrestTest {
    
    @Test
    @DisplayName("getTotalPriceByArtist суммирует альбомы из стаба")
    void getTotalPriceByArtist_sumsAlbums_fromStub() {
        AlbumRepositoryStub stub = new AlbumRepositoryStub();
        MusicStore store = new MusicStore(stub);
        // Сумма цен Nirvana: 19.99 + 15.50 = 35.49
        assertThat(store.getTotalPriceByArtist("Nirvana"), is(35.49));
        // Массив Nirvana имеет размер 2 (без привязки к порядку элементов)
        Album[] nirvana = stub.findByArtist("Nirvana");
        assertThat(nirvana, arrayWithSize(2));
        // Неизвестный исполнитель → сумма 0.0
        assertThat(store.getTotalPriceByArtist("Unknown"), is(0.0));
        // Неизвестный исполнитель → пустой массив
        assertThat(stub.findByArtist("Unknown"), arrayWithSize(0));
    }
}