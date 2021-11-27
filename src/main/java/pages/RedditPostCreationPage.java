package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RedditPostCreationPage extends BasePage {

    private final static String DRAFTTITLE = "myTitle";

    private final static String POSTCREATIONURL = "https://www.reddit.com/submit";

    @FindBy(xpath = "//textarea[@placeholder='Title']")
    private WebElement postTitleTextarea;

    @FindBy(xpath = "//div[@class='notranslate public-DraftEditor-content']")
    private WebElement postInputTextarea;

    @FindBy(xpath = "//button[@role='button' and contains (text(),'Save Draft')]")
    private WebElement saveDraftButton;

    @FindBy(xpath = "//h2[contains (text(),'" + DRAFTTITLE + "')]")
    private WebElement draftListLine;

    @FindBy(xpath = "//button[contains (text(),'Drafts')]")
    private WebElement draftsButton;

    public RedditPostCreationPage typeTitle() {
        fillIn(postTitleTextarea, DRAFTTITLE);
        return this;
    }

    public RedditPostCreationPage typeContent() {
        fillIn(postInputTextarea, "content");
        return this;
    }

    public RedditPostCreationPage pressSaveDraftButton() {
        clickIn(saveDraftButton);
        return this;
    }

    public RedditPostCreationPage pressDraftsButton() {
        clickIn(draftsButton);
        return this;
    }

    public boolean checkIfDraftExists() {
        String checker = waitForTextOf(draftListLine);
        return checker.contains(DRAFTTITLE);
    }

}
