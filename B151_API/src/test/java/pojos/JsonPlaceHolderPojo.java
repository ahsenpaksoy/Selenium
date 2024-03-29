package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPlaceHolderPojo {

    //1. Tüm değşkenlere ait private isimler oluştur
    private Integer userId;
    private  String title;
    private Boolean completed;

        //2.Parametreli ve parametresiz constructor'lar oluştur

    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public JsonPlaceHolderPojo() {
    }

        //3. public getter ve setter ları oluştur

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

        //4. toString method'unu oluştur

    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}

/*

Biz intellij de hem UI(Selenium ile) - Api(Rest Assured ile ) - Database(JDBC ile) testi yapabiliriz

Postman da otomasyon yapilabilir. Lakin postman de sadece Api Testi yaparken Intellij de E2E testi yapabiliriz
UI Testi ---> API Testi ---> Database Testi === E2E TEST
 */
















