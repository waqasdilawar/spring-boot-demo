package com.discorp.demo.controller;

import com.discorp.demo.model.ApiKeyModel;
import com.discorp.demo.service.ApiKeyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController
{
    private ApiKeyService apiKeyService;

    public TestController(ApiKeyService apiKeyService)
    {
        this.apiKeyService = apiKeyService;
    }

    @GetMapping("/greeting")
    public ResponseEntity<String> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return ResponseEntity.ok("hello " + name);
    }

    @GetMapping("/")
    public ResponseEntity<ApiKeyModel> get() {
        return ResponseEntity.ok(apiKeyService.getApiKey());
    }
}
