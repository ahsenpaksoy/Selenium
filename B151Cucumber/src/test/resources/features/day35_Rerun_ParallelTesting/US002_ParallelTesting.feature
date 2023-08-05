Feature: US002 Google Sayfasi Testi

  @pozitif
  Scenario: TC01 Arama Kutusunda Volvo Aratilir
    Given kullanici "googleUrl" sayfasina properties ile gider
    And kullanici 2 saniye bekler
    And kullanici cerezleri kapatir
    And  kullanici 2 saniye bekler
    Then kullanici google arama kutusunda "volvo" aratir
    And kullanici 2 saniye bekler
    And kullanici sayfa basliginin "arac1" icerdigini test eder
    And sayfayi kapatir



  Scenario: TC02 Arama Kutusunda Ford Aratilir
    * kullanici 2 saniye bekler
    * kullanici cerezleri kapatir
    * kullanici 2 saniye bekler
    * kullanici arama kutusunda "arac2" aratir
    * kullanici 2 saniye bekler
    * kullanici sayfa basliginin "arac2" icerdigini test eder
    * sayfayi kapatir

  @negatif
  Scenario: TC03 Arama Kutusunda Audi Aratilir
    Given kullanici "googleUrl" sayfasina properties ile gider
    * kullanici 2 saniye bekler
    * kullanici cerezleri kapatir
    * kullanici 2 saniye bekler
    * kullanici google arama kutusunda "audi" aratir
    * kullanici 2 saniye bekler
    * kullanici sayfa basliginin "arac3" icerdigini test eder
    * sayfayi kapatir


#terminale mvn clean verify yazip enter a basip calistirdik