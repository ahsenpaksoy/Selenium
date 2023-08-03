Feature: US001 Google Sayfasinda Urun Aramasi

  Scenario: TC01 Arama Kutusunda Verilen Urunler Aratilir
    Given kullanici "googleUrl" sayfasina gitti
    And kullanici 2 saniye bekler
    And kullanici cerezleri kapatir
    Then kullanici data tableda verilen bilgileri aratir
      | Datalar  |
      | samsung  |
      | nokia    |
      | apple    |
      | motorola |
    And sayfayi kapatir


#DataTable Scenario Outline daki gibi birden fazla veriyi aynı scenario'da test etmek için kullanılır
#Scenario Outline'dan farklı olarak verilerle ilgili tabloları istediğimiz stepten sonra kendimiz oluşturabiliriz.
#Tabloyu oluşturduğumuz step'in method'una parametre olarak cucumber.io dan DataTable parametresini ekleriz.
#Bu parametre sayesinde oluşturmus olduğumuz tabloyu bir list'e dönüstürüp loop ile verileri kullanabiliriz.
#Birden fazla sutün oluşturduysak yine DataTable parametresi sayesinde excel'den bildiğimiz row() methodu ile
#bu datalara ulaşabiliriz.


#AltGr+<>  --> |
