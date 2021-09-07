package com.discorp.demo.model;

import com.discorp.demo.domain.ApiKey;
import lombok.Data;

@Data
public class ApiKeyModel
{
    private String authKey;
    private Long enterpriseId;
    private Long webId;
    private String disabled;

    public ApiKeyModel(ApiKey model)
    {
        this.authKey = model.getAuthKey();
        this.enterpriseId = model. getEnterpriseId();
        this.webId = model.getWebId();
        this.disabled = model.getDisabled();
    }
}
