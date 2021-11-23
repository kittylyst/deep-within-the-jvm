package kathik.session5.fx.sealed;

import kathik.session5.fx.CurrencyPair;
import kathik.session5.fx.Side;

import java.time.LocalDateTime;

public sealed interface FXOrder permits MarketOrder, LimitOrder {
    int units();
    CurrencyPair pair();
    Side side();
    LocalDateTime sentAt();
}
