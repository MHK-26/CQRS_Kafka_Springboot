package com.mhk26.account.query.api.queries;

import com.mhk26.account.query.api.dto.EqualityType;
import com.mhk26.cqrs.core.queries.BaseQuery;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class FindAccountWithBalanceQuery extends BaseQuery {
    private EqualityType equalityType;
    private double balance;
}
