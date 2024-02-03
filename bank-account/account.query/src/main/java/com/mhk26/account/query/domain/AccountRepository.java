package com.mhk26.account.query.domain;

import  org.springframework.data.repository.CrudRepository;
import com.mhk26.cqrs.core.domain.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends CrudRepository<BankAccount, String> {
    Optional<BankAccount> findByAccountHolder(String accountHolder);
    List<BaseEntity> findByBalanceGreaterThan(double balance);
    List<BaseEntity> findByBalanceLessThan(double balance);


}
