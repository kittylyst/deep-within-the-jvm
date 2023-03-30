package kathik.session5.fx.sealed;

import kathik.session5.fx.CurrencyPair;
import kathik.session5.fx.Side;

import java.time.LocalDateTime;

public record MarketOrder(int units,
                          CurrencyPair pair,
                          Side side,
                          LocalDateTime sentAt,
                          boolean allOrNothing) implements FXOrder {
    // constructors and factories omitted
}
