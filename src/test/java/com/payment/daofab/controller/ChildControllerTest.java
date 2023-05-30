package com.payment.daofab.controller;

import com.payment.daofab.dto.ChildDTO;
import com.payment.daofab.service.ChildService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ChildControllerTest {

  @Mock
  private ChildService childService;

  private MockMvc mockMvc;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    ChildController childController = new ChildController(childService);
    mockMvc = MockMvcBuilders
        .standaloneSetup(childController)
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
  public void testGetChildrenByParentId() throws Exception {
    long parentId = 3l;
    ChildDTO childDTO = new ChildDTO(1l, parentId, "sender3", "receiver3", 110.0, 110.0);
    List<ChildDTO> childDTOList = new ArrayList<>();
    childDTOList.add(childDTO);
    given(childService.findChildrenByParentId(parentId)).willReturn(childDTOList);

    mockMvc.perform(get("/api/child/3").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].id", is(childDTO.getId().intValue())));
  }
}
