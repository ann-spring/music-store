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
    
    // Позитивная проверка: findByTitle вызывается ровно один раз,
    // других взаимодействий с репозиторием нет
    @Test
    @DisplayName("findByTitle вызывается ровно один раз")
    void getPriceByTitle_callsRepositoryOnce() {
        Album album = new Album("Nevermind", "Nirvana", 1991, 19.99);
        when(repository.findByTitle("Nevermind")).thenReturn(album);
        double price = musicStore.getPriceByTitle("Nevermind");
        assertThat(price).isEqualTo(19.99);
        verify(repository).findByTitle("Nevermind");
        verifyNoMoreInteractions(repository);
    }
    
    // Негативная проверка: пустой title → исключение до обращения к репозиторию
    @Test
    @DisplayName("findByTitle НЕ вызывается, если title пустой")
    void getPriceByTitle_neverCallsRepository_whenTitleEmpty() {
        assertThatThrownBy(() -> musicStore.getPriceByTitle(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Title");
        verify(repository, never()).findByTitle(anyString());
        verifyNoInteractions(repository);
    }
    
    // Негативная проверка: исключение из репозитория пробрасывается наружу
    @Test
    @DisplayName("исключение из репозитория пробрасывается наружу")
    void getPriceByTitle_propagatesRepositoryException() {
        when(repository.findByTitle("Boom"))
                .thenThrow(new RuntimeException("DB down"));
        assertThatThrownBy(() -> musicStore.getPriceByTitle("Boom"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("DB down");
    }
}
