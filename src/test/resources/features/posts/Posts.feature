Feature: Autenticarse con el servidor

  Background: Autenticarse con el servidor
    Given el ususario se autentica con el servidor

  @regression
  Scenario: Obtener todos los Posts
    When Se llama al request de obtener todos los posts
    Then Se verifica que el status code sea 200
    And Se verifica que el response time sea menor a 5000 ms

  @regression
  Scenario: Obtener un Posts por su id
    When Se llama al request de obtener un Post con id 3
    Then Se verifica que el status code sea 200
    And Se verifica que el response time sea menor a 5000 ms
    And Se hace un schema validation del response body de Post

  @regression @Smoke
  Scenario: eliminar un Posts
    When Se llama al request de eliminar un Post con id 3
    Then Se verifica que el status code sea 200
    And Se verifica que el response time sea menor a 5000 ms

  @regression
  Scenario: Ordenar un Posts
    Given Se ordena por el valor de "views" de manera "desc"
    When Se llama al request de ordenar los Posts
    Then Se verifica que el status code sea 200
    And Se verifica que el response time sea menor a 5000 ms

  @regression
  Scenario: Buscar Posts
    Given Se busca el Post que contenga "history"
    When Se llama al request de buscar un Post
    Then Se verifica que el status code sea 200
    And Se verifica que el response time sea menor a 5000 ms

  @regression @Smoke
  Scenario: Crear un Posts
    Given Se genera un request body de Post
    When Se llama al request de crear un Post
    Then Se verifica que el status code sea 201
    And Se verifica que el response time sea menor a 5000 ms

  @regression @Smoke
  Scenario: Actualizar un Posts
    Given Se genera un request body de Post
    When Se llama al request de actualizar un Post con id 3
    Then Se verifica que el status code sea 200
    And Se verifica que el response time sea menor a 5000 ms

  @regression @Smoke
  Scenario: Actualizar parcialmente un Posts
    Given Se genera un request body de Partial Post
    When Se llama al request de actualizar parcialmente un Post con id 3
    Then Se verifica que el status code sea 200
    And Se verifica que el response time sea menor a 5000 ms

  @regression
  Scenario Outline: Verificar Posts
    When Se llama al request de obtener un Post con id <id>
    Then Se verifica que el status code sea 200
    And Se obtiene el response body de Post
    And Se verifica el <id>, <title>, <likes>, <dislikes> & <views> sean correctos
    Examples:
      | id | title                                               | likes | dislikes | views |
      | 1  | "His mother had always taught him"                  | 192   | 25       | 305   |
      | 2  | "He was an expert but not in a discipline"          | 859   | 32       | 4884  |
      | 3  | "Dave watched as the forest burned up on the hill." | 1448  | 39       | 4152  |
      | 4  | "All he wanted was a candy bar."                    | 359   | 18       | 4548  |
      | 5  | "Hopes and dreams were dashed that day."            | 119   | 30       | 626   |
      | 6  | "Dave wasn't exactly sure how he had ended up"      | 15    | 8        | 38    |
      | 7  | "This is important to remember."                    | 127   | 26       | 168   |
      | 8  | "One can cook on and with an open fire."            | 1271  | 36       | 2116  |
      | 9  | "There are different types of secrets."             | 703   | 18       | 2235  |
      | 10 | "They rushed out the door."                         | 455   | 3        | 4504  |



