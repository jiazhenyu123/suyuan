package deploy;

import constant.Data;
import contract.AssetContract;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;
import java.util.List;

public class AssetContractBusiness {
    public static void main(String[] args) throws Exception {
        Web3j web3j = Web3j.build(new HttpService("HTTP://127.0.0.1:8545"));
//        web3j.
        String pk = Data.PK;
        Credentials credentials = Credentials.create(pk);
        StaticGasProvider provider = new StaticGasProvider(new BigInteger("20000000000"),new BigInteger("6721975"));
        System.out.println("——————————————————部署AssetContract智能合约——————————————————————");
        AssetContract contract;
//        contract = AssetContract.deploy(web3j,credentials,provider).send();
        contract = AssetContract.load("0x6dab84c308fd3a533e8bfa5d1cd0de83aa387ce0",web3j,credentials,provider);
        // 部署完成后打印合约地址
        System.out.println("AssetContractAddress:" + contract.getContractAddress());
        // 判断部署的合约是否可用
        System.out.println("isValid:" + contract.isValid());
        if(contract.isValid()){
//            //创建物资
//            AssetContract.Asset myAssert1 = new AssetContract.Asset("1",
//                                                                "桌子",
//                                                                    false,
//                                                                    "/User/PicUrl/desk",
//                                                                    "30元",
//                                                                    new BigInteger("4"),new BigInteger("0"));
//            AssetContract.Asset myAssert2 = new AssetContract.Asset("2",
//                    "椅子",
//                    false,
//                    "/User/PicUrl/chair",
//                    "10元",
//                    new BigInteger("4"),new BigInteger("0"));
//            contract.createAsset(myAssert1).send();
//            contract.createAsset(myAssert2).send();
            System.out.println("modify before picUrl:" + contract.Assets("1").send().component4());
//            //获取物资信息
            List<AssetContract.Asset> list = contract.getAssetListPlaceId("0x38a78c4315d1127a4a3a5865c932d4db91e40e14","1").send();
            for (int i = 0;i < list.size();i++){
                System.out.println(list.get(i).assetName);
            }
            //修改照片路径
//            TransactionReceipt receipt =  contract.modifyPictureUrl("1","/User/PicUrl/desk_modify").send();
//            System.out.println("modify after picUrl:" + contract.Assets("1").send().component4());
//            List<AssetContract.ModifierPicUrlEventEventResponse> list =  contract.getModifierPicUrlEventEvents(receipt);
//            System.out
        }
    }
}
