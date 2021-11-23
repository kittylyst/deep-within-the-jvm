package kathik.session5.fx.sealed;

import kathik.session5.fx.CurrencyPair;
import kathik.session5.fx.Side;

import java.time.LocalDateTime;

public record LimitOrder(int units,
                         CurrencyPair pair,
                         Side side,
                         LocalDateTime sentAt,
                         double price,
                         int ttl) implements FXOrder {
    // constructors and factories ommitted
}
