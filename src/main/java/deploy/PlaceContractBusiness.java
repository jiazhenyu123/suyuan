package deploy;

import constant.Data;
import contract.AssetContract;
import contract.PlaceContract;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;
import java.util.List;

public class PlaceContractBusiness {
    public static void main(String[] args) throws Exception {
        Web3j web3j = Web3j.build(new HttpService("HTTP://127.0.0.1:8545"));
//        web3j.
        String pk = Data.PK;
        Credentials credentials = Credentials.create(pk);
        StaticGasProvider provider = new StaticGasProvider(new BigInteger("20000000000"),new BigInteger("6721975"));
        System.out.println("——————————————————部署PlaceContract智能合约——————————————————————");
        PlaceContract contract;
//        contract = PlaceContract.deploy(web3j,credentials,provider).send();
        contract = PlaceContract.load("0x5c7bec79f6d5a2d3d0f8f198ddf3467fea3f8993",web3j,credentials,provider);
        // 部署完成后打印合约地址
        System.out.println("PlaceContractAddress:" + contract.getContractAddress());
        // 判断部署的合约是否可用
        System.out.println("isValid:" + contract.isValid());
        if(contract.isValid()){
//            //创建自提点
//            PlaceContract.Place place1 = new PlaceContract.Place("1","自提点1","7教415教室","19052238",new BigInteger("0"));
//            PlaceContract.Place place2 = new PlaceContract.Place("2","自提点2","7教410教室","19052239",new BigInteger("0"));
//            contract.createPlace(place1).send();
//            contract.createPlace(place2).send();
            //获取所有自提点列表
//            List<PlaceContract.Place> list = contract.getAllPlaceList().send();
//            for (int i = 0;i < list.size();i++){
//                System.out.println(list.get(i).placeName);
//            }
//            删除自提点
            TransactionReceipt receipt = contract.deletePlace("0xce3f1717d5ca693ca51a1c0c8ee148362de7e668","0x38a78c4315d1127a4a3a5865c932d4db91e40e14","admin","2").send();
            System.out.println("删除自提点消息：" + contract.getDeleteMsgEvents(receipt).get(0).data);
        }
    }
}
