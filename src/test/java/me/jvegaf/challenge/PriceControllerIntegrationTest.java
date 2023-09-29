package me.jvegaf.challenge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    private static final String URI = "/api/prices";

    @Test
    @DisplayName("when the application date is 2020-06-14T10:00:00Z and brand 1 and product 35455 should return 35.50 price")
    public void test1() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get(URI)
                        .param("applicationDate", "2020-06-14T10:00:00Z")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.product_id").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price_list").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.start_date").value("2020-06-14T00:00:00Z"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.end_date").value("2020-12-31T23:59:59Z"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.50));

    }


    @Test
    @DisplayName("when the application date is 2020-06-14T16:00:00Z and brand 1 and product 35455 should return 25.45 price")
    public void test2() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get(URI)
                        .param("applicationDate", "2020-06-14T16:00:00Z")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.product_id").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price_list").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.start_date").value("2020-06-14T15:00:00Z"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.end_date").value("2020-06-14T18:30:00Z"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(25.45));

    }

    @Test
    @DisplayName("when the application date is 2020-06-14T21:00:00Z and brand 1 and product 35455 should return 35.50 price")
    public void test3() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get(URI)
                        .param("applicationDate", "2020-06-14T21:00:00Z")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.product_id").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price_list").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.start_date").value("2020-06-14T00:00:00Z"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.end_date").value("2020-12-31T23:59:59Z"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.50));

    }

    @Test
    @DisplayName("when the application date is 2020-06-15T10:00:00Z and brand 1 and product 35455 should return 30.50 price")
    public void test4() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get(URI)
                        .param("applicationDate", "2020-06-15T10:00:00Z")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.product_id").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price_list").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.start_date").value("2020-06-15T00:00:00Z"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.end_date").value("2020-06-15T11:00:00Z"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(30.50));

    }

    @Test
    @DisplayName("when the application date is 2020-06-16T21:00:00Z and brand 1 and product 35455 should return 38.95 price")
    public void test5() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get(URI)
                        .param("applicationDate", "2020-06-16T21:00:00Z")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.product_id").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price_list").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$.start_date").value("2020-06-15T16:00:00Z"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.end_date").value("2020-12-31T23:59:59Z"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(38.95));

    }

}

