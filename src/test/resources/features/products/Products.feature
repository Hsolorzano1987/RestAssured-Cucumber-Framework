Feature: Products

  Background: Autenticarse con el servidor
    Given el ususario se autentica con el servidor

  @regression
  Scenario: Obtener todos los Products
    When Se llama al request de obtener todos los Products
    Then Se verifica que el status code sea 200
    And Se verifica que el response time sea menor a 3000 ms

  @regression @smoke
  Scenario: Obtener un solo Product
    When Se llama al request de obtener un Product con is 2
    Then Se verifica que el status code sea 200
    And Se verifica que el response time sea menor a 3000 ms
    And Se hace un schema validation del response body de Product

  @regression @smoke
  Scenario: Eliminar un Product
    When Se llama al request de eliminar un Product con id 2
    Then Se verifica que el status code sea 200
    And Se verifica que el response time sea menor a 3000 ms

  @regression
  Scenario: Ordenar Products
    Given Se ordena lo Products por el valor de "price" de manera "asc"
    When Se llama al request de ordenar los Products
    Then Se verifica que el status code sea 200
    And Se verifica que el response time sea menor a 3000 ms

  @regression
  Scenario: Buscar Products
    Given Se busca el Product que contenga "kitchen"
    When Se llama al request de buscar un Product
    Then Se verifica que el status code sea 200
    And Se verifica que el response time sea menor a 3000 ms

  @regression @smoke
  Scenario: Crear un Product
    Given Se genera un request body de Product
    When Se llama al request de crear un Product
    Then Se verifica que el status code sea 201
    And Se verifica que el response time sea menor a 3000 ms

  @regression @smoke
  Scenario: Actualizar un Product
    Given Se genera un request body de Product
    When Se llama al request de actualizar un Product con id 2
    Then Se verifica que el status code sea 200
    And Se verifica que el response time sea menor a 3000 ms

  @regression @smoke
  Scenario: Actualizar parcialmente un Product
    Given Se genera un request body de Partial Product
    When Se llama al request de actualizar parcialmente un Product con id 2
    Then Se verifica que el status code sea 200
    And Se verifica que el response time sea menor a 3000 ms

