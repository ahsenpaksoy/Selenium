@all
Feature: US001 Techproeducation Sayfasi Testi
  Scenario: TC01 Sayfada Arama Yapar
    Given kullanici techpro sayfasina gider
    Then arama kutusunda qa aratir
    And sayfa basliginin qa icerdigini test eder
    And sayfayi kapatir

      # Burada daha once yazdigimiz methodlardan birini secersek yazi rengi koyu olmaz
   #Feature fille da daha once olusturdugumuz bir method'u baska bir scenario larda tekrar olusturmadan kullanabiliriz
  #Yukaridaki ornekte sayfayi kapatir step'i icin daha once amazonStepDefinition class'inda olusturdugumuz methodu
  # kullanabiliriz

  Scenario: TC02 Sayfada Arama Yapar
    Given kullanici techpro sayfasina gider
    Then arama kutusunda java aratir
    And sayfa basliginin java icerdigini test eder
    And sayfayi kapatir

  @techpro
  Scenario: TC03 Sayfada Arama Yapar
    Given kullanici techpro sayfasina gider
    Then arama kutusunda mobile aratir
    When cikan dropdown da mobile developer linkine tiklar
    And sayfa basliginin Mobile icerdigini test eder
    And sayfayi kapatir

    # @all hepsini calistirir. Runner da tag a @all yazmaliyiz.