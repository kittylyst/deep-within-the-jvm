package kathik.session5.fx.records;

import kathik.session5.fx.CurrencyPair;
import kathik.session5.fx.Side;

import java.time.LocalDateTime;

public record FXO2(int units,
        CurrencyPair pair,
        Side side,
        double price,
        LocalDateTime sentAt,
        int ttl) {

    public FXOrder of() {
        return new FXOrder(units,
                pair,
                side,
        price,
        sentAt,
        ttl);
    }
}

