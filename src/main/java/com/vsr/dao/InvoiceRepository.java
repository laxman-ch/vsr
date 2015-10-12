package com.vsr.dao;

import com.vsr.model.Invoice;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Long> {
	List<Invoice> findByDepartmentId(@Param("deptid") int deptid);
}
