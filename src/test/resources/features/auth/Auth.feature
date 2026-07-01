Feature: Auth

  @regression @smoke
  Scenario: Login Correcto
    Given Se obtiene el request body de login con credenciales "validas"
    When Se llama el request del login
    Then Se verifica que el status code sea 200
    And Se verifica que el response time sea menor a 3000 ms
    And Se obtiene el response body de login
    And Se verifica que el id sea positivo
    And Se verifica que el Access Token y Refresh Token tengan una longitud de 360 caracteres