Feature: Autenticarse con el servidor


  @regression
  Scenario: Obtener todos los Posts
    When Se llama al request de obtener todos los posts
    Then Se verifica que el status code sea 401
  

  @regression
  Scenario: Obtener un Posts por su id
    When Se llama al request de obtener un Post con id 3
    Then Se verifica que el status code sea 401


  @regression
  Scenario: eliminar un Posts
    When Se llama al request de eliminar un Post con id 3
    Then Se verifica que el status code sea 401


  @regression
  Scenario: Ordenar un Posts
    Given Se ordena por el valor de "views" de manera "desc"
    When Se llama al request de ordenar los Posts
    Then Se verifica que el status code sea 401


  @regression
  Scenario: Buscar Posts
    Given Se busca el Post que contenga "history"
    When Se llama al request de buscar un Post
    Then Se verifica que el status code sea 401


  @regression
  Scenario: Crear un Posts
    Given Se genera un request body de Post
    When Se llama al request de crear un Post
    Then Se verifica que el status code sea 401


  @regression
  Scenario: Actualizar un Posts
    Given Se genera un request body de Post
    When Se llama al request de actualizar un Post con id 3
    Then Se verifica que el status code sea 401


  @regression
  Scenario: Actualizar parcialmente un Posts
    Given Se genera un request body de Partial Post
    When Se llama al request de actualizar parcialmente un Post con id 3
    Then Se verifica que el status code sea 401





