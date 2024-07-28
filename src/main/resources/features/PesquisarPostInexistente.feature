# language: pt
@postAgibank
Funcionalidade: Pesquisa de posts inexistente no blog do Agibank.

  @PostInexistente
  Cenario: Realizar pesquisa de postagem inexistente

    Dado que acesso a página do blog do Agibank
    Quando buscar por "xpto"
    Entao não devo visualizar nenhum post
    E deve haver a seguinte mensagem "Lamentamos, mas nada foi encontrado para sua pesquisa, tente novamente com outras palavras."