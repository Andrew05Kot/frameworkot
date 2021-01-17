package com.kot.frameworkot.api.service;

import com.kot.frameworkot.api.general.AbstractRequest;
import com.kot.frameworkot.api.general.AbstractResponse;
import com.kot.frameworkot.api.general.ResponsePage;
import com.kot.frameworkot.dal.entity.BaseEntity;
import com.kot.frameworkot.dal.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class AbstractAPIService<
		Entity extends BaseEntity,
		RequestBean extends AbstractRequest,
		ResponseBean extends AbstractResponse,
		Service extends AbstractService<Entity>> {

	public static final Integer DEFAULT_PAGE_NUMBER = 0;
	public static final Integer DEFAULT_PAGE_SIZE = 8;
	public static final String NON_FOUND_MESSAGE = "Item was not found";

	@Autowired
	protected Service service;

	public ResponseBean create(RequestBean request) {
		Entity entity = getNewEntity(request);
		Entity createdEntity = service.create(entity);
		return convertToResponseBean(createdEntity);
	}

	public ResponseBean findById(Long id) {
		Entity entity = getValidEntityById(id);
		return convertToResponseBean(entity);
	}

	public ResponsePage<ResponseBean> findItems(Optional<Integer> pageNo,
	                                            Optional<Integer> pageSize,
	                                            Sort sort) {
		return getResponsePage(pageNo.orElse(DEFAULT_PAGE_NUMBER),
				pageSize.orElse(DEFAULT_PAGE_SIZE), sort);
	}

	public ResponsePage<ResponseBean> getResponsePage(Integer pageNo, Integer pageSize, Sort sort) {
		sort = getSortedByDefault(sort);
		Pageable paging = PageRequest.of(pageNo, pageSize, sort);
		Page<Entity> pagedResult = service.findAll(paging);
		List<ResponseBean> responses = pagedResult.getContent().stream().map(this::convertToResponseBean)
				.collect(Collectors.toList());
		return new ResponsePage<>(responses, pagedResult.getTotalElements());
	}

	public void update(Long id, RequestBean request) {
		Entity entity = getValidEntityById(id);
		copyProperties(request, entity);
		service.update(entity);
	}

	public void delete(Long id) {
		service.delete(id);
	}

	protected Entity getValidEntityById(Long id) {
		Entity entity = service.findById(id);
		if (entity == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, NON_FOUND_MESSAGE);
		}
		return entity;
	}

	protected Sort getSortedByDefault(Sort sort) {
		return sort.and(Sort.by(Sort.Direction.ASC, "id"));
	}

	protected abstract Entity getNewEntity(RequestBean request);

	protected abstract void copyProperties(RequestBean request, Entity entity);

	protected abstract ResponseBean convertToResponseBean(Entity entity);


}
