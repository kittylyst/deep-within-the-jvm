package kathik.session5.fx;

import kathik.session5.fx.sealed.FXOrder;

record OrderPartition(CurrencyPair pair, Side side) {

    public Side otherSide() {
        if (side == Side.BUY) {
            return Side.SELL;
        }
        return Side.BUY;
    }

    public OrderPartition(FXOrder order) {
        this(order.pair(), order.side());
    }
}