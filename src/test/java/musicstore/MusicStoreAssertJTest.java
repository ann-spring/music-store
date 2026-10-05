package musicstore;

import musicstore.stubs.AlbumRepositoryStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("MusicStore (AssertJ)")
class MusicStoreAssertJTest {

    // TODO: позитивная проверка — скидка 10% на "Nevermind" → 17.99

    // TODO: позитивная проверка — скидка 0% → 19.99

    // TODO: позитивная проверка — скидка 100% → 0.0

    // TODO: негативная проверка — скидка -1 → IllegalArgumentException

    // TODO: негативная проверка — альбом "Unknown" не найден → -1
}
