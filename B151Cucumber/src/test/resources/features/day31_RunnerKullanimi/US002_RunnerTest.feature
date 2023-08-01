Feature: US002 Amazon Urun Arama Testi
  @iphone
  Scenario: TC01 Amazonda iphone aramasi
    Given kullanici amazon sayfasina gider
    And sayfayi yeniler
    And kullnici aramaKutusunda iphone aratir
    And basligin iphone icerdigini test eder
    And sayfayi kapatir


    @samsung
    Scenario: TC02 Amazonda samsung aramasi
      Given kullanici amazon sayfasina gider
      And sayfayi yeniler
      And kullnici aramaKutusunda samsung aratir
      And basligin samsung icerdigini test eder
      And sayfayi kapatir