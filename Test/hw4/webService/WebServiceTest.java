package hw4.webService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WebServiceTest {

    @Test
    void testFetchData() {
        HttpClient httpClientMock = mock(HttpClient.class);
        WebService webService = new WebService(httpClientMock);

        String url = "http://example.com";
        String expectedResponse = "Expected Data";

        when(httpClientMock.getData(url)).thenReturn(expectedResponse);

        assertEquals(expectedResponse, webService.fetchData(url));
    }
}