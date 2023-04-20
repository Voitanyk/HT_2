import static org.testng.Assert.assertEquals;

public class TestSteps {
    GitHubPage gitHubPage = new GitHubPage();
    ReadProperties readProperties = new ReadProperties();
    PomXmlVersionChecker pomXmlVersionChecker = new PomXmlVersionChecker();

    public void signInToGithubAccount(){
        gitHubPage.openLoginPage(readProperties.getValue("baseUrl"));
        gitHubPage.typeInTheLoginField(readProperties.getValue("login"));
        gitHubPage.typeInThePasswordField(readProperties.getValue("password"));
        gitHubPage.clickSignInButton();
    }

    public void openTheProject(){
        gitHubPage.searchForTheProject(readProperties.getValue("projectName"));
        gitHubPage.clickOnTheFirstSearchResult();
    }

    public void openPomXmlFile(){
        gitHubPage.openPomXmlFile();
    }

    public void printLibrariesAndVersions() {
        pomXmlVersionChecker.printLibrariesAndVersions();
    }

    public void verifyTestngLibraryVersion() throws Exception {
        assertEquals(pomXmlVersionChecker.getLibraryVersion("testng"), "7.4.0");
    }
}
