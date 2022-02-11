import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName

class StringTest {

    var binary = "binary"

    @DisplayName("인덱스로 문자열 접근")
    @Test
    fun stringWithIndex () {
        assertThat(binary[1])
            .isEqualTo('i');
    }

    @DisplayName("문자열 이어붙이기")
    @Test
    fun plus() {
        assertThat(binary.plus(".yun"))
            .isEqualTo("binary.yun")
    }

    @DisplayName("특정 인덱스의 ASCII 코드 값을 반환")
    @Test
    fun codePointAt() {
        assertThat(binary.codePointAt(0))
            .isEqualTo(98)
        assertThrows(IndexOutOfBoundsException::class.java) {
            binary.codePointAt(binary.length + 1)
        };
    }

    @DisplayName("n번째 문자 이전을 제거한 부분 문자열을 반환")
    @Test
    fun drop() {
        assertThat(binary.drop(0))
            .isEqualTo("binary")
        assertThat(binary.drop(2))
            .isEqualTo("nary")
        assertThat(binary.drop(binary.length+1))
            .isEqualTo("")
        assertThrows(IllegalArgumentException::class.java) {
            binary.drop(-1)
        };
    }

    @DisplayName("뒤에서 n번째 문자 이후를 제거한 부분 문자열을 반환")
    @Test
    fun dropLast() {
        assertThat(binary.dropLast(0))
            .isEqualTo("binary")
        assertThat(binary.dropLast(2))
            .isEqualTo("bina")
        assertThat(binary.dropLast(binary.length))
            .isEqualTo("")
        assertThrows(IllegalArgumentException::class.java) {
            binary.drop(-1)
        };
    }
}