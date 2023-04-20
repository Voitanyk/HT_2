import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GitHubTest extends BaseTest {
    TestSteps testSteps = new TestSteps();

    @Test
    public void testProjectLibraryVersion() throws Exception {
        testSteps.signInToGithubAccount();
        testSteps.openTheProject();
        testSteps.openPomXmlFile();
        testSteps.printLibrariesAndVersions();
        testSteps.verifyTestngLibraryVersion();
    }

}
