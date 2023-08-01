@tech
Feature: US003 Techproeducation Sayfasi Testi

  #Feature file içinde Scenario larda ortak kullanilan step'lerde Background: yapisini kullanabiliriz.
  #Her scenario'dan önce buradaki step çalışır sonra scenario'daki stepler çalişmaya devam eder
  #Burda ortak adim olan Given i scenario lardan sildik Background un icine koyduk.
  Background: Kullanici TechproEducation sayfasina gider
    Given kullanici techpro sayfasina gider

  Scenario: TC01 Sayfada Arama Yapar
    Then arama kutusunda qa aratir
    And sayfa basliginin qa icerdigini test eder

      # Burada daha once yazdigimiz methodlardan birini secersek yazi rengi koyu olmaz
   #Feature fille da daha once olusturdugumuz bir method'u baska bir scenario larda tekrar olusturmadan kullanabiliriz
  #Yukaridaki ornekte sayfayi kapatir step'i icin daha once amazonStepDefinition class'inda olusturdugumuz methodu
  # kullanabiliriz

  Scenario: TC02 Sayfada Arama Yapar
    Then arama kutusunda java aratir
    And sayfa basliginin java icerdigini test eder

  @techpro
  Scenario: TC03 Sayfada Arama Yapar
    Then arama kutusunda mobile aratir
    When cikan dropdown da mobile developer linkine tiklar
    And sayfa basliginin Mobile icerdigini test eder
    And sayfayi kapatir
  #Scenario larimizin tek bir browserda calismasini istersek ve tum scenariolardan sonra browser'i kapatmak
  #istersek en son scenario'da close yapabiliriz.

    # @all u daha once kullandigimiz icin burda @tech kullandik
    #Tek bir browser da calistirmak istersek sayfayi kapat steplerini kapatmamiz gerekir
  # Featurelarin istedigimiz siraya gore veya alfabetik olarak calismasini istiyorsak
  # file larin basina a b c vs gibi koyabiliriz