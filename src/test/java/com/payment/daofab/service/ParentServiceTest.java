package com.payment.daofab.service;

import com.payment.daofab.dto.ParentDTO;
import com.payment.daofab.repository.ParentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.*;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

public class ParentServiceTest {

    @Mock
    private ParentRepository parentRepository;

    private ParentService parentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        parentService = new ParentService(parentRepository);
    }

    @Test
    public void testFindParentsWithTotalPaidAmount() {
        // Given
        Pageable pageable = PageRequest.of(1, 2);

        ParentDTO parent1 = new ParentDTO(3L, "sender3", "receiver3", 110.0, 110.0);
        Page<ParentDTO> expectedPage = new PageImpl<>(Arrays.asList(parent1), pageable, 1);

        given(parentRepository.findParentTransactionsWithTotalPaidAmount(pageable)).willReturn(expectedPage);

        // When
        Page<ParentDTO> actualPage = parentService.findParentsWithTotalPaidAmount(pageable);

        // Then
        assertThat(actualPage).isEqualTo(expectedPage);
    }
}
