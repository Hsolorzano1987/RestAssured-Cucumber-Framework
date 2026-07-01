Feature: Unhappy Path de Posts

  Background: Autenticarse con el servidor
    Given el ususario se autentica con el servidor


  @regression
  Scenario: Obtener un Post con id inexistente
    When Se llama al request de obtener un Post con id 2500
    Then Se verifica que el status code sea 404

  @regression
  Scenario: Eliminar un Post con id inexistente
    When Se llama al request de eliminar un Post con id 2500
    Then Se verifica que el status code sea 404

  @regression
  Scenario: Actualizar un Post con id inexistente
    Given Se genera un request body de Post
    When Se llama al request de actualizar un Post con id 2500
    Then Se verifica que el status code sea 404

  @regression
  Scenario: Actualizar parcialmente un Post con id inexistente
    Given Se genera un request body de Partial Post
    When Se llama al request de actualizar parcialmente un Post con id 2500
    Then Se verifica que el status code sea 404