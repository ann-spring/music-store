package musicstore;

import musicstore.stubs.AlbumRepositoryStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("MusicStore (AssertJ)")
class MusicStoreAssertJTest {

    @Test
    @DisplayName("getDiscountedPrice применяет скидку и валидирует процент")
    void getDiscountedPrice_appliesDiscount_andValidatesRange() {
        MusicStore store = new MusicStore(new AlbumRepositoryStub());
        // Скидка 10% на "Nevermind": 19.99 * 90 / 100 = 17.991 → округление → 17.99
        assertThat(store.getDiscountedPrice("Nevermind", 10)).isEqualTo(17.99);
        // Скидка 0% — цена не меняется
        assertThat(store.getDiscountedPrice("Nevermind", 0)).isEqualTo(19.99);
        // Скидка 100% — цена становится нулём
        assertThat(store.getDiscountedPrice("Nevermind", 100)).isZero();
        // Скидка -1 → IllegalArgumentException с текстом "Discount"
        assertThatThrownBy(() -> store.getDiscountedPrice("Nevermind", -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Discount");
        // Альбом не найден → -1
        assertThat(store.getDiscountedPrice("Unknown", 10)).isEqualTo(-1.0);
    }
}