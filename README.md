## Projeto da cadeira Frameworks para Desenvolvimento de Softwares

* Grupo: **Leonardo Luz & Diego Prestes**
* 5º Semestre ADS

## Páginas testadas

[Página de Cadastro](./src/main/java/ifrs/edu/com/SignInPage.java)
[Página Inicial](./src/main/java/ifrs/edu/com/HomePage.java)
[Página de Perfil](./src/main/java/ifrs/edu/com/ProfilePage.java)
[Página de Login](./src/main/java/ifrs/edu/com/LoginPage.java)

[Teste do Sistema](./src/test/java/ifrs/edu/com/SystemTest.java)

## Fluxo do teste

      +-----------------+
      | Página de Login |
      +-----------------+
               |
      para página de cadastro
               |
               v
      +--------------------+                  +----------------+                            +------------------+
      | Página de Cadastro |--testa cadastro->| Página Inicial |----para página de perfil-->| Página de Perfil |-----+
      +--------------------+                  +----------------+                            +------------------+     |
                                                                                                                     |
                                            +-------------------+                  +-----------------+               |
             +----envia e limpar mensagens--| Página de Inicial |<--efetuar login--| Página de Login |<----logout----+
             |                              +-------------------+                  +-----------------+
       para página de perfil
             |
             v
     +-------------------+                 +-----------------+                  +-----+
     | Página de Perfil  |--excluir conta->| Página de Login |--falhar login--->| FIM |
     +-------------------+                 +-----------------+                  +-----+
