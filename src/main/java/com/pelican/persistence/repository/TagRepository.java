package com.pelican.persistence.repository;

import com.pelican.persistence.domain.auth.LoginInfo;
import com.pelican.persistence.domain.task.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Nightingale on 15.09.2014.
 */
public interface TagRepository extends JpaRepository<Tag, Serializable> {
    List<Tag> findAllByOwnerId(int ownerId);
}
