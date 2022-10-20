package deploy;

import constant.Data;
import contract.AssetContract;
import contract.AssetDetailContract;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.StaticGasProvider;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class AssetDetailContractBusiness {
    public static void main(String[] args) throws Exception {
        Web3j web3j = Web3j.build(new HttpService("HTTP://127.0.0.1:8545"));
//        web3j.
        String pk = Data.PK;
        Credentials credentials = Credentials.create(pk);
        StaticGasProvider provider = new StaticGasProvider(new BigInteger("20000000000"),new BigInteger("6721975"));
        System.out.println("——————————————————部署AssetContract智能合约——————————————————————");
        AssetDetailContract contract;
//        contract = AssetDetailContract.deploy(web3j,credentials,provider).send();
        contract = AssetDetailContract.load("0xebcd9555b8a9286709d2478d1734f7bbb3f06f61",web3j,credentials,provider);
        // 部署完成后打印合约地址
        System.out.println("AssetDetailContractAddress:" + contract.getContractAddress());
        // 判断部署的合约是否可用
        System.out.println("isValid:" + contract.isValid());
        if(contract.isValid()){
            //新增资产状态明细
            AssetDetailContract.AssetDetail assetDetail1 = new AssetDetailContract.AssetDetail("1","19052238","1",new BigInteger("1"),new BigInteger("0"));
            AssetDetailContract.AssetDetail assetDetail2 = new AssetDetailContract.AssetDetail("2","19052239","1",new BigInteger("1"),new BigInteger("0"));
            AssetDetailContract.AssetDetail assetDetail3 = new AssetDetailContract.AssetDetail("3","19052240","1",new BigInteger("1"),new BigInteger("0"));
            List<AssetDetailContract.AssetDetail> list = new ArrayList<>();
            list.add(assetDetail1);
            list.add(assetDetail2);
            list.add(assetDetail3);
            contract.insertAssetDetail(list).send();
            System.out.println(contract.assetDetails("1").send().component2());
        }
    }
}
