package hash;

import common.UnfinishedSolution;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UnfinishedRunnerTest {


    /**
     *  ["leo", "kiki", "eden"], ["eden", "kiki"]
     *  ["marina", "josipa", "nikola", "vinko", "filipa"], ["josipa", "filipa", "marina", "nikola"]
     *  ["mislav", "stanko", "mislav", "ana"], ["stanko", "ana", "mislav"]
      */

    static class TestRunnerFixture{
        String[] participant;
        String[] completion;

        public TestRunnerFixture(String[] participant, String[] completion) {
            this.participant = participant;
            this.completion = completion;
        }

        public String[] getParticipant() {
            return participant;
        }

        public String[] getCompletion() {
            return completion;
        }
    }

    TestRunnerFixture a = new TestRunnerFixture(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"});
    TestRunnerFixture b = new TestRunnerFixture(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
            new String[]{"josipa", "filipa", "marina", "nikola"});
    TestRunnerFixture c = new TestRunnerFixture(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"});

    @Test
    void solution2() throws Exception{
        UnfinishedSolution runner = new UnfinishedRunnerHashVer();
        assertThat(runner.solution(a.participant, a.completion)).isEqualTo("leo");
        assertThat(runner.solution(b.participant, b.completion)).isEqualTo("vinko");
        assertThat(runner.solution(c.participant, c.completion)).isEqualTo("mislav");
    }

}