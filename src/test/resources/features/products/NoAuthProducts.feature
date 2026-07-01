Feature: No Auth Products


  @regression
  Scenario: Obtener todos los Products
    When Se llama al request de obtener todos los Products
    Then Se verifica que el status code sea 401
    

  @regression
  Scenario: Obtener un solo Product
    When Se llama al request de obtener un Product con is 2
    Then Se verifica que el status code sea 401


  @regression
  Scenario: Eliminar un Product
    When Se llama al request de eliminar un Product con id 2
    Then Se verifica que el status code sea 401


  @regression
  Scenario: Ordenar Products
    Given Se ordena lo Products por el valor de "price" de manera "asc"
    When Se llama al request de ordenar los Products
    Then Se verifica que el status code sea 401


  @regression
  Scenario: Buscar Products
    Given Se busca el Product que contenga "kitchen"
    When Se llama al request de buscar un Product
    Then Se verifica que el status code sea 401


  @regression
  Scenario: Crear un Product
    Given Se genera un request body de Product
    When Se llama al request de crear un Product
    Then Se verifica que el status code sea 401


  @regression
  Scenario: Actualizar un Product
    Given Se genera un request body de Product
    When Se llama al request de actualizar un Product con id 2
    Then Se verifica que el status code sea 401


  @regression
  Scenario: Actualizar parcialmente un Product
    Given Se genera un request body de Partial Product
    When Se llama al request de actualizar parcialmente un Product con id 2
    Then Se verifica que el status code sea 401


