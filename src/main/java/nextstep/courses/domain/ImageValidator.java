package nextstep.courses.domain;

public class ImageValidator {
    private static final long MAX_SIZE = 1_024 * 1_024 ; // 1MB
    private static final int MIN_WIDTH = 300;
    private static final int MIN_HEIGHT = 200;
    private static final double W_H_RATIO = 1.5;


    private ImageValidator() {
        throw new IllegalStateException("Utility class");
    }

    public static void validate(byte[] imageBytes, String imageFormat, int width,  int height) {
        validate(imageBytes);
        validate(imageFormat);
        validate(width, height);
    }

    public static void validate(byte[] imageBytes) {
        if (imageBytes.length > MAX_SIZE) {
            throw new IllegalArgumentException("이미지 사이즈가 1MB를 초과합니다.");
        }
    }

    public static void validate(int width, int height) {
        if (width < MIN_WIDTH || height < MIN_HEIGHT) {
            throw new IllegalArgumentException("이미지의 가로 또는 세로 크기가 너무 작습니다.");
        }
        if ((double) width/height != W_H_RATIO) {
            throw new IllegalArgumentException("이미지의 가로 세로 비율이 1.5가 아닙니다.");
        }
    }

    public static void validate(String imageFormat) {
        try {
            ImageFormat.valueOf(imageFormat.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("지원하지 않는 이미지 포맷입니다.");
        }
    }
}
