package deploy;

import constant.Data;
import contract.AssetBorrowHistoryContract;
import contract.AssetContract;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

public class AssetBorrowHistoryContractBusiness {
    public static void main(String[] args) throws Exception {
        Web3j web3j = Web3j.build(new HttpService("HTTP://127.0.0.1:8545"));
        //        web3j.
        String pk = Data.PK;
        Credentials credentials = Credentials.create(pk);
        StaticGasProvider provider = new StaticGasProvider(new BigInteger("20000000000"),new BigInteger("6721975"));
        System.out.println("——————————————————部署AssetBorrowHistoryContract智能合约——————————————————————");
        AssetBorrowHistoryContract contract;
        contract = AssetBorrowHistoryContract.deploy(web3j,credentials,provider).send();
//    contract = AssetBorrowHistoryContract.load("0x6dab84c308fd3a533e8bfa5d1cd0de83aa387ce0",web3j,credentials,provider);
        // 部署完成后打印合约地址
        System.out.println("AssetBorrowHistoryContractAddress:" + contract.getContractAddress());
        // 判断部署的合约是否可用
        System.out.println("isValid:" + contract.isValid());
        if(contract.isValid()){
            //测试新增
            AssetBorrowHistoryContract.AssetBorrowHistory assetBorrowHistory = new AssetBorrowHistoryContract.AssetBorrowHistory("1","1","19052238","admin","20221025","20221026","借用原因",new BigInteger("1"),"审核原因","20221025",new BigInteger("1"));
            contract.insertAssertBorrowHistory(assetBorrowHistory).send();
            System.out.println("borrowAccount:" + contract.assetBHs("1").send().component3());

            //测试getAssetBHByAssetBorrowApplyId
            AssetBorrowHistoryContract.AssetBorrowHistory assetBorrowHistory1 =  contract.getAssetBHByAssetBorrowApplyId("1").send();
            System.out.println("getAssetBHByAssetBorrowApplyId:" + assetBorrowHistory1.borrowerAccount);

            //测试修改
            AssetBorrowHistoryContract.AssetBorrowHistory assetBorrowHistory2 = new AssetBorrowHistoryContract.AssetBorrowHistory("1","1","19052240","admin","20221025","20221026","借用原因",new BigInteger("1"),"审核原因","20221025",new BigInteger("1"));
            TransactionReceipt receipt = contract.update(assetBorrowHistory2).send();
            System.out.println("isUpdateSuccess:" + contract.getIsUpdateSuccessEvents(receipt).get(0).code);
        }
    }
}
