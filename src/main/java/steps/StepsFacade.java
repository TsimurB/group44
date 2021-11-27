package steps;

import models.User;
import pages.RedditHomePage;
import pages.RedditPostCreationPage;

public class StepsFacade {

    private final RedditHomePage homePage = new RedditHomePage();
    private final RedditPostCreationPage postPage = new RedditPostCreationPage();

    public StepsFacade completePrerequisitesForPosting(User user) {
        homePage
                .goToHomePage()
                .logout()
                .pressLoginButton()
                .processLogin(user)
                .pressCreatePostButton();
        return this;
    }

    public StepsFacade createDraft() {
        postPage
                .typeTitle()
                .typeContent()
                .pressSaveDraftButton();
        return this;
    }
}
