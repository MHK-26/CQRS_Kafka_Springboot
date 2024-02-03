package com.mhk26.account.common.events;

import com.mhk26.cqrs.core.events.BaseEvent;
import lombok.Data;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
public class AccountClosedEvent extends BaseEvent {
}
