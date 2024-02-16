package com.mhk26.cqrs.core.infrastructure;

import com.mhk26.cqrs.core.domain.BaseEntity;
import com.mhk26.cqrs.core.queries.BaseQuery;
import com.mhk26.cqrs.core.queries.QueryHandlerMethod;

import java.util.List;

public interface QueryDispatcher {
    <T extends BaseQuery> void registerHandler(Class<T> type, QueryHandlerMethod<T> handler);
    <U extends BaseEntity> List<U> send(BaseQuery query);
}
