import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static org.testng.Assert.assertEquals;

public class LibraryTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    PomXmlVersionChecker pomXmlVersionChecker = new PomXmlVersionChecker();

    @Test
    public void loginToGithubAccount() throws Exception {
        loginPage.openLoginPage(readProperties.getValue("baseUrl"));
        loginPage.typeInTheLoginField(readProperties.getValue("login"));
        loginPage.typeInThePasswordField(readProperties.getValue("password"));
        loginPage.clickSignInButton();
        loginPage.searchForTheProject(readProperties.getValue("projectName"));
        loginPage.clickOnTheFirstSearchResult();
        loginPage.openPomXmlFile();
        pomXmlVersionChecker.printLibrariesAndVersions();
        assertEquals(pomXmlVersionChecker.getLibraryVersion("testng"), "7.4.0");

    }

}
