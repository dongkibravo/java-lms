package nextstep.courses.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ImageValidatorTest {

    @Test
    @DisplayName("이미지 파일 사이즈 1mb 이상일 경우")
    public void imageFileSizeOverTest() {
        // given
        byte[] image = new byte[1024 * 1024 * 2];

        // then
        assertThatThrownBy(() -> {
            // when
            ImageValidator.validate(image);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이미지 사이즈가 1MB를 초과합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"jpg", "png", "gif", "jpeg"})
    @DisplayName("이미지 타입이 jpg, png, gif일 경우")
    public void imageFileTypePassTest(String fileType) {
        assertDoesNotThrow(() -> ImageValidator.validate(fileType));
    }

    @ParameterizedTest
    @ValueSource(strings = {"tiff", "bmp", "webp"})
    @DisplayName("이미지 타입이 jpg, png, gif가 아닐 경우")
    public void imageFileTypeFailTest(String fileType) {
        assertThatThrownBy(() -> ImageValidator.validate(fileType))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("가로 세로 값이 최소값 보다 작은 경우")
    public void imageHeightWidthFailTest() {
        // given
        int invalidWidth = 200;
        int invalidHeight = 100;
        int validWidth = 300;
        int validHeight = 200;

        // then
        assertThatThrownBy(() ->
            // when
            ImageValidator.validate(invalidWidth, validHeight)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이미지의 가로 또는 세로 크기가 너무 작습니다.");

        // then
        assertThatThrownBy(() ->
                // when
                ImageValidator.validate(validWidth, invalidHeight)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이미지의 가로 또는 세로 크기가 너무 작습니다.");
    }

    @Test
    @DisplayName("가로 세로 비율 실패 케이스")
    public void imageWidthHeightRatioFailTest() {
        // given
        int width = 400;
        int height = 400;

        // then
        assertThatThrownBy(() -> ImageValidator.validate(width, height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이미지의 가로 세로 비율이 1.5가 아닙니다.");
    }

    @Test
    @DisplayName("이미지 검증 성공 케이스")
    public void imageValidityPassTest() {
        // when
        byte[] image = new byte[1024 * 1024];
        String format = "jpg";
        int width = 600;
        int height = 400;

        // then
        ImageValidator.validate(image, format, width, height);
    }

}
