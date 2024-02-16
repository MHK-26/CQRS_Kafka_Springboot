package com.mhk26.cqrs.core.queries;

import com.mhk26.cqrs.core.domain.BaseEntity;

import java.util.List;

@FunctionalInterface
public interface QueryHandlerMethod<T extends BaseQuery> {
    List<BaseEntity> handler(T query);
}
