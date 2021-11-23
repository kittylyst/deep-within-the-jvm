package kathik.session5.fx;

import kathik.session5.fx.sealed.FXOrder;

record OrderPartition(CurrencyPair pair, Side side) {
    public OrderPartition(FXOrder order) {
        this(order.pair(), order.side());
    }
}