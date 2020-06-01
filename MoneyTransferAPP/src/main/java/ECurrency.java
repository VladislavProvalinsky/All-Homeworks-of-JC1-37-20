public enum ECurrency {
    BYN (933),
    USD (840),
    EUR (978),
    RUS (643);

    private int currencyCode;

    ECurrency (int currencyCode) {
        this.currencyCode = currencyCode;
    }

    public int getCurrencyCode () {
        return currencyCode;
    }
}
