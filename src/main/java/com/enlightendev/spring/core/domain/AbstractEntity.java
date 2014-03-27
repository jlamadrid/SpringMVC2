package com.enlightendev.spring.core.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @MappedSuperclass to express that it is not a managed entity class on its own but rather will be extended by entity
 * classes.
 */
@MappedSuperclass
public class AbstractEntity {

    /**
     * instruct the persistence provider to automatically select the most appropriate strategy for
     * auto generation of primary keys
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Returns the identifier of the entity.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (this.id == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
            return false;
        }

        AbstractEntity that = (AbstractEntity) obj;

        return this.id.equals(that.getId());
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }
}
