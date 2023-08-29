package constants;

public class Endpoints {
    public static class TokenApi{
        public static final String TOKEN_ID = "token";
        public static final String GET_TOKEN = "tokens/{" + TOKEN_ID +"}";
        public static final String GET_LIST_TOKEN = "tokens";
    }
    public static class StakeApi{
        public static final String GET_STAKE_ADDRESS = "stake/address/{address}";
        public static final String STAKE_KEY = "stakeKey";
        public static final String GET_STAKE = "stakes/{"+ STAKE_KEY +"}";

    }
}
