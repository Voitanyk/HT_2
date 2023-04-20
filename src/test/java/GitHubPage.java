import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class GitHubPage {
        private final SelenideElement loginField = $("#login_field");
        private final SelenideElement passwordField = $("#password");
        private final SelenideElement signInButton = $("#login > div.auth-form-body.mt-3 > form > div > input.btn.btn-primary.btn-block.js-sign-in-button");
        private final SelenideElement searchField =  $("input[name='q']");
        private final SelenideElement searchResultList = $("ul.repo-list a");
        private static SelenideElement pomXmlFile = $("a[title='pom.xml']");

        public void typeInTheLoginField(String userLogin){
            loginField.setValue(userLogin);
        }

        public void typeInThePasswordField(String userPassword){
            passwordField.setValue(userPassword);
        }

        public void clickSignInButton(){
            signInButton.click();
        }
        public void openLoginPage(String url){
            Selenide.open(url);
        }
        public void searchForTheProject(String projectName){
            searchField.setValue(projectName).pressEnter();
        }
        public void clickOnTheFirstSearchResult(){
            searchResultList.click();
        }
    public void openPomXmlFile(){
        pomXmlFile.click();
    }

    }