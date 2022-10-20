package deploy;

import constant.Data;
import contract.PlaceAssetContract;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.StaticGasProvider;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PlaceAssetContractBusiness {
    public static void main(String[] args) throws Exception {
        Web3j web3j = Web3j.build(new HttpService("HTTP://127.0.0.1:8545"));
//        web3j.
        String pk = Data.PK;
        Credentials credentials = Credentials.create(pk);
        StaticGasProvider provider = new StaticGasProvider(new BigInteger("20000000000"),new BigInteger("6721975"));
        System.out.println("——————————————————部署PlaceContract智能合约——————————————————————");
        PlaceAssetContract contract;
//        contract = PlaceAssetContract.deploy(web3j,credentials,provider).send();
        contract = PlaceAssetContract.load("0x38a78c4315d1127a4a3a5865c932d4db91e40e14",web3j,credentials,provider);
        // 部署完成后打印合约地址
        System.out.println("PlaceAssetContractAddress:" + contract.getContractAddress());
        // 判断部署的合约是否可用
        System.out.println("isValid:" + contract.isValid());
        if (contract.isValid()){
            //绑定自提点对应资产
            PlaceAssetContract.PlaceAsset placeAsset1 = new PlaceAssetContract.PlaceAsset("1","1","1",new BigInteger("4"), new BigInteger("0"));
            PlaceAssetContract.PlaceAsset placeAsset2 = new PlaceAssetContract.PlaceAsset("2","1","2",new BigInteger("16"), new BigInteger("0"));
            List<PlaceAssetContract.PlaceAsset> list = new ArrayList<>();
            list.add(placeAsset1);
            list.add(placeAsset2);
            contract.bindAsset(list).send();
            System.out.println("length:" + contract.length().send());
        }
    }
}
