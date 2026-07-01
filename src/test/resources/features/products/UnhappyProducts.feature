Feature: Unhappy Path de Products

  Background: Autenticarse con el servidor
    Given el ususario se autentica con el servidor

  @regression
  Scenario: Obtener un Product con id inexistente
    When Se llama al request de obtener un Product con is 2500
    Then Se verifica que el status code sea 404

  @regression
  Scenario: Eliminar un Product con un id inexistente
    When Se llama al request de eliminar un Product con id 2500
    Then Se verifica que el status code sea 404

  @regression
  Scenario: Actualizar un Product con id inexistente
    Given Se genera un request body de Product
    When Se llama al request de actualizar un Product con id 2500
    Then Se verifica que el status code sea 404

  @regression
  Scenario: Actualizar parcialmente un Product con id inexistente
    Given Se genera un request body de Partial Product
    When Se llama al request de actualizar parcialmente un Product con id 2500
    Then Se verifica que el status code sea 404