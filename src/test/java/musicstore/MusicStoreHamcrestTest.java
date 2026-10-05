package musicstore;

import musicstore.stubs.AlbumRepositoryStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DisplayName("MusicStore (Hamcrest)")
class MusicStoreHamcrestTest {

    // TODO: позитивная проверка — сумма альбомов Nirvana = 35.49

    // TODO: позитивная проверка — массив Nirvana имеет размер 2

    // TODO: негативная проверка — исполнитель Unknown → сумма 0.0

    // TODO: негативная проверка — массив Unknown пустой (arrayWithSize(0))
}
