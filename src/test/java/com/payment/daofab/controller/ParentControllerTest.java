package com.payment.daofab.controller;

import com.payment.daofab.dto.ParentDTO;
import com.payment.daofab.service.ParentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Arrays;
import java.util.Locale;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;

public class ParentControllerTest {

    @Mock
    private ParentService parentService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ParentController parentController = new ParentController(parentService);
        mockMvc = MockMvcBuilders
            .standaloneSetup(parentController)
            .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
            .setViewResolvers(new ViewResolver() {
                @Override
                public View resolveViewName(String viewName, Locale locale) throws Exception {
                    return new MappingJackson2JsonView();
                }
            })
            .build();
    }

    @Test
    @Disabled
    public void testGetAllTransactions() throws Exception {
        // Given
        Pageable pageable = PageRequest.of(1, 2);
        ParentDTO parent1 = new ParentDTO(3L, "sender3", "receiver3", 110.0, 110.0);
        Page<ParentDTO> page = new PageImpl<>(Arrays.asList(parent1), pageable, 1);
        given(parentService.findParentsWithTotalPaidAmount(pageable)).willReturn(page);

        mockMvc.perform(get("/api/parent/?page=1&size=2").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(1)))
                .andExpect(jsonPath("$.content[0].parentId", is(parent1.getParentId().intValue())));
    }

}
