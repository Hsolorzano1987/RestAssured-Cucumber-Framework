Feature: Users

  Background: Autenticarse con el servidor
    Given el ususario se autentica con el servidor

  @regression
  Scenario: Obtener todos los Users
    When Se llama al request de obtener todos los Users
    Then Se verifica que el status code sea 200
    And Se verifica que el response time sea menor a 5000 ms

  @regression @smoke
  Scenario: Obtener un User por su id
    When Se llama al request de obtener un User con id 5
    Then Se verifica que el status code sea 200
    And Se verifica que el response time sea menor a 5000 ms
    And Se hace un schema validation del response body de User

  @regression @Smoke
  Scenario: eliminar un User
    When Se llama al request de eliminar un User con id 5
    Then Se verifica que el status code sea 200
    And Se verifica que el response time sea menor a 5000 ms

  @regression
  Scenario: Ordenar un User
    Given Se ordena los Users por el valor de "price" de manera "asc"
    When Se llama al request de ordenar los Users
    Then Se verifica que el status code sea 200
    And Se verifica que el response time sea menor a 5000 ms

  @regression
  Scenario: Filtrar Users
    Given Se filtran los Users cuyo "address.city" sean "Phoenix"
    When Se llama al request de filtrar los Users
    Then Se verifica que el status code sea 200
    And Se verifica que el response time sea menor a 5000 ms

  @regression @Smoke
  Scenario: Crear un User
    Given Se genera un request body de User
    When Se llama al request de crear un User
    Then Se verifica que el status code sea 201
    And Se verifica que el response time sea menor a 5000 ms

  @regression @Smoke
  Scenario: Actualizar un User
    Given Se genera un request body de User
    When Se llama al request de actualizar un User con id 5
    Then Se verifica que el status code sea 200
    And Se verifica que el response time sea menor a 5000 ms

  @regression @Smoke
  Scenario: Actualizar parcialmente un User
    Given Se genera un request body de Partial User
    When Se llama al request de actualizar parcialmente un User con id 5
    Then Se verifica que el status code sea 200
    And Se verifica que el response time sea menor a 5000 ms