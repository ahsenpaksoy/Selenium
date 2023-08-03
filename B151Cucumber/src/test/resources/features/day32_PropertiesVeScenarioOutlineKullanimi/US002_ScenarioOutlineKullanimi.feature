Feature: US002 Google Sayfasi Testi

  Scenario Outline: TC01 Arama Kutusunda Araclar Aratilir

    Given kullanici "googleUrl" sayfasina properties ile gider
    And kullanici 2 saniye bekler
    And kullanici cerezleri kapatir
    And  kullanici 2 saniye bekler
    Then kullanici google arama kutusunda "<aranacakAraclar>" aratir
    And kullanici 2 saniye bekler
    And kullanici sayfa basliginin "<aranacakAraclar>" icerdigini test etti
    And sayfayi kapatir

    Examples:
      | aranacakAraclar |
      | volvo           |
      | ford            |
      | audi            |
      | mercedes        |

  #Scenario Outline: kullanimi testNG deki data provider mantigiyla ayni calisir.
  #Yukaridaki ornekteki gibi birden fazla veriyi loop kullanmadan test edebiliriz.
  #Scenario Outline kullaniminda Examples yapisini kendimiz yazmamiza gerek yok,
  #Scenario Outline yazdigimiz zaman altini kirmizi cizer ve mouse ile uzerine geldigimizde
  #Example yapisini create edebiliriz.