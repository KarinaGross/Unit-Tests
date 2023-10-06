package hw4.webService;

public class WebService {
    private HttpClient httpClient;

    public WebService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String fetchData(String url) {
        return httpClient.getData(url);
    }
}
