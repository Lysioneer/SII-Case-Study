package com.sii.service;

import com.sii.repository.TransactionRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Test class for {@link TransactionServiceImpl}
 *
 * Created by Simek Jan on 21.9.2023.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TransactionServiceImplTest {

    @Mock
    private TransactionRepository repository;

    @Mock
    private EntityMapper mapper;

    @InjectMocks
    private TransactionServiceImpl service;

    @Before
    public void init() {
        ReflectionTestUtils.setField(service, "mapper", mapper);
        ReflectionTestUtils.setField(service, "repository", repository);
    }

}
