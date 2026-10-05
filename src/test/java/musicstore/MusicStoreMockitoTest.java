package musicstore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

@DisplayName("MusicStore (Mockito)")
class MusicStoreMockitoTest {

    private AlbumRepository repository;
    private MusicStore musicStore;

    @BeforeEach
    void setUp() {
        repository = mock(AlbumRepository.class);
        musicStore = new MusicStore(repository);
    }

    // TODO: позитивная проверка — findByTitle вызывается ровно один раз
    //       и возвращает цену найденного альбома

    // TODO: негативная проверка — пустой title → IllegalArgumentException,
    //       findByTitle НЕ вызывается (verify never + verifyNoInteractions)

    // TODO: негативная проверка — исключение из репозитория пробрасывается наружу
    //       (when(...).thenThrow(...))
}
