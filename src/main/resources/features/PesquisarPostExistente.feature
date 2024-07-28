# language: pt
  @postAgibank
  Funcionalidade: Pesquisa de posts existente no blog do Agibank.

    @PostExistente
    Cenario: Realizar pesquisa de postagem existente

      Dado que acesso a página do blog do Agibank
      Quando buscar por "Qual o melhor banco para receber benefício INSS?"
      Entao devo visualizar uma listagem de posts
      E deve haver uma postagem com o mesmo termo da busca