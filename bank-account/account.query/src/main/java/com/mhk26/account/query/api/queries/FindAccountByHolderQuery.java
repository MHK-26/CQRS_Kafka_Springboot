package com.mhk26.account.query.api.queries;

import com.mhk26.cqrs.core.queries.BaseQuery;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class FindAccountByHolderQuery extends BaseQuery {
    private String accountHolder;
}
