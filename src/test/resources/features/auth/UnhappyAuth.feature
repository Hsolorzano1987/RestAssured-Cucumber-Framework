Feature: Auth con credenciales invalidas


  @regression
  Scenario Outline: Login con credenciales Erroneas
    Given Se obtiene el request body de login con credenciales <tipo>
    When Se llama el request del login
    Then Se verifica que el status code sea <statusCode>

    Examples:
      | tipo        | statusCode |
      | "invalidas" | 400        |
      | "vacias"    | 400        |