package blogAgi.pesquisarPost;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static support.Context.driver;

@Getter
public class SearchPostPage {

    public SearchPostPage() {
        PageFactory.initElements(driver(), this);
    }

    @FindBy(css = "div[class*=ast-search-icon] a[aria-label*='pesquisa']")
    private WebElement searchIcon;

    @FindBy(id = "search-field")
    private WebElement searchField;

    @FindBy(css = "h1.page-title span")
    private WebElement searchResult;

    @FindBy(css = "#primary #main article")
    private List<WebElement> articles;

    @FindBy(css = "#primary #main article h2 a")
    private List<WebElement> articleTitles;

    @FindBy(css = "main#main section.no-results")
    private WebElement noArticleFound;

    @FindBy(css = "main#main section.no-results p")
    private WebElement noArticleFoundMessage;
}
