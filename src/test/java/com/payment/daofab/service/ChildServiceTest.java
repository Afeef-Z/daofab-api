package com.payment.daofab.service;

import com.payment.daofab.dto.ChildDTO;
import com.payment.daofab.entity.Child;
import com.payment.daofab.entity.Parent;
import com.payment.daofab.repository.ChildRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

public class ChildServiceTest {

  @Mock
  private ChildRepository childRepository;

  private ChildService childService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    childService = new ChildService(childRepository);
  }

  @Test
  public void testFindChildrenByParentId() {
    long parentId = 3l;
    Parent parent = new Parent();
    parent.setId(parentId);
    parent.setReceiver("receiver3");
    parent.setSender("sender3");
    parent.setTotalAmount(110.0);
    Child child = new Child();
    child.setId(1l);
    child.setParent(parent);
    child.setPaidAmount(110.0);
    List<Child> childList = new ArrayList<>();
    childList.add(child);

    given(childRepository.findByParentIdOrderByPaidAmount(3l)).willReturn(childList);

    List<ChildDTO> actualChildDtoList = childService.findChildrenByParentId(3l);

    assertThat(actualChildDtoList.get(0).getId()).isEqualTo(child.getId());
  }
}
