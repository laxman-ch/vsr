package com.vsr.dao;

import com.vsr.model.Faremap;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FaremapRepository extends PagingAndSortingRepository<Faremap, Integer> {
}
