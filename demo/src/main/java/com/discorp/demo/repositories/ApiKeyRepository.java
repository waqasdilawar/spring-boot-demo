package com.discorp.demo.repositories;

import com.discorp.demo.domain.ApiKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApiKeyRepository extends JpaRepository<ApiKey, Long>
{
    Optional<ApiKey> findByAuthKey(String authKey);
}
