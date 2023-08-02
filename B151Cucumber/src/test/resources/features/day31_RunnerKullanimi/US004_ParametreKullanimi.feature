@ahsen #hepsini birden calistirmak icin bu tagi en basa koyduk
Feature: US004 TechProEducation Arama Testi
  Scenario: TC01 Sayfada Arama Yapar
    Given kullanici "https://techproeducation.com" sayfasina gider
    Then arama kutusunda "mobile" aratir
    And kullanici 2 saniye bekler
    When cikan dropdown da mobile developer linkine tiklar
    And sayfa basliginin Mobile icerdigini test eder
    And sayfayi kapatir

  Scenario: TC02 Sayfada Arama Yapar
    Given kullanici "https://techproeducation.com" sayfasina gider
    Then arama kutusunda "qa" aratir
    And sayfayi kapatir

  Scenario: TC03 Sayfada Arama Yapar
    Given kullanici "https://techproeducation.com" sayfasina gider
    Then arama kutusunda "java" aratir
    And sayfayi kapatir

  Scenario: TC04 Google sayfasina gidilir
  Given kullanici "https://google.com" sayfasina gider

  Scenario: TC05 Facebook sayfasina gidilir
    Given kullanici "https://facebook.com" sayfasina gider
  And sayfayi kapatir


  #Scenario'larda birden fazla url'e gitmek istediğimizde yada birden fazla ürün aratmak istediğimizde
  #her step için yeniden method oluşturmak yerine gitmek istediğimiz url yada aratmak istediğimiz ürünü
  #stepleri yazarken " " tırnak içene alırsak step definition class'ında parametreli bir method oluşturur
  #ve bu methodu diğer url ve aratmak istediğimiz ürünler için direk feature file üzerinden değiştirip
  #kullanabiliriz. Böylece tekrar tekrar her step için method oluşturmamış olururuz.Aşağıdaki örneklerdede
  #bunu görebilirisiniz.



