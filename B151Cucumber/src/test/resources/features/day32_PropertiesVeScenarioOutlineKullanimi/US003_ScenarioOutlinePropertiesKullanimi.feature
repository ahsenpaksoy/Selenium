Feature: US003 Google Sayfasi Testi

  Scenario Outline: TC01 Arama Kutusunda Araclar Aratilir

    Given kullanici "googleUrl" sayfasina properties ile gider
    And kullanici 2 saniye bekler
    And kullanici cerezleri kapatir
    Then kullanici google arama kutusunda "<aranacakAraclar>" ile propertiesden aratir
    And kullanici 2 saniye bekler
    And kullanici sayfa basliginin "<aranacakAraclar>" icerdigini test eder
    And sayfayi kapatir

    Examples:
      | aranacakAraclar |
      | arac1           |
      | arac2           |
      | arac3           |
      | arac4           |

  #Bu ornekte Scenario Outline yapisi ile verileri properties dosyasindan cektik