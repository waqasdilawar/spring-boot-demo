package com.discorp.demo.service.impl;

import com.discorp.demo.model.ApiKeyModel;
import com.discorp.demo.repositories.ApiKeyRepository;
import com.discorp.demo.service.ApiKeyService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ApiKeyServiceImpl implements ApiKeyService
{
    @NonNull private ApiKeyRepository apiKeyRepository;
    @Override
    public ApiKeyModel getApiKey()
    {
        return apiKeyRepository.findByAuthKey("test1").map(ApiKeyModel::new)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }
}
