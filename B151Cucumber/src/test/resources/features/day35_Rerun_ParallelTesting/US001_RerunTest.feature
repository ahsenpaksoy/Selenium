Feature: US001 Google Sayfasi Testi

  Background: Google Sayfasina Gidildi
    Given kullanici "googleUrl" sayfasina properties ile gider

  @arc
  Scenario: TC01 Arama Kutusunda Volvo Aratilir
    And kullanici 2 saniye bekler
    And kullanici cerezleri kapatir
    And  kullanici 2 saniye bekler
    Then kullanici arama kutusunda "arac1" aratir
    And kullanici 2 saniye bekler
    And kullanici sayfa basliginin "arac1" icerdigini test eder
    And sayfayi kapatir
      #bu scenarioda bilerek hata aldik arac1 yerine arac2 yazdik

  @arc
  Scenario: TC02 Arama Kutusunda Ford Aratilir
    * kullanici 2 saniye bekler
    * kullanici cerezleri kapatir
    * kullanici 2 saniye bekler
    * kullanici arama kutusunda "arac2" aratir
    * kullanici 2 saniye bekler
    * kullanici sayfa basliginin "arac2" icerdigini test eder
    * sayfayi kapatir

  @arc
  Scenario: TC03 Arama Kutusunda Audi Aratilir
    * kullanici 2 saniye bekler
    * kullanici cerezleri kapatir
    * kullanici 2 saniye bekler
    * kullanici arama kutusunda "arac3" aratir
    * kullanici 2 saniye bekler
    * kullanici sayfa basliginin "arac3" icerdigini test eder
    * sayfayi kapatir

    #bu scenariolarda bilerek fail aldik. FailedRunner classi ile onlari duzelttik.
  # @arac1  @arac2 , qarac3  @arac4  tu.