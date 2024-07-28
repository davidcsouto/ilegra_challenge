package blogAgi.pesquisarPost;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PesquisaPostSteps {

    SearchPostLogic searchPostLogic;
    String term;

    public PesquisaPostSteps() {
        searchPostLogic = new SearchPostLogic();
    }

    @Dado("que acesso a página do blog do Agibank")
    public void que_acesso_a_página_do_blog_do_agibank() {
        searchPostLogic.navigateToBlog();
    }

    @Quando("buscar por {string}")
    public void buscar_por(String term) {
        this.term = term;
        searchPostLogic.searchPost(term);
    }
    @Entao("devo visualizar uma listagem de posts")
    public void devo_visualizar_uma_listagem_de_posts() {
        searchPostLogic.validatePageHasArticles();
    }

    @E("deve haver uma postagem com o mesmo termo da busca")
    public void deveHaverUmaPostagemComOMesmoTermoDaBusca() {
        searchPostLogic.postHasTitle(term);
    }

    @Entao("não devo visualizar nenhum post")
    public void nãoDevoVisualizarNenhumPost() {
        searchPostLogic.noPostsFound();
    }

    @E("deve haver a seguinte mensagem {string}")
    public void deveHaverASeguinteMensagem(String message) {
        searchPostLogic.validateNoArticleFoundMessage(message);
    }
}
