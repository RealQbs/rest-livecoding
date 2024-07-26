package com.example.restlivecoding;

import com.example.restlivecoding.adapters.in.rest.CreateItemRequest;
import com.example.restlivecoding.domain.models.Item;
import com.example.restlivecoding.integration.db.ItemInMemoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemInMemoryRepository itemInMemoryRepository;

    @Test
    void should_successfully_create_item_id_db() throws Exception {
        // Given
        CreateItemRequest body = new CreateItemRequest("test", "test");
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(body);

        //And
        Item mockedItem = new Item("test", "test");
        Mockito.when(itemInMemoryRepository.save(Mockito.any())).thenReturn(mockedItem);

        // When
        MvcResult result = mockMvc.perform(
                        post("/items")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestBody)
                )
                .andExpect(status().isCreated())
                .andReturn();


        // Then
        Mockito.verify(itemInMemoryRepository).save(Mockito.any());
        assertEquals(201, result.getResponse().getStatus());
        assertEquals("http://localhost/items/" + mockedItem.getId(), result.getResponse().getHeader("Location"));
    }

//    @Test
//    void should_throw_a_name_validation_exception() throws Exception {
//        // Given
//        CreateItemRequest body = new CreateItemRequest("", "test");
//        ObjectMapper objectMapper = new ObjectMapper();
//        String requestBody = objectMapper.writeValueAsString(body);
//
//        // When
//        MvcResult result = mockMvc.perform(
//                        post("/items")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(requestBody)
//                )
//                .andExpect(status().isBadRequest())
//                .andReturn();
//
//        // Then
//        assertEquals(400, result.getResponse().getStatus());
//    }
}
