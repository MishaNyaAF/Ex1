package ex1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

public class MainTest {
    @Test
    public void correctOutputOpenProfileTest() throws IOException {
        Assertions.assertThat(ex1.Main.parser("https://vk.com/mixafonin")).isInstanceOf(ArrayList.class);
    }

    @Test
    public void validUserTest() throws IOException {
        Assertions.assertThat(ex1.Main.parser("https://vk.com/d00mrage")).hasSizeGreaterThan(0);
    }

    @Test
    public void invalidUserTest() throws IOException {
        Assertions.assertThat(ex1.Main.parser("q5hthgq54hw3")).isEqualTo(null);
    }

    @Test
    public void highFriendsQuantityTest() throws IOException {
        Assertions.assertThat(ex1.Main.parser("https://vk.com/jesusavgn")).hasSizeGreaterThan(5001);
    }

    @Test
    public void closedProfileTest() throws IOException {
        Assertions.assertThat(ex1.Main.parser("https://vk.com/id163578691")).isEqualTo(null);
    }
}