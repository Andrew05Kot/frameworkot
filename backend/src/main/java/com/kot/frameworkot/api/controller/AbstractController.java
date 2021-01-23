package com.kot.frameworkot.api.controller;

import com.kot.frameworkot.api.common.AbstractRequest;
import com.kot.frameworkot.api.common.AbstractResponse;
import com.kot.frameworkot.api.common.ResponsePage;
import com.kot.frameworkot.api.service.AbstractAPIService;
import com.kot.frameworkot.dal.entity.BaseEntity;
import com.kot.frameworkot.dal.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

public abstract class AbstractController<
		Entity extends BaseEntity,
		RequestBean extends AbstractRequest,
		ResponseBean extends AbstractResponse,
		Service extends AbstractService<Entity>,
		APIService extends AbstractAPIService<Entity, RequestBean, ResponseBean, Service>> {

	@Autowired
	protected APIService apiService;

	@ResponseStatus( HttpStatus.CREATED )
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean create( @RequestBody RequestBean request ) {
		return apiService.create(request);
	}

	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponsePage< ResponseBean > findItems(
			Optional<Integer> pageNo,
			Optional<Integer> pageSize,
			Sort sort) {
		return apiService.findItems(pageNo, pageSize, sort);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean findById( @PathVariable Long id) {
		return apiService.findById(id);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update( @PathVariable Long id, @RequestBody RequestBean request ) {
		apiService.update(id, request);
	}

	@ResponseStatus( HttpStatus.NO_CONTENT )
	@DeleteMapping(value = "/{id}")
	public void delete( @PathVariable Long id ) {
		apiService.delete(id);
	}

}
