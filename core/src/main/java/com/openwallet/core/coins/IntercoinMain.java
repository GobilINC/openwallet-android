package com.openwallet.core.coins;

import com.openwallet.core.coins.families.BitFamily;

/**
 * @author John L. Jegutanis
 */
public class IntercoinMain extends BitFamily {
    private IntercoinMain() {
        id = "intercoin.main";

        addressHeader = 76;
        p2shHeader = 63;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 100;
        dumpedPrivateKeyHeader = 128;

        name = "Intercoin";
        symbol = "ITC";
        uriScheme = "intercoin";
        bip44Index = 0;
        unitExponent = 8;
        feeValue = value(100000);
        minNonDust = value(1000); // 0.00001 ITC mininput
        softDustLimit = value(100000); // 0.001 ITC
        softDustPolicy = SoftDustPolicy.BASE_FEE_FOR_EACH_SOFT_DUST_TXO;
        signedMessageHeader = toBytes("Intercoin Signed Message:\n");
    }

    private static IntercoinMain instance = new IntercoinMain();
    public static synchronized CoinType get() {
        return instance;
    }
}
