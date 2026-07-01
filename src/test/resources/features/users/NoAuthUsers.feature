Feature: No Auth Users


  @regression
  Scenario: Obtener todos los Users
    When Se llama al request de obtener todos los Users
    Then Se verifica que el status code sea 401

  @regression
  Scenario: Obtener un User por su id
    When Se llama al request de obtener un User con id 5
    Then Se verifica que el status code sea 401


  @regression
  Scenario: eliminar un User
    When Se llama al request de eliminar un User con id 5
    Then Se verifica que el status code sea 401

  @regression
  Scenario: Ordenar un User
    Given Se ordena los Users por el valor de "price" de manera "asc"
    When Se llama al request de ordenar los Users
    Then Se verifica que el status code sea 401

  @regression
  Scenario: Filtrar Users
    Given Se filtran los Users cuyo "address.city" sean "Phoenix"
    When Se llama al request de filtrar los Users
    Then Se verifica que el status code sea 401

  @regression
  Scenario: Crear un User
    Given Se genera un request body de User
    When Se llama al request de crear un User
    Then Se verifica que el status code sea 401

  @regression
  Scenario: Actualizar un User
    Given Se genera un request body de User
    When Se llama al request de actualizar un User con id 5
    Then Se verifica que el status code sea 401

  @regression
  Scenario: Actualizar parcialmente un User
    Given Se genera un request body de Partial User
    When Se llama al request de actualizar parcialmente un User con id 5
    Then Se verifica que el status code sea 401
