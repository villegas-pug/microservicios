package com.microservicios.test.services;

import com.commons.utils.models.entities.Pais;
import com.commons.utils.services.CommonService;
import com.microservicios.test.models.repository.TestRepository;

import org.springframework.stereotype.Service;

@Service
public class TestService extends CommonService<Pais, TestRepository> implements ITestService {

}
