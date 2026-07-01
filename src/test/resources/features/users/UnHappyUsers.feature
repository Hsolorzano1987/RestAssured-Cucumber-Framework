Feature: Unhappy Users

  Background: Autentcarse con el servidor
    Given el ususario se autentica con el servidor

  @regression
  Scenario: Obtener un User con id inexistente
    When Se llama al request de obtener un User con id 2500
    Then Se verifica que el status code sea 404

  @regression
  Scenario: Eliminar un User con un id inexistente
    When Se llama al request de eliminar un User con id 2500
    Then Se verifica que el status code sea 404

  @regression
  Scenario: Actualizar un User con id inexistente
    Given Se genera un request body de User
    When Se llama al request de actualizar un User con id 2500
    Then Se verifica que el status code sea 404

  @regression
  Scenario: Actualizar parcialmente un User con id inexistente
    Given Se genera un request body de Partial User
    When Se llama al request de actualizar parcialmente un User con id 2500
    Then Se verifica que el status code sea 404