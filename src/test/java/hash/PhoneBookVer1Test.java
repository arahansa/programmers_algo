package hash;

import common.PhoneBook;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PhoneBookVer1Test {
    String[] a = new String[]{"119", "97674223", "1195524421"};
    String[] b = new String[]{"123","456","789"};
    String[] c = new String[]{"12","123","1235","567","88"};

    @Test
    void test() throws Exception{
        PhoneBook phoneBook = new PhoneBookVer1();
        assertThat(phoneBook.solution(a)).isFalse();
        assertThat(phoneBook.solution(b)).isTrue();
        assertThat(phoneBook.solution(c)).isFalse();
    }

}