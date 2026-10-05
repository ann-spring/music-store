package musicstore;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Album (JUnit 5)")
class AlbumTest {

    // Позитивная проверка: корректный альбом создаётся без исключения
    @Test
    @DisplayName("smoke: корректный альбом создаётся без исключения")
    void constructor_doesNotThrow_forValidData() {
        assertDoesNotThrow(() -> new Album("Nevermind", "Nirvana", 1991, 19.99));
    }
    // Негативная проверка: пустой title → IllegalArgumentException
    @Test
    @DisplayName("пустой title → IllegalArgumentException")
    void constructor_throws_whenTitleEmpty() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> new Album("", "Nirvana", 1991, 19.99)
        );
        assertTrue(ex.getMessage().contains("Title"));
    }
    // Негативная проверка: отрицательная price → IllegalArgumentException
    @Test
    @DisplayName("отрицательная price → IllegalArgumentException")
    void constructor_throws_whenPriceNegative() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> new Album("Nevermind", "Nirvana", 1991, -0.01)
        );
        assertTrue(ex.getMessage().contains("Price"));
    }
}

