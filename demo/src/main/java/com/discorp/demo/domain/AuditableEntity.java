package com.discorp.demo.domain;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
abstract public class AuditableEntity implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernateSequence")
    @GenericGenerator(name = "hibernateSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {@Parameter(name = "increment_size",value = "50")})
    @Column(name = "web_id", unique = true, nullable = false)
    protected Long webId;

    @Version
    @Column(nullable = false)
    protected Integer version;

    @Column(name = "date_updated")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateUpdated;

    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateCreated;

    @PrePersist
    @PreUpdate
    public void onUpdate()
    {
        if (dateCreated == null)
        {
            dateCreated = new Date();
        }
        this.setDateUpdated(new Date());
    }

    public Date getDateUpdated()
    {
        return this.dateUpdated;
    }

    public void setDateUpdated(Date date)
    {
        this.dateUpdated = date;
    }


    /**
     * Getter for version.
     *
     * @return the version
     * @author HoaBT2
     */
    public Integer getVersion()
    {
        return version;
    }

    /**
     * Setter for version.
     *
     * @param version the version to set
     * @author HoaBT2
     */
    public void setVersion(Integer version)
    {
        this.version = version;
    }

    /**
     * Getter for webId.
     *
     * @return the webId
     * @author HoaBT2
     */
    public Long getWebId()
    {
        return webId;
    }

    /**
     * Setter for webId.
     *
     * @param webId the webId to set
     * @author HoaBT2
     */
    public void setWebId(Long webId)
    {
        this.webId = webId;
    }

    public Date getDateCreated()
    {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    @Override
    public int hashCode()
    {
        if (webId == null)
        {
            return super.hashCode();
        }
        int hash = 1;
        hash = hash * 17 + this.getClass().hashCode();
        hash = hash * 31 + webId.hashCode();
        return hash;
    }
}
