@Regression
Feature: Sweatcoin Test Cases

  @Check
  Scenario: Check Welcome Page Elements
    Given User open app with "EN" language and "US" locale
    Then should see Logo on Welcome Page
    Then should see Description "Convert your steps into a currency to spend on products, offers and supporting charitable causes" on Welcome Page
    Then should see Sign Up with Google Button "Sign up with Google" on Welcome Page
    Then should see Already Have Account "Already have an account? Log in here" on Welcome Page
    Then should see Terms of Use and Privacy Policy "By Creating Account you Accept Terms of Use and  Privacy Policy." on Welcome Page

  @Navigate @Login
  Scenario Outline: Navigate Already Have an Account with Language: <language> and Locale: <locale>
    Given User open app with "<language>" language and "<locale>" locale
    When click Login Button on Welcome Page
    Then should see Login Page
    Examples:
      | language | locale |
      | EN       | US     |



