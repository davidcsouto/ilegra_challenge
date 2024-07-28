package blogAgi.pesquisarPost;

import lombok.extern.java.Log;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import static support.Context.webSupport;

@Log
public class SearchPostLogic {

    private SearchPostPage searchPostPage;
    private String step;

    public SearchPostLogic() {
        searchPostPage = new SearchPostPage();
    }

    public void navigateToBlog(){
        step = "Navegando para o blog do AgiBank";
        log.info(step);
        webSupport().navigateToUrl("https://blogdoagi.com.br/");
        webSupport().registerScreenshotAllureReport(step);
    }

    public void searchPost(String postTitle){
        step = "Buscando pelo post sobre " + postTitle;
        log.info(step);
        webSupport().waitElementToBeClickable(searchPostPage.getSearchIcon());
        webSupport().click(searchPostPage.getSearchIcon());
        webSupport().insertKeys(searchPostPage.getSearchField(), postTitle);
        webSupport().registerScreenshotAllureReport(step);
        webSupport().insertKeys(searchPostPage.getSearchField(), Keys.ENTER);
        Assert.assertTrue(webSupport().elementIsVisible(searchPostPage.getSearchResult()));
    }

    public void validatePageHasArticles(){
        step = "Resultado da busca";
        log.info(step);
        Assert.assertTrue(!searchPostPage.getArticles().isEmpty());
        webSupport().registerScreenshotAllureReport(step);
    }

    public void postHasTitle(String titleArticle){
        step = "Validando que um dos post tem o título igual ao termo procurado";
        log.info(step);
        webSupport().waitElementToBeVisible(searchPostPage.getArticleTitles().get(0));
        String text = webSupport().getItemInList(searchPostPage.getArticleTitles(), titleArticle).getText();
        Assert.assertEquals(text, titleArticle);
        webSupport().registerScreenshotAllureReport(step);
    }

    public void noPostsFound(){
        step = "Nenhum post exibido";
        log.info(step);
        webSupport().waitElementToBeVisible(searchPostPage.getNoArticleFound());
        webSupport().registerScreenshotAllureReport(step);
    }

    public void validateNoArticleFoundMessage(String expectedMessage){
        step = "Validando mensagem de nenhuma postagem encontrada";
        log.info(step);
        String messageFound = webSupport().getTextFromElement(searchPostPage.getNoArticleFoundMessage());
        Assert.assertEquals(expectedMessage, messageFound);
    }

}
